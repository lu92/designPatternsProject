package DesignPatternsProject.entities.actors;

import DesignPatternsProject.entities.personalData.Address;
import DesignPatternsProject.entities.personalData.Personality;
import DesignPatternsProject.entities.personalData.Role;


import javax.persistence.*;

/**
 * Created by lucjan on 10.03.15.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Person {

    @Id @GeneratedValue
    private Long person_id;
    private String username;
    private String password;
    private String email;

    @OneToOne(mappedBy = "person", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Personality personality;

    @OneToOne(mappedBy = "person", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Address address;

    @OneToOne(mappedBy = "person", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Role role;

    public Person() {
    }


    public Person(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Person(String username, String password, String email, Personality personality, Address address, Role role) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.personality = personality;
        this.address = address;
        this.role = role;
    }

    public Person(Long person_id, String username, String password, String email, Personality personality, Address address, Role role) {
        this(username, password, email, personality, address, role);
        this.person_id = person_id;
    }

    public enum PersonType {
        CLIENT, CONSULTANT, MANAGER, STUDENT, WORKER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (!email.equals(person.email)) return false;
        if (!personality.equals(person.personality)) return false;
        if (!role.equals(person.role)) return false;
        if (!username.equals(person.username)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = username.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + personality.hashCode();
        result = 31 * result + role.hashCode();
        return result;
    }

    public Long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Long person_id) {
        this.person_id = person_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Personality getPersonality() {
        return personality;
    }

    public void setPersonality(Personality personality) {
        this.personality = personality;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Person{" +
                "person_id=" + person_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", personality=" + personality +
                ", address=" + address +
                ", role=" + role +
                '}';
    }
}
