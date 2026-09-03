package Greedy.Hard;

import java.util.Arrays;
import java.util.PriorityQueue;

public class IPO {

    public static int findMaximizedCapital(int k, int w, int[] p, int[] c) {

        int n = p.length;

        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            arr[i][0] = c[i]; // capital
            arr[i][1] = p[i]; // profit
        }

        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq =
                new PriorityQueue<>((a, b) -> b - a);

        int j = 0;

        for (int i = 0; i < k; i++) {

            while (j < n && arr[j][0] <= w) {
                pq.offer(arr[j][1]);
                j++;
            }

            if (pq.isEmpty()) {
                break;
            }

            w += pq.poll();
        }

        return w;
    }

    public static void main(String[] args) {
        int[] profit={1,2,3};
        int[] capital={0,1,1};
        int k=2;

        System.out.println(findMaximizedCapital(k,0,profit,capital));
    }
}
