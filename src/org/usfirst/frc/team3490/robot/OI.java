package org.usfirst.frc.team3490.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;

import org.usfirst.frc.team3490.robot.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);//
    Joystick joy, joy2;
    Button one, two, three, four, five, six, seven, eight, nine, ten;
    Trigger trigger;
    public OI(){
    	joy = new Joystick(0);
    	/*three = new JoystickButton(joy2, 3);
    	four = new JoystickButton(joy2, 4);*/
    	trigger = new JoystickButton(joy, 1);
    	joy2 = new Joystick(1);
    	trigger.whileActive(new JoyDriveFast());
    	
    	
    	JoystickButton mast1 = new JoystickButton(joy2, 7);
        JoystickButton mast2= new JoystickButton(joy2, 8);
        JoystickButton mast3= new JoystickButton(joy2, 9);
        JoystickButton mast4 = new JoystickButton(joy2, 10);
        JoystickButton mast0 = new JoystickButton(joy2, 11);
        JoystickButton mastd = new JoystickButton(joy2, 5);
        JoystickButton mastu = new JoystickButton(joy2, 6);
        JoystickButton ledon = new JoystickButton(joy, 9);
        JoystickButton ledoff = new JoystickButton(joy, 10);
        //JoystickButton driveStraight = new JoystickButton(joy, 7);
        //JoystickButton strafeStraight = new JoystickButton(joy, 8);
        /*JoystickButton three = new JoystickButton(joy, 3);
        JoystickButton four = new JoystickButton(joy, 4);
        JoystickButton five = new JoystickButton(joy, 5);
        JoystickButton six = new JoystickButton(joy, 6);
        JoystickButton seven = new JoystickButton(joy, 7);
        JoystickButton eight = new JoystickButton(joy, 8);
        JoystickButton nine = new JoystickButton(joy, 9);
        JoystickButton test = new JoystickButton(joy2,  5);*/

        //driveStraight.whenPressed(new DriveStraight());
        //strafeStraight.whileHeld(new StrafeStraight());
        ledon.whenPressed(new LightsOn());
        ledoff.whenPressed(new LightsOff());
        //position conveyer
        mast1.whenPressed(new JoyMast(RobotMap.conveyerPos1,RobotMap.converyPos1MinSpeed,RobotMap.converyPos1MaxSpeed));
        //position conveyer
        mast2.whenPressed(new JoyMast(RobotMap.conveyerPos2,RobotMap.converyPos2MinSpeed,RobotMap.converyPos2MaxSpeed));
        //position conveyer
        mast3.whenPressed(new JoyMast(RobotMap.conveyerPos3,RobotMap.converyPos3MinSpeed,RobotMap.converyPos3MaxSpeed));
        //position conveyer
        mast4.whenPressed(new JoyMast(RobotMap.conveyerPos4,RobotMap.converyPos4MinSpeed,RobotMap.converyPos4MaxSpeed));
        //position conveyer
        mast0.whenPressed(new JoyMast(RobotMap.conveyerPos0,RobotMap.converyPos0MinSpeed,RobotMap.converyPos0MaxSpeed));
        //manual conveyer
        mastu.whenPressed(new JoyMastManual());
        //manual conveyer
        mastd.whenPressed(new JoyMastManual());
       /*three.whenPressed(new firstSequence());
        four.whenPressed(new DriveStraight(1, 25));
        five.whenPressed(new secondSequence());
        six.whenPressed(new DriveStraight(1, 30));
        seven.whenPressed(new thirdSequence());
        eight.whenPressed(new JoyMast(Robot.mast.setPosition(0)));
        nine.whenPressed(new RiddickSequence());*/
        //test.whenPressed(new Test());
    //	three.whileHeld(new MassTilt(.3));
    //	four.whileHeld(new MassTilt(-.3));
    }
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    public Joystick getJoystick(){
    	return joy;
    }
    public Joystick getJoystick2(){
    	return joy2;
    }
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
}

