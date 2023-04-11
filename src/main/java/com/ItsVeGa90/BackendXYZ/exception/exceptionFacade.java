package com.ItsVeGa90.BackendXYZ.exception;

public class exceptionFacade extends Exception {
    public exceptionFacade() {
    }

    public exceptionFacade(String message) {
        super(message);
    }

    public exceptionFacade(String message, Throwable cause) {
        super(message, cause);
    }

    public exceptionFacade(Throwable cause) {
        super(cause);
    }

    public exceptionFacade(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
