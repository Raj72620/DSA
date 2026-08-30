package Greedy.Hard;

import java.util.PriorityQueue;

public class minRefuelingStops {

        public static int minNoOfRefuelingStops(int[][] nums, int n) {

        PriorityQueue<Integer> pq =
            new PriorityQueue<>((a, b) -> b - a);

        int stops = 0;
        int fuel = 10;

        for (int i = 0; i < n; i++) {

            int pos = nums[i][0];

            if (pos <= fuel) {
                pq.add(nums[i][1]);

            } else {

                while (!pq.isEmpty() && pos > fuel) {
                    fuel += pq.remove();
                    stops++;
                }
                if (pos > fuel) {
                    return -1;
                }

                pq.add(nums[i][1]);
            }
        }

        return stops;
    }
    public static void main(String[] args) {
         int[][] nums = {
            {10, 60},
            {20, 30},
            {30, 30},
            {60, 40}
        };

        int n = nums.length;

        System.out.println(minNoOfRefuelingStops(nums, n));
    }
}
