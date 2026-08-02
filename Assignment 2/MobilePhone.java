class MobilePhone {
    String brand;
    String model;
    double price;
    MobilePhone() {
        brand = "Unknown";
        model = "Unknown";
        price = 0;
    }
    MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
    MobilePhone(MobilePhone mobile) {
        brand = mobile.brand;
        model = mobile.model;
        price = mobile.price;
    }
    void display() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
    }
    public static void main(String[] args) {
        MobilePhone m1 = new MobilePhone();
        MobilePhone m2 = new MobilePhone("Samsung", "Galaxy S24", 74999);
        MobilePhone m3 = new MobilePhone(m2);
        System.out.println("Mobile 1:");
        m1.display();
        System.out.println();
        System.out.println("Mobile 2:");
        m2.display();
        System.out.println();
        System.out.println("Duplicate Mobile Record:");
        m3.display();
    }
}



