package Part_A.UnitTesting;

import java.util.*;

// Employee class holds the data about an employee's salary
public class Employee {
    private String name;           // name of the employee
    private String number;         // Employee number
    private Vector salary_components;  // salary components earned by the employee

    // Constructor
    public Employee(String nm, String no) throws RuntimeException {
        // check that the parameters are valid
        // Enter your code here
        if (nm == null) {
            throw new RuntimeException("Invalid employee name");
        }

        if (no == null) {
            throw new RuntimeException("Invalid employee number");
        }

        // store the employee's name and number
        // Enter your code here
        this.name = nm;
        this.number = no;

        // initialize the vector that will store the employee's salary
        salary_components = new Vector();
    }

    // method to get the employee's name
    public String getEmpName() {
        return name;
    }

    // method to get the employee number
    public String getEmpNumber() {
        return number;
    }

    // method to assign salary earned for a particular salary component
    public void assignSalary(String component, int amount) throws RuntimeException {

        SalaryComponent c = new SalaryComponent(component, amount);
        salary_components.addElement(c);
    }

    // method to return the amount earned for a particular salary component
    public int getSalary(String component) throws RuntimeException {
        // check the inputs
        if (component == null)
            throw new RuntimeException("Invalid salary component name");

        // find the salary component
        for (Enumeration e = salary_components.elements(); e.hasMoreElements();) {
            SalaryComponent c = (SalaryComponent) e.nextElement();

            if (component.equals(c.getComponentName()))
                return c.getComponentAmount();
        }

        // if component does not exist, throw exception
        throw new RuntimeException("Salary Component " + component + " does not exist");
    }

    // method to find the total pay from all the salary components earned by an employee
    public int getTotalPay() {
        int totalPay = 0;

        // if the employee has earned any salary (for example, for a new employee), return 0
        if (salary_components.isEmpty()) {
            throw new RuntimeException("No salary records exist for " + this.getEmpName());
        } else {
            // otherwise, find the total pay
            // Enter your code here
            for (Enumeration e = salary_components.elements(); e.hasMoreElements();) {
                SalaryComponent c = (SalaryComponent) e.nextElement();

                totalPay += c.getComponentAmount();
            }

        }

        return totalPay;
    }
}


