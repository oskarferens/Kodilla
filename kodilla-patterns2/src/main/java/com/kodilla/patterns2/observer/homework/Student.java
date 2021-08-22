package com.kodilla.patterns2.observer.homework;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Student implements Observable{

    private Queue<Task> taskQueue;
    private List<Observer> observerList;
    private String name;
    private String surname;

    public Student(String name, String surname) {
        this.taskQueue = new ArrayDeque<>();
        this.observerList = new ArrayList<>();
        this.name = name;
        this.surname = surname;
    }

    public void putToQueue(Task task) {
        taskQueue.offer(task);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer mentor : observerList) {
            mentor.update(this);
        }

    }

    @Override
    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    public Queue<Task> getTaskQueue() {
        return taskQueue;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
