
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Spencer, Team 3266
 */
public class ShiftGears extends CommandBase {
    
    public ShiftGears() {
        requires(transmission);
    }
    
    protected void initialize() {
        
    }
    
    protected void execute() {
        transmission.shiftGears();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
