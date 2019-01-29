package com.example.geddi;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class HomeActivity extends AppCompatActivity {
    EditText searh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ViewPager fragment= (ViewPager)findViewById(R.id.viewpager);
        FragmentPager adapter= new FragmentPager(getSupportFragmentManager());
        fragment.setAdapter(adapter);

        /*searh = (EditText) findViewById(R.id.search);
        Button next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str= searh.getText().toString().trim();
                searh.setText("knkj");
            }
        });*/
    }
}
