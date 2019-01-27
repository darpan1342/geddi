package com.example.geddi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {
    EditText searh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searh = (EditText) findViewById(R.id.search);
        Button next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str= searh.getText().toString().trim();
                searh.setText("knkj");
            }
        });
    }
}
