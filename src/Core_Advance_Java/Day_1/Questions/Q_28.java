package Core_Advance_Java.Day_1.Questions;

import java.util.Scanner;

public class Q_28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
           sum+=arr[i];
        }
        double sum1=sum;
        double avg = (sum1/arr.length);
        System.out.println(sum);
        System.out.println(avg);
    }
}
