
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.image.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.UserDrive;

/**
 *
 * @author Spencer, Team #3266
 */
public class Drivetrain extends Subsystem {

    RobotDrive drive;
    Victor frontLeft, frontRight, rearLeft, rearRight;
    Encoder leftEncoder, rightEncoder;
    Gyro gyro;
    
    PIDController leftPID, rightPID;
    
    LeftDriveOutput leftDriveOutput;
    RightDriveOutput rightDriveOutput;
    
    AxisCamera camera;
    ColorImage cImage;
    BinaryImage bImage;
    int redLow, redHigh, greenLow, greenHigh, blueLow, blueHigh;
    
    public void initDefaultCommand() {
        setDefaultCommand(new UserDrive());
    }
    
    public Drivetrain() {
        
        frontLeft = new Victor(RobotMap.frontLeftVictor);
        rearLeft = new Victor(RobotMap.rearLeftVictor);
        frontRight = new Victor(RobotMap.frontRightVictor);
        rearRight = new Victor(RobotMap.rearRightVictor);
        
        drive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);
        
        leftEncoder = new Encoder(RobotMap.leftDriveEncoderA, RobotMap.leftDriveEncoderB);
        rightEncoder = new Encoder(RobotMap.rightDriveEncoderA, RobotMap.rightDriveEncoderB);
        
        gyro = new Gyro(RobotMap.gyro);
        
        camera = AxisCamera.getInstance("10.32.66.11");
//        try {
//            cImage = new RGBImage();
//            bImage = (BinaryImage) new MonoImage();
//        } catch (NIVisionException ex) {
//            ex.printStackTrace();
//        }
        
        redLow = 10;
        redHigh = 155;
        greenLow = 140;
        greenHigh = 255;
        blueLow = 140;
        blueHigh = 255;
        
        leftEncoder.setPIDSourceParameter(Encoder.PIDSourceParameter.kDistance);
        rightEncoder.setPIDSourceParameter(Encoder.PIDSourceParameter.kDistance);
        
        leftDriveOutput = new LeftDriveOutput();
        rightDriveOutput = new RightDriveOutput();
        
        leftPID = new PIDController(RobotMap.driveLowKp, RobotMap.driveLowKi, RobotMap.driveLowKd, leftEncoder, leftDriveOutput);
        rightPID = new PIDController(RobotMap.driveLowKp, RobotMap.driveLowKi, RobotMap.driveLowKd, rightEncoder, rightDriveOutput);
        leftPID.setOutputRange(-1.0, 1.0);
        rightPID.setOutputRange(-1.0, 1.0);
        
        leftEncoder.setDistancePerPulse(-RobotMap.driveEncoderDistancePerPulse);
        rightEncoder.setDistancePerPulse(RobotMap.driveEncoderDistancePerPulse);
    }
    
    public void joystickDrive(Joystick stick) {
        drive.arcadeDrive(stick);
        
        SmartDashboard.putNumber("Speed", getSpeed());
    }
    
    public void setLeftDrive(double speed) {
        frontLeft.set(speed);
        rearLeft.set(speed);
    }
    public void setRightDrive(double speed) {
        frontRight.set(speed);
        rearRight.set(speed);
    }
    
    public void stopDrive() {
        drive.drive(0.0, 0.0);
    }
    
    public void changeGears(boolean lowGear) {
        boolean isEnabled = leftPID.isEnable() && rightPID.isEnable();
                
        if(lowGear) {
            leftPID.setPID(RobotMap.driveLowKp, RobotMap.driveLowKi, RobotMap.driveLowKd);
        } else {
            rightPID.setPID(RobotMap.driveHighKp, RobotMap.driveHighKi, RobotMap.driveHighKd);
        }
        
        if(!isEnabled) {
            leftPID.reset();
            rightPID.reset();
        }
    }
    
    public void startEncoders() {
        leftEncoder.reset();
        rightEncoder.reset();
        leftEncoder.start();
        rightEncoder.start();
    }
    
    public void driveDistance(double feet) {
        leftPID.setSetpoint(feet);
        rightPID.setSetpoint(feet);
        leftPID.enable();
        rightPID.enable();
    }
    
    double aimRotation = 0;
    
    public double getImage() {
        if(camera.freshImage()) {
            try {
                cImage = camera.getImage();
                bImage = cImage.thresholdRGB(
                        redLow, 
                        redHigh,
                        greenLow, 
                        greenHigh, 
                        blueLow, 
                        blueHigh);
                
                cImage.free();
                
                bImage.convexHull(true);
                
                ParticleAnalysisReport[] particles = bImage.getOrderedParticleAnalysisReports();
                
                bImage.free();
 
                int highestParticle = -1;
                double highestHeight = camera.getResolution().height;

                for(int i=0; i<particles.length; i++) {
                    if(particles[i].center_mass_y<highestHeight && particles[i].particleArea>20.0) {
                        highestHeight = particles[i].particleArea;
                        highestParticle = i;
                    }
                }
                
                if(highestParticle>=0) {
                    double fov = 30;
                    double widthRes = camera.getResolution().width;
                    double PARatio = (fov/2)/widthRes;
                    aimRotation = -((widthRes/2)-(particles[highestParticle].center_mass_x))*PARatio;
                }
                System.out.println(aimRotation);
                return aimRotation;
            } catch (AxisCameraException ex) {
                ex.printStackTrace();
                return aimRotation;
            } catch (NIVisionException ex) {
                ex.printStackTrace();
                return aimRotation;
            }
        } else return aimRotation;
    }
    
    
    
    public boolean target() {
        gyro.reset();
        double leftValue = limit((getGyroAngle()-aimRotation)*-RobotMap.rotationKp);
        double rightValue = limit((getGyroAngle()-aimRotation)*RobotMap.rotationKp);
        
        if (leftValue<0) drive.tankDrive(-2.0+leftValue, 2.0+rightValue);
        else drive.tankDrive(2.0+leftValue, -2.0+rightValue);
        
        if((getGyroAngle()>=-0.5 && getGyroAngle()<=0.5)) {
            double checkRotation = getImage();
            if ((getGyroAngle()-checkRotation>=-0.5) && (getGyroAngle()-checkRotation<=0.5)) {
                drive.drive(0.0, 0.0);
                return true;
            } else return false;
        } else return false;
    }
    
    private double limit(double value) {
        if(value>1.0) value = 1.0;
        if(value<-1.0) value = -1.0;
        return value;
    }
    
    public double getGyroAngle() {
        return gyro.getAngle();
    }
    
    public void disablePID() {
        leftPID.disable();
        rightPID.disable();
    }
    
    public double getSpeed() {
        return((leftEncoder.getRate()+rightEncoder.getRate())/2);
    }
    
    public double getDistance() {
        return((leftEncoder.getDistance()+rightEncoder.getDistance())/2);
    }
    
    public void stopEncoders() {
        leftEncoder.stop();
        rightEncoder.stop();
        leftEncoder.reset();
        rightEncoder.reset();
    }
}