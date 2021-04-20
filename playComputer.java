import java.util.Scanner;

public class playComputer {
    public char notXOrO(char XOrO) {
        char x = 'x';
        char o = 'o';
        Scanner keyboard = new Scanner(System.in);
        while (Character.toLowerCase(XOrO) != x && Character.toLowerCase(XOrO) != o) {
            System.out.println("Wrong input. Type 'X' or 'O'");
            XOrO = keyboard.next().charAt(0);
        }
        return XOrO;
    }

    public boolean boardCheckerAndEverythingOccupied(Deckboard deckToBoard, int turn) {
        if (deckToBoard.boardChecker(turn)) {
            return true;
        } else if (deckToBoard.everythingOccupied()) {
            System.out.println("Looks like everything is occupied, It's a tie!");
            System.out.println("Game Over");
            return true;
        }
        return false;
    }

    public void playMainGame(char compString, char humString) {
        Deckboard deckToBoard = new Deckboard();
        Scanner keyboard = new Scanner(System.in);
        computerThoughtProcess computerStrategy = new computerThoughtProcess();
        int[] coordinatesOutputHumanTurn = new int[2];
        deckToBoard.resetBoard();
        for (int turn = 0; turn < 6; turn++) {
            System.out.print("Turn: ");
            System.out.println(turn + 1);
            if (coordinatesOutputHumanTurn == null) {
                System.out.println("coordinatesOutputHumanTurn == null");
                int[] computerTurn = deckToBoard.generateComputerTurn();
                deckToBoard.updateBoard(computerTurn, compString, deckToBoard);
            } else {
                computerStrategy.thoughtProcess(coordinatesOutputHumanTurn[0], coordinatesOutputHumanTurn[1], humString, deckToBoard);
                deckToBoard.printBoard();
            }
            if (boardCheckerAndEverythingOccupied(deckToBoard, turn)) {
                break;
            }
            System.out.println("Your turn! Type the number assigned on your desired move.");
            deckToBoard.printRepresentation();
            int humanTurn = keyboard.nextInt();
            while (!deckToBoard.inputValidator(humanTurn) || !deckToBoard.positionUnoccupied(humanTurn)) {
                System.out.println("You type the wrong number or the number you're placing is already occupied.");
                System.out.println("Please try again.");
                humanTurn = keyboard.nextInt();
            }
            coordinatesOutputHumanTurn = deckToBoard.inputXorO(humanTurn, humString, deckToBoard);
            if (boardCheckerAndEverythingOccupied(deckToBoard, turn)) {
                break;
            }
            System.out.println("Computer's Turn");
        }
    }
    public void chooseXOrOThenActualGame() {
        char compString = 'X';
        char humString = 'O';
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Pick your poison.\nType 'X' or 'O'");
        char XOrO = keyboard.next().charAt(0);
        if (Character.toUpperCase(notXOrO(XOrO)) == compString) {
            compString = 'O';
            humString = 'X';
        }
        playMainGame(compString, humString);
    }
}
