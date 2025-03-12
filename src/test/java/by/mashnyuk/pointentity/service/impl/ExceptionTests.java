package by.mashnyuk.pointentity.service.impl;

import by.mashnyuk.pointentity.entity.Point;
import by.mashnyuk.pointentity.util.TestFileReader;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;

public class ExceptionTests {

    private List<Point> testPoints;

    @BeforeClass
    public void initialSetUp() {
        testPoints = TestFileReader.readPointsFromFile("src/test/resources/exceptionsTest_data.txt").getPoints();
        assertFalse(testPoints.isEmpty(), "The testPoints list should not be empty.");
    }

    @Test
    public void testMoveWithNegativeTime() {
        Point point = testPoints.get(0);
        assertTrue(PointServiceImpl.move(point, -1).isEmpty(), "Expected empty result for negative time.");
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testNullPoint() {
        new PointServiceImpl().getVelocity(null);
    }
}