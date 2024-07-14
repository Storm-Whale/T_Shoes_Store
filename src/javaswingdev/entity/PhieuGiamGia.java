/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaswingdev.entity;

import Utils.Format;
import Utils.PGG_TrangThai;
import java.math.BigDecimal;
import java.util.Date;
import javaswingdev.service.PGG_Service;

/**
 *
 * @author ADMIN
 */
public class PhieuGiamGia {

    private Long id;
    private NhanVien idNV;
    private String maPGG;
    private String tenPGG;
    private int loaiPGG;
    private BigDecimal giaTri;
    private int soLuongPhieu;
    private BigDecimal donToiThieu;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private Date ngayTao;
    private String moTa;
    private int trangThai;

    public PhieuGiamGia() {
    }

    public PhieuGiamGia(NhanVien idNV, String maPGG, String tenPGG, int loaiPGG, BigDecimal giaTri, int soLuongPhieu, BigDecimal donToiThieu, Date ngayBatDau, Date ngayKetThuc, String moTa, int trangThai) {
        this.idNV = idNV;
        this.maPGG = maPGG;
        this.tenPGG = tenPGG;
        this.loaiPGG = loaiPGG;
        this.giaTri = giaTri;
        this.soLuongPhieu = soLuongPhieu;
        this.donToiThieu = donToiThieu;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public PhieuGiamGia(NhanVien idNV, String maPGG, String tenPGG, int loaiPGG, BigDecimal giaTri, int soLuongPhieu, BigDecimal donToiThieu, Date ngayBatDau, Date ngayKetThuc, Date ngayTao, String moTa, int trangThai) {
        this.idNV = idNV;
        this.maPGG = maPGG;
        this.tenPGG = tenPGG;
        this.loaiPGG = loaiPGG;
        this.giaTri = giaTri;
        this.soLuongPhieu = soLuongPhieu;
        this.donToiThieu = donToiThieu;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.ngayTao = ngayTao;
        this.moTa = moTa;
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

    public String getMaPGG() {
        return maPGG;
    }

    public void setMaPGG(String maPGG) {
        this.maPGG = maPGG;
    }

    public String getTenPGG() {
        return tenPGG;
    }

    public void setTenPGG(String tenPGG) {
        this.tenPGG = tenPGG;
    }

    public int getLoaiPGG() {
        return loaiPGG;
    }

    public void setLoaiPGG(int loaiPGG) {
        this.loaiPGG = loaiPGG;
    }

    public BigDecimal getGiaTri() {
        return giaTri;
    }

    public void setGiaTri(BigDecimal giaTri) {
        this.giaTri = giaTri;
    }

    public int getSoLuongPhieu() {
        return soLuongPhieu;
    }

    public void setSoLuongPhieu(int soLuongPhieu) {
        this.soLuongPhieu = soLuongPhieu;
    }

    public BigDecimal getDonToiThieu() {
        return donToiThieu;
    }

    public void setDonToiThieu(BigDecimal donToiThieu) {
        this.donToiThieu = donToiThieu;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getTrangThaiString() {
        String trangThai = "";
        if (this.trangThai == PGG_TrangThai.sapDienRa) {
            trangThai = "Sắp diễn ra";
        }
        if (this.trangThai == PGG_TrangThai.dangDienRa) {
            trangThai = "Đang diễn ra";
        }
        if (this.trangThai == PGG_TrangThai.daHetHan) {
            trangThai = "Đã hết hạn";
        }
        return trangThai;
    }
    public NhanVien getNhanVien() {
        NhanVien nv = PGG_Service.getNhanVien(this.id);
        return nv;
    }

    public Object[] rowDate(int i) {
        return new Object[]{
            i, idNV.getHoTenNV(), maPGG, tenPGG, loaiPGG == 0 ? "%" : "VND",
            giaTri, soLuongPhieu, Format.format(donToiThieu), ngayBatDau, ngayKetThuc, ngayTao, moTa, getTrangThaiString()
        };
    }

    public Object[] rowDataKH_BH(int i) {
        return new Object[]{
            i, maPGG, tenPGG, loaiPGG == 0 ? "Phần trăm ( % )" : " VNĐ ", loaiPGG == 0 ? giaTri + " ( % ) " : Format.format1(giaTri) + " VNĐ ", Format.format(donToiThieu)
        };
    }

    @Override
    public String toString() {
        return "PhieuGiamGia{" + "id=" + id + ", idNV=" + idNV + ", maPGG=" + maPGG + ", tenPGG=" + tenPGG + ", loaiPGG=" + loaiPGG + ", giaTri=" + giaTri + ", soLuongPhieu=" + soLuongPhieu + ", donToiThieu=" + donToiThieu + ", ngayBatDau=" + ngayBatDau + ", ngayKetThuc=" + ngayKetThuc + ", ngayTao=" + ngayTao + ", moTa=" + moTa + ", trangThai=" + trangThai + '}';
    }

}
