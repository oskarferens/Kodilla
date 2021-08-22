package com.kodilla.patterns2.observer.forum;

import com.kodilla.patterns2.observer.homework.Mentor;
import com.kodilla.patterns2.observer.homework.Student;
import com.kodilla.patterns2.observer.homework.Task;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HomeworkTestSuite {

    @Test
    public void updateTest() {
        //Given
        Student student1 = new Student("John", "Lenon");
        Student student2 = new Student("Elvis", "Presley");
        Student student3 = new Student("Mary", "Flery");

        Mentor mentor1 = new Mentor("Mentor 1");
        Mentor mentor2 = new Mentor("Mentor 2");

        Task task1 = new Task("24.1", "content1");
        Task task2 = new Task("24.2", "content2");
        Task task3 = new Task("24.3", "content3");

        //When
        student1.registerObserver(mentor1);
        student2.registerObserver(mentor1);
        student2.registerObserver(mentor2);
        student3.registerObserver(mentor1);
        student2.putToQueue(task2);
        student2.putToQueue(task3);
        student1.putToQueue(task1);
        student1.putToQueue(task2);
        student3.putToQueue(task1);

        //Then
        assertEquals(2, mentor2.getUpdateCount());
        assertEquals(5, mentor1.getUpdateCount());

    }
}