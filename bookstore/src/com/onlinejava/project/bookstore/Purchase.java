package com.onlinejava.project.bookstore;

public class Purchase {
    private final String title;
    private final String customer;
    private final int buyNumber;

    @Override
    public String toString() {
        return "Purchase{" +
                "title='" + title + '\'' +
                ", customer='" + customer + '\'' +
                ", buyNumber=" + buyNumber +
                '}';
    }

    public Purchase(String Title, String Customer, int buyNumber){


        title = Title;
        customer = Customer;
        this.buyNumber = buyNumber;
    }
}
