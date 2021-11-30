package com.kodilla.spring.portfolio;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BoardTestSuite {

    @Test
    public void testAllTasksAreReadable() {
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        board.addTaskToDo("Task to do");
        board.addTaskInProgress("Task in progress");
        board.addTaskDone("Task done");

        String taskTD = board.readTaskToDo(board.getToDoQuantity()-  1);
        String taskIP = board.readTaskInProgress(board.getInProgressQuantity()-1);
        String taskD = board.readTaskDone(board.getDoneQuantity()-1);

        //then
        assertEquals(taskTD, "Task to do");
        assertEquals(taskIP, "Task in progress");
        assertEquals(taskD, "Task done");
    }
}