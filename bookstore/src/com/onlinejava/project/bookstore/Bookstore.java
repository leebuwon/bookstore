package com.onlinejava.project.bookstore;

import org.w3c.dom.xpath.XPathResult;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bookstore {

    private List<Book> bookList;
    private List<Purchase> purchaseList;
    private List<Member> MemberList;

    {
        purchaseList = new ArrayList<>();
        bookList = new ArrayList<>();
        MemberList = new ArrayList<>();


        try {FileInputStream fis = new FileInputStream("booklist.dat");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader reader = new BufferedReader(isr);        // BufferedReader는 scanner보다 성능상으로 좋기 떄문에 잘 사용하는 것이 좋다

            reader.lines()
                    .forEach(line -> {
                                List<String> book = Arrays.stream(line.split(",")).map(String::trim).toList();
                                bookList.add(new Book(book.get(0), book.get(1), Integer.parseInt(book.get(2)), book.get(3)));
                            });

            FileInputStream fis2 = new FileInputStream("memberlist.dat");
            InputStreamReader isr2 = new InputStreamReader(fis2);
            BufferedReader reader2 = new BufferedReader(isr2);

            reader2.lines()
                    .forEach(line -> {
                        List<String> member = Arrays.stream(line.split(",")).map(String::trim).toList();
                        MemberList.add(new Member(member.get(0), member.get(1), member.get(2)));
                    });

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void pagescreen() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("==========================================================");
        System.out.println("=                                                        =");
        System.out.println("=                                                        =");
        System.out.println("=           -----------------------------------          =");
        System.out.println("=           |    Welcome bookstore            |          =");
        System.out.println("=           |                                 |          =");
        System.out.println("=           |    1. Print book list           |          =");
        System.out.println("=           |    2. Book Search               |          =");
        System.out.println("=           |    3. Add new book              |          =");
        System.out.println("=           |    4. Delete a book             |          =");
        System.out.println("=           |    5. Buy a book                |          =");
        System.out.println("=           |    6. Print purchase list       |          =");
        System.out.println("=           |    7. Add book stock            |          =");
        System.out.println("=           |    8. Print a Member List       |          =");
        System.out.println("=           |    9. Add new Member            |          =");
        System.out.println("=           |    10. Withdraw a member        |          =");
        System.out.println("=           |    11. Modify a member          |          =");
        System.out.println("=           |    12. Print a user`s purchases |          =");
        System.out.println("=           |    0. Quit                      |          =");
        System.out.println("=           -----------------------------------          =");
        System.out.println("=                                                        =");
        System.out.println("=                                                        =");
        System.out.println("==========================================================");
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
                System.out.printf("Type title: ");
                String addTitle = sc.nextLine().trim();

                System.out.printf("Type stock: ");
                int addStock = Integer.parseInt(sc.nextLine().trim());

                addBookStock(addTitle, addStock);
                break;
            case "8":
                printMemberList();
                break;
            case "9":
                System.out.printf("User Name: ");
                String addUserName = sc.nextLine().trim();

                System.out.printf("User Email: ");
                String addUserEmail = sc.next().trim();

                System.out.printf("User PhoneNumber: ");
                String addUserPhoneNumber = sc.next().trim();

                Member newMember = new Member(addUserName, addUserEmail, addUserPhoneNumber);
                updateUser(newMember);
                break;
            case "10":
                System.out.printf("Withdraw MemberName: ");
                String withdrawUserName = sc.next().trim();

                System.out.printf("Withdraw MemberEmail: ");
                String withdrawEmail = sc.next().trim();

                withdrawMember(withdrawUserName, withdrawEmail);
                break;
            case "0":
                System.exit(0);
                break;
            default:
                System.out.println("Error : known " + input);
        }
    }

    private void withdrawMember(String withdrawUserName, String withdrawEmail) {
        List<Member> list = getMemberList();
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getUserName().equals(withdrawUserName)){
                if (list.get(i).getEmail().equals(withdrawEmail)){
                    list.remove(i);
                    System.out.println("success withdrawal ");
                    return;
                } else {
                    System.out.println("fail withdrawal");
                    return;
                }
            }
        }
    }

    private void updateUser(Member newMember) {
        getMemberList().add(newMember);
    }

    private void printMemberList() {
        getMemberList().forEach(member ->
                System.out.println(member));
    }

    private List<Member> getMemberList() {
        return MemberList;
    }

    private void addBookStock(String addTitle, int addStock) {
        List<Book> list = getbookList();
        for (int i = 0; i < list.size(); i++){
            if(list.get(i).getTitle().equals(addTitle)){
                list.get(i).setStock(list.get(i).getStock() + addStock);
                System.out.printf(addTitle + "의 재고를 " + addStock + "권 추가하였습니다.");
            }
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
//            }                                 // 음수가 나오지 않게 하기! 지금은 stock이 -가 나옴
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