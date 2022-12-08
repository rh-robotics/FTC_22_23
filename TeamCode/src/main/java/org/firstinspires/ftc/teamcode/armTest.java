package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp (name="armTest", group="Iterative OpMode")
public class armTest extends OpMode{

    private ElapsedTime runTime = new ElapsedTime();

    private Servo armServo = null;
    private Servo clawServo = null;
    private DcMotor flipMotor = null;
   // HardwareMap hwMap =  null;

    public boolean clawMechanism = true;
    public boolean armMechanism = true;
    public double up = 0;
    public double down = -270;
    public double closed = 50;
    public double open = 0;


    @Override public void init(){
        //hwMap = bhwMap;
        armServo = hardwareMap.get(Servo.class, "armServo");
        clawServo = hardwareMap.get(Servo.class, "clawServo");
        flipMotor = hardwareMap.get(DcMotorEx.class, "flipMotor");

        telemetry.addData("Status", "Initialized" );

    }

    @Override public void start(){}


    @Override public void loop()
    {


        if (gamepad1.b)
        {
         armServo.setPosition(down);
        }
        else
        {
            armServo.setPosition(up);
        }


        if (clawMechanism)
        {
            clawServo.setPosition(closed);
        }
        else
        {
            clawServo.setPosition(open);
        }



        telemetry.addData("arm servo", " (%.2f),",  armServo.getPosition());
        telemetry.addData("claw servo", " (%.2f),",  clawServo.getPosition());

    }
}

