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

}
