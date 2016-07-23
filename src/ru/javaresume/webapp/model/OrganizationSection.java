package ru.javaresume.webapp.model;

import java.util.List;

/**
 * Created by deadRabbit on 17.07.2016.
 */
public class OrganizationSection extends Section{

    private List<Organization> organizations;

    public OrganizationSection(List<Organization> organizations) {
        super("OrganizationSection");
        this.organizations = organizations;
    }
}
