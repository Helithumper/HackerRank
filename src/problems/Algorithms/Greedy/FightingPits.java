package problems.Algorithms.Greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class FightingPits {
    static boolean DEBUG = false;
    static void log(String s){
        if(DEBUG){
            System.out.println("[DEBUG]: "+ s);
        }
    }
    static int fight(Team t1, Team t2) {
        //Print out teams initially
        log(t1.printTeam());
        log(t2.printTeam());
        //Set some major battle variables
        int winner = 0;
        int turn = 1;

        //Main Game Loop
        mainloop: while (winner == 0) {
            //Is there a Clear Winner?
            if(t1.fighters.size()==0){winner = 2;break;}
            if(t2.fighters.size()==0){winner = 1;break;}

            //Team 1's Turn
            if (turn == 1) {

                log("Team 1's Turn to Fight!");

                //Who is TEAM 1's MOST POWERFUL
                int mostPowerful = -1, mostPowerfulEnemy = -1;
                for (int fighter : t1.fighters) {
                    if (fighter > mostPowerful) {
                        mostPowerful = fighter;
                    }
                }
                log("\tTeam's Most Powerful Fighter:\tStrength: " + mostPowerful);

                //Who is the enemies most powerful fighter? Kill as many as our team's strength
                for (int i = 0; i < mostPowerful; i++) {

                    mostPowerfulEnemy = -1;
                    for (int fighter : t2.fighters) {
                        if (fighter > mostPowerfulEnemy) {
                            mostPowerfulEnemy = fighter;
                        }
                    }
                    log ("\t\tFighter eliminates enemy\tEnemy Strength: " + mostPowerfulEnemy);

                    //Kill as many of their most powerful fighters as needed
                    try {
                        t2.kill(mostPowerfulEnemy);
                    } catch (Exception e) {
                        winner = 1;
                        break mainloop;
                    }
                }
            }

            //Is it team 2's Turn
            else {

                log("Team 2's Turn to Fight!");

                //Who is team two's most powerful player?
                int mostPowerful = -1, mostPowerfulEnemy = -1;
                for (int fighter : t2.fighters) {
                    if (fighter > mostPowerful) {
                        mostPowerful = fighter;
                    }
                }
                log("\tTeam's Most Powerful Fighter:\tStrength: " + mostPowerful);

                //Fight as many fighters as our most powerful strength
                for (int i = 0; i < mostPowerful; i++) {

                    if (t1.fighters.size() == 0) {
                        winner = 2;
                        break mainloop;
                    }

                    //Who is the enemy team's most powerful player?
                    mostPowerfulEnemy = -1;
                    for (int fighter : t1.fighters) {
                        if (fighter > mostPowerfulEnemy) {
                            mostPowerfulEnemy = fighter;
                        }
                    }

                    log("\t\tFighter eliminates enemy\tEnemy Strength: " + mostPowerfulEnemy);

                    //Kill him if possible
                    try {
                        t1.kill((Integer) mostPowerfulEnemy);
                    } catch (Exception e) {
                        winner = 2;
                        break mainloop;
                    }
                }
            }

            //End of round stats
            log("Swapping Sides");
            log(t1.printTeam());
            log(t2.printTeam());
            turn = (turn == 1) ? 2 : 1;

        }
        t1.resetTeam();
        t2.resetTeam();
        log("TEAM " + winner + " WINS!!!");
        System.out.println(winner);
        return winner;
    }

    static void swap(Team a, Team b){
        Team temp = a;
        a = b;
        b = temp;
        return;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numFighters = in.nextInt();
        int numTeams = in.nextInt();
        int numQueries = in.nextInt();
        in.nextLine();
        Team[] teams = new Team[numTeams];
        for(int i = 0 ; i < teams.length; i++){
            teams[i] = new Team(i);
        }
        int fighterTeam,fighterStrength;
        for(int i = 0; i < numFighters; i++){
            fighterTeam = in.nextInt();
            fighterStrength = in.nextInt();
            teams[fighterTeam-1].fighters.add(fighterStrength);
            in.nextLine();
        }
        for(Team t:teams){
            log(t.printTeam());
        }
        for(int i = 0; i < numQueries; i++){
            int input = in.nextInt();
            //If add fighter
            if(input == 1){
                int strength = in.nextInt();
                int team = in.nextInt();
                teams[team].fighters.add(strength);
            }
            if(input == 0){
                for(Team t:teams){
                    log(t.printTeam());
                }
            }
            //If fight
            else if(input == 2){
                fight(teams[in.nextInt()-1],teams[in.nextInt()-1]);
            }
            in.nextLine();
        }

    }
}
class Team{
    public ArrayList<Integer> fighters = new ArrayList<Integer>();
    public ArrayList<Integer> fighterStorage = new ArrayList<Integer>();
    public int teamNumber;

    public Team(int number){
        teamNumber = number;
    }
    public Team(Team oldteam){
        this.fighters = oldteam.fighters;
        this.teamNumber = oldteam.teamNumber;
    }

    public void kill(int strength) throws Exception {
        for(int i = 0; i < fighters.size(); i++){
            if(fighters.get(i)==strength){
                fighterStorage.add(fighters.get(i));
                fighters.remove(i);
                if(fighters.size()==0){
                    throw new Exception();
                }
                break;
            }
        }
    }

    public void resetTeam(){
        while(fighterStorage.size()>0){
            fighters.add(fighterStorage.get(0));
            fighterStorage.remove(0);
        }
    }
    public String printTeam(){
        String output = "Team: "+(((teamNumber+1)==1)?2:1);
        for(int i:fighters){
            output+="\n\tFighter\tStrength: " + i;
        }
        output+="\nEnd Team";
        return output;
    }

}