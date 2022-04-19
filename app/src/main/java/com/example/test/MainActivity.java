package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Toast.makeText(this, "onCreate方法执行", Toast.LENGTH_SHORT).show();

        // 登录成功
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyApp.isLogin = true;
                test();
            }
        });

        // 登录失败
        findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyApp.isLogin = false;
                test2();
            }
        });
    }

    @CheckLogin
    private void test2() {
        Toast.makeText(this, "登录失败，跳转到登录页面", Toast.LENGTH_SHORT).show();
    }

    @CheckLogin
    private void test() {
        Toast.makeText(this, "登录成功，跳转到首页", Toast.LENGTH_SHORT).show();
    }
}