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
public class OneTwoActivity extends Activity {


   // private static ImageButton button_next;
    private static Button button_maganda;
    private static Button button_salamat;
    private static Button button_matibay;
   // private static TextView txt_ans;
    final Context context = this;
    private static MediaPlayer mp;
    private static ProgressBar pbar;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one_two);
        onButtonClickListener();

        pbar = (ProgressBar) findViewById(R.id.progressBar);
        pbar.setMax(15);
        pbar.setProgress(2);

    }


    @Override
    public void onBackPressed() {

        mp = MediaPlayer.create(this,R.raw.click);
        mp.start();
        AlertDialog.Builder a_builder = new AlertDialog.Builder(OneTwoActivity.this);
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
                        Intent nextform = new Intent(OneTwoActivity.this, LevelOneActivity.class);
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
        button_salamat = (Button) findViewById(R.id.btnSalamat);
        button_matibay = (Button) findViewById(R.id.btnMatibay);
        //txt_ans = (TextView) findViewById(R.id.txtAns);


        button_maganda.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mp.start();
                        AlertDialog.Builder alert = new AlertDialog.Builder(context);
                        //alert.setTitle(""); //Set Alert dialog title here
                        alert.setMessage("The correct translation is 'Salamat sa bigay mo na sapatos.'"); //Message here
                        alert.setCancelable(false);
                        alert.setPositiveButton("next", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                mp.start();
                                Intent nextForm = new Intent(OneTwoActivity.this, OneThreeActivity.class);
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


        button_salamat.setOnClickListener(
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

                        Intent nextForm = new Intent(OneTwoActivity.this, OneThreeActivity.class);
                        startActivity(nextForm);
                        overridePendingTransition(R.anim.leftin, R.anim.pushleftout);
                        finish();

                    }
                }
        );


        button_matibay.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mp.start();
                        //String ans = button_matibay.getText().toString();
                        //txt_ans.setText(ans);

                        AlertDialog.Builder alert = new AlertDialog.Builder(context);
                        //alert.setTitle(""); //Set Alert dialog title here
                        alert.setMessage("The correct translation is 'Salamat sa bigay mo na sapatos.'"); //Message here
                        alert.setCancelable(false);
                        alert.setPositiveButton("next", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                mp.start();
                                Intent nextForm = new Intent(OneTwoActivity.this, OneThreeActivity.class);
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
