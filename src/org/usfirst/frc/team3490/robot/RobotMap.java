package org.usfirst.frc.team3490.robot;
/*
import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.Rect;

import edu.wpi.first.wpilibj.CANTalon;*/
import edu.wpi.first.wpilibj.Compressor;
/*import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.vision.AxisCamera;*/

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    public static int driveLeftFront =3;  	//CAN Talon
    public static int driveLeftRear = 4;	//CAN Talon
    public static int driveRightFront = 5;	//CAN Talon
    public static int driveRightRear = 6;	//CAN Talon
    public static int LFEncoder0[] = {10, 11};		//DI 0,1 yaxis
    public static int LREncoder1[] = {12, 13};      //DI 2,3 xaxis
    public static int RFEncoder[] = {};
    public static int RREncoder[] = {};
    public static int mastEncoder3 = 3;		//DI 4,5 mast convey
    public static int limitSwitchHi = 6;	//DI 6 FL hi
    public static int limitSwitchLow = 7;	//DI 7 FL Lo
    public static int limitSwitchReady = 8;	//DI 8 feeder in
    public static int mastRasiedLimit = 9; 	//DI 9 mastRaised Limit    
    public static int sonar = 0;			//AI 0
    public static int gyro1 = 1;			//AI 1
    public static int potMast = 2;			//AI 2
    public static int potArm = 3;			//AI 3
    public static int comp = 0;		//PCM Compressor
    public static int mastSol = 0;			//PCM 0
    public static int flArmSol = 2;			//PCM 2
    public static int flArmSol2 = 1;		//PCM 1
    public static int sol3 = 1;				//PCM 2 ???????????
    public static int conveyer = 0;			//PWM 0
    public static int flMotor = 1;			//PWM 5
    public static double driveStraightTimeout =3.0;
    public static Compressor compressor;
    
    //conveyer data
    public static double conveyerPos0 =  0.369  ;
    public static double converyPos0MinSpeed = -0.35;
    public static double converyPos0MaxSpeed = 0.4;		//.4
  
    public static double conveyerPos1 = 0.391;
    public static double converyPos1MinSpeed = -0.35;
    public static double converyPos1MaxSpeed = 0.5;    //.45
  
    public static double conveyerPos2 =	0.494;
    public static double converyPos2MinSpeed = -0.35;
    public static double converyPos2MaxSpeed = 0.6;		//.5
  
    public static double conveyerPos3 =	0.596;
    public static double converyPos3MinSpeed = -0.35;
    public static double converyPos3MaxSpeed = 0.75;	//.65
  
    public static double conveyerPos4 =	 0.670;
    public static double converyPos4MinSpeed = -0.1;
    public static double converyPos4MaxSpeed = 0.85;		//.9
  
    public static double conveyerDefaultPos = 0.407;
    public static double converyPosDefaultMinSpeed = -1;
    public static double converyPosDefaultMaxSpeed = 1;
  
    
    
  //  public static int flKeep[] = {3, 4};	//????

    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    //
    //my stuff. public static int rangefinderPort scont;= 1;
    // public static int rangefinderModule = 1;
    
    public static void init(){
    	compressor = new Compressor(comp);
    }
}

