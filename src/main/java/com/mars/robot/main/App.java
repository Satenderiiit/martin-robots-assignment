package com.mars.robot.main;


import com.mars.robot.move.Rover;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        // Problem statement
        // Mars surface model as rectangular grid. -->Robot movement boundary

        // High level problem statement:-
        // determines each sequence of robot positions and reports the final position of the robot.
        // *************************
        // Low level problem details:-
        // grid coordinate - (a pair of integers: x-coordinate followed by y-coordinate)
        //                 an orientation (N, S, E, W for north, south, east, and west).

        //  turnLeft() --> the robot turns left 90 degrees and remains on the current grid point.
        //  turnRight() --> the robot turns right 90 degrees and remains on the current grid point.
        //  moveForward() --> the robot moves forward one grid point in the direction of the current orientation and maintains the same orientation.

        // Future scope : additional command types

        // The direction North corresponds to the direction from grid point (x, y) to grid point (x, y+1).

        // Key Consideration :-
        //  a robots that moves  “off” an edge of the grid is lost forever.
        // However, lost robots leave a robot “scent” that prohibits future robots from dropping off the world at the same grid point.


        // The scent grid position - instruction is ignored by subsequent robots to avoid drop & lost forever.

        // Usecase boundary:-
        //Each robot is processed sequentially, i.e., finishes executing the robot instructions before the next robot begins execution.
        // MAX_X_COORDINATE & MAX_Y_COORDINATE is 50 respectively.
        // Instruction commands.length < 100

        System.out.println("Please provide positions for the robot format eg: 1 1 E  \n");
        Scanner scan = new Scanner(System.in);
        String robotPositions = scan.nextLine();

        Rover rover = new Rover(robotPositions);
        System.out.println("Please provide robot instruction format eg: RFRFRFRF \n");
        String robotInstructions = scan.nextLine();
        rover.robotInstructionProcessing(robotInstructions);
        System.out.println("Robots position after instruction command execution: " + rover.xAxis +" "+ rover.yAxis+" "+rover.direction + " " + rover.robotStatus);
    }
}
