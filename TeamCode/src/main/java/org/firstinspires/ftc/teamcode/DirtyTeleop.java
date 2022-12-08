package org.firstinspires.ftc.teamcode;

import static java.lang.Thread.sleep;
import java.lang.Thread;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp (name="DirtyTele", group="Iterative OpMode")
public class DirtyTeleop extends OpMode{

    private ElapsedTime runTime = new ElapsedTime();
    private HardwarePushbot robot = new HardwarePushbot();
   // private Drive drive = new Drive(robot);
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    private Servo clawServo = null;
    private Servo armServo = null;

   public boolean flipped;


    @Override public void init(){
        robot.init(hardwareMap);

        leftDrive = hardwareMap.get(DcMotor.class, "flDrive");
        rightDrive = hardwareMap.get(DcMotor.class, "frDrive");

        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);

        telemetry.addData("Status", "Initialized" );
        //drive.manualDrive(gamepad1);
    }

    @Override public void start(){}


    @Override public void loop()
    {
        double strafe_Y = gamepad1.left_stick_y; // forward is pos, backward is neg. (-1 <= magnitude <= 1)
        double strafe_X = -gamepad1.right_stick_x; //right is pos, left is neg. (-1 <= magnitude <= 1)

        double blStrafePwr = (strafe_X+strafe_Y);
        double brStrafePwr = -(strafe_X-strafe_Y);
        double flStrafePwr = -(strafe_X-strafe_Y);
        double frStrafePwr = (strafe_X+strafe_Y);

        double up = 0;
        double down = 360;
        double open = -180;
        double closed = 180;
        double rotate = gamepad1.left_stick_x;


        //Counter clockwise is positive (right joystick), Counter is neg (joystick left?)

        if (strafe_Y==0 && strafe_X==0) {
            robot.blDrive.setPower(rotate);
            robot.brDrive.setPower(-rotate);
            robot.flDrive.setPower(rotate);
            robot.frDrive.setPower(-rotate);
        }
        else {
            robot.blDrive.setPower(blStrafePwr);
            robot.brDrive.setPower(brStrafePwr);
            robot.flDrive.setPower(flStrafePwr);
            robot.frDrive.setPower(frStrafePwr);
        }



        if (gamepad1.b)
        {
            flipped = true;
        }
        else
        {
            flipped = false;
        }

        if (gamepad1.a)
        {
            clawServo.setPosition(closed);
        }
        else
        {
            clawServo.setPosition(open);
        }

        if (flipped) {
            armServo.setPosition(down);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flipped = false;
        }




        telemetry.addData("arm servo", " (%.2f),",  armServo.getPosition());
        telemetry.addData("claw servo", " (%.2f),",  clawServo.getPosition());
        telemetry.addData("flDrive", "(%)", robot.flDrive.getPower());
        telemetry.addData("frDrive", "(%)", robot.frDrive.getPower());
        telemetry.addData("blDrive", "(%)", robot.blDrive.getPower());
        telemetry.addData("brDrive", "(%)", robot.brDrive.getPower());


    }

    }




