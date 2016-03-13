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
public class ThreeEightActivity extends Activity {

    //private static ImageButton button_next;
    private static Button button_umaga;
    private static Button button_hatinggabi;
    private static Button button_hapon;
    final Context context = this;
    private static ProgressBar pbar;
    private static MediaPlayer mp;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.three_eight);
        onButtonClickListener();

        pbar = (ProgressBar) findViewById(R.id.progressBar);
        pbar.setMax(9);
        pbar.setProgress(7);

    }

    @Override
    public void onBackPressed() {
        mp = MediaPlayer.create(this, R.raw.click);
        mp.start();
        AlertDialog.Builder a_builder = new AlertDialog.Builder(ThreeEightActivity.this);
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
                        Intent nextform = new Intent(ThreeEightActivity.this, LevelOneActivity.class);
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
        button_umaga = (Button) findViewById(R.id.btnUmaga);
        button_hatinggabi = (Button) findViewById(R.id.btnHatinggabi);
        button_hapon = (Button) findViewById(R.id.btnHapon);

        button_hatinggabi.setOnClickListener(
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

                        Intent nextForm = new Intent(ThreeEightActivity.this, ThreeNineActivity.class);
                        startActivity(nextForm);
                        overridePendingTransition(R.anim.leftin, R.anim.pushleftout);
                        finish();

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
                        alert.setMessage(R.string.tthreeeight); //Message here
                        alert.setCancelable(false);
                        alert.setPositiveButton(R.string.next, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                mp.start();
                                Intent nextForm = new Intent(ThreeEightActivity.this, ThreeNineActivity.class);
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
        button_hapon.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        mp.start();
                        AlertDialog.Builder alert = new AlertDialog.Builder(context);
                        //alert.setTitle(""); //Set Alert dialog title here
                        alert.setMessage(R.string.tthreeeight); //Message here
                        alert.setCancelable(false);
                        alert.setPositiveButton(R.string.next, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                mp.start();
                                Intent nextForm = new Intent(ThreeEightActivity.this, ThreeNineActivity.class);
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

