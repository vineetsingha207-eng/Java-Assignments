class Student {
    String name;
    int rollNo;
    Student() {
        name = "Unknown";
        rollNo = 0;
    }
    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }
    void display() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNo);
    }
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student("Vineet", 101);
        s1.display();
        System.out.println();
        s2.display();
    }
}
