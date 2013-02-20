
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.ChangeElevation;

/**
 *
 * @author Spencer Lanman, FIRST Team 3266
 */

public class Elevator extends Subsystem {
    
    Solenoid elevator;
    DigitalInput magneticStop;
    
    public void initDefaultCommand() {
        
    }
    
    public Elevator() {
        elevator = new Solenoid(RobotMap.elevatorSolenoid);
        magneticStop = new DigitalInput(RobotMap.magneticStop);
    }
    
    public void setElevator(boolean up) {
        elevator.set(up);
    }
}
