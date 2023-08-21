package com.beemchallenge.caleb.repository;

import java.util.List;

import com.beemchallenge.caleb.model.ElevatorMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElevatorMovementRepository extends JpaRepository<ElevatorMovement, Integer> {
	
	List<ElevatorMovement> findByElevatorIDOrderByTimeAsc(String elevatorID);
	
}
