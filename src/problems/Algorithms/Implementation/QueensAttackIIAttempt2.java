package problems.Algorithms.Implementation;

import java.util.Scanner;

public class QueensAttackIIAttempt2
{

    //Credit is given where credit is due. Much learned from this experience:
    //https://codereview.stackexchange.com/questions/154040/hackerrank-queens-attack-ii
    public static void main(String args[])
    {
        evaluate();
    }

    public static void evaluate()
    {
        Scanner reader = new Scanner(System.in);
        int rows = reader.nextInt();
        int countObstacles = reader.nextInt();

        int qx = reader.nextInt();
        int qy = reader.nextInt();

        //Find Distances around the queen. Add to Array.
        //1-8, Starting at Left
        int[] distances = new int[8];

        distances[0] = qx; //Left
        distances[2] = qy; //Up
        distances[4] = rows + 1 - qx; //Right
        distances[6] = rows + 1 - qy; //Down
        distances[1] = Math.min(distances[0], distances[2]); //Left Up
        distances[3] = Math.min(distances[2], distances[4]); //Up Right
        distances[5] = Math.min(distances[4], distances[6]); //Right Down
        distances[7] = Math.min(distances[6], distances[0]); //Down Left

        for (int i = 0; i < countObstacles; i++) {
            int dx = reader.nextInt() - qx;
            int dy = reader.nextInt() - qy;
            int distance = 0;
            int direction = 0;

            if (dx == 0) {
                direction = (dy < 0) ? 2 : 6;
                distance = Math.abs(dy);
            }
            else if (dy == 0) {
                direction = (dx < 0) ? 0 : 4;
                distance = Math.abs(dx);
            }
            else if (Math.abs(dx) == Math.abs(dy)) {
                if (dx < 0) {
                    direction = (dy < 0) ? 1 : 7;
                }
                else {
                    direction = (dy < 0) ? 3 : 5;
                }
                distance = Math.abs(dx);
            }
            else {
                continue;
            }

            if (distance < distances[direction]) {
                distances[direction] = distance;
                //System.out.println("An Obstacles interferes with direction " + direction + " and reduces that direction to a distance of " + distance + " units");
            }


        }
        int total = 0;
        for (int i = 0; i < 8; i++) {
            total += distances[i] - 1;
        }
        System.out.println(total);

    }
}
