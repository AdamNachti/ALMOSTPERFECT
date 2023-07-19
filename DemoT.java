package org.firstinspires.ftc.teamcode.ALMOSTPERFECT;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

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

        boolean pressingRt = false;

        boolean pressingLt = false;

        boolean pressed = false;

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

            robot.clawExtension.setPower(gamepad2.left_stick_y);

            robot.robotClawExtension.setPower(gamepad2.right_stick_x);

            if ((gamepad2.right_trigger > 0.1) && !pressingRt) {
                robot.robotClaw.setPosition(0.097);
                pressingRt = true;
            } else if (!(gamepad2.right_trigger > 0.1)) {
                pressingRt = false;
            }
            if ((gamepad2.left_trigger > 0.1) && !pressingLt) {
                robot.robotClaw.setPosition(.205);
                pressingLt = true;
            } else if (!(gamepad2.left_trigger > 0.1)) {
                pressingLt = false;
            }
        }
    }
}

