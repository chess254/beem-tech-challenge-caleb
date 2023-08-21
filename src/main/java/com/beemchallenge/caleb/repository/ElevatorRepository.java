package com.beemchallenge.caleb.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import com.beemchallenge.caleb.model.ElevatorStatus;
import org.springframework.stereotype.Repository;

import com.beemchallenge.caleb.business.Elevator;

/**
 * Repository of elevators.
 * @author lnie
 *
 */
@Repository
public class ElevatorRepository {

	private List<Elevator> elevators = new ArrayList<Elevator>();
	
	@PostConstruct
	public void init() {
		Arrays.asList("A", "B", "C", "D").forEach(number -> {
			Elevator elevator = new Elevator(number);
			elevator.setStatus(ElevatorStatus.IDLE);
			elevator.setCurrentFloorNo(1);
			elevators.add(elevator);
		});
	}
	
	public List<Elevator> getElevators() {
		return elevators;
	}
}
