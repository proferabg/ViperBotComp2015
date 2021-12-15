package org.usfirst.frc.team3490.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoConveyerCanFwd extends CommandGroup {
    
    public  AutoConveyerCanFwd() {
        // Add Commands here:
        addSequential(new AutoClose(false,true));
        addSequential(new DriveStraight(1,100));
        addSequential(new AutoClose(true,false));
        
      
    }
}
