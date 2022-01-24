package com.thenullproject.designpatterns.singleton;

public class ThreadUnsafeSingleton {

    private static final ThreadUnsafeSingleton instance = new ThreadUnsafeSingleton();
    private String data = "Initial Data";

    private ThreadUnsafeSingleton() {}

    public static ThreadUnsafeSingleton getInstance() {
        return instance;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
