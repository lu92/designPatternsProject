package DesignPatternsProject.strategies;


import DesignPatternsProject.entities.orders.AbstractOrderDetails;

/**
 * Created by lucjan on 01.04.15.
 */
public class PolishTaxation08 implements TaxationStrategy {

    private static final int TAX = 8;
    private Country country;
    private AbstractOrderDetails orderDetails;

    public PolishTaxation08(Country country) {
        this.country = country;
    }

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
        return TAX * orderDetails.getTotalNettoPrice() / 100;
    }

    @Override
    public double calculateDuty() {
        return country.getDutyPercent() *orderDetails.getTotalNettoPrice() / 100;
    }

    @Override
    public int getTax() {
        return TAX;
    }
}
