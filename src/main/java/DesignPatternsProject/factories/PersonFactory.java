package DesignPatternsProject.factories;

import DesignPatternsProject.entities.actors.Person;

/**
 * Created by lucjan on 10.03.15.
 */
public class PersonFactory implements AbstractPersonFactory {
    @Override
    public Person createPerson(Class type) {
        return null;
    }

    @Override
    public Person createPerson(String type) {
        return null;
    }


}
