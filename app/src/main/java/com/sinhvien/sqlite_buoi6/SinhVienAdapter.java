package com.sinhvien.sqlite_buoi6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.sinhvien.sqlite_buoi6.models.SinhVien;

import java.util.ArrayList;

public class SinhVienAdapter extends ArrayAdapter<SinhVien> {

    public SinhVienAdapter(@NonNull Context context, int resource, ArrayList<SinhVien> sinhviens) {
        super(context, resource, sinhviens);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        SinhVien sinhvien = getItem(position);

        if (convertView == null) {
            // Get the file layout item for listview
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.sinhvien_cell, parent, false);
        }

        TextView textViewTenSinhVien = (TextView) convertView.findViewById(R.id.ten_sinh_vien_text_view);
        TextView textViewLopSinhVien = (TextView) convertView.findViewById(R.id.lop_sinh_vien_text_view);
        ImageView ButtonXoaSinhVien = (ImageView) convertView.findViewById(R.id.image_xoa_sinh_vien);

        textViewTenSinhVien.setText(sinhvien.getTen());
        textViewLopSinhVien.setText(sinhvien.getLop());

        return convertView;
    }
}
