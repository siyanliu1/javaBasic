import java.util.Scanner;

public class MaxNumberOccurrence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxNumber = Integer.MIN_VALUE;
        int count = 0;

        System.out.print("Enter numbers: ");

        try {
            while (true) {
                int num = scanner.nextInt(); // 读取输入

                if (num == 0) {
                    break; // 遇到 0 结束输入
                }

                if (num > maxNumber) {
                    maxNumber = num;
                    count = 1; // 重置计数
                } else if (num == maxNumber) {
                    count++; // 计数增加
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter only integers.");
        } finally {
            scanner.close(); // 关闭 scanner
        }

        if (maxNumber != Integer.MIN_VALUE) {
            System.out.println("The largest number is " + maxNumber);
            System.out.println("The occurrence count of the largest number is " + count);
        } else {
            System.out.println("No valid numbers were entered.");
        }
    }
}
