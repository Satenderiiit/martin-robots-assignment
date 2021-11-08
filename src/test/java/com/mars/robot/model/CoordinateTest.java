package com.mars.robot.model;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CoordinateTest {

    @Test
    public void Should_Pass_All_Coordinate_Tests_Using_ClassAndFieldPredicatePair() {
        Coordinate coordinate = new Coordinate(2,4);
        assertEquals(2, coordinate.X());
        assertEquals(4, coordinate.Y());

    }

}
