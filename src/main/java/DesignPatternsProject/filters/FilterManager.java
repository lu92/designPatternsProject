package DesignPatternsProject.filters;

import DesignPatternsProject.entities.actors.Person;

import java.util.Set;

/**
 * Created by lucjan on 04.06.15.
 */
public class FilterManager {
    private ObjectCriteria begin;
    private Set<Person> allPersons;

    public FilterManager() {
    }

    public FilterManager(Set<Person> allPersons) {
        this.allPersons = allPersons;
    }

    public Set<Person> doFilter() {
        return begin.performFilter(allPersons);
    }

    public ObjectCriteria getBegin() {
        return begin;
    }

    public void setBegin(ObjectCriteria begin) {
        this.begin = begin;
    }

}
