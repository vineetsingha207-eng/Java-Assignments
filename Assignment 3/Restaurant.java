class Restaurant {
    static int totalOrders = 0;

    static double calculateBill(double foodAmount, double tax) {
        totalOrders++;
        return foodAmount + tax;
    }

    static double calculateBill(double foodAmount, double tax, double packingCharge) {
        totalOrders++;
        return foodAmount + tax + packingCharge;
    }

    static double calculateBill(double foodAmount, double tax, double packingCharge, double deliveryCharge) {
        totalOrders++;
        return foodAmount + tax + packingCharge + deliveryCharge;
    }

    public static void main(String[] args) {
        double dineInBill = calculateBill(500, 50);
        double takeawayBill = calculateBill(500, 50, 30);
        double deliveryBill = calculateBill(500, 50, 30, 50);

        System.out.println("Dine-in Bill: " + dineInBill);
        System.out.println("Takeaway Bill: " + takeawayBill);
        System.out.println("Delivery Bill: " + deliveryBill);
        System.out.println("Total Orders: " + totalOrders);
    }
}
