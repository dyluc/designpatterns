package com.thenullproject.designpatterns.visitor;

public final class Apartment implements Property {

    public int numberOfRooms = 2;
    public int numberOfFloors = 1;

    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this); // calls Apartment visit method
    }
}
