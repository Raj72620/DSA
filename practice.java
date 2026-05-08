
import java.util.HashMap;


public  class practice{

  public static boolean isIso(String s1,String s2){
    HashMap<Character,Integer> map=new HashMap<>();
    
    for(int i=0;i<s1.length();i++){
      if(map.put(s1.charAt(i), 1)!= map.put(s2.charAt(i),1)){
          return false;
      }
    }
    return true;
  }
  
    public static void main(String[] args) {
    String s1= "egg";
    String s2="add";

    System.out.println(isIso(s1,s2));
    }
}