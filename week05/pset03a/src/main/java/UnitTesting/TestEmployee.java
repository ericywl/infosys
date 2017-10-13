package UnitTesting;

import junit.framework.*;

public class TestEmployee extends TestCase {
    // constructor
    public TestEmployee(String name) {
        super(name);
    }

    // method to test the constructor of the Employee class
    public void testConstructor() {
        String employee_name = "John Doe";
        String employee_no = "1234567";

        // create a new employee
        Employee emp  = new Employee(employee_name, employee_no);

        // verify that the employee object is constructed properly
        assertEquals("employee name wrong", employee_name, emp.getEmpName());
        assertTrue("employee no. wrong", emp.getEmpNumber().equals(employee_no));

        // test invalid inputs - null emp no and null emp name
        try {
            Employee e = new Employee("Peter Brown", null);
            fail("Constructor allows null employee number");
        } catch (RuntimeException e) {
            // do nothing
        }

        try {
            Employee e = new Employee(null, "9876543");
            fail("Constructor allows null employee name");
        } catch (RuntimeException e) {
            // do nothing
        }
    }

    // method to test the assigning and retrieval of salary components
    public void testAssignAndRetrieveSalaryComponents() {
        // create an employee
        Employee emp  = new Employee("James Watson", "2345678");

        // assign a few salary components to this employee
        emp.assignSalary("Basic", 2000);
        emp.assignSalary("Overtime", 500);
        emp.assignSalary("Medical", 350);

        // verify that the assignment is correct
        assertTrue("fail to assign Basic component", emp.getSalary("Basic") == 2000);
        assertTrue("fail to assign Medical component", emp.getSalary("Medical") == 350);

        // attempt to retrieve a salary component that does not exist
        try {
            emp.getSalary("Transportation");
            fail("fail to catch non-existent salary component ");
        } catch (RuntimeException e) {
            // do nothing
        }
    }


    // method to test if the total pay is correct
    public void testCalculationOfTotalPay() {
        // create an employee
        Employee emp  = new Employee("John Doe", "1234567");

        // assign a few salary components to this employee
        emp.assignSalary("Basic", 2000);
        emp.assignSalary("Overtime", 500);
        emp.assignSalary("Medical", 350);

        // verify that the total pay calculation is correct
        assertTrue("fail to calculate total pay ", emp.getTotalPay() == 2850);

        // attempt to retrieve calculate total pay for an employee that has no salary components
        try {
            Employee emp2 = new Employee("Tommy Anderson", "3456789");

            emp2.getTotalPay();
            fail("fail to catch non-existent salary component ");
        } catch (RuntimeException e) {
            // do nothing
        }
    }


    // method create a test suite
    public static Test suite() {
        return new TestSuite(TestEmployee.class);
    }

    // the main method
    public static void main(String args[]) {
        junit.textui.TestRunner.run(suite());
    }
}
