
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Spencer Lanman, FRC Team 3266
 */

public class ChangeElevation extends CommandBase {
    
    boolean up = false;
    boolean isTimed = false;
    
    public ChangeElevation(boolean isTimed) {
        requires(elevator);
        this.isTimed = isTimed;
    }

    protected void initialize() {
        
    }

    protected void execute() {
        elevator.setElevator(!up);
    }

    protected boolean isFinished() {
        if(isTimed) return isTimedOut();
        else return true;
    }

    protected void end() {
        up = !up;
    }

    protected void interrupted() {
        
    }
}
