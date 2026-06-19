package Sorting;

public class quickSort {

    public static void sort(int[] arr,int si , int ei){
        if(si>=ei) return;

        int Pidx=partition(arr,si,ei);
        sort(arr, si, Pidx-1);
        sort(arr,Pidx+1,ei);
        
    }
    public static int partition(int[] arr,int si,int ei){
        int pivot=arr[ei];
        int i=si-1;
        for(int j=si;j<ei;j++){
            if(arr[j]<=pivot){
                i++;
                int temp = arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
            }
        }
        i++;
        int temp=pivot;
        arr[ei]=arr[i];
        arr[i]=temp;

        return i;
    }
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1};
        sort(arr,0,arr.length-1);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
    }
}
