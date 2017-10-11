package Part_A.UnitTesting;

public class SalaryComponent {

    // this class is used for storing the information of a salary component
    private String component_name; // name of the salary component
    private int amount;         // amount earned for this component

    // Constructor
    public SalaryComponent(String name, int amount) throws RuntimeException {
        // check that the parameters are valid
        if (name == null || name.equals("") || amount < 0 || amount > 10000)
            throw new RuntimeException("Illegal inputs for Salary Component");

        // store the salary component name and the amount earned
        // Enter your code here
        this.component_name = name;
        this.amount = amount;
    }

    // method to get the name of the salary component
    public String getComponentName() {
        return component_name;
    }

    // method to get the amount earned for the salary component
    public int getComponentAmount() {
        return amount;
    }
}
