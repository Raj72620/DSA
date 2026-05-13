import java.util.*;

public class medianFromDataStream {

    static class MedianFinder {

        PriorityQueue<Integer> maxHeap =new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        public void insert(int num) {

            if (maxHeap.isEmpty() || num <= maxHeap.peek()) {
                maxHeap.add(num);
            } else {
                minHeap.add(num);
            }
            if (maxHeap.size() > minHeap.size() + 1) {
                minHeap.add(maxHeap.remove());
            } 
            else if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.remove());
            }
        }
        public double getMedian() {

            if (maxHeap.size() == minHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            }
            
            return maxHeap.peek();
        }
    }
    public static void main(String[] args) {

        int[] streams = {2, 3, 4, 1, 5};

        MedianFinder mf = new MedianFinder();
        for (int ele : streams) {
            mf.insert(ele);
            System.out.println(mf.getMedian());
        }
    }
}