package com.onlinejava.project.bookstore;

import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Bookstore Bookstore = new Bookstore();

        while(true) {
            Bookstore.pagescreen();
            Bookstore.runcommand(sc);

            }
        }




}

        




