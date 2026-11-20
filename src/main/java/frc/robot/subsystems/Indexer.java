package frc.robot.subsystems;

import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.SparkMax;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Indexer extends SubsystemBase {
    private SparkMax indexerMotor;
    private SparkMax feederMotor;
    public Indexer(){
        indexerMotor = new SparkMax(24, MotorType.kBrushless);
        feederMotor = new SparkMax(23, MotorType.kBrushless);
    }
    public Command go(){
        return run(() -> {
            indexerMotor.setVoltage(5);
            feederMotor.setVoltage(5);
        });
    }
    public Command reverse(){
        return run(() ->{
            indexerMotor.setVoltage(-5);
            feederMotor.setVoltage(-5);
        });
    }
    public Command stop(){
        return run(() -> {
            indexerMotor.setVoltage(0);
            feederMotor.setVoltage(0);
        });
    }
    
}