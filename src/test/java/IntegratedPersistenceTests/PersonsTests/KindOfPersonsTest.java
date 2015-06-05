package IntegratedPersistenceTests.PersonsTests;

import DesignPatternsProject.builders.AbstractPersonBuilder;
import DesignPatternsProject.builders.PersonBuilder;
import DesignPatternsProject.entities.actors.Manager;
import DesignPatternsProject.entities.personalData.Address;
import DesignPatternsProject.entities.personalData.Personality;
import DesignPatternsProject.entities.personalData.Role;
import DesignPatternsProject.repositories.ManagerRepository;
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
public class KindOfPersonsTest {

    private String username = "Harry1970";
    private String password = "secret";
    private String email = "harry@gmail.com";


    @Autowired
    private ManagerRepository managerRepository;

    @Test
    public void createAndSaveManagerWithUsingPersonBuilder() {

        Assert.assertNotNull(managerRepository);

        AbstractPersonBuilder personBuilder = new PersonBuilder(username, password, email, Manager.class);
        Assert.assertNotNull(personBuilder);

        personBuilder.setAddress(new Address("England", "London", "90-90"));
        personBuilder.setPersonality("Harry", "Osborn", "12/04/1990", "123456789");
        Manager manager = (Manager) personBuilder.getBuildResult();
        Assert.assertEquals(new Address("England", "London", "90-90"), manager.getAddress());

        Role scientist = new Role("scientist");
        scientist.addPrivileges("calculating", "teaching", "learning");

        manager.addRoles(scientist);

        managerRepository.save(manager);
        Assert.assertEquals(new Personality("Harry", "Osborn", "12/04/1990", "123456789"), managerRepository.findOne(1L).getPersonality());
        Assert.assertEquals(1, managerRepository.count());
        Assert.assertEquals(3, managerRepository.findOne(1L).getRoles().size());
        System.out.println(managerRepository.findOne(1L));
    }



}
