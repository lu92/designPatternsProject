package DesignPatternsProject.filters.personFilters;

import DesignPatternsProject.entities.actors.Person;
import DesignPatternsProject.filters.ObjectCriteria;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 04.06.15.
 */
public class SalaryBruttoGreaterThanCriteria extends ObjectCriteria {

    private int value;

    public SalaryBruttoGreaterThanCriteria(int value) {
        this.value = value;
    }

    public SalaryBruttoGreaterThanCriteria(ObjectCriteria next, int value) {
        super(next);
        this.value = value;
    }

    @Override
    public Set<Person> performFilter(Set<Person> allPersons) {
        Set<Person> personsWhoEarsMoreThan = new HashSet<>();
        for (Person person : allPersons)
            if (person.getSalary().getBrutto() > value)
                personsWhoEarsMoreThan.add(person);

        return personsWhoEarsMoreThan;
    }
}
