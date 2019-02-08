package com.mindyourlovedone.healthcare.HomeActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class BaseNewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_new);
    }
}
