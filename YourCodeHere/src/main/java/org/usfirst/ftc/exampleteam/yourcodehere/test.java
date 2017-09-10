//Run from the package
package org.usfirst.ftc.exampleteam.yourcodehere;

//Import necessary items
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.ColorSensor;

@Autonomous(name="test") //Name the program
public class test extends LinearOpMode{
        //Define DC Motors
        DcMotor leftMotorFront;
        DcMotor rightMotorFront;
        DcMotor leftMotorBack;
        DcMotor rightMotorBack;
        DcMotor shooterLeft;
        DcMotor shooterRight;
        DcMotor spinnerTop;
        DcMotor spinnerBottom;

        //Define Sensors and the CDI
        ColorSensor colorSensorLeft;
        ColorSensor colorSensorRight;
        ColorSensor colorSensorBottom;
        DeviceInterfaceModule CDI;

        //Define a string to use as the color, and set it to blue, since we are blue team
        String color = "Red";

        //Define an int for the time that the shooter will be on
        int shootTime = 3000;

        //Set up drive powers to avoid magic numbers
        float drivePower= (float) 0.5;
        float stopOnLinePower = (float) 0.25;
        float shiftPower = (float) 0.4;
        float turnPower = (float) 0.4;

        //***************************************************************************************************************************
        //MAIN BELOW
        @Override
        public void runOpMode() throws InterruptedException
        {
            //Get references to the DC motors from the hardware map
            leftMotorFront = hardwareMap.dcMotor.get("leftMotorFront");
            rightMotorFront = hardwareMap.dcMotor.get("rightMotorFront");
            leftMotorBack = hardwareMap.dcMotor.get("leftMotorBack");
            rightMotorBack = hardwareMap.dcMotor.get("rightMotorBack");
            spinnerTop = hardwareMap.dcMotor.get("spinnerTop");
            spinnerBottom = hardwareMap.dcMotor.get("spinnerBottom");
            shooterLeft = hardwareMap.dcMotor.get("shooterLeft");
            shooterRight = hardwareMap.dcMotor.get("shooterRight");

            //Get references to the sensors and the CDI from the hardware map
            colorSensorBottom = hardwareMap.colorSensor.get("colorSensorBottom");
            colorSensorLeft = hardwareMap.colorSensor.get("colorSensorLeft");
            colorSensorRight = hardwareMap.colorSensor.get("colorSensorRight");
            CDI = hardwareMap.deviceInterfaceModule.get("CDI");

            //Set up the DriveFunctions class and give it all the necessary components (motors, sensors, CDI)
            DriveFunctions functions = new DriveFunctions(leftMotorFront, rightMotorFront, leftMotorBack, rightMotorBack, spinnerTop, spinnerBottom, shooterLeft, shooterRight, colorSensorLeft, colorSensorRight, colorSensorBottom, CDI);

            //Set the sensors to the modes that we want, and set their addresses. Also set the directions of the motors
            functions.initializeMotorsAndSensors();

            //Wait for start button to be clicked
            waitForStart();

//***********************************************************************************************************
            //LOOP BELOW
            //While the op mode is active, do anything within the loop
            //Note we use opModeIsActive() as our loop condition because it is an interruptible method.
            while (opModeIsActive()) {
                leftMotorBack.setPower(-1.0);
                rightMotorBack.setPower(1.0);
                leftMotorFront.setPower(-1.0);
                rightMotorFront.setPower(1.0);
            }
        }
    }
