package com.ItsVeGa90.BackendXYZ.exception;

public class exceptionManager extends Exception {
    public exceptionManager() {
    }

    public exceptionManager(String message) {
        super(message);
    }

    public exceptionManager(String message, Throwable cause) {
        super(message, cause);
    }

    public exceptionManager(Throwable cause) {
        super(cause);
    }

    public exceptionManager(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
