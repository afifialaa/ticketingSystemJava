package database;

import user.User;
import user.employee.Employee;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeTable {

    public static void create(Employee user) throws Exception{
        // Insert statement
        String query = "INSERT INTO user (firstName, lastName, email, userName, ipAddress, branch)"
                + " VALUES (?, ?, ?, ?, ?, ?)";

        /* Create the mysql insert prepared statement */
        PreparedStatement preparedStmt = Database.con.prepareStatement(query);
        preparedStmt.setString(1, user.getFirstName());
        preparedStmt.setString(2, user.getLastName());
        preparedStmt.setString(3, user.getEmail());
        preparedStmt.setString(4, user.getUserName());
        preparedStmt.setString(5, user.getIpAddress());
        preparedStmt.setString(6, user.getBranch());
        preparedStmt.execute();
        System.out.println("User was created");
    }

    public static void delete(String userName) throws Exception{
        String query = "DELETE FROM user WHERE userName = ?;";
        PreparedStatement preparedStmt = Database.con.prepareStatement(query);
        preparedStmt.setString(1, userName);
        preparedStmt.execute();
        System.out.println("User was deleted");
    }

    public static void deleteByEmail(String email) throws Exception{
        String query = "DELETE FROM user WHERE email = ?;";
        PreparedStatement preparedStmt = Database.con.prepareStatement(query);
        preparedStmt.setString(1, email);
        preparedStmt.execute();
        System.out.println("User was deleted");
    }

    public static Employee read(String userName) throws Exception{
        String query = "SELECT * FROM user WHERE username = ?";
        PreparedStatement preparedStmt = Database.con.prepareStatement(query);
        preparedStmt.setString(1, userName);
        ResultSet res = preparedStmt.executeQuery();
        Employee employee = new Employee();
        while(res.next()){
            employee.setFirstName(res.getString("firstName"));
            employee.setLastName(res.getString("lastName"));
            employee.setEmail(res.getString("email"));
            employee.setUserName(res.getString("userName"));
            employee.setIpAddress(res.getString("ipAddress"));
            employee.setBranch(res.getString("branch"));
            // Breaking to select first item in the result set
            break;
        }
        return employee;
    }

    public static void update() throws Exception{

    }

    public static User readByEmail(String email) throws Exception{
        String query = "SELECT * FROM user WHERE email = ?";
        PreparedStatement preparedStmt = Database.con.prepareStatement(query);
        preparedStmt.setString(1, email);
        ResultSet res = preparedStmt.executeQuery();
        Employee employee = new Employee();
        while(res.getRow() == 0){
            employee.setFirstName(res.getString("firstName"));
            employee.setLastName(res.getString("lastName"));
            employee.setEmail(res.getString("email"));
            employee.setUserName(res.getString("userName"));
            break;
        }
        return employee;
    }
}
