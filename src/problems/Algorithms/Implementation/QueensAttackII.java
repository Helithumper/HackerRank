package problems.Algorithms.Implementation;

import java.util.Scanner;

public class QueensAttackII {


    public static boolean debug = false;
    /*public static void log(String s){
        if(debug) {
            System.out.print("[DEBUG]: \n" + s);
        }
    }*/
    public static int convertRow(int oldRow, int boardSize){
        return boardSize-oldRow;
    }
    public static int convertCol(int oldCol, int boardSize){
        return oldCol-1;
    }

    public static void printBoard(int[][] board){
        String result = "";
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                result+=board[i][j] + " ";
            }
            result+=("\n");
        }
        //log(result);
    }
    public static void main(String[] args) {
        //log("Running\n");


        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int rQueen = in.nextInt();
        int cQueen = in.nextInt();


        //Create a board of the correct size
        int[][] board = new int[n][n];

        //Place Queen in correct spot
        rQueen = convertRow(rQueen,n);
        cQueen = convertCol(cQueen,n);
        board[rQueen][cQueen] = 1;

        int rObstacle = 0;
        int cObstacle = 0;
        //Place obstacles in correct spots
        for(int a0 = 0; a0 < k; a0++){
            //log("This many obstacles to go: \t" + (k-a0));

            rObstacle = in.nextInt();
            cObstacle = in.nextInt();
            board[convertRow(rObstacle,n)][convertCol(cObstacle,n)] = 2;
            printBoard(board);
        }
        printBoard(board);
        ////////////
        //Check Verticals and horizontals
        ////////////
        int horizontalSpots = 0;
        boolean queenVisitedVertical = false;
        boolean queenVisitedHorizontal = false;
        boolean horizontalFinished = false;
        boolean verticalFinished = false;
        int verticalSpots = 0;
        for(int i = 0; i < board.length; i++){
            //log("This many horizontals / verticals to go: \t" + (board.length-i));
            ///////VERTICAL/////////
            if (board[i][cQueen] == 1 && !queenVisitedVertical && !verticalFinished){
                queenVisitedVertical = true;
            }
            else if(board[i][cQueen] == 0 && !verticalFinished) {
                verticalSpots++;
            }
            else if (board[i][cQueen] == 2 && !queenVisitedVertical){
                verticalSpots = 0;
            }
            else if (board[i][cQueen] == 2 && queenVisitedVertical){
                verticalFinished = true;
            }

            //////////HORIZONTAL////////
            if (board[rQueen][i] == 1 && !queenVisitedHorizontal && !horizontalFinished){
                queenVisitedHorizontal = true;
            }
            else if(board[rQueen][i] == 0){
                horizontalSpots++;
            }

            else if (board[rQueen][i] == 2 && !queenVisitedHorizontal){
                horizontalSpots = 0;
            }
            else if (board[rQueen][i] == 2 && queenVisitedHorizontal && !horizontalFinished){
                horizontalFinished = true;
            }
        }
        //log("Vertical Spots:\t"+verticalSpots+"\n");
        //log("Horizontal Spots:\t"+horizontalSpots+"\n");
        //printBoard(board);


        ////////////
        //Check Bottom Left to Top Right Diagonal
        ////////////
        int diagonal1Spots = 0;
        int commonSum = rQueen + cQueen;
        //Go Down
        for(int r = rQueen, c = cQueen; r < board.length && c >= 0; r++, c--){
            if(board[r][c] == 0){
                diagonal1Spots++;
            }
            else if(board[r][c] == 1){
                continue;
            }
            else if(board[r][c] == 2){
                break;
            }
        }

        //Go Up
        for(int r = rQueen, c = cQueen; r >= 0 && c < board.length; r--, c++){
            if(board[r][c] == 0){
                diagonal1Spots++;
            }
            else if(board[r][c] == 1){
                continue;
            }
            else if(board[r][c] == 2){
                break;
            }
        }

        //log("\nDiagonal 1 Spots / : \t" + diagonal1Spots);

        //Check Top Left to Bottom Right Diagonal
        boolean queenVisited = false;
        int startingCol = 0;
        int startingRow = 0;

        if(rQueen == cQueen){
            startingCol = 0;
        }
        else if(cQueen > rQueen){
            startingRow = 0;
            startingCol = cQueen-rQueen;
        }
        else if(cQueen < rQueen){
            startingCol = 0;
            startingRow = rQueen-cQueen;
        }
        queenVisited = false;
        int diagonal2Spots = 0;
        for(int i = startingRow,j = startingCol; j < board.length && i < board.length; i++,j++){
            if(board[i][j] == 1){
                queenVisited = true;
            }
            else if (board[i][j] == 2 && !queenVisited){
                diagonal2Spots = 0;
            }
            else if (board[i][j] == 2 && queenVisited){
                break;
            }
            else if(board[i][j] == 0){
                diagonal2Spots++;
            }
        }
        //log("\nDiagonal 2 Spots: \\t"+diagonal2Spots+"\n");
        //Add up total moves
        System.out.println(verticalSpots+horizontalSpots+diagonal1Spots+diagonal2Spots);
        //Print that
    }
}
