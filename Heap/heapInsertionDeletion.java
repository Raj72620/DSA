import java.util.*;

//Max Heap -> 

public class heapInsertionDeletion {
    
ArrayList<Integer> li = new ArrayList<>();

public void insert(int value){
    li.add(value);

    int childIdx = li.size()-1;
    while(childIdx > 0){
        int parentIdx = (childIdx-1)/2;

        if(li.get(childIdx) > li.get(parentIdx)){
            int temp = li.get(childIdx);

            li.set(childIdx, li.get(parentIdx));

            li.set(parentIdx, temp);

            childIdx = parentIdx;
        }else{
            break;
        }
    }
}
public void delete(){
    int temp = li.get(0);  // swapping 

    li.set(0, li.get(li.size()-1));
    li.set(li.size()-1, temp);

    li.remove(li.size()-1); // removed the last element

    int parentIdx =0;
    while(parentIdx < li.size()){

        int leftIdx = 2*parentIdx+1;
        int rightIdx = 2*parentIdx+2;

        int biggestIdx = parentIdx;

        if(leftIdx < li.size() && li.get(leftIdx) > li.get(biggestIdx)){
            biggestIdx = leftIdx;
        }
        if(rightIdx < li.size()&& li.get(rightIdx)> li.get(biggestIdx)){
            biggestIdx=rightIdx;
        }
        if(biggestIdx !=parentIdx){
            int t = li.get(parentIdx);
            li.set(parentIdx, li.get(biggestIdx));
            li.set(biggestIdx, t);
            parentIdx=biggestIdx;
        }else{
            break;
        }
    }
}
    public static void main(String[] args) {
        heapInsertionDeletion h = new heapInsertionDeletion();
        h.insert(40);
        h.insert(20);
        h.insert(30);
        h.insert(10);
        h.insert(35);

        System.out.print(h.li + " ");
    }
    
}
