package com.kodilla.patterns2.patterns.factory.tasks;


public class ShoppingTask implements Task{

    String taskName;
    String whatToBuy;
    double quantity;
    boolean isExecuted = false;

    public ShoppingTask(String taskName, String whatToBuy, double quantity) {
        this.taskName = taskName;
        this.whatToBuy = whatToBuy;
        this.quantity = quantity;
    }

    @Override
    public void executeTask() {
        System.out.println("Executing task: " + taskName + ". Product name: " + whatToBuy + ". Quantity: " + quantity );
        isExecuted = true;
    }

    @Override
    public String getTaskName() {
        return taskName;
    }

    @Override
    public boolean isTaskExecuted() {
        if (isExecuted = true) {
            System.out.println("The task was completed. ");
        } else {
            System.out.println("The task is not completed");
        }
        return isExecuted;
    }

}
