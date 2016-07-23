package ru.javaresume.webapp.model;

import java.util.List;

/**
 * Created by deadRabbit on 17.07.2016.
 */
public class OrganizationSection extends Section{

    private List<Organization> organizations;

    public OrganizationSection(SectionType type,List<Organization> organizations) {
        super(type);
        this.organizations = organizations;
    }
}
