package problems.Algorithms.Warmups;

import java.util.Scanner;

public class MiniMax {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = new int[5];
        for(int arr_i=0; arr_i < 5; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        int smallest = arr[0], largest = arr[0];
        for(int a:arr){
            if(a<smallest){
                smallest = a;
            }
            else if (a>largest){
                largest = a;
            }
        }
        long minimum = 0, maximum = 0;
        for(int a:arr){
            if(a!=smallest){
                maximum+=a;
            }
            else{
                smallest = -1;
            }
            if(a!=largest){
                minimum+=a;
            }
            else{
                largest = -1;
            }
        }
        System.out.println(minimum + " " + maximum);
    }
}
