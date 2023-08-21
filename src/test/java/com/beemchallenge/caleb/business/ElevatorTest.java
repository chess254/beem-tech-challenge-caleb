package com.beemchallenge.caleb.business;

import static org.junit.Assert.*;

import com.beemchallenge.caleb.model.ElevatorStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.beemchallenge.caleb.business.exception.ElevatorException;

@RunWith(MockitoJUnitRunner.class)
public class ElevatorTest {

	@Test
	public void testStartTask() {
		Elevator elevator = new Elevator("A");
		elevator.startTask();
		assertEquals(ElevatorStatus.TASK_STARTED, elevator.getStatus());
	}

	@Test
	public void testMoveElevator() throws ElevatorException {
		Elevator elevator = new Elevator("A");
		int toFloorNo = 5;
		elevator.moveElevator(toFloorNo);
		assertEquals(toFloorNo, elevator.getCurrentFloorNo());
	}

	@Test
	public void testPeopleMoveIn() throws ElevatorException {
		Elevator elevator = new Elevator("A");
		int noOfPeople = 5;
		elevator.peopleMoveIn(noOfPeople);
		assertEquals(noOfPeople, elevator.getNoOfPeople());
	}

	@Test
	public void testPeopleMoveOut() throws ElevatorException {
		Elevator elevator = new Elevator("A");
		elevator.setNoOfPeople(10);
		elevator.peopleMoveOut();
		assertEquals(0, elevator.getNoOfPeople());
	}

}
