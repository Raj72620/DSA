package Greedy;

public class LemonadeChange {

public static boolean find(int[] arr) {
    int count_5 = 0;
    int count_10 = 0;
    
    for(int bill : arr) {
        if(bill == 5) {
            count_5++;
        } 
        else if(bill == 10) {
            if(count_5 == 0) return false;
            count_5--;
            count_10++;
        } 
         // bill == 20
        else {
            // Prefer $10 + $5
            if(count_10 > 0 && count_5 > 0) {
                count_10--;
                count_5--;
            } 
            // Otherwise try three $5
            else if(count_5 >= 3) {
                count_5 -= 3;
            } 
            else {
                return false;
            }
        }
    }
    return true;
    }
    public static void main(String[] args) {
        int[] arr={5, 5, 10, 10, 20};

        System.out.println(find(arr));
    }
    
}
