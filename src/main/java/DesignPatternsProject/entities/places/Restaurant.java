package DesignPatternsProject.entities.places;


import DesignPatternsProject.entities.orders.Mark;
import DesignPatternsProject.entities.personalData.Address;

import javax.persistence.Entity;
import java.util.List;

/**
 * Created by lucjan on 10.03.15.
 */

@Entity
public class Restaurant extends Venue {
    public Restaurant() {
    }

    public Restaurant(String name, Address address) {
        super(name, address);
    }

    public Restaurant(String name, double rate, List<Mark> marks, Address address) {
        super(name, rate, marks, address);
    }

    public Restaurant(Long id, String name, double rate, List<Mark> marks, Address address) {
        super(id, name, rate, marks, address);
    }
}
