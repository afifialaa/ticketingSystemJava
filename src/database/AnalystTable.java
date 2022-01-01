package database;

import user.User;
import user.analyst.Analyst;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AnalystTable {

    /**
     * Inserts an analyst into the database
     * @param user
     * @throws Exception
     */
    public static void create(Analyst user) throws Exception{
        // Insert statement
        String query = "INSERT INTO user (firstName, lastName, email, userName, analyst)"
                + " VALUES (?, ?, ?, ?, ?)";

        /* Create the mysql insert prepared statement */
        PreparedStatement preparedStmt = Database.con.prepareStatement(query);
        preparedStmt.setString (1, user.getFirstName());
        preparedStmt.setString (2, user.getLastName());
        preparedStmt.setString   (3, user.getEmail());
        preparedStmt.setString(4, user.getUserName());
        preparedStmt.setBoolean(5, user.getAnalyst());
        preparedStmt.execute();
        System.out.println("User was created");
    }

    /**
     * Reads an analyst from the database
     * @param userName
     * @return an analyst
     * @throws Exception
     */
    public static Analyst read(String userName) throws Exception{
        String query = "SELECT * FROM user WHERE username = ?";
        PreparedStatement preparedStmt = Database.con.prepareStatement(query);
        preparedStmt.setString(1, userName);
        ResultSet res = preparedStmt.executeQuery();
        Analyst analyst = new Analyst();
        while(res.next()){
            analyst.setFirstName(res.getString("firstName"));
            analyst.setLastName(res.getString("lastName"));
            analyst.setEmail(res.getString("email"));
            analyst.setUserName(res.getString("userName"));
            analyst.setAnalyst(res.getBoolean("analyst"));
            // Breaking to select first item in the result set
            break;
        }
        return analyst;
    }

    /**
     * Updates an analyst
     * @throws Exception
     */
    public static void update() throws Exception{

    }

    /**
     * Deletes an analyst by username
     * @param userName
     * @throws Exception
     */
    public static void delete(String userName) throws Exception{
        String query = "DELETE FROM user WHERE userName = ?;";
        PreparedStatement preparedStmt = Database.con.prepareStatement(query);
        preparedStmt.setString(1, userName);
        preparedStmt.execute();
        System.out.println("User was deleted");
    }

    /**
     * Deletes an analyst by email
     * @param email
     * @throws Exception
     */
    public static void deleteByEmail(String email) throws Exception{
        String query = "DELETE FROM user WHERE email = ?;";
        PreparedStatement preparedStmt = Database.con.prepareStatement(query);
        preparedStmt.setString(1, email);
        preparedStmt.execute();
        System.out.println("User was deleted");
    }

    /**
     * Reads an analyst by email
     * @param email
     * @return an analyst
     * @throws Exception
     */
    public static Analyst readByEmail(String email) throws Exception{
        String query = "SELECT * FROM user WHERE email = ?";
        PreparedStatement preparedStmt = Database.con.prepareStatement(query);
        preparedStmt.setString(1, email);
        ResultSet res = preparedStmt.executeQuery();
        Analyst analyst = new Analyst();
        while(res.getRow() == 0){
            analyst.setFirstName(res.getString("firstName"));
            analyst.setLastName(res.getString("lastName"));
            analyst.setEmail(res.getString("email"));
            analyst.setUserName(res.getString("userName"));
            analyst.setAnalyst(res.getBoolean("analyst"));
            break;
        }
        return analyst;
    }
}
