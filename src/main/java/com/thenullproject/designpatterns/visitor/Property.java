package com.thenullproject.designpatterns.visitor;

// Visitable element
public sealed interface Property permits Apartment, Cottage, Mansion {

    // define method used to delegate calls to Visitor
    double accept(Visitor visitor);
}
