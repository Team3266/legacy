
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Spencer Lanman, FRC Team 3266
 */

public class UserIndexer extends CommandBase {
    
    public UserIndexer() {
        requires(indexer);
    }

    protected void initialize() {
        indexer.set(false);
    }

    protected void execute() {
        if(oi.gunStick.getRawAxis(RobotMap.indexerAxis)==-1.0) indexer.set(true);
        else indexer.set(false);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        indexer.set(false);
    }

    protected void interrupted() {
        indexer.set(false);
    }
}
