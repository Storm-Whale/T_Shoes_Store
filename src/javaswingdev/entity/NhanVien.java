/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaswingdev.entity;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class NhanVien {

    private Long id;
    private String MaNV;
    private String hoTenNV;
    private String matKhau;
    private String ngaySinh;
    private String cccd;
    private String email;
    private String diaChi;
    private String sdt;
    private Integer vaiTro;
    private String ngayTao;
    private Integer trangThai;

    public NhanVien() {
    }

    public NhanVien(Long id) {
        this.id = id;
    }

    public NhanVien(Long id, String hoTenNV) {
        this.id = id;
        this.hoTenNV = hoTenNV;
    }

    public NhanVien(Long id, String MaNV, String hoTenNV) {
        this.id = id;
        this.MaNV = MaNV;
        this.hoTenNV = hoTenNV;
    }

    public NhanVien(String MaNV, String hoVaTenNV, String matKhau, String ngaySinh, String cccd, String email, String diaChi, String sdt, Integer vaiTro, String ngayTao, Integer trangThai) {
        this.MaNV = MaNV;
        this.hoTenNV = hoTenNV;
        this.matKhau = matKhau;
        this.ngaySinh = ngaySinh;
        this.cccd = cccd;
        this.email = email;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.vaiTro = vaiTro;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public NhanVien(Long id, String MaNV, String hoTenNV, String matKhau, String ngaySinh, String cccd, String email, String diaChi, String sdt, Integer vaiTro, String ngayTao, Integer trangThai) {
        this.id = id;
        this.MaNV = MaNV;
        this.hoTenNV = hoTenNV;
        this.matKhau = matKhau;
        this.ngaySinh = ngaySinh;
        this.cccd = cccd;
        this.email = email;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.vaiTro = vaiTro;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getHoTenNV() {
        return hoTenNV;
    }

    public void setHoTenNV(String hoTenNV) {
        this.hoTenNV = hoTenNV;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Integer getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(Integer vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "NhanVien{" + "id=" + id + ", MaNV=" + MaNV + ", hoTenNV=" + hoTenNV + ", matKhau=" + matKhau + ", ngaySinh=" + ngaySinh + ", cccd=" + cccd + ", email=" + email + ", diaChi=" + diaChi + ", sdt=" + sdt + ", vaiTro=" + vaiTro + ", ngayTao=" + ngayTao + ", trangThai=" + trangThai + '}';
    }

}
