
import java.util.ArrayList;

public class heapSort {

    ArrayList<Integer> li = new ArrayList<>();

    public void insert(int value) {
        li.add(value);

        int childIdx = li.size() - 1;
        while (childIdx > 0) {
            int parentIdx = (childIdx - 1) / 2;

            if (li.get(childIdx) > li.get(parentIdx)) {
                int temp = li.get(childIdx);

                li.set(childIdx, li.get(parentIdx));

                li.set(parentIdx, temp);

                childIdx = parentIdx;
            } else {
                break;
            }
        }
    }
    public int delete() {

        int temp = li.get(0);  // swapping 

        li.set(0, li.get(li.size() - 1));
        li.set(li.size() - 1, temp);

       int deleted = li.remove(li.size() - 1); // removed the last element

        int parentIdx = 0;
       
        while (parentIdx < li.size()) {

            int leftIdx = 2 * parentIdx + 1;
            int rightIdx = 2 * parentIdx + 2;

            int biggestIdx = parentIdx;

            if (leftIdx < li.size() && li.get(leftIdx) > li.get(biggestIdx)) {
                biggestIdx = leftIdx;
            }
            if (rightIdx < li.size() && li.get(rightIdx) > li.get(biggestIdx)) {
                biggestIdx = rightIdx;
            }
            if (biggestIdx != parentIdx) {
                int t = li.get(parentIdx);
                li.set(parentIdx, li.get(biggestIdx));
                li.set(biggestIdx, t);
                parentIdx = biggestIdx;
            } else {
                break;
            }
        }
            return deleted;
    }

    public static void main(String[] args) {
        heapSort h = new heapSort();
       int[] insertOperation = {40,20,25,12,10,15};
       for(int ele : insertOperation){
        h.insert(ele);
       }
      for(int i=0; i<insertOperation.length; i++){
    System.out.print(h.delete() + " ");
}
    }
}
