package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;


/**
 * Created by brayden on 11/20/17.
 */

public class autoTemp {

    @Autonomous(name="Autonomous red side", group="NHRHS Robotics")

    public class AutoMode extends LinearOpMode {

        Hardware                robot = new Hardware();         // Uses Robot's Hardware


        @Override
        public void runOpMode() throws InterruptedException {

            // Init Hardware Map
            robot.init(hardwareMap);

            // Initialize Robot
            telemetry.addData("Status", "Lets go!");
            telemetry.update();

            // Robot is waiting to start
            waitForStart();
            //Start Autonomous
            //servo

            // Drive foward
            robot.motorBackRight.setPower(.5);
            robot.motorFrontRight.setPower(.5);
            robot.motorBackLeft.setPower(-.5);
            robot.motorFrontLeft.setPower(-.5);

            sleep(5000); //wait

            robot.motorBackRight.setPower(0);
            robot.motorFrontRight.setPower(0);
            robot.motorBackLeft.setPower(0);
            robot.motorFrontLeft.setPower(0);
        }
    }
}
