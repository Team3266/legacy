package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.subsystems.*;

public abstract class CommandBase extends Command {
    
    public static Drivetrain drivetrain = new Drivetrain();
    public static Transmission transmission = new Transmission();
    public static Hopper hopper = new Hopper();
    public static Shooter shooter = new Shooter();
    public static Elevator elevator = new Elevator();
    public static Pneumatics pneumatics = new Pneumatics();
    public static Indexer indexer = new Indexer();
    public static OI oi = new OI();
    
    public static void init() {
        
    }
    
    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
