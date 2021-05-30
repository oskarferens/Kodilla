package com.kodilla.patterns.factory.tasks;


public class DrivingTask implements Task {

    String taskName;
    String where;
    String using;
    boolean isExecuted = false;

    public DrivingTask(String taskName, String where, String using) {
        this.taskName = taskName;
        this.where = where;
        this.using = using;
    }

    @Override
    public void executeTask() {
        System.out.println("Executing task: " + taskName + ". Destination: " + where + ". Vehicle: " + using );
        isExecuted = false;
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
