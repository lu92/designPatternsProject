package IntegratedPersistenceTests.PersonsTests;

import DesignPatternsProject.entities.personalData.Privilege;
import DesignPatternsProject.entities.personalData.Role;
import DesignPatternsProject.repositories.RoleRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import DesignPatternsProject.repositories.PrivelegeRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lucjan on 31.03.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DesignPatternsProject.DesignPatternsProjectApplication.class)
@WebAppConfiguration
@Transactional  //  IMPORTANT
public class RoleAndPrivelegeTest {

    @Autowired
    private PrivelegeRepository privelegeRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void saveSimplePrivelege() {
        Assert.assertNotNull(privelegeRepository);
        privelegeRepository.deleteAll();
        privelegeRepository.save(new Privilege("killing1"));
        privelegeRepository.save(new Privilege("killing2"));
        privelegeRepository.save(new Privilege("killing3"));
        privelegeRepository.save(new Privilege("killing4"));
        privelegeRepository.save(new Privilege("killing5"));
        Assert.assertSame(5, (int) privelegeRepository.count());
    }


    @Test
    public void test2() {
        Assert.assertNotNull(roleRepository);
        Assert.assertNotNull(privelegeRepository);

        roleRepository.deleteAll();
        Assert.assertEquals(0, roleRepository.count());

        privelegeRepository.deleteAll();
        Assert.assertEquals(0, privelegeRepository.count());

        Role agent = new Role("agent");
        agent.addPrivileges("killing", "mordering", "robering");
        roleRepository.save(agent);
        Assert.assertEquals(1, roleRepository.count());

        Assert.assertEquals(3, privelegeRepository.count());    //  WARN

        Assert.assertSame(1, (int) roleRepository.count());
        for (Role role : roleRepository.findAll()) {
            System.out.println(role);
        }

        for (Privilege privilege : privelegeRepository.findAll())
            System.out.println(privilege);

        Assert.assertEquals(3, roleRepository.findOne(1L).getPrivileges().size());

    }
}
