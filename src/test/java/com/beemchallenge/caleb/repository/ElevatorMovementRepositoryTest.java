package com.beemchallenge.caleb.repository;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import com.beemchallenge.caleb.Application;
import com.beemchallenge.caleb.model.ElevatorMovement;
import com.beemchallenge.caleb.model.ElevatorStatus;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.test.context.web.WebAppConfiguration;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, 
	DirtiesContextTestExecutionListener.class,
	TransactionalTestExecutionListener.class, 
	DbUnitTestExecutionListener.class })
@DatabaseSetup("/ElevatorMovement.xml")
@ActiveProfiles("test")
public class ElevatorMovementRepositoryTest {

	@Autowired
    private ElevatorMovementRepository repository;
	
	@Test
	public void findByElevatorIDReturnsCorrectResults() {
		String elevatorID = "A";
		List<ElevatorMovement> elevatorMovements = repository.findByElevatorIDOrderByTimeAsc(elevatorID);

		assertNotNull(elevatorMovements);
		assertEquals(5, elevatorMovements.size());
		assertThat(elevatorMovements.get(0),
				Matchers.allOf(hasProperty("id", is(1)), hasProperty("currentFloorNo", is(1)),
						hasProperty("toFloorNo", is(0)), hasProperty("noOfPeople", is(0)),
						hasProperty("status", Matchers.is(ElevatorStatus.TASK_STARTED))));
		elevatorMovements.forEach(elevatorMovement -> {
			assertThat(elevatorMovement,
					allOf(hasProperty("elevatorID", is("A"))));
		});
	}
	
	@Test
	public void findByElevatorIDReturnsOnlyResultsOfThatElevatorID() {
		String elevatorID = "A";
		List<ElevatorMovement> elevatorMovements = repository.findByElevatorIDOrderByTimeAsc(elevatorID);

		assertNotNull(elevatorMovements);
		assertEquals(5, elevatorMovements.size());
		
		elevatorMovements.forEach(elevatorMovement -> {
			assertThat(elevatorMovement,
					allOf(hasProperty("elevatorID", is("A"))));
		});
	}
	
	@Test
	public void findByWrongElevatorIDReturnsEmptyResult() {
		String elevatorID = "C";
		List<ElevatorMovement> elevatorMovements = repository.findByElevatorIDOrderByTimeAsc(elevatorID);

		assertNotNull(elevatorMovements);
		assertEquals(0, elevatorMovements.size());
	}
	
	@Test
	public void findByEmptyElevatorIDReturnsEmptyResult() {
		String elevatorID = " ";
		List<ElevatorMovement> elevatorMovements = repository.findByElevatorIDOrderByTimeAsc(elevatorID);

		assertNotNull(elevatorMovements);
		assertEquals(0, elevatorMovements.size());
	}
	
	@Test
	public void findByNullElevatorIDReturnsEmptyResult() {
		String elevatorID = null;
		List<ElevatorMovement> elevatorMovements = repository.findByElevatorIDOrderByTimeAsc(elevatorID);

		assertNotNull(elevatorMovements);
		assertEquals(0, elevatorMovements.size());
	}

}
