package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    List<String> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void add(String text) {
        tasks.add(tasks.size(), text);
    }

    public String getElement(int i) {
        return tasks.get(i);
    }

    public int getSize() {
        return tasks.size();
    }
}
