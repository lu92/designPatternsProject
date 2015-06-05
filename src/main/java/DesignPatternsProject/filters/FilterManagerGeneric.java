package DesignPatternsProject.filters;

import DesignPatternsProject.entities.actors.Person;

import java.util.Set;

/**
 * Created by lucjan on 06.06.15.
 */
public class FilterManagerGeneric <T, V> {
//    T - type
//    V - value

    private V begin;
    private Set<V> allObjects;

    public FilterManagerGeneric() {
    }

    public FilterManagerGeneric(Set<V> allObjects) {
        this.allObjects = allObjects;
    }

//    public Set<V> doFilter() {
//        return begin.doCriteriaFilter(allObjects);
//    }

    public V getBegin() {
        return begin;
    }

    public void setBegin(V begin) {
        this.begin = begin;
    }
}
