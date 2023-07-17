package org.firstinspires.ftc.teamcode.ALMOSTPERFECT;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.ALMOSTPERFECT.DemoHardware;

@TeleOp (name = "TeleOp")
public class DemoT extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    DemoHardware robot = DemoHardware.getInstance();

    public void runOpMode() {
        robot.init(hardwareMap);

        telemetry.addData("status", "Initialized");
        telemetry.update();

        if (robot.rightWheel != null) {
            robot.rightWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
        if (robot.leftWheel != null) {
            robot.leftWheel.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }

        DemoHardware.maxSpeed = 1;

        waitForStart();

        boolean pressinga = false;

        while (opModeIsActive()) {

            double movement = -gamepad1.right_stick_x;
            double turning = gamepad1.left_stick_y;

            double left = movement + turning;
            double right = movement - turning;

            double max = Math.max(Math.abs(left), Math.abs(right));
            if (max > 1.0) {
                left /= max;
                right /= max;
            }

            robot.rightWheel.setPower(right);
            robot.leftWheel.setPower(left);

            if ((gamepad1.a && !pressinga)) {

                pressinga = true;
            } else if (gamepad1.a) {
                pressinga = false;
            }

            robot.robotClaw.setPower(gamepad2.left_stick_y);
        }
    }
}

