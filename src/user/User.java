package user;

import database.UserTable;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Base64;

public class User implements IUser{
    protected int id;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String userName;
    protected String password;

    public User(){
    }

    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public User(String firstName, String lastName, String email, String userName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
    }

    public User(String userName){
        this.userName = userName;
    }

    public void create() throws Exception {
        UserTable.createUser(this);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void delete() throws Exception{
        UserTable.deleteByUserName(this.userName);
    }

    public void deleteByEmail() throws Exception {
        UserTable.deleteByEmail(this.email);
    }

    public User read() throws Exception{
        return UserTable.readByUserName(this.userName);
    }

    public void readByEmail() throws Exception {
    }

    public void print(){
        System.out.println("Full name: " + this.firstName + " " + this.lastName);
        System.out.println("Email: " + this.email);
        System.out.println("Username: " + this.userName);
    }

    public void setPassword(String password) {
        this.password = hashPassword(password);
    }

    public String getPassword(){
        return password;
    }

    /**
     * Hashes password
     * @return
     */
    protected String hashPassword(String password){
        try{
            byte[] salt = new byte[16];

            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt);

            byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedPassword) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }

            // Get complete hashed password in hex format
            return sb.toString();
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
            System.out.println("No such hashing algorithm");
        }

        return "";
    }

    /**
     * Updated user password
     * @return boolean
     */
    public boolean updatePassword(){
        setPassword(password);
        return UserTable.updatePassword(this);
    }

    public boolean login() throws SQLException {
        // Hash password to be compared to stored password
        setPassword(this.password);
        return UserTable.login(this);
    }
}
