public class EmployeeData {
    private String id = "";
    private String employeename = "";
    private String salary = "";
    private String employeerole = "";

    public EmployeeData(String id, String employeename, String salary, String employeerole) {
        this.id = id;
        this.employeename = employeename;
        this.salary = salary;
        this.employeerole = employeerole;
    }

    public String getId() {
        return id;
    }

    public String getEmployeename() {
        return employeename;
    }
    public String getSalary() {
        return salary;
    }
    public String getEmployeerole() {
        return employeerole;
    }
}
