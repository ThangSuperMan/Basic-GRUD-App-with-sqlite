package com.sinhvien.sqlite_buoi6.sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.sinhvien.sqlite_buoi6.models.SinhVien;

import java.util.ArrayList;

public class SinhVienDao {
    private static SQLiteDatabase db;

    public SinhVienDao(Context context) {
        DBHelper helper = new DBHelper(context);

        // Connect to the sqlite
        // This will allow us to using the GRUD operators
        db = helper.getReadableDatabase();
    }

    @SuppressLint("Range")
    public static ArrayList<SinhVien> get(String sql, String ...selectArgs) {
        ArrayList<SinhVien> list = new ArrayList<>();

        Cursor cursor = db.rawQuery(sql, selectArgs);
        while (cursor.moveToNext()) {
            SinhVien sinhvien = new SinhVien();
            String id = cursor.getString(cursor.getColumnIndex("id_sinh_vien"));
            String ten = cursor.getString(cursor.getColumnIndex("ten"));
            String lop = cursor.getString(cursor.getColumnIndex("lop"));
            sinhvien.setId(id);
            sinhvien.setTen(ten);
            sinhvien.setLop(lop);

            list.add(sinhvien);
        }

        return list;
    }

    public static ArrayList<SinhVien> getAll() {
        String sql = "select * from SinhVien";
        return  get(sql);
    }

    public static SinhVien getById(String id) {
        String sql = "select * from SinhVien where id_sinh_vien = ?";
        ArrayList<SinhVien> list = get(sql, id);

        return  list.get(0);
    }

    public long insert(SinhVien sinhVien) {
        ContentValues values = new ContentValues();
//        values.put("id_sinh_vien", sinhVien.getId());
        values.put("ten", sinhVien.getTen());
        values.put("lop", sinhVien.getLop());

        return db.insert("sinhvien", null, values);
    }

    public int update(SinhVien sinhVien) {
        ContentValues values = new ContentValues();
        values.put("id_sinh_vien", sinhVien.getTen());
        values.put("id_sinh_vien", sinhVien.getLop());

        return db.update("SinhVien", values, "id=?", new String[]{sinhVien.getId()});
    }
}
