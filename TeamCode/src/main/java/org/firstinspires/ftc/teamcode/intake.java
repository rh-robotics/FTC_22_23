//
package org.firstinspires.ftc.teamcode;
import androidx.annotation.NonNull;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.Gamepad;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class intake {

    private final HardwarePushbot robot;
    private HardwarePushbot robot;

    {
        new HardwarePushbot();
    }

    private Telemetry telemetry;
    public boolean flipped;
    public intake(HardwarePushbot robot) {
        super();
        this.robot = robot;
    }

    public void intake(Gamepad gamepad) {

        double up = 0;
        double down = 360;

        if (gamepad.b)
        {
            flipped = true;
        }
        else
        {
            flipped = false;
        }

        if (gamepad.a)
        {
            clawServo.setPosition(closed);
        }
        else
        {
            clawServo.setPosition(open);
        }

        if (flipped)
        {
            armServo.setPosition(down);
        }



        telemetry.addData("arm servo", " (%.2f),",  armServo.getPosition());
        telemetry.addData("claw servo", " (%.2f),",  clawServo.getPosition());

    }

}