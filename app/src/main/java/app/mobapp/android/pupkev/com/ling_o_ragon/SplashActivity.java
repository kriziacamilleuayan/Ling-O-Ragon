package app.mobapp.android.pupkev.com.ling_o_ragon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by A C E R on 12/26/2015.
 */
public class SplashActivity extends Activity{

    @Override
    protected void onCreate(Bundle SaveInstanceState){
        super.onCreate(SaveInstanceState);
        setContentView(R.layout.splash);

        Thread myThread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(2000);
                    Intent startLingORagon = new Intent (SplashActivity.this, LingORagonActivity.class);
                    startActivity(startLingORagon);
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
