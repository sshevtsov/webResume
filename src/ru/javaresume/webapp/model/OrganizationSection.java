package ru.javaresume.webapp.model;

import java.util.Arrays;
import java.util.List;

/**
 * Created by deadRabbit on 17.07.2016.
 */
public class OrganizationSection extends Section{

    private final List<Organization> organizations;

    public OrganizationSection(SectionType type, Organization ... organizations) {
        this(type, Arrays.asList(organizations));
    }
    public OrganizationSection(SectionType type,List<Organization> organizations) {
        super(type);
        this.organizations = organizations;
    }

    @Override
    public String toString() {
        return "(" + organizations.toString() + ")";
    }
}
