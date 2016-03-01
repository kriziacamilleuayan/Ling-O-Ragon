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
import android.widget.TextView;


/**
 * Created by A C E R on 12/29/2015.
 */
public class TriviasActivity extends Activity {
    private static Button button_triviaone;
    private static Button button_triviatwo;
    private static Button button_triviathree;
    private static Button button_triviafour;
    private static TextView txt_stars;
    final Context context = this;
    private static MediaPlayer mp;

    public void onButtonClickListener(){
        mp = MediaPlayer.create(this,R.raw.click);

        button_triviaone = (Button) findViewById(R.id.btnTrivia1);
        button_triviaone.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mp.start();

                        SharedPreferences sharedlol = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                        Integer triviaOne = sharedlol.getInt("TriviaOne", 0);

                        if (triviaOne == 0){

                            AlertDialog.Builder alert = new AlertDialog.Builder(context);
                            alert.setTitle("Trivia 1");
                            alert.setMessage("Costs 50 stars");
                            alert.setCancelable(true);
                            alert.setNegativeButton("No, thanks.", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    mp.start();
                                    dialog.cancel();
                                }
                            });
                            alert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    mp.start();
                                    SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                                    Integer Stars = sharedPreferences.getInt("Stars", 0);

                                    if (Stars >= 50){
                                        SharedPreferences.Editor editor = sharedPreferences.edit();
                                        Integer newstars = sharedPreferences.getInt("Stars", 0);
                                        Integer totalStars = newstars - 50;
                                        Integer ctrOne = 1;
                                        editor.putInt("TriviaOne",ctrOne);
                                        editor.putInt("Stars",totalStars);
                                        editor.commit();

                                        Intent nextForm = new Intent(TriviasActivity.this, TriviaOneActivity.class);
                                        startActivity(nextForm);
                                        overridePendingTransition(R.anim.leftin, R.anim.pushleftout);
                                        finish();
                                    }

                                    else {

                                        AlertDialog.Builder alert = new AlertDialog.Builder(context);
                                        alert.setTitle("Ooppps");
                                        alert.setMessage("You don't have enough stars.");
                                        alert.setCancelable(true);
                                        alert.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                mp.start();
                                                dialog.cancel();
                                            }
                                        });
                                        AlertDialog alertDialog = alert.create();
                                        alertDialog.show();
                                    }
                                }
                            });
                            AlertDialog alertDialog = alert.create();
                            alertDialog.show();

                        }

                        else {
                            Intent nextForm = new Intent(TriviasActivity.this, TriviaOneActivity.class);
                            startActivity(nextForm);
                            overridePendingTransition(R.anim.leftin, R.anim.pushleftout);
                            finish();
                        }

                    }
                }
        );


        button_triviatwo = (Button) findViewById(R.id.btnTrivia2);
        button_triviatwo.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mp.start();
                        AlertDialog.Builder alert = new AlertDialog.Builder(context);
                        alert.setTitle("Trivia 2");
                        alert.setMessage("Costs 100 stars");
                        alert.setCancelable(true);
                        alert.setNegativeButton("No, thanks.", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mp.start();
                                dialog.cancel();
                            }
                        });
                        alert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mp.start();
                                //nextForm
                            }
                        });
                        AlertDialog alertDialog = alert.create();
                        alertDialog.show();
                    }
                }
        );


        button_triviathree = (Button) findViewById(R.id.btnTrivia3);
        button_triviathree.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mp.start();
                        AlertDialog.Builder alert = new AlertDialog.Builder(context);
                        alert.setTitle("Trivia 3");
                        alert.setMessage("Costs 150 stars");
                        alert.setCancelable(true);
                        alert.setNegativeButton("No, thanks.", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mp.start();
                                dialog.cancel();
                            }
                        });
                        alert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mp.start();
                                //nextForm
                            }
                        });
                        AlertDialog alertDialog = alert.create();
                        alertDialog.show();
                    }
                }
        );

        button_triviafour = (Button) findViewById(R.id.btnTrivia4);
        button_triviafour.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder alert = new AlertDialog.Builder(context);
                        alert.setTitle("Trivia 4");
                        alert.setMessage("Costs 200 stars");
                        alert.setCancelable(true);
                        alert.setNegativeButton("No, thanks.", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        alert.setPositiveButton("Buy", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //nextForm
                            }
                        });
                        AlertDialog alertDialog = alert.create();
                        alertDialog.show();
                    }
                }
        );


        Animation a = AnimationUtils.loadAnimation(this, R.anim.one);
        Animation b = AnimationUtils.loadAnimation(this, R.anim.two);
        Animation c = AnimationUtils.loadAnimation(this, R.anim.three);
        Animation d = AnimationUtils.loadAnimation(this, R.anim.four);
        button_triviaone.startAnimation(a);
        button_triviatwo.startAnimation(b);
        button_triviathree.startAnimation(c);
        button_triviafour.startAnimation(d);

    }

    public void updateStars() {
        txt_stars = (TextView) findViewById(R.id.txtStars);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String stars = String.valueOf(sharedPreferences.getInt("Stars", 0));
        txt_stars.setText(stars);
    }


    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trivias);
        onButtonClickListener();
        updateStars();
    }


    @Override
    public void onBackPressed() {
        mp = MediaPlayer.create(this,R.raw.click);
        mp.start();
        super.onBackPressed();
        Intent nextform = new Intent(TriviasActivity.this, MainActivity.class);
        overridePendingTransition(R.anim.pushrightin, R.anim.pushrightout);
        startActivity(nextform);
        finish();
    }
}
