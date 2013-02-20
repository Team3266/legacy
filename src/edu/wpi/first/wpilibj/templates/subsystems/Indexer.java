
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.UserIndexer;

/**
 *
 * @author Spencer Lanman, FRC Team 3266
 */

public class Indexer extends Subsystem {
    
    Victor indexer;
    
    public void initDefaultCommand() {
        setDefaultCommand(new UserIndexer());
    }
    
    public Indexer() {
        indexer = new Victor(RobotMap.indexerVictor);
    }
    
    public void set(boolean on) {
        if(on) indexer.set(1.0);
        else indexer.set(0.0);
    }
}
