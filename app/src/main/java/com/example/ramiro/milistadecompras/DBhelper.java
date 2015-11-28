package com.example.ramiro.milistadecompras;

/**
 * Created by Ramiro on 26/11/2015.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper {

    // Información de la tabla
    public static final String TABLE_PRODUCT = "productos";
    public static final String PRODUCTO_ID = "_id";
    public static final String PRODUCTO_NOMBRE = "nombre";

    // información del a base de datos
    static final String DB_NAME = "DBPRODUCTO";
    static final int DB_VERSION = 1;

    // Información de la base de datos
    private static final String CREATE_TABLE = "create table "
            + TABLE_PRODUCT + "(" + PRODUCTO_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + PRODUCTO_NOMBRE + " TEXT NOT NULL);";

    public DBhelper(Context context) {
        super(context, DB_NAME, null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCT);
        onCreate(db);
    }
}
