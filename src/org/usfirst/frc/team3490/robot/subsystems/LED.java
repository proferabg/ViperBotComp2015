package org.usfirst.frc.team3490.robot.subsystems;

import org.usfirst.frc.team3490.robot.commands.LightsOff;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LED extends Subsystem{
	
	I2C Wire;
	
	public LED(){
    	Wire = new I2C(Port.kOnboard, 4);
	}

	@Override
	protected void initDefaultCommand() {
		setDefaultCommand(new LightsOff());
	}

	public void turnOn(){
		sendLEDCommand("on");
	}
	
	public void turnOff(){
		sendLEDCommand("off");
	}
	
	public void sendLEDCommand(String s){
    	char[] CharArray = s.toCharArray();
		byte[] WriteData = new byte[CharArray.length];
		for (int i = 0; i < CharArray.length; i++) {
			WriteData[i] = (byte) CharArray[i];
		}
		Wire.transaction(WriteData, WriteData.length, null, 0);
    }
	
}
