package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.subsystems.Arm;

public class RaiseArm extends CommandBase {
    
    public RaiseArm() {
        this.addRequirements(Robot.arm);
    }

    // Set Motor State to ON / OFF
    @Override
    public void initialize() {}

    @Override
    public void execute() {
            Robot.arm.setArmChainMotorState(Arm.ArmChainMotorState.ON);
            Robot.arm.setArmChainMotor2State(Arm.ArmChainMotor2State.ON);
        
    }
    
    @Override
    public void end(boolean interrupted) {
        
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}