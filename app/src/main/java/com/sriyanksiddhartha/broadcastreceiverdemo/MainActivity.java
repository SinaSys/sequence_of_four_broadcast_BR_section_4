package com.sriyanksiddhartha.broadcastreceiverdemo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

/**
 * 		Author: Sriyank Siddhartha
 *
 * 		Module 3: Exploring Ordered BroadcastReceiver
 *
 * 			"AFTER" project
 * */
public class MainActivity extends AppCompatActivity {

	private static final String TAG = MainActivity.class.getSimpleName();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	public void sendBroadcastMessage(View view) {

		Intent intent = new Intent("my.custom.action.name");

		Bundle b = new Bundle();
		b.putString("title", "SmartDeveloper");

		sendOrderedBroadcast(intent, null, new MyFourthReceiver(), null, Activity.RESULT_OK, "Android", b);
	}

	public static class MyThirdReceiverInner extends BroadcastReceiver {

		private static final String TAG = MyThirdReceiverInner.class.getSimpleName();

		@Override
		public void onReceive(Context context, Intent intent) {

			if (isOrderedBroadcast()) {
				int initCode = getResultCode();
				String initData = getResultData();

				Bundle bundle = getResultExtras(true);
				String title = bundle.getString("title");


				Log.i(TAG, "Code: " + initCode + ", Data: " + initData + ", Bundle: " + title);
				Toast.makeText(context, "Hello from 3rd Receiver Inner", Toast.LENGTH_LONG).show();

				setResultCode(17);
				setResultData("iOS");

				bundle.putString("title", "WiseDeveloper");
				setResultExtras(bundle);

				//setResult(17, "iOS", bundle);
			}
		}
	}
}
