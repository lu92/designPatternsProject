package DesignPatternsProject.filters;

import DesignPatternsProject.entities.actors.Person;

import java.util.Set;

/**
 * Created by lucjan on 06.06.15.
 */
public abstract class ObjectCriteria<T> {
    private ObjectCriteria next;
    public abstract Set<T> performFilter(Set<T> allObjects);

    public ObjectCriteria() {
    }

    public ObjectCriteria(ObjectCriteria next) {
        this.next = next;
    }

    public Set<T> doCriteriaFilter(Set<T> allObjects) {
        if (getNext() == null)
            return performFilter(allObjects);
        else
            return getNext().doCriteriaFilter(performFilter(allObjects));
    }

    public ObjectCriteria getNext() {
        return next;
    }

    public void setNext(ObjectCriteria next) {
        this.next = next;
    }
}
