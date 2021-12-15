package org.usfirst.frc.team3490.robot.subsystems;

import org.usfirst.frc.team3490.robot.RobotMap;
import org.usfirst.frc.team3490.robot.commands.JoyFlArm;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ForkLiftArm extends Subsystem{
	
	Solenoid arm;
	Solenoid arm2;
	String status = "Open";
	//
	
	
	public ForkLiftArm(){
		arm = new Solenoid(RobotMap.flArmSol);
		arm2 = new Solenoid(RobotMap.flArmSol2);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new JoyFlArm());
	}

	public void log() {
		SmartDashboard.putString("FLArm Solenoid", status);
	}
	
	public void JoyFlArm(Joystick joy2){
		if (joy2.getRawButton(3)){
			arm.set(true);
			arm2.set(false);
		} else if (joy2.getRawButton(4)){
			arm.set(false);
			arm2.set(true);
		}
	}
	public void JoyFlArm(Boolean Barm, Boolean Barm2){
		arm.set(Barm);
		arm2.set(Barm2);
	}

}
