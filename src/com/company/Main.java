package com.company;

import database.Database;
import menu.TicketMenu;
import menu.UserMenu;

import java.util.Scanner;

public class Main {

    private static final Scanner  input = new Scanner(System.in);

    public static void main(String[] args) throws Exception{

        Database.connect();
        // UserTable.createTable();
        displayHomeMenu();
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
