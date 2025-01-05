package gr.aueb.cf.xmas;

import java.util.Scanner;

public class Project5 {
    static Scanner in = new Scanner(System.in);
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean[][] positions = initializePositions();
        int rowPosition;
        int intColPosition;
        int choice;
        char colPosition;

        do {
            printMenu();
            choice = getChoice();

            switch (choice) {
                case 1:
                    rowPosition = getRowPosition() - 1;
                    colPosition = getColumnPosition();
                    intColPosition = getIntegerColPosition(colPosition);
                    book(positions, rowPosition, intColPosition);
                    break;
                case 2:
                    rowPosition = getRowPosition() - 1;
                    colPosition = getColumnPosition();
                    intColPosition = getIntegerColPosition(colPosition);
                    cancel(positions, rowPosition, intColPosition);
                    break;
                default:
                    System.out.println("You choose exit");
                    System.out.println("Theater's positions are following");
                    for (boolean[] row : positions) {
                        for (boolean col : row) {
                            System.out.print(col + " ");
                        }
                        System.out.println();
                    }
                    break;
            }
        } while (choice != 3);

        System.out.println("Thank you for using this app!");
    }

    public static void printMenu() {
        System.out.println("Choose one of the following options:");
        System.out.println("1-Book");
        System.out.println("2-Cancel");
        System.out.println("3-Exit");
    }

    public static int getChoice() {
        int choice;

        choice = in.nextInt();
        while (choice < 1 || choice > 3) {
            printMenu();
            choice = in.nextInt();
        }

        return choice;
    }

    public static boolean[][] initializePositions() {
        boolean arr[][] = new boolean[30][12];

        for (int i = 0; i < arr.length; i++) {
            for (char j = 0; j < arr[i].length; j++) {
                arr[i][j] = false;
            }
        }

        return arr;
    }

    public static int getRowPosition() {
        int row;

        do {
            System.out.println("Select row position between 1-30");
            row = in.nextInt();
        } while (row < 1 || row > 30);

        return row;
    }

    public static char getColumnPosition() {
        char column;

        do {
            System.out.println("Select column position between A-L");
            column = sc.nextLine().charAt(0);
        } while (column > 'L');

        return column;
    }

    public static int getIntegerColPosition(char colPosition) {
        int num = 0;

        switch (colPosition) {
            case 'A':
                num = 0;
                break;
            case 'B':
                num = 1;
                break;
            case 'C':
                num = 2;
                break;
            case 'D':
                num = 3;
                break;
            case 'E':
                num = 4;
                break;
            case 'F':
                num = 5;
                break;
            case 'G':
                num = 6;
                break;
            case 'H':
                num = 7;
                break;
            case 'I':
                num = 8;
                break;
            case 'J':
                num = 9;
                break;
            case 'K':
                num = 10;
                break;
            case 'L':
                num = 11;
                break;
        }

        return num;
    }

    public static void book(boolean[][] arr, int i, int j) {
        int rowPosition;
        char colPosition;
        int intColPosition;

        if (arr[i][j] == true) {
            System.out.println("This position is booked, please select another position");
        } else {
            arr[i][j] = true;
        }
    }

    public static void cancel(boolean[][] arr, int i, int j) {
        if (arr[i][j] == true) {
            arr[i][j] = false;
            System.out.println("This position is canceled");
        } else {
            System.out.println("Position isn't booked");
        }
    }

}
