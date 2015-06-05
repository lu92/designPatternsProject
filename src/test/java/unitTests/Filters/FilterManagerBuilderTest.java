package unitTests.Filters;

import DesignPatternsProject.filters.FilterManagerBuilder;
import DesignPatternsProject.filters.personFilters.*;
import DesignPatternsProject.resources.PersonResource;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lucjan on 04.06.15.
 */
public class FilterManagerBuilderTest {

    private RoleCriteria roleCriteria = new RoleCriteria("Java Developer");

    @Test
    public void insertAndDeleteTest() {
        FilterManagerBuilder filterManagerBuilder = new FilterManagerBuilder(PersonResource.getAllPersonsFromResources());
        Assert.assertNotNull(filterManagerBuilder);

        Assert.assertEquals(0, filterManagerBuilder.getCriterias().size());

        filterManagerBuilder.addCriteria(
                new AddressCriteria("Poland", "Warsaw", "20-290"),
                new NameAndLastNameCriteria("James", "Bond")
        );

        Assert.assertEquals(2, filterManagerBuilder.getCriterias().size());

        filterManagerBuilder.addCriteria(roleCriteria);

        Assert.assertEquals(3, filterManagerBuilder.getNumberOfCriterias());

        filterManagerBuilder.addCriteria(new SalaryBruttoGreaterThanCriteria(1000));
        Assert.assertEquals(4, filterManagerBuilder.getNumberOfCriterias());

        filterManagerBuilder.removeCriteria(roleCriteria);
        Assert.assertEquals(3, filterManagerBuilder.getNumberOfCriterias());

//        for (ObjectCriteria criteria : filterManagerBuilder.getCriterias())
//            System.out.println(criteria);

    }


    @Test
    public void NameAndLastnameCriteriaTest() {
        FilterManagerBuilder filterManagerBuilder = new FilterManagerBuilder(PersonResource.getAllPersonsFromResources());
        Assert.assertNotNull(filterManagerBuilder);

        Assert.assertEquals(0, filterManagerBuilder.getCriterias().size());

        filterManagerBuilder.addCriteria(
                new SalaryBruttoGreaterThanCriteria(6000),
                new SalaryBruttoLessThanCriteria(7100),
                new NameAndLastNameCriteria("Wojciech", "Seliga"),
                new RoleCriteria("Java Developer Role"),
                new RegularEmploymenTypeCriteria()
        );


        Assert.assertEquals(5, filterManagerBuilder.getNumberOfCriterias());

//        for (Person person : filterManagerBuilder.getBuiltResult().doFilter())
//            System.out.println(person);

        Assert.assertEquals(1, filterManagerBuilder.getBuiltResult().doFilter().size());

    }

}
