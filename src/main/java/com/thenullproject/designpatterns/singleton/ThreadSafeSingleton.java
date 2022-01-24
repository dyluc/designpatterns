package com.thenullproject.designpatterns.singleton;

public enum ThreadSafeSingleton {

    INSTANCE("Initial Data");

    private String data;

    ThreadSafeSingleton(String initialData) {
        data = initialData;
        // ...
    }

    public ThreadSafeSingleton getInstance() {
        return INSTANCE;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
