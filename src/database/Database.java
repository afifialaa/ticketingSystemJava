package database;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Database {

    private static String databaseURL;
    private static String user;
    private static String password;
    public  static Connection con;

    public void setDatabase(String databaseURL){
        databaseURL = databaseURL;
    }

    private String getDatabaseURL(){
        return databaseURL;
    }

    public void setUser(String user){
        user = user;
    }

    public String getUser(){
        return user;
    }

    public void setPassword(String password){
        password = password;
    }

    public String getPassword(){
        return password;
    }

    private static void init() throws IOException {
        Properties devProp = new Properties();
        try (FileReader in = new FileReader("/Users/alaaafifi/Projects/ticketingSystem/src/com/company/dev.properties")) {
            devProp.load(in);
        }
        // Setting variables
        databaseURL = devProp.getProperty("devdburl");
        user = devProp.getProperty("devdbuser");
        password = devProp.getProperty("devdbpassword");
    }

    /* Establishes a connection to database */
    public static void connect() throws Exception{
        init();
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(databaseURL,user,password);
        System.out.println("Connection to database is established");
    }

    /**
     *  Closes database connection
     *  */
    public static void close() throws Exception{
        con.close();
        System.out.println("Connection to database is terminated");
    }

    /**
     * Creates a table
     * */
    public static void createTable(String schema){
        try{
            Statement statement = con.createStatement();
            statement.executeUpdate(schema);
            System.out.println("table was created");
        } catch (SQLException ex){
            System.out.println("An error has occured on Table Creation");
            ex.printStackTrace();
        }
    }

    public static void createDB() throws Exception{
        Statement statement = con.createStatement();
        int res = statement.executeUpdate("CREATE DATABASE ticketing_system");
        System.out.println(res);
    }
}
