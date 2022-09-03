package com.onlinejava.project.bookstore;

public class Member {
    private String userName;
    private String email;
    private String phonenNumber;


    public Member(String userName, String Email, String phonenNumber) {
        this.userName = userName;
        email = Email;
        this.phonenNumber = phonenNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenNumber() {
        return phonenNumber;
    }

    public void setPhonenNumber(String phonenNumber) {
        this.phonenNumber = phonenNumber;
    }

    @Override
    public String toString() {
        return "Member{" +
                "userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", phonenNumber='" + phonenNumber + '\'' +
                '}';
    }
}
