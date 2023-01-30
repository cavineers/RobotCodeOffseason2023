package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Arm;

public class ExtendArm extends CommandBase {
    
    public ExtendArm() {
        this.addRequirements(Robot.arm);
    }

    // Set Motor State to ON / OFF
    @Override
    public void initialize() {}

    @Override
    public void execute() {
            Robot.arm.setArmExtensionMotorState(Arm.ArmExtensionMotorState.ON);
    }

    @Override
    public void end(boolean interrupted) {}

    @Override
    public boolean isFinished() {
        return false;
    }
}