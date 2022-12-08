//
package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class preClaw {



    private Servo leftClaw = null;
    private Servo rightClaw = null;
    private HardwarePushbot robot;
    public double openPosition = 1;
    public double closedPosition = 0;

    {
        new HardwarePushbot();
    }

    // private Telemetry telemetry;

    public preClaw(HardwarePushbot robot) {
        super();
        this.robot = robot;
    }

    public void clawProcedure(Gamepad gamepad2) {

        double rotate = gamepad2.left_stick_x;

        //Counter clockwise is positive (right joystick), Counter is neg (joystick left?)
        if (gamepad2.x) {
            //isClawOpening = true;
            leftClaw.setPosition(openPosition);
            rightClaw.setPosition(closedPosition);
        }

    }
}