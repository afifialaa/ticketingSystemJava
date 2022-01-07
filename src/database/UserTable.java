package database;

import user.IUser;
import user.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserTable{

    /**
     * Creates user table
     */
    public static void createTable(){
        /**
         * User table schema
         */
         String userSchema = "CREATE TABLE user ("
                 + "id INTEGER KEY NOT NULL AUTO_INCREMENT,"
                + "firstName VARCHAR(32),"
                + "lastName VARCHAR(32),"
                + "email VARCHAR(32),"
                + "userName varchar(8),"
                 + "password varchar(256),"
                 + "ipAddress varchar(32),"
                 + "branch varchar(32),"
                 + "analyst boolean DEFAULT false"
                + ");";

        Database.createTable(userSchema);
    }

    /**
     * Creates a new user
     * @param user
     * @throws Exception
     */
    public static void createUser(IUser user) throws Exception{
        // Insert statement
        String query = "INSERT INTO user (firstName, lastName, email, userName, ipAddress, branch, analyst)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?)";

        /* Create the mysql insert prepared statement */
        PreparedStatement preparedStmt = Database.con.prepareStatement(query);
        preparedStmt.setString (1, user.getFirstName());
        preparedStmt.setString (2, user.getLastName());
        preparedStmt.setString   (3, user.getEmail());
        preparedStmt.setString(4, user.getUserName());
        preparedStmt.execute();
        System.out.println("User was created");
    }

    /**
     * Delete a user by username
     * @param userName
     * @throws Exception
     */
    public static void deleteByUserName(String userName) throws Exception{
        String query = "DELETE FROM user WHERE userName = ?;";
        PreparedStatement preparedStmt = Database.con.prepareStatement(query);
        preparedStmt.setString(1, userName);
        preparedStmt.execute();
        System.out.println("user was deleted");
    }

    /**
     * Deletes a user by email
     * @param email
     * @throws Exception
     */
    public static void deleteByEmail(String email) throws Exception{
        String query = "DELETE FROM user WHERE email = ?;";
        PreparedStatement preparedStmt = Database.con.prepareStatement(query);
        preparedStmt.setString(1, email);
        preparedStmt.execute();
        System.out.println("user was deleted");
    }

    public static User readByUserName(String userName) throws Exception{
        String query = "SELECT * FROM user WHERE username = ?";
        PreparedStatement preparedStmt = Database.con.prepareStatement(query);
        preparedStmt.setString(1, userName);
        ResultSet res = preparedStmt.executeQuery();
        User user = new User();
        while(res.next()){
            user.setFirstName(res.getString("firstName"));
            user.setLastName(res.getString("lastName"));
            user.setEmail(res.getString("email"));
            user.setUserName(res.getString("userName"));
            // Breaking to select first item in the result set
            break;
        }
        return user;
    }

    public static User readByEmail(String email) throws Exception{
        String query = "SELECT * FROM user WHERE email = ?";
        PreparedStatement preparedStmt = Database.con.prepareStatement(query);
        preparedStmt.setString(1, email);
        ResultSet res = preparedStmt.executeQuery();
        User user = new User();
        while(res.getRow() == 0){
            user.setFirstName(res.getString("firstName"));
            user.setLastName(res.getString("lastName"));
            user.setEmail(res.getString("email"));
            user.setUserName(res.getString("userName"));
            break;
        }
        return user;
    }

    /**
     * Logs user in
     * @param user
     * @return
     */
    public static boolean login(User user) {
        System.out.println("password: " + user.getPassword());
        System.out.println("username: " + user.getUserName());
        try{
            String query = "select * from user where userName = ? and password = ?";
            PreparedStatement preparedStmt = Database.con.prepareStatement(query);
            preparedStmt.setString(1, user.getUserName());
            preparedStmt.setString(2, user.getPassword());

            ResultSet res = preparedStmt.executeQuery();
            if(res.next()){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            System.out.println("Invalid sql statement");
            ex.printStackTrace();
            System.exit(1);
        }
        return true;
    }

    public static boolean updatePassword(User user){
        try{
            String query = "update user " + "set password = ? where userName = ?";
            PreparedStatement preparedStmt = Database.con.prepareStatement(query);
            preparedStmt.setString(1, user.getPassword());
            preparedStmt.setString(2, user.getUserName());
            preparedStmt.executeUpdate();
            return true;
        }catch(SQLException ex){
            System.out.println("Invalid sql statement");
            ex.printStackTrace();
        }
        return true;
    }
}
