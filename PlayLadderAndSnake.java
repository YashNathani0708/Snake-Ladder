package assingment_1;

//main method
import java.util.Scanner;

public class PlayLadderAndSnake {
	public static void main(String[] args) {
		System.out.println("Enter Number of Players = ");
		Scanner playIn = new Scanner (System.in);
		int numPlayers = playIn.nextInt();
		System.out.println("Player 1 = 🚴 ");
		System.out.println("Player 1 = 🏄 \n");


		LadderAndSnake ladderAndSnakeGameBoard = new LadderAndSnake(numPlayers);

		ladderAndSnakeGameBoard.decideFirstTurn();

		ladderAndSnakeGameBoard.proceedGame();
		
	}
}
