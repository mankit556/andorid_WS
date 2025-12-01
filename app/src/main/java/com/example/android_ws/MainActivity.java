package com.example.android_ws;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        TextView textView = new TextView(this);
        textView.setText("Hello, World!");
        textView.setTextSize(30);

        
        setContentView(textView);
    }
}