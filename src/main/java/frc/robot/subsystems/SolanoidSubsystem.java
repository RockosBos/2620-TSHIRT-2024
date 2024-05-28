// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsModuleType;

public class SolanoidSubsystem extends SubsystemBase {

  public DoubleSolenoid doubleSolenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 0, 1);

  /** Creates a new SolanoidSubsystem. */

  public void solanoidControl(Joystick controller) {
    if (controller.getRawAxis(3) > 0.1) {
      doubleSolenoid.set(kForward);
    } else if (controller.getRawAxis(3) < -0.1) {
      doubleSolenoid.set(kReverse);
    } else {
      doubleSolenoid.set(kOff);
    }
  }

}
