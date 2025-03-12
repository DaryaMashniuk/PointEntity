package by.mashnyuk.pointentity.validator;

import by.mashnyuk.pointentity.entity.Point;

public interface PointValidator {
    boolean validate(Point point);
    boolean validateTime(double time);

}
