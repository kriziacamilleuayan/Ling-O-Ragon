package app.mobapp.android.pupkev.com.ling_o_ragon;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Locale;

/**
 * Created by root on 12/19/15.
 */

public class SettingActivity extends Activity{

    Locale myLocale;

    private static Button button_language;
    private static Button button_about;
    private static Button button_feed;
    private static Button button_tutorial;
    private static MediaPlayer mp;

    public void onButtonClickListener(){

        mp = MediaPlayer.create(this,R.raw.click);

        button_about = (Button) findViewById(R.id.btnAbout);
        button_about.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mp.start();
                        Intent nextForm = new Intent(SettingActivity.this, AboutActivity.class);
                        startActivity(nextForm);
                        overridePendingTransition(R.anim.leftin, R.anim.pushleftout);
                        finish();
                    }
                }
        );


        button_language = (Button) findViewById(R.id.btnLanguage);
        button_language.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mp.start();
                        AlertDialog.Builder a_builder = new AlertDialog.Builder(SettingActivity.this);
                        a_builder.setTitle(R.string.selectLang)
                                //.setMessage("")
                                .setCancelable(true)
                                .setPositiveButton("Filipino", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mp.start();
                                        Toast.makeText(SettingActivity.this,
                                                R.string.selectedFil, Toast.LENGTH_SHORT)
                                                .show();
                                        setLocale("tl");
                                        Intent refresh = new Intent("app.mobapp.android.pupkev.com.ling_o_ragon.MainActivity");
                                        startActivity(refresh);
                                        overridePendingTransition(R.anim.pushrightin, R.anim.pushrightout);
                                        finish();

                                    }

                                })
                                .setNegativeButton("English", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        mp.start();
                                        Toast.makeText(SettingActivity.this,
                                                R.string.selectedEng, Toast.LENGTH_SHORT)
                                                .show();
                                        setLocale("en");
                                        Intent refresh = new Intent("app.mobapp.android.pupkev.com.ling_o_ragon.MainActivity");
                                        startActivity(refresh);
                                        overridePendingTransition(R.anim.pushrightin, R.anim.pushrightout);
                                        finish();

                                    }
                                });
                        AlertDialog alert = a_builder.create();
                        alert.show();
                    }
                }
        );



        button_feed = (Button) findViewById(R.id.btnFeedbackAndSuggestions);
        button_feed.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mp.start();
                        Intent nextForm = new Intent(SettingActivity.this, FeedbackActivity.class);
                        startActivity(nextForm);
                        overridePendingTransition(R.anim.leftin, R.anim.pushleftout);
                        finish();
                    }
                }
        );


        button_tutorial = (Button) findViewById(R.id.btnTutorial);
        button_tutorial.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mp.start();
                        Intent nextForm = new Intent(SettingActivity.this, TutorialOneActivity.class);
                        startActivity(nextForm);
                        overridePendingTransition(R.anim.leftin, R.anim.pushleftout);
                        finish();
                    }
                }
        );


        Animation a = AnimationUtils.loadAnimation(this, R.anim.one);
        Animation b = AnimationUtils.loadAnimation(this, R.anim.two);
        Animation c = AnimationUtils.loadAnimation(this, R.anim.three);
        Animation d = AnimationUtils.loadAnimation(this, R.anim.four);
        button_language.startAnimation(a);
        button_about.startAnimation(b);
        button_feed.startAnimation(c);
        button_tutorial.startAnimation(d);

    }

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        onButtonClickListener();

    }


    @Override
    public void onBackPressed() {
        mp = MediaPlayer.create(this,R.raw.click);
        mp.start();
        super.onBackPressed();
        Intent nextform = new Intent(SettingActivity.this, MainActivity.class);
        overridePendingTransition(R.anim.pushrightin, R.anim.pushrightout);
        startActivity(nextform);
        finish();
    }


    public void setLocale(String lang) {

        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);

    }
}
