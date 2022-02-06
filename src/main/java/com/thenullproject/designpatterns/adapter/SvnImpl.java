package com.thenullproject.designpatterns.adapter;

public class SvnImpl implements Svn {
    @Override
    public void commit() {
        System.out.println("svn commit");
    }

    @Override
    public void copy() {
        System.out.println("svn copy");
    }

    @Override
    public void revert() {
        System.out.println("svn revert");
    }
}
