
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author Spencer, Team 3266
 */
public class Transmission extends Subsystem {

    Solenoid shifterA, shifterB;
    boolean lowGear;
    
    protected void initDefaultCommand() {
        
    }
    
    public Transmission() {
        shifterA = new Solenoid(RobotMap.shifterSolenoidA);
        shifterB = new Solenoid(RobotMap.shifterSolenoidB);
        lowGear = true;
    }
    
    public void shiftGears() {
        shifterA.set(lowGear);
        shifterB.set(!shifterA.get());
        System.out.println("Shifting Gears...");
    }
    
    public void changeGears() {
        lowGear = !lowGear;
        CommandBase.drivetrain.changeGears(lowGear);
        System.out.println("Gears Changed");
    }
}
