class TaxUtilHelper{

    public static double calculateTax(double amount, double rate) {
        return amount * rate;
    }
}

public class TaxUtil {
    public static void main(String[] args) {
        double amount = 100.0;
        double rate = 0.15;
        System.out.println("Tax is: " + TaxUtilHelper.calculateTax(amount, rate));  // Tax is: 15.0
    }
}