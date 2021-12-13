package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskListDaoTestSuite {

    private static final String LISTNAME = "List one";
    private static final String DESCRIPTION = "list of cleaning tasks";

    @Autowired
    private TaskListDao taskListDao;

    @Test
    void testFindByListName(){
        //Given
        TaskList taskList = new TaskList(LISTNAME, DESCRIPTION);
        taskListDao.save(taskList);

        //When
        List<TaskList> found = taskListDao.findByListName(LISTNAME);

        //Then
        assertEquals(1, found.size());

        //cleanUp
        int id = found.get(0).getId();
        taskListDao.deleteById(id);
    }
}
