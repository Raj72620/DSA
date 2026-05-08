
import java.util.*;

public  class heapPractice {
   static class Student implements Comparable<Student>{
        String name;
        int marks;

        Student(String name,int marks) {
            this.name=name;
            this.marks=marks;

        }
       @Override
         public int compareTo(Student other){
        return this.marks - other.marks;
    }
}
    public static void main(String[] args) {
        ArrayList<Student> li = new ArrayList<>();

        li.add(new Student("Raj", 90));
         li.add(new Student("Bob", 70));
          li.add(new Student("Alice", 80));
        Collections.sort(li);
          for(Student s : li){
            System.out.println(s.name + " " + s.marks);
        }
       

    }
}
