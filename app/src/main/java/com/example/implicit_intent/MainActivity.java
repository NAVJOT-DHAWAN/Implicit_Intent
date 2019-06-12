package com.example.implicit_intent;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private EditText websiteEditext;
    private EditText locationEditext;
    private EditText shareEdittext;
    private ImageView i_view;
    private static final int pic_id = 123;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        websiteEditext = findViewById(R.id.website_edittext);
        locationEditext = findViewById(R.id.location_edittext);
        shareEdittext = findViewById(R.id.share_edittext);
        i_view = findViewById(R.id.image);
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


    public void picture(View view) {

        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        startActivityForResult(intent,pic_id);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == pic_id){
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            i_view.setImageBitmap(photo);
        }
    }
}
