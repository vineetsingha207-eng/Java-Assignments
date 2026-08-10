interface Delivery {
    void status();
}

class FoodDelivery {
    String order = "Pizza";
    int orderId = 101;

    class OrderDetails {
        void display() {
            System.out.println("Order ID: " + orderId);
            System.out.println("Food: " + order);
        }
    }

    void deliveryStatus() {
        Delivery d1 = new Delivery() {
            public void status() {
                System.out.println("Order is being prepared.");
            }
        };

        Delivery d2 = new Delivery() {
            public void status() {
                System.out.println("Order is out for delivery.");
            }
        };

        d1.status();
        d2.status();
    }

    public static void main(String[] args) {
        FoodDelivery f = new FoodDelivery();

        FoodDelivery.OrderDetails o = f.new OrderDetails();
        o.display();

        f.deliveryStatus();
    }
}

