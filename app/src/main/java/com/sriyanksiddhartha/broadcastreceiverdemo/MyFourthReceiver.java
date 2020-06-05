package com.sriyanksiddhartha.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MyFourthReceiver extends BroadcastReceiver {

    private static final String TAG = MyFourthReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {

        if (isOrderedBroadcast()) {
            int initCode = getResultCode();
            String initData = getResultData();

            Bundle bundle = getResultExtras(true);
            String title = bundle.getString("title");

            Log.i(TAG, "Result Receiver : Final Code: " + initCode + ", Final Data: " + initData + ", Final Bundle: " + title);
            Toast.makeText(context, "Hello from 4th Receiver", Toast.LENGTH_LONG).show();
        }
    }
}
