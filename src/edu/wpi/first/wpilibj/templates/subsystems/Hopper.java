
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.UserHopper;

/**
 *
 * @author Spencer, Team 3266
 */
public class Hopper extends Subsystem {

    Solenoid kicker;
    
    public void initDefaultCommand() {
        setDefaultCommand(new UserHopper());
    }
    
    public Hopper() {
        kicker = new Solenoid(RobotMap.kickerSolenoid);
    }
    
    public void set(boolean on) {
        kicker.set(on);
    }
}
