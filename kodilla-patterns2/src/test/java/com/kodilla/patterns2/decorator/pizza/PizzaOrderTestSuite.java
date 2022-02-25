package com.kodilla.patterns2.decorator.pizza;

import com.kodilla.patterns2.decorator.pizza.menu.Hawaii;
import com.kodilla.patterns2.decorator.pizza.menu.Vesuvio;
import com.kodilla.patterns2.decorator.pizza.toppings.Olives;
import com.kodilla.patterns2.decorator.pizza.toppings.Tomato;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;

public class PizzaOrderTestSuite {
    @Test
    public void testBasicPizzaOrderGetCost(){
        //Given
        PizzaOrder thePizza = new BasicPizza();
        //When
        BigDecimal calculatedCost = thePizza.getCost();
        //When
        assertEquals(new BigDecimal(15.0), calculatedCost);
    }

    @Test
    public void testBasicPizzaOrderGetDescription(){
        //Given
        PizzaOrder thePizza = new BasicPizza();
        //When
        String description = thePizza.getDescription();
        //Then
        assertEquals("Pizza with tomato sauce + mozzarella", description);
    }

    @Test
    public void testVesuvioOrderGetCost(){
        //Given
        PizzaOrder thePizza = new BasicPizza();
        thePizza = new Vesuvio(thePizza);
        //When
        BigDecimal theCost = thePizza.getCost();
        //Then
        assertEquals(new BigDecimal(18.0), theCost);
    }

    @Test
    public void testVesuvioOrderGetDescription(){
        //Given
        PizzaOrder thePizza = new BasicPizza();
        thePizza = new Vesuvio(thePizza);
        //When
        String description = thePizza.getDescription();
        //Then
        assertEquals("Pizza with tomato sauce + mozzarella type: Vesuvio (ham)", description);
    }

    @Test
    public void testHawaiiWithTomatoesAndOlivesGetCost(){
        //Given
        PizzaOrder thePizza = new BasicPizza();
        thePizza = new Hawaii(thePizza);
        thePizza = new Tomato(thePizza);
        thePizza = new Olives(thePizza);
        //When
        BigDecimal theCost = thePizza.getCost();
        //Then
        assertEquals(new BigDecimal("28.0"), theCost);
    }

    @Test
    public void testHawaiiWithTomatoesAndOlivesGetDescription(){
        //Given
        PizzaOrder thePizza = new BasicPizza();
        thePizza = new Hawaii(thePizza);
        thePizza = new Tomato(thePizza);
        thePizza = new Olives(thePizza);
        //When
        String description = thePizza.getDescription();
        //Then
        assertEquals("Pizza with tomato sauce + mozzarella type: Hawaii (ham, pineapple) + tomato + olives", description);
    }
}
