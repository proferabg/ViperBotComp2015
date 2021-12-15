package org.usfirst.frc.team3490.robot.commands;

import org.usfirst.frc.team3490.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoClose extends Command {
	boolean arm, arm2;
    public AutoClose(boolean arm, boolean arm2) {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.flArm);
        this.arm = arm;
        this.arm2 = arm2;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.flArm.JoyFlArm(arm, arm2);
    	Timer.delay(1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
