
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Spencer Lanman, FIRST FRC Team 3266
 */

public class OnHopper extends CommandBase {

    public OnHopper() {
        requires(hopper);
        setInterruptible(false);
        setTimeout(RobotMap.hopperKickLength);
    }
    
    protected void initialize() {
        hopper.set(true);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
    }

    protected void interrupted() {
    }
    
}
