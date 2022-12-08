package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@TeleOp (name="IterativeOpMode", group="Iterative OpMode")
public class IterativeOpMode extends OpMode{
    private ElapsedTime runTime = new ElapsedTime();

    private HardwarePushbot robot = new HardwarePushbot();
    private Drive drive = new Drive(robot);
    private intake intake = new intake(robot);
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

    @Override public void start(){



    }

    @Override public void loop(){


        drive.manualDrive(gamepad1);

    }
}
