package menu;

import database.AnalystTable;
import user.IUser;
import user.User;
import user.analyst.Analyst;
import user.employee.Employee;

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

    public static void createMenu() throws Exception {
        System.out.print("First name: ");
        String firstName = input.next();
        System.out.print("Last name: ");
        String lastName = input.next();
        System.out.print("Email: ");
        String email = input.next();
        System.out.print("Username: ");
        String userName = input.next();
        System.out.print("Analyst: ");
        boolean isAnalyst = input.nextBoolean();

        if(isAnalyst){
            Analyst analyst = new Analyst(firstName, lastName, email, userName);
            analyst.create();
            return;
        }

        System.out.print("Branch: ");
        String branch = input.next();
        System.out.print("Ip address: ");
        String ipAddress = input.next();

        Employee employee = new Employee(firstName, lastName, email, userName, ipAddress, branch);
        employee.create();
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

    public static void updateMenu() {
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
}
