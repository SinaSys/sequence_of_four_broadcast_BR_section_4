package com.sriyanksiddhartha.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MySecondReceiver extends BroadcastReceiver {

    private static final String TAG = MySecondReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {

        if (isOrderedBroadcast()) {


            int initCode = getResultCode();
            String initData = getResultData();

            Bundle bundle = getResultExtras(true);
            String title = bundle.getString("title");

            Log.i(TAG, "Code: " + initCode + ", Data: " + initData + ", Bundle: " + title);
            Toast.makeText(context, "Hello from 2nd Receiver", Toast.LENGTH_LONG).show();

            setResultCode(47);
            setResultData("Blackberry");

            bundle.putString("title", "CleverDeveloper");
            setResultExtras(bundle);

            // Or Use setResult(47, "Blackberry", bundle);

            
        }
    }
}
