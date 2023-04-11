package com.ItsVeGa90.BackendXYZ.exception;

public class exceptionDAO extends Exception {
    public exceptionDAO() {
    }

    public exceptionDAO(String message) {
        super(message);
    }

    public exceptionDAO(String message, Throwable cause) {
        super(message, cause);
    }

    public exceptionDAO(Throwable cause) {
        super(cause);
    }

    public exceptionDAO(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
