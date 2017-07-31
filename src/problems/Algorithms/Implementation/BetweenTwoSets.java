package problems.Algorithms.Implementation;

import java.util.Scanner;

public class BetweenTwoSets
{
    static int getTotalX(int[] a, int[] b){
        int total = 0;
        iloop: for(int i = 1; i <= b[0]; i++){
            for(int anum: a){
                if(i%anum!=0){
                    continue iloop;
                }
            }
            for(int bnum: b){
                if(bnum%i!=0){
                    continue iloop;
                }
            }
            total++;
        }
        return total;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i=0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        int total = getTotalX(a, b);
        System.out.println(total);
    }
}
