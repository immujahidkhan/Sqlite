package com.aisha.sqliteagain;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.sql.Timestamp;

/**
 * Created by Aisha on 10/02/2018.
 */

public class SQLiteHelper extends SQLiteOpenHelper {
    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super (context, name, factory, version);
    }
    public void queryData(String sql){
        SQLiteDatabase database = getWritableDatabase ();
        database.execSQL (sql);
    }
    public void insertData(String title, String details, Long dateTime , byte[] image){
        SQLiteDatabase database = getWritableDatabase ();
        String sql = "INSERT INTO NOTIFICATION VALUES(NULL, ? , ? ,? ,? )";

        SQLiteStatement statement = database.compileStatement (sql);
        statement.clearBindings ();

        statement.bindString (1, title);
        statement.bindString (2,details);
        statement.bindLong(3, dateTime);
        statement.bindBlob(4, image);

        statement.executeInsert ();
    }

    public void updateData(String title, String details, byte[] image , int id ){
        SQLiteDatabase database = getWritableDatabase ();

        String sql = "UPDATE NOTIFICATION SET title= ? , details = ? , image = ? WHERE id= ?";
        SQLiteStatement statement = database.compileStatement (sql);

        statement.bindString (1, title);
        statement.bindString (2, details);
        statement.bindBlob(3, image);
        statement.bindDouble (4, (double)id);

        statement.execute ();
        database.close ();
    }

    public void deleteData(int id){
        SQLiteDatabase database = getWritableDatabase ();

        String sql = "DELETE FROM NOTIFICATION WHERE id = ?";
        SQLiteStatement statement = database.compileStatement (sql);
        statement.clearBindings ();
        statement.bindDouble (1, (double)id);

        statement.execute ();
        database.close ();

    }

    public Cursor getData(String sql){

        SQLiteDatabase database = getReadableDatabase ();
        return database.rawQuery (sql, null);
    }

    public SQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super (context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
