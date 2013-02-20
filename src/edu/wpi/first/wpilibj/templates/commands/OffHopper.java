
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Spencer Lanman, FIRST FRC Team 3266
 */

public class OffHopper extends CommandBase {

    public OffHopper() {
        requires(hopper);
        setInterruptible(false);
        setTimeout(RobotMap.hopperKickReturnLength);
    }
    
    protected void initialize() {
        hopper.set(false);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
        hopper.set(false);
    }

    protected void interrupted() {
        hopper.set(false);
    }
    
}
