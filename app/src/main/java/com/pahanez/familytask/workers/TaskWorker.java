package com.pahanez.familytask.workers;

import com.pahanez.familytask.model.Task;

import java.util.List;

/**
 * Created by pindziukou on 17.09.14.
 */
public interface TaskWorker {
    List<Task> listTasks(String id);
    void removeTask(String id);
    void addTask(Task task);
}
