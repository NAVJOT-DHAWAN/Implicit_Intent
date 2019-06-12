package com.example.implicit_intent;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText websiteEditext;
    private EditText locationEditext;
    private EditText shareEdittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        websiteEditext = findViewById(R.id.website_edittext);
        locationEditext = findViewById(R.id.location_edittext);
        shareEdittext = findViewById(R.id.share_edittext);
    }

    public void openWebsite(View view){

        String url = websiteEditext.getText().toString();
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW,webpage);

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
        else{
            Log.d("Implicit Intents","Can't handle this!!!!");
        }
    }


    public void openLocation(View view) {

        String loc = locationEditext.getText().toString();
        Uri address = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW,address);

        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
        else{
            Log.d("Implicit Intents","Can't handle this!!!!");
        }
    }

    public void shareText(View view) {

        String text = shareEdittext.getText().toString();
        String mimeType = "text/plain";

        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText(text)
                .startChooser();
    }
}
