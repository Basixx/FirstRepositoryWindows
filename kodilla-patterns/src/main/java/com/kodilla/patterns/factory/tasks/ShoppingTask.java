package com.kodilla.patterns.factory.tasks;

public class ShoppingTask implements Task{
    private final String taskName;
    private final String whatToBuy;
    private final double quantity;
    public boolean isExecuted = false;

    public ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    @Override
     public void executeTask(){
        System.out.println("executing shopping task - need to buy "
                + whatToBuy + " quantity: " + quantity);
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
