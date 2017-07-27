package problems.Algorithms.Warmups;

import java.util.Scanner;

public class DiagonalDifference {
    public static int diagonalAbsDiff(int[][] matrix){
        int suma = 0, sumb = 0;
        for(int i = 0; i < matrix.length; i ++){
            suma = suma + matrix[i][i];
        }
        int j = 0;
        for(int i = matrix.length-1; i >=0; i--){
            sumb = sumb+matrix[i][j];
            j++;
        }
        return Math.abs(suma-sumb);
    }

    public DiagonalDifference() {
        Scanner in = new Scanner(System.in);
        int dimension = in.nextInt();
        in.nextLine();
        int[][] matrix = new int[dimension][dimension];

        for (int i = 0; i < matrix.length ; i++) {
            String input = in.nextLine();
            System.out.println(input);
            String[] stringMatrix = input.split(" ");

            for (int j = 0; j < stringMatrix.length; j++) {
                matrix[i][j] = Integer.parseInt(stringMatrix[j]);
            }
        }
        System.out.println(diagonalAbsDiff(matrix));
    }
}
