package com.ItsVeGa90.BackendXYZ.exception;

public class exceptionController extends Exception {
    public exceptionController() {
    }

    public exceptionController(String message) {
        super(message);
    }

    public exceptionController(String message, Throwable cause) {
        super(message, cause);
    }

    public exceptionController(Throwable cause) {
        super(cause);
    }

    public exceptionController(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
