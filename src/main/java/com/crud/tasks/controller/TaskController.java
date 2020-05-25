package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/task")
public class TaskController {
    @Autowired
    private DbService service;
    @Autowired
    private TaskMapper taskMapper;

    @RequestMapping(method = RequestMethod.GET, value = "getTasks")
    List<TaskDto> getTasks() {
        return taskMapper.mapToTaskDtoList(service.getAllTasks());
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTask", params = "taskId")
    TaskDto getTask(@RequestParam("taskId") Long taskId) {
        return new TaskDto(1L, "test title", "test_contetnt");
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTask", params = "taskId")
    void deleteTask(@RequestParam("taskId") Long taskId) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateTask", params = "task")
    TaskDto updateTask(@RequestParam("task") TaskDto task) {
        return new TaskDto(1L, "Edited test title", "Test contetnt");
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTasK", params = "task")
    void createTask(@RequestParam("task") TaskDto task) {

    }
}
