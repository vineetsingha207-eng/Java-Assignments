import java.util.Scanner;

class EmployeePayroll {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        String idinput = sc.nextLine();

        System.out.print("Enter Basic Salary: ");
        String salaryinput = sc.nextLine();

        System.out.print("Enter Bonus Amount: ");
        String bonusinput = sc.nextLine();

        Integer employeeid = Integer.valueOf(idinput);
        Double basicsalary = Double.valueOf(salaryinput);
        Double bonus = Double.valueOf(bonusinput);

        if (employeeid <= 0) {
            System.out.println("Invalid employee id.");
        } 
        else if (basicsalary < 0) {
            System.out.println("Invalid basic salary.");
        } 
        else if (bonus < 0) {
            System.out.println("Invalid bonus amount.");
        } 
        else {
            Double netsalary = basicsalary + bonus;

            System.out.println("employee ID: " + employeeid);
            System.out.println("basic Salary: " + basicsalary);
            System.out.println("bonus Amount: " + bonus);
            System.out.println("Net Salary: " + netsalary);
        }

        sc.close();
    }
}