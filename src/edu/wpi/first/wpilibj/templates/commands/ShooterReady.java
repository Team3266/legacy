
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Spencer Lanman, FRC Team 3266
 */

public class ShooterReady extends CommandBase {
    
    public ShooterReady() {
        
    }

    protected void initialize() {
        
    }

    protected void execute() {
        
    }

    protected boolean isFinished() {
        return shooter.isOnTarget();
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
}
