
package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());

    // Driver's Joystick
    public Joystick joyDriver;


    public OI() {

        //joyCo = new Joystick(RobotMap.JOYCO_USB_PORT);
        joyDriver = new Joystick(Constants.JOYDRIVER_USB_PORT); 
    }
        
    public Joystick getJoyDriver() {
        return joyDriver;
    }

    public double getJoyDriverAxis(int axis) {
        return joyDriver.getRawAxis(axis);
    }
}

