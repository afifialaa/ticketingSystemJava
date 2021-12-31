package ticket;

public class Ticket {
    private String number;
    private String employeeUserName;
    private String analystUserName;

    private int priority;

    public Ticket(String number, String employeeUserName, String analystUserName){
        this.number = number;
        this.employeeUserName = employeeUserName;
        this.analystUserName = analystUserName;
    }

    public String getNumber() {
        return  number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
