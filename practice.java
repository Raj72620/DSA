
import java.util.ArrayList;

public class practice {
public static void main(String[] args) {
    ArrayList<Integer> path = new ArrayList<>();

    path.add(1);
    path.add(2);
    path.add(3);

  

    path.remove(path.size()-1);

      for(int i=0;i<path.size();i++){
        System.out.print(path.get(i)+ " ");
    }
  
}
}