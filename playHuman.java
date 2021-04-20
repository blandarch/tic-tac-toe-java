import java.util.Scanner;

public class playHuman extends playComputer {

    @Override
    public void playMainGame(char player1Char, char player2Char) {
        Deckboard deckToBoard = new Deckboard();
        Scanner keyboard = new Scanner(System.in);
        deckToBoard.resetBoard();

        for (int turn = 0; turn < 6; turn++) {
            System.out.print("Turn: ");
            System.out.println(turn + 1);
            System.out.println("Player1's Turn! Type the number assigned on your desired move.");
            deckToBoard.printRepresentation();
            int player1Turn = keyboard.nextInt();
            while (!deckToBoard.inputValidator(player1Turn) || !deckToBoard.positionUnoccupied(player1Turn)) {
                System.out.println("You type the wrong number or the number you're placing is already occupied.");
                System.out.println("Please try again.");
                player1Turn  = keyboard.nextInt();
            }
            deckToBoard.inputXorO(player1Turn, player1Char, deckToBoard);
            if (boardCheckerAndEverythingOccupied(deckToBoard, turn)) {
                break;
            }
            System.out.println("Player2's Turn! Type the number assigned on your desired move.");
            deckToBoard.printRepresentation();
            int player2Turn = keyboard.nextInt();
            while (!deckToBoard.inputValidator(player2Turn) || !deckToBoard.positionUnoccupied(player2Turn)) {
                System.out.println("You type the wrong number or the number you're placing is already occupied.");
                System.out.println("Please try again.");
                player2Turn = keyboard.nextInt();
            }
            deckToBoard.inputXorO(player2Turn, player2Char, deckToBoard);
            if (boardCheckerAndEverythingOccupied(deckToBoard, turn)) {
                break;
            }
        }
    }

    @Override
    public void chooseXOrOThenActualGame() {
        char player1Char= 'X';
        char player2Char = 'O';
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Player 1, pick your poison.\nType 'X' or 'O'");
        char XOrO = keyboard.next().charAt(0);
        if (Character.toUpperCase(notXOrO(XOrO)) == player1Char) {
            player1Char = 'O';
            player2Char = 'X';
        }
        playMainGame(player1Char, player2Char);
    }
}
