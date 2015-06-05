package DesignPatternsProject.filters;

import DesignPatternsProject.entities.actors.Person;

import java.util.Set;

/**
 * Created by lucjan on 04.06.15.
 */
public abstract class ObjectCriteria {
    private ObjectCriteria next;
    public abstract Set<Person> performFilter(Set<Person> allPersons);

    public ObjectCriteria() {
    }

    public ObjectCriteria(ObjectCriteria next) {
        this.next = next;
    }

    public ObjectCriteria getNext() {
        return next;
    }

    public void setNext(ObjectCriteria next) {
        this.next = next;
    }
}
