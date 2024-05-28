// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

public class DriveSubsystem extends SubsystemBase {

  private WPI_VictorSPX leftDrive = new WPI_VictorSPX(Constants.MOTOR_LEFT_ID);
  private WPI_VictorSPX rightDrive = new WPI_VictorSPX(Constants.MOTOR_RIGHT_ID);

  private MotorControllerGroup rightMotors = new MotorControllerGroup(rightDrive);
  private MotorControllerGroup leftMotors = new MotorControllerGroup(leftDrive);

  public DifferentialDrive base = new DifferentialDrive(leftMotors, rightMotors);

  public void drive(double speed, double angle) {
    
    base.arcadeDrive(speed, angle);
  }

  public void initDefaultCommand() {
    // setDefaultCommand(new Drive(driveController.getRawAxis(1),
    // driveController.getRawAxis(0));
  }

  public void setLeftMotors(double speed) {
    leftDrive.set(ControlMode.PercentOutput, -speed);
  }

  public void setRightMotors(double speed) {
    rightDrive.set(ControlMode.PercentOutput, speed);
  }
}
