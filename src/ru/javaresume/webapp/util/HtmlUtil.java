package ru.javaresume.webapp.util;

import ru.javaresume.webapp.model.*;

/**
 * Created by deadRabbit on 24.08.2016.
 */
public class HtmlUtil {
    public static String formatDates(Organization.Position position) {
        return DateUtil.format(position.getStartDate()) + " - " + DateUtil.format(position.getEndDate());
    }

    public static boolean isEmpty(String value) {
        return value == null || value.isEmpty();
    }

    public static String getContact(Resume r, ContactType type) {
        String contact = r.getContacts().get(type);
        return contact == null ? "" : contact;
    }

    public static Section getSection(Resume r, SectionType type) {
        Section section = r.getSections().get(type);
        if (section != null) {
            return section;
        }
        switch (type) {
            case OBJECTIVE:
                return TextSection.EMPTY;
            case ACHIEVEMENT:
            case QUALIFICATIONS:
                return ListSection.EMPTY;
            case EXPERIENCE:
            case EDUCATION:
                return OrganizationSection.EMPTY;
            default:
                throw new IllegalStateException("Illegal type " + type);
        }
    }

}
