package DesignPatternsProject.entities.orders;


import DesignPatternsProject.entities.actors.Client;
import DesignPatternsProject.entities.personalData.Address;
import DesignPatternsProject.entities.productsAndServices.BaseProduct;
import DesignPatternsProject.entities.productsAndServices.Category;
import DesignPatternsProject.entities.productsAndServices.Product;
import DesignPatternsProject.entities.productsAndServices.Service;
import DesignPatternsProject.strategies.TaxationStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucjan on 10.03.15.
 */
public class OrderDetails extends AbstractOrderDetails{

    public OrderDetails() {
    }

    public OrderDetails(String date, TaxationStrategy taxationStrategy, Client client) {
        super(date, taxationStrategy, client);
    }
}
