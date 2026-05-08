import java.util.*;
public class example {

    static class student implements Comparable<student>{
        String name;
        int marks;

        public student(String name,int marks) {
            this.name=name;
            this.marks=marks;
        }
        @Override
        public int compareTo(student other){
            return this.marks - other.marks;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<student> pq = new PriorityQueue<>();
       pq.add(new student("Raj", 90));
       pq.add(new student("Bob", 70));
       pq.add(new student("Alice", 20));

     
        while(!pq.isEmpty()){
            System.out.print(pq.remove().name+" ");
        }
    }
}
