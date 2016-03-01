package app.mobapp.android.pupkev.com.ling_o_ragon;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * Created by A C E R on 1/4/2016.
 */
public class OneFifteenActivity extends Activity{

    //MainActivity main;

    private static Button button_next;
    private static TextView txt_ans;
    final Context context = this;
    private static ProgressBar pbar;
    private static MediaPlayer mp;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_fifteen);
        onButtonClickListener();

        pbar = (ProgressBar) findViewById(R.id.progressBar);
        pbar.setMax(15);
        pbar.setProgress(15);
    }


    @Override
    public void onBackPressed() {
        mp = MediaPlayer.create(this,R.raw.click);
        mp.start();
        AlertDialog.Builder a_builder = new AlertDialog.Builder(OneFifteenActivity.this);
        a_builder.setTitle("Continue?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mp.start();
                        dialog.cancel();
                    }

                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mp.start();
                        Intent nextform = new Intent(OneFifteenActivity.this, LevelOneActivity.class);
                        startActivity(nextform);
                        overridePendingTransition(R.anim.pushrightin, R.anim.pushrightout);
                        finish();
                    }
                });
        AlertDialog alert = a_builder.create();
        alert.show();
    }

    public void onButtonClickListener(){
        mp = MediaPlayer.create(this,R.raw.click);
        txt_ans = (EditText) findViewById(R.id.edittxtAns);
        button_next = (Button) findViewById(R.id.btnNext);
        button_next.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mp.start();
                        if (txt_ans.getText().toString().toLowerCase().equals("dai")){
                            SharedPreferences sharedP = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                            SharedPreferences.Editor editor = sharedP.edit();
                            Integer score = sharedP.getInt("ScoreOne",0);
                            Integer totalScore = score + 1;
                            editor.putInt("ScoreOne", totalScore);
                            editor.commit();

                            if (totalScore == 15){

                                Integer round = sharedP.getInt("RoundOneOne", 0);

                                Toast.makeText(OneFifteenActivity.this, "Your Score is: " + totalScore, Toast.LENGTH_LONG).show();

                                if (round == 0){

                                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                    SharedPreferences.Editor editors = sharedPreferences.edit();
                                    Integer newstars = sharedPreferences.getInt("Stars", 0);
                                    Integer totalRounds = 1;
                                    Integer totalStars = newstars + 50;
                                    editors.putInt("RoundOneOne", totalRounds);
                                    editors.putInt("Stars", totalStars);
                                    editors.commit();

                                    AlertDialog.Builder alert = new AlertDialog.Builder(context);
                                    alert.setTitle("Congratulations!");
                                    alert.setMessage("You have earned 50 stars");
                                    alert.setCancelable(false);
                                    alert.setPositiveButton("next", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int whichButton) {
                                            mp.start();
                                            Intent nextForm = new Intent(OneFifteenActivity.this, MainActivity.class);
                                            startActivity(nextForm);
                                            overridePendingTransition(R.anim.leftin, R.anim.pushleftout);
                                            finish();
                                        } // End of onClick(DialogInterface dialog, int whichButton)
                                    }); //End of alert.setPositiveButton
                                    AlertDialog alertDialog = alert.create();
                                    alertDialog.show();
                                }


                                else{


                                    AlertDialog.Builder alert = new AlertDialog.Builder(context);
                                    alert.setTitle("Congratulations!");
                                    alert.setCancelable(false);
                                    alert.setPositiveButton("next", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int whichButton) {
                                            mp.start();
                                            Intent nextForm = new Intent(OneFifteenActivity.this, MainActivity.class);
                                            startActivity(nextForm);
                                            overridePendingTransition(R.anim.leftin, R.anim.pushleftout);
                                            finish();
                                        } // End of onClick(DialogInterface dialog, int whichButton)
                                    }); //End of alert.setPositiveButton
                                    AlertDialog alertDialog = alert.create();
                                    alertDialog.show();
                                }
                            }

                            else{

                                Toast.makeText(OneFifteenActivity.this, "Your Score is :" + totalScore, Toast.LENGTH_LONG).show();

                                AlertDialog.Builder alert = new AlertDialog.Builder(context);
                                alert.setTitle("Oooppss. You didn't answer all correctly");
                                alert.setMessage("Restart Game?");
                                alert.setCancelable(false);
                                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        mp.start();
                                        Intent nextForm = new Intent(OneFifteenActivity.this, OneOneActivity.class);
                                        startActivity(nextForm);
                                        overridePendingTransition(R.anim.leftin, R.anim.pushleftout);
                                        finish();
                                    } // End of onClick(DialogInterface dialog, int whichButton)
                                }); //End of alert.setPositiveButton
                                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        mp.start();
                                        Intent nextForm = new Intent(OneFifteenActivity.this, MainActivity.class);
                                        startActivity(nextForm);
                                        overridePendingTransition(R.anim.leftin, R.anim.pushleftout);
                                        finish();
                                    } // End of onClick(DialogInterface dialog, int whichButton)
                                }); //End of alert.setNegativeButton
                                AlertDialog alertDialog = alert.create();
                                alertDialog.show();
                            }


                        }
                        else{
                            AlertDialog.Builder alert = new AlertDialog.Builder(context);
                            alert.setMessage("The correct translation is 'Dai'"); //Message here
                            alert.setCancelable(false);
                            alert.setPositiveButton("next", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    mp.start();

                                    SharedPreferences sharedP = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                    Integer totalScore = sharedP.getInt("ScoreOne",0);
                                    Toast.makeText(OneFifteenActivity.this, "You're Score is:" + totalScore, Toast.LENGTH_LONG).show();

                                    AlertDialog.Builder alert = new AlertDialog.Builder(context);
                                    alert.setTitle("Oooppss. You didn't answer all correctly");
                                    alert.setMessage("Restart Game?");
                                    alert.setCancelable(false);
                                    alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int whichButton) {
                                            mp.start();
                                            Intent nextForm = new Intent(OneFifteenActivity.this, OneOneActivity.class);
                                            startActivity(nextForm);
                                            overridePendingTransition(R.anim.leftin, R.anim.pushleftout);
                                            finish();
                                        } // End of onClick(DialogInterface dialog, int whichButton)
                                    }); //End of alert.setPositiveButton
                                    alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int whichButton) {
                                            mp.start();
                                            Intent nextForm = new Intent(OneFifteenActivity.this, MainActivity.class);
                                            startActivity(nextForm);
                                            overridePendingTransition(R.anim.leftin, R.anim.pushleftout);
                                            finish();
                                        } // End of onClick(DialogInterface dialog, int whichButton)
                                    }); //End of alert.setNegativeButton
                                    AlertDialog alertDialog = alert.create();
                                    alertDialog.show();
                                } // End of onClick(DialogInterface dialog, int whichButton)
                            }); //End of alert.setPositiveButton
                            AlertDialog alertDialog = alert.create();
                            alertDialog.show();
                        }
                    }
                }
        );


    }

}
