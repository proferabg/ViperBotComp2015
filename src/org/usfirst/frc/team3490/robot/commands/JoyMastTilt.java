package org.usfirst.frc.team3490.robot.commands;

import org.usfirst.frc.team3490.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class JoyMastTilt extends Command {
	
	public JoyMastTilt(){
		requires(Robot.mast);
	}

	protected void initialize() {
		// TODO Auto-generated method stub

	}

	protected void execute() {
		Robot.mast.mastTilt(Robot.oi.getJoystick2());
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
