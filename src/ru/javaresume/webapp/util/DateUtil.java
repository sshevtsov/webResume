package ru.javaresume.webapp.util;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/**
 * Created by deadRabbit on 09.08.2016.
 */
public class DateUtil {
    public static final LocalDate NOW = LocalDate.of(3000, 1, 1);
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MM/yyyy");

    private DateUtil() {
    }

    public static LocalDate of(int year, Month month) {
        return LocalDate.of(year, month, 1);
    }

    public static String format(LocalDate date) {
        return date.equals(NOW) ? "Сейчас" : date.format(DATE_FORMATTER);
    }
}
