package DesignPatternsProject.strategies;

import DesignPatternsProject.entities.productsAndServices.BaseProduct;

/**
 * Created by lucjan on 01.04.15.
 */
public class PolishTaxation08Strategy implements AbstractProductAndServiceTaxationStrategy {

    private BaseProduct baseProduct;
    private static final int TAX = 8;

    @Override
    public void setProduct(BaseProduct product) {
        this.baseProduct = product;
    }

    @Override
    public double calculateTax() {
        return baseProduct.getBrutto()/TAX;
    }

    @Override
    public double calculateDuty() {
        return 0;
    }

    @Override
    public double calculateNetto() {
        return baseProduct.getBrutto() - calculateTax();
    }
}
