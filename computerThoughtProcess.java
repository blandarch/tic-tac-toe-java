import java.util.Random;
import java.lang.Math;

public class computerThoughtProcess {

    public void fillDeckboardHorizontal(int i, char newXOrO, Deckboard updateTheBoard) {
        for (int count = 0; count < updateTheBoard.board[i].length; count++) {
            if (updateTheBoard.board[i][count] == 0) {
                updateTheBoard.board[i][count] = newXOrO;
                break;
            }
        }
    }

    public void fillDeckboardVertical(int j, char newXOrO, Deckboard updateTheBoard) {
        for (int count = 0; count < updateTheBoard.board.length; count++) {
            if (updateTheBoard.board[count][j] == 0) {
                updateTheBoard.board[count][j] = newXOrO;
                break;
            }
        }
    }

    public void fillDeckboardSlantRight(char newXOrO, Deckboard updateTheBoard) {
        for (int k = 0; k <= 2 * (updateTheBoard.board.length - 1); k++) {
            int yMin = Math.max(0, k - updateTheBoard.board.length + 1);
            int yMax = Math.min(updateTheBoard.board.length - 1, k);
            for (int y = yMin; y <= yMax; y++) {
                int x = k - y;
                if (x + y == 2 && updateTheBoard.board[y][x] == 0) {
                    updateTheBoard.board[y][x] = newXOrO;
                    break;
                } 
            }
        }
    }

    public void fillDeckboardSlantLeft(char newXOrO, Deckboard updateTheBoard) {
        for (int y = 0; y < updateTheBoard.board.length; y++) {
            for (int x = 0; x < updateTheBoard.board.length; x++) {
                for (int z = 0; z < updateTheBoard.board.length-y-x; z++) {
                    if (
                        (x + z == 0 || x + z == 1 || x + z == 2) &&
                        (y + z == 0 || y + z == 1 || y + z == 2) &&
                        updateTheBoard.board[y][x] == 0
                        ) {
                        updateTheBoard.board[y][x] = newXOrO;
                        break;
                    }
                }
            }
        }
    }

    public void generateNewComputerTurn(int i, int j, char newXOrO, Deckboard updateTheBoard) {
        Random randomNumber = new Random();
        int newI = randomNumber.nextInt(2);
        int newJ = randomNumber.nextInt(2);
        while (newI == i && newJ == j) {
            newI = randomNumber.nextInt(2);
            newJ = randomNumber.nextInt(2);
        }
        updateTheBoard.board[newI][newJ] = newXOrO;
    }

    public void thoughtProcess(int i, int j, char XOrO, Deckboard updateTheBoard) {
        char newXOrO;
        if (XOrO == 'X') {
            newXOrO = 'O';
        } else {
            newXOrO = 'X';
        }

        Random randomNumber = new Random();

        if (i == 0 && j == 0) {
            if (updateTheBoard.board[0][0] == updateTheBoard.board[0][1] || updateTheBoard.board[0][0] == updateTheBoard.board[0][2]) {
                System.out.println("It goes here! (horizontal)");
                fillDeckboardHorizontal(i, newXOrO, updateTheBoard);
            } else if (updateTheBoard.board[0][0] == updateTheBoard.board[1][0] || updateTheBoard.board[0][0] == updateTheBoard.board[2][0]) {
                System.out.println("It goes here! (vertical)");
                fillDeckboardVertical(j, newXOrO, updateTheBoard);
            } else if (updateTheBoard.board[0][0] == updateTheBoard.board[1][1] || updateTheBoard.board[0][0] == updateTheBoard.board[2][2]) {
                System.out.println("It goes here! (slant left)");
                fillDeckboardSlantLeft(newXOrO, updateTheBoard);
            } else {
                System.out.println("It goes here! (random)");
                generateNewComputerTurn(i, j, newXOrO, updateTheBoard);
            }
        } else if (i == 0 && j == 1) {
            if (updateTheBoard.board[0][1] == updateTheBoard.board[0][2] || updateTheBoard.board[0][1] == updateTheBoard.board[0][0]) {
                System.out.println("It goes here 2! (horizontal)");
                fillDeckboardHorizontal(i, newXOrO, updateTheBoard);
            } else if (updateTheBoard.board[0][1] == updateTheBoard.board[1][1] || updateTheBoard.board[0][1] == updateTheBoard.board[2][1]) {
                System.out.println("It goes here 2! (vertical)");
                fillDeckboardVertical(j, newXOrO, updateTheBoard);
            } else {
                System.out.println("It goes here 2! (random)");
                generateNewComputerTurn(i, j, newXOrO, updateTheBoard);
            }
        } else if (i == 0 && j == 2) {
            if (updateTheBoard.board[0][2] == updateTheBoard.board[0][1] || updateTheBoard.board[0][2] == updateTheBoard.board[0][0]) {
                System.out.println("It goes here 3! (horizontal)");
                fillDeckboardHorizontal(i, newXOrO, updateTheBoard);
            } else if (updateTheBoard.board[0][2] == updateTheBoard.board[1][2] || updateTheBoard.board[0][2] == updateTheBoard.board[2][2]) {
                System.out.println("It goes here 3! (vertical)");
                fillDeckboardVertical(j, newXOrO, updateTheBoard);
            } else if (updateTheBoard.board[0][2] == updateTheBoard.board[1][1] || updateTheBoard.board[0][2] == updateTheBoard.board[2][0]) {
                System.out.println("It goes here 3! (slant right)");
                fillDeckboardSlantRight(newXOrO, updateTheBoard);
            } else {
                System.out.println("It goes here 3! (random)");
                generateNewComputerTurn(i, j, newXOrO, updateTheBoard);
            }
        } else if (i == 1 && j == 0) {
            if (updateTheBoard.board[1][0] == updateTheBoard.board[1][1] || updateTheBoard.board[1][0] == updateTheBoard.board[1][2]) {
                System.out.println("It goes here 4! (horizontal)");
                fillDeckboardHorizontal(i, newXOrO, updateTheBoard);
            } else if (updateTheBoard.board[1][0] == updateTheBoard.board[0][0] || updateTheBoard.board[1][0] == updateTheBoard.board[2][0]) {
                System.out.println("It goes here 4! (vertical)");
                fillDeckboardVertical(j, newXOrO, updateTheBoard);
            } else {
                System.out.println("It goes here 4! (random)");
                generateNewComputerTurn(i, j, newXOrO, updateTheBoard);
            }
        } else if (i == 1 && j == 1) {
            if (updateTheBoard.board[1][1] == updateTheBoard.board[1][0] || updateTheBoard.board[1][1] == updateTheBoard.board[1][2]) {
                System.out.println("It goes here 5! (horizontal)");
                fillDeckboardHorizontal(i, newXOrO, updateTheBoard);
            } else if (updateTheBoard.board[1][1] == updateTheBoard.board[0][1] || updateTheBoard.board[1][1] == updateTheBoard.board[2][1]) {
                System.out.println("It goes here 5! (vertical)");
                fillDeckboardVertical(j, newXOrO, updateTheBoard);
            } else if (updateTheBoard.board[1][1] == updateTheBoard.board[0][0] || updateTheBoard.board[1][1] == updateTheBoard.board[2][2]) {
                System.out.println("It goes here 5! (slant left)");
                fillDeckboardSlantLeft(newXOrO, updateTheBoard);
            } else if (updateTheBoard.board[1][1] == updateTheBoard.board[0][2] || updateTheBoard.board[1][1] == updateTheBoard.board[2][0]) {
                System.out.println("It goes here 5! (slant right)");
                fillDeckboardSlantRight(newXOrO, updateTheBoard);
            } else {
                System.out.println("It goes here 5! (random)");
                generateNewComputerTurn(i, j, newXOrO, updateTheBoard);
            }
        } else if (i == 1 && j == 2) {
            if (updateTheBoard.board[1][2] == updateTheBoard.board[1][1] || updateTheBoard.board[1][2] == updateTheBoard.board[1][0]) {
                System.out.println("It goes here 6! (horizontal)");
                fillDeckboardHorizontal(i, newXOrO, updateTheBoard);
            } else if (updateTheBoard.board[1][2] == updateTheBoard.board[0][2] || updateTheBoard.board[1][2] == updateTheBoard.board[2][2]) {
                System.out.println("It goes here 6! (vertical)");
                fillDeckboardVertical(j, newXOrO, updateTheBoard);
            } else {
                System.out.println("It goes here 6! (random)");
                generateNewComputerTurn(i, j, newXOrO, updateTheBoard);
            }
        } else if (i == 2 && j == 0) {
            if (updateTheBoard.board[2][0] == updateTheBoard.board[2][1] || updateTheBoard.board[2][0] == updateTheBoard.board[2][2]) {
                System.out.println("It goes here 7! (horizontal)");
                fillDeckboardHorizontal(i, newXOrO, updateTheBoard);
            } else if (updateTheBoard.board[2][0] == updateTheBoard.board[1][0] || updateTheBoard.board[2][0] == updateTheBoard.board[0][0]) {
                System.out.println("It goes here 7! (vertical)");
                fillDeckboardVertical(j, newXOrO, updateTheBoard);
            } else if (updateTheBoard.board[2][0] == updateTheBoard.board[1][1] || updateTheBoard.board[2][0] == updateTheBoard.board[0][2]) {
                System.out.println("It goes here 7! (slant right)");
                fillDeckboardSlantRight(newXOrO, updateTheBoard);
            } else {
                System.out.println("It goes here 7! (random)");
                generateNewComputerTurn(i, j, newXOrO, updateTheBoard);
            }
        } else if (i == 2 && j == 1) {
            if (updateTheBoard.board[2][1] == updateTheBoard.board[2][0] || updateTheBoard.board[2][1] == updateTheBoard.board[2][2]) {
                System.out.println("It goes here 8! (horizontal)");
                fillDeckboardHorizontal(i, newXOrO, updateTheBoard);
            } else if (updateTheBoard.board[2][1] == updateTheBoard.board[1][1] || updateTheBoard.board[2][1] == updateTheBoard.board[0][1]) {
                System.out.println("It goes here 8! (vertical)");
                fillDeckboardVertical(j, newXOrO, updateTheBoard);
            } else {
                System.out.println("It goes here 8! (random)");
                generateNewComputerTurn(i, j, newXOrO, updateTheBoard);
            }
        } else {
            if (updateTheBoard.board[2][2] == updateTheBoard.board[2][1] || updateTheBoard.board[2][2] == updateTheBoard.board[2][0]) {
                System.out.println("It goes here 9! (horizontal)");
                fillDeckboardHorizontal(i, newXOrO, updateTheBoard);
            } else if (updateTheBoard.board[2][2] == updateTheBoard.board[1][2] || updateTheBoard.board[2][2] == updateTheBoard.board[0][2]) {
                System.out.println("It goes here 9! (vertical)");
                fillDeckboardVertical(j, newXOrO, updateTheBoard);
            } else if (updateTheBoard.board[2][2] == updateTheBoard.board[1][1] || updateTheBoard.board[2][2] == updateTheBoard.board[0][0]) {
                System.out.println("It goes here 9! (slant left)");
                fillDeckboardSlantLeft(newXOrO, updateTheBoard);
            } else {
                System.out.println("It goes here 9! (random)");
                generateNewComputerTurn(i, j, newXOrO, updateTheBoard);
            }
        }
    }   
}
