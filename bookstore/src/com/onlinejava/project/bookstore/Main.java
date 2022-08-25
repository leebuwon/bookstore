package com.onlinejava.project.bookstore;

import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        bookstore bookstore = new bookstore();


        while(true) {
            bookstore.pagescreen();
            bookstore.runcommand(sc);

            }
        }




}

        




