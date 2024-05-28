
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import javax.swing.JToggleButton.ToggleButtonModel;

public class CompressorSubsystem extends SubsystemBase {

    public Compressor compressor = new Compressor(PneumaticsModuleType.CTREPCM);
    boolean bool = false;
    boolean value;
    AnalogInput pressureSensor = new AnalogInput(0);
    public static double pressure = 0;
    double maxPressure;
    SendableChooser<Double> maxPressureChooser = new SendableChooser<>();

    public void compressorControl(Joystick controller) {

        SmartDashboard.putData("Max Pressure", maxPressureChooser);
        SmartDashboard.putNumber("Pressure", Math.round(pressure * 1000) / 1000);

        maxPressureChooser.setDefaultOption("90 PSI", 90.0);
        maxPressureChooser.addOption("80 PSI", 80.0);
        maxPressureChooser.addOption("70 PSI", 70.0);
        maxPressureChooser.addOption("60 PSI", 60.0);
        maxPressureChooser.addOption("50 PSI", 50.0);
        maxPressureChooser.addOption("40 PSI", 40.0);
        maxPressureChooser.addOption("0 PSI", 0.0);

        pressure = convertVoltageToPressure(pressureSensor.getAverageVoltage());
        maxPressure = maxPressureChooser.getSelected();
        /*
         * if(controller.getRawButton(12)){ if(bool){ bool = false; } else{ bool = true;
         * } }
         */
        if (pressure < maxPressure) {
            compressor.enableDigital();

        } else {
            compressor.disable();
        }

    }

    public double convertVoltageToPressure(double voltage) {
        double pressure = 0;
        pressure = 250 * (voltage / 5) - 19.5;

        return pressure;
    }

    public double getPressure() {
        return pressure;
    }

    public void initDefaultCommand() {
    }

}