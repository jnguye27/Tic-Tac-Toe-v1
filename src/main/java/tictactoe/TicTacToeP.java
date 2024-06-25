package tictactoe;

public class TicTacToeP {
  // Declaring and initializing variables
  private static char playerTurn = 'X'; 
  private static int depth = 0; 
  private static int position;
  private static char[] board = {
    '0','|','1','|','2','\n',
    '-','+','-','+','-','\n',
    '3','|','4','|','5','\n',
    '-','+','-','+','-','\n',
    '6','|','7','|','8','\n'
  };
  private static int[] posToIndex = {0,2,4,12,14,16,24,26,28};

  // Prints out the updated board
  public static void printBoard() {
    System.out.println(board);
  }

  // A mutator that puts user input into the variable "position" for this class to use
  public static void setPosition(int positionMain) {
    position = positionMain;
  }

  // Checks if the given position is "Out Of Bounds"
  public static boolean outBounds() {
    if (position > 8 || position < 0) {
      return true;
    }
    return false;
  } 

  // Increases depth whenever someone takes a turn (max 9 turns)
  public static void increaseDepth() {
    depth++;
  }

  // An accessor that returns the depth value
  public static int getDepth() {
    return depth;
  }

  // A mutator that converts the position on the board to PLAYER X or O's spot
  public static void setBoardPosition() {
    board[posToIndex[position]] = playerTurn;
  }

  // An accessor that returns a player's turn (returns X or O)
  public static char getTurn() {
    return playerTurn;
  }

  // A mutator that switches player turn
  public static void setTurn(char turn) {
    if (turn == 'X') {
      turn = 'O';
    } else {
      turn = 'X';
    }
    playerTurn = turn;
  }

  /*Checks if either player has chosen an invalid number on the board (taken spot)
  Can't have the previous parameters because of the board array parameter*/
  public static boolean checkBoard() {
    if (
      board[posToIndex[position]] == 'X' 
      ||
      board[posToIndex[position]] == 'O'
    ) {
      return true;
    }
    return false;
  }

  /*Checks if there are any wins or ties (patterns)
  Can't have the previous parameters because of the board array parameter*/
  public static boolean winner() {
    char winner = '?';
    for (int i = 0; i < 3; i++){
      if (board[posToIndex[i]] == board[posToIndex[i+3]] 
        && 
        board[posToIndex[i+3]]== board[posToIndex[i+6]]) {
        winner = board[posToIndex[i]];
        break;
      }
    }

    if(winner == '?'){
      if (board[posToIndex[0]] == board[posToIndex[4]] 
        &&
        board[posToIndex[4]] == board[posToIndex[8]]) {
        winner = board[posToIndex[0]];
      }
      if (board[posToIndex[2]] == board[posToIndex[4]] 
        && 
        board[posToIndex[4]] == board[posToIndex[6]]) {
        winner = board[posToIndex[2]];
      }
    }

    if(winner == '?'){
      for (int i = 0; i <= 6; i+=3){
        if (board[posToIndex[i]] == board[posToIndex[i+1]] 
          &&
          board[posToIndex[i+1]] == board[posToIndex[i+2]]) {
          winner = board[posToIndex[i]];
          break;
        }
      }
    }

    // If depth = 9, no more spots are left (tie)
    if (depth == 9) {
      System.out.println("The Game was a Tie!");
      System.exit(0);
    } else if (winner != '?'){
      System.out.println("The winner is player " + winner + "!");
      System.exit(0);
    } 
    return true;
  }

  /* Main in TicTacToeP
  public static void main(String[] args) {
    System.out.println(board);
    System.out.println("Turn = X");

    while (winner(depth,board)) {
      System.out.print("Enter Position between 1 and 9:\n");
      position = input.nextInt();

      if (position > board.length) {
        System.out.println("Error - Out of Bounds");
      } else {
        if (checkBoard(position,board)) {
          System.err.println("Illegal Move! Try Again");
        } else {
          depth++;
          board[posToIndex[position]] = playerTurn;
          System.out.println(board);
          setTurn(playerTurn);
          if (depth != 9) {
            System.out.println("Turn = " + playerTurn);
          }
        }
      }
    } 
    setTurn(playerTurn);
    System.out.println("Winner = " + playerTurn); 
  }
  */
}