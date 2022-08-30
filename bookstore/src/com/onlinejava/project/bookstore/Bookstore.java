package com.onlinejava.project.bookstore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bookstore {

    private List<Book> bookList;
    private List<Purchase> purchaseList;

    {
        purchaseList = new ArrayList<>();
        bookList = new ArrayList<>();
        bookList.add(new Book("홍길동전", "효선", 15000, "2층 15번" ));
        bookList.add(new Book("토끼전", "지선", 20000, "1층 5번" ));
        bookList.add(new Book("흥부전", "규선", 17500, "1층 3번" ));
        bookList.add(new Book("JAVA의 정석", "남궁성", 22500, "1층 7번" ));
    }

    public void pagescreen() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("=====================================================");
        System.out.println("=                                                   =");
        System.out.println("=                                                   =");
        System.out.println("=           ------------------------------          =");
        System.out.println("=           |    Welcome bookstore       |          =");
        System.out.println("=           |                            |          =");
        System.out.println("=           |    1. Print book list      |          =");
        System.out.println("=           |    2. Book Search          |          =");
        System.out.println("=           |    3. Add new book         |          =");
        System.out.println("=           |    4. Delete a book        |          =");
        System.out.println("=           |    5. Buy a book           |          =");
        System.out.println("=           |    6. Print purchase list  |          =");
        System.out.println("=           |    7. Add book stock       |          =");
        System.out.println("=           |    0. Quit                 |          =");
        System.out.println("=           ------------------------------          =");
        System.out.println("=                                                   =");
        System.out.println("=                                                   =");
        System.out.println("=====================================================");
        System.out.print("Type the number of the command you want to run: ");

    }

    public void runcommand(Scanner sc) {
        String input = sc.nextLine().trim();
        switch (input) {
            case "1":
                printBookList();
                break;
            case "2":
                System.out.printf("Search Title: ");
                String searchTitle = sc.nextLine().trim();
                printBookList(searchBook(searchTitle));
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
            case "5":
                System.out.printf("Type title: ");
                String purchaseBook = sc.nextLine().trim();

                System.out.printf("Type customer: ");
                String buyCustomer = sc.nextLine().trim();
                buyBook(purchaseBook, buyCustomer);
                break;
            case "6":
                printPurchaseList();
                break;


            case"7":
                break;

            case "0":
                System.exit(0);
                break;
            default:
                System.out.println("Error : known " + input);
        }
    }

    private void printPurchaseList() {
        getPurchaseList().stream()
                .forEach(System.out::println);
    }

    private void buyBook(String purchaseBook, String buyCustomer) {
//        List<Book> list = getbookList();
//        for(int i = 0; i < list.size(); i++){                           //아래가 함수형 프로그램으로 변환한 것
//            if(list.get(i).getTitle().equals(purchaseBook)){
//                list.get(i).setStock(list.get(i).getStock() - 1);
//            }                                 // 음수가 나오지 않게 하기!
//        }
        getbookList().stream()
                .filter(book -> book.getTitle().equals(purchaseBook))
                .filter(book -> book.getStock() > 0)
                .forEach(book -> book.setStock(book.getStock() - 1));
        Purchase purchase = new Purchase(purchaseBook, buyCustomer, 1);
        getPurchaseList().add(purchase);
    }

    private List<Purchase> getPurchaseList() {
        return this.purchaseList;
    }

    private void printBookList(Object searchBook) {
        //이건 잘모르겠습니다.
    }

    private List<Book> searchBook(String searchTitle) {
        List<Book> list = getbookList();
        for (int i = 0; i < list.size(); i++){
            if(list.get(i).getTitle().contains(searchTitle)){
                System.out.println(searchTitle + " 책이 존재합니다.");
                break;
            }
        }
        return bookList;
    }


    private void deletingBook(String deletingBook) {
        List<Book> list = getbookList();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getTitle().equals(deletingBook)){
                list.remove(i);
                System.out.println("Delete success");
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

    private void printBookList() {
        getbookList().forEach( (book) -> {
            System.out.println(book);
        });
    }

    private List<Book> getbookList() {
        return bookList;
    }
}