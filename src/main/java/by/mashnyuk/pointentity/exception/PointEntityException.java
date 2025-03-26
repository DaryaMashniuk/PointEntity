package by.mashnyuk.pointentity.exception;


public class PointEntityException extends Exception {
    private final ErrorType errorType;

    public PointEntityException(ErrorType errorType) {
        super(errorType.getDefaultMessage());
        this.errorType = errorType;
    }

    public PointEntityException(ErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }

    public PointEntityException(ErrorType errorType, String message, Throwable cause) {
        super(message, cause);
        this.errorType = errorType;
    }

    public ErrorType getErrorType() {
        return errorType;
    }


    public enum ErrorType {
        DIVISION_BY_ZERO("Division by zero is not allowed"),
        FILE_OPERATION("File operation failed"),
        INVALID_POINT_DATA("Invalid point data"),
        PARSING_ERROR("Error while parsing input data"),
        CALCULATION_ERROR("Calculation error");


        private final String defaultMessage;

        ErrorType(String defaultMessage) {
            this.defaultMessage = defaultMessage;
        }

        public String getDefaultMessage() {
            return defaultMessage;
        }
    }
}