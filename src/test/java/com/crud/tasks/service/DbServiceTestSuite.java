package com.crud.tasks.service;

import com.crud.tasks.domain.Task;
import com.crud.tasks.repository.TaskRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.Silent.class)
public class DbServiceTestSuite {
    @InjectMocks
    DbService dbService;

    @Mock
    TaskRepository taskRepository;

    @Test
    public void getAllTasksTest() {
        //Given
        List<Task> taskList = new ArrayList<>();
        Mockito.when(taskRepository.findAll()).thenReturn(taskList);
        //When
        List<Task> result = dbService.getAllTasks();
        //Then
        assertNotNull(result);
        assertEquals(0, result.size());
    }

    @Test
    public void saveTaskTest() {
        //Given
        Task task = new Task(1L, "title", "content");
        Mockito.when(taskRepository.save(task)).thenReturn(task);
        //When
        Task result = dbService.saveTask(task);
        //Then
        assertEquals(result.getTitle(), task.getTitle());
    }

    @Test
    public void getTaskTest(){
        //Given
        Task task = new Task(1L, "title", "content");
        Mockito.when(taskRepository.findById(1L)).thenReturn(Optional.of(task));
        //When
        Optional<Task> result = dbService.getTask(1L);
        //Then
        assertEquals(result.get().getTitle(),task.getTitle());
    }

    @Test
    public void deleteTaskTest(){
        //Given
        Task task = new Task(1L, "title", "content");
        //When &Then
        dbService.deleteTask(1L);
    }
}
