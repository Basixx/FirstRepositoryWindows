package com.kodilla.patterns.factory.tasks;

public class PaintingTask implements Task{
    private final String taskName;
    private final String color;
    private final String whatToPaint;
    public boolean isExecuted = false;

    public PaintingTask(String taskName, String color, String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    @Override
    public void executeTask(){
        System.out.println("executing painting task - painting "
        + whatToPaint + " in color "+ color);
        isExecuted = true;
    }

    @Override
    public boolean isTaskExecuted() {
        return isExecuted;
    }

    @Override
    public String getTaskName(){
        return taskName;
    }
}
