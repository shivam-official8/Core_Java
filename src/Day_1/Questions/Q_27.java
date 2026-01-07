package Day_1.Questions;

import java.util.Scanner;

public class Q_27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
            max = Math.max(max, arr[i]);
        }
        System.out.println(max);
    }
}
