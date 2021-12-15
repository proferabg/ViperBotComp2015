package org.usfirst.frc.team3490.robot.commands;

import org.usfirst.frc.team3490.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
/**
 *
 */
public class JoyMast extends Command {
	
	private double setpoint;
	private double maxSpeed,minSpeed;


    
    public JoyMast(double setpoint, double maxSpeed, double minSpeed){
    	this.setpoint = setpoint;
    	this.maxSpeed = maxSpeed;
    	this.minSpeed = minSpeed;
    	requires(Robot.mast);
    }
    

    // Called just before this Command runs the first time
    protected void initialize() {
        Robot.mast.enable();
        Robot.mast.setOutputRange(maxSpeed, minSpeed);
        Robot.mast.setSetpoint(setpoint);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.mast.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
