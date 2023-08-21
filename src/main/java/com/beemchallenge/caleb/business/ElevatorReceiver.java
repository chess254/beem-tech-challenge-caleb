package com.beemchallenge.caleb.business;

import com.beemchallenge.caleb.business.exception.ElevatorException;

public interface ElevatorReceiver {

	public void moveElevator(int toFloor) throws ElevatorException;
	public void peopleMoveIn(int noOfPeople) throws ElevatorException;
	public void peopleMoveOut() throws ElevatorException;
}
