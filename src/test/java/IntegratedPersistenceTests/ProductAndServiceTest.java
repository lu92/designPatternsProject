package IntegratedPersistenceTests;

import DesignPatternsProject.entities.productsAndServices.Product;
import DesignPatternsProject.repositories.ProductRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lucjan on 29.04.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DesignPatternsProject.DesignPatternsProjectApplication.class)
@WebAppConfiguration
@Transactional  //  IMPORTANT
@TransactionConfiguration(defaultRollback = true)
public class ProductAndServiceTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void simpleTest() {
        Product product = new Product("pasztet", 5);
        productRepository.save(product);
        Assert.assertEquals(1, productRepository.count());
    }


}
