package minjae.trustmeparents;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

/**
 * Created by Minjae on 2017-08-09.
 */

public class Receiver extends BroadcastReceiver {

    private KeyguardManager manager = null;
    private KeyguardManager.KeyguardLock lock = null;
    private TelephonyManager telephonyManager = null;
    private boolean isPhoneCalling = true;

    @Override
    public void onReceive(Context context, Intent intent) {

        if ((intent.getAction()).equals(Intent.ACTION_SCREEN_OFF)) {

            if (manager == null)
                manager = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);

            if (lock == null) lock = manager.newKeyguardLock(Context.KEYGUARD_SERVICE);

            if (telephonyManager == null) {
                telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                telephonyManager.listen(phoneListener, PhoneStateListener.LISTEN_CALL_STATE);
            }

            if (isPhoneCalling) {
                disableKeyguard();

                Intent i = new Intent(context, LockActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            } // 화면이 꺼지면 잠금화면 실행

        }

    }

    public void reenableKeyguard() {
        lock.reenableKeyguard();
    }

    public void disableKeyguard() {
        lock.disableKeyguard();
    }

    private PhoneStateListener phoneListener = new PhoneStateListener() {

        @Override
        public void onCallStateChanged(int state, String incomingNumber) {

            switch (state) {
                case TelephonyManager.CALL_STATE_IDLE : isPhoneCalling = true;
                    break;
                case TelephonyManager.CALL_STATE_RINGING : isPhoneCalling = false;
                    break;
                case TelephonyManager.CALL_STATE_OFFHOOK : isPhoneCalling = false;
                    break;
            }

        }

    };

}
