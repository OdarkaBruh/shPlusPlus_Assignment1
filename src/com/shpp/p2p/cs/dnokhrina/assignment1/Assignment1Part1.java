package com.shpp.p2p.cs.dnokhrina.assignment1;

public class Assignment1Part1 extends SuperKarel {
    public void run() throws Exception {
        
    	goTowardsTheNewspaper();
        pickBeeper(); //pick the Newspaper
        goBackTowardsTheChair();
    }
    
    private void goTowardsTheNewspaper() throws Exception {
    	
    	//Walk until it reaches the right wall
    	moveToWall();
    	
    	//Look for the door (hole in the right wall)
    	turnRight();
        while(leftIsBlocked()) {
        	move();
        }
        
        //Go out towards the newspaper
        turnLeft();
        while(noBeepersPresent()) {
        	move();
        }
    }
    
    private void goBackTowardsTheChair() throws Exception {
    	//go back towards the left wall. 
    	turnAround();
        moveToWall();
        
        //Turn north and walk towards the upper wall => it is in a corner. 
        turnRight();
        moveToWall();
    }
}
