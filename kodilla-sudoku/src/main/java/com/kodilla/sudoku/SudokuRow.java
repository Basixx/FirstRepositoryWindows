package com.kodilla.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuRow {
    private static int MAX = 9;
    private List <SudokuElement> rowList = new ArrayList<>();

    public SudokuRow(){
        for (int i =1; i<= MAX; i++){
            rowList.add(i, new SudokuElement());
        }
    }

    public List<SudokuElement> getRowList(){
        return rowList;
    }
}
