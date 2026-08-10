abstract class FoodOrder {
    double price = 500;

    abstract void calculateBill();
}

class DineInOrder extends FoodOrder {
    void calculateBill() {
        double total = price + 50;
        System.out.println("Dine In Bill: Rs." + total);
    }
}

class TakeAwayOrder extends FoodOrder {
    void calculateBill() {
        double total = price + 20;
        System.out.println("Take Away Bill: Rs." + total);
    }
}

class Main {
    public static void main(String[] args) {
        DineInOrder d = new DineInOrder();
        TakeAwayOrder t = new TakeAwayOrder();

        d.calculateBill();
        t.calculateBill();
    }
}
