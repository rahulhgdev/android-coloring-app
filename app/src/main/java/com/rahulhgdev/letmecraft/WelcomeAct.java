package com.rahulhgdev.letmecraft;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WelcomeAct extends AppCompatActivity {

    Button openColoringbtn, openPaintActivity, openAboutAcitivity, openExitActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void openColoring(View view) {

        openColoringbtn = (Button) view.findViewById(R.id.openColoring);
      //  openPaintActivity = (Button) view.findViewById(R.id.openPainting);
        openAboutAcitivity = (Button) view.findViewById(R.id.openAbout);
        openExitActivity = (Button) view.findViewById(R.id.Bye);
        openColoringbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openColoringActivity();
            }
        });
    }

    private void openColoringActivity() {
        Intent newIntent = new Intent(WelcomeAct.this, MainActivity.class);
        startActivity(newIntent);
    }

    public void openAbout(View view) {

        openAboutAcitivity = (Button) view.findViewById(R.id.openAbout);
        openAboutAcitivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAboutAcitivity();
            }
        });

    }

    private void openAboutAcitivity() {
        Intent aboutIntent = new Intent(WelcomeAct.this, AboutDeveloper.class);
        startActivity(aboutIntent);
    }

    public void exit(View view) {
        openExitActivity = (Button) view.findViewById(R.id.Bye);

        openExitActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitActivity();
            }
        });

    }

    private void exitActivity() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("Do you really want to exit ?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       finish();
                    }
                });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                 dialog.dismiss();
            }
        });
        builder.create().show();
    }


}