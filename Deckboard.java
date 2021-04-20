import java.util.Arrays;
import java.util.Random;

public class Deckboard {
    char[][] board;
    char stringX;
    char stringO;
    char space;

    public Deckboard() {
        board = new char[3][3];
        stringX = 'X';
        stringO = 'O';
        space = 0;

    }

    public void printBoard() {
        System.out.println(board[0][0] + " | " + board[0][1] + " | "  + board[0][2]);
        System.out.println("_______");
        System.out.println(board[1][0] + " | "  + board[1][1] + " | "  + board[1][2]);
        System.out.println("_______");
        System.out.println(board[2][0] + " | "  + board[2][1] + " | "  + board[2][2]);
    }

    public void printRepresentation() {
        System.out.println("1 | 2 | 3");
        System.out.println("_______");
        System.out.println("4 | 5 | 6");
        System.out.println("_______");
        System.out.println("7 | 8 | 9");
    }

    public boolean inputValidator(int input) {
        for (int i = 0; i < 10; i++) {
            if (input == i) {
                return true;
            }
        }
        return false;
    }

    public void resetBoard() {
        board = new char[3][3];
    }

    public void updateBoard(int[] randNumber, char stringUpdate, Deckboard updateTheBoard) {
        board[randNumber[0]][randNumber[1]] = stringUpdate;
        updateTheBoard.printBoard();
    }

    public boolean everythingOccupied() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != stringO && board[i][j] != stringX) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean positionUnoccupied(int input) {
        char[][] representBoard = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int translateInput = input;
        for (int i = 0; i < representBoard.length; i++) {
            for (int j = 0; j < representBoard[i].length; j++) {
                if (representBoard[i][j] == translateInput && board[i][j] == space) {
                    return true;
                }
            }
        }
        return false;
    }

    public int[] inputXorO(int input, char XOrO, Deckboard updateTheBoard) {
        int translatorInput = input;
        char turn = XOrO;
        int[] output = new int[2];
        char[][] representBoard = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int i = 0; i < representBoard.length; i++) {
            for (int j = 0; j < representBoard[i].length; j++) {
                if (representBoard[i][j] == translatorInput) {
                    board[i][j] = turn;
                    output[0] = i;
                    output[1] = j;
                    break;
                }
            }
        }
        updateTheBoard.printBoard();
        return output;
    }

    public int[] generateComputerTurn() {
        Random randomNumber = new Random();
        int[] randNumber = new int[2];
        randNumber[0] = randomNumber.nextInt(2);
        randNumber[1] = randomNumber.nextInt(2);
        while (board[randNumber[0]][randNumber[1]] != space) {
            randNumber[0] = randomNumber.nextInt(2);
            randNumber[1] = randomNumber.nextInt(2);
        }
        return randNumber;
    }

    public boolean boardChecker(int counter) {
        if (counter <= 5) {
            if (board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][2] != space) {
                System.out.println("Game Over!");
                System.out.println("The " + board[0][0] + " has won.");
                return true;
            } else if (board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][2] != space) {
                System.out.println("Game Over!");
                System.out.println("The " + board[1][0] + " has won.");
                return true;
            } else if (board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][2] != space) {
                System.out.println("Game Over!");
                System.out.println("The " + board[2][0] + " has won.");
                return true;
            } else if (board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[2][0] != space) {
                System.out.println("Game Over!");
                System.out.println("The " + board[0][0] + " has won.");
                return true;
            } else if (board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[2][1] != space) {
                System.out.println("Game Over!");
                System.out.println("The " + board[2][1] + " has won.");
                return true;
            } else if (board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[2][2] != space) {
                System.out.println("Game Over!");
                System.out.println("The " + board[2][2] + " has won.");
                return true;
            } else if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[2][2] != space) {
                System.out.println("Game Over!");
                System.out.println("The " + board[0][0] + " has won.");
                return true;
            } else if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[2][0] != space) {
                System.out.println("Game Over!");
                System.out.println("The " + board[2][0] + " has won.");
                return true;
            } 
        }
        return false;
    }
}