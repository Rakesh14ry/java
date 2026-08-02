
class Calculator {

    
    static int count = 0;

    
    void add(int a, int b) {
        System.out.println("Integer Addition = " + (a + b));
        count++;
    }

    
    void add(double a, double b) {
        System.out.println("Decimal Addition = " + (a + b));
        count++;
    }

    public static void main(String[] args) {

        Calculator c = new Calculator();

        c.add(10, 20);
        c.add(12.5, 7.5);

        System.out.println("Total Calculations = " + Calculator.count);
    }
}