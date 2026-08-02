class Calculator {
    static int calculationCount = 0;
    static int add(int a, int b) {
        calculationCount++;
        return a + b;
    }
    static double add(double a, double b) {
        calculationCount++;
        return a + b;
    }
    public static void main(String[] args) {
        int result1 = add(10, 20);
        double result2 = add(10.5, 20.5);
        System.out.println("Addition of integers: " + result1);
        System.out.println("Addition of decimals: " + result2);
        System.out.println("Total calculations: " + calculationCount);
    }
}
