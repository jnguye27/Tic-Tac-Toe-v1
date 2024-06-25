/* 
Program: Tic-Tac-Toe 
Creator: Jessica Nguyen
Date: 2022-09-27
Note: Majority of functions are void since all of the needed values are within TicTacToeP.java
The only issue with this program is that it doesn't allow char, but since our only objective 
is to make this program object oriented, I felt no need to fix it (+ main's line limit).
*/

// Same like #define, imports commands
import java.util.Scanner;

public class Runner {
  public static void main(String[] args) {
    /*2 new variables created
    tictactoe. prefix needed or else an "error: cannot find symbol" occurs*/
    tictactoe.TicTacToeP game;
    Scanner input;
    
    game = new tictactoe.TicTacToeP();
    input = new Scanner(System.in);

    // Prints the starter board, player X starts
    game.printBoard();
    System.out.println("Turn = X");

    // Loops the program until there is a winner (game.winner == true)
    while (game.winner()) {
      System.out.print("Enter a position between 0 and 8:\n");
      
      // Asks user input for chosen position
      game.setPosition(input.nextInt());

      // If the inputted value is out of range, prints an error
      if (game.outBounds()) {
        System.out.println("\nError - Out of Bounds");
      } else {
        // If the move is unavailable, prints an error
        if (game.checkBoard()) {
          System.err.println("\nError - Illegal Move");
        } else {
          /*If the move is valid...
          depth = depth + 1;*/
          game.increaseDepth();
          // Change the value of the position on the board to O or X
          game.setBoardPosition();
          // Print out the new board
          game.printBoard();
          // Switch turns
          game.setTurn(game.getTurn());
          // If the depth is 9 + no winner, end the game in a tie
          if (game.getDepth() != 9) {
            System.out.println("Turn = " + game.getTurn());
          }
        }
      }
    }
    game.setTurn(game.getTurn());
    System.out.println("Winner = " + game.getTurn());
  }
}
