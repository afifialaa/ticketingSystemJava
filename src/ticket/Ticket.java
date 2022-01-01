package ticket;

import database.TicketTable;

public class Ticket {
    private int id;
    private String employeeUserName;
    private String analystUserName;
    private String ipAddress;
    private String details;
    private boolean resolved;

    public Ticket(){

    }

    public Ticket(String employeeUserName, String ipAddress, String details){
        this.employeeUserName = employeeUserName;
        this.ipAddress = ipAddress;
        this.details = details;
    }

    public Ticket(String employeeUserName, String ipAddress){
        this.employeeUserName = employeeUserName;
        this.ipAddress = ipAddress;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getEmployeeUserName() {
        return employeeUserName;
    }

    public void setEmployeeUserName(String employeeUserName) {
        this.employeeUserName = employeeUserName;
    }

    public String getAnalystUserName() {
        return analystUserName;
    }

    public void setAnalystUserName(String analystUserName) {
        this.analystUserName = analystUserName;
    }

    public boolean isResolved() {
        return resolved;
    }

    public void setResolved(boolean resolved) {
        this.resolved = resolved;
    }

    public void create()throws Exception{
        TicketTable.create(this);
    }

    public void delete() throws Exception{
        TicketTable.delete(this.id);
    }
}
