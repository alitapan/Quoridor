package ca.mcgill.ecse223.quoridor.controller;


import java.sql.Time;
import java.util.List;

import ca.mcgill.ecse223.quoridor.QuoridorApplication;
import ca.mcgill.ecse223.quoridor.model.*;
import ca.mcgill.ecse223.quoridor.model.Game.GameStatus;
import ca.mcgill.ecse223.quoridor.model.Game.MoveMode;



public class Controller {
	
  /**
   * <p> Start New Game <p>
   * <p> Initialize a new Game object.
   * @return the created initialized Game object
   * 
   * @author Ali Tapan
   * @version 2.0
   */
  public static Game startNewGame() {
	 Quoridor quoridor = QuoridorApplication.getQuoridor();
	 Game game = new Game(GameStatus.Initializing, MoveMode.PlayerMove, quoridor);
	 return game;
  }
  	
  /**
   * <p> Initialize White Player <p>
   * <p> Initializes a white player and assigns it <p>
   * @param username
   * @return Player object
   * 
   * @author Ali Tapan
   * @version 1.0
   */
  public static Player initWhitePlayer(String username) {
	  Quoridor quoridor = QuoridorApplication.getQuoridor();
	  User user = quoridor.addUser(username);
	  Player p = new Player(Time.valueOf("00:01:00"), user, 1, Direction.Vertical);
	  quoridor.getCurrentGame().setWhitePlayer(p);
	  return p;
  }
  
  /**
   * <p> Initialize Black Player <p>
   * <p> Initialize a black player and assigns it <p>
   * @param username
   * @return Player object
   * 
   * @author Ali Tapan
   * @version 1.0
   */
  public static Player initBlackPlayer(String username) {
	  Quoridor quoridor = QuoridorApplication.getQuoridor();
	  User user = quoridor.addUser(username);
	  Player p = new Player(Time.valueOf("00:01:00"), user, 9, Direction.Vertical);
	  quoridor.getCurrentGame().setBlackPlayer(p);
	  return p;
  }
  /**
   * <p> Set Total Thinking Time <p>
   * <p> Set the total thinking time for player.
   * 
   * @author Ali Tapan
   * @version 2.0
   */
  public static void setTotalThinkingTime(String time) {
	  Quoridor quoridor = QuoridorApplication.getQuoridor();
	  String error = "";
	  Time remaining = null;
	  
			  try {
				  remaining = Time.valueOf(time);
			  }catch (IllegalArgumentException e) {
				 error=e.getMessage(); 
			  }
			  
	  quoridor.getCurrentGame().getBlackPlayer().setRemainingTime(remaining);
	  quoridor.getCurrentGame().getWhitePlayer().setRemainingTime(remaining);
	  quoridor.getCurrentGame().setGameStatus(GameStatus.ReadyToStart);
  }
  
  
  /**
   * <p> Start the Clock <p>
   * <p> Initiates the game timer which starts when the game is running.
   * 
   * @author Ali Tapan
   * @version 2.0
   */
  public static void startClock() {
	  
	  Quoridor quoridor = QuoridorApplication.getQuoridor();
	  quoridor.getCurrentGame().setGameStatus(GameStatus.Running);
}
  
  /**
   * <p> Select an Existing Username <p>
   * <p> The user selects an existing user name that was previously used in a game
   * @param username is a String that is the existing user name
   * @returns a Boolean, true if it successfully sets the username, false otherwise
   * @author Ali Tapan
   * @version 2.0
   */
  public static Boolean selectExistingUsername(String username, Player player) {
	  
	  if(username.equals(null))
	  {
		 return false;
	  }
	  if(User.hasWithName(username) == false)
	  {
		  return false;
	  }
	  
	  Quoridor quoridor = QuoridorApplication.getQuoridor();
	  //Iterate through the users to see if they match the user name provided
	  for(int i = 0; i < quoridor.numberOfUsers(); i++)
	  {
		  User user = quoridor.getUser(i);
		  if(user.getName().equals(username))
		  {
			 player.setUser(user);
			 return true;
		  }
	  }
	  return false;
}
  
  
  /**
   * <p> Provide a New Username <p>
   * <p> The user selects/enters a new user name that was not previously used in a game
   * @param username is a String that is the new user name
   * @return returns a Boolean, true if it successfully sets the username, false otherwise
   * @author Ali Tapan
   * @verison 2.0
   */
  public static Boolean provideNewUsername(String username, Player player) {
	  if(User.hasWithName(username) == true)
	  {
		  return false;
	  }
	  Quoridor quoridor = QuoridorApplication.getQuoridor();
	  player.getUser().setName(username);
	 // User user = quoridor.addUser(username);
	  //player.setUser(user);
	  return true;
}
  
  
  /**
   * @author Sam Perreault
   * Sets the starting thinking time for the players. Time is accepted as minutes and seconds,
   * and is converted to milliseconds.
   * @param minute The number of minutes allowed to each player
   * @param second The number of seconds allowed to each player
   */
  public static void  setPlayerThinkingTime(int minute, int second) {
}

  /**
   * @author Sam Perreault
   * Generates the board, and sets the starting position and walls of each player.
   * In addition, sets white/player 1 as the player to move, and starts counting down
   * the white player's thinking time.
   */
  public static void initializeBoard() {
}

  /**
   * @author Luke Barber
   * Grabs a given wall and holds it so that it is ready for use. 
   * @param wall The wall that will be grabbed
   */
	public static void grabWall(Wall wall) {
}
		// TODO Auto-generated method stub

	
	/**
   * @author Luke Barber
   * Rotates a given wall that is on the board. 
   * @param wall The wall that will be rotated
   */
	public static void rotateWall(Wall wall) {
		}
	
  /**
	 * <p> 7. Move Wall <p>
	 * <p>moveWall method that allows a player to move the wall that they have in their hand over the board. 
	 * It will be allowed to move over the rows and columns of the board and also give an error when it is placed in an incorrect position.<p>
	 *
	 * @author arneetkalra
	 * @param wallMoveCandidate 
	 * @param side references the Wall that player will have in their hand
	 * @return void method but allows player to manipulate wall over board 
	 */
	public static void moveWall(WallMove wallMoveCandidate, String side) {
}
	
	/**
	 * <p> 8. Drop Wall <p>
	 * <p>dropWall method that allows player to place the wall after navigating to the designated (and valid) area in order to register
	 * the wall placement as a move for the player. <p>
	 * @author arneetkalra
	 * @param aWall references the Wall that player will have in their hand
	 * @return void method but drops wall which prompts end of player turn
	 */
	public static void dropWall(WallMove wallMoveCandidate) {
	}
	/**
	 *<p> Boolean method that returns if a WallMove has been completed<p>
	 * @author arneetkalra
	 * @param moveWall
	 * @return boolean
	 */
	public static boolean isWallMoved(WallMove movedWall) {
		return false;
	}
	
	/**
	 * <p>Boolean method that can check if a wall was moved to a certain row and column <p>
	 * @author arneetkalra
	 * @param row the reference of the row 
	 * @param col the reference of the column
	 * @return boolean
	 */
	public static boolean isWallMovedTo(int row, int col) {
		return false;
	}
  /**
	 * 
	 * Load the game from the game file. 
	 * load the correct player position and wall position
	 * @author Yin
	 * @param quoridor This is the quoridor you want to load the game into
	 * @param fileName This is the name of the file which stores the game
	 * 
	 * */
	public static Quoridor loadPosition(Quoridor quoridor, String fileName) {
	return null;
}
	
	
	/**
	 * Save the game into a game file
	 * @author Yin
	 * @param fileName
	 * */
	public static void savePosition(String fileName, GamePosition gamePosition) {
	}
	
	/**
	 * @author Yin Zhang 260726999
  	 * The user confirm whether to overwrite the existing file
  	 * */
	public static void confirmsToOverWrite() {
	}
	
	  /**
	 * <p>11 Validate Position<p>
	 * <p>validate if the player positions and wall positions are valid 
	 * e.g. overlapping walls or outof-track pawn or wall positions. <p>
	 * 
	 * @author William Wang
	 * @param position the currentPosition object of the game
	 * @return the validation result, true for pass, false for error
	 */
	public static boolean validatePosition(GamePosition position) {
		return false;
	}
		
	/**
	 * <p>12. Switch player (aka. Update board)<p>
	 * <p>Switch current player and update clock <p>
	 * 
	 * @author William Wang
	 * @param game the current quoridor game
	 */
	public static void switchCurrentPlayer(Game game) {
	}

}


