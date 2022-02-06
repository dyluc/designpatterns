package com.thenullproject.designpatterns.adapter;

/**
 * Target interface (the interface the client interacts with)
 */
public interface Svn {

    void commit();
    void copy();
    void revert();

}
