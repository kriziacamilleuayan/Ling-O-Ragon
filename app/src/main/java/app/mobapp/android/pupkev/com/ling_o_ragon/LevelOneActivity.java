package app.mobapp.android.pupkev.com.ling_o_ragon;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
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

/**
 * Created by A C E R on 12/30/2015.
 */
public class LevelOneActivity extends Activity {

    private static Button button_greet;
    private static Button button_numbers;
    private static Button button_date;
    final Context context = this;
    private static MediaPlayer mp;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.levelone);
        onButtonClickListener();

    }

    @Override
    public void onBackPressed() {
        mp = MediaPlayer.create(this,R.raw.click);
        mp.start();
        super.onBackPressed();
        Intent nextform = new Intent(LevelOneActivity.this, StartActivity.class);
        overridePendingTransition(R.anim.pushrightin, R.anim.pushrightout);
        startActivity(nextform);
        finish();
    }


    public void onButtonClickListener(){
        mp = MediaPlayer.create(this,R.raw.click);
        button_greet = (Button) findViewById(R.id.btnGreetings);



        button_greet.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mp.start();
                        AlertDialog.Builder alert = new AlertDialog.Builder(context);
                        alert.setTitle(R.string.greetingsStage);
                        alert.setMessage(R.string.gcontent);
                        alert.setCancelable(false);
                        alert.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mp.start();
                                dialog.cancel();
                            }
                        });
                        alert.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                mp.start();
                                Intent nextForm = new Intent(LevelOneActivity.this, OneOneActivity.class);
                                startActivity(nextForm);
                                overridePendingTransition(R.anim.leftin, R.anim.pushleftout);
                                finish();
                            }
                        });
                        AlertDialog alertDialog = alert.create();
                        alertDialog.show();
                    }
                }
        );



        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Integer num = sharedPreferences.getInt("RoundOneOne", 0);
        Integer numnum = sharedPreferences.getInt("RoundOneTwo", 0);
        button_numbers = (Button) findViewById(R.id.btnNumbers);


        if (num == 1){

            button_numbers.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mp.start();
                            AlertDialog.Builder alert = new AlertDialog.Builder(context);
                            alert.setTitle(R.string.numbersStage);
                            alert.setMessage(R.string.gcontent);
                            alert.setCancelable(false);
                            alert.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    mp.start();
                                    dialog.cancel();
                                }
                            });
                            alert.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    mp.start();
                                    Intent nextForm = new Intent(LevelOneActivity.this, TwoOneActivity.class);
                                    startActivity(nextForm);
                                    overridePendingTransition(R.anim.leftin, R.anim.pushleftout);
                                    finish();
                                }
                            });
                            AlertDialog alertDialog = alert.create();
                            alertDialog.show();
                        }
                    }
            );

        }

        else{
            button_numbers.setEnabled(false);
        }

        button_date = (Button) findViewById(R.id.btnTime);

        if (numnum == 1){

            button_date.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mp.start();
                            AlertDialog.Builder alert = new AlertDialog.Builder(context);
                            alert.setTitle(R.string.dateStage);
                            alert.setMessage(R.string.gcontent);
                            alert.setCancelable(false);
                            alert.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    mp.start();
                                    dialog.cancel();
                                }
                            });
                            alert.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    mp.start();
                                    Intent nextForm = new Intent(LevelOneActivity.this, ThreeOneActivity.class);
                                    startActivity(nextForm);
                                    overridePendingTransition(R.anim.leftin, R.anim.pushleftout);
                                    finish();
                                }
                            });
                            AlertDialog alertDialog = alert.create();
                            alertDialog.show();
                        }
                    }
            );

        }

        else{
            button_date.setEnabled(false);
        }



        Animation a = AnimationUtils.loadAnimation(this, R.anim.one);
        Animation b = AnimationUtils.loadAnimation(this, R.anim.two);
        Animation c = AnimationUtils.loadAnimation(this, R.anim.three);
        button_greet.startAnimation(a);
        button_numbers.startAnimation(b);
        button_date.startAnimation(c);

    }

}
