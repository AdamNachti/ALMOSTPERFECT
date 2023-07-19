package org.firstinspires.ftc.teamcode.ALMOSTPERFECT;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "DemoAuto")
public class DemoAuto extends LinearOpMode {

    DemoHardware robot = DemoHardware.getInstance();

            private ElapsedTime runtime = new ElapsedTime();


    public void runOpMode() {
        robot.init(hardwareMap);


        telemetry.addData("status", "initialized");
        telemetry.update();
        waitForStart();

        move(65, .5);

        /*runtime.reset();
        while (runtime.seconds() < 3) {
            robot.setPower(1,1);
        }
        runtime.reset();
        if (robot.colorSensor.red() > 10) {

        }*/

    }

    public void move(double distanceMoving, double speedMoving) {
        double wheelCircumference = 4 * Math.PI;
        double wheelMotor = 560;
        double ticks = (distanceMoving * (wheelMotor / wheelCircumference));

        robot.setPower(0, 0);
        robot.rightWheel.setTargetPosition((int) Math.round(ticks));
        robot.leftWheel.setTargetPosition((int) Math.round(ticks));

        robot.rightWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.leftWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        robot.rightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.leftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.rightWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        robot.leftWheel.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        robot.setPower(speedMoving, speedMoving);

        while (opModeIsActive() && (robot.rightWheel.getCurrentPosition() +10 < ticks
                || robot.leftWheel.getCurrentPosition() - 10 > ticks)) {
        }

        robot.setPower(0, 0);

        robot.rightWheel.setMode((DcMotor.RunMode.RUN_USING_ENCODER));
        robot.leftWheel.setMode((DcMotor.RunMode.RUN_USING_ENCODER));
    }

}

