package com.mindyourlovedone.healthcare.DashBoard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.mindyourlovedone.healthcare.HomeActivity.R;


public class ZoomActivity extends AppCompatActivity {
    ImageView imgZoom, bt_zoom_dialogclose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_zoom);

        imgZoom = findViewById(R.id.img_zoom);
        bt_zoom_dialogclose = findViewById(R.id.bt_zoom_dialogclose);
        bt_zoom_dialogclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
