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
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by A C E R on 1/4/2016.
 */
public class OneFiveActivity extends Activity{

    //private static ImageButton button_next;
    private static Button button_please;
    private static Button button_balik;
    private static Button button_sigi;
    //private static TextView txt_ans;
    final Context context = this;
    private static ProgressBar pbar;
    private static MediaPlayer mp;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_five);
        onButtonClickListener();

        pbar = (ProgressBar) findViewById(R.id.progressBar);
        pbar.setMax(15);
        pbar.setProgress(5);

    }

    @Override
    public void onBackPressed() {
        mp = MediaPlayer.create(this, R.raw.click);
        mp.start();
        AlertDialog.Builder a_builder = new AlertDialog.Builder(OneFiveActivity.this);
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
                        Intent nextform = new Intent(OneFiveActivity.this, LevelOneActivity.class);
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

        button_please = (Button) findViewById(R.id.btnPlease);
        button_balik = (Button) findViewById(R.id.btnBalik);
        button_sigi = (Button) findViewById(R.id.btnSigi);
        //txt_ans = (TextView) findViewById(R.id.txtAns);

        button_please.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mp.start();
                        SharedPreferences sharedP = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                        SharedPreferences.Editor editor = sharedP.edit();
                        Integer score = sharedP.getInt("ScoreOne",0);
                        Integer totalScore = score + 1;
                        editor.putInt("ScoreOne", totalScore);
                        editor.commit();
                        Intent nextForm = new Intent(OneFiveActivity.this, OneSixActivity.class);
                        startActivity(nextForm);
                        overridePendingTransition(R.anim.leftin, R.anim.pushleftout);
                        finish();
                    }
                }
        );


        button_balik.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mp.start();
                        //String ans = button_balik.getText().toString();
                        //txt_ans.setText(ans);


                        AlertDialog.Builder alert = new AlertDialog.Builder(context);
                        //alert.setTitle(""); //Set Alert dialog title here
                        alert.setMessage(R.string.tonefive); //Message here
                        alert.setCancelable(false);
                        alert.setPositiveButton(R.string.next, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                mp.start();
                                Intent nextForm = new Intent(OneFiveActivity.this, OneSixActivity.class);
                                startActivity(nextForm);
                                overridePendingTransition(R.anim.leftin, R.anim.pushleftout);
                                finish();
                            } // End of onClick(DialogInterface dialog, int whichButton)
                        }); //End of alert.setPositiveButton
                        AlertDialog alertDialog = alert.create();
                        alertDialog.show();
                    }
                }
        );


        button_sigi.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mp.start();
                        //String ans = button_sigi.getText().toString();
                        //txt_ans.setText(ans);

                        AlertDialog.Builder alert = new AlertDialog.Builder(context);
                        //alert.setTitle(""); //Set Alert dialog title here
                        alert.setMessage(R.string.tonefive); //Message here
                        alert.setCancelable(false);
                        alert.setPositiveButton(R.string.next, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                mp.start();
                                Intent nextForm = new Intent(OneFiveActivity.this, OneSixActivity.class);
                                startActivity(nextForm);
                                overridePendingTransition(R.anim.leftin, R.anim.pushleftout);
                                finish();
                            } // End of onClick(DialogInterface dialog, int whichButton)
                        }); //End of alert.setPositiveButton
                        AlertDialog alertDialog = alert.create();
                        alertDialog.show();
                    }
                }
        );
    }

}
