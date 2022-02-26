package com.kodilla.patterns2.observer.homework.mentors;

import com.kodilla.patterns2.observer.homework.Observer;
import com.kodilla.patterns2.observer.homework.students.Homework;

public class Mentor implements Observer {
    private final String name;
    private int updateCount;

    public Mentor(String name) {
        this.name = name;
    }

    @Override
    public void update (Homework homework){
        System.out.println(name + ": New homework to grade from: " + homework.getStudentName() + "\n" +
                " (total: " + homework.getModules().size() + " modules)." );
        updateCount++;
    }

    public String getName() {
        return name;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}
