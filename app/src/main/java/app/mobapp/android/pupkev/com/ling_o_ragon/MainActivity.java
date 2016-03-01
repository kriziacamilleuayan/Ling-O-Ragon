package app.mobapp.android.pupkev.com.ling_o_ragon;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class MainActivity extends Activity{

    public static File mainFile;
    //private static Button button_exit;
    private static Button button_trivias;
    private static Button button_settings;
    private static Button button_start;
    private static TextView txt_stars;
    final Context context = this;
    private boolean showMessage = true;
    private static MediaPlayer mp;
    private static ImageView star;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        onButtonClickListener();
        updateStars();
        mp = MediaPlayer.create(this,R.raw.click);


        SharedPreferences sharedPref = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
        String username = sharedPref.getString("username", null);
        if(username == null){
            //first time user - ask for username
            AlertDialog.Builder alert = new AlertDialog.Builder(context);
            alert.setCancelable(false);
            alert.setTitle("Welcome to Ling-O-Ragon"); //Set Alert dialog title here
            alert.setMessage("Enter Your Name Here"); //Message here

            // Set an EditText view to get user input
            final EditText input = new EditText(context);
            alert.setView(input);

            alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int whichButton) {
                    mp.start();
                    //You will get as string input data in this variable
                    String srt = input.getEditableText().toString();
                    SharedPreferences sharedPref = MainActivity.this.getPreferences(Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putString("username", srt);
                    editor.commit();
                } // End of onClick(DialogInterface dialog, int whichButton)
            }); //End of alert.setPositiveButton

            AlertDialog alertDialog = alert.create();
            alertDialog.show();
            showMessage = false;

        } else if (showMessage) {
            showMessage = false;
            //greet
            AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
            a_builder.setMessage("Mabuhay "+ username + "!")
                    .setCancelable(true)
                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            mp.start();
                            dialog.cancel();
                        }
                    });
            AlertDialog alert = a_builder.create();
            alert.show();

        }

    }

    public void updateStars() {
        txt_stars = (TextView) findViewById(R.id.txtStars);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            //the key is "Stars" don't forget to type it as you created the Sp
        String stars = String.valueOf(sharedPreferences.getInt("Stars", 0));
        txt_stars.setText(stars);
    }

    @Override
    public void onBackPressed() {
        mp = MediaPlayer.create(this,R.raw.click);
        mp.start();
        AlertDialog.Builder a_builder = new AlertDialog.Builder(MainActivity.this);
        a_builder.setTitle(R.string.exitLing)
        .setMessage(R.string.exitcontent)
                .setCancelable(true)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mp.start();
                        finish();
                    }

                })
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mp.start();
                        dialog.cancel();
                    }
                });
        AlertDialog alert = a_builder.create();
        alert.show();
    }

    public void onButtonClickListener(){

        button_start = (Button) findViewById(R.id.btnStart);
        button_start.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mp.start();
                        Intent nextForm = new Intent(MainActivity.this, StartActivity.class);
                        startActivity(nextForm);
                        overridePendingTransition(R.anim.leftin, R.anim.pushleftout);
                        finish();
                    }
                }
        );

        button_trivias = (Button) findViewById(R.id.btnTrivias);
        button_trivias.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mp.start();
                        Intent nextForm = new Intent(MainActivity.this, TriviasActivity.class);
                        startActivity(nextForm);
                        overridePendingTransition(R.anim.leftin, R.anim.pushleftout);
                        finish();
                    }
                }
        );

        button_settings = (Button) findViewById(R.id.btnSettings);
        button_settings.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mp.start();
                        Intent nextForm = new Intent(MainActivity.this, SettingActivity.class);
                        startActivity(nextForm);
                        overridePendingTransition(R.anim.leftin, R.anim.pushleftout);
                        finish();
                    }
                }
        );

        star = (ImageView) findViewById(R.id.star);


        Animation a = AnimationUtils.loadAnimation(this, R.anim.one);
        Animation b = AnimationUtils.loadAnimation(this, R.anim.two);
        Animation c = AnimationUtils.loadAnimation(this, R.anim.three);
        button_start.startAnimation(a);
        button_trivias.startAnimation(b);
        button_settings.startAnimation(c);

    }


}
