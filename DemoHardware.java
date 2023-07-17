package org.firstinspires.ftc.teamcode.ALMOSTPERFECT;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class DemoHardware {

    public DcMotor demoWheel1;

    public DcMotor demoWheel2;

    public Servo demoServo;

    public BNO055IMU gyro;

    public double maxSpeed = 1;

    private static DemoHardware myInstance = null;

    public static DemoHardware getInstance() {

        if (myInstance == null)

            myInstance = new DemoHardware();

        return myInstance;
    }

    public void init(HardwareMap hwMap) {


        try {

            demoWheel1 = hwMap.get(DcMotor.class, "demoWheel1");
            demoWheel1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            demoWheel1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            demoWheel1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            demoWheel1.setPower(0);
        } catch (Exception p_exception) {
            demoWheel1 = null;


            demoWheel2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
            demoWheel2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            demoWheel2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            demoWheel2.setPower(0);

        } catch (Exception p_exception) {
            gyro = null;

        }
        try {
            demoServo = hwMap.get(Servo.class, "demoServo");

        } catch (Exception p_exception) {
            demoServo = null;
        }
    }


    public void setPower(double wheelDemo1, double wheelDemo2) {
        if (demoWheel1 != null) {

        }
    }
}










