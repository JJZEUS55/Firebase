package redes.com.pruebaanswer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class AppDb extends SQLiteOpenHelper {

    private static AppDb appDbHelper;
    private static final String NAME = "Prueba.db";
    private static final int VERSION = 1;

    public AppDb(@Nullable Context context) {
        super(context, NAME, null, VERSION);
    }

    public static synchronized AppDb getAppDbHelper(Context context) {
        if (appDbHelper == null) {
            appDbHelper = new AppDb(context);
        }

        return appDbHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Tables.TABLE_QUESTIONS);
        db.execSQL(Tables.TABLE_REPORT);
        db.execSQL(Tables.TABLE_ANSWER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
