package app.mobapp.android.pupkev.com.ling_o_ragon;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

/**
 * Created by A C E R on 12/28/2015.
 */
public class AboutActivity extends Activity{

    private static MediaPlayer mp;

    public void onButtonClickListener(){

    }


    /*@Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.imgbtnBackSettings:
            {
                Intent main = new Intent(this, SettingActivity.class);
                startActivity(main);
            }


        }
    }*/
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);
        onButtonClickListener();

        //ImageButton backBtn = (ImageButton) findViewById(R.id.imgbtnBackSettings);

        //backBtn.setOnClickListener(this);
    }


    @Override
    public void onBackPressed() {
        mp = MediaPlayer.create(this,R.raw.click);
        mp.start();
        super.onBackPressed();
        Intent nextform = new Intent(AboutActivity.this, SettingActivity.class);
        overridePendingTransition(R.anim.pushrightin, R.anim.pushrightout);
        startActivity(nextform);
        finish();
    }

}
