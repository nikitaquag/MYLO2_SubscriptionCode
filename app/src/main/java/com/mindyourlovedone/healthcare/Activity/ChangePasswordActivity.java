package com.mindyourlovedone.healthcare.Activity;

import android.content.Context;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mindyourlovedone.healthcare.HomeActivity.R;

/*Created by Shradha 15 Feb 2019*/
public class ChangePasswordActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imgBack;
    TextInputLayout tilOldPass;
    TextView txtSave, txtOldPass;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        initUi();
        initListener();
    }

    private void initListener() {
        imgBack.setOnClickListener(this);
        txtSave.setOnClickListener(this);
    }

    private void initUi() {
        imgBack = findViewById(R.id.imgBack);
        txtSave = findViewById(R.id.txtSave);
        tilOldPass = findViewById(R.id.tilOldPass);
        txtOldPass = findViewById(R.id.txtOldPass);


        tilOldPass.setHintEnabled(false);
        txtOldPass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                tilOldPass.setHintEnabled(true);
                tilOldPass.setFocusable(true);
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgBack:
                finish();
                break;
            case R.id.txtSave:
                Toast.makeText(context, "In Progress please wait..!!", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
