package minjae.trustmeparents.Receivers;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Minjae on 2017-08-09.
 */

public class PackageReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();

        if (action.equals(Intent.ACTION_PACKAGE_ADDED)) {
            // 앱 설치 시
        }
        else if (action.equals(Intent.ACTION_PACKAGE_REMOVED)) {
            // 앱 삭제 시
        }
        else if (action.equals(Intent.ACTION_PACKAGE_REPLACED)) {
            // 앱 업데이트 시
            Intent i = new Intent(context, Service.class);
            context.startService(i);
        }

    }

}
