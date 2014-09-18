package com.pahanez.familytask.workers;

import com.pahanez.familytask.model.Task;

import java.util.List;

import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Path;

/**
 * Created by pindziukou on 18.09.14.
 */
public interface ParseService {

    @GET("/tasks/{id}/")
    List<Task> listTask(@Path("id") String id);
    @POST("tasks/{id}/")
    void removeTask(@Path("id") String id);
    @POST("tasks/new")
    void addTask(@Body Task task);

}
