package com.zyj.plaything.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.zyj.plaything.R;
import com.zyj.plaything.ui.boxoffice.BoxOfficeActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnBoxOffice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnBoxOffice = (Button) findViewById(R.id.main_btn_box_office);

        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbar);
        toolBar.setTitle(getString(R.string.app_name));
        toolBar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolBar);

        btnBoxOffice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_btn_box_office:
                Intent intent = new Intent(this, BoxOfficeActivity.class);
                startActivity(intent);
                break;
        }
    }
}
