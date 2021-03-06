package org.usfirst.frc100.SlideWinder.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc100.SlideWinder.SlideWinder;

/**
 * Autonomously turns to an angle in inches specified in the constructor
 * (relative to starting position). Uses PID.
 */
public class AutoTurn extends Command {

	private final double angle;
	private boolean gradualDrive;

	/**
	 * @param angle - The angle to turn in degrees
	 */
	public AutoTurn(double angle) {
		this.angle = angle;
		gradualDrive = false;
        requires(SlideWinder.drivetrain);
	}

	public AutoTurn(double angle, boolean gradualdrive) {
		this.angle = angle;
		gradualDrive = gradualdrive;
		requires(SlideWinder.drivetrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		SlideWinder.drivetrain.setAutoTarget(0, 0, angle);
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		SlideWinder.drivetrain.updateAuto(gradualDrive);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return SlideWinder.drivetrain.reachedAngle();
	}

	// Called once after isFinished returns true
	protected void end() {
		SlideWinder.drivetrain.drive(0, 0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}
