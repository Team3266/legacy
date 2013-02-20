
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.UserShooter;

/**
 *
 * @author Spencer, Team 3266
 */

public class Shooter extends Subsystem implements PIDOutput, PIDSource {

    Victor spinner;
    Encoder spinnerEncoder;
    PIDController pid;
    
    double rpm = 0;
    
    public void initDefaultCommand() {
        setDefaultCommand(new UserShooter());
    }
    
    public Shooter() {
        spinner = new Victor(RobotMap.spinnerVictor);
        
        spinnerEncoder = new Encoder(RobotMap.spinnerEncoderA, RobotMap.spinnerEncoderB);
        spinnerEncoder.setDistancePerPulse(-RobotMap.spinnerEncoderDistancePerPulse);
        
        pid = new PIDController(RobotMap.spinnerKp, RobotMap.spinnerKi, RobotMap.spinnerKd, this, this);
        //pid.setPercentTolerance(0.5);
    }
    
    public void startEncoder() {
        spinnerEncoder.start();
        pid.enable();
    }
    
    public void stopEncoder() {
        spinnerEncoder.stop();
        spinnerEncoder.reset();
        pid.disable();
        pid.reset();
    }
    
    public void setSpinner(double rpm) {
        pid.setSetpoint(rpm);
    }
    
    public void stopSpinner() {
        pid.setSetpoint(0.0);
        setSpinner(0.0);
    }
    
    public boolean isOnTarget() {
        double setpoint = pid.getSetpoint();
        double rpm = pidGet();
        return setpoint>=rpm-50 && setpoint<=rpm+50;
    }

    public void pidWrite(double d) {
        spinner.set(d);
    }

    double prevDistance = 0;
    double prevTime = 0;
    double prevRate = 0;
    
    public double pidGet() {
        double curTime = System.currentTimeMillis();
        double time = curTime - prevTime;
        double curDistance = spinnerEncoder.getDistance();
        double distance = curDistance - prevDistance;
        double rate = (distance/(time/1000))*60;
        SmartDashboard.putNumber("Shooter Speed", rate);
        prevTime = curTime;
        prevDistance = curDistance;
        prevRate = rate;
        return(rate);
    }
}
