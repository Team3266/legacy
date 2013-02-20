
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.OI;

/**
 *
 * @author Developer
 */

public class KickHopper extends CommandGroup {
    
    public KickHopper() {
        setInterruptible(false);
        addSequential(new ShooterReady());
        addSequential(new OnHopper());
        addSequential(new OffHopper());
    }
}
