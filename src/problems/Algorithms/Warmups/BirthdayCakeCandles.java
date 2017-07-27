package problems.Algorithms.Warmups;

import java.util.Scanner;

public class BirthdayCakeCandles {
    static int birthdayCakeCandles(int n, int[] ar) {
        int maximum = ar[0], count = 1;
        for(int i = 1; i < ar.length; i++){
            if(ar[i]>maximum){
                maximum = ar[i];
                count = 1;
            }
            else if (ar[i]==maximum){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = birthdayCakeCandles(n, ar);
        System.out.println(result);
    }
}
