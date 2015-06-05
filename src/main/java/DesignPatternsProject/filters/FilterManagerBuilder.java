package DesignPatternsProject.filters;

import DesignPatternsProject.entities.actors.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by lucjan on 04.06.15.
 */
public class FilterManagerBuilder {
    private FilterManager filterManager;

    public FilterManagerBuilder() {
        filterManager = new FilterManager();
    }

    public FilterManagerBuilder(Set<Person> allPersons) {
        filterManager = new FilterManager(allPersons);
    }


    public List<ObjectCriteria> getCriterias() {
        List<ObjectCriteria> objectCriteriaList = new ArrayList<>();
        ObjectCriteria objectCriteria = filterManager.getBegin();
        while(objectCriteria != null) {
            objectCriteriaList.add(objectCriteria);
            objectCriteria = objectCriteria.getNext();
        }
        return objectCriteriaList;
    }

    public void addCriteria(ObjectCriteria ... objectCriterias) {
        if (filterManager.getBegin() == null && objectCriterias.length > 0) {
            ObjectCriteria objectCriteria = filterManager.getBegin();
            filterManager.setBegin(objectCriterias[0]);
            objectCriteria = filterManager.getBegin();
            for (int i= 1; i<objectCriterias.length; i++) {
                objectCriteria.setNext(objectCriterias[i]);
                objectCriteria = objectCriteria.getNext();
            }
        }
        else {

            ObjectCriteria objectCriteria = filterManager.getBegin();
            while (objectCriteria.getNext() != null)
                objectCriteria = objectCriteria.getNext();

            for (ObjectCriteria criteria : objectCriterias) {
                objectCriteria.setNext(criteria);
                objectCriteria = objectCriteria.getNext();
            }
        }
    }

    public void removeCriteria(ObjectCriteria criteriaToRemove) {
        ObjectCriteria criteria = filterManager.getBegin();
        ObjectCriteria prev = null;

        while (criteria != null && !criteria.equals(criteriaToRemove)) {
            prev = criteria;
            criteria = criteria.getNext();
        }

        if (criteria != null) {
            if (prev == null)
                criteria.setNext(criteria.getNext());
            else
                prev.setNext(criteria.getNext());
        }
    }

    public FilterManager getBuiltResult() {
        return filterManager;
    }

}
