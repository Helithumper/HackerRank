package problems.Algorithms.Strings;

import java.util.ArrayList;
import java.util.Scanner;

public class TwoStrings {
    static String twoStrings(String s1, String s2){
        ArrayList<Character> letters = new ArrayList<Character>();
        for(int i = 0; i < s1.length();i++){
            if(!letters.contains(s1.charAt(i))) {
                letters.add(s1.charAt(i));
            }
        }
        for(int i = 0; i < s2.length();i++){
            if(letters.contains(s2.charAt(i))){
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        in.nextLine();
        String[] first = new String[q];
        String[] second = new String[q];
        for(int i = 0; i < q; i++){
            first[i] = in.nextLine();
            second[i] = in.nextLine();
        }
        for(int i = 0; i < q; i++){
            System.out.println(twoStrings(first[i],second[i]));
        }
    }
}
