package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuElement {
    public static int EMPTY = -1;
    private static int MAX = 9;
    private int value;
    private List<Integer> valuesList = new ArrayList<>();

    public SudokuElement() {
        this.value = EMPTY;
        for (int i=1; i<=MAX; i++){
            valuesList.add(i);
        }
    }

    public boolean setValue(int value){
        if(!valuesList.contains(value)) return false;
        this.value = value;
        return true;
    }

}
