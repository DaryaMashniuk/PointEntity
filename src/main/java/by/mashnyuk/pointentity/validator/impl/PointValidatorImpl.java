package by.mashnyuk.pointentity.validator.impl;

import by.mashnyuk.pointentity.entity.Point;
import by.mashnyuk.pointentity.validator.PointValidator;

public class PointValidatorImpl implements PointValidator {

    private static final double MIN_VELOCITY = -100;
    private static final double MAX_VELOCITY = 100;
    private static final double MIN_ACCELERATION = -50;
    private static final double MAX_ACCELERATION = 50;
    private static final double MIN_TIME = 0;

    public static boolean isValid(Point point) {
        PointValidatorImpl validator = new PointValidatorImpl();
        return validator.validate(point);
    }

    @Override
    public boolean validate(Point point) {
        if (point == null) {
            return false;
        }
        return validateTime(point.getTime()) &&
                validateVelocity(point.getVelocityX(), point.getVelocityY(), point.getVelocityZ()) &&
                validateAcceleration(point.getAccelerationX(), point.getAccelerationY(), point.getAccelerationZ());
    }

    @Override
    public boolean validateTime(double time) {
        return time >= MIN_TIME;
    }

    public boolean validateVelocity(double vx, double vy, double vz) {
        return vx >= MIN_VELOCITY && vx <= MAX_VELOCITY &&
                vy >= MIN_VELOCITY && vy <= MAX_VELOCITY &&
                vz >= MIN_VELOCITY && vz <= MAX_VELOCITY;
    }

    public boolean validateAcceleration(double ax, double ay, double az) {
        return ax >= MIN_ACCELERATION && ax <= MAX_ACCELERATION &&
                ay >= MIN_ACCELERATION && ay <= MAX_ACCELERATION &&
                az >= MIN_ACCELERATION && az <= MAX_ACCELERATION;
    }
}