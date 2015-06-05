package DesignPatternsProject.filters.personFilters;

import DesignPatternsProject.entities.actors.Person;
import DesignPatternsProject.entities.personalData.EmploymentContractType;
import DesignPatternsProject.filters.ObjectCriteria;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 05.06.15.
 */
public class FixedTermEmploymentTypeCriteria extends ObjectCriteria {

    public FixedTermEmploymentTypeCriteria() {
    }

    public FixedTermEmploymentTypeCriteria(ObjectCriteria next) {
        super(next);
    }

    @Override
    public Set<Person> performFilter(Set<Person> allPersons) {
        Set<Person> personsFindedByFixedTermEmploymentType = new HashSet<>();
        for (Person person : allPersons)
            if (person.getSalary().getType() == EmploymentContractType.FIXED_TERM_EMPLOYMENT)
                personsFindedByFixedTermEmploymentType.add(person);

        return getNext().performFilter(personsFindedByFixedTermEmploymentType);
    }
}
