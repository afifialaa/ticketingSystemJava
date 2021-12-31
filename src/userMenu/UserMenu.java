package userMenu;

import user.User;

import java.util.Scanner;

public class UserMenu {

    private static Scanner input = new Scanner(System.in);

    public static void userMenuHome() throws Exception {
        System.out.println("1) Create user");
        System.out.println("2) Read user");
        System.out.println("3) Update user");
        System.out.println("4) Delete user");

        String choice = input.next();
        switch (choice){
            case "1":
                createUserMenu();
        }
    }

    public static void createUserMenu() throws Exception {
        System.out.print("First name: ");
        String firstName = input.next();
        System.out.print("Last name: ");
        String lastName = input.next();
        System.out.print("Email: ");
        String email = input.next();
        System.out.print("ID ");
        String id = input.next();
        System.out.print("Username: ");
        String userName = input.next();

        User user = new User(firstName, lastName, email, id, userName);
        user.createUser();
    }
}
