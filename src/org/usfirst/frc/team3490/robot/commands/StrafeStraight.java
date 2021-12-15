package org.usfirst.frc.team3490.robot.commands;

import org.usfirst.frc.team3490.robot.Robot;
import org.usfirst.frc.team3490.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class StrafeStraight extends Command {

	private double angle;
	private double Kp_Gyro = 0.03;
	private double Kpdist = 0.1;
	
	private double errorYaxis;
	private int direction;
	private double distance ;
	private double zAxis=0;
	
	
	public StrafeStraight()
	{
		this (-1,80);
	}
	
    public StrafeStraight(int dir, double dist) 
    {
    	requires(Robot.driveTrain);
    	direction = dir;
    	distance = dist;
    }

    // Called just before this Command runs the first time
    protected void initialize()
    {
    	Robot.driveTrain.resetDriveEncoders();
		
	
    	Robot.driveTrain.resetGyro();
    	Robot.driveTrain.resetDriveEncoders();
    	angle = Robot.driveTrain.getHeading();
    	Timer.delay(0.2);
    	setTimeout(RobotMap.driveStraightTimeout );
    	SmartDashboard.putNumber("Drive Striaght angle", angle);
    	zAxis = 0.0;
    	
    	
    	
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	double speederror = 0.0;
    	double speed = 0.0;
    	if(Robot.driveTrain.getDistance()<distance)
    	{
    		speederror = distance - Robot.driveTrain.getDistance();
    		speed = speederror * Kpdist *direction;
	    	if(speed >.65 || speed <-.65)
	    		speed = .65*direction;
	    	
	    	errorYaxis = angle - Robot.driveTrain.getHeading();
	    	zAxis = errorYaxis *Kp_Gyro;
	    	Robot.driveTrain.drive(speed,0,zAxis,0);
    	}
    	SmartDashboard.putNumber("Drive Staif speederror",speederror);
    	SmartDashboard.putNumber("Drive Staif speed",speed);
    	SmartDashboard.putNumber("Drive staif Dist",Robot.driveTrain.getDistance());
    }
    /*
    public boolean isMore(double dis, double getdis){
    	if(getdis > dis){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    */
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(Robot.driveTrain.getDistance()>=distance*0.95)
    	{
    			return true;
    	}
    	else 
    		return false;	
    }
    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
