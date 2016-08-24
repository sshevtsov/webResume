package ru.javaresume.webapp.storage;

import ru.javaresume.webapp.ResumeNotFoundException;
import ru.javaresume.webapp.ResumeStorageException;
import ru.javaresume.webapp.model.ContactType;
import ru.javaresume.webapp.model.Resume;
import ru.javaresume.webapp.sql.SqlHelper;
import ru.javaresume.webapp.util.HtmlUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by deadRabbit on 24.08.2016.
 */
public class SqlStorage implements Storage {
    public final SqlHelper sqlHelper;

    public SqlStorage(String dbUrl, String dbUser, String dbPassword) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        sqlHelper = new SqlHelper(() -> DriverManager.getConnection(dbUrl, dbUser, dbPassword));
    }

    @Override
    public void clear() {
        sqlHelper.execute("DELETE FROM resume");
    }

    @Override
    public Resume get(String uuid) {
        return sqlHelper.execute(
                "SELECT * FROM resume r\n" +
                        "LEFT JOIN  contact c ON r.uuid = c.resume_uuid\n" +
                        "WHERE uuid=?",
                ps -> {

                    ps.setString(1, uuid);
                    ResultSet rs = ps.executeQuery();
                    if (!rs.next()) {
                        throw new ResumeStorageException(uuid, "Resume " + uuid + " is not exist");
                    }
                    Resume r = new Resume(uuid, rs.getString("full_name"), rs.getString("about"));
                    do {
                        addContact(rs, r);
                    } while (rs.next());
                    return r;
                });
    }

    @Override
    public void save(Resume r) {
        sqlHelper.transactionExecute(conn -> {
            try (PreparedStatement ps = conn.prepareStatement("INSERT INTO resume (uuid, full_name, about) VALUES(?,?,?)")) {
                ps.setString(1, r.getUuid());
                ps.setString(2, r.getFullName());
                ps.setString(3, r.getAbout());
                ps.execute();
            }
            insertContact(conn, r);
            return null;
        });
    }

    @Override
    public void update(Resume r) {
        sqlHelper.transactionExecute(conn -> {
            try (PreparedStatement st = conn.prepareStatement("UPDATE resume SET full_name = ?, about = ? WHERE uuid = ?")) {
                st.setString(1, r.getFullName());
                st.setString(2, r.getAbout());
                st.setString(3, r.getUuid());
                if (st.executeUpdate() == 0) {
                    throw new ResumeNotFoundException(r.getUuid());
                }
            }
            deleteContacts(conn, r);
            insertContact(conn, r);
            return null;
        });
    }

    @Override
    public void delete(String uuid) {
        sqlHelper.execute("DELETE FROM resume WHERE uuid=?", ps -> {
            ps.setString(1, uuid);
            if (ps.executeUpdate() == 0) {
                throw new ResumeNotFoundException(uuid);
            }
            return null;
        });
    }

    @Override
    public List<Resume> getAllSorted() {
        return sqlHelper.execute("" +
                        "SELECT * FROM resume r\n" +
                        "LEFT JOIN contact c ON r.uuid = c.resume_uuid\n" +
                        "ORDER BY full_name, uuid",
                ps -> {
                    ResultSet rs = ps.executeQuery();
                    Map<String, Resume> map = new LinkedHashMap<>();
                    while (rs.next()) {
                        String uuid = rs.getString("uuid");
//                        map.putIfAbsent()
                        Resume resume = map.get(uuid);
                        if (resume == null) {
                            resume = new Resume(rs.getString("uuid"), rs.getString("full_name"), rs.getString("about"));
                            map.put(uuid, resume);
                        }
                        addContact(rs, resume);
                    }
                    return new ArrayList<>(map.values());
                });
    }

    @Override
    public int size() {
        return sqlHelper.execute("SELECT count(*) FROM resume", st -> {
            ResultSet rs = st.executeQuery();
            return rs.next() ? rs.getInt(1) : 0;
        });
    }

    private void insertContact(Connection conn, Resume r) throws SQLException {
        try (PreparedStatement st = conn.prepareStatement("INSERT INTO contact (resume_uuid, type, value) VALUES (?,?,?)")) {
            for (Map.Entry<ContactType, String> e : r.getContacts().entrySet()) {
                st.setString(1, r.getUuid());
                st.setString(2, e.getKey().name());
                st.setString(3, e.getValue());
                st.addBatch();
            }
            st.executeBatch();
        }
    }

    private void addContact(ResultSet rs, Resume r) throws SQLException {
        String value = rs.getString("value");
        if (!HtmlUtil.isEmpty(value)) {
            ContactType type = ContactType.valueOf(rs.getString("type"));
            r.addContact(type, value);
        }
    }

    private void deleteContacts(Connection conn, Resume r) throws SQLException {
        try (PreparedStatement st = conn.prepareStatement("DELETE FROM contact WHERE resume_uuid = ?")) {
            st.setString(1, r.getUuid());
            st.execute();
        }
    }
}

