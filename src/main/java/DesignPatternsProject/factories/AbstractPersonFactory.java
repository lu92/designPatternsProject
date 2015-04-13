package DesignPatternsProject.factories;

import DesignPatternsProject.entities.actors.Person;

/**
 * Created by lucjan on 30.03.15.
 */
public interface AbstractPersonFactory {
    public Person createPerson(Class type);
    public Person createPerson(String type);

}
