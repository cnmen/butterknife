package com.cmonbaby.butterknife.library;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cmonbaby.butterknife.annotation.BindView;
import com.cmonbaby.butterknife.annotation.OnClick;
import com.cmonbaby.butterknife.core.ButterKnife;

public class LibraryActivity extends AppCompatActivity {

    @BindView(id = R2.id.tv) // First kind
    TextView tv; // Don't set private or static for properties

    @BindView(id = "iv") // Second kind
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        ButterKnife.bind(this); // just support one id event
    }

    @OnClick(id = R2.id.btn) // just support one id event
    public void click(View view) {
        Toast.makeText(this, "hello simon", Toast.LENGTH_SHORT).show();
    }
}
