
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Gamepad;

@TeleOp(name = "Speed Factor Test")
public class Speedfactortest extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {

        double speedFactor = 0.7;

        Gamepad currentGamepad1 = new Gamepad();
        Gamepad currentGamepad2 = new Gamepad();

        Gamepad previousGamepad1 = new Gamepad();
        Gamepad previousGamepad2 = new Gamepad();

        telemetry.addLine("WAITING FOR START");
        waitForStart();

        telemetry.addLine("PROGRAM STARTED");
        while( !isStopRequested() ) {

            // setting game-pad values
            previousGamepad1.copy(currentGamepad1);
            previousGamepad2.copy(currentGamepad2);
            currentGamepad1.copy(gamepad1);
            currentGamepad2.copy(gamepad2);

            if (currentGamepad1.a && !previousGamepad1.a) {
                speedFactor++;
                telemetry.addData("", "working ++");
            }

            if (gamepad1.left_bumper && !previousGamepad1.left_bumper) {
                speedFactor--;
                telemetry.addData("", "working --");
            }

            // Sets min/max values
            speedFactor = Math.max(speedFactor, 1);
            speedFactor = Math.min(speedFactor, 0.5);

            telemetry.addData("Speed Factor", speedFactor);
            telemetry.addData("left bumper", gamepad1.left_bumper);
            telemetry.addData("right bumper", gamepad1.right_bumper);
            telemetry.addData("prev left bumper", previousGamepad1.left_bumper);
            telemetry.addData("prev right bumper", previousGamepad1.right_bumper);
            telemetry.update();
        }
    }
}

