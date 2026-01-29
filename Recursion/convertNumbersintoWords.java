package Recursion;

public class convertNumbersintoWords {
    public static void convert(int n, String[] digits){
        if(n==0) return;

        int lastDigit = n%10;
        convert(n/10, digits);
        System.out.print(digits[lastDigit]+ " ");
    }
    public static void main(String[] args) {
        String[] digits={"zero","one" ,"two" , "three" , "four", "five", "six", "seven", "eight","nine","ten"};
        convert(2019,digits);
    }
    
}
