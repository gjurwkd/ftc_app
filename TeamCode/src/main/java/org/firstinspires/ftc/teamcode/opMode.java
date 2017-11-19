package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;


@TeleOp(name="Standard OpMode", group="NHRHS Robotics")
public class opMode extends LinearOpMode {

    Hardware                robot = new Hardware();         // Uses Robot's Hardware
    private ElapsedTime     runtime = new ElapsedTime();

    static final double ARM_SPEED = 0.4;

    @Override
    public void runOpMode() throws InterruptedException {

        // Init Hardware Map
        robot.init(hardwareMap);

        // Initialize Robot
        telemetry.addData("Status: ", "Ready to eat a potato!");
        telemetry.update();

        // Robot is waiting to start
        waitForStart();

        while (opModeIsActive()) {

            /**
             * Navigation - Controler 1
             */

            // Values declared for stick navigation
            double leftstick = gamepad1.left_stick_y;
            double rightstick = gamepad1.right_stick_y;

            // Values declared for dpad navigation
            boolean dpad_up1 = gamepad1.dpad_up;
            boolean dpad_down1 = gamepad1.dpad_down;
            boolean dpad_left1 = gamepad1.dpad_left;
            boolean dpad_right1 = gamepad1.dpad_right;

            boolean dpad_up2 = gamepad2.dpad_up;
            boolean dpad_down2 = gamepad2.dpad_down;

            int dpad_upValue = 0;
            int dpad_downValue = 0;
            int dpad_leftValue = 0;
            int dpad_rightValue = 0;

            // Speed via Stick
            robot.motorBackLeft.setPower(leftstick/2);
            robot.motorFrontLeft.setPower(leftstick/2);
            robot.motorFrontRight.setPower(rightstick/2);
            robot.motorBackRight.setPower(rightstick/2);

            // Speed via Dpad

            // Convert boolean values to ints
            if(dpad_up1 == true){
                dpad_upValue = 1;
            }
            if(dpad_down1 == true){
                dpad_downValue = -1;
            }
            if(dpad_left1 == true){
                dpad_leftValue = 1;
            }
            if(dpad_right1 == true){
                dpad_rightValue = 1;
            }

            // Forward
            robot.motorBackLeft.setPower(dpad_upValue);
            robot.motorFrontLeft.setPower(dpad_upValue);
            robot.motorFrontRight.setPower(dpad_upValue);
            robot.motorBackRight.setPower(dpad_upValue);

            // Backwards
            robot.motorBackLeft.setPower(dpad_downValue);
            robot.motorFrontLeft.setPower(dpad_downValue);
            robot.motorFrontRight.setPower(dpad_downValue);
            robot.motorBackRight.setPower(dpad_downValue);

            // Left
            robot.motorBackLeft.setPower(dpad_leftValue*-1);
            robot.motorFrontLeft.setPower(dpad_leftValue*-1);
            robot.motorFrontRight.setPower(dpad_leftValue);
            robot.motorBackRight.setPower(dpad_leftValue);

            // Right
            robot.motorBackLeft.setPower(dpad_leftValue);
            robot.motorFrontLeft.setPower(dpad_leftValue);
            robot.motorFrontRight.setPower(dpad_leftValue*-1);
            robot.motorBackRight.setPower(dpad_leftValue*-1);

            /**
             * Sweepers - Controller 1
             */

            if(gamepad1.left_trigger > 0){
                robot.rotateGrabL.setPower(gamepad1.right_trigger);
                robot.rotateGrabR.setPower(gamepad1.right_trigger);
            }
            else{
                robot.rotateGrabL.setPower(0);
                robot.rotateGrabR.setPower(0);
            }
            if(gamepad1.right_trigger > 0){
                robot.rotateGrabL.setPower(gamepad1.right_trigger);
                robot.rotateGrabR.setPower(gamepad1.right_trigger);
            }
            else{
                robot.rotateGrabL.setPower(0);
                robot.rotateGrabR.setPower(0);
            }

            /**
             * Clamps - Controller 2
             */

                robot.clampL.setPower(gamepad2.left_stick_x/5);
                robot.clampR.setPower(gamepad2.right_stick_x/5);


            /**
             * Drawer - Controller 2
             */
            if(dpad_up2 == true){
                robot.drawer.setPower(1);
            }
            else{
                robot.drawer.setPower(0);
            }
            if(dpad_down2 == true){
                robot.drawer.setPower(-1);
            }
            else{
                robot.drawer.setPower(0);
            }


            /**
             * Telemetry Code
             */
            // Logs
            telemetry.addData("Status", "Running for " + runtime.toString() + " :)");
            telemetry.addData("Left top speed :", leftstick);
            telemetry.addData("Right top speed :", rightstick);
            telemetry.update();

            // Pause for metronome tick.  40 mS each cycle = update 25 times a second.
            robot.waitForTick(40);
            idle();

            /*
                Legacy Code. PLEASE IGNORE
             */
            // boolean claw = gamepad1.left_bumper;
            // double  clawPosition = robot.Claw.getPosition(); //Position of Claw

            //boolean ShiftLeft = gamepad1.dpad_left;
            //boolean ShiftRight = gamepad1.dpad_right;
            //while(left_trigger)
            /*          // Arm ~ Right Trigger for Up / Left Trigger Down ~
            if (gamepad1.right_trigger == 1)
                robot.Arm.setPower(ARM_SPEED);
            else if(gamepad1.left_trigger == 1)
                robot.Arm.setPower(-ARM_SPEED);

            //Claw - SERVO
            robot.Claw.setPosition(Hardware.CLAW_HOME);
            if(claw) {
                robot.Claw.setPosition(1);
                sleep(10);
            }
            */
            //shift left
            /*
            if(ShiftLeft){
                robot.motorBackLeft.setPower(0.5);
                robot.motorFrontLeft.setPower(0.5);
                robot.motorFrontRight.setPower(0);
                robot.motorBackRight.setPower(0);
            }

            //shift right
            if (ShiftRight){
                robot.motorBackLeft.setPower(0);
                robot.motorFrontLeft.setPower(0);
                robot.motorFrontRight.setPower(0.5);
                robot.motorBackRight.setPower(0.5);
            }
            */
        }
    }
}
