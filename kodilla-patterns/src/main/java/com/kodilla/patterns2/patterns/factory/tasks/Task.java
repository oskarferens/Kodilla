package com.kodilla.patterns2.patterns.factory.tasks;

public interface Task {
    void executeTask();
    String getTaskName();
    boolean isTaskExecuted();
}