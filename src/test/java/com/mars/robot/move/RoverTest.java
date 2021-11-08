package com.mars.robot.move;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertEquals;

public class RoverTest {
    private Rover rover;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    @DisplayName("should turns left 90 degrees and remains on the current grid point.")
    public void shouldTurnLeft(){
        rover = new com.mars.robot.move.Rover("1 1 E");
        rover.turnLeft();
        assertEquals("N", rover.direction);

    }

    @Test
    @DisplayName("should turns right 90 degrees and remains on the current grid point.")
    public void shouldTurnRight(){
        rover = new Rover("1 1 E");
        rover.turnRight();
        assertEquals("S", rover.direction);
    }

    @Test
    @DisplayName("should moves forward one grid point in the direction of the current orientation i.e. East")
    public void shouldMoveForward(){
        rover = new Rover("1 1 E");
        rover.moveForward();
        assertEquals(2, rover.xAxis);
        assertEquals(1, rover.yAxis);
    }
    @Test
    @DisplayName("should process and moves based on instruction commands.Starts at 1 1 E;  Arrives at 1 1 E")
    public void robotInstructionProcessingForRFRFRFRF(){
        rover = new Rover("1 1 E");
        rover.robotInstructionProcessing("RFRFRFRF");
        assertEquals("1 1 E", rover.xAxis +" "+ rover.yAxis+" "+rover.direction);
    }

    @Test
    @DisplayName("should process and moves based on instruction commands.Starts at 3 2 N;  Arrives at 3 3 N")
    public void robotInstructionProcessingForFRRFLLFFRRFLL(){
        rover = new Rover("3 2 N");
        rover.robotInstructionProcessing("FRRFLLFFRRFLL");
        assertEquals("3 3 N ", rover.xAxis +" "+ rover.yAxis+" "+rover.direction+" "+rover.robotStatus);
    }

    @Test
    @DisplayName("should process and moves based on instruction commands. Starts at 0 3 W; Arrives at 2 4 S")
    public void robotInstructionProcessingForLLFFFLFLFL(){
        rover = new Rover("0 3 W");
        rover.robotInstructionProcessing("LLFFFLFLFL");
        assertEquals("2 4 S ", rover.xAxis +" "+ rover.yAxis+" "+rover.direction+" "+rover.robotStatus);
    }

    @Test
    @DisplayName("should process and moves based on instruction commands. Starts at 49 49 E; Arrives at 53 49 E LOST")
    public void robotInstructionProcessingForLOST(){
        rover = new Rover("49 49 E");
        rover.robotInstructionProcessing("FFFF");
        assertEquals("53 49 E LOST", rover.xAxis +" "+ rover.yAxis+" "+rover.direction+" "+rover.robotStatus);
    }

    @Test()
    @DisplayName("should throw exception when robots instruction is more than 100 character")
    public void exceptionTestForRobotInstructionProcessing(){
        rover = new Rover("0 3 W");
        exception.expectMessage("Instruction should be less than 100 characters in length.");
        rover.robotInstructionProcessing("FFFFRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRLLLLLLLFFFFFFLLFFFLFLFLLLLLFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFLLLLLLLLLLLRRRRRRFFFFFFFFFF");
    }
}
