package DesignPatternsProject.builders;

import DesignPatternsProject.entities.actors.Person;
import DesignPatternsProject.entities.personalData.Address;
import DesignPatternsProject.entities.personalData.Personality;
import DesignPatternsProject.entities.personalData.Role;

import java.util.Date;

/**
 * Created by lucjan on 30.03.15.
 */
public interface AbstractPersonBuilder {

    public void setPersonality( String name, String lastname, Date birth, String telephoneNumber);
    public void setPersonality( String name, String lastname, String birth, String telephoneNumber);
    public void setPersonality(Personality personality);

    public void setRole(String roleName) throws IllegalArgumentException;
    public void setRole(Role role);

    public void setAddress(String country, String city, String zipCode);
    public void setAddress(Address address);

    public Class getClassPersonType();
    public String getPersonType();

    public Person getBuildResult();
    public void printPerson();

}
