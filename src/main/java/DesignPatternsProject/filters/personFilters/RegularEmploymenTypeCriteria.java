package DesignPatternsProject.filters.personFilters;

import DesignPatternsProject.entities.actors.Person;
import DesignPatternsProject.entities.personalData.EmploymentContractType;
import DesignPatternsProject.filters.PersonCriteria;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 05.06.15.
 */
public class RegularEmploymenTypeCriteria extends PersonCriteria {

    public RegularEmploymenTypeCriteria() {
    }

    public RegularEmploymenTypeCriteria(PersonCriteria next) {
        super(next);
    }

    @Override
    public Set<Person> performFilter(Set<Person> allPersons) {
        Set<Person> personsFindedByRegularEmploymentType = new HashSet<>();
        for (Person person : allPersons)
            if (person.getSalary().getType() == EmploymentContractType.REGULAR_EMPLOYMENT)
                personsFindedByRegularEmploymentType.add(person);

        return personsFindedByRegularEmploymentType;
    }

    @Override
    public String toString() {
        return "RegularEmploymenTypeCriteria{} " + super.toString();
    }
}
