package ru.javaresume.webapp.sql;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by deadRabbit on 24.08.2016.
 */
public interface SqlExecutor<T> {
    T execute(PreparedStatement st) throws SQLException;
}
