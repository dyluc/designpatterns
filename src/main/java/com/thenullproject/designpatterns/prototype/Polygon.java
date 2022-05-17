package com.thenullproject.designpatterns.prototype;

/**
 * Abstract base prototype class
 */
public abstract sealed class Polygon permits Square, Triangle {

    private final String name;
    private final int noOfEdges;

    /**
     * Regular constructor
     */
    protected Polygon(String name, int noOfEdges) {
        this.name = name;
        this.noOfEdges = noOfEdges;
    }

    /**
     * Prototype constructor
     */
    protected Polygon(Polygon polygon) {
        this(polygon.name, polygon.noOfEdges);
    }

    /**
     * Returns a Polygon subclass
     */
    public abstract Polygon clone();
}
