package by.mashnyuk.pointentity.validator.impl;

import by.mashnyuk.pointentity.entity.Point;
import by.mashnyuk.pointentity.validator.PointValidator;

public class PointValidatorImpl implements PointValidator {

    public static boolean isValid(Point point) {
        PointValidatorImpl validator = new PointValidatorImpl();
        return validator.validate(point);
    }

    @Override
    public boolean validate(Point point) {
        if (point == null) {
            return false;
        }
        return  validateTime(point.getTime()) &&
                validateVelocity(point.getVx(), point.getVy(), point.getVz()) &&
                validateAcceleration(point.getAx(), point.getAy(), point.getAz());
    }

    @Override
    public boolean validateTime(double time) {
        return time >= 0;
    }

    public boolean validateVelocity(double vx, double vy, double vz) {
        return vx >= -100 && vx <= 100 &&
                vy >= -100 && vy <= 100 &&
                vz >= -100 && vz <= 100;
    }

    public boolean validateAcceleration(double ax, double ay, double az) {
        return ax >= -50 && ax <= 50 &&
                ay >= -50 && ay <= 50 &&
                az >= -50 && az <= 50;
    }
}
