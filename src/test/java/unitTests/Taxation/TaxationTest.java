package unitTests.Taxation;

import DesignPatternsProject.entities.orders.OrderDetails;
import DesignPatternsProject.entities.productsAndServices.Product;
import DesignPatternsProject.entities.productsAndServices.Service;
import DesignPatternsProject.resources.ClientResource;
import DesignPatternsProject.strategies.Country;
import DesignPatternsProject.strategies.Currency;
import DesignPatternsProject.strategies.PolishTaxation08;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * Created by lucjan on 05.06.15.
 */
public class TaxationTest {

    @Test
    public void createOrder() {
        OrderDetails orderDetails = new OrderDetails(
                "12/05/2015", new PolishTaxation08(new Country("Poland", Currency.PLN, 1.0, 0)),
                ClientResource.getAnnaNowak());

        Assert.assertNotNull(orderDetails);

        orderDetails.addAnyBaseProduct(
                new Product("CRM", 100*1000),
                new Service("wdrazenie CRM", 20*1000)
        );

        Assert.assertEquals(2, orderDetails.getContentSize());
        Assert.assertNotNull(orderDetails.getClient());

        Assert.assertEquals(new Date("12/05/2015"), orderDetails.getDate());

        Assert.assertEquals("laczna cena netto",120 * 1000, orderDetails.getTotalNettoPrice(), 0.01);
        Assert.assertEquals("cena podatku VAT", 8 * orderDetails.getTotalNettoPrice() / 100, orderDetails.getTax(), 0.01);
        Assert.assertEquals("laczna cena brutto", 108 * 120 * 1000 / 100 , orderDetails.getTotalBruttoPrice(), 0.01);

        Assert.assertEquals(ClientResource.getAnnaNowak().getAddress(), orderDetails.getAddress());
        Assert.assertEquals(0.9 * 108 * 120 * 1000 / 100 , orderDetails.calculateDiscount(10), 0.01);
        Assert.assertEquals(108 * 120 * 1000 / 100 - 10*1000 , orderDetails.calculateDiscount(10.0*1000), 0.01);



    }
}
