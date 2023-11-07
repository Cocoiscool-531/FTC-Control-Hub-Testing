package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "Servos")
@Disabled
public class Servos extends LinearOpMode {

    Gamepad currentGamepad1 = new Gamepad();
    Gamepad currentGamepad2 = new Gamepad();

    Gamepad previousGamepad1 = new Gamepad();
    Gamepad previousGamepad2 = new Gamepad();


    Servo servo1;


    public void runOpMode() throws InterruptedException {
        init();
        servo1 = hardwareMap.get(Servo.class, "servo1");
        double servoPosition = 0.5;
        int timer = 0;
        waitForStart();
        while(opModeIsActive()){

            previousGamepad1.copy(currentGamepad1);
            previousGamepad2.copy(currentGamepad2);
            currentGamepad1.copy(gamepad1);
            currentGamepad2.copy(gamepad2);

            if(currentGamepad1.dpad_up && !previousGamepad1.dpad_up)
            {servoPosition = servoPosition + 0.1;}
            if(currentGamepad1.dpad_down && !previousGamepad1.dpad_down)
            {servoPosition = servoPosition - 0.1;}

            servo1.setPosition(servoPosition);

            telemetry.addData("servo1", servo1.getPosition());
            telemetry.addData("timer", timer);
            telemetry.update();
        }
    }

}
