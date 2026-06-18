package Sorting;

public class mergeSort {
    public static void sort(int[] arr,int Si,int Ei){

        if(Si>=Ei) return;

        int mid = Si+(Ei-Si)/2;
        sort(arr,Si,mid);
        sort(arr,mid+1,Ei);
        merge(arr,Si,mid,Ei);
    }
    public static void merge(int[] arr , int si,int mid,int ei){

        int[] temp=new int[ei-si+1];
        int i=si;
        int j=mid+1;
        int k=0;

        while(i<=mid && j<=ei){

            if(arr[i]<=arr[j]){
                temp[k++]=arr[i++];
            }else{
                temp[k++]=arr[j++];
            }
        }

        while(i<=mid){
            temp[k++]=arr[i++];
        }

        while(j<=ei){
            temp[k++]=arr[j++];
        }

        for(k=0,i=si;k<temp.length;k++,i++){
            arr[i]=temp[k];
        }
    }
    public static void print(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        int startingIdx=0;
        int endIdx=arr.length-1;
        sort(arr,startingIdx,endIdx);

        print(arr);
    }
}
