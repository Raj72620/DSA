

public  class practice{
 
  public static int findMax(int[] nums){
    int currEnd=0;
    int jumps=0;
    int farthest=0;

    for(int i=0;i<nums.length;i++){  
      farthest=Math.max(farthest, i+nums[i]);

      if(farthest >=nums.length-1){
        jumps++;
        break;
      }
      if(i==currEnd){
        jumps++;
        currEnd=farthest;
      }
    }
    return jumps;
  }
    public static void main(String[] args) {
    int[] nums={7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};

   System.out.println( findMax(nums));

    }
}