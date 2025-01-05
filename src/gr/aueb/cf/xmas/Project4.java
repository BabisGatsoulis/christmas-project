package gr.aueb.cf.xmas;

import java.util.Scanner;

public class Project4 {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] ticTacToe = new int[3][3];
        int choice;
        int orderChoice = 0;
        int rowPosition;
        int ColPosition;
        int round = 0;
        boolean isGameEnd = false;

        do {
            round += 1;
            System.out.println("Round : " + round);
            choice = getOneChoice();
            while (orderChoice == choice) {
                if (choice == 1) {
                    System.out.println("Please pay attention to player's order. Player 2 must play");
                } else {
                    System.out.println("Please pay attention to player's order. Player 1 must play");
                }
                choice = getOneChoice();
            }
            orderChoice = choice;
            rowPosition = getRowPosition() - 1;
            ColPosition = getColPosition() - 1;
            checkTablePosition(ticTacToe,orderChoice,rowPosition,ColPosition);
            for (int[] row : ticTacToe) {
                for (int col : row) {
                    System.out.print(col + " ");
                }
                System.out.println();
            }
            isGameEnd = isGameEnd(ticTacToe);
            if (isGameEnd) break;
            if (round == 9) System.out.println("Game ends equal");

        } while(round <9);
        System.out.println("Thank you!");
    }

    public static int getOneChoice() {
        int choice;

        do {
            System.out.println("Please enter 1 if you're the Player 1 or 2 if you're the Player 2");
            choice = in.nextInt();
        } while (choice < 1 || choice > 2);

        return choice;
    }

    public static int getRowPosition() {
        int row;

        do {
            System.out.println("Select row position between 1-3");
            row = in.nextInt();
        } while (row < 1 || row > 3);

        return row;
    }

    public static int getColPosition() {
        int col;

        do {
            System.out.println("Select column position between 1-3");
            col = in.nextInt();
        } while (col < 1 || col > 3);

        return col;
    }

    public static void checkTablePosition (int[][] arr, int choice, int i, int j) {

        while (arr[i][j] == 1 || arr[i][j] ==2) {
            System.out.println("You must choose another position");
            i = getRowPosition() - 1;
            j = getColPosition() - 1;
        }
        arr[i][j] = choice;
    }

    public static boolean isGameEnd(int[][] arr) {
        boolean isEnd = false;

        for (int i=0; i < arr.length; i++){
            for (int j=0; j <arr[i].length-2; j++) {
                if ((arr[i][j] ==  1 && arr[i][j+1] == 1 && arr[i][j+2] == 1) || (arr[i][j] ==  2 && arr[i][j+1] == 2 && arr[i][j+2] == 2)){
                    isEnd = true;
                    System.out.println("There is a winner");
                    return isEnd;
                }
            }
        }

        for (int i=0; i < arr.length-2; i++){
            for (int j=0; j <arr[i].length; j++) {
                if ((arr[i][j] == 1 && arr[i+1][j] == 1 && arr[i+2][j] == 1) || (arr[i][j] == 2 && arr[i+1][j] == 2 && arr[i+2][j] == 2)) {
                    isEnd = true;
                    System.out.println("There is a winner");
                    return isEnd;
                }
            }
        }

        if ((arr[0][0] == 1 && arr[1][1] == 1 && arr[2][2] == 1) || (arr[0][0] == 2 && arr[1][1] == 2 && arr[2][2] == 2) || (arr[2][0]== 1 && arr[1][1] == 1 && arr[0][2] == 1) || (arr[2][0]== 2 && arr[1][1] == 2 && arr[0][2] == 2)){
            isEnd = true;
            System.out.println("There is a winner");
            return isEnd;
        }

        return isEnd;
    }
}