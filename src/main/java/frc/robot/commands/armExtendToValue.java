// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.ArmSystem;
//import destiny2;

public class armExtendToValue extends CommandBase {
  private static ArmSystem m_armsysyetem;
  private static PIDController m_pidController;
  public static double destination;
  /** Creates a new armExtendToValue. */
  public armExtendToValue(ArmSystem sub1, double dest) { //dest, more like destiny 2
    // Use addRequirements() here to declare subsystem dependencies.
    destination = dest;
    m_armsysyetem = sub1;
    addRequirements(m_armsysyetem);
    m_pidController = new PIDController(Constants.PID_ARM_P, Constants.PID_ARM_I, Constants.PID_ARM_D);
    m_pidController.setSetpoint(destination);
    m_pidController.setTolerance(Constants.kTurnToleranceDeg, Constants.kTurnRateToleranceDegPerS);
    //m_pidController.enableContinuousInput(Constants.MIN_ARM_POSITION, Constants.MAX_ARM_POSITION);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_pidController.setSetpoint(destination);
    System.out.println(destination);
    double output = m_pidController.calculate(m_armsysyetem.getPosition(), destination);
    m_armsysyetem.extendArm(output);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_armsysyetem.stopArmMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_pidController.atSetpoint();
  }

  // Commands to check error and output
  public static double getError() {
    return m_pidController.getPositionError();
  }
  
  public static double getOutput() {
    return m_pidController.calculate(m_armsysyetem.getPosition());
  }

  public static void updateDestination(double newDestination) {
    armExtendToValue.destination = newDestination;
  }

  /*public static void printOutput() {
    System.out.println("Output: " + getOutput());
  }

  public static void printError() {
  }

  public static void printDestination(double destination) {
    System.out.print(destination);*/
  }


