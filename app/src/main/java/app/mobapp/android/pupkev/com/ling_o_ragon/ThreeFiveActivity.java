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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by A C E R on 12/30/2015.
 */
public class ThreeFiveActivity extends Activity {

    //private static ImageButton button_next;
    private static Button button_umaga;
    private static Button button_mamaya;
    private static Button button_kagabi;
    final Context context = this;
    private static ProgressBar pbar;
    private static MediaPlayer mp;


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three_five);
        onButtonClickListener();

        pbar = (ProgressBar) findViewById(R.id.progressBar);
        pbar.setMax(5);
        pbar.setProgress(5);

    }

    @Override
    public void onBackPressed() {
        mp = MediaPlayer.create(this, R.raw.click);
        mp.start();
        AlertDialog.Builder a_builder = new AlertDialog.Builder(ThreeFiveActivity.this);
        a_builder.setTitle("Continue?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }

                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent nextform = new Intent(ThreeFiveActivity.this, LevelOneActivity.class);
                        startActivity(nextform);
                        overridePendingTransition(R.anim.pushrightin, R.anim.pushrightout);
                        finish();
                    }
                });
        AlertDialog alert = a_builder.create();
        alert.show();
    }

    public void onButtonClickListener(){
        mp = MediaPlayer.create(this, R.raw.click);
        button_mamaya = (Button) findViewById(R.id.btnMamaya);
        button_kagabi = (Button) findViewById(R.id.btnKagabi);
        button_umaga = (Button) findViewById(R.id.btnUmaga);

        button_mamaya.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mp.start();
                        AlertDialog.Builder alert = new AlertDialog.Builder(context);
                        //alert.setTitle(""); //Set Alert dialog title here
                        alert.setMessage("The correct translation is 'Narinig mo ba ang tuko kagabi.'"); //Message here
                        alert.setCancelable(false);
                        alert.setPositiveButton("next", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                mp.start();
                                SharedPreferences sharedP = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                Integer totalScore = sharedP.getInt("ScoreThree",0);
                                Toast.makeText(ThreeFiveActivity.this, "You're Score is:" + totalScore, Toast.LENGTH_LONG).show();


                                AlertDialog.Builder alert = new AlertDialog.Builder(context);
                                alert.setTitle("Oooppss. You didn't answer all correctly");
                                alert.setMessage("Restart Game?");
                                alert.setCancelable(false);
                                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        mp.start();
                                        Intent nextForm = new Intent(ThreeFiveActivity.this, ThreeOneActivity.class);
                                        startActivity(nextForm);
                                        overridePendingTransition(R.anim.leftin, R.anim.pushleftout);
                                        finish();
                                    } // End of onClick(DialogInterface dialog, int whichButton)
                                }); //End of alert.setPositiveButton
                                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        mp.start();
                                        Intent nextForm = new Intent(ThreeFiveActivity.this, MainActivity.class);
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
        );
        button_umaga.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mp.start();
                        // String ans = button_mabuti.getText().toString();
                        // txt_ans.setText(ans);
                        AlertDialog.Builder alert = new AlertDialog.Builder(context);
                        //alert.setTitle(""); //Set Alert dialog title here
                        alert.setMessage("The correct translation is 'Narinig mo ba ang tuko kagabi.'"); //Message here
                        alert.setCancelable(false);
                        alert.setPositiveButton("next", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {

                                mp.start();
                                SharedPreferences sharedP = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                Integer totalScore = sharedP.getInt("ScoreThree",0);
                                Toast.makeText(ThreeFiveActivity.this, "You're Score is:" + totalScore, Toast.LENGTH_LONG).show();

                                AlertDialog.Builder alert = new AlertDialog.Builder(context);
                                alert.setTitle("Oooppss. You didn't answer all correctly");
                                alert.setMessage("Restart Game?");
                                alert.setCancelable(false);
                                alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        mp.start();
                                        Intent nextForm = new Intent(ThreeFiveActivity.this, ThreeOneActivity.class);
                                        startActivity(nextForm);
                                        overridePendingTransition(R.anim.leftin, R.anim.pushleftout);
                                        finish();
                                    } // End of onClick(DialogInterface dialog, int whichButton)
                                }); //End of alert.setPositiveButton
                                alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        mp.start();
                                        Intent nextForm = new Intent(ThreeFiveActivity.this, MainActivity.class);
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
        );
        button_kagabi.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mp.start();
                        SharedPreferences sharedP = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                        SharedPreferences.Editor editor = sharedP.edit();
                        Integer score = sharedP.getInt("ScoreThree",0);
                        Integer totalScore = score + 1;
                        editor.putInt("ScoreThree", totalScore);
                        editor.commit();

                        if (totalScore == 5){

                            Toast.makeText(ThreeFiveActivity.this, "You're Score is:" + totalScore, Toast.LENGTH_LONG).show();

                            Integer round = sharedP.getInt("RoundOneThree", 0);

                            if (round == 0){

                                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                SharedPreferences.Editor editors = sharedPreferences.edit();
                                Integer newstars = sharedPreferences.getInt("Stars", 0);
                                Integer totalRounds = 1;
                                Integer totalStars = newstars + 75;
                                editors.putInt("RoundOneThree", totalRounds);
                                editors.putInt("Stars", totalStars);
                                editors.commit();

                                AlertDialog.Builder alert = new AlertDialog.Builder(context);
                                alert.setTitle("Congratulations!");
                                alert.setMessage("You have earned 75 stars");
                                alert.setCancelable(false);
                                alert.setPositiveButton("next", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        mp.start();
                                        Intent nextForm = new Intent(ThreeFiveActivity.this, MainActivity.class);
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
                                        Intent nextForm = new Intent(ThreeFiveActivity.this, MainActivity.class);
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


                            SharedPreferences sharedPp = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                            Integer totalScores = sharedPp.getInt("ScoreThree",0);
                            Toast.makeText(ThreeFiveActivity.this, "You're Score is:" + totalScores, Toast.LENGTH_LONG).show();

                            AlertDialog.Builder alert = new AlertDialog.Builder(context);
                            alert.setTitle("Oooppss. You didn't answer all correctly");
                            alert.setMessage("Restart Game?");
                            alert.setCancelable(false);
                            alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    mp.start();
                                    Intent nextForm = new Intent(ThreeFiveActivity.this, ThreeOneActivity.class);
                                    startActivity(nextForm);
                                    overridePendingTransition(R.anim.leftin, R.anim.pushleftout);
                                    finish();
                                } // End of onClick(DialogInterface dialog, int whichButton)
                            }); //End of alert.setPositiveButton
                            alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    mp.start();
                                    Intent nextForm = new Intent(ThreeFiveActivity.this, MainActivity.class);
                                    startActivity(nextForm);
                                    overridePendingTransition(R.anim.leftin, R.anim.pushleftout);
                                    finish();
                                } // End of onClick(DialogInterface dialog, int whichButton)
                            }); //End of alert.setNegativeButton
                            AlertDialog alertDialog = alert.create();
                            alertDialog.show();
                        }

                    }
                }
        );
    }
}

