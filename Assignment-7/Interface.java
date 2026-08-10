interface Product {
    void display();
}
class Electronic implements Product {
    String name = "Laptop";
    int price = 50000;

    public void display() {
        System.out.println("Electronic: " + name);
        System.out.println("Price: Rs." + price);
    }
}
class Clothing implements Product {
    String name = "T-Shirt";
    int price = 800;

    public void display() {
        System.out.println("Clothing: " + name);
        System.out.println("Price: Rs." + price);
    }
}
class Grocery implements Product {
    String name = "Rice";
    int price = 500;

    public void display() {
        System.out.println("Grocery: " + name);
        System.out.println("Price: Rs." + price);
    }
}
class Main {
    public static void main(String[] args) {
        Electronic e = new Electronic();
        Clothing c = new Clothing();
        Grocery g = new Grocery();

        e.display();
        c.display();
        g.display();
    }
}

