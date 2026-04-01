package lab5.advanced;

public class Lab5Adv {
    static void main() {
        NewIntCalculator intCalc = new NewIntCalculator(10);
        int resInt = (Integer) intCalc.add(5).subtract(3).multiply(2).result();
        System.out.println("Rezultat Integer: " + resInt);

        DoubleCalculator doubleCalc = new DoubleCalculator(10.0);
        double resDouble = (Double) doubleCalc.add(5.0).subtract(3.3).multiply(2.2).result();
        System.out.println("Rezultat Double: " + resDouble);


    }
}
