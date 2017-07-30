package problems.Algorithms.Implementation;

import java.util.BitSet;
import java.util.Scanner;

public class ACMICPCTeam
{
    public static void main(String[] args)
    {
        evaluate();
    }

    public static void evaluate()
    {
        Scanner in = new Scanner(System.in);
        int numPeople = in.nextInt();
        int numTopics = in.nextInt();
        in.nextLine();

        int[] people = new int[numPeople];

        for (int i = 0; i < people.length; i++) {
            int input = Integer.parseInt(in.nextLine(),2);
            System.out.println(Integer.toBinaryString(input));
        }
    }
}
