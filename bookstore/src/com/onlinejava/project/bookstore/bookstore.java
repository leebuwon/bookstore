package com.onlinejava.project.bookstore;
import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class bookstore {

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
        System.out.println("=           |    2. Book Search      |          =");
        System.out.println("=           |    0. Quit             |          =");
        System.out.println("=           --------------------------          =");
        System.out.println("=                                               =");
        System.out.println("=                                               =");
        System.out.println("=================================================");
        System.out.println("Type the number of the command you want to run: ");

    }
    public void runcommand(Scanner sc) {
        int input = sc.nextInt();
        switch (input) {
            case 1:
                System.out.println("list");
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Error : known" + input);
        }
    }


}
