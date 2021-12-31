package com.company;

import database.Database;
import user.UserTable;
import userMenu.UserMenu;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception{

        Database.connect();
         displayHomeMenu();
    }

    public static void displayHomeMenu() throws Exception {

        System.out.println("1) User");
        System.out.println("2) Ticket");

        String choice = input.next();

        switch (choice){
            case "1":
                UserMenu.userMenuHome();
        }
    }
}
