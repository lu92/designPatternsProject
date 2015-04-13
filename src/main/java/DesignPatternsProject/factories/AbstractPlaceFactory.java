package DesignPatternsProject.factories;

import DesignPatternsProject.entities.actors.Client;
import DesignPatternsProject.entities.orders.Mark;
import DesignPatternsProject.entities.personalData.Address;
import DesignPatternsProject.entities.places.Office;
import DesignPatternsProject.entities.places.Restaurant;

import java.util.List;

/**
 * Created by lucjan on 30.03.15.
 */
public interface AbstractPlaceFactory {

    public Office createCompany(String name, Address address);
    public Office createCompany(String name, Address address, Client client);
    public Office createCompany(String name, String country, String city, String zipCode);
    public Office createCompany(String name, String country, String city, String zipCode, Client client);

    public Restaurant createRestaurant(String name, Address address);
    public Restaurant createRestaurant(String name, Address address, List<Mark> marks);
    public Restaurant createRestaurant(String name, String country, String city, String zipCode);
    public Restaurant createRestaurant(String name, String country, String city, String zipCode, Mark mark);
    public Restaurant createRestaurant(String name, String country, String city, String zipCode, List<Mark> marks);
}
