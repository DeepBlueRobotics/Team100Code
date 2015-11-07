package org.usfirst.frc100.Robot2015.subsystems;

import org.usfirst.frc100.Robot2015.RobotMap;
import org.usfirst.frc100.Robot2015.commands.*;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The autonomous arm used to grab recycling containers from the step.
 */
public class Arm extends Subsystem {
	
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    SpeedController deployMotor = RobotMap.armDeployMotor;
    SpeedController raiseMotor = RobotMap.armRaiseMotor;
    DoubleSolenoid piston = RobotMap.armPiston;
    DigitalInput containerSensor = RobotMap.armContainerSensor;
    AnalogPotentiometer potentiometer = RobotMap.armPotentiometer;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
    }
    
    // Returns whether the arm's grabbing mechanism is closed
    public boolean isGrabbing() {
    	return piston.get() == DoubleSolenoid.Value.kForward;    	
    }
    
    // Sets the arm to open or close the grabbing mechanism
    public void setArm(boolean grab) {
    	if (grab) {
    		piston.set(DoubleSolenoid.Value.kForward); 
    	}else{
    		piston.set(DoubleSolenoid.Value.kReverse);
    	}
    }
    
    // Updates the SmartDashboard
    public void updateDashboard() {
    	SmartDashboard.putBoolean("Arm Grabbing", isGrabbing());
    	SmartDashboard.putBoolean("Arm Container Sensor", containerSensor.get());
    	SmartDashboard.putNumber("Arm Potentiometer", potentiometer.get());
    }
}