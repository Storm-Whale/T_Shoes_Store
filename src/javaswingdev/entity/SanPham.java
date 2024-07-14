/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaswingdev.entity;

import java.util.Date;

/**
 *
 * @author DEll
 */
public class SanPham {
    private Long idSanPham;
    private String maSanPham;
    private String tenSanpham;
    private Integer soLuong;
    private Date ngayTao;
    private String nguoiTao;
    private int trangThai;

    public SanPham() {
    }

    public SanPham(Long idSanPham) {
        this.idSanPham = idSanPham;
    }

    public SanPham(String tenSanpham) {
        this.tenSanpham = tenSanpham;
    }

    public SanPham(Long idSanPham, String maSanPham, String tenSanpham, int trangThai) {
        this.idSanPham = idSanPham;
        this.maSanPham = maSanPham;
        this.tenSanpham = tenSanpham;
        this.trangThai = trangThai;
    }

    public SanPham(String maSanPham, String tenSanpham, int trangThai) {
        this.maSanPham = maSanPham;
        this.tenSanpham = tenSanpham;
        this.trangThai = trangThai;
    }

    public SanPham(Long idSanPham, String tenSanpham) {
        this.idSanPham = idSanPham;
        this.tenSanpham = tenSanpham;
    }

    public SanPham(Long idSanPham, String maSanPham, String tenSanpham) {
        this.idSanPham = idSanPham;
        this.maSanPham = maSanPham;
        this.tenSanpham = tenSanpham;
    }

    public SanPham(Long idSanPham, String maSanPham, String tenSanpham, Integer soLuong, Date ngayTao, String nguoiTao, int trangThai) {
        this.idSanPham = idSanPham;
        this.maSanPham = maSanPham;
        this.tenSanpham = tenSanpham;
        this.soLuong = soLuong;
        this.ngayTao = ngayTao;
        this.nguoiTao = nguoiTao;
        this.trangThai = trangThai;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public Long getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(Long idSanPham) {
        this.idSanPham = idSanPham;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanpham() {
        return tenSanpham;
    }

    public void setTenSanpham(String tenSanpham) {
        this.tenSanpham = tenSanpham;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }
    
    public Object[] toDataRow () {
        return new Object[] {
            this.getMaSanPham(),
            this.getTenSanpham(),
            this.getSoLuong(),
            this.getNgayTao(),
            this.getNguoiTao(),
            this.getTrangThai() == 0 ? "Con Hang" : "Het Hang"
        };
    }

    @Override
    public String toString() {
        return  tenSanpham ;
    }
}
