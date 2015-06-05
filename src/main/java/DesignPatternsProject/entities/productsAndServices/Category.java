package DesignPatternsProject.entities.productsAndServices;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucjan on 10.03.15.
 */

//@Entity
public class Category {

//    @Id @GeneratedValue
    private Long category_id;
    private String name;
    private List<BaseProduct> products = new ArrayList<>();


    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(String name, List<BaseProduct> products) {
        this.name = name;
        this.products = products;
    }

    public void addProducts(BaseProduct ... args) {
        for (BaseProduct product : args)
            products.add(product);
    }

    public void addProducts(List<BaseProduct> baseProductList) {
        for (BaseProduct product : baseProductList)
            products.add(product);
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BaseProduct> getProducts() {
        return products;
    }

    public void setProducts(List<BaseProduct> products) {
        this.products = products;
    }
}
