package com.onlinejava.project.bookstore;

public class book {
    private String title;
    private String writer;
    private int price;
    private String loction;

    public book(String title, String Writer, int price, String loction) {

        this.title = title;
        writer = Writer;
        this.price = price;
        this.loction = loction;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
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