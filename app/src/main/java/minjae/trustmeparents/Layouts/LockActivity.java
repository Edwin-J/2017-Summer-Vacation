package minjae.trustmeparents.Layouts;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import minjae.trustmeparents.R;

public class LockActivity extends AppCompatActivity implements View.OnClickListener{

    TextView hint;
    TextView result;

    TextView btn_0;
    TextView btn_1;
    TextView btn_2;
    TextView btn_3;
    TextView btn_4;
    TextView btn_5;
    TextView btn_6;
    TextView btn_7;
    TextView btn_8;
    TextView btn_9;

    TextView clear;

    int a;
    int b;
    int answer;
    int input[] = new int[4];
    int check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED); // 기본 잠금 화면 위에 띄우기
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD); // 기본 잠금 화면 없애기

        hint = (TextView) findViewById(R.id.hint);
        result = (TextView) findViewById(R.id.input);
        btn_0 = (TextView) findViewById(R.id.zero);
        btn_1 = (TextView) findViewById(R.id.one);
        btn_2 = (TextView) findViewById(R.id.two);
        btn_3 = (TextView) findViewById(R.id.three);
        btn_4 = (TextView) findViewById(R.id.four);
        btn_5 = (TextView) findViewById(R.id.five);
        btn_6 = (TextView) findViewById(R.id.six);
        btn_7 = (TextView) findViewById(R.id.seven);
        btn_8 = (TextView) findViewById(R.id.eight);
        btn_9 = (TextView) findViewById(R.id.nine);
        clear = (TextView) findViewById(R.id.clear);

        a = (int) (Math.random() * 9999);
        b = (int) (Math.random() * a);
        hint.setText(a + "-" + b);
        answer = a - b;

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        clear.setOnClickListener(this);

    }

    public void onClick(View v) {

        for (int i = 0; i < 4; i ++) {

            switch (v.getId()) {

                case R.id.clear:
                    i -= 1;
                    break;

                case R.id.zero:
                    input[i] = 0;
                    break;
                case R.id.one:
                    input[i] = 1;
                    break;
                case R.id.two:
                    input[i] = 2;
                    break;
                case R.id.three:
                    input[i] = 3;
                    break;
                case R.id.four:
                    input[i] = 4;
                    break;
                case R.id.five:
                    input[i] = 5;
                    break;
                case R.id.six:
                    input[i] = 6;
                    break;
                case R.id.seven:
                    input[i] = 7;
                    break;
                case R.id.eight:
                    input[i] = 8;
                    break;
                case R.id.nine:
                    input[i] = 9;
                    break;
            }

        }

        check = (input[0] * 1000) + (input[1] * 100) + (input[2] * 10) + (input[3] * 1);
        result.setText(check);

        if (check == answer)
            finish();
        else {
            Toast toast = Toast.makeText(getApplicationContext(), "Wrong password", Toast.LENGTH_LONG);
            toast.show();
        }

    }

}
