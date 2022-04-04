package com.thenullproject.designpatterns.visitor;

public class ValuationVisitor implements Visitor {

    @Override
    public double visit(Apartment apartment) {
        System.out.println("Valuing Apartment");
        double value = apartment.numberOfRooms * apartment.numberOfFloors * 50_200.234;
        return Double.parseDouble(String.format("%.2f", value));
    }

    @Override
    public double visit(Cottage cottage) {
        System.out.println("Valuing Cottage");
        double value = cottage.numberOfRooms * cottage.numberOfFloors * 20_250.554;
        return Double.parseDouble(String.format("%.2f", value));
    }

    @Override
    public double visit(Mansion mansion) {
        System.out.println("Valuing Mansion");
        double value = mansion.numberOfRooms * mansion.numberOfFloors * 31_415.927;
        return Double.parseDouble(String.format("%.2f", value));
    }
}
