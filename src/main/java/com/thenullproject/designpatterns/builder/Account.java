package com.thenullproject.designpatterns.builder;

import java.util.UUID;

public class Account {

    public enum AccountType {
        USER, ADMIN
    }

    // final fields
    private final UUID accountId;
    private final AccountType accountType;

    private final String firstName;
    private final String lastName;
    private final int age;
    private final String mobile;
    private final String address;

    private Account(AccountBuilder builder) {
        this.accountId = builder.accountId;
        this.accountType = builder.accountType;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.mobile = builder.mobile;
        this.address = builder.address;
    }

    public static class AccountBuilder {
        private final UUID accountId;
        private final AccountType accountType;

        private String firstName;
        private String lastName;
        private int age;
        private String mobile;
        private String address;


        public AccountBuilder(AccountType accountType, String firstName) {
            this.accountId = UUID.randomUUID();
            this.accountType = accountType;

            this.firstName = firstName;
        }

        public AccountBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public AccountBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public AccountBuilder age(int age) {
            this.age = age;
            return this;
        }

        public AccountBuilder mobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public AccountBuilder address(String address) {
            this.address = address;
            return this;
        }

        // method to construct object
        public Account build() {
            return new Account(this);
        }
    }

    // immutable class only requires getters

    public UUID getAccountId() {
        return accountId;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getMobile() {
        return mobile;
    }

    public String getAddress() {
        return address;
    }

    //


    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountType=" + accountType +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", mobile='" + mobile + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
