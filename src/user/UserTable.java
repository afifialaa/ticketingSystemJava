package user;

import database.Database;

import java.sql.PreparedStatement;

public class UserTable{

    // Creates user table
    public static void createTable(){
        // User schema
         String userSchema = "CREATE TABLE user ("
                 + "id INTEGER KEY NOT NULL AUTO_INCREMENT,"
                + "firstName VARCHAR(32),"
                + "lastName VARCHAR(32),"
                + "email VARCHAR(32),"
                + "userName varchar(8)"
                + ");";

        Database.createTable(userSchema);
    }


    // Inserts a user
    public static void createUser(User user) throws Exception{
        // Insert statement
        String query = " insert into user (firstName, lastName, email, userName)"
                + " values (?, ?, ?, ?)";

        /* Create the mysql insert prepared statement */
        PreparedStatement preparedStmt = Database.con.prepareStatement(query);
        preparedStmt.setString (1, user.firstName);
        preparedStmt.setString (2, user.lastName);
        preparedStmt.setString   (3, user.email);
        preparedStmt.setString(4, user.userName);
        preparedStmt.execute();
        System.out.println("User was created");
    }
}
