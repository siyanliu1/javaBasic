public class SquareCubeCalculator {
    public static void main(String[] args) {
        // Print table header
        System.out.println("number\t square\t cube");

        // Loop from 0 to 10 and compute square and cube
        for (int i = 0; i <= 10; i++) {
            int square = i * i;         // Calculate square
            int cube = i * i * i;       // Calculate cube
            System.out.println(i + "\t " + square + "\t " + cube);
        }
    }
}
