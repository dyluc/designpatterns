package com.thenullproject.designpatterns.visitor;

public final class Mansion implements Property {

    public int numberOfRooms = 20;
    public int numberOfFloors = 4;

    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this); // calls Mansion visit method
    }
}
