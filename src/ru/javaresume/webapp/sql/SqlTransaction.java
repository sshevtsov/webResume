package ru.javaresume.webapp.sql;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by deadRabbit on 24.08.2016.
 */
public interface SqlTransaction<T> {
    T execute(Connection conn) throws SQLException;
}
