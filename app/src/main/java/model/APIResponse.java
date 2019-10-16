package model;

public class APIResponse {
    private boolean success;
    private String message;
    private String status;

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }
}
