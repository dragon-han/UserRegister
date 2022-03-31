package com.example.userregister;

import static androidx.constraintlayout.motion.utils.Oscillator.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    String city = "";
    Button btn;
    EditText password;
    boolean dispalyFlag = false;
    Button register;
    String sex = "";
    String hobby = "";
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn_pwd);
        register = findViewById(R.id.bt_register);
        register.setOnClickListener(this);
        btn.setOnClickListener(this);

        Spinner spinner = findViewById(R.id.sn_position);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                if (pos == 0) {
                    city = "北京";
                } else if (pos == 1) {
                    city = "上海";
                } else if (pos == 2) {
                    city = "杭州";
                } else if (pos == 3) {
                    city = "深圳";
                } else if (pos == 4) {
                    city = "云南";
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_pwd:
                hideOrDisplayPwd();
                break;
            case R.id.bt_register:
                setRegister();
                break;
            default:
                break;
        }

    }

    public void hideOrDisplayPwd() {
        password = findViewById(R.id.et_password);

        if (!dispalyFlag) {
            password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            password.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        dispalyFlag = !dispalyFlag;
        btn.postInvalidate();
    }

    public void setRegister() {
        intent = new Intent(MainActivity.this, ShowActivity.class);
        EditText username = findViewById(R.id.et_phone);
        password = findViewById(R.id.et_password);
        RadioGroup selection = findViewById(R.id.rg_Selection);
        CheckBox reading = findViewById(R.id.cb_readbook);
        CheckBox music = findViewById(R.id.cb_music);
        CheckBox playball = findViewById(R.id.cb_playball);
        CheckBox running = findViewById(R.id.cb_running);
        for (int i = 0; i < selection.getChildCount(); i++) {
            RadioButton RB = (RadioButton) selection.getChildAt(i);
            if (RB.isChecked()) {
                sex = RB.getText().toString();
                break;
            }
        }
        //hobby字符串的获取
        if (reading.isChecked())
            hobby += reading.getText().toString() + " ";
        if (music.isChecked())
            hobby += music.getText().toString() + " ";
        if (playball.isChecked())
            hobby += playball.getText().toString() + " ";
        if (running.isChecked())
            hobby += running.getText().toString() + " ";
        if (!"".equals(username) && !"".equals(password) && !"".equals(sex) && !"".equals(hobby) && !"".equals(city)) {
            if (username.length() == 11) {
                intent.putExtra("username", username.getText().toString().trim());
                intent.putExtra("password", password.getText().toString().trim());
                intent.putExtra("sex", sex);
                intent.putExtra("hobby", hobby);
                intent.putExtra("city", city);
                Log.e(TAG="han", "setRegister: 已执行");
                startActivity(intent);
            } else
                Toast.makeText(MainActivity.this, "请输入合法的手机号", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "请将信息填写完整", Toast.LENGTH_SHORT).show();

        }

    }
}
