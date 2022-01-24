package com.thenullproject.designpatterns;

import com.thenullproject.designpatterns.builder.Account;
import com.thenullproject.designpatterns.singleton.ThreadSafeSingleton;
import com.thenullproject.designpatterns.singleton.ThreadUnsafeSingleton;

import static com.thenullproject.designpatterns.builder.Account.AccountType;

public class Main {

    public static void main(String[] args) {

        // Design pattern usages

        // Singleton
        singleton();

        // Builder
        builder();

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
