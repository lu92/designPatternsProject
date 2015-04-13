package unitTests.BuilderTests;

import DesignPatternsProject.builders.AbstractPersonBuilder;
import DesignPatternsProject.builders.PersonBuilder;
import DesignPatternsProject.entities.actors.*;
import DesignPatternsProject.entities.personalData.Address;
import DesignPatternsProject.entities.personalData.Personality;
import DesignPatternsProject.entities.personalData.Role;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by lucjan on 31.03.15.
 */
public class PersonBuilderTest {

    private final String username = "James Bond";
    private final String password = "007";
    private final String email = "james.bond@gmail.com";

    private Personality personality = new Personality("James", "Bond", "12/04/1970", "007007007");
    private Address address = new Address("England", "London", "12-990");
    private Role role = new Role("agent");


    @Test
    public void correctConstructorsTest() {
        AbstractPersonBuilder personBuilder1 = new PersonBuilder(username, password, email, Manager.class);
        AbstractPersonBuilder personBuilder2 = new PersonBuilder(username, password, email, "MANAGER");
        AbstractPersonBuilder personBuilder3 = new PersonBuilder(username, password, email, "client");
        AbstractPersonBuilder personBuilder4 = new PersonBuilder(username, password, email, "StuDent");

        Assert.assertNotNull(personBuilder1);
        Assert.assertNotNull(personBuilder2);
        Assert.assertNotNull(personBuilder3);
        Assert.assertNotNull(personBuilder4);
    }


    @Test(expected = IllegalArgumentException.class)
    public void incorrectConstructorTest1() {
        AbstractPersonBuilder personBuilder5 = personBuilder5 = new PersonBuilder(username, password, email, "FJHDFjhvsdfJHV8098");
        Assert.assertNotNull(personBuilder5);
    }

    @Test
    public void incorrectConstructorTest2() {
        AbstractPersonBuilder personBuilder6 = null;
        try {
            personBuilder6 = new PersonBuilder(username, password, email, "FJHDFjhvsdfJHV8098");
        } catch (IllegalArgumentException e) {
        }
        Assert.assertNull(personBuilder6);
    }

    @Test
    public void createNewClient() {
        AbstractPersonBuilder builder = new PersonBuilder(username, password, email, Client.class);
        Client client = (Client) builder.getBuildResult();
        Assert.assertNotNull(client);
    }

    @Test
    public void createNewConsultant() {
        AbstractPersonBuilder builder = new PersonBuilder(username, password, email, Consultant.class);
        Consultant consultant = (Consultant) builder.getBuildResult();
        Assert.assertNotNull(consultant);
    }

    @Test
    public void createNewManager() {
        AbstractPersonBuilder builder = new PersonBuilder(username, password, email, Manager.class);
        Manager manager = (Manager) builder.getBuildResult();
        Assert.assertNotNull(manager);
    }

    @Test
    public void createNewStudent() {
        AbstractPersonBuilder builder = new PersonBuilder(username, password, email, Student.class);
        Student student = (Student) builder.getBuildResult();
        Assert.assertNotNull(student);
    }

    @Test
    public void createNewWorker() {
        AbstractPersonBuilder builder = new PersonBuilder(username, password, email, Worker.class);
        Worker worker = (Worker) builder.getBuildResult();
        Assert.assertNotNull(worker);
    }

    @Test
    public void creatingPersonWithSettersTest() {
        AbstractPersonBuilder builder = new PersonBuilder(username, password, email, Student.class);
        builder.setPersonality(personality);
        builder.setAddress(address);
        builder.setRole(role);
        Student student = (Student) builder.getBuildResult();
        Assert.assertNotNull(student);
        Assert.assertSame(personality, student.getPersonality());
        Assert.assertSame(address, student.getAddress());
        Assert.assertSame(role, student.getRole());
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongBirthDate() {
        AbstractPersonBuilder builder = new PersonBuilder(username, password, email, Client.class);
        builder.setPersonality("James", "Bond", "50|50|-999", "123456789");
        Client client = (Client) builder.getBuildResult();
    }
}
