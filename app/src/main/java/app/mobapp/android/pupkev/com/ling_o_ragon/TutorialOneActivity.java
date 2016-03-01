package app.mobapp.android.pupkev.com.ling_o_ragon;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Layout;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by A C E R on 2/18/2016.
 */
public class TutorialOneActivity extends Activity {

    private static MediaPlayer mp;
    private static FrameLayout next;
    private static ImageView lol;
    private static TextView wew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial1);

        next = (FrameLayout) findViewById(R.id.tutorialone);
        mp = MediaPlayer.create(this, R.raw.click);

        lol = (ImageView) findViewById(R.id.lol);
        Animation a = AnimationUtils.loadAnimation(this, R.anim.lol);
        a.setFillAfter(true);
        a.reset();
        lol.startAnimation(a);

        wew = (TextView) findViewById(R.id.wew);
        Animation b = AnimationUtils.loadAnimation(this, R.anim.wew);
        b.setFillAfter(true);
        b.reset();
        wew.startAnimation(b);


        next.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mp.start();

                        Intent nextForm = new Intent(TutorialOneActivity.this, TutorialTwoActivity.class);
                        startActivity(nextForm);
                        overridePendingTransition(R.anim.leftin, R.anim.pushleftout);
                        finish();

                    }
                }
        );



    }


    @Override
    public void onBackPressed() {
        mp = MediaPlayer.create(this, R.raw.click);
        mp.start();
        AlertDialog.Builder a_builder = new AlertDialog.Builder(TutorialOneActivity.this);
        a_builder.setTitle("Exit Tutorial?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mp.start();
                        Intent nextform = new Intent(TutorialOneActivity.this, LevelOneActivity.class);
                        startActivity(nextform);
                        overridePendingTransition(R.anim.pushrightin, R.anim.pushrightout);
                        finish();
                    }

                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mp.start();
                        dialog.cancel();
                    }
                });
        AlertDialog alert = a_builder.create();
        alert.show();
    }
}
