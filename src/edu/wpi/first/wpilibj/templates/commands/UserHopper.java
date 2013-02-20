
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Spencer Lanman, FRC Team 3266
 */

public class UserHopper extends CommandBase {
    
    public UserHopper() {
        requires(hopper);
        this.setInterruptible(false);
    }

    protected void initialize() {
        
    }
    
    boolean isFinished = false;
    boolean pressed = false;
    byte state = 4;
    double startTime = 0;
    
    protected void execute() {
        
        switch(state) {
            
            case 0:
                startTime = System.currentTimeMillis();
                hopper.set(true);
                state = 1;
                break;
            
            case 1: //On
                if(startTime+RobotMap.hopperKickLength*1000<=System.currentTimeMillis()) state = 2;
                break;
                
            case 2:
                startTime = System.currentTimeMillis();
                hopper.set(false);
                state = 3;
                break;
                
            case 3: //Off
                if(startTime+RobotMap.hopperKickReturnLength*1000<=System.currentTimeMillis()) state = 4;
                break;
                
            case 4: //Check
                if(oi.gunStick.getRawButton(RobotMap.hopperKickerButton)) state = 0;
                break;
        }
    }

    protected boolean isFinished() {
        return isFinished;
    }

    protected void end() {
        
    }

    protected void interrupted() {
        hopper.set(false);
    }
}
