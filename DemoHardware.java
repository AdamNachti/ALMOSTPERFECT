package org.firstinspires.ftc.teamcode.ALMOSTPERFECT;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.Range;

public class DemoHardware {

     public DcMotor rightWheel;

     public DcMotor leftWheel;

     public Servo demoServo;

     public BNO055IMU gyro;

     public static double maxSpeed = 1;

     private static DemoHardware myInstance = null;
     public static DemoHardware getInstance() {
          if(myInstance == null) {
               myInstance = new DemoHardware();
          }
          return myInstance;
     }

     public void init(HardwareMap hwMap) {


          try {
               rightWheel = hwMap.get(DcMotor.class, "rightWheel");
               rightWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
               rightWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
               rightWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
               rightWheel.setPower(0);
          }
          catch(Exception p_exception) {
               rightWheel = null;
          }
          try {
               leftWheel = hwMap.get(DcMotor.class, "leftWheel");
               leftWheel.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
               leftWheel.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
               leftWheel.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
               leftWheel.setPower(0);
          }
          catch(Exception p_exception) {
               leftWheel = null;
          }


          try {
               gyro = hwMap.get(BNO055IMU.class, "gyro");
               BNO055IMU.Parameters parameters = new BNO055IMU.Parameters();
               parameters.angleUnit = BNO055IMU.AngleUnit.DEGREES;
               parameters.accelUnit = BNO055IMU.AccelUnit.METERS_PERSEC_PERSEC;
               parameters.loggingEnabled = true;
               parameters.loggingTag = "gyro";
               gyro.initialize(parameters);
          }
          catch (Exception p_exception) {
               gyro = null;
          }

          try {
               demoServo = hwMap.get(Servo.class, "demoServo");
          }catch (Exception p_exception){
                    demoServo = null;
               }
          }


     public void setPower(double wheelDemo1, double wheelDemo2){
          if(rightWheel != null) {
               rightWheel.setPower(Range.clip(wheelDemo1, -maxSpeed, maxSpeed));
          }if (leftWheel != null){
                    leftWheel.setPower(Range.clip(wheelDemo2, -maxSpeed, maxSpeed));
               }
          }

     public void DemoServo(double servoDemo) {
          if (demoServo != null) {
               demoServo.setPosition(servoDemo);
          }
     }
}
