package com.onlinejava.project.bookstore;

public class Purchase {
    private String title;
    private String customer;
    private int buyNumber;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getBuyNumber() {
        return buyNumber;
    }

    public void setBuyNumber(int buyNumber) {
        this.buyNumber = buyNumber;
    }
}
