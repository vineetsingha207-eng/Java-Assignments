
interface Action {
    void perform();
}

class Vehicle {
    String name = "Honda City";
    String number = "MH12AB1234";

    class Details {
        void display() {
            System.out.println("Vehicle Name: " + name);
            System.out.println("Vehicle Number: " + number);
        }
    }

    void action() {
        Action a = new Action() {
            public void perform() {
                System.out.println("Vehicle is starting.");
            }
        };
        a.perform();
    }

    public static void main(String[] args) {
        Vehicle v = new Vehicle();

        Vehicle.Details d = v.new Details();
        d.display();

        v.action();
    }
}

