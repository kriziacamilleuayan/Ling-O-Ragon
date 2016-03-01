package app.mobapp.android.pupkev.com.ling_o_ragon;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by A C E R on 1/19/2016.
 */
public class DataBaseCommand extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "sampledb.db";
    public static final String TABLE_NAME = "STATS";
    public static final String COL_SCORE = "SCORE";


    public DataBaseCommand (Context context)  {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table" + TABLE_NAME + " (SCORE INTEGER PRIMARY KEY)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db);
    }
}
