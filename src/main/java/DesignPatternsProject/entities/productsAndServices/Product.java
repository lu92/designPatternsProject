package DesignPatternsProject.entities.productsAndServices;

import javax.persistence.Entity;

/**
 * Created by lucjan on 10.03.15.
 */
@Entity
public class Product extends BaseProduct {
    public Product() {
    }

    public Product(String name, double netto) {
        super(name, netto);
    }

    public Product(String name, double netto, Category category) {
        super(name, netto, category);
    }

    public Product(Long id, String name, double netto) {
        super(id, name, netto);
    }

    public Product(Long id, String name, double netto, Category category) {
        super(id, name, netto, category);
    }
}
