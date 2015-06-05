package DesignPatternsProject.entities.actors;

import javax.persistence.Entity;

/**
 * Created by lucjan on 10.03.15.
 */
@Entity
public class Manager extends Person {

    public Manager() {
    }

    public Manager(String username, String password, String email) {
        super(username, password, email);
    }

}
