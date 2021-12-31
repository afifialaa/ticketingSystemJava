package menu.userMenu;

import user.User;
import java.util.Scanner;

public class UserMenu {

    private static final Scanner input = new Scanner(System.in);

    public static void userMenuHome() throws Exception {
        System.out.println("1) Create user");
        System.out.println("2) Read user");
        System.out.println("3) Update user");
        System.out.println("4) Delete user");

        String choice = input.next();
        switch (choice) {
            case "1" -> createMenu();
            case "2" -> readMenu();
            case "4" -> deleteMenu();
        }
    }

    public static void readMenu() throws Exception {
        User user = new User();
        System.out.println("Search by 1) username 2) email");
        String choice = input.next();
        switch (choice){
            case "1" -> {
                System.out.println("Username: ");
                String userName = input.next();
                user.setUserName(userName);
                user = user.read();
                user.print();
            }
            case "2" -> {
                System.out.println("Email: ");
                String email = input.next();
                user.setEmail(email);
                user.readByEmail();
                user.print();
            }
        }
    }

    public static void deleteMenu() throws Exception{
        User user = new User();
        System.out.println("Delete by: 1) username 2) email");
        String choice = input.next();
        switch (choice) {
            case "1" -> {
                System.out.println("Enter username: ");
                String userName = input.next();
                user.setUserName(userName);
                user.delete();
            }
            case "2" -> {
                System.out.println("Enter email: ");
                String email = input.next();
                user.setEmail(email);
                user.deleteByEmail();
            }
        }
    }

    public static void createMenu() throws Exception {
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

    public static void updateMenu() {
    }
}
