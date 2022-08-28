package com.onlinejava.project.bookstore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bookstore{

    private List<Book> bookList;
    {
        bookList = new ArrayList<>();
        bookList.add(new Book("홍길동전", "효선", 15000, "2층 15번"));
        bookList.add(new Book("토끼전", "지선", 20000, "1층 5번"));
        bookList.add(new Book("흥부전", "규선", 17500, "1층 3번"));
        bookList.add(new Book("JAVA의 정석", "남궁성", 22500, "1층 7번"));
    }

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
        System.out.println("=           |    2. Book Search      |          ="); // 마지막에 구현
        System.out.println("=           |    3. Add new book     |          =");
        System.out.println("=           |    4. Delete a book    |          =");
        System.out.println("=           |    0. Quit             |          =");
        System.out.println("=           --------------------------          =");
        System.out.println("=                                               =");
        System.out.println("=                                               =");
        System.out.println("=================================================");
        System.out.print("Type the number of the command you want to run: ");

    }
    public void runcommand(Scanner sc) {
        String input = sc.nextLine().trim();
        switch (input) {
            case "1":
                printBookList();
                break;
            case "2":
                searchBook();
                break;
            case "3":
                System.out.printf("Type Title: ");
                String Title = sc.nextLine().trim();

                System.out.printf("Type Writer: ");
                String Writer = sc.nextLine().trim();

                System.out.printf("Type Price: ");
                int Price = Integer.parseInt(sc.nextLine().trim());

                System.out.printf("Type Location: ");
                String Location = sc.nextLine().trim();

                Book newBook = new Book(Title, Writer, Price, Location);
                updateBook(newBook);
                break;
            case "4":
                System.out.printf("delete Title: ");
                String deletingBook = sc.nextLine().trim();
                deletingBook(deletingBook);
                break;
            case "0":
                System.exit(0);
                break;
            default:
                System.out.println("Error : known" + input);
        }
    }

    private void deletingBook(String deletingBook) {
        List<Book> list = getbookList();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getTitle().equals(deletingBook)){
                list.remove(i);
                return;
            } else{
                System.out.println("No matching book found.");
                return;
            }
        }
    }

    private void updateBook(Book newBook) {
        getbookList().add(newBook);
    }


    private void searchBook() {  // 마지막에 구현

    }

    private void printBookList() {
        getbookList().forEach( (book) -> {
            System.out.println(book);
        });
    }

    private List<Book> getbookList() {
        return bookList;
    }


}
