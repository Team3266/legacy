
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Spencer Lanman, FRC Team 3266
 */

public class SetShooter extends CommandBase {
    
    double rpm = 0;
    
    public SetShooter(double rpm) {
        requires(shooter);
        this.rpm = rpm;
    }

    protected void initialize() {
        shooter.startEncoder();
    }

    protected void execute() {
        shooter.setSpinner(rpm);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        shooter.stopSpinner();
    }

    protected void interrupted() {
        shooter.stopSpinner();
    }
}
