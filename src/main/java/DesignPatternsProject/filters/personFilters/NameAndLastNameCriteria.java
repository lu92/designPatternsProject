package DesignPatternsProject.filters.personFilters;

import DesignPatternsProject.entities.actors.Person;
import DesignPatternsProject.filters.ObjectCriteria;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 04.06.15.
 */
public class NameAndLastNameCriteria extends ObjectCriteria {

    private String nameCriteria;
    private String lastnameCriteria;

    public NameAndLastNameCriteria(ObjectCriteria next, String nameCriteria, String lastnameCriteria) {
        super(next);
        this.nameCriteria = nameCriteria;
        this.lastnameCriteria = lastnameCriteria;
    }

    public NameAndLastNameCriteria(String nameCriteria, String lastnameCriteria) {
        this.nameCriteria = nameCriteria;
        this.lastnameCriteria = lastnameCriteria;
    }

    @Override
    public Set<Person> performFilter(Set<Person> allPersons) {
        Set<Person> personFindedByNameAndLastname = new HashSet<>();
        for (Person person : allPersons) {
            if (person.getPersonality().getName().equals(nameCriteria) &&
                    person.getPersonality().getLastname().equals(lastnameCriteria))
                personFindedByNameAndLastname.add(person);
        }
        return personFindedByNameAndLastname;
    }
}
