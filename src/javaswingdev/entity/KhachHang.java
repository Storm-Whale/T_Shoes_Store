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
public class KhachHang {

    private Long id;
    private NhanVien idNV;
    private String maKH;
    private String tenKH;
    private String sdt;
    private Date ngaySinh;
    private boolean gioiTinh;
    private String email;
    private String diaChi;
    private Date ngayTao;
    private Boolean trangThai;

    public KhachHang() {
    }

    public KhachHang(Long id, NhanVien idNV, String maKH, String tenKH, String sdt, Date ngaySinh, boolean gioiTinh, String email, String diaChi) {
        this.id = id;
        this.idNV = idNV;
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.diaChi = diaChi;

    }

    public KhachHang(Long id, String maKH, String tenKH) {
        this.id = id;
        this.maKH = maKH;
        this.tenKH = tenKH;
    }

    public KhachHang(NhanVien idNV, String maKH, String tenKH, String sdt, Date ngaySinh, boolean gioiTinh, String email, String diaChi) {
        this.idNV = idNV;
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.diaChi = diaChi;
    }

    public KhachHang(NhanVien idNV, String maKH, String tenKH, String sdt, Date ngaySinh, String email, boolean gioiTinh, String diaChi) {
        this.idNV = idNV;
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
    }

    public KhachHang(Long id, NhanVien idNV, String maKH, String tenKH, String sdt, Date ngaySinh, boolean gioiTinh, String email, String diaChi, Date ngayTao, Boolean trangThai) {
        this.id = id;
        this.idNV = idNV;
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.sdt = sdt;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.email = email;
        this.diaChi = diaChi;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NhanVien getIdNV() {
        return idNV;
    }

    public void setIdNV(NhanVien idNV) {
        this.idNV = idNV;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
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

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Float setGiamGiaCapBac(int cB) {
        if (cB == 0 || cB == 3) {
            return 0f;
        } else if (cB == 1) {
            return 3f;
        } else {
            return 8f;
        }
    }

    public Object[] rowData(int index) {
        return new Object[]{
            index, maKH, tenKH, gioiTinh ? "Nam" : "Nữ", sdt, diaChi, email, ngaySinh
        };
    }

    public Object[] rowData2() {
        return new Object[]{
            maKH, tenKH, sdt, email, gioiTinh ? "Nam" : "Nữ", diaChi
        };
    }

    @Override
    public String toString() {
        return "KhachHang{" + "id=" + id + ", idNV=" + idNV + ", maKH=" + maKH + ", tenKH=" + tenKH + ", sdt=" + sdt + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + ", email=" + email + ", diaChi=" + diaChi + ", ngayTao=" + ngayTao + ", trangThai=" + trangThai + '}';
    }

    public KhachHang getThongTin() {
        return new KhachHang(id, maKH, tenKH);
    }

}
