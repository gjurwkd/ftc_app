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

            //Robot is waiting to start
            waitForStart();

            while (opModeIsActive()) {
            //Show imput

                //buttons
                telemetry.addData("a: ",gamepad1.a);
                telemetry.addData("b: ",gamepad1.b);
                telemetry.addData("y: ",gamepad1.y);
                telemetry.addData("x: ",gamepad1.x);

                //right stick
                telemetry.addData("right stick Y: ",(gamepad1.right_stick_y));
                telemetry.addData("right stick X: ",(gamepad1.right_stick_x));

                //left stick
                telemetry.addData("left stick Y: ",(gamepad1.left_stick_y));
                telemetry.addData("left stick X: ",(gamepad1.left_stick_x));

                //d pad
                telemetry.addData("d pad up:",gamepad1.dpad_up);
                telemetry.addData("d pad down:",gamepad1.dpad_down);
                telemetry.addData("d pad left:",gamepad1.dpad_left);
                telemetry.addData("d pad right:",gamepad1.dpad_right);

                //trigger
                telemetry.addData("right trigger:",gamepad1.right_trigger);
                telemetry.addData("left trigger:",gamepad1.left_trigger);

                //bumper
                telemetry.addData("right bumper:",gamepad1.right_bumper);
                telemetry.addData("left bumper:",gamepad1.left_bumper);

                //update
                telemetry.update();

                //Start code for moving

                // Drive train
                robot.motorBackRight.setPower(-gamepad1.right_stick_y/2);
                robot.motorFrontRight.setPower(-gamepad1.right_stick_y/2);
                robot.motorBackLeft.setPower(gamepad1.left_stick_y/2);
                robot.motorFrontLeft.setPower(gamepad1.left_stick_y/2);

                //v drawer slide
                if (gamepad1.x)
                {
                    robot.drawer.setPower(-.25);
                }

                else if (gamepad1.y)
                {
                    robot.drawer.setPower(1);
                }

                else
                {
                    robot.drawer.setPower(0);
                }
                //clamps
                //CHECK SIGNS
                if (gamepad1.a){
                    robot.clampR.setPower(.25);
                    robot.clampL.setPower(-.25);
                }
                else if (gamepad1.b)
                {
                    robot.clampR.setPower(-.25);
                    robot.clampL.setPower(.25);
                }

                else
                {
                    robot.clampR.setPower(0);
                    robot.clampL.setPower(0);
                }


            }
        }
    }
}
