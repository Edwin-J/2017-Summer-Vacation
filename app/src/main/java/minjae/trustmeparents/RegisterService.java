package minjae.trustmeparents;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;

import minjae.trustmeparents.R;
import minjae.trustmeparents.Receivers.LockReceiver;
import minjae.trustmeparents.Receivers.PackageReceiver;

/**
 * Created by Minjae on 2017-08-09.
 */

public class RegisterService extends Service{

    private LockReceiver lockReceiver = null;
    private PackageReceiver packageReceiver = null;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        lockReceiver = new LockReceiver();
        IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_OFF);
        registerReceiver(lockReceiver, filter);

        packageReceiver = new PackageReceiver();
        IntentFilter pFilter = new IntentFilter(Intent.ACTION_PACKAGE_ADDED);
        pFilter.addAction(Intent.ACTION_PACKAGE_REMOVED);
        pFilter.addAction(Intent.ACTION_PACKAGE_REPLACED);
        pFilter.addDataScheme("package");
        registerReceiver(packageReceiver, pFilter);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        Notification notification = new Notification(R.mipmap.ic_launcher_round, "서비스 실행됨", System.currentTimeMillis());
        startForeground(1, notification);

        if ( (intent != null) && (intent.getAction() == null) &&  (lockReceiver == null) ) {
            lockReceiver = new LockReceiver();
            IntentFilter filter = new IntentFilter(Intent.ACTION_SCREEN_OFF);
            registerReceiver(lockReceiver, filter);
        }
        return START_REDELIVER_INTENT;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        if (lockReceiver != null) unregisterReceiver(lockReceiver);
        if (packageReceiver != null) unregisterReceiver(packageReceiver);

        lockReceiver.reenableKeyguard();
    }

}
