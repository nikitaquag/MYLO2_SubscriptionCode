package com.mindyourlovedone.healthcare.HomeActivity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImpAgreementActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imgBack;
    TextView txtSignup;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imp_agreement);
        initUi();
        initListener();
    }

    private void initListener() {
        imgBack.setOnClickListener(this);
        txtSignup.setOnClickListener(this);

    }

    private void initUi() {
        imgBack = findViewById(R.id.imgBack);
        txtSignup = findViewById(R.id.txtSignup);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgBack:
                finish();
                break;

            case R.id.txtSignup:
                Intent intentBase = new Intent(context, BaseNewActivity.class);
                startActivity(intentBase);
                break;
        }
    }
}
