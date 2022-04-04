package com.thenullproject.designpatterns.visitor;

public interface Visitor {

    double visit(Apartment apartment);
    double visit(Cottage cottage);
    double visit(Mansion mansion);

}
