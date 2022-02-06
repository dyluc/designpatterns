package com.thenullproject.designpatterns.adapter;

public class GitImpl implements Git {

    @Override
    public void commit() {
        System.out.println("git commit");
    }

    @Override
    public void branch() {
        System.out.println("git branch");
    }

    @Override
    public void reset() {
        System.out.println("git reset");
    }
}
