package user.employee;

import database.EmployeeTable;
import user.User;

public class Employee extends User {
    private String ipAddress;
    private String branch;

    public Employee() {}


    public Employee(String firstName, String lastName, String email, String userName){
        super(firstName, lastName, email, userName);
    }

    public Employee(String firstName, String lastName, String email, String userName, String ipAddress, String branch){
        super(firstName, lastName, email, userName);
        this.ipAddress = ipAddress;
        this.branch = branch;
    }

    public void setIpAddress(String ipAddress){
        this.ipAddress = ipAddress;
    }

    public String getIpAddress(){
        return this.ipAddress;
    }

    public void setBranch(String branch){
        this.branch = branch;
    }

    public String getBranch() {
        return this.branch;
    }

    public void create() throws Exception {
        EmployeeTable.create(this);
    }

    public void update() throws Exception {

    }

    public void delete() throws Exception{
        EmployeeTable.delete(userName);
    }

    public Employee read() throws Exception {
        return EmployeeTable.read(this.userName);
    }
}