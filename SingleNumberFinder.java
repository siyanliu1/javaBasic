// The XOR operation (^) has useful properties:
// x ^ x = 0 (any number XORed with itself is 0)
// x ^ 0 = x (any number XORed with 0 remains unchanged)
// XOR is commutative and associative, meaning order does not matter.
// By XORing all numbers together, duplicates cancel out (x ^ x = 0), leaving only the unique number.


public class SingleNumberFinder {
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // XOR operation
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 2, 1};
        System.out.println(singleNumber(nums1)); // Output: 1

        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums2)); // Output: 4
    }
}
