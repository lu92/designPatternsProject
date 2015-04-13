package DesignPatternsProject.factories;

import DesignPatternsProject.entities.actors.Client;
import DesignPatternsProject.entities.orders.Mark;
import DesignPatternsProject.entities.personalData.Address;
import DesignPatternsProject.entities.places.Office;
import DesignPatternsProject.entities.places.Restaurant;

import java.util.List;

/**
 * Created by lucjan on 10.03.15.
 */
public class PlaceFactory implements AbstractPlaceFactory{
    @Override
    public Office createCompany(String name, Address address) {
        return null;
    }

    @Override
    public Office createCompany(String name, Address address, Client client) {
        return null;
    }

    @Override
    public Office createCompany(String name, String country, String city, String zipCode) {
        return null;
    }

    @Override
    public Office createCompany(String name, String country, String city, String zipCode, Client client) {
        return null;
    }

    @Override
    public Restaurant createRestaurant(String name, Address address) {
        return null;
    }

    @Override
    public Restaurant createRestaurant(String name, Address address, List<Mark> marks) {
        return null;
    }

    @Override
    public Restaurant createRestaurant(String name, String country, String city, String zipCode) {
        return null;
    }

    @Override
    public Restaurant createRestaurant(String name, String country, String city, String zipCode, Mark mark) {
        return null;
    }

    @Override
    public Restaurant createRestaurant(String name, String country, String city, String zipCode, List<Mark> marks) {
        return null;
    }
}
