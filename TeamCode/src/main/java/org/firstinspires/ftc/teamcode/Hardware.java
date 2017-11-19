package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * This is NOT an opmode.
 *
 * This class can be used to define all the specific hardware for a single robot.
 *
 * This hardware class assumes the following device names have been configured on the robot:
 * Note:  All names are case sensitive and some have single spaces between words.
 *
 * Motor channel:  Left  Front drive motor:         "left front"
 * Motor channel:  Right Front drive motor:         "right front"
 * Motor channel:  Left  Back drive motor:          "left back"
 * Motor channel:  Right Back drive motor:          "right back"
 *
 * Motor channel:  Catapult motor:                  "arm"
 *
 * Motor channel:  Lift motor vertical              "lift vert"
 * Motor channel:  Lift motor horizontal            "lift hor"
 *
 * Servo channel:  Claw servo:                      "claw"
 *
 * Servo channel:  Gate servo:                      "gate"
 *
 */
public class Hardware
{
    /* Public OpMode members. */

    // Wheels
    public DcMotor  motorFrontLeft   = null;
    public DcMotor  motorBackLeft    = null;
    public DcMotor  motorFrontRight  = null;
    public DcMotor  motorBackRight   = null;

    // Arms
    public CRServo rotateGrabL = null;
    public CRServo rotateGrabR = null;

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

        // Wheels
        motorFrontLeft = hardwareMap.dcMotor.get("d_q2");
        motorFrontRight = hardwareMap.dcMotor.get("d_q1");
        motorBackLeft = hardwareMap.dcMotor.get("d_q3");
        motorBackRight = hardwareMap.dcMotor.get("d_q4");

        // Grabber

        rotateGrabL = hardwareMap.crservo.get("g_sweepL");
        rotateGrabR = hardwareMap.crservo.get("g_sweepR");

        // Clamps

        clampR = hardwareMap.dcMotor.get("g_clampR");
        clampL = hardwareMap.dcMotor.get("g_clampL");

        // Drawer

        drawer = hardwareMap.dcMotor.get("v_drawer");

        // Set all motors to zero power
        motorFrontLeft.setPower(0);
        motorFrontRight.setPower(0);
        motorBackLeft.setPower(0);
        motorBackRight.setPower(0);

        rotateGrabL.setPower(0);
        rotateGrabR.setPower(0);

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

