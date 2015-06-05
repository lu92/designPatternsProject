package DesignPatternsProject.strategies;

import DesignPatternsProject.entities.orders.AbstractOrderDetails;
import DesignPatternsProject.entities.productsAndServices.Category;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lucjan on 01.05.15.
 */
public class UsaTaxation implements TaxationStrategy{

    private Country country;
    private AbstractOrderDetails orderDetails;
    private Map<Category, Double> UsaTaxation = new HashMap<>();


    @Override
    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public void setOrderDetails(AbstractOrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public double calculateTax() {
        return 0;
    }

    @Override
    public double calculateDuty() {
        return 0;
    }

    @Override
    public int getTax() {
        return 0;
    }



}
