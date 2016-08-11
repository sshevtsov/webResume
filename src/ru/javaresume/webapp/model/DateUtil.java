package ru.javaresume.webapp.model;

import java.time.LocalDate;
import java.time.Month;

/**
 * Created by deadRabbit on 09.08.2016.
 */
public class DateUtil {

    public static final LocalDate NOW = LocalDate.of(3000, 1, 1);

    private DateUtil(){
    }

    public static LocalDate of(int year, Month month) {
        return LocalDate.of(year, month, 1);
    }

}
