package problems.Algorithms.Implementation;

import java.math.BigInteger;
import java.util.ArrayList;
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

        BigInteger[] people = new BigInteger[numPeople];
        ArrayList<BigInteger> teams = new ArrayList<BigInteger>();
        for (int i = 0; i < people.length; i++) {
            people[i] = new BigInteger(in.nextLine(),2);
        }

        for(int i = 0; i < people.length-1;i++){
            for(int j = i+1; j < people.length; j++){
                if(i==j){
                    continue;
                }
                else{
                    teams.add(people[i].or(people[j]));
                }
            }
        }
        int bestTeams = 0;
        int mostTopics = 0;
        for(BigInteger pair:teams){
            if(pair.bitCount() > mostTopics){
                bestTeams = 1;
                mostTopics = pair.bitCount();
            }
            else if(pair.bitCount() == mostTopics){
                bestTeams++;
            }
            //System.out.println(Integer.toBinaryString(pair));
        }
        System.out.println(mostTopics);
        System.out.println(bestTeams);


    }
}
