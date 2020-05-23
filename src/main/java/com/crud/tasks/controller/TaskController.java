package com.crud.tasks.controller;

import com.crud.tasks.domain.TaskDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/task")
public class TaskController {

    @RequestMapping(method = RequestMethod.GET, value = "getTasks")
    List<TaskDto> getTasks() {
        return new ArrayList<>();
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
