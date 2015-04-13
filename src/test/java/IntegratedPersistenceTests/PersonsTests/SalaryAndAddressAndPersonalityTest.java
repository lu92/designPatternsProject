package IntegratedPersistenceTests.PersonsTests;

import DesignPatternsProject.entities.personalData.Address;
import DesignPatternsProject.entities.personalData.Personality;
import DesignPatternsProject.entities.personalData.Salary;
import DesignPatternsProject.repositories.AddressRepository;
import DesignPatternsProject.repositories.PersonalityRepository;
import DesignPatternsProject.repositories.SalaryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lucjan on 31.03.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DesignPatternsProject.DesignPatternsProjectApplication.class)
@WebAppConfiguration
@Transactional  //  IMPORTANT
public class SalaryAndAddressAndPersonalityTest {

    @Autowired
    private SalaryRepository salaryRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PersonalityRepository personalityRepository;

    @Test
    public void SalaryTest() {
        Assert.assertNotNull(salaryRepository);
        salaryRepository.save(new Salary(Salary.EmploymentContractType.REGULAR_EMPLOYMENT, 3000, 5000, 1000));
        Assert.assertEquals(1, salaryRepository.count());
        Assert.assertSame(Salary.EmploymentContractType.REGULAR_EMPLOYMENT, salaryRepository.findOne(1L).getType());

    }

    @Test
    public void AddressTest() {
        Assert.assertNotNull(addressRepository);
        addressRepository.save(new Address("England", "London", "12-990"));
        addressRepository.save(new Address("England", "London", "12-990"));
        addressRepository.save(new Address("England", "London", "12-990"));
        Assert.assertEquals(3, addressRepository.count());
    }

    @Test
    public void PersonalityTest() {
        Assert.assertNotNull(personalityRepository);
        personalityRepository.save(new Personality("James", "Bond", "12/10/1970", "123456789"));
        Assert.assertEquals(1, personalityRepository.count());
//        Assert.assertSame(String.valueOf(new Date("12/10/1970")), personalityRepository.findOne(1L).getStringBirth());
        Assert.assertSame("123456789", personalityRepository.findOne(1L).getTelephoneNumber());
    }
}
