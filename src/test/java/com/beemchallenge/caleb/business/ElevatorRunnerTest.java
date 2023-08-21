package com.beemchallenge.caleb.business;

import static org.mockito.Mockito.*;

import com.beemchallenge.caleb.model.ElevatorMovement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import com.beemchallenge.caleb.business.exception.ElevatorException;
import com.beemchallenge.caleb.repository.ElevatorMovementRepository;

@RunWith(MockitoJUnitRunner.class)
public class ElevatorRunnerTest {

	@Spy
	private Task task;
	
	@Mock
	private Elevator elevator;
	
	@Mock
	private ElevatorMovementRepository elevatorMovementRepository;
	
	@InjectMocks
	private ElevatorRunner elevatorRunner;
	
	@Test
	public void testElevatorIsRunningInParticularSteps() throws ElevatorException {
		task.setFromFloorNO(3);
		task.setToFloorNo(8);
		task.setNoOfpeople(6);
		when(elevatorMovementRepository.save(any(ElevatorMovement.class))).thenReturn(null);
		elevatorRunner.run();
		InOrder inOrder = inOrder(elevator);
		inOrder.verify(elevator).moveElevator(3);
		inOrder.verify(elevator).peopleMoveIn(6);
		inOrder.verify(elevator).moveElevator(8);
		inOrder.verify(elevator).peopleMoveOut();
	}

}
