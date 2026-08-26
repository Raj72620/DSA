package BinarySearch.Medium;

//Handling Duplicates

public class RotatedSortedArrTwo {

public static int solve(int[] arr, int tar) {
    int low = 0;
    int high = arr.length - 1;

    while (low <= high) {
        int mid = low + (high - low) / 2;

        if (arr[mid] == tar)
            return mid;

        // Handle duplicates
        if (arr[low] == arr[mid] && arr[mid] == arr[high]) {
            low++;
            high--;
            continue;
        }

        // Left half sorted
        if (arr[low] <= arr[mid]) {
            if (arr[low] <= tar && tar < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        // Right half sorted
        else {
            if (arr[mid] < tar && tar <= arr[high]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
    }

    return -1;
}
    public static void main(String[] args) {
         int[] arr={3,3,4,5,6,7,1,2,2,3,3,3};
    int target=3;
    System.out.println(solve(arr,target));
    }
}
