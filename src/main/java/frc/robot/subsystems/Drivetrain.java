package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.TankDrive;

public class Drivetrain extends Subsystem {
    public TalonSRX leftMaster  = new TalonSRX(20);
    public TalonSRX leftSlave   = new TalonSRX(21);
    public TalonSRX rightMaster = new TalonSRX(22);
    public TalonSRX rightSlave  = new TalonSRX(23);

    public Drivetrain(){
        leftSlave.set(ControlMode.Follower, leftMaster.getDeviceID());
        rightSlave.set(ControlMode.Follower, rightMaster.getDeviceID());
    }

    public void setOutput(double leftOutput, double rightOutput){
        leftMaster.set(ControlMode.PercentOutput, leftOutput);
        rightMaster.set(ControlMode.PercentOutput, rightOutput);
        SmartDashboard.putNumber("Left Output", leftOutput);
        SmartDashboard.putNumber("Right Output", rightOutput);
    }

    public void initDefaultCommand(){
        setDefaultCommand(new TankDrive());
    }
}
