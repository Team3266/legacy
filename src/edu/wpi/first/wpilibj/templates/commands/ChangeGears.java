
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Spencer Lanman, FIRST FRC Team 3266
 */

public class ChangeGears extends CommandBase {
    
    public ChangeGears() {
        requires(transmission);
    }

    protected void initialize() {
        transmission.changeGears();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
