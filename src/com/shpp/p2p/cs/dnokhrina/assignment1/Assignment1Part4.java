package com.shpp.p2p.cs.dnokhrina.assignment1;

/*
  	Black tiles are always one tile apart. The robot starts at a black tile. 
  
  	Therefore, throughout this task, to recreate the chessboard, 
  	it will almost always simply move two tiles away from the previous black tile to find the next one.
  	
  	Code example:
  	
  			if (beepersPresent()) {
				move(); // →
				if(frontIsClear()) {
					move(); // →
					putBeeper();
				}
			}
  	
 */
public class Assignment1Part4 extends SuperKarel {
	public void run() throws Exception {
		
		//Check for 1x1 or 1xN world
		turnLeft();
		if (rightIsBlocked()) fill_1xN_World();
		
		else { // Guaranteed that world is at least 2 tiles wide
			//Put the first beeper
			turnRight();
			putBeeper();
			
			//Fill in The first line
			fillRow();
			
			//as long as the next row exists (↑) => move up and fill it in
			while (frontIsClear()) {
				moveToNextRow();
				fillRow();
			};
		}
	}
	
	private void fillRow() throws Exception {
		//Facing east => while there are cells in the row in front of Karel
		while (frontIsClear()) {
			//Karel start at the beeper. So, just do 2 steps and place next beeper.
			if (beepersPresent()) {
				move(); // →
				//This check for the end of row. Otherwise, if board's width isn't even number - bot will run from the world (aka Error)
				if(frontIsClear()) {
					move(); // →
					putBeeper();
				}
			}
		}
		
		//Return to the starting position (move to the beginning of the row and turn north)
		goBack();
		turnRight();
	}
	
	//Need not only to move to the next row, but also keep the grid => also need to find the first black tile of the next row and mark it.
	private void moveToNextRow() throws Exception {
		//if on black tile ==> try to put one diagonally
		if (beepersPresent()) {
			// Karel is on a black tile at the beginning of the row => move diagonally to find the first black tile in the next row
			move(); // ↑
			turnRight(); 
			move(); // →
			putBeeper(); //first black tile of the row
		}
		
		//if on the white tile ==> directly above the robot will be first black tile of the next row.
		else {
			move();
			putBeeper();
			turnRight(); //At the end of this method, the robot must be facing east to begin filling in the row.
		}
	}
	
	private void fill_1xN_World() throws Exception {
		putBeeper(); //put first beeper
		while (frontIsClear()) { //Continue until top is reached
			move();
			if (frontIsClear()) { //If inside if to track the grid without boolean variables
				move();
				putBeeper();
			}
		}
	}
}
