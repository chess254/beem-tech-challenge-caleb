package com.beemchallenge.caleb.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.beemchallenge.caleb.business.Elevator;
import com.beemchallenge.caleb.business.Task;

@Service("elevatorScheduleService")
@Scope("prototype")
public class ElevatorScheduleServiceImpl implements ElevatorScheduleService{
    
	@Autowired
	private ElevatorAllocateService elevatorAllocateService;
	
	@Autowired
	private AsyncCallService asyncService;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Elevator scheduleElevator(Task task) {
		Elevator elevator = elevatorAllocateService.requestElevator(task);
		if(elevator == null) {
			return null;
		}
		asyncService.schedule(task, elevator);
		return elevator;
	}
	

}
