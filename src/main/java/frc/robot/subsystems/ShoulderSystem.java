package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
public class ShoulderSystem extends SubsystemBase { 

    private static Encoder shoulder_encoder;
    private WPI_TalonSRX shoulderMotor;


    public ShoulderSystem() {
        shoulder_encoder = new Encoder(Constants.ENCODER_SHOULDER_A, Constants.ENCODER_SHOULDER_B);
        shoulderMotor = new WPI_TalonSRX(Constants.SHOULDER_MOTOR);
    }

    @Override
    public void periodic() {
        //Called once per scheduler run
    }

    @Override
    public void simulationPeriodic() {
        //Called once per scheduler run when in simulation
    }

    //Following methods are for controlling the system

    public void lowerShoulder() {
        shoulderMotor.set(0.1); // Notice the sllow speed on the shoulder
    }

    public void raiseShoulder() {
        shoulderMotor.set(-0.1); 
    }

    public void stopShoulderMotor() {
        shoulderMotor.stopMotor();
    }

    public int getPosition() {
        return shoulder_encoder.get();
    }



}
