
import java.util.Arrays;
import java.util.PriorityQueue;

public class mergeKsortedList {

    static class Info implements Comparable<Info> {

        int value;
        int listIdx;
        int eleIdx;

        public Info(int value, int listIdx, int eleIdx) {
            this.value = value;
            this.listIdx = listIdx;
            this.eleIdx = eleIdx;
        }

        @Override
        public int compareTo(Info other) {
            return this.value - other.value;
        }
    }

    public static int[] mergeList(int[][] arr) {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        int totalSize = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length > 0) {
                pq.add(new Info(arr[i][0], i, 0));
                totalSize += arr[i].length;
            }
        }
        int[] result = new int[totalSize];

        int idx = 0;

        while (!pq.isEmpty()) {

            Info curr = pq.remove();
            result[idx++] = curr.value;

            if (curr.eleIdx + 1 < arr[curr.listIdx].length) {
                pq.add(new Info(arr[curr.listIdx][curr.eleIdx + 1], curr.listIdx, curr.eleIdx + 1));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 4, 5}, {1,2,2,2}, {2, 6}};
       int[] ans = mergeList(arr);
       System.out.println(Arrays.toString(ans));

    }

}
