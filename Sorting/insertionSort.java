package Sorting;

//shift the smallest ele to it's correct position 
public class insertionSort {
    public static void sort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int curr=arr[i];
            int j=i-1;

            while(j>=0 && arr[j]>curr){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=curr;
        }
    }
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1};
        sort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
    }
}
