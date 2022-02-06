package com.thenullproject.designpatterns.adapter;

/**
 * Expose the target interface and wrap the adaptee
 */
public class GitToSvnAdapter implements Svn {

    private final Git git;

    public GitToSvnAdapter(Git git) {
        this.git = git;
    }

    @Override
    public void commit() {
        git.commit();
    }

    @Override
    public void copy() {
        git.branch();
    }

    @Override
    public void revert() {
        git.reset();
    }
}
