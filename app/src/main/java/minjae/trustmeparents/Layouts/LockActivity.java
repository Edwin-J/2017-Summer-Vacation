package minjae.trustmeparents.Layouts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.TextView;
import android.widget.Toast;

import minjae.trustmeparents.R;

import static java.sql.Types.NULL;

public class LockActivity extends AppCompatActivity {

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
    TextView enter;

    TextView input1;
    TextView input2;
    TextView input3;
    TextView input4;

    String input[] = new String[4];
    // 사용자가 입력해주는 값 저장

    String PW = "4587";
    // MainActivity에서 intent로 넘겨준 값 저장

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock);

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED); // 기본 잠금 화면 위에 띄우기
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD); // 기본 잠금 화면 없애기

        Intent pwIntent = getIntent();
        PW = pwIntent.getExtras().getString("password", "0000");
        // MainActivity에서 넘겨준 값 받기

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
        enter = (TextView) findViewById(R.id.ent);

        input1 = (TextView) findViewById(R.id.input1);
        input2 = (TextView) findViewById(R.id.input2);
        input3 = (TextView) findViewById(R.id.input3);
        input4 = (TextView) findViewById(R.id.input4);

        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (input[0] == null) {
                    input[0] = "0";
                    input1.setText("0");
                }
                else if (input[1] == null) {
                    input[1] = "0";
                    input2.setText("0");
                }
                else if (input[2] == null) {
                    input[2] = "0";
                    input3.setText("0");
                }
                else if (input[3] == null) {
                    input[3] = "0";
                    input4.setText("0");
                }
                // 이런 식으로 각 버튼을 누를 때 마다 배열에 빈 공간을 찾아서 해당 숫자 넣음
            }
        });
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (input[0] == null) {
                    input[0] = "1";
                    input1.setText("1");
                }
                else if (input[1] == null) {
                    input[1] = "1";
                    input2.setText("1");
                }
                else if (input[2] == null) {
                    input[2] = "1";
                    input3.setText("1");
                }
                else if (input[3] == null) {
                    input[3] = "1";
                    input4.setText("1");
                }
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (input[0] == null)
                    input[0] = "2";
                else if (input[1] == null)
                    input[1] = "2";
                else if (input[2] == null)
                    input[2] = "2";
                else if (input[3] == null)
                    input[3] = "2";
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (input[0] == null) {
                    input[0] = "3";
                    input1.setText("3");
                }
                else if (input[1] == null) {
                    input[1] = "3";
                    input2.setText("3");
                }
                else if (input[2] == null) {
                    input[2] = "3";
                    input3.setText("3");
                }
                else if (input[3] == null) {
                    input[3] = "3";
                    input4.setText("3");
                }
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (input[0] == null) {
                    input[0] = "4";
                    input1.setText("4");
                }
                else if (input[1] == null) {
                    input[1] = "4";
                    input2.setText("4");
                }
                else if (input[2] == null) {
                    input[2] = "4";
                    input3.setText("4");
                }
                else if (input[3] == null) {
                    input[3] = "4";
                    input4.setText("4");
                }
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (input[0] == null) {
                    input[0] = "5";
                    input1.setText("5");
                }
                else if (input[1] == null) {
                    input[1] = "5";
                    input2.setText("5");
                }
                else if (input[2] == null) {
                    input[2] = "5";
                    input3.setText("5");
                }
                else if (input[3] == null) {
                    input[3] = "5";
                    input4.setText("5");
                }
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (input[0] == null) {
                    input[0] = "6";
                    input1.setText("6");
                }
                else if (input[1] == null) {
                    input[1] = "6";
                    input2.setText("6");
                }
                else if (input[2] == null) {
                    input[2] = "6";
                    input3.setText("6");
                }
                else if (input[3] == null) {
                    input[3] = "6";
                    input4.setText("6");
                }
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (input[0] == null) {
                    input[0] = "7";
                    input1.setText("7");
                }
                else if (input[1] == null) {
                    input[1] = "7";
                    input2.setText("7");
                }
                else if (input[2] == null) {
                    input[2] = "7";
                    input3.setText("7");
                }
                else if (input[3] == null) {
                    input[3] = "7";
                    input4.setText("7");
                }
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (input[0] == null) {
                    input[0] = "8";
                    input1.setText("8");
                }
                else if (input[1] == null) {
                    input[1] = "8";
                    input2.setText("8");
                }
                else if (input[2] == null) {
                    input[2] = "8";
                    input3.setText("8");
                }
                else if (input[3] == null) {
                    input[3] = "8";
                    input4.setText("8");
                }
            }
        });
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (input[0] == null) {
                    input[0] = "9";
                    input1.setText("9");
                }
                else if (input[1] == null) {
                    input[1] = "9";
                    input2.setText("9");
                }
                else if (input[2] == null) {
                    input[2] = "9";
                    input3.setText("9");
                }
                else if (input[3] == null) {
                    input[3] = "9";
                    input4.setText("9");
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (input[0] == null)
                    ;
                else if (input[1] == null)
                    input[0] = null;
                else if (input[2] == null)
                    input[1] = null;
                else if (input[3] == null)
                    input[2] = null;
            }
        });
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String INPUT = "" + input[0] + input[1] + input[2] + input[3];
                // input 배열에 저장된 숫자들을 문자열로 변환

                if ( INPUT.equals(PW) )
                    finish();

                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Wrong password.", Toast.LENGTH_SHORT);
                    toast.show();
                    input[0] = null; input1.setText("");
                    input[1] = null; input2.setText("");
                    input[2] = null; input3.setText("");
                    input[3] = null; input4.setText("");
                    // 틀리면 다 날라감
                }

            }
        });

    }

}
