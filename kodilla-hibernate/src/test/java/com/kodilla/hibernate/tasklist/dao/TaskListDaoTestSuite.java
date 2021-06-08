package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.dao.TaskListDao;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;
    private static final String DESCRIPTION = "Test: Learn Hibernate";

    @Test
    void testFindByListName() {
        //Given
        TaskList taskList = new TaskList("Sample list name 1", DESCRIPTION);
        taskListDao.save(taskList);
        String listName = taskList.getListName();

        //When
        List<TaskList> readTaskList = taskListDao.findByListName(listName);

        //Then
        assertEquals(1, readTaskList.size());

        //CleanUp
        int id = readTaskList.get(0).getId();
        taskListDao.deleteById(id);
    }
}