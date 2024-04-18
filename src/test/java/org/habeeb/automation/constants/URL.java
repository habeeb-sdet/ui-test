package org.habeeb.automation.constants;

public enum URL {

    HEROKU_APP_FORMY_PROJECT("https://formy-project.herokuapp.com/"),
    SAUCE_LAB_DEMO_APP("https://www.saucedemo.com/");

    private final String url;

    URL(String url){
        this.url = url;
    }

    public String getUrl(){
        return this.url;
    }
}
