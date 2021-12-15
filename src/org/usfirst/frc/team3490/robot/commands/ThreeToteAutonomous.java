package org.usfirst.frc.team3490.robot.commands;


import org.usfirst.frc.team3490.robot.RobotMap;


import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ThreeToteAutonomous extends CommandGroup {
    
    public  ThreeToteAutonomous() {
    //	addSequential(new JoyMast(Robot.mast.setPosition(1)));   	
    	//addSequential(new JoyMast(Robot.mast.setPosition(3)));
    	addSequential(new JoyMast(RobotMap.conveyerPos2,RobotMap.converyPos2MinSpeed,RobotMap.converyPos2MinSpeed));
     	addSequential(new DriveStraight(-1, 20));
    	addSequential(new StrafeStraight(-1,84));
    	addSequential(new DriveStraight(1, 25));
    	addSequential(new JoyMast(RobotMap.conveyerPos3,RobotMap.converyPos3MinSpeed,RobotMap.converyPos3MinSpeed));
       	addSequential(new DriveStraight(-1, 24));
    	addSequential(new StrafeStraight(-1, 90));
    	addSequential(new DriveStraight(1, 30));
    	addSequential(new JoyMast(RobotMap.conveyerPos4,RobotMap.converyPos4MinSpeed,RobotMap.converyPos4MinSpeed));
    	addSequential(new DriveStraight(-1, 90));
    	addSequential(new JoyMast(RobotMap.conveyerPos2,RobotMap.converyPos2MinSpeed,RobotMap.converyPos2MinSpeed));
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
