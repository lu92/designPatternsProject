package DesignPatternsProject.entities.actors;

import DesignPatternsProject.entities.orders.OrderDetails;

import java.util.List;

/**
 * Created by lucjan on 10.03.15.
 */

public class Client extends Person {
    List<OrderDetails> orders;

    public Client(String username, String password, String email) {
    }

    public Client() {

    }
}
