
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 *
 * @author Spencer Lanman, FIRST Team 3266
 */
public class RightDriveOutput implements PIDOutput {

    public void pidWrite(double d) {
        CommandBase.drivetrain.setRightDrive(d);
        System.out.println("Right Drive Speed: "+d);
    }
}
