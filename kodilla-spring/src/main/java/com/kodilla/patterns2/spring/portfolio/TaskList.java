package com.kodilla.patterns2.spring.portfolio;
import java.util.ArrayList;
import java.util.List;

public class TaskList {

    List<String> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public List<String> getTasks() {
        return tasks;
    }

    public void addTask(String task) {
        tasks.add(task);
    }
}
