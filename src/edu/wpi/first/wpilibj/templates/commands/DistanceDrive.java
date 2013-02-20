
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Spencer Lanman, FIRST FRC Team 3266
 */

public class DistanceDrive extends CommandBase {
    
    public DistanceDrive() {
        requires(drivetrain);
    }

    protected void initialize() {
        drivetrain.driveDistance(12.0);
    }

    protected void execute() {
        
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

    protected void end() {
        drivetrain.disablePID();
        drivetrain.stopDrive();
    }

    protected void interrupted() {
        drivetrain.disablePID();
        drivetrain.stopDrive();
    }
}
