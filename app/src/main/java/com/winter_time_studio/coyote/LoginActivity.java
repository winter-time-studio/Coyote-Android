package com.winter_time_studio.coyote;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.loginButton)
    void onLoginButtonClicked() {
        // クリック時の処理
        Intent intent = new Intent(getApplication(), MainActivity.class);
        startActivity(intent);
    }
}
