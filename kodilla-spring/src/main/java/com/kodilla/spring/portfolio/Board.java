package com.kodilla.spring.portfolio;

public class Board {
    private TaskList toDoList;
    private TaskList inProgressList;
    private TaskList doneList;

    public Board(TaskList toDoList, TaskList inProgressList,
                 TaskList doneList){
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }
    public void addTaskToDo(String task) {
        toDoList.add(task);
    }

    public void addTaskInProgress(String task) {
        inProgressList.add(task);
    }

    public void addTaskDone(String task) {
        doneList.add(task);
    }

    public String readTaskToDo(int i) {
        return toDoList.getElement(i);
    }

    public String readTaskInProgress(int i) {
        return inProgressList.getElement(i);
    }

    public String readTaskDone(int i) {
        return doneList.getElement(i);
    }

    public int getToDoQuantity() {
        return toDoList.getSize();
    }

    public int getInProgressQuantity() {
        return inProgressList.getSize();
    }

    public int getDoneQuantity() {
        return doneList.getSize();
    }
}
