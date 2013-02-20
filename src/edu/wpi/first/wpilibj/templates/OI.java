
package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.*;

public class OI {
    
    public Joystick driveStick = new Joystick(RobotMap.driveStick);
    public Joystick gunStick = new Joystick(RobotMap.gunStick);
    
    public JoystickButton shiftGearsButton = new JoystickButton(driveStick, RobotMap.shiftGearsButton);
    public JoystickButton targetButton = new JoystickButton(driveStick, RobotMap.targetButton);
    
    public JoystickButton changeElevationButton = new JoystickButton(gunStick, RobotMap.changeElevationButton);
    
    public JoystickButton preset1 = new JoystickButton(gunStick, RobotMap.preset1Button);
    public JoystickButton preset2 = new JoystickButton(gunStick, RobotMap.preset2Button);
    public JoystickButton preset3 = new JoystickButton(gunStick, RobotMap.preset3Button);
    public JoystickButton preset4 = new JoystickButton(gunStick, RobotMap.preset4Button);
    
    public OI() {
        
        shiftGearsButton.whileHeld(new ShiftGears());
        shiftGearsButton.whenReleased(new ChangeGears());
        
        targetButton.whileHeld(new Target());
        
        changeElevationButton.whenPressed(new ChangeElevation(false));
        
        preset1.whileHeld(new SetShooter(RobotMap.preset1));
        preset2.whileHeld(new SetShooter(RobotMap.preset2));
        preset3.whileHeld(new SetShooter(RobotMap.preset3));
        preset4.whileHeld(new SetShooter(RobotMap.preset4));
    }
}