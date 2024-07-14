/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaswingdev.entity;

/**
 *
 * @author ADMIN
 */
public class ThuongHieu {

    private Long idThuongHieu;
    private String maThuongHieu;
    private String tenThuongHieu;
    private String nguoiTao;
    private int trangThai;

    public ThuongHieu() {
    }

    public ThuongHieu(Long idThuongHieu) {
        this.idThuongHieu = idThuongHieu;
    }

    public ThuongHieu(Long idThuongHieu, String tenThuongHieu) {
        this.idThuongHieu = idThuongHieu;
        this.tenThuongHieu = tenThuongHieu;
    }

    public ThuongHieu(String maThuongHieu, String tenThuongHieu, int trangThai) {
        this.maThuongHieu = maThuongHieu;
        this.tenThuongHieu = tenThuongHieu;
        this.trangThai = trangThai;
    }

    public ThuongHieu(String tenThuongHieu) {
        this.tenThuongHieu = tenThuongHieu;
    }

    public ThuongHieu(Long idThuongHieu, String maThuongHieu, String tenThuongHieu) {
        this.idThuongHieu = idThuongHieu;
        this.maThuongHieu = maThuongHieu;
        this.tenThuongHieu = tenThuongHieu;
    }

    public ThuongHieu(Long idThuongHieu, String maThuongHieu, String tenThuongHieu, String nguoiTao, int trangThai) {
        this.idThuongHieu = idThuongHieu;
        this.maThuongHieu = maThuongHieu;
        this.tenThuongHieu = tenThuongHieu;
        this.nguoiTao = nguoiTao;
        this.trangThai = trangThai;
    }

    public Long getIdThuongHieu() {
        return idThuongHieu;
    }

    public void setIdThuongHieu(Long idThuongHieu) {
        this.idThuongHieu = idThuongHieu;
    }

    public String getMaThuongHieu() {
        return maThuongHieu;
    }

    public void setMaThuongHieu(String maThuongHieu) {
        this.maThuongHieu = maThuongHieu;
    }

    public String getTenThuongHieu() {
        return tenThuongHieu;
    }

    public void setTenThuongHieu(String tenThuongHieu) {
        this.tenThuongHieu = tenThuongHieu;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return tenThuongHieu + "";
    }
}
