class Employee {
    String name = "Rahul";
    int salary = 30000;

    void display() {
        System.out.println("Employee Name: " + name);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee {
    String name = "Amit";
    int salary = 50000;

    void display() {
        System.out.println("Manager Name: " + name);
        System.out.println("Manager Salary: " + salary);
        System.out.println("Employee Name: " + super.name);
        System.out.println("Employee Salary: " + super.salary);
    }
}

class Main {
    public static void main(String[] args) {
        Manager m = new Manager();
        m.display();
    }
}

