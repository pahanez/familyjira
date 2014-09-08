package com.pahanez.familytask.activity;

public interface ActivityInteractor {
    public void onViewClicked(int id);
    public <V> void loaderResult(V result);
}
