package com.kodilla.patterns2.observer.homework.students;

import com.kodilla.patterns2.observer.homework.Observable;
import com.kodilla.patterns2.observer.homework.Observer;

import java.util.ArrayList;
import java.util.List;

public class Homework implements Observable {
    private final List <Observer> observers;
    private final List<Double> modules;
    private final String studentName;

    public Homework(String studentName) {
        modules = new ArrayList<>();
        observers = new ArrayList<>();
        this.studentName = studentName;
    }

    public void addModule(Double module){
        modules.add(module);
        notifyMentor();
    }

    @Override
    public void registerMentor(Observer observer){
        observers.add(observer);
    }

    @Override
    public void notifyMentor(){
        for (Observer observer : observers){
            observer.update(this);
        }
    }

    @Override
    public void removeMentor(Observer observer){
        observers.remove(observer);
    }

    public List<Double> getModules() {
        return modules;
    }

    public String getStudentName() {
        return studentName;
    }
}
