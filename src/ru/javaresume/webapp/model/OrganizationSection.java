package ru.javaresume.webapp.model;

import java.util.Arrays;
import java.util.List;

/**
 * Created by deadRabbit on 17.07.2016.
 */
public class OrganizationSection extends Section{

    private final List<Organization> organizations;

    public OrganizationSection(Organization ... organizations) {
        this( Arrays.asList(organizations));
    }
    public OrganizationSection(List<Organization> organizations) {
        this.organizations = organizations;
    }

    @Override
    public String toString() {
        return "(" + organizations.toString() + ")";
    }
}
