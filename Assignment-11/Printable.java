interface Printable {
    void print();
}

class Student implements Printable {
    void display() {
        System.out.println("Student Details");
    }

    public void print() {
        System.out.println("Student is printing");
    }
}

class Employee implements Printable {
    void display() {
        System.out.println("Employee Details");
    }

    public void print() {
        System.out.println("Employee is printing");
    }
}

class Main {
    public static void main(String[] args) {
        Student s = new Student();
        Employee e = new Employee();

        s.display();
        s.print();

        e.display();
        e.print();
    }
}
