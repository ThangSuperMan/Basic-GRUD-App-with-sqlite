package com.sinhvien.sqlite_buoi6.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    public static final String databaseName = "QuanLySinhVien";
    public static final String  nameTable = "SinhVien";

    public DBHelper(Context context) {
        super( context, "QuanLySinhVien", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // Log.d("myTag", "onCreate just called");
        String sql = "create table SinhVien(" +
                "id_sinh_vien integer primary key autoincrement," +
                "ten text," +
                "lop text)";
        sqLiteDatabase.execSQL(sql);

        sql = "create table GiamDoc(" +
                "id_giam_doc integer primary key autoincrement," +
                "ten text," +
                "lop text)";

        sqLiteDatabase.execSQL(sql);

        String sqlInsert = "insert into SinhVien values(null, 'Thang', 'TH2013')";
        sqLiteDatabase.execSQL(sqlInsert);
        String sqlInsert2 = "insert into SinhVien values(null, 'Ngoc', 'TH2013')";
        sqLiteDatabase.execSQL(sqlInsert2);
        String sqlInsert3 = "insert into SinhVien values(null, 'Han', 'TH2013')";
        sqLiteDatabase.execSQL(sqlInsert3);
        String sqlInsert4 = "insert into GiamDoc values(null, 'Giam Doc A', 'TH2013')";
        sqLiteDatabase.execSQL(sqlInsert4);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         super.onDowngrade(db, oldVersion, newVersion);
//        Log.d("myTag", "onDowgrade just called");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // Log.d("myTag", "onUpgrade just called");
        sqLiteDatabase.execSQL("drop table if exists SinhVien");
        sqLiteDatabase.execSQL("drop table if exists GiamDoc");
        onCreate(sqLiteDatabase);
    }
}
