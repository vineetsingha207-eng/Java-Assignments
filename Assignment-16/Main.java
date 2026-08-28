import java.util.Scanner;

class AgeException extends Exception {
    AgeException(String message) {
        super(message);
    }
}

public class Main {

    static void checkAge(int age) throws AgeException {
        if (age < 18) {
            throw new AgeException("You are not eligible for voting");
        }

        System.out.println("You are eligible for voting");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter your age: ");
            int age = sc.nextInt();

            checkAge(age);
        } catch (AgeException e) {
            System.out.println(e.getMessage());
        }

        sc.close();
    }
}