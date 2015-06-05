package DesignPatternsProject.filters.personFilters;

import DesignPatternsProject.entities.actors.Person;
import DesignPatternsProject.entities.personalData.Role;
import DesignPatternsProject.filters.ObjectCriteria;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 04.06.15.
 */
public class RoleCriteria extends ObjectCriteria {
    private String roleCriteria;

    public RoleCriteria(String roleCriteria) {
        this.roleCriteria = roleCriteria;
    }

    public RoleCriteria(ObjectCriteria next, String roleCriteria) {
        super(next);
        this.roleCriteria = roleCriteria;
    }

    @Override
    public Set<Person> performFilter(Set<Person> allPersons) {
        Set<Person> personsFindedByRole = new HashSet<>();
        for (Person person : allPersons)
            for (Role role : person.getRoles())
                if (role.getRoleName().equals(roleCriteria)) {
                    personsFindedByRole.add(person);
                    break;
                }
        return personsFindedByRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoleCriteria that = (RoleCriteria) o;

        if (!roleCriteria.equals(that.roleCriteria)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return roleCriteria.hashCode();
    }
}
