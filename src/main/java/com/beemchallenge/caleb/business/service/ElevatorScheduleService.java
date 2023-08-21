package com.beemchallenge.caleb.business.service;

import com.beemchallenge.caleb.business.Elevator;
import com.beemchallenge.caleb.business.Task;

/**
 * A service that schedules elevator upon customer's request.
 * 
 * @author lnie
 *
 */
public interface ElevatorScheduleService {
	
	/**
	 * <p>
	 * Schedule an elevator as per customer's request.
	 * </p>
	 * <p>
	 * Return the scheduled elevator. <br/>
	 * Return null if no elevator is scheduled,
	 * </p>  
	 * @param task Customer's request.
	 * @return scheduled elevator.
	 */
	public Elevator scheduleElevator(Task task);
}
