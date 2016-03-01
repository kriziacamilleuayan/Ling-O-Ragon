package app.mobapp.android.pupkev.com.ling_o_ragon;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


/**
 * Created by A C E R on 12/28/2015.
 */
public class LanguageActivity extends Activity{
    //private Intent nextForm;
    //private static Button button_fil;
    //private static ImageButton button_back;
    private static Button button_fil;
    private static Button button_eng;

    public void onButtonClickListener(){
        /*button_back = (ImageButton) findViewById(R.id.imgbtnBackSettings);
        button_back.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent nextForm = new Intent("app.mobapp.android.pupkev.com.ling_o_ragon.SettingActivity");
                        startActivity(nextForm);
                    }
                }
        );*/

        button_fil = (Button) findViewById(R.id.btnFilipino);
        button_fil.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(LanguageActivity.this,"Filipino Language",Toast.LENGTH_SHORT).show();
                    }
                }
        );

        button_eng = (Button) findViewById(R.id.btnEnglish);
        button_eng.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(LanguageActivity.this,"English Language",Toast.LENGTH_SHORT).show();
                    }
                }
        );

    }


    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.language);
        onButtonClickListener();

    }


}
