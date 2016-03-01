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

/**
 * Created by A C E R on 12/30/2015.
 */
public class OneOneActivity extends Activity {

    //private static ImageButton button_next;
    private static Button button_maganda;
    private static Button button_mabuti;
    private static Button button_marami;
    final Context context = this;
    private static ProgressBar pbar;
    private static MediaPlayer mp;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_one);
        onButtonClickListener();


        SharedPreferences sharedP = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = sharedP.edit();
        Integer totalScore = 0;
        editor.putInt("ScoreOne", totalScore);
        editor.commit();

        pbar = (ProgressBar) findViewById(R.id.progressBar);
        pbar.setMax(15);

        pbar.setProgress(1);

    }

    @Override
    public void onBackPressed() {
        mp = MediaPlayer.create(this,R.raw.click);
        mp.start();
        AlertDialog.Builder a_builder = new AlertDialog.Builder(OneOneActivity.this);
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
                        Intent nextform = new Intent(OneOneActivity.this, LevelOneActivity.class);
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
        button_maganda = (Button) findViewById(R.id.btnMaganda);
        button_mabuti = (Button) findViewById(R.id.btnMabuti);
        button_marami = (Button) findViewById(R.id.btnMarami);

        button_maganda.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mp.start();
                        //String ans = button_maganda.getText().toString();
                        //txt_ans.setText(ans);
                        AlertDialog.Builder alert = new AlertDialog.Builder(context);
                        //alert.setTitle(R.string.correctTranslation); //Set Alert dialog title here
                        alert.setMessage(R.string.wewe + "The correct translation is 'Maraming salamat sa mga regalo.'"); //Message here
                        alert.setCancelable(false);
                        alert.setPositiveButton(R.string.next, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                mp.start();
                                Intent nextForm = new Intent(OneOneActivity.this, OneTwoActivity.class);
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
        button_mabuti.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mp.start();
                       // String ans = button_mabuti.getText().toString();
                       // txt_ans.setText(ans);
                        AlertDialog.Builder alert = new AlertDialog.Builder(context);
                        //alert.setTitle(""); //Set Alert dialog title here
                        alert.setMessage("The correct translation is 'Maraming salamat sa mga regalo.'"); //Message here
                        alert.setCancelable(false);
                        alert.setPositiveButton(R.string.next, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                mp.start();
                                Intent nextForm = new Intent(OneOneActivity.this, OneTwoActivity.class);
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
        button_marami.setOnClickListener(
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

                        Intent nextForm = new Intent(OneOneActivity.this, OneTwoActivity.class);
                        startActivity(nextForm);
                        overridePendingTransition(R.anim.leftin, R.anim.pushleftout);
                        finish();

                    }
                }
        );



    }


}

