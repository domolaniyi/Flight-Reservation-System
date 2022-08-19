package com.example.test;

public class Admin {

    private String fName;
    private String lName;
    private String userName;
    private String password;


    public Admin(String fName, String lName, String userName, String password) {
        this.fName = fName;
        this.lName = lName;
        this.userName = userName;
        this.password = password;
    }


    public String getfName() {
        return fName;
    }

    public String getlName() {
        return lName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
