package ru.javaresume.webapp.model;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static ru.javaresume.webapp.util.DateUtil.NOW;
import static ru.javaresume.webapp.util.DateUtil.of;

/**
 * Created by deadRabbit on 17.07.2016.
 */
public class Organization {

    private Link homePage;
    private List<Position> positions;

    public Organization(String name, String url, Position... positions) {
        this(new Link(name, url), Arrays.asList(positions));
    }

    public Organization(Link homePage, List<Position> periods) {
        this.homePage = homePage;
        this.positions = periods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Organization that = (Organization) o;

        return Objects.equals(homePage, that.homePage) &&
                Objects.equals(positions, that.positions);

    }

    @Override
    public int hashCode() {
        return Objects.hash(homePage, positions);
    }

    @Override
    public String toString() {
        return "Organization(" + homePage + ", " + positions + ")";
    }

    /**
     * Created by deadRabbit on 17.07.2016.
     */
    public static class Position {

        private final LocalDate startDate;
        private final LocalDate endDate;
        private String title;
        private String description;

        public Position(int startYear, Month startMonth, String title, String description) {
            this(of(startYear, startMonth), NOW, title, description);
        }

        public Position(int startYear, Month startMonth, int endYear, Month endMonth, String title, String description) {
            this(of(startYear, startMonth), of(endYear, endMonth), title, description);
        }

        public Position(LocalDate startDate, LocalDate endDate, String title, String description) {
            this.startDate = startDate;
            this.endDate = endDate;
            this.title = title;
            this.description = description;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return Objects.equals(startDate, position.startDate) &&
                    Objects.equals(endDate, position.endDate) &&
                    Objects.equals(title, position.title) &&
                    Objects.equals(description, position.description);
        }

        @Override
        public int hashCode() {
            return Objects.hash(startDate, endDate, title, description);
        }

        @Override
        public String toString() {
            return "Position(" + startDate + ", " + endDate + ", '" + title + ", '" + description + ")";
        }
    }
}
