package com.pahanez.familytask.workers;

import com.pahanez.familytask.model.Task;

/**
 * Created by pindziukou on 15.09.14.
 */
public class AppActivityWorkerImpl implements AppActivityWorker{

    private TaskWorker mTaskWorker;


    AppActivityWorkerImpl(TaskWorker worker){
        this.mTaskWorker = worker;
    }

    @Override
    public void ref() {
        android.util.Log.e("p37td8", "ckeck");

//        mTaskWorker.addTask(new Task());

        mTaskWorker.listTasks("dk");
    }


}
