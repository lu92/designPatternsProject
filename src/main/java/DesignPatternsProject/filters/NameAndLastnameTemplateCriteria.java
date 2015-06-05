package DesignPatternsProject.filters;

import DesignPatternsProject.entities.actors.Person;

import java.util.Set;

/**
 * Created by lucjan on 06.06.15.
 */
public class NameAndLastnameTemplateCriteria extends ObjectCriteria<Person> {
    @Override
    public Set<Person> performFilter(Set<Person> allObjects) {
        return null;
    }
}
