package com.sinhvien.sqlite_buoi6.models;

// Models
public class SinhVien {
    private String id;
    private String ten;
    private String lop;

    public SinhVien(String id, String ten, String lop) {
        this.id = id;
        this.ten = ten;
        this.lop = lop;
    }

    public SinhVien() {

    }

    @Override
    public String toString() {
        return ten + " - " + lop;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }
}
