package org.telesoftas;

public class Result {
    public static Result OK = new Result(true);
    public static Result ERROR = new Result(false);
    private final boolean valid;
    private String message;

    public Result(boolean valid) {
        this.valid = valid;
    }

    public boolean isValid() {
        return valid;
    }

    public String getMessage() {
        return message;
    }

    public Result setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        if (isValid()) return "OK";
        return "ERROR";
    }
}
