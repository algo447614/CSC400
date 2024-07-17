import java.util.*;

public class mod5 {
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }

        int max = getMax(arr);
        int maxDigits = String.valueOf(max).length();

        System.out.println("Initial array: " + Arrays.toString(arr));
        System.out.println("\nBig-O Analysis:");
        System.out.println("Finding max element: O(n)");
        System.out.println("Number of digits in max element: " + maxDigits);
        System.out.println("We will perform " + maxDigits + " passes through the array.\n");

        for (int exp = 1, step = 1; max / exp > 0; exp *= 10, step++) {
            countingSort(arr, exp, step, maxDigits);
        }
    }

    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    private static void countingSort(int[] arr, int exp, int step, int maxDigits) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        Arrays.fill(count, 0);

        System.out.println("Step " + step + " (sorting by " + getPositionName(exp) + "):");
        System.out.println("Counting occurrences of each digit:");
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
            System.out.println("  " + arr[i] + " has " + getPositionName(exp) + " digit: " + digit);
        }

        System.out.println("Cumulative count array: " + Arrays.toString(count));

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        System.out.println("Updated cumulative count array: " + Arrays.toString(count));

        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        System.arraycopy(output, 0, arr, 0, n);

        System.out.println("Array after this step: " + Arrays.toString(arr));
        System.out.println();
    }

    private static String getPositionName(int exp) {
        switch (exp) {
            case 1: return "1's (units)";
            case 10: return "10's (tens)";
            case 100: return "100's (hundreds)";
            default: return exp + "'s";
        }
    }

    public static void main(String[] args) {
        int[] arr = {783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94};
        radixSort(arr);
        
        System.out.println("Final sorted array: " + Arrays.toString(arr));
        System.out.println("\nBig-O Analysis:");
        System.out.println("  d = number of digits in the largest number (" + String.valueOf(getMax(arr)).length() + ")");
        System.out.println("  n = number of elements in the array (" + arr.length + ")");
        System.out.println("  k = range of values for a digit (10 for decimal)");
        System.out.println("Time Complexity: O(d * (n + k))");
        System.out.println("Space Complexity: O(n + k)");

    }
}
