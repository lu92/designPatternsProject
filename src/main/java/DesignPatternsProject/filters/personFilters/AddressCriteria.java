package DesignPatternsProject.filters.personFilters;

import DesignPatternsProject.entities.actors.Person;
import DesignPatternsProject.entities.personalData.Address;
import DesignPatternsProject.filters.ObjectCriteria;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 04.06.15.
 */
public class AddressCriteria extends ObjectCriteria {
    private Address addressCriteria;

    public AddressCriteria(ObjectCriteria next, Address addressCriteria) {
        super(next);
        this.addressCriteria = addressCriteria;
    }

    public AddressCriteria(Address addressCriteria) {
        this.addressCriteria = addressCriteria;
    }

    public AddressCriteria(String country, String city, String zipCode) {
        this.addressCriteria = new Address(country, city, zipCode);
    }

    @Override
    public Set<Person> performFilter(Set<Person> allPersons) {
        Set<Person> personsFindedByAddress = new HashSet<>();
        for (Person person : allPersons)
            if (person.getAddress().equals(addressCriteria))
                personsFindedByAddress.add(person);

        return getNext().performFilter(personsFindedByAddress);
    }
}
