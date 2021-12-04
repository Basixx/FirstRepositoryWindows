package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    @Test
    void testFactoryShoppingTask(){
        //given
        TaskFactory factory = new TaskFactory();

        //when
        Task shopping = factory.makeTask(TaskFactory.SHOPPING_TASK);
        shopping.executeTask();

        //then
        assertEquals("Shopping", shopping.getTaskName());
        assertTrue(shopping.isTaskExecuted());
    }

    @Test
    void testFactoryPaintingTask(){
        //given
        TaskFactory factory = new TaskFactory();

        //when
        Task painting = factory.makeTask(TaskFactory.PAINTING_TASK);
        painting.executeTask();

        //then
        assertEquals("Painting", painting.getTaskName());
        assertTrue(painting.isTaskExecuted());
    }

    @Test
    void testFactoryDrivingTask(){
        //given
        TaskFactory factory = new TaskFactory();

        //when
        Task driving = factory.makeTask(TaskFactory.DRIVING_TASK);
        driving.executeTask();

        //then
        assertEquals("Driving", driving.getTaskName());
        assertTrue(driving.isTaskExecuted());
    }
}
