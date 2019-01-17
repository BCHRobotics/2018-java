/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.DriveArcade;

/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	TalonSRX leftFrontTalon = null;
	TalonSRX leftMiddleTalon = null;
	TalonSRX leftBackTalon = null;
	TalonSRX rightFrontTalon = null;
	TalonSRX rightMiddleTalon = null;
	TalonSRX rightBackTalon = null;
	
	



	DifferentialDrive differentialDrive = null;

	public Drivetrain() {
		leftFrontTalon = new TalonSRX(RobotMap.DRIVETRAIN_LEFT_FRONT_TALON);
		leftMiddleTalon = new TalonSRX(RobotMap.DRIVETRAIN_LEFT_MIDDLE_TALON);
		leftBackTalon = new TalonSRX(RobotMap.DRIVETRAIN_LEFT_BACK_TALON);
		rightFrontTalon = new TalonSRX(RobotMap.DRIVETRAIN_RIGHT_FRONT_TALON);
		rightMiddleTalon = new TalonSRX(RobotMap.DRIVETRAIN_RIGHT_MIDDLE_TALON);
		rightBackTalon = new TalonSRX(RobotMap.DRIVETRAIN_RIGHT_BACK_TALON);
		
		rightBackTalon.follow(rightFrontTalon);
		rightMiddleTalon.follow(rightFrontTalon);
		leftBackTalon.follow(leftFrontTalon);
		leftMiddleTalon.follow(leftFrontTalon);
	}


	/*public void arcadeDrive(double moveSpeed, double rotateSpeed) {
		leftFrontTalon.set(ControlMode.PercentOutput, (rotateSpeed + moveSpeed));
		rightFrontTalon.set(ControlMode.PercentOutput, (rotateSpeed - moveSpeed));
	}*/

	public void arcadeDrive(double moveSpeed, double rotateSpeed) {
		leftFrontTalon.set(ControlMode.PercentOutput, moveSpeed);
		rightFrontTalon.set(ControlMode.PercentOutput, moveSpeed);
	
	}

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new DriveArcade());
	}
}
