package problems.Algorithms.Strings;

import java.util.ArrayList;
import java.util.Scanner;

public class GameOfThronesI {
    static String gameOfThrones(String s){
        ArrayList<Character> letters = new ArrayList<Character>();
        while(s.length()>0){
            char point = s.charAt(0);
            if(!letters.contains(point)){
                letters.add(point);
                s = s.substring(1);
            }
            else{
                letters.remove((Character)point);
                s = s.substring(1);
            }
        }
        String result = (letters.size()>1)?"NO":"YES";
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = gameOfThrones(s);
        System.out.println(result);
    }
}
