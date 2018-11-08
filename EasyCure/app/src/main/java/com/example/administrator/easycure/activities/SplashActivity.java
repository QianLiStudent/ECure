package com.example.administrator.easycure.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.Window;

import com.example.administrator.easycure.R;
import com.example.administrator.easycure.utils.BaseActivity;

/**
 * Created by Administrator on 2018/11/4 0004.
 */

public class SplashActivity extends BaseActivity {

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            startActivity(new Intent(SplashActivity.this,LoginActivity.class));
            finish();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handler.sendEmptyMessageDelayed(0,3000);

    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }
}
