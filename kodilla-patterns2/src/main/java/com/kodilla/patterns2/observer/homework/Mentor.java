package com.kodilla.patterns2.observer.homework;


public class Mentor implements Observer{

    public final String mentorName;
    private int updateCount;

    public Mentor(String mentorName) {
        this.mentorName = mentorName;
    }

    @Override
    public void update(Student student) {
        System.out.println(mentorName + ": You`ve got new Task in queue done by " + student.getName() + " "
                + student.getSurname() + "\n" + "Total: " + student.getTaskQueue().size() + " tasks.");
        updateCount++;
    }

    public String getMentorName() {
        return mentorName;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}