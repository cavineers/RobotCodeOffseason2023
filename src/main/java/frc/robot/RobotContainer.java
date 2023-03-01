package frc.robot;

import frc.robot.Constants.OIConstants;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Arm;
import frc.robot.commands.NumPad.BottomLeft;
import frc.robot.commands.NumPad.BottomMid;
import frc.robot.commands.NumPad.BottomRight;
import frc.robot.commands.NumPad.MidLeft;
import frc.robot.commands.NumPad.MidMid;
import frc.robot.commands.NumPad.MidRight;
import frc.robot.commands.NumPad.TopLeft;
import frc.robot.commands.NumPad.TopMid;
import frc.robot.commands.NumPad.TopRight;
import frc.robot.commands.ManualOverrideCommands.ExtendArm;
import frc.robot.commands.ManualOverrideCommands.RetractArm;
import frc.robot.commands.ManualOverrideCommands.RaiseArm;
import frc.robot.commands.ManualOverrideCommands.LowerArm;
import frc.robot.commands.ControllerPresets.HomeArm;
import frc.robot.commands.ControllerPresets.BottomNode;
import frc.robot.commands.ControllerPresets.MidNode;
import frc.robot.commands.ControllerPresets.TopNode;


public class RobotContainer  {
    
    public Command m_autoCommand;
    public SendableChooser<Command> auto = new SendableChooser<Command>();

    public Command m_armBottomLeft;
    public Command m_armBottomMid;
    public Command m_armBottomRight;
    public Command m_armMidLeft;
    public Command m_armMidMid;
    public Command m_armMidRight;
    public Command m_armTopLeft;
    public Command m_armTopMid;
    public Command m_armTopRight;
    public Command m_armRaise;
    public Command m_armLower;
    public Command m_armExtend;
    public Command m_armRetract;
    public Command m_armHome;
    public Command m_armBottomNode;
    public Command m_armMidNode;
    public Command m_armTopNode;
    public Command m_arm;

    // Driver Controller
  public Joystick joy = new Joystick(0);
  public JoystickButton a_button = new JoystickButton(joy, 1);
  public JoystickButton b_button = new JoystickButton(joy, 2);
  public JoystickButton x_button = new JoystickButton(joy, 3);
  public JoystickButton y_button = new JoystickButton(joy, 4);
  public JoystickButton l_bump = new JoystickButton(joy, 5);
  public JoystickButton r_bump = new JoystickButton(joy, 6);
  public JoystickButton left_menu = new JoystickButton(joy, 7);
  public JoystickButton right_menu = new JoystickButton(joy, 8);
  public JoystickButton left_stick = new JoystickButton(joy, 9);
  public JoystickButton right_stick = new JoystickButton(joy, 10);

  public POVButton povUp = new POVButton(joy, 0, 0);
  public POVButton povRight = new POVButton(joy, 90, 0);
  public POVButton povDown = new POVButton(joy, 180, 0);
  public POVButton povLeft = new POVButton(joy, 270, 0); 

  // Driver Numpad
  public Joystick joy2 = new Joystick(1);
  public JoystickButton a_button2 = new JoystickButton(joy2, 1);
  public JoystickButton b_button2 = new JoystickButton(joy2, 2);
  public JoystickButton x_button2 = new JoystickButton(joy2, 3);
  public JoystickButton y_button2 = new JoystickButton(joy2, 4);
  public JoystickButton l_bump2 = new JoystickButton(joy2, 5);
  public JoystickButton r_bump2 = new JoystickButton(joy2, 6);
  public JoystickButton left_menu2 = new JoystickButton(joy2, 7);
  public JoystickButton right_menu2 = new JoystickButton(joy2, 8);
  public JoystickButton left_stick2 = new JoystickButton(joy2, 9);
  public JoystickButton right_stick2 = new JoystickButton(joy2, 10);

  public POVButton povUp2 = new POVButton(joy2, 0, 0);
  public POVButton povRight2 = new POVButton(joy2, 90, 0);
  public POVButton povDown2 = new POVButton(joy2, 180, 0);
  public POVButton povLeft2 = new POVButton(joy2, 270, 0); 

  public enum CurrentMode {
    DRIVE,
    ARM
  }
  
  
    
  private Joystick m_joy = new Joystick(OIConstants.kDriverJoystickPort);

    public POVButton m_povUp = new POVButton(m_joy, 0, 0);
    
    public CurrentMode mode = CurrentMode.DRIVE; 

    public RobotContainer() {
      if(this.mode == CurrentMode.DRIVE) {
        configureButtonBindings();
        configureButtonBindingsNumPad();
      } else {
        configureButtonBindingsArm();
        configureButtonBindingsNumPad();
      }
    };

    private void configureButtonBindings() {
      this.right_menu.onTrue(new InstantCommand() {
        public void initialize() {
          mode = CurrentMode.ARM;
        }
      });
        
      this.left_menu.onTrue(new InstantCommand() {
        public void initialize() {
          m_armHome = new HomeArm();
          m_armHome.schedule();
        }
      });
      this.povDown.onTrue(new InstantCommand() {
        public void initialize() {
          m_armBottomNode = new BottomNode();
          m_armBottomNode.schedule();
        }
      });
      this.povRight.onTrue(new InstantCommand() {
        public void initialize() {
          m_armMidNode = new MidNode();
          m_armMidNode.schedule();
        }
      });
      this.povUp.onTrue(new InstantCommand() {
        public void initialize() {
          m_armTopNode = new TopNode();
          m_armTopNode.schedule();
        }
      });
    }

    private void configureButtonBindingsNumPad() {
      
      this.a_button2.onTrue(new InstantCommand() {
          public void initialize() {
            m_armBottomLeft = new BottomLeft();
            m_armBottomLeft.schedule();
          }
        });
        this.b_button2.onTrue(new InstantCommand() {
          public void initialize() {
            m_armBottomMid = new BottomMid();
            m_armBottomMid.schedule();
          }
        });
        this.x_button2.onTrue(new InstantCommand() {
          public void initialize() {
            m_armBottomRight = new BottomRight();
            m_armBottomRight.schedule();
          }
        });
        this.y_button2.onTrue(new InstantCommand() {
          public void initialize() {
            m_armMidLeft = new MidLeft();
            m_armMidLeft.schedule();
          }
        });
        this.povUp2.onTrue(new InstantCommand() {
          public void initialize() {
            m_armMidMid = new MidMid();
            m_armMidMid.schedule();
          }
        });
        this.povRight2.onTrue(new InstantCommand() {
          public void initialize() {
            m_armMidRight = new MidRight();
            m_armMidRight.schedule();
          }
        });
        this.povLeft2.onTrue(new InstantCommand() {
          public void initialize() {
            m_armTopLeft = new TopLeft();
            m_armTopLeft.schedule();
          }
        });
        this.povDown2.onTrue(new InstantCommand() {
          public void initialize() {
            m_armTopMid = new TopMid();
            m_armTopMid.schedule();
          }
        });
        this.r_bump2.onTrue(new InstantCommand() {
          public void initialize() {
            m_armTopRight = new TopRight();
            m_armTopRight.schedule();
          }
        });
    }
    private void configureButtonBindingsArm() {
      this.right_menu.onTrue(new InstantCommand() {
        public void initialize() {
          mode = CurrentMode.DRIVE;
        }
      });
    }
    
   

    public double getJoystickRawAxis(int id) {
        return -m_joy.getRawAxis(id);
    };
}
