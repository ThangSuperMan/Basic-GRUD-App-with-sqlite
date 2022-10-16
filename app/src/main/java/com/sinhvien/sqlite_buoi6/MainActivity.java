package com.sinhvien.sqlite_buoi6;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.sinhvien.sqlite_buoi6.models.SinhVien;
import com.sinhvien.sqlite_buoi6.sqlite.DBHelper;
import com.sinhvien.sqlite_buoi6.sqlite.SinhVienDao;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    // Variables
    public static ArrayList<SinhVien> listSinhVien = new ArrayList<>();
    private ListView listView;
    ArrayAdapter adapter;

    // UI components
    Button buttonAddStudent;
    Button buttonUpdateStudent;
    EditText editTextNameStudent;
    EditText editTextClassStudent;

    // Life cycles
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpData();
        setUplist();
        setUpEvents();
    }

    private void setUpEvents() {
        buttonAddStudent = (Button) findViewById(R.id.buttonAddStudent);
        buttonUpdateStudent = (Button) findViewById(R.id.buttonUpdateStudent);
        editTextNameStudent = (EditText)findViewById(R.id.editTextNameStudent);
        editTextClassStudent = (EditText)findViewById(R.id.editTextClassStudent);

        String nameStudent = editTextNameStudent.getText().toString();
        String classStudent = editTextClassStudent.getText().toString();

        // EVent listeners
        buttonAddStudent.setOnClickListener(v -> {

            if (nameStudent.equals("")) {
                Toast.makeText(MainActivity.this, "Sorry, we can not adding for you this student cause the name field is empty!", Toast.LENGTH_SHORT).show();
                return;
            } else if (classStudent.equals("")) {
                Toast.makeText(MainActivity.this, "Sorry, we can not adding for you this student cause the class field is empty!", Toast.LENGTH_SHORT).show();
                return;
            } else {
                Toast.makeText(MainActivity.this, "Allow insert to table", Toast.LENGTH_SHORT).show();
            }

            Toast.makeText(MainActivity.this, "Here", Toast.LENGTH_SHORT).show();

//            if (!nameStudent.equals("") && !classStudent.equals("")) {
//                Toast.makeText(MainActivity.this, "Allow insert to table", Toast.LENGTH_SHORT).show();
//            } else {
//                Toast.makeText(MainActivity.this, "Do not allow insert to table", Toast.LENGTH_SHORT).show();
//               return;
//            }

            SinhVien sinhvien = new SinhVien();
            sinhvien.setTen(nameStudent);
            sinhvien.setLop(classStudent);
            SinhVienDao sinhVienDao = new SinhVienDao(MainActivity.this);
            long resultInserted = sinhVienDao.insert(sinhvien);

            // Error handling for the database
            if (resultInserted == -1) {
                Toast.makeText(MainActivity.this, "Added the student have some issue!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Added the student successfully", Toast.LENGTH_SHORT).show();
            }
        });

        buttonUpdateStudent.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this, "Update action just be called", Toast.LENGTH_SHORT).show();
        });
    }

    // Functions
    private void setUpData() {
        SinhVienDao sinhVienDao = new SinhVienDao(MainActivity.this);
        listSinhVien = SinhVienDao.getAll();
    }

    private void setUplist() {
        listView = (ListView) findViewById(R.id.list_sinhvien);
//        SinhVienDao sinhVienDao = new SinhVienDao(MainActivity.this);
//        listSinhVien = SinhVienDao.getAll();
        SinhVienAdapter adapter = new SinhVienAdapter(MainActivity.this, 0, listSinhVien);
        listView.setAdapter(adapter);
    }

}