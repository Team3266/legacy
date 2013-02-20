
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Spencer Lanman, FIRST FRC Team 3266
 */

public class CompressorOn extends CommandBase {
    
    public CompressorOn() {
        requires(pneumatics);
    }

    protected void initialize() {
        pneumatics.set(true);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        pneumatics.set(false);
    }

    protected void interrupted() {
        pneumatics.set(false);
    }
}
