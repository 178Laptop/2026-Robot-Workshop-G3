// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Indexer;

public class RobotContainer {
  private CommandXboxController xbox360;
  private Indexer indexer;
  public RobotContainer() {
    xbox360 = new CommandXboxController(0);
    indexer = new Indexer();
    indexer.setDefaultCommand(indexer.stop());
    configureBindings();
  }

  private void configureBindings() {
    xbox360.b().and(xbox360.a().negate()).whileTrue(indexer.reverse());
    xbox360.a().and(xbox360.b().negate()).whileTrue(indexer.go()); 
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
