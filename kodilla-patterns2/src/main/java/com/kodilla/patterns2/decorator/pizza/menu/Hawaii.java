package com.kodilla.patterns2.decorator.pizza.menu;

import com.kodilla.patterns2.decorator.pizza.AbstractPizzaDecorator;
import com.kodilla.patterns2.decorator.pizza.PizzaOrder;

import java.math.BigDecimal;

public class Hawaii extends AbstractPizzaDecorator {
    public Hawaii(PizzaOrder pizzaOrder){
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(7.0));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " type: Hawaii (ham, pineapple)";
    }
}
