package com.thenullproject.designpatterns.prototype;

import java.util.Objects;

/**
 * Concrete prototype
 */
public final class Square extends Polygon {

    private final float length; // length of side

    public Square(float length) {
        super("Square", 4); // copy private fields defined in parent class
        this.length = length;
    }

    private Square(Square square) {
        super(square);
        length = square.length;
    }

    /**
     * Clone method creates a new object and passes it to the constructor.
     */
    @Override
    public Polygon clone() {
        return new Square(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Float.compare(square.length, length) == 0;
    }
}
