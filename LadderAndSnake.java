package assingment_1;

import java.util.Random;

public class LadderAndSnake {
	// initializing array and variables
	private int numPlayers;

	private boolean endGame = false;

	private Player player1;
	private Player player2;

	private int count = 0;

	private static final int[][] board = { { 100, 99, 98, 97, 96, 95, 94, 93, 92, 91 }, // 0
			{ 81, 82, 83, 84, 85, 86, 87, 88, 89, 90 }, // 1
			{ 80, 79, 78, 77, 76, 75, 74, 73, 72, 71 }, // 2
			{ 61, 62, 63, 64, 65, 66, 67, 68, 69, 70 }, // 3
			{ 60, 59, 58, 57, 56, 55, 54, 53, 52, 51 }, // 4
			{ 41, 42, 43, 44, 45, 46, 47, 48, 49, 50 }, // 5
			{ 40, 39, 38, 37, 36, 35, 34, 33, 32, 31 }, // 6
			{ 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 }, // 7
			{ 20, 19, 18, 17, 16, 15, 14, 13, 12, 11 }, // 8
			{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 },// 9
	};
	private int[][] snake = new int[][] { { 16, 6 }, { 48, 30 }, { 64, 60 }, { 79, 19 }, { 93, 68 }, { 95, 24 },
			{ 97, 76 }, { 98, 78 } };
	private int[][] ladder = new int[][] { { 1, 38 }, { 4, 14 }, { 9, 31 }, { 28, 84 }, { 21, 42 }, { 36, 44 },
			{ 51, 67 }, { 71, 91 }, { 80, 100 } };

	// default Constructor
	public LadderAndSnake() {
		numPlayers = 2;
		player1 = new Player("🚴");
		player2 = new Player("🏄");
	}

	// Parameterized Constructor for letting a player enter into a game
	public LadderAndSnake(int numPlayers) {
		if (numPlayers == 2) {
			player1 = new Player("🚴");
			player2 = new Player("🏄");
			System.out.println("Voila! Let's begin the Game");
			
		} else if (numPlayers > 2) {
			numPlayers = 2;
			player1 = new Player("🚴");
			player2 = new Player("🏄");
			System.out
					.println("WARNING, The game is design for only 2 people, Please try again entering the value - 2 ");

			// setting players to 2
		} else {
			System.out.println("Sorry: Cannot Start the game with less than 2 players! Program exit");
			System.exit(numPlayers);
		}
	}

	// random dice method
	public int flipDice() {
		Random random = new Random();
		int lowerLimit = 1;// setting limit
		int upperLimit = 7;

		return random.nextInt(lowerLimit, upperLimit);
	}

	public void decideFirstTurn() {// deciding which player starts first
		do {
			if (count > 0) {
				System.out.println("Player 1 got a dice value of " + player1.getDiceValue());
				System.out.println("Player 2 got a dice value of " + player2.getDiceValue());
				System.out.println("A tie was achieved between Player 1 and Player 2. Attempting to break the tie");
			}
			player1.setDiceValue(flipDice());
			player2.setDiceValue(flipDice());
			count++;
		} while (player1.getDiceValue() == player2.getDiceValue());
	}

	public void gameHelper(Player currentPlayer, Player opponentPlayer) {

		currentPlayer.setTurn(true);

		while (true) {
			if (currentPlayer.getTurn()) {
				gameRunner(currentPlayer.getName(), currentPlayer, opponentPlayer, currentPlayer.isKnockedOut());
				currentPlayer.setTurn(false);
				opponentPlayer.setTurn(true);
			} else {
				gameRunner(opponentPlayer.getName(), opponentPlayer, currentPlayer, opponentPlayer.isKnockedOut());
				currentPlayer.setTurn(true);
				opponentPlayer.setTurn(false);
			}
		}
	}

	public void proceedGame() {
		if (player1.getDiceValue() < player2.getDiceValue()) {
			System.out.println("player 2 got a dice value" + player2.getDiceValue());
			System.out.println("Reached final decision on order of playing: " + player2.getName() + " than "
					+ player1.getName() + ". It took " + count + " attempts before a decision could be made.");

			gameHelper(player2, player1);

		} else {
			System.out.println("player 1 got a dice value" + player1.getDiceValue());
			System.out.println("Reached final decision on order of playing: " + player1.getName() + " than "
					+ player2.getName() + ". It took " + count + " attempts before a decision could be made.");

			gameHelper(player1, player2);

		}
	}

	public void gameRunner(String playerName, Player currentPlayer, Player opponentPlayer,
			boolean currentPlayerKnockedOut) {
		System.out.println("\nTurn of -> " + playerName);
		if (currentPlayerKnockedOut) {
			System.out.println("Oops, knocked out by opponent - moved to " + player1.getPosition());
			currentPlayer.setKnockedOut(false);
		}

		currentPlayer.setDiceValue(flipDice());

		playGame(currentPlayer);

		if (opponentPlayer.getPosition() == currentPlayer.getPosition()) {
			opponentPlayer.setPosition(0);
			opponentPlayer.setKnockedOut(true);
		}

		System.out.println(playerName + " got a dice value of " + currentPlayer.getDiceValue() + " ; now in square "
				+ currentPlayer.getPosition());

		if (!(endGame)) {
			System.out.println("Game not over; flipping again");
		} else {
			System.out.println("Game Ended!! " + playerName + " won the game. :)");
			System.exit(0);
		}

		printBoard();
	}

	public void playGame(Player currentPlayer) {// play method
		int playerPosition = currentPlayer.getDiceValue() + currentPlayer.getPosition();// adding player position

		if (playerPosition > 100) {
			int difference = playerPosition - 100;// difference from 100
			playerPosition = 100 - difference;
		}

		for (int[] value : ladder) {
			if (playerPosition == value[0]) {
				playerPosition = value[1];
				System.out.println("Hurray, encountered a ladder 🪜 !! Moved to " + playerPosition);
			}
		}

		for (int[] ints : snake) {
			if (playerPosition == ints[0]) {
				playerPosition = ints[1];
				System.out.println("Ohh, encountered a snake 🐍 !! Moved to " + playerPosition);
			}
		}

		if (playerPosition > 100) {
			int difference = playerPosition - 100;
			playerPosition = 100 - difference;
		}

		if (playerPosition == 100) {
			endGame = true;
		}

		currentPlayer.setPosition(playerPosition);
	}

	public void printBoard() {
		System.out.println("----------------------------PLAYING BOARD----------------------------");
		for (int[] ints : board) {
			for (int anInt : ints) {
				if (anInt == player1.getPosition()) {
					System.out.print(player1.getName() + " ");
				} else if (anInt == player2.getPosition()) {
					System.out.print(player2.getName() + " ");
				} else {
					System.out.print(anInt + " ");
				}
			}
			System.out.println();
			
		}
	}
}
