package com.kodilla.stream.world;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
public class WorldTestSuite {

    @Test
    void testWorldPopulationCount(){
        //Given
        World earth = new World();
        Continent europe = new Continent("Europe");
        Continent asia = new Continent("Asia");
        Continent africa = new Continent("Africa");

        Country poland = new Country("Poland", new BigDecimal("12345678901234567890"));
        Country spain = new Country("Spain", new BigDecimal("1827361230192"));
        Country germany = new Country("Germany", new BigDecimal("2347293487"));

        Country china = new Country("China", new BigDecimal("837462341233253"));
        Country japan = new Country("Japan", new BigDecimal("429384572453405"));
        Country india = new Country("India", new BigDecimal("293e8572348756"));

        Country kenya = new Country("Kenya", new BigDecimal("2387462837"));
        Country ethiopia = new Country("Ethiopia", new BigDecimal("387456387"));
        Country uganda = new Country("Uganda", new BigDecimal("3985734834235"));

        BigDecimal allPeople = BigDecimal.ZERO.add(poland.getPeopleQuantity())
                .add(spain.getPeopleQuantity())
                .add(germany.getPeopleQuantity())
                .add(china.getPeopleQuantity())
                .add(japan.getPeopleQuantity())
                .add(india.getPeopleQuantity())
                .add(kenya.getPeopleQuantity())
                .add(ethiopia.getPeopleQuantity())
                .add(uganda.getPeopleQuantity());

        earth.getContinentList().add(europe);
        earth.getContinentList().add(asia);
        earth.getContinentList().add(africa);


        europe.getCountryList().add(poland);
        europe.getCountryList().add(spain);
        europe.getCountryList().add(germany);

        asia.getCountryList().add(china);
        asia.getCountryList().add(japan);
        asia.getCountryList().add(india);

        africa.getCountryList().add(kenya);
        africa.getCountryList().add(ethiopia);
        africa.getCountryList().add(uganda);

        //when
        BigDecimal totalPeople = earth.getPeopleQuantity();

        //then
        Assertions.assertEquals(totalPeople, allPeople);
    }

}
