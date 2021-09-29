package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;


public class OddNumbersExterminator {

    List <Integer> evenNumbers = new ArrayList<>();

    public List<Integer> createList (List<Integer> numbers){

          for (Integer number: numbers){
              if (number %2==0){
                  evenNumbers.add(number);
              }
          }
        return evenNumbers;
    }
}
