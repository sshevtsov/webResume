package ru.javaresume.webapp.model;

import java.util.*;

/**
 * Created by deadRabbit on 17.07.2016.
 */
public class OrganizationSection extends Section {
    private static final long serialVersionUID = 1L;

    public static final OrganizationSection EMPTY = new OrganizationSection(Collections.emptyList());

    public OrganizationSection() {
    }

    private List<Organization> organizations = new ArrayList<>();

    public OrganizationSection(Organization... organizations) {
        this(Arrays.asList(organizations));
    }

    public OrganizationSection(List<Organization> organizations) {
        this.organizations = organizations;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    @Override
    public String toString() {
        return organizations.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizationSection that = (OrganizationSection) o;
        return Objects.equals(organizations, that.organizations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(organizations);
    }
}