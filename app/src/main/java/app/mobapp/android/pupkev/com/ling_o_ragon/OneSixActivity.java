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
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by A C E R on 1/4/2016.
 */
public class OneSixActivity extends Activity{

    private static Button button_next;
    private static TextView txt_ans;
    final Context context = this;
    private static ProgressBar pbar;
    private static MediaPlayer mp;
    private static ImageButton speech;
    private static MediaPlayer onesix;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_six);
        onButtonClickListener();

        pbar = (ProgressBar) findViewById(R.id.progressBar);
        pbar.setMax(15);
        pbar.setProgress(6);


        onesix = MediaPlayer.create(this,R.raw.onesix);
        speech = (ImageButton) findViewById(R.id.btnspeech);
        speech.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onesix.start();
                    }
                }
        );


    }


    @Override
    public void onBackPressed() {
        mp = MediaPlayer.create(this,R.raw.click);
        AlertDialog.Builder a_builder = new AlertDialog.Builder(OneSixActivity.this);
        a_builder.setTitle(R.string.cont)
                .setCancelable(false)
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mp.start();
                        dialog.cancel();
                    }

                })
                .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mp.start();
                        Intent nextform = new Intent(OneSixActivity.this, LevelOneActivity.class);
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
                        if (txt_ans.getText().toString().toLowerCase().equals("namomotan ta ka")){
                            SharedPreferences sharedP = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                            SharedPreferences.Editor editor = sharedP.edit();
                            Integer score = sharedP.getInt("ScoreOne",0);
                            Integer totalScore = score + 1;
                            editor.putInt("ScoreOne", totalScore);
                            editor.commit();

                            Intent nextForm = new Intent(OneSixActivity.this, OneSevenActivity.class);
                            startActivity(nextForm);
                            overridePendingTransition(R.anim.leftin, R.anim.pushleftout);
                            finish();

                        }
                        else{
                            AlertDialog.Builder alert = new AlertDialog.Builder(context);
                            alert.setMessage(R.string.tonesix); //Message here
                            alert.setCancelable(false);
                            alert.setPositiveButton(R.string.next, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    mp.start();
                                    Intent nextForm = new Intent(OneSixActivity.this, OneSevenActivity.class);
                                    startActivity(nextForm);
                                    overridePendingTransition(R.anim.leftin, R.anim.pushleftout);
                                    finish();
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
