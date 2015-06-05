package unitTests.Filters;

import DesignPatternsProject.entities.actors.Person;
import DesignPatternsProject.filters.FilterManagerBuilder;
import DesignPatternsProject.filters.personFilters.AddressCriteria;
import DesignPatternsProject.filters.personFilters.NameAndLastNameCriteria;
import DesignPatternsProject.filters.personFilters.RoleCriteria;
import DesignPatternsProject.filters.personFilters.SalaryBruttoGreaterThanCriteria;
import DesignPatternsProject.resources.PersonResource;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 04.06.15.
 */
public class FilterManagerBuilderTest {

    private RoleCriteria roleCriteria = new RoleCriteria("Java Developer");

    @Test
    public void insertAndDeleteTest() {
        FilterManagerBuilder filterManagerBuilder = new FilterManagerBuilder(getPersonFromResources());
        Assert.assertNotNull(filterManagerBuilder);

        Assert.assertEquals(0, filterManagerBuilder.getCriterias().size());

        filterManagerBuilder.addCriteria(
                new AddressCriteria("Poland", "Warsaw", "20-290"),
                new NameAndLastNameCriteria("James", "Bond")
        );

        Assert.assertEquals(2, filterManagerBuilder.getCriterias().size());

        filterManagerBuilder.addCriteria(roleCriteria);

        Assert.assertEquals(3, filterManagerBuilder.getCriterias().size());

        filterManagerBuilder.addCriteria(new SalaryBruttoGreaterThanCriteria(1000));
        Assert.assertEquals(4, filterManagerBuilder.getCriterias().size());

        filterManagerBuilder.removeCriteria(new RoleCriteria("Java Developer"));
        Assert.assertEquals(3, filterManagerBuilder.getCriterias().size());

    }


    @Test
    public void NameAndLastnameCriteriaTest() {
        FilterManagerBuilder filterManagerBuilder = new FilterManagerBuilder(getPersonFromResources());
        Assert.assertNotNull(filterManagerBuilder);

        Assert.assertEquals(0, filterManagerBuilder.getCriterias().size());

        filterManagerBuilder.addCriteria(
                new NameAndLastNameCriteria("Adrian", "Krawiec")
        );


        Assert.assertEquals(1, filterManagerBuilder.getBuiltResult().doFilter().size());
    }

    private Set<Person> getPersonFromResources() {
        Set<Person> personSet = new HashSet<>();
        personSet.add(PersonResource.getDatabaseDeveloperAdrianCiecholewski());
        personSet.add(PersonResource.getDatabaseDeveloperAdrianKrawiec());
        personSet.add(PersonResource.getDatabaseDeveloperLukaszDebinski());
        personSet.add(PersonResource.getJavaDeveloperAdamWojcik());
        personSet.add(PersonResource.getJavaDeveloperKamilMilosz());
        personSet.add(PersonResource.getJavaDeveloperPiotrNawalka());
        personSet.add(PersonResource.getJavaDeveloperWojciechSeliga());
        personSet.add(PersonResource.getManagerJanKowalski());
        personSet.add(PersonResource.getUXDesignerMonikaStokrotka());
        personSet.add(PersonResource.getWebDeveloperDominikNocon());
        personSet.add(PersonResource.getWebDeveloperMateuszStepala());
        personSet.add(PersonResource.getWebDeveloperPrzemekRoman());
        return personSet;
    }

}
