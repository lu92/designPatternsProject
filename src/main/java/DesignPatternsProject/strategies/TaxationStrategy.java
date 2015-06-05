package DesignPatternsProject.strategies;


import DesignPatternsProject.entities.orders.AbstractOrderDetails;

/**
 * Created by lucjan on 01.04.15.
 */
public interface TaxationStrategy {
    public void setCountry(Country country);
    public void setOrderDetails(AbstractOrderDetails orderDetails);
    public double calculateTax();
    public double calculateDuty();
    public int getTax();
}
