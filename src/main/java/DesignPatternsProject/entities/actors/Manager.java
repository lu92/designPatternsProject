package DesignPatternsProject.entities.actors;

import DesignPatternsProject.entities.personalData.Salary;

import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * Created by lucjan on 10.03.15.
 */
@Entity
public class Manager extends Person {
    @Transient
    Salary salary;

    public Manager(String username, String password, String email) {
        super(username, password, email);
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }
}
