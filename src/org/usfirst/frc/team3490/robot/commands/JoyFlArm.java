package org.usfirst.frc.team3490.robot.commands;

import org.usfirst.frc.team3490.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class JoyFlArm extends Command{
	
	public JoyFlArm(){
    	requires(Robot.flArm);
	}

	protected void initialize() {
		
	}

	protected void execute() {
		Robot.flArm.JoyFlArm(Robot.oi.getJoystick2());
		
	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	protected void end() {
		// TODO Auto-generated method stub
		
	}

	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
