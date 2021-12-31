package menu.ticketMenu;

import ticket.Ticket;

import java.util.Scanner;

public class TicketMenu {

    private static final Scanner input = new Scanner(System.in);

    public static void ticketMenuHome() throws Exception {
        System.out.println("1) Create ticket");
        System.out.println("2) Read ticket");
        System.out.println("3) Update ticket");
        System.out.println("4) Delete ticket");

        String choice = input.next();
        switch (choice) {
            case "1" -> createMenu();
            case "2" -> readMenu();
            case "3" -> updateMenu();
            case "4" -> deleteMenu();
        }
    }

    public static void createMenu() throws Exception {
        System.out.println("Username: ");
        String empUserName = input.next();
        System.out.println("Ip address: ");
        String ipAddress = input.next();
        input.nextLine();
        System.out.println("Details: ");
        String details = input.nextLine();

        Ticket ticket = new Ticket(empUserName, ipAddress, details);
        ticket.create();
    }

    public static void deleteMenu() throws Exception {
        Ticket ticket = new Ticket();
        System.out.println("Enter ticket number: ");
        int id = input.nextInt();
        ticket.setId(id);
        ticket.delete();
    }

    public static void updateMenu(){

    }

    public static void readMenu(){

    }
}
