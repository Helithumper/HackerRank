package problems.Algorithms.Warmups;

import java.text.DecimalFormat;
import java.util.Scanner;

public class PlusMinus {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int N = reader.nextInt();
        reader.nextLine();
        int[] nums = new int[N];
        for(int i = 0; i < N; i++){
            nums[i] = reader.nextInt();
        }
        int pos=0,neg=0,zero=0;
        for(int i:nums){
            if(i>0){
                pos++;
            }
            else if(i<0){
                neg++;
            }
            else if(i==0) {
                zero++;
            }
        }
        DecimalFormat df = new DecimalFormat("#0.000000");
        double posfrac = (double)(pos)/N, negfrac = (double)(neg)/N, zerofrac = (double)(zero)/N;
        String posfracformatted = df.format(posfrac);
        String negfracformatted = df.format(negfrac);
        String zerofracformatted = df.format(zerofrac);
        System.out.println(posfracformatted+"\n"+negfracformatted+"\n"+zerofracformatted);
    }
}
