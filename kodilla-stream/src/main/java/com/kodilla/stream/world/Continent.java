package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public final class Continent {
    private final String name;
    private List<Country> countryList = new ArrayList<>();

    public Continent(String name) {
        this.name = name;

    }

    public void addCountry (String name, BigDecimal peopleQuantity){
        Country country = new Country(name, peopleQuantity);
        countryList.add(country);
    }

    public List<Country> getCountryList() {

        return countryList;
    }
}
