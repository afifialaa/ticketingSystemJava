package database;

import ticket.Ticket;
import user.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TicketTable {

    // Creates ticket table
    public static void createTable(){
        // Ticket schema
        String ticketSchema = "CREATE TABLE ticket ("
                + "id INTEGER KEY NOT NULL AUTO_INCREMENT,"
                + "empUserName VARCHAR(32),"
                + "analystUserName VARCHAR(32),"
                + "ipAddress VARCHAR(32),"
                + "details VARCHAR(256),"
                + "resolved boolean DEFAULT false"
                + ");";

        Database.createTable(ticketSchema);
    }

    // Creates a ticket
    public static void create(Ticket ticket)throws Exception{
        // Insert statement
        String query = "INSERT INTO ticket (empUserName, ipAddress, details)"
                + " VALUES (?, ?, ?)";

        /* Create the mysql insert prepared statement */
        PreparedStatement preparedStmt = Database.con.prepareStatement(query);
        preparedStmt.setString (1, ticket.getEmployeeUserName());
        preparedStmt.setString (2, ticket.getIpAddress());
        preparedStmt.setString (3, ticket.getDetails());
        preparedStmt.execute();
        System.out.println("Ticket was created");
    }

    // Deletes a ticket
    public static void delete(int id) throws Exception{
        String query = "DELETE FROM ticket WHERE id = ?";

        /* Create the mysql insert prepared statement */
        PreparedStatement preparedStmt = Database.con.prepareStatement(query);
        preparedStmt.setInt (1, id);
        preparedStmt.execute();
        System.out.println("Ticket was deleted");
    }

    public static Ticket read(int id) throws Exception{
        String query = "DELETE FROM ticket WHERE id = ?";

        /* Create the mysql insert prepared statement */
        PreparedStatement preparedStmt = Database.con.prepareStatement(query);
        preparedStmt.setInt (1, id);
        ResultSet res = preparedStmt.executeQuery();
        Ticket ticket = new Ticket();

        while(res.getRow() == 0){
            ticket.setId(res.getInt("id"));
            ticket.setEmployeeUserName(res.getString("empUserName"));
            ticket.setAnalystUserName(res.getString("analystUserName"));
            ticket.setIpAddress(res.getString("ipAddress"));
            ticket.setResolved(res.getBoolean("ipAddress"));
            break;
        }

        return ticket;
    }
}
