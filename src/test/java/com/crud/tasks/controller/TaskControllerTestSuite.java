package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.Silent.class)
public class TaskControllerTestSuite {

    @InjectMocks
    private TaskController taskController;

    @Mock
    private DbService dbService;

    @Mock
    private TaskMapper taskMapper;

    @Test
    public void getTasksTest() {
        //Given
        List<Task> taskList = new ArrayList<>();
        List<TaskDto> taskDtoList = new ArrayList<>();
        Mockito.when(dbService.getAllTasks()).thenReturn(taskList);
        Mockito.when(taskMapper.mapToTaskDtoList(taskList)).thenReturn(taskDtoList);
        //When
        taskDtoList = taskController.getTasks();
        //Then
        assertNotNull(taskDtoList);
        assertEquals(0, taskDtoList.size());
    }

    @Test
    public void getTaskTest() throws TaskNotFoundException {
        //Given
        Task task = new Task(1L, "title", "content");
        TaskDto taskDto = new TaskDto(1L, "title", "content");
        Mockito.when(dbService.getTask(1L)).thenReturn(java.util.Optional.of(task));
        Mockito.when(taskMapper.mapToTaskDto(task)).thenReturn(taskDto);
        //When
        TaskDto result = taskController.getTask(1L);
        //Then
        assertEquals(task.getTitle(), result.getTitle());
    }

    @Test
    public void deleteTaskTest() throws TaskNotFoundException {
        //Given
        Task task = new Task(1L, "title", "content");
        Mockito.when(dbService.getTask(1L)).thenReturn(java.util.Optional.of(task));
        //When &Then
        taskController.deleteTask(1L);
    }

    @Test
    public void updateTaskTest() {
        //Given
        Task task = new Task(1L, "title", "content");
        TaskDto taskDto = new TaskDto(1L, "title", "content");
        Mockito.when(taskMapper.mapToTask(taskDto)).thenReturn(task);
        Mockito.when(dbService.saveTask(task)).thenReturn(task);
        Mockito.when(taskMapper.mapToTaskDto(task)).thenReturn(taskDto);
        //When
        TaskDto result = taskController.updateTask(taskDto);
        //Then
        assertEquals(result.getTitle(), taskDto.getTitle());
    }

    @Test
    public void createTaskTest() {
        //Given
        Task task = new Task(1L, "title", "content");
        TaskDto taskDto = new TaskDto(1L, "title", "content");
        Mockito.when(taskMapper.mapToTask(taskDto)).thenReturn(task);
        Mockito.when(dbService.saveTask(task)).thenReturn(task);

        //When & Then
        taskController.createTask(taskDto);
    }
}