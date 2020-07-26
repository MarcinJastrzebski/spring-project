package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskMapperTestSuite {
    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void allTaskMappersTest(){
        //Given
        Task task1 = new Task(1L,"title1", "content1");
        TaskDto task2Dto = new TaskDto(2L,"title2", "content2");
        List<Task> taskList = new ArrayList<>();
        taskList.add(task1);

        //When
        TaskDto task1Dto = taskMapper.mapToTaskDto(task1);
        Task task2 = taskMapper.mapToTask(task2Dto);
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(taskList);

        //Then
        Assert.assertEquals(task1.getTitle(),task1Dto.getTitle());
        Assert.assertEquals(task2.getTitle(),task2Dto.getTitle());
        Assert.assertEquals(taskList.get(0).getTitle(),taskDtoList.get(0).getTitle());
    }
}
