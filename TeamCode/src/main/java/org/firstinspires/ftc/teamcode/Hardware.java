package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.ColorSensor;

/**
 * This is NOT an opmode.
 *
 * This class can be used to define all the specific hardware for a single robot.
 *
 *
 * This hardware class assumes the following device names have been configured on the robot:
 * Note:  All names are case sensitive and some have single spaces between words.
 */
public class Hardware
{
    /* Public OpMode members. */

    // Wheels
    public DcMotor  motorFrontLeft   = null;
    public DcMotor  motorBackLeft    = null;
    public DcMotor  motorFrontRight  = null;
    public DcMotor  motorBackRight   = null;

    // Servo arm
    public Servo sensor_arm = null;
    public ColorSensor color_sensor = null;

    // clamping system
    public DcMotor drawer = null;
    public DcMotor clampR = null;
    public DcMotor clampL = null;

    /* Local OpMode members. */
    HardwareMap hardwareMap = null;
    private ElapsedTime runtime  = new ElapsedTime();

    /* Constructor */
    public Hardware() {
    }

    /* Initialize standard Hardware interfaces */
    public void init(HardwareMap ahwMap) {
        // save reference to HW Map
        hardwareMap = ahwMap;


        //sensor
//        color_sensor = hardwareMap.colorSensor.get("color_sensor");
        // servo
//        sensor_arm = hardwareMap.servo.get("sensor_arm");
        // Wheels
        motorFrontLeft = hardwareMap.dcMotor.get("wheel_right_front");//ok
        motorFrontRight = hardwareMap.dcMotor.get("wheel_left_front"); //ok
        motorBackLeft = hardwareMap.dcMotor.get("wheel_right_back");//ok
        motorBackRight = hardwareMap.dcMotor.get("wheel_left_back");//ok

        // Clamps

        clampR = hardwareMap.dcMotor.get("clamp_r");//ok
        clampL = hardwareMap.dcMotor.get("clamp_l");//ok

        // Drawer

        drawer = hardwareMap.dcMotor.get("drawer_v");// ok

        // Set all motors to run without encoders.
        // May want to use RUN_USING_ENCODERS if encoders are installed.
        motorFrontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorFrontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorBackLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorBackRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    /***
     *
     * waitForTick implements a periodic delay. However, this acts like a metronome with a regular
     * periodic tick.  This is used to compensate for varying processing times for each cycle.
     * The function looks at the elapsed cycle time, and sleeps for the remaining time interval.
     *
     * @param periodMs  Length of wait cycle in mSec.
     * @throws InterruptedException
     */

    public void waitForTick(long periodMs)  throws InterruptedException {

        long  remaining = periodMs - (long)runtime.milliseconds();

        // sleep for the remaining portion of the regular cycle period.
        if (remaining > 0)
            Thread.sleep(remaining);

        // Reset the cycle clock for the next pass.
        runtime.reset();
    }
}

