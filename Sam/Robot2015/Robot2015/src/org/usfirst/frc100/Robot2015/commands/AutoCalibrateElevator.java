package org.usfirst.frc100.Robot2015.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc100.Robot2015.Robot;

/**
 * Moves elevator down to lower limit switch and sets that position to be the
 * zero value.
 */
public class  AutoCalibrateElevator extends Command {
	
	// Requires the Elevator subsystem
    public AutoCalibrateElevator() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
        requires(Robot.elevator);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.elevator.manualControl(-0.42);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.elevator.getLowerLimit();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.activateBrake();;
    	Robot.elevator.zeroPID();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
