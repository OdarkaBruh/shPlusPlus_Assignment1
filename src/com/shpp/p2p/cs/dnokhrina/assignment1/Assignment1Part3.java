package com.shpp.p2p.cs.dnokhrina.assignment1;

public class Assignment1Part3 extends SuperKarel {
	public void run() throws Exception {
		//go to the right filling the row with beepers
		fillLineWithBeepers();
		turnAround();
		
		//while beepers are present - remove them one-by-one from each side
		while (beepersPresent()) {
			removeEdgeBeeper();
		}
		
		//when there is no beepers - come back and put one. It will be the middle.
		stepBack();
		putBeeper();
	}
	
	public void removeEdgeBeeper() throws Exception {
		
		//go to the end of the row (frontIsClear()) or the end of beepers (beepersPresent())
		while (beepersPresent() && frontIsClear()) move();
		
		//If there are no beepers, step back and return to the “line” of beepers to continue removing the outer (edge) ones.
		if(noBeepersPresent()) stepBack();
		
		/* Both lines above basically aim to solve the problem of first pass.
		 * 
		 * During the first pass, the line is completely filled with beepers, so when beepersPresent() will never fail => robot will move outside of the world.
		 * But later we need to find where beepers end, so we need "beepersPresent()"
		 * 
		 * When we find the end of beepers and if this isn't the first pass - the robot will be outside of "beepers-line". So it needs to do a step back.
		 */
		
		//turn around. After that, the robot will “switch to the other side,” and the next call to the method will remove the beeper from the other side.
		turnAround();
		
		//	if beeper is present - remove this outer beeper.
		if (beepersPresent()) {
			pickBeeper();
			if (frontIsClear()) move();
		}
		/* if beeper is not present => we removed all beepers ↓
		 * => the middle is reached, no need to do anything (the main method will put a final beeper) */
	}
}
