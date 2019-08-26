package model;

public class LoginSignupResponse { private int userId;
    private boolean success;
    private String message;
    private String status;
    private String token;

    public int getUserId() {
        return userId;
    }

    public boolean getSuccess() {
        return success;
    }

    public String getStatus() {
        return status;
    }

    public String getToken() {
        return token;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
