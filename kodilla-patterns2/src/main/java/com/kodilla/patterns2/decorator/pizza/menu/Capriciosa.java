package com.kodilla.patterns2.decorator.pizza.menu;

import com.kodilla.patterns2.decorator.pizza.AbstractPizzaDecorator;
import com.kodilla.patterns2.decorator.pizza.PizzaOrder;

import java.math.BigDecimal;

public class Capriciosa extends AbstractPizzaDecorator {
    public Capriciosa(PizzaOrder pizzaOrder){
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost() {
        return super.getCost().add(new BigDecimal(5.5));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " type: Capriciosa (ham, mushrooms)";
    }
}
