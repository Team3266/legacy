
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 * @author Spencer, Team 3266
 */
public class UserShooter extends CommandBase {
    
    public UserShooter() {
        requires(shooter);
    }

    protected void initialize() {
        
    }
    
    protected void execute() {
        shooter.stopSpinner();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        
    }
}
