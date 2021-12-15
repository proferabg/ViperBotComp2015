package org.usfirst.frc.team3490.robot.subsystems;

import java.beans.Encoder;



/*import java.util.ArrayList;
import java.util.List;
*/
import org.usfirst.frc.team3490.robot.RobotMap;
//import org.usfirst.frc.team3490.robot.commands.JoyDrive;
import org.usfirst.frc.team3490.robot.commands.JoyDriveFast;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
/*import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.livewindow.LiveWindowSendable;*/
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {
    CANTalon talonLF, talonLR, talonRF, talonRR;
    Encoder encLF, encRF, encLR, encRR;
    RobotDrive drive;
    AnalogGyro gyro;
    BuiltInAccelerometer axl;
    private double wheel_D = 5.875;
    private double encTicks =250;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public DriveTrain(){
		talonLF = new CANTalon(RobotMap.driveLeftFront);
		talonLR = new CANTalon(RobotMap.driveLeftRear);
		talonRF = new CANTalon(RobotMap.driveRightFront);
		talonRR = new CANTalon(RobotMap.driveRightRear);
		
		drive = new RobotDrive(talonLF, talonLR, talonRF, talonRR);
		drive.setExpiration(.1);
		drive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
		drive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, false);
		drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
		drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, false);
		gyro = new AnalogGyro(RobotMap.gyro1);
		drive.setSensitivity(0.1);
		gyro.setSensitivity(0.0125);
		axl = new BuiltInAccelerometer();
		//encoderLF = new Encoder(RobotMap.
		/*LiveWindow.addActuator("Drive Train", "LF Motor", (LiveWindowSendable)talonLF);
		LiveWindow.addActuator("Drive Train", "LR Motor", (LiveWindowSendable)talonLR);
		LiveWindow.addActuator("Drive Train", "RF Motor", (LiveWindowSendable)talonRF);
		LiveWindow.addActuator("Drive Train", "RR Motor", (LiveWindowSendable)talonRR);*/
	//	LiveWindow.addSensor("Drive Train", "Gyro", gyro);
		
		
	}
	public double sendAxlX(){
		return axl.getX();
	}
	public double sendAxlY(){
		return axl.getY();
	}
	public double sendAxlZ(){
		return axl.getZ();
	}
    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new JoyDriveFast());
    }
    public void mecanumDrive_CartesianFull(Joystick joy)
    {
    	/*double throttle = joy.getThrottle();
    	throttle += 1;
    	if (throttle > 0) throttle /= 2;*/
    	drive.mecanumDrive_Cartesian(joy.getX() * throttle(joy), joy.getY()* throttle(joy), joy.getZ()* throttle(joy), 0);
    	//drive.mecanumDrive_Cartesian(joy.getX(), joy.getY(), joy.getZ(), 0);
    }
    public double throttle(Joystick joy){
    	double throttle = -(joy.getThrottle());
    	throttle += 1;
    	if(throttle > 0){
    		return throttle /= 2;
    	}
    	else{
    	return throttle;
    	}
    }
    public void stop()
    {
    	drive.mecanumDrive_Cartesian(0, 0, 0, 0);
    }
	public void mecanumDrive_CartesianHalf(Joystick joy) 
	{
		// TODO Auto-generated method stub
		drive.mecanumDrive_Cartesian(joy.getX()/2, joy.getY()/2, joy.getZ()/2, 0);
	}
	
	public void resetGyro()
	{
		gyro.reset();
	}
	public double getHeading()
	{
		return gyro.getAngle();
	}
	public void resetDriveEncoders()
	{
		talonLF.setPosition(0);
		talonLR.setPosition(0);
		talonRF.setPosition(0);
		talonRR.setPosition(0);
	
		
	}
	
	public double getLFdist()
	{
		double dist = Math.abs((wheel_D * Math.PI )*(((talonLF.getEncPosition()/4)/(encTicks)))) ;
		
		return dist;
	}
	
	public double getLRdist(){
		double dist = Math.abs((wheel_D * Math.PI )*(((talonLR.getEncPosition()/4)/362))) ;
		return dist;
		
	}
	public double getRFdist(){
		double dist = Math.abs((wheel_D * Math.PI )*(((talonRF.getEncPosition()/4)/encTicks))) ;
		return dist;
		
	}
	public double getRRdist(){
		double dist = Math.abs((wheel_D * Math.PI )*(((talonRR.getEncPosition()/4)/encTicks))) ;
		return dist;
		
	}
	public double getDistance(){
		double distance=0;
		double num=0.0;
		//if(getLFdist()>0.1){
			//distance = getLFdist();
			//num++;
		//}
		if(getLRdist()>0.1){
			distance += getLRdist();
			num ++;
		}
		if(getRFdist()>0.1){
			distance += getRFdist();
			num++;
		}
		if(getRRdist()>0.1){
			distance += getRRdist();
			num++;
		}
		if(distance >0)
			distance = distance/num;
			
		return distance;
	}
	
	public void drive (double x, double y, double z, double angle)
	{
		drive.mecanumDrive_Cartesian(x, y, z, angle);
	}
	 public void log()
	    {
			SmartDashboard.putNumber("Gyro", gyro.getAngle());
			SmartDashboard.putNumber("Drive LF Motor", talonLF.get());
			SmartDashboard.putNumber("Drive LR Motor", talonLR.get());
			SmartDashboard.putNumber("Drive RF Motor", talonRF.get());
			SmartDashboard.putNumber("Drive RR Motor", talonRR.get());
			SmartDashboard.putNumber("Drive LF Motor", getLFdist());
			SmartDashboard.putNumber("Drive LR Motor", getLRdist());
			SmartDashboard.putNumber("Drive RF Motor", getRFdist());
			SmartDashboard.putNumber("Drive RR Motor", getRRdist());
			SmartDashboard.putNumber("trouleshoot LF", talonLF.getPosition());
			SmartDashboard.putNumber("trouleshoot LR", talonLR.getPosition());
			SmartDashboard.putNumber("trouleshoot RF", talonRF.getPosition());
			SmartDashboard.putNumber("trouleshoot RR", talonRR.getPosition());
			SmartDashboard.putNumber("Drive Train  dist", getDistance());
	    }
	 
	 /*@SuppressWarnings({ "unchecked", "rawtypes" })
		public List<String> getColors(){
			List<String> s = new ArrayList();
			if (talonLR.getSpeed() > 0.1){
				s.add(0,"0,255,0");
			} else if (talonLR.getSpeed() < -0.1){
				s.add(0,"255,0,0");
			} else {
				s.add(0,"0,0,0");
			}
			
			if (talonLF.getSpeed() > 0.1){
				s.add(1,"0,255,0");
			} else if (talonLF.getSpeed() < -0.1){
				s.add(1,"255,0,0");
			} else {
				s.add(1,"0,0,0");
			}
			
			if (talonRR.getSpeed() > 0.1){
				s.add(2,"0,255,0");
			} else if (talonRR.getSpeed() < -0.1){
				s.add(2,"255,0,0");
			} else {
				s.add(2,"0,0,0");
			}
			
			if (talonRF.getSpeed() > 0.1){
				s.add(3,"0,255,0");
			} else if (talonRF.getSpeed() < -0.1){
				s.add(3,"255,0,0");
			} else {
				s.add(3,"0,0,0");
			}
			
			if (s.size() < 4 || s.isEmpty()){
				s.add(0,"0,0,0");
				s.add(1,"0,0,0");
				s.add(2,"0,0,0");
				s.add(3,"0,0,0");
			}
			return s;
		}*/
}

