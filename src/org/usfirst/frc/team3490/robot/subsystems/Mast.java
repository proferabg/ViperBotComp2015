package org.usfirst.frc.team3490.robot.subsystems;

import org.usfirst.frc.team3490.robot.Robot;
import org.usfirst.frc.team3490.robot.RobotMap;
import org.usfirst.frc.team3490.robot.commands.JoyMastTilt;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Mast extends PIDSubsystem {
    DigitalInput limit = new DigitalInput(RobotMap.mastRasiedLimit);
    Talon convey = new Talon(RobotMap.conveyer);
    AnalogInput sonar = new AnalogInput(RobotMap.sonar);
    Potentiometer pot = new AnalogPotentiometer(RobotMap.potMast);
    Solenoid sol = new Solenoid(RobotMap.mastSol);
    private static final double  kP_real = 50, kI_real =0.0, kD_real = 0;// kP_real = 6, kI_real = 0.0;
   // public double maxSpeed = 0.7;
   
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public Mast(){
    	super(kP_real, kI_real, kD_real);
        setAbsoluteTolerance(0.02);
    }
    
    //logs the potentiometer value
    public void log(){
    	SmartDashboard.putNumber("Conveyer pot", Robot.mast.getPot().get());
    }
    

    public void initDefaultCommand() {
    	setDefaultCommand(new JoyMastTilt());
    }
    
    public void mastTilt(Joystick joy2){
    	if (joy2.getRawButton(1)){
    		sol.set(true);
    	} else if (joy2.getRawButton(2)){
    		sol.set(false);
    	}
    }
    
    
    public double getDistance() {
    	return sonar.getAverageVoltage();
    }
    
  
    
    //Old manual convey not used for pid usage
    public void mastConvey(Joystick joy2){
    	if (joy2.getRawButton(5)) {
    		convey.set(1);
    	}
    	else if (joy2.getRawButton(6)) {
    		convey.set(-1);
    	}
    	else {
    		convey.set(0);
    	}
    }
    
    //gets and returns the instance of the potentiometer
    public Potentiometer getPot(){
    	return pot;
    }
    


	protected double returnPIDInput() {
		return pot.get();
	}

	//set the conveyor to goto a setpoint
	
	protected void usePIDOutput(double output) {
		
		convey.set(-output);
		SmartDashboard.putNumber("Conveyer Speed", output);
	
	}
	
	
	
	
}




