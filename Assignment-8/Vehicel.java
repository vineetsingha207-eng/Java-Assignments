class Vehicle {
    String vehicleName = "Honda City";
    int year = 2024;

    void display() {
        System.out.println("Vehicle: " + vehicleName);
        System.out.println("Year: " + year);
    }
}

class CarInsurance extends Vehicle {
    String insurance = "Car Insurance";

    void display() {
        System.out.println("Insurance: " + insurance);
        System.out.println("Vehicle: " + super.vehicleName);
        System.out.println("Year: " + super.year);
    }
}

class BikeInsurance extends Vehicle {
    String insurance = "Bike Insurance";

    void display() {
        System.out.println("Insurance: " + insurance);
        System.out.println("Vehicle: " + super.vehicleName);
        System.out.println("Year: " + super.year);
    }
}

class Main {
    public static void main(String[] args) {
        CarInsurance c = new CarInsurance();
        BikeInsurance b = new BikeInsurance();

        c.display();
        b.display();
    }
}
