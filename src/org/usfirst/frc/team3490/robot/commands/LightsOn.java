package org.usfirst.frc.team3490.robot.commands;

import org.usfirst.frc.team3490.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class LightsOn extends Command{
	
	public LightsOn(){
		requires(Robot.led);
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		Robot.led.turnOn();
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		
		
	}

	@Override
	protected void interrupted() {
		end();
		
	}

}
