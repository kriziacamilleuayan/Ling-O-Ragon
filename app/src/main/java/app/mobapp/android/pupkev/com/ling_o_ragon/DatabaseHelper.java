package app.mobapp.android.pupkev.com.ling_o_ragon;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by A C E R on 1/6/2016.
 */


    public class DatabaseHelper extends SQLiteOpenHelper {

        public static final String DATABASE_NAME = "star.db";
        public static final String TABLE_NAME = "stars_table";
        public static final String COL1 = "stars";


        public DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, 1);

        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + TABLE_NAME +
                    "(" + COL1 + " INTEGER PRIMARY KEY)");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
            onCreate(db);
        }

        public boolean insertData(Integer stars) {
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues contentValues = new ContentValues();

            contentValues.put(COL1, stars);
            db.insert(TABLE_NAME, null, contentValues);
            return true;
        }

        public Cursor getAllData() {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor res =  db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
            return res;
        }






    public boolean updateStar(Integer id, int score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1, score);
        db.update(TABLE_NAME, contentValues, COL1 + " = ? ", new String[] { Integer.toString(id) } );
        return true;
    }



}
