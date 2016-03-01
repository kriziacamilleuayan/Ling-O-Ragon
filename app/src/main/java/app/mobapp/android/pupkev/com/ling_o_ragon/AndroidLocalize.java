package app.mobapp.android.pupkev.com.ling_o_ragon;

import java.util.Locale;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

/**
 * Created by A C E R on 1/3/2016.
 */
public class AndroidLocalize extends Activity {

    Spinner spinnerctrl;
    Button btn;
    Locale myLocale;

    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.androidlocalize);
        spinnerctrl = (Spinner) findViewById(R.id.spinner1);
        spinnerctrl.setOnItemSelectedListener(new OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {

                if (pos == 1) {

                    Toast.makeText(parent.getContext(),
                            "You have selected Filipino", Toast.LENGTH_SHORT)
                            .show();
                    setLocale("tl");
                    Intent nextForm = new Intent("app.mobapp.android.pupkev.com.ling_o_ragon.MainActivity");
                    startActivity(nextForm);

                } else if (pos == 2) {

                    Toast.makeText(parent.getContext(),
                            "You have selected English", Toast.LENGTH_SHORT)
                            .show();
                    setLocale("en");
                    Intent nextForm = new Intent("app.mobapp.android.pupkev.com.ling_o_ragon.MainActivity");
                    startActivity(nextForm);
                }
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });
    }

    public void setLocale(String lang) {

        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        Intent refresh = new Intent(this, AndroidLocalize.class);
        startActivity(refresh);

    }
}


