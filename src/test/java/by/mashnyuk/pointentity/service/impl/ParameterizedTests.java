package by.mashnyuk.pointentity.service.impl;

import by.mashnyuk.pointentity.creator.PointFactory;
import by.mashnyuk.pointentity.entity.Point;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Optional;

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
        Optional<Point> pointOpt = PointFactory.create3DPoint(x, y, z, time, vx, vy, vz, 0, 0, 0);
        if (pointOpt.isPresent()) {
            double velocity = new PointServiceImpl().getVelocity(pointOpt.get());
            assertEquals(expected, velocity, 0.001);
        } else {
            fail("Point creation failed.");
        }
    }
}