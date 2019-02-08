package com.mindyourlovedone.healthcare.Activity;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.mindyourlovedone.healthcare.HomeActivity.R;

public class TransparentActivity extends AppCompatActivity implements View.OnClickListener {
    FloatingActionButton floatCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transparent);
        initUi();
        initListener();
    }

    private void initListener() {
        floatCancel.setOnClickListener(this);
    }

    private void initUi() {
        floatCancel = findViewById(R.id.floatCancel);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.floatCancel:
                finish();
                break;
        }
    }
}
