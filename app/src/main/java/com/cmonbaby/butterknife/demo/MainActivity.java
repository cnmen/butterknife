package com.cmonbaby.butterknife.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.cmonbaby.butterknife.annotation.BindView;
import com.cmonbaby.butterknife.annotation.OnClick;
import com.cmonbaby.butterknife.core.ButterKnife;
import com.cmonbaby.butterknife.library.LibraryActivity;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tv)
    TextView tv; // Don't set private or static for properties

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this); // just support activity current
    }

    @OnClick(R.id.btn) // just support one id event
    public void click(View view) {
        startActivity(new Intent(this, LibraryActivity.class));
    }
}
