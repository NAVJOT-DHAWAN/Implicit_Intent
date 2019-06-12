package com.example.implicit_intent;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText websiteEditext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        websiteEditext = findViewById(R.id.website_edittext)
    }

    public void openWebsite(View view){

        String url = websiteEditext.getText().toString();
        Uri webpage = Uri.parse(url);

    }
}
