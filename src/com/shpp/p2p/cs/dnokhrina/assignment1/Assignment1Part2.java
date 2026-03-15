package com.shpp.p2p.cs.dnokhrina.assignment1;

public class Assignment1Part2 extends SuperKarel {
	public void run() throws Exception {
		//Build first column
		buildColumn();
		
		//continue building while next tiles in a row exist
		while (frontIsClear()) {
			lookForNextColumn();
			if	(facingEast()) buildColumn(); // Explanation for facingEast() is in method "lookForNextColumn()"
		}
	}
	
	private void buildColumn() throws Exception {
		// Go to the wall (to the "x")
		turnLeft();
		moveToWall();
		
		// On the way back, put beepers
		turnAround();
		while (frontIsClear()) {
			if (noBeepersPresent()) putBeeper();
			else move();
		}
		
		//Check last tile for a beeper
		if (noBeepersPresent()) putBeeper();
		turnLeft();
	}
	
	//3 steps right for the next column
	private void lookForNextColumn() throws Exception {
		for (int i = 0; i <= 3; i++) {
			if (frontIsClear()) move();
			
			/* We need to stop the while loop in the main() method, but using boolean variables is not allowed. 
			 * 
			 * However, we can turn the robot south and use that as a makeshift Boolean variable. 
			 * There will never be any cells to the south, so the while loop in the main() method will stop executing and the program will finish.    */
			else turnRight();
		}
	}
}
