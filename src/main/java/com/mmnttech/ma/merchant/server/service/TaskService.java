package com.mmnttech.ma.merchant.server.service;

import com.mmnttech.ma.merchant.server.common.exception.DatabaseException;
import com.mmnttech.ma.merchant.server.mapper.TaskMapper;
import com.mmnttech.ma.merchant.server.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Stelo
 * @createAt 2018/1/16
 **/

@Transactional(rollbackFor = DatabaseException.class)
@Service("taskService")
public class TaskService {

    protected static final String TaskStatusWaiting = "1";
    protected static final String TaskStatusEnding = "2";
    protected static final String TaskStatusProcessing = "P";

    @Autowired
    private TaskMapper taskMapper;

    public List<Task> createTaskList(List<Task> taskList) {
        List<Task> curTaskList = new LinkedList<>();
        for (Task task : taskList) {
            task.setStatus(TaskStatusWaiting);
            taskMapper.insert(task);
            curTaskList.add(task);
        }
        return taskList;
    }
}
