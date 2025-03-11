package by.mashnyuk.pointentity.service.impl;

import by.mashnyuk.pointentity.entity.Point;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ParameterizedTests {

    @DataProvider(name = "velocityData")
    public Object[][] createVelocityData() {
        return new Object[][] {
                {0, 0, 0, 0, 3, 4, 0, 5.0},
                {1, 1, 1, 0, 6, 8, 0, 10.0},
                {2, 2, 2, 0, 0, 0, 0, 0.0}
        };
    }

    @Test(dataProvider = "velocityData")
    public void testGetVelocity(double x, double y, double z, double time, double vx, double vy, double vz, double expected) {
        Point point = new Point(x, y, z, time, vx, vy, vz, 0, 0, 0);
        double velocity = new PointServiceImpl().getVelocity(point);
        assertEquals(expected, velocity, 0.001);
    }
}