package com.mindyourlovedone.healthcare.Activity;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.mindyourlovedone.healthcare.HomeActivity.R;
/*Created by Shradha 15 Feb 2019*/
public class RelationshipActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView imgBack;
    LinearLayout llAunt, llBrother, llBrotherLaw, llClient, llCousin;
    ImageView imgAunt, imgBrother, imgBrotherLaw, imgClient, imgCousin;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relationship);
        initUi();
        initListener();
    }

    private void initUi() {
        imgBack = findViewById(R.id.imgBack);

        llAunt = findViewById(R.id.llAunt);
        llBrother = findViewById(R.id.llBrother);
        llBrotherLaw = findViewById(R.id.llBrotherLaw);
        llClient = findViewById(R.id.llClient);
        llCousin = findViewById(R.id.llCousin);

        imgAunt = findViewById(R.id.imgAunt);
        imgBrother = findViewById(R.id.imgBrother);
        imgBrotherLaw = findViewById(R.id.imgBrotherLaw);
        imgClient = findViewById(R.id.imgClient);
        imgCousin = findViewById(R.id.imgCousin);
    }

    private void initListener() {
        imgBack.setOnClickListener(this);

        llAunt.setOnClickListener(this);
        llBrother.setOnClickListener(this);
        llBrotherLaw.setOnClickListener(this);
        llClient.setOnClickListener(this);
        llCousin.setOnClickListener(this);

        imgAunt.setOnClickListener(this);
        imgBrother.setOnClickListener(this);
        imgBrotherLaw.setOnClickListener(this);
        imgClient.setOnClickListener(this);
        imgCousin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imgBack:
                finish();
                break;
            case R.id.llAunt:
                if (imgAunt.getVisibility() == View.GONE) {
                    imgAunt.setVisibility(View.VISIBLE);
                    imgBrother.setVisibility(View.GONE);
                    imgBrotherLaw.setVisibility(View.GONE);
                    imgClient.setVisibility(View.GONE);
                    imgCousin.setVisibility(View.GONE);
                }
                break;
            case R.id.llBrother:
                if (imgBrother.getVisibility() == View.GONE) {
                    imgBrother.setVisibility(View.VISIBLE);
                    imgAunt.setVisibility(View.GONE);
                    imgBrotherLaw.setVisibility(View.GONE);
                    imgClient.setVisibility(View.GONE);
                    imgCousin.setVisibility(View.GONE);
                }
                break;
            case R.id.llBrotherLaw:
                if (imgBrotherLaw.getVisibility() == View.GONE) {
                    imgBrotherLaw.setVisibility(View.VISIBLE);
                    imgBrother.setVisibility(View.GONE);
                    imgAunt.setVisibility(View.GONE);
                    imgClient.setVisibility(View.GONE);
                    imgCousin.setVisibility(View.GONE);
                }
                break;
            case R.id.llClient:
                if (imgClient.getVisibility() == View.GONE) {
                    imgClient.setVisibility(View.VISIBLE);
                    imgBrotherLaw.setVisibility(View.GONE);
                    imgBrother.setVisibility(View.GONE);
                    imgAunt.setVisibility(View.GONE);
                    imgCousin.setVisibility(View.GONE);
                }
                break;
            case R.id.llCousin:
                if (imgCousin.getVisibility() == View.GONE) {
                    imgCousin.setVisibility(View.VISIBLE);
                    imgClient.setVisibility(View.GONE);
                    imgBrotherLaw.setVisibility(View.GONE);
                    imgBrother.setVisibility(View.GONE);
                    imgAunt.setVisibility(View.GONE);
                }
                break;
        }
    }
}
