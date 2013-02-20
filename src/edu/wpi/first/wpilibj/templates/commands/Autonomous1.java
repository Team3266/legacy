
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Spencer, Team 3266
 */
public class Autonomous1 extends CommandGroup {
    
    public Autonomous1() {
        System.out.println("Auton");
        addParallel(new SetShooter(RobotMap.preset1), 5.0);
        addSequential(new ChangeElevation(true), 5.0);
        addParallel(new SetShooter(RobotMap.preset1));
        addSequential(new ShooterReady());
        addParallel(new SetShooter(RobotMap.preset1));
        addSequential(new KickHopper());
        addParallel(new SetShooter(RobotMap.preset1));
        addSequential(new ShooterReady());
        addParallel(new SetShooter(RobotMap.preset1));
        addSequential(new KickHopper());
        addParallel(new SetShooter(RobotMap.preset1));
        addSequential(new ShooterReady());
        addParallel(new SetShooter(RobotMap.preset1));
        addSequential(new KickHopper());
        addSequential(new SetShooter(0.0), 1.0);
    }
}
