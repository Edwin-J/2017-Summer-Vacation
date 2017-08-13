package minjae.trustmeparents.Layouts;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import minjae.trustmeparents.R;
import minjae.trustmeparents.RegisterService;

public class MainActivity extends AppCompatActivity {

    EditText setpw;

    Button on;
    Button off;
    Button save;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    Editable password;
    String PW = "0000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setpw = (EditText) findViewById(R.id.setpw);
        sharedPreferences = getSharedPreferences("password", MODE_PRIVATE);
        PW = sharedPreferences.getString("password", "0000");
        setpw.setText(PW);

        on = (Button) findViewById(R.id.on);
        off = (Button) findViewById(R.id.off);
        save = (Button) findViewById(R.id.save);
        on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(), "Start Service", Toast.LENGTH_SHORT);
                toast.show();
                Intent intent = new Intent(getApplicationContext(), RegisterService.class);
                startService(intent);
            }
        });
        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(), "Stop Service", Toast.LENGTH_SHORT);
                toast.show();
                Intent intent = new Intent(getApplicationContext(), RegisterService.class);
                stopService(intent);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                password = setpw.getText();
                PW = password.toString(); // 사용자의 비밀번호 저장
                editor = sharedPreferences.edit();
                editor.putString("password", PW);
                editor.commit(); // SharedPreferences에 비밀번호 저장.

                Intent intent = new Intent();
                intent.putExtra("password", PW); // intent에 값 저장
                Toast toast = Toast.makeText(getApplicationContext(), "Saved your password : " + PW, Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }
}