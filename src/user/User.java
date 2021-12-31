package user;

import database.UserTable;

public class User {
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String userId;
    protected String userName;

    public User(){
    }

    public User(String firstName, String lastName, String email, String userId, String userName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userId = userId;
        this.userName = userName;
    }

    public User(String userName){
        this.userName = userName;
    }

    public void createUser() throws Exception {
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
}
