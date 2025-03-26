package by.mashnyuk.pointentity.service.impl;

import by.mashnyuk.pointentity.conroller.Facade;
import by.mashnyuk.pointentity.entity.Point;
import by.mashnyuk.pointentity.entity.PointsStorage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ExceptionTests {

    private PointsStorage pointsStorage;

    @Test
    public void testMoveWithNegativeTime() {
        Point testPoint = new Point(3.0, 4.0, 0.0, 0.0, 3.0, 4.0, 0.0, 0.0, 0.0, 0.0);
        assertTrue(PointServiceImpl.move(testPoint, -1).isEmpty(), "Expected empty result for negative time.");
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testNullPoint() {
        new PointServiceImpl().calculateVelocity(null);
    }
}