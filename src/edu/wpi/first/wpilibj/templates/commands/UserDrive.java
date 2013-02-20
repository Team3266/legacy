/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author Spencer, Team 3266
 */
public class UserDrive extends CommandBase {
    
    public UserDrive() {
        requires(drivetrain);
    }

    protected void initialize() {
        drivetrain.startEncoders();
    }

    protected void execute() {
        drivetrain.joystickDrive(oi.driveStick);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
        drivetrain.stopDrive();
        drivetrain.stopEncoders();
    }

    protected void interrupted() {
        drivetrain.stopDrive();
        drivetrain.stopEncoders();
    }
}
