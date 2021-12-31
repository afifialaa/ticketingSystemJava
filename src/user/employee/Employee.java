package user.employee;

import user.User;

public class Employee extends User {
    private String position;
    private String ipAddress;
    private String branch;

    public Employee(String firstName, String lastName, String email, String id, String userName) {
        super(firstName, lastName, email, id, userName);
    }

    public void setPosition(String position){
        this.position = position;
    }

    public String getPosition(){
        return this.position;
    }

    public void setIpAddress(String ipAddress){
        this.ipAddress = ipAddress;
    }

    public String getIpAddress(){
        return this.ipAddress;
    }

    public void branch(String branch){
        this.branch = branch;
    }

    public String getBranch() {
        return this.branch;
    }
}
