package com.mindyourlovedone.healthcare.Activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

import com.mindyourlovedone.healthcare.DashBoard.CarePlanListActivity;
import com.mindyourlovedone.healthcare.HomeActivity.BaseActivity;
import com.mindyourlovedone.healthcare.HomeActivity.R;

public class PrivacyActivity extends AppCompatActivity implements View.OnClickListener {
    Context context = this;
    ImageView imgBack;
    WebView webPrivacy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy);


        Intent intent = getIntent();
        if (intent.getExtras() != null) {
            String privacy = intent.getExtras().getString("Privacy");
            if (privacy.equals("PRIVACY")) {
                webPrivacy = findViewById(R.id.webPrivacy);
                String privacyPdf = "http://mindyour-lovedones.com/MYLO/DocumentFolder/Privacy_Policy.pdf";
                webPrivacy.loadUrl(privacyPdf);
                /*"http://drive.google.com/viewerng/viewer?embedded=true&url=" + */
            } else {
                Toast.makeText(context, "Something went wrong dude..!!", Toast.LENGTH_SHORT).show();
            }
        }

        initUi();
        initListener();
    }

    private void initListener() {
        imgBack.setOnClickListener(this);
    }

    private void initUi() {
        imgBack = findViewById(R.id.imgBack);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgBack:
                finish();
                break;
        }
    }
}
