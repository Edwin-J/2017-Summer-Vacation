package minjae.trustmeparents;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

/**
 * Created by Minjae on 2017-08-09.
 */

public class RegisterService extends Service{

    private Receiver receiver = null;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        receiver = new Receiver();
        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_OFF);
        registerReceiver(receiver, filter);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        if ( (intent != null) && (intent.getAction() == null) &&  (receiver == null) ) {
            receiver = new Receiver();
            IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_OFF);
            registerReceiver(receiver, filter);
        }
        return START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if(receiver != null) unregisterReceiver(receiver);

        receiver.reenableKeyguard();
    }

}
