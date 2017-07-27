package problems.Algorithms.Warmups;

import java.util.Scanner;

public class TimeConversion {
    static String timeConversion(String s) {
        String[] timesplit = s.split(":");
        if(timesplit[0].equals("12") && timesplit[2].contains("AM")){
            timesplit[0]="00";
        }
        else if(timesplit[0].equals("12") && timesplit[2].contains("PM")){
            timesplit[0]="12";
        }
        else if(timesplit[2].contains("PM")){
            timesplit[0] = Integer.parseInt(timesplit[0])+12+"";
        }

        timesplit[2] = timesplit[2].substring(0,2);
        String result = timesplit[0]+":"+timesplit[1]+":"+timesplit[2];
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = timeConversion(s);
        System.out.println(result);
    }
}
