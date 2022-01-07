package com.company;

import database.Database;
import database.UserTable;
import menu.TicketMenu;
import menu.UserMenu;
import user.User;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    private static final Scanner  input = new Scanner(System.in);

    public static void main(String[] args) throws Exception{
        System.out.println("Still in development");
    }

    public static void login() throws SQLException {
        User user = new User("afifi123", "afifi12");
        boolean auth = user.login();
        if(auth){
            System.out.println("auth");
        }else{
            System.out.println("not auth");
        }
    }

    public static void displayHomeMenu() throws Exception {

        System.out.println("1) User");
        System.out.println("2) Ticket");

        String choice = input.next();

        switch (choice) {
            case "1" -> UserMenu.userMenuHome();
            case "2" -> TicketMenu.ticketMenuHome();
        }
    }
}
