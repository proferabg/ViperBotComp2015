package org.usfirst.frc.team3490.robot.subsystems;

import org.usfirst.frc.team3490.robot.Robot;
import org.usfirst.frc.team3490.robot.RobotMap;
import org.usfirst.frc.team3490.robot.commands.JoyForkLift;

import edu.wpi.first.wpilibj.AnalogInput;
//import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
//import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ForkLift extends Subsystem {
//	private static final double Kp = -2;
//	private static final double Ki = 0.0;
//	private static final double Kd = 0.0;
	Talon arm;
	AnalogInput pot;
	boolean lowLimit = false;
	boolean highLimit = false;
//	double low = 0.71;
//	double high = 0.25;
	double low1 = 1.45;  //trial setpoints 
	double high1 = 3.67;  //trial setpoint
	double low2 = 1.38;  //trial setpoint
    // Initialize your subsystem here
    public ForkLift() {
    	//super("Fork Lift Arm", Kp, Ki, Kd);
    	arm = new Talon(RobotMap.flMotor);
    	pot = new AnalogInput(RobotMap.potArm);
    	//setAbsoluteTolerance(0.005);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    public void JoyForklift(Joystick joy2){
    	 if(joy2.getY() < -0.1 && !highLimit){
    		arm.set(joy2.getY());
    		lowLimit = false;
    		if(returnPosition()>high1)
    		{
    			highLimit = true;
    		}
    	} 

    	 else if (joy2.getY() > 0.1 && !lowLimit && returnPosition() > low1){
    		arm.set(joy2.getY());
    		highLimit = false;
    		if(returnPosition()<low1)
    		{
    			lowLimit = true;
    		}
    	} else if (joy2.getY() > 0.1 && !lowLimit && returnPosition() > low2){
    		arm.set(joy2.getY()/2);
    		highLimit = false;
    		if(returnPosition()<low2)
    		{
    			lowLimit = true;
    		}
    	} else{
    		arm.set(0);
    	}
/*    	if (joy.getRawButton(1)){
    		arm.set(1);
    	} else if (joy.getRawButton(2)){
    		arm.set(-1);
    	} else {
    		arm.set(0);
    	}
*/
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new JoyForkLift());
    }
    
    protected double returnPosition() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return pot.getAverageVoltage();
    }
    
 /*   protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	arm.set(output);
    }
*/    
    public void log(){
    	SmartDashboard.putNumber("FlArm Potentiometer", returnPosition());
    	SmartDashboard.putNumber("Joystick 2 Y", Robot.oi.getJoystick2().getY());
    	SmartDashboard.putBoolean("FL Arm High", highLimit);
    	SmartDashboard.putBoolean("FL Arm Low", lowLimit);

    }
    
    public String getColors(){
    	String s = "0,0,0";
    	if (arm.getSpeed() > 0.1){
    		s = "0,255,0";
    	} else if (arm.getSpeed() < -0.1){
    		s = "255,0,0";
    	}
    	return s;
    }
}
