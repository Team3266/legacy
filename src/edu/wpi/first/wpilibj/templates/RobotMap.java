package edu.wpi.first.wpilibj.templates;

public class RobotMap {
    
    //Values
    public static final double driveEncoderDistancePerPulse = 0.0019833287;
    public static final double spinnerEncoderDistancePerPulse = 0.0027777777777778;
    
    public static final double driveLowKp = 0.01;
    public static final double driveLowKi = 0.0;
    public static final double driveLowKd = 0.0;
    
    public static final double driveHighKp = 0.005;
    public static final double driveHighKi = 0.0;
    public static final double driveHighKd = 0.0;
    
    public static final double spinnerKp = -0.001;
    public static final double spinnerKi = -0.00005;
    public static final double spinnerKd = 0.0;
    
    public static final double rotationKp = -0.08;
    
    public static final double hopperKickLength = 0.25;
    public static final double hopperKickReturnLength = 0.35;
    
    //Autonomous Values
    public static final double preset1 = 3800.3266;
    public static final double preset2 = 4000.3266;
    public static final double preset3 = 4200.3266;
    public static final double preset4 = 4500.3266;
    
    //Controls (Joystick Controls)
    public static final int driveStick = 1;
    public static final int gunStick = 2;
    
    public static final int shiftGearsButton = 1;
    public static final int targetButton = 2;
    
    public static final int hopperKickerButton = 1;
    public static final int changeElevationButton = 2;
    
    public static final int preset1Button = 3;
    public static final int preset2Button = 4;
    public static final int preset3Button = 5;
    public static final int preset4Button = 6;
    
    public static final int indexerAxis = 6;
    
    //Electronics (Ports)
    public static final int frontLeftVictor = 3;
    public static final int rearLeftVictor = 1;
    public static final int frontRightVictor = 4;
    public static final int rearRightVictor = 2;
    
    public static final int compressorRelay = 1;
    public static final int pressureSwitch = 1;
    
    public static final int shifterSolenoidA = 1;
    public static final int shifterSolenoidB = 2;
    
    public static final int kickerSolenoid = 3;
    public static final int elevatorSolenoid = 4;
    
    public static final int gyro = 1;
    public static final int magneticStop = 9;
    
    public static final int leftDriveEncoderA = 4;
    public static final int leftDriveEncoderB = 2;
    public static final int rightDriveEncoderA = 5;
    public static final int rightDriveEncoderB = 3;
    
    public static final int spinnerVictor = 6;
    
    public static final int spinnerEncoderA = 7;
    public static final int spinnerEncoderB = 6;
    
    public static final int indexerVictor = 5;
}
