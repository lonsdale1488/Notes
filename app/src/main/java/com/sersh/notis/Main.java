package com.sersh.notis;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends AppCompatActivity implements View.OnClickListener {

    Button btm1,btm2,btm3,btm4;
    String chage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btm1 = (Button) findViewById(R.id.btn1);

        btm1.setOnClickListener(this);
        btm2.setOnClickListener(this);
        btm3.setOnClickListener(this);
        btm4.setOnClickListener(this);
    }
    public void onClick(View v)
    { Intent intent = new Intent(this, Registarion.class);
        startActivity(intent);
        switch (v.getId())
    {
        case R.id.btn1:
            chage = findViewById(R.id.btn1).toString();
            break;
    }

    }
}
