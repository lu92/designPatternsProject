package DesignPatternsProject.filters.personFilters;

import DesignPatternsProject.entities.actors.Person;
import DesignPatternsProject.filters.ObjectCriteria;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 05.06.15.
 */
public class SalaryNettoLessThanCriteria extends ObjectCriteria{

    private int value;

    public SalaryNettoLessThanCriteria(int value) {
        this.value = value;
    }

    public SalaryNettoLessThanCriteria(ObjectCriteria next, int value) {
        super(next);
        this.value = value;
    }

    @Override
    public Set<Person> performFilter(Set<Person> allPersons) {
        Set<Person> personsWhoEarsLessThan = new HashSet<>();
        for (Person person : allPersons)
            if (person.getSalary().getNetto() < value)
                personsWhoEarsLessThan.add(person);

        return personsWhoEarsLessThan;
    }

}
