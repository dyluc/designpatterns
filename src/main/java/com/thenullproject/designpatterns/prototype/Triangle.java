package com.thenullproject.designpatterns.prototype;

import java.util.Objects;

/**
 * Concrete prototype
 */
public final class Triangle extends Polygon {

    public enum Type {
        EQUILATERAL, ISOSCELES, SCALENE
    }

    private final Type type;

    public Triangle(Type type) {
        super("Triangle", 3); // copy private fields defined in parent class
        this.type = type;
    }

    private Triangle(Triangle triangle) {
        super(triangle);
        type = triangle.type;
    }

    /**
     * Clone method creates a new object and passes it to the constructor.
     */
    @Override
    public Polygon clone() {
        return new Triangle(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return type == triangle.type;
    }
}
