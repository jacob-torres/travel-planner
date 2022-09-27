package com.app.welcome;

public class WelcomeBean {
    
    private String message;

    public WelcomeBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
