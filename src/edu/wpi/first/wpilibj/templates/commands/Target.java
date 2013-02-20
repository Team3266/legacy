
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Spencer Lanman, FRC Team 3266
 */

public class Target extends CommandBase {
    
    boolean isDone = false;
    
    public Target() {
        requires(drivetrain);
    }

    protected void initialize() {
        drivetrain.getImage();
    }

    protected void execute() {
        isDone = drivetrain.target();
    }

    protected boolean isFinished() {
        return isDone;
    }

    protected void end() {
        drivetrain.stopDrive();
    }

    protected void interrupted() {
        drivetrain.stopDrive();
    }
}
