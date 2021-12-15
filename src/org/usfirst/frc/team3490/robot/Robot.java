
package org.usfirst.frc.team3490.robot;

import java.util.TimerTask;

import org.usfirst.frc.team3490.robot.commands.*;
import org.usfirst.frc.team3490.robot.subsystems.*;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	Command autonomousCommand;

	public static OI oi;
	public static DriveTrain driveTrain;
	public static ForkLift forklift;
	public static ForkLiftArm flArm;
	public static ForkLiftPID flPid;
	public static Mast mast;
	public static LED led;
    static I2C Wire;
    int color = 1;
	//public static Feeder feeder;
//	public static Jacob jacob;
   
    SendableChooser autoChooser;
    static SendableChooser colorChooser;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	Wire = new I2C(Port.kOnboard, 4);
    	driveTrain = new DriveTrain();
    	mast = new Mast();
    	forklift = new ForkLift();
  //  	flPid = new ForkLiftPID();
    	flArm = new ForkLiftArm();//
    	led = new LED();
		oi = new OI();
		//
		//autonomousCommand = new ThreeToteAutonomous();
        // instantiate the command used for the autonomous period
        SmartDashboard.putData(driveTrain);
        SmartDashboard.putNumber("Accelerometer X", driveTrain.sendAxlX());
        SmartDashboard.putNumber("Accelerometer Y", driveTrain.sendAxlY());
        SmartDashboard.putNumber("Accelerometer Z", driveTrain.sendAxlZ());
        SmartDashboard.putData("LED On", new LightsOn());
        SmartDashboard.putData("LED Off", new LightsOff());
       
        
        colorChooser = new SendableChooser();
        colorChooser.addDefault("Blue Lights", "blue");
        colorChooser.addObject("Red Lights", "red");
        colorChooser.addObject("Rainbow Lights", "rainbow");
        colorChooser.addObject("Purple", "purple");
        SmartDashboard.putData("LED Color Chooser", colorChooser);
        
        autoChooser = new SendableChooser();
        autoChooser.addDefault("Drive Can Conveyor",new AutoConveyerCanFwd());
        autoChooser.addObject("Drive Can Forklift", new AutoCanCarry());
        autoChooser.addObject("Drive Straight (Forklift)",new DriveStraight());
        autoChooser.addObject("Do Nothing",new AutoDoNothing());
        autoChooser.addObject("Josh's Auto (Three Tote) BROKEN!!!!!!", new ThreeToteAutonomous());
        SmartDashboard.putData("Autonomous mode chooser",autoChooser);
        
        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
            	checkLightsEnabled();
            }
        }, 0, 1000);
    }
	
	public static String getColor(){
    	if(colorChooser.getSelected() != null){
        	return (String) colorChooser.getSelected();
    	} else {
    		return "blue";
    	}
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		log();
	}

    public void autonomousInit() {
    	autonomousCommand= (Command)autoChooser.getSelected();
        // schedule the autonomous command (example)
        autonomousCommand.start();
        new LightsOn();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        log();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        new LightsOn();
    }

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        log();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
    private void log()
    {
    	driveTrain.log();
    	mast.log();
    	forklift.log();
    	flArm.log();
    	//doLights();
    	
    }
    
    /*private void doLights(){
    	List<String> d = Robot.driveTrain.getColors();
    	String fl = Robot.forklift.getColors();
    	String s = "led~"+d.get(0)+"-"+d.get(1)+"-"+ fl + "-"+d.get(2)+"-"+d.get(3) +"-"+ fl;
    	sendLEDCommand(s);
    }
    */
    public void checkLightsEnabled(){
    	if(!isEnabled()){
    		led.turnOff();
    	}
    }
    /*
    public void sendLEDCommand(String s){
    	char[] CharArray = s.toCharArray();
		byte[] WriteData = new byte[CharArray.length];
		for (int i = 0; i < CharArray.length; i++) {
			WriteData[i] = (byte) CharArray[i];
		}
		Wire.transaction(WriteData, WriteData.length, null, 0);
    }*/
   
}
