package problems.Algorithms.Warmups;

import java.util.Scanner;

public class Staircase {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(j<N-i-1){
                    System.out.print(" ");
                }
                else{
                    System.out.print("#");
                }
            }
            System.out.println();
        }
    }
}
