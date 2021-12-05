package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BigmacTestSuite {

    @Test
    void testBigmacNew(){
        //given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .bun("seasam")
                .sauce("hot")
                .burgers(2)
                .ingredient("tomato")
                .ingredient("bacon")
                .ingredient("onion")
                .ingredient("pickles")
                .build();
        System.out.println(bigmac);

        //when
        int howManyIngredients = bigmac.getIngredients().size();
        String whichSauce = bigmac.getSauce();
        int howManyBurgers = bigmac.getBurgers();

        //then
        assertEquals(4, howManyIngredients);
        assertEquals("hot", whichSauce);
        assertEquals(2, howManyBurgers);
    }

}
