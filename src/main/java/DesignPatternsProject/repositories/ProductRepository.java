package DesignPatternsProject.repositories;

import DesignPatternsProject.entities.personalData.Address;
import DesignPatternsProject.entities.productsAndServices.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lucjan on 29.04.15.
 */
@Transactional
public interface ProductRepository extends CrudRepository<Product, Long> {
}
