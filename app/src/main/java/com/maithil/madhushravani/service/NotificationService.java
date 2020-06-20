package com.maithil.madhushravani.service;

import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;

public class NotificationService extends FirebaseMessagingService {
    private static final String TAG = "NotificationService";
    @Override
    public void onNewToken(String token) {
        Log.d(TAG, "Refreshed token: " + token);

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        // sendRegistrationToServer(token);
    }
}
