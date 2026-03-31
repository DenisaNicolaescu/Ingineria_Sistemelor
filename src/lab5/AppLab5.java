package lab5;

public class AppLab5 {
    static void main() {
        IntCalculator calculator = new IntCalculator(10);
        int result = calculator.add(5).subtract(3).multiply(2).result();
        System.out.println("a) " + result);

        AdvancedCalculator avansat = new AdvancedCalculator(10);
        int result2 = avansat.divide(2).power(2).root(2).result();
        System.out.println("b) " + result2);
    }
}
