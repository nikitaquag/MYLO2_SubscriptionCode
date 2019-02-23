package com.mindyourlovedone.healthcare.Connections;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.mindyourlovedone.healthcare.HomeActivity.R;

public class PhoneActivity extends AppCompatActivity {
ListView listRelation;
Context context=this;
ImageView imgBack;
    String[] Relationship = {"Mobile", "Home", "Office", "Fax"};
    private static int RESULT_RELATION = 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        initUi();
    }

    private void initUi() {
        listRelation=findViewById(R.id.listRelation);
        imgBack=findViewById(R.id.imgBack);

        RelationsAdapter rd=new RelationsAdapter(context,Relationship);
        listRelation.setAdapter(rd);

        listRelation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView txtRel=view.findViewById(R.id.txtRel);
                Intent i=new Intent();
                i.putExtra("Relation",txtRel.getText().toString());
                setResult(RESULT_RELATION,i);
                finish();
            }
        });

        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
