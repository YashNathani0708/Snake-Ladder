# Ladder and Snake Game

This repository contains a simple Java implementation of the classic board game "Snakes and Ladders" designed for two players. The game includes a graphical representation of the board and basic game logic to handle player movements, dice rolls, and the effects of encountering snakes or ladders.

## Contents

- `LadderAndSnake.java`: The main game logic for the Snakes and Ladders game.
- `PlayLadderAndSnake.java`: The entry point for running the game, handling user input for the number of players.
- `Player.java`: A class representing a player in the game, holding attributes such as name, position, and turn status.

## Features

- **Board Representation**: A 10x10 board with numbered squares.
- **Snakes and Ladders**: Predefined positions for snakes and ladders on the board.
- **Two Players**: The game supports two players represented by different icons.
- **Dice Roll**: Simulates rolling a dice to move players.
- **Game Logic**: Handles player turns, movement, encountering snakes and ladders, and determining the winner.

## How to Run

1. **Clone the repository**:
    ```sh
    git clone https://github.com/yourusername/ladder-and-snake.git
    cd ladder-and-snake
    ```

2. **Compile the Java files**:
    ```sh
    javac assignment_1/*.java
    ```

3. **Run the game**:
    ```sh
    java assignment_1.PlayLadderAndSnake
    ```

4. **Input**: The game will prompt for the number of players. Enter `2` to start the game.

## Game Instructions

1. The game is played on a 10x10 board numbered from 1 to 100.
2. Players take turns to roll a dice and move forward according to the dice value.
3. If a player lands at the base of a ladder, they climb up to the top of the ladder.
4. If a player lands on the head of a snake, they slide down to the tail of the snake.
5. The first player to reach exactly square 100 wins the game.
6. If a player lands on the same square as the opponent, the opponent is sent back to the start.

## Example Gameplay

1. **Game Start**:
    ```
    Enter Number of Players =
    2
    Player 1 = 🚴
    Player 2 = 🏄
    ```

2. **Turn Order Decision**:
    ```
    Player 1 got a dice value of 4
    Player 2 got a dice value of 6
    Reached final decision on order of playing: 🏄 than 🚴. It took 1 attempts before a decision could be made.
    ```

3. **Player Turns**:
    ```
    Turn of -> 🏄
    🏄 got a dice value of 3 ; now in square 3
    Game not over; flipping again
    ```

## Classes

### LadderAndSnake.java

- **Attributes**:
  - `numPlayers`: Number of players in the game.
  - `endGame`: Flag indicating if the game has ended.
  - `player1`, `player2`: Player objects representing the two players.
  - `count`: Counter for determining the turn order.
  - `board`: 2D array representing the game board.
  - `snake`, `ladder`: 2D arrays holding positions of snakes and ladders.

- **Methods**:
  - `LadderAndSnake()`: Default constructor initializing players and the game board.
  - `LadderAndSnake(int numPlayers)`: Parameterized constructor for initializing with user input.
  - `flipDice()`: Simulates rolling a dice.
  - `decideFirstTurn()`: Determines the turn order.
  - `gameHelper(Player currentPlayer, Player opponentPlayer)`: Manages game flow.
  - `proceedGame()`: Proceeds with the game based on turn order.
  - `gameRunner(String playerName, Player currentPlayer, Player opponentPlayer, boolean currentPlayerKnockedOut)`: Runs the game logic for each turn.
  - `playGame(Player currentPlayer)`: Handles player movements and encounters with snakes and ladders.
  - `printBoard()`: Prints the current state of the game board.

### Player.java

- **Attributes**:
  - `name`: Player's name/icon.
  - `position`: Player's position on the board.
  - `turn`: Flag indicating if it's the player's turn.
  - `diceValue`: The value obtained from rolling the dice.
  - `knockedOut`: Flag indicating if the player has been knocked out by landing on the same square as the opponent.

- **Methods**:
  - Getters and setters for the attributes.

### PlayLadderAndSnake.java

- **Methods**:
  - `main(String[] args)`: Entry point for the game. Prompts for the number of players and starts the game.

## License

This project is licensed under the MIT License. See the LICENSE file for details.

## Acknowledgements

- Inspired by the classic board game "Snakes and Ladders".
