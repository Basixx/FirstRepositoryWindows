package com.kodilla.patterns2.decorator.pizza.toppings;

import com.kodilla.patterns2.decorator.pizza.AbstractPizzaDecorator;
import com.kodilla.patterns2.decorator.pizza.PizzaOrder;

import java.math.BigDecimal;

public class Ham extends AbstractPizzaDecorator {
    public Ham(PizzaOrder pizzaOrder){
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost(){
        return super.getCost().add(new BigDecimal(3.0));
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + ham";
    }
}
