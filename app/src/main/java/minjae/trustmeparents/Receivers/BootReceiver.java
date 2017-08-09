package minjae.trustmeparents.Receivers;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Minjae on 2017-08-09.
 */

// 시스템 부팅 시 잠금 화면 실행
public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED)) {
            Intent i = new Intent(context, Service.class);
            context.startService(i);
        }

    }

}
