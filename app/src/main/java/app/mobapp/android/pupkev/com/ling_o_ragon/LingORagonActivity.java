package app.mobapp.android.pupkev.com.ling_o_ragon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


/**
 * Created by A C E R on 12/26/2015.
 */
public class LingORagonActivity extends Activity{

    @Override
    protected void onCreate(Bundle SaveInstanceState){
        super.onCreate(SaveInstanceState);
        setContentView(R.layout.lingoragon);


        Thread myThread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(2000);
                    Intent startMainActivity = new Intent (LingORagonActivity.this, MainActivity.class);
                    startActivity(startMainActivity);
                    overridePendingTransition(R.anim.fadein ,R.anim.fadeout);
                    finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        myThread.start();
    }
}
