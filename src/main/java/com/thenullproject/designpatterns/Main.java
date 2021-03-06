package com.thenullproject.designpatterns;

import com.thenullproject.designpatterns.adapter.GitImpl;
import com.thenullproject.designpatterns.adapter.GitToSvnAdapter;
import com.thenullproject.designpatterns.adapter.SvnImpl;
import com.thenullproject.designpatterns.builder.Account;
import com.thenullproject.designpatterns.factory.Cryptocurrency;
import com.thenullproject.designpatterns.factory.CryptocurrencyFactory;
import com.thenullproject.designpatterns.iterator.Array;
import com.thenullproject.designpatterns.iterator.Iterator;
import com.thenullproject.designpatterns.prototype.Polygon;
import com.thenullproject.designpatterns.prototype.PolygonRegistry;
import com.thenullproject.designpatterns.prototype.Square;
import com.thenullproject.designpatterns.prototype.Triangle;
import com.thenullproject.designpatterns.singleton.ThreadSafeSingleton;
import com.thenullproject.designpatterns.singleton.ThreadUnsafeSingleton;
import com.thenullproject.designpatterns.strategy.ArraySort;
import com.thenullproject.designpatterns.strategy.ArraySortStrategy;
import com.thenullproject.designpatterns.strategy.BubbleSort;
import com.thenullproject.designpatterns.strategy.QuickSort;
import com.thenullproject.designpatterns.visitor.Apartment;
import com.thenullproject.designpatterns.visitor.Cottage;
import com.thenullproject.designpatterns.visitor.Mansion;
import com.thenullproject.designpatterns.visitor.ValuationVisitor;

import java.util.Arrays;

import static com.thenullproject.designpatterns.builder.Account.AccountType;

public class Main {

    public static void main(String[] args) {

        /*

        Client usages of various design patterns

         */

        // ==== Creational ====
        // Singleton
        //singleton();

        // Builder
        //builder();

        // Factory
        //factory(args[0]);

        // Prototype
        prototype();

        // ==== Behavioural ====

        // Iterator
        //iterator();

        // Strategy
        // strategy();

        // Visitor
        // visitor();

        // ==== Structural ====

        // Adapter
        //adapter();


    }

    private static void prototype() {
        // create Square & Triangle instances using normal constructors
        Square square = new Square(5.0F);
        Triangle triangle = new Triangle(Triangle.Type.ISOSCELES);

        // clone it and cast it
        Square squareClone1 = (Square) square.clone();
        Triangle triangleClone1 = (Triangle) triangle.clone();

        System.out.println("Squares equal: " + square.equals(squareClone1));
        System.out.println("Triangles equal: " + triangle.equals(triangleClone1));

        // clone it (don't need to know its type, refer to it by its base class)
        Polygon squareClone2 = square.clone();
        Polygon triangleClone2 = triangle.clone();

        // polygon registry is just a wrapper around a hashmap
        PolygonRegistry polygonRegistry = new PolygonRegistry();

        polygonRegistry.addPolygon("Square", squareClone2);
        polygonRegistry.addPolygon("Triangle", triangleClone2);

        // get a clone from the registry
        Polygon squareClone3 = polygonRegistry.getPolygonByName("Square");
        Polygon triangleClone3 = polygonRegistry.getPolygonByName("Triangle");
    }

    private static void visitor() {
        // construct an instance of a visitor
        ValuationVisitor propertyValuer = new ValuationVisitor();

        // objects now have a common interface
        Apartment apartment = new Apartment();
        Cottage cottage = new Cottage();
        Mansion mansion = new Mansion();

        // delegate calls to visitor by passing it to the accept methods
        double apartmentValue = apartment.accept(propertyValuer);
        System.out.println("??" + apartmentValue);

        double cottageValue = cottage.accept(propertyValuer);
        System.out.println("??" + cottageValue);

        double mansionValue = mansion.accept(propertyValuer);
        System.out.println("??" + mansionValue);
    }

    private static void strategy() {
        // construct new context
        ArraySort arraySort = new ArraySort();

        // construct new strategy implementation algorithm
        ArraySortStrategy bubbleSortStrategy = new BubbleSort();

        // pass strategy to context
        arraySort.setStrategy(bubbleSortStrategy);

        // execute strategy
        Integer[] pi = new Integer[] {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5, 9};
        Integer[] piClone = pi.clone();

        System.out.printf("Unsorted Array: %s.%n", Arrays.toString(pi));
        arraySort.sort(pi);
        System.out.printf("Sorted Array: %s.%n", Arrays.toString(pi));

        // change strategy
        arraySort.setStrategy(new QuickSort());

        // execute strategy
        System.out.printf("%nUnsorted Array: %s.%n", Arrays.toString(piClone));
        arraySort.sort(piClone);
        System.out.printf("Sorted Array: %s.%n", Arrays.toString(piClone));
    }

    private static void adapter() {
        GitImpl gitImpl = new GitImpl();
        SvnImpl svnImpl = new SvnImpl();

        // git commands
        System.out.println("Calling git commands...");
        gitImpl.commit();
        gitImpl.branch();
        gitImpl.reset();
        System.out.println();

        // svn commands
        System.out.println("Calling svn commands...");
        svnImpl.commit();
        svnImpl.copy();
        svnImpl.revert();
        System.out.println();

        // call git branch using svn dialect
        System.out.println("Calling git commands using svn dialect...");
        new GitToSvnAdapter(gitImpl).copy();
    }

    private static void iterator() {
        // create new array with 6 items
        Array array = new Array();

        for(int i = 1; i <= 6; i++)
            array.push(String.format("Item %d.", i));

        // create 2 new instances of an ArrayIterator
        Iterator arrayIterator1 = array.getIterator();
        Iterator arrayIterator2 = array.getIterator();

        // print items in order
        while(arrayIterator1.hasNext()) {
            System.out.println(arrayIterator1.getNext());
        }

        while(arrayIterator2.hasNext()) {
            System.out.println(arrayIterator2.getNext());
        }
    }

    private static void factory(String type) {
        Cryptocurrency cryptocurrency = CryptocurrencyFactory.createCurrency(type);
        System.out.println(cryptocurrency.getTickerSymbol());
    }


    private static void singleton() {
        // Thread unsafe
        ThreadUnsafeSingleton classSingleton1 = ThreadUnsafeSingleton.getInstance();

        System.out.println(classSingleton1.getData().equals("Initial Data"));

        ThreadUnsafeSingleton classSingleton2 = ThreadUnsafeSingleton.getInstance();
        classSingleton2.setData("Modified Class Data");

        System.out.println(classSingleton2.getData().equals(classSingleton1.getData()));

        // Thread safe
        ThreadSafeSingleton enumSingleton1 = ThreadSafeSingleton.INSTANCE.getInstance();

        System.out.println(enumSingleton1.getData().equals("Initial Data"));

        ThreadSafeSingleton enumSingleton2 = ThreadSafeSingleton.INSTANCE.getInstance();
        enumSingleton2.setData("Modified Enum Data");

        System.out.println(enumSingleton2.getData().equals(enumSingleton1.getData()));
    }

    private static void builder() {
        Account userAccount = new Account.AccountBuilder(AccountType.USER, "John")
                .lastName("Doe")
                .mobile("01234 567 890")
                .build();

        Account.AccountBuilder adminAccountBuilder = new Account.AccountBuilder(AccountType.ADMIN, "Susan");

        adminAccountBuilder
                .lastName("Doe")
                .address("123 Penny Lane")
                .age(21);

        Account adminAccount = adminAccountBuilder.build();

        System.out.println(userAccount.toString());
        System.out.println(adminAccount.toString());
    }
}
