package com.thenullproject.designpatterns.visitor;

public final class Cottage implements Property {

    public int numberOfRooms = 4;
    public int numberOfFloors = 2;

    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this); // calls Cottage visit method
    }
}
