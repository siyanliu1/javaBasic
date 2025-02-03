public class PowerTable {
    public static void main(String[] args) {
        // Print table header
        System.out.println("a\t b\t pow(a, b)");

        // Loop through the given values and compute the power manually
        for (int a = 1, b = 2; a <= 5; a++, b++) {
            int power = calculatePower(a, b);
            System.out.println(a + "\t " + b + "\t " + power);
        }
    }

    // Method to compute power manually
    public static int calculatePower(int base, int exponent) {
        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base; // Multiply base 'exponent' times
        }
        return result;
    }
}
