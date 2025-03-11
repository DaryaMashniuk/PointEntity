package by.mashnyuk.pointentity.service.impl;

import by.mashnyuk.pointentity.entity.Point;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ExceptionTests {

    @Test
    public void testMoveWithNegativeTime() {
        Point point = new Point(0, 0, 0, 0, 2, 3, 4, 1, 1, 1);
        assertTrue(PointServiceImpl.move(point, -1).isEmpty());
    }

    @Test(expectedExceptions = NullPointerException.class)
    public void testNullPoint() {
        new PointServiceImpl().getVelocity(null);
    }
}