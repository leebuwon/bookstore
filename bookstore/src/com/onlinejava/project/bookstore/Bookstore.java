package com.onlinejava.project.bookstore;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Bookstore{

    public void pagescreen() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("=================================================");
        System.out.println("=                                               =");
        System.out.println("=                                               =");
        System.out.println("=           --------------------------          =");
        System.out.println("=           |    Welcome bookstore   |          =");
        System.out.println("=           |                        |          =");
        System.out.println("=           |    1. Print book list  |          =");
        System.out.println("=           |    2. Book Search      |          ="); // search는.....
        System.out.println("=           |    0. Quit             |          =");
        System.out.println("=           --------------------------          =");
        System.out.println("=                                               =");
        System.out.println("=                                               =");
        System.out.println("=================================================");
        System.out.print("Type the number of the command you want to run: ");

    }
    public void runcommand(Scanner sc) {
        int input = sc.nextInt();
        switch (input) {
            case 1:
                printBookList();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Error : known" + input);
        }
    }

    private void printBookList() {
        getbookList().forEach( (book) -> {
            System.out.println(book);
        });
    }

    private List<Book> getbookList() {
        return List.of(
                new Book("홍길동전", "효선", 15000, "2층 15번"),
                new Book("토끼전", "지선", 20000, "1층 5번"),
                new Book("흥부전", "규선", 17500, "1층 3번"),
                new Book("JAVA의 정석", "남궁성", 22500, "1층 7번")
        );
    }


}
