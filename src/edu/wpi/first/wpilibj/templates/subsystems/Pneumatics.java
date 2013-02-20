
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.CompressorOn;

/**
 *
 * @author Spencer Lanman, FIRST FRC Team 3266
 */

public class Pneumatics extends Subsystem {

    Compressor compressor;
    
    public void initDefaultCommand() {
        setDefaultCommand(new CompressorOn());
    }
    
    public Pneumatics() {
        compressor = new Compressor(RobotMap.pressureSwitch, RobotMap.compressorRelay);
    }
    
    public void set(boolean on) {
        if(on) compressor.start();
        else compressor.stop();
    }
}
