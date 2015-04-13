package unitTests.BuilderTests;

import DesignPatternsProject.builders.ManagerBuilder;
import DesignPatternsProject.entities.actors.Manager;
import DesignPatternsProject.entities.personalData.Salary;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lucjan on 31.03.15.
 */
public class ManagerBuilderTest {

    private final String username = "James Bond";
    private final String password = "007";
    private final String email = "james.bond@gmail.com";

    @Test
    public void SalaryTest() {
        ManagerBuilder managerBuilder = new ManagerBuilder(username, password, email);
        managerBuilder.setSalary(new Salary(Salary.EmploymentContractType.REGULAR_EMPLOYMENT, 3000, 5000, 1000));
        Manager manager = (Manager) managerBuilder.getBuildResult();
        Assert.assertEquals(3000, manager.getSalary().getNetto(), 0.01);
        Assert.assertEquals(5000, manager.getSalary().getBrutto(), 0.01);
        Assert.assertEquals(1000, manager.getSalary().getInsurancePrice(), 0.01);
        Assert.assertEquals(Salary.EmploymentContractType.REGULAR_EMPLOYMENT, manager.getSalary().getType());
    }
}
