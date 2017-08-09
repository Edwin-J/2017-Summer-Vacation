package minjae.trustmeparents;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class LockActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED); // 기본 잠금 화면 위에 띄우기
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD); // 기본 잠금 화면 없애기

    }
}
