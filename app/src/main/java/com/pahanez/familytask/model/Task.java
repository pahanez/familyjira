package com.pahanez.familytask.model;

public class Task implements IdentifiedEntity{

    private String mTaskId;

    
    @Override
    public String getID() {
        return mTaskId;
    }

    @Override
    public void setID(String id) {
        this.mTaskId = id;
    }
}
