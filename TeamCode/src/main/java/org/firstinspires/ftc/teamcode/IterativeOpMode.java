package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.Gamepad;


import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;


//as of 11/16/2022, this code controls the strafing/driving of the robot as it is now.

@TeleOp (name="Basic: IterativeOpMode", group="Iterative OpMode")
public class IterativeOpMode extends OpMode{
    private ElapsedTime runTime = new ElapsedTime();

    private HardwarePushbot robot = new HardwarePushbot();

    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;


    @Override public void init(){
        robot.init(hardwareMap);

        leftDrive = hardwareMap.get(DcMotor.class, "flDrive");
        rightDrive = hardwareMap.get(DcMotor.class, "frDrive");

        leftDrive.setDirection(DcMotor.Direction.FORWARD);
        rightDrive.setDirection(DcMotor.Direction.FORWARD);

        telemetry.addData("Status", "Initialized" );

    }

    @Override public void start(){ }

    @Override public void loop(){


        double strafe_Y = gamepad1.left_stick_y; // forward is pos, backward is neg. (-1 <= magnitude <= 1)
        double strafe_X = -gamepad1.right_stick_x; //right is pos, left is neg. (-1 <= magnitude <= 1)

        double blStrafePwr = (strafe_X+strafe_Y);
        double brStrafePwr = -(strafe_X-strafe_Y);
        double flStrafePwr = -(strafe_X-strafe_Y);
        double frStrafePwr = (strafe_X+strafe_Y);

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



        //telemetry.addData("Motors driving? ", )
        telemetry.update();


    }


}
