package com.shpp.p2p.cs.dnokhrina.assignment1;

import com.shpp.karel.KarelTheRobot;

//Function names describe exactly what they do
public class SuperKarel extends KarelTheRobot{
	public void turnAround() throws Exception {
    	turnLeft();
    	turnLeft();
    }
    
    public void turnRight() throws Exception {
    	turnLeft();
    	turnLeft();
    	turnLeft();
    }
    
    //Don't confuse this with “stepBack()” because this method goes as far as it can, rather than just moving one step
    public void goBack() throws Exception {
		turnAround();
		while(frontIsClear()) move();
	}
    
    //Basically, go forward as long as it is possible
    public void moveToWall() throws Exception {
    	while(frontIsClear()) move();
    }
    
    public void stepBack() throws Exception {
		turnAround();
    	if(frontIsClear()) move();
    	turnAround();
    }
    
    public void fillLineWithBeepers() throws Exception {
    	if(noBeepersPresent()) putBeeper();
		while (frontIsClear()) {
			move();
			if(noBeepersPresent()) putBeeper();
		}
	}
    	
}
