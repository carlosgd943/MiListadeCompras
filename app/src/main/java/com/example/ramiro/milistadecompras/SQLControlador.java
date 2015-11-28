package com.example.ramiro.milistadecompras;

/**
 * Created by Ramiro on 26/11/2015.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class SQLControlador {

    private DBhelper dbhelper;
    private Context ourcontext;
    private SQLiteDatabase database;

    public SQLControlador(Context c) {
        ourcontext = c;
    }

    public SQLControlador abrirBaseDeDatos() throws SQLException {
        dbhelper = new DBhelper(ourcontext);
        database = dbhelper.getWritableDatabase();
        return this;
    }

    public void cerrar() {
        dbhelper.close();
    }

    public void insertarDatos(String name) {
        ContentValues cv = new ContentValues();
        cv.put(DBhelper.PRODUCTO_NOMBRE, name);
        database.insert(DBhelper.TABLE_PRODUCT, null, cv);
    }

    public Cursor leerDatos() {
        String[] todasLasColumnas = new String[] {
                DBhelper.PRODUCTO_ID,
                DBhelper.PRODUCTO_NOMBRE
        };
        Cursor c = database.query(DBhelper.TABLE_PRODUCT, todasLasColumnas, null,
                null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    public int actualizarDatos(long memberID, String memberName) {
        ContentValues cvActualizar = new ContentValues();
        cvActualizar.put(DBhelper.PRODUCTO_NOMBRE, memberName);
        int i = database.update(DBhelper.TABLE_PRODUCT, cvActualizar,
                DBhelper.PRODUCTO_ID + " = " + memberID, null);
        return i;
    }

    public void deleteData(long memberID) {
        database.delete(DBhelper.TABLE_PRODUCT, DBhelper.PRODUCTO_ID + "="
                + memberID, null);
    }
}
