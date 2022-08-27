package com.onlinejava.project.bookstore;

public class Book {
    private String title;
    private String Writer;
    private int price;
    private String loction;

    public Book(String title, String Writer, int price, String loction) {

        this.title = title;
        this.Writer = Writer;
        this.price = price;
        this.loction = loction;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", writer='" + Writer + '\'' +
                ", price=" + price +
                ", loction='" + loction + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return Writer;
    }

    public void setWriter(String writer) {
        this.Writer = writer;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getLoction() {
        return loction;
    }

    public void setLoction(String loction) {
        this.loction = loction;
    }


}