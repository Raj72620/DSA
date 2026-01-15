package Greedy;

public class Candy {

    public static int findSum(int[] arr) {
        int n = arr.length;

        int i = 1, sum = 1;

        while (i < n) {
            // Case 1: Equal rating (plateau)
            if (arr[i] == arr[i - 1]) {
                sum += 1;
                i++;
            }

            // Case 2: Increasing sequence
            int peak = 1;

            while (i < n && arr[i] > arr[i - 1]) {
                peak=peak+1;
                sum += peak;
                i++;
            }
            // Case 3: Decreasing sequence
            int down = 1;

            while (i < n && arr[i] < arr[i - 1]) {
                sum += down;
                i++;
                down=down+1;
            }
            if (down > peak) {
                sum += (down - peak);
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,87,87,87,2,1};
        System.out.println(findSum(arr));
    }

}
