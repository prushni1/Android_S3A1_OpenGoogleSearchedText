package com.connect.s3a1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText ed_search;
    Button btn_search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_search=(EditText)findViewById(R.id.ed_search);
        btn_search=(Button)findViewById(R.id.btn_search);

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String searchtext=ed_search.getText().toString();

                if(TextUtils.isEmpty(searchtext))
                {
                    Toast.makeText(MainActivity.this,"Please Enter Some Text",Toast.LENGTH_SHORT).show();
                }
                else
                {

                    String searchdatavalue=ed_search.getText().toString();

                    SharedPreferences pref = getApplicationContext().getSharedPreferences("SEARCHDATA", MODE_PRIVATE);
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putString("ed_searchdata", searchdatavalue);

                    editor.commit();


                    Intent i=new Intent(MainActivity.this,OpenGooglePage.class);
                    startActivity(i);
                }
            }
        });
    }
}
