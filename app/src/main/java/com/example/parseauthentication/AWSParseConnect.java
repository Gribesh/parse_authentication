package com.example.parseauthentication;

import android.app.Application;
import com.parse.Parse;
import com.parse.ParseACL;

public class AWSParseConnect extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);
        Parse.initialize(new Parse.Configuration.Builder(getApplicationContext())
                .applicationId("myappID")
                .clientKey("S2AQMuUdBb82")
                .server("http://13.233.92.60/parse/")
                .build()
        );
        ParseACL defaultACL = new ParseACL();
        defaultACL.setPublicReadAccess(true);
        defaultACL.setPublicWriteAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    }
}