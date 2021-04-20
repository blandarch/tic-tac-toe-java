import java.util.Scanner;

public class mainGame {
    public String computerHumanWrongInput() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Do you want to play with a computer or with a human? \n(Type Computer or Human)\n");
        String computerOrHuman = keyboard.nextLine();
        System.out.println(computerOrHuman.toLowerCase());
        while (
            !computerOrHuman.toLowerCase().equals("computer") && 
            !computerOrHuman.toLowerCase().equals("human")
            ) {
            System.out.print("You type the wrong input.\nType Computer or Human\n");
            computerOrHuman = keyboard.nextLine();
        }
        return computerOrHuman;
    }
    public String wantToPlayAgain() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Do you want to play again? (Type Yes or No)\n");
        String yesOrNo = keyboard.nextLine();
        while (
            !yesOrNo.toLowerCase().equals("yes") && 
            !yesOrNo.toLowerCase().equals("no") && 
            !yesOrNo.toLowerCase().equals("y") && 
            !yesOrNo.toLowerCase().equals("n")
            ) {
            System.out.print("Not a valid input. Type Yes or No.\n");
            yesOrNo = keyboard.nextLine();
        }
        return yesOrNo;
    }
    public static void main(String[] args) {
        String playAgain = "yes";
        while (playAgain.toLowerCase().equals("yes") || playAgain.toLowerCase().equals("y")) {
            System.out.println("Tic Tac Toe!");
            mainGame inGame = new mainGame();
            String compHuman = inGame.computerHumanWrongInput();
            if (compHuman.toLowerCase().equals("human")) {
                playHuman playOnlyHuman = new playHuman();
                playOnlyHuman.chooseXOrOThenActualGame();
            } else {
                playComputer playOnlyComputer = new playComputer();
                playOnlyComputer.chooseXOrOThenActualGame();
            }
            playAgain = inGame.wantToPlayAgain();
            if (playAgain.toLowerCase().equals("no") || playAgain.toLowerCase().equals("n")) {
                break;
            }
        }
        

    }
}
