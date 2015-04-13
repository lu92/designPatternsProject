package DesignPatternsProject.strategies;

import DesignPatternsProject.entities.productsAndServices.BaseProduct;

/**
 * Created by lucjan on 01.04.15.
 */
public interface AbstractProductAndServiceTaxationStrategy {

    public void setProduct(BaseProduct product);
    public double calculateTax();
    public double calculateDuty();
    public double calculateNetto();
}
