package com.onlinejava.project.bookstore;

public class Book {
    private String Title;
    private String Writer;
    private int Price;
    private String Location;

    public Book(String Title, String Writer, int Price, String Location) {

        this.Title = Title;
        this.Writer = Writer;
        this.Price = Price;
        this.Location = Location;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Title='" + Title + '\'' +
                ", writer='" + Writer + '\'' +
                ", Price=" + Price +
                ", Location='" + Location + '\'' +
                '}';
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getWriter() {
        return Writer;
    }

    public void setWriter(String writer) {
        this.Writer = writer;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }


}