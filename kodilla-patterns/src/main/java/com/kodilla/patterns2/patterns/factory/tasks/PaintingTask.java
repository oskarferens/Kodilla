package com.kodilla.patterns2.patterns.factory.tasks;


public class PaintingTask implements Task{

    String taskName;
    String color;
    String whatToPaint;
    boolean isExecuted = false;

    public PaintingTask(String taskName, String color, String whatToPaint) {
        this.taskName = taskName;
        this.color = color;
        this.whatToPaint = whatToPaint;
    }

    @Override
    public void executeTask() {
        System.out.println("Executing task: " + taskName + ". Color: " + color + ". What to paint: " + whatToPaint );
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
