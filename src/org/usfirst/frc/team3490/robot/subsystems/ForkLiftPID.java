package org.usfirst.frc.team3490.robot.subsystems;

import org.usfirst.frc.team3490.robot.RobotMap;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 */
public class ForkLiftPID extends PIDSubsystem {
	AnalogInput pot;
	Talon arm;
	private static final double Kp = -2;
	private static final double Ki = 0.0;
	private static final double Kd = 0.0;
    // Initialize your subsystem here
    public ForkLiftPID() {
    	super("Fork Lift Arm", Kp, Ki, Kd);
    	pot = new AnalogInput(RobotMap.potArm);
    	arm = new Talon(RobotMap.flMotor);
    	enable();
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return 0.0;
    }
    protected double returnPosition() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return pot.getAverageVoltage();
    }
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	arm.set(output/2);
    }
}
