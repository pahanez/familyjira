package com.pahanez.familytask.auth;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class FamilyTaskAuthenticatorService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        FamilyTaskAuthenticator authenticator = new FamilyTaskAuthenticator(this);
        return authenticator.getIBinder();
    }
}
