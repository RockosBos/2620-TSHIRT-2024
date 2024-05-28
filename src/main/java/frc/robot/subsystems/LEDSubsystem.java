// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class LEDSubsystem extends SubsystemBase {
  /** Creates a new LEDSubsystem. */
  AddressableLED led;
  AddressableLEDBuffer ledBuffer;
  Timer timer;
  double colorLength = 3.0;
  String colorState = "Red";


  public LEDSubsystem() {
      led = new AddressableLED(0);
      ledBuffer = new AddressableLEDBuffer(140);
      timer = new Timer();
      led.setLength(140);
      led.setData(ledBuffer);

      led.start();
      timer.start();
  }

  @Override
  public void periodic() {
    if(timer.get() > colorLength){
        if(colorState == "Blue"){
            colorState = "Red";
        }
        else if(colorState == "Red"){
            colorState = "Blue";
        }
        timer.reset();
    }

    if(colorState == "Red"){
      for(int i = 0; i < ledBuffer.getLength(); i++){
          ledBuffer.setRGB(i, 255, 0, 0);
      }
    }
    else if(colorState == "Blue"){
      for(int i = 0; i < ledBuffer.getLength(); i++){
          ledBuffer.setRGB(i, 0, 0, 255);
      }
    }
    led.setData(ledBuffer);

    // This method will be called once per scheduler run
  }
}
