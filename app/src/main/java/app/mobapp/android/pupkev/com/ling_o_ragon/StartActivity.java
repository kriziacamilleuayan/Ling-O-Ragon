package app.mobapp.android.pupkev.com.ling_o_ragon;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by root on 12/19/15.
 */
public class StartActivity extends Activity {

    private static ImageButton button_levelone;
    private static ImageButton button_leveltwo;
    private static ImageButton button_levelthree;
    private static ImageButton button_leveltwodisable;
    private static ImageButton button_levelthreedisable;
    private static ImageButton button_sundisable;
    private static ImageButton button_sun;
    private static TextView txt_two;
    private static TextView txt_three;
    private static TextView txt_one;
    private static MediaPlayer mp;



    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start);
        onButtonClickListener();

    }

    @Override
    public void onBackPressed() {
        mp = MediaPlayer.create(this,R.raw.click);
        mp.start();
        super.onBackPressed();
        Intent nextform = new Intent(StartActivity.this, MainActivity.class);
        overridePendingTransition(R.anim.pushrightin, R.anim.pushrightout);
        startActivity(nextform);
        finish();
    }

    public void onButtonClickListener(){

        mp = MediaPlayer.create(this,R.raw.click);

        button_levelone = (ImageButton) findViewById(R.id.imgbtnlvlstar1);
        button_leveltwo = (ImageButton) findViewById(R.id.imgbtnstarlvl2);
        button_levelthree = (ImageButton) findViewById(R.id.imgbtnlvlstar3);
        button_leveltwodisable = (ImageButton) findViewById(R.id.imgbtnlvl2disable);
        button_sun = (ImageButton) findViewById(R.id.imgbtnSun);
        button_sundisable = (ImageButton) findViewById(R.id.imgbtnsundisable);
        txt_one = (TextView) findViewById(R.id.txtlvl1);
        txt_two = (TextView) findViewById(R.id.txtlvl2);
        txt_three = (TextView) findViewById(R.id.txtlvl3);

        button_levelone.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                        Integer tutorial = sharedPreferences.getInt("tutorial", 0);
                        if (tutorial == 0){
                            mp.start();
                            Intent nextForm = new Intent(StartActivity.this, TutorialOneActivity.class);
                            startActivity(nextForm);
                            overridePendingTransition(R.anim.leftin, R.anim.pushleftout);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            Integer tut = 1;
                            editor.putInt("tutorial", tut);
                            editor.commit();
                            finish();
                        }

                        else{
                            mp.start();
                            Intent nextForm = new Intent(StartActivity.this, LevelOneActivity.class);
                            startActivity(nextForm);
                            overridePendingTransition(R.anim.leftin, R.anim.pushleftout);
                            finish();

                        }
                    }
                }
        );



        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Integer num = sharedPreferences.getInt("RoundOneThree", 0);


        if (num == 1){
            button_leveltwo.setVisibility(View.VISIBLE);
            button_leveltwo.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent nextForm = new Intent(StartActivity.this, LevelOneActivity.class);
                            startActivity(nextForm);
                            overridePendingTransition(R.anim.leftin, R.anim.pushleftout);
                            finish();
                        }
                    }
            );

        }

        else{
            button_leveltwo.setVisibility(View.GONE);
            button_leveltwodisable.setVisibility(View.VISIBLE);

            button_levelthree.setVisibility(View.GONE);
            button_sun.setVisibility(View.GONE);
            txt_two.setVisibility(View.GONE);
            txt_three.setVisibility(View.GONE);
        }


        Animation a = AnimationUtils.loadAnimation(this, R.anim.rotation);
        Animation b = AnimationUtils.loadAnimation(this, R.anim.rotation);

        button_sun.startAnimation(a);
        button_sundisable.startAnimation(b);

    }


}
