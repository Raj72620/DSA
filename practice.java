

public  class practice{
 
  public static boolean check(int[] arr){
    int maxReach=0;

    for(int i=0;i<arr.length;i++){
      int totalDist = i+arr[i];
      if(i>maxReach) return false;
      maxReach=Math.max(totalDist, maxReach);
      if(maxReach>=arr.length-1){
        return true;
      }
    }
    return false;
  }
    public static void main(String[] args) {
    int[] arr={1,2,3,1,1,0,2,5};
    System.out.println(check(arr));
    }
}