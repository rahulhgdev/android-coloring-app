package com.rahulhgdev.letmecraft;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class AboutDeveloper extends AppCompatActivity {

    ImageView imgGitHub, imgInsta, imgTwitter, imgMedian;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_developer);
    }

    public void openGitHub(View view) {
        imgGitHub = (ImageView) view.findViewById(R.id.imgGithub);
        imgGitHub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //followGit();
                goToUrl("https://www.instagram.com/quotes_arena070/");
            }
        });
    }



    public void openInsta(View view) {
        imgInsta = (ImageView) view.findViewById(R.id.imgInsta);
        imgInsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToUrl("https://www.instagram.com/quotes_arena070/");
                //followInsta();
            }
        });
    }
    public void openTwitter(View view) {
        imgTwitter = (ImageView) view.findViewById(R.id.imgTwitter);
        imgTwitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  followTwitter();
                goToUrl("https://twitter.com/rahulhgdev");
            }
        });
    }
    public void openMedian(View view) {
        imgMedian = (ImageView) view.findViewById(R.id.imgMedian);
        imgMedian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  followMedium();
                goToUrl("https://www.instagram.com/quotes_arena070/");

            }
        });
    }
    private void goToUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

}