package org.usfirst.frc.team3490.robot.commands;

import org.usfirst.frc.team3490.robot.Robot;
import org.usfirst.frc.team3490.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveStraight extends Command {


    	private double angle;
    	private double Kp = 0.1;
    	private double Kpdist =0.1;
    	private double maxSpeed = 0.60;
    	private double errorXaxis ;
    	private double distance ;
    	//private double driveSpeed;
    	private double zAxis =0;
    	//private PIDController pid;
    	private int direction;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	public DriveStraight()
    	{
    		this (-1,5); //speed,distance)
    	}
    	public DriveStraight(double Time){
    		requires(Robot.driveTrain);
    		setTimeout(Time);
    	}
    	public DriveStraight (int dir, double dist)
    	{
    		
    		requires(Robot.driveTrain);
    		
    		direction = dir;
    		distance = dist;		
    	}
    	
    	
    	
    
    

    // Called just before this Command runs the first time
    protected void initialize()
    {
    	Robot.driveTrain.resetGyro();
    	Robot.driveTrain .resetDriveEncoders();
    	angle = Robot.driveTrain.getHeading();
    	setTimeout(RobotMap.driveStraightTimeout);
    	Robot.driveTrain.resetDriveEncoders();
		Timer.delay(0.2);
	
    	SmartDashboard.putNumber("Drive Striaght angle",angle);
    	zAxis = 0.0;
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	double speederror = 0.0;
    	double speed =0.0;
    	if(Robot.driveTrain.getDistance() < distance)
    	{
    		speederror =  distance - Robot.driveTrain.getDistance(); 
    		speed = speederror * Kpdist * direction ;
    		if(speed>0.60 || speed <-0.60)
    			speed = maxSpeed *direction;
    			
    		errorXaxis = angle - Robot.driveTrain.getHeading();
    		zAxis = errorXaxis * Kp; 
    		Robot.driveTrain.drive(0,speed,zAxis,0);
    	}
    	//else{
    		//Robot.driveTrain .drive(0,0,0,0);
    		//isFinished();
    	//}
    	SmartDashboard.putNumber("Drive Striaght speederror",speederror);
    	SmartDashboard.putNumber("Drive Striaght speed",speed);
    	SmartDashboard.putNumber("Drive Striaght Dist",Robot.driveTrain.getDistance());

  
    }
 /*   public boolean isMore(double dis, double getdis){
    	if(getdis > dis){
    		return true;
    	}
    	else{
    	return false;
    	}
    }
    */
    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished()
    {	
    	if(Robot.driveTrain.getDistance()>distance*0.95){
    		return true;
    	}
    	else if(isTimedOut()){
    		return true;
    	}
    	else
    		return false;			
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    //	pid.disable();
    	Robot.driveTrain.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
