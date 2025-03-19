package by.mashnyuk.pointentity.service.impl;

import by.mashnyuk.pointentity.entity.Point;
import by.mashnyuk.pointentity.entity.PointsStorage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ExceptionTests {

    private PointsStorage pointsStorage;

    @BeforeClass
    public void initialSetUp() {
        pointsStorage = new PointServiceImpl().loadPoints("/exceptionsTest_data.txt");
        assertFalse(pointsStorage.getPoints().isEmpty(), "The points storage should not be empty.");
    }

    @Test
    public void testMoveWithNegativeTime() {
        Point point = pointsStorage.getPoints().get(0);
        assertTrue(PointServiceImpl.move(point, -1).isEmpty(), "Expected empty result for negative time.");
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testNullPoint() {
        new PointServiceImpl().calculateVelocity(null);
    }
}