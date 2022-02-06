package com.thenullproject.designpatterns;

import com.thenullproject.designpatterns.adapter.GitImpl;
import com.thenullproject.designpatterns.adapter.GitToSvnAdapter;
import com.thenullproject.designpatterns.adapter.SvnImpl;
import com.thenullproject.designpatterns.builder.Account;
import com.thenullproject.designpatterns.factory.Cryptocurrency;
import com.thenullproject.designpatterns.factory.CryptocurrencyFactory;
import com.thenullproject.designpatterns.iterator.Array;
import com.thenullproject.designpatterns.iterator.Iterator;
import com.thenullproject.designpatterns.singleton.ThreadSafeSingleton;
import com.thenullproject.designpatterns.singleton.ThreadUnsafeSingleton;

import static com.thenullproject.designpatterns.builder.Account.AccountType;

public class Main {

    public static void main(String[] args) {

        /*

        Usages of various design patterns

         */

        // ==== Creational ====
        // Singleton
        //singleton();

        // Builder
        //builder();

        // Factory
        //factory(args[0]);

        // ==== Behavioural ====

        // Iterator
        //iterator();

        // ==== Structural ====

        // Adapter
        adapter();


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
