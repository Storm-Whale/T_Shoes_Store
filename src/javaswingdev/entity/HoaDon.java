/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaswingdev.entity;

import Utils.Format;
import java.math.BigDecimal;
import java.util.Date;


/**
 *
 * @author ADMIN
 */
public class HoaDon {

 private Long id;
    private PhieuGiamGia IdPGG;
    private NhanVien IdNV;
    private KhachHang IdKH;
    private String maHoaDon;
    private BigDecimal tienPhieuGiam;
    private Integer phuongThucTT;
    private BigDecimal tongTienSP;
    private BigDecimal tienKhDua;
    private BigDecimal tienKhChuyenKhoan;
    private BigDecimal tienThua;
    private BigDecimal thanhTien;
    private Date ngayTao;
    private Date ngayThanhToan;
    private boolean hinhThucMua;
    private Integer trangThai;

    public HoaDon() {
    }

    public HoaDon(NhanVien IdNV, KhachHang IdKH, String maHoaDon, BigDecimal tienPhieuGiam, Integer phuongThucTT, BigDecimal tienKhDua, BigDecimal tienKhChuyenKhoan, BigDecimal tienThua, BigDecimal thanhTien, Date ngayThanhToan, boolean hinhThucMua, Integer trangThai) {
        this.IdNV = IdNV;
        this.IdKH = IdKH;
        this.maHoaDon = maHoaDon;
        this.tienPhieuGiam = tienPhieuGiam;
        this.phuongThucTT = phuongThucTT;
        this.tienKhDua = tienKhDua;
        this.tienKhChuyenKhoan = tienKhChuyenKhoan;
        this.tienThua = tienThua;
        this.thanhTien = thanhTien;
        this.ngayThanhToan = ngayThanhToan;
        this.hinhThucMua = hinhThucMua;
        this.trangThai = trangThai;
    }

    public HoaDon(PhieuGiamGia IdPGG, NhanVien IdNV, KhachHang IdKH, String maHoaDon) {
        this.IdPGG = IdPGG;
        this.IdNV = IdNV;
        this.IdKH = IdKH;
        this.maHoaDon = maHoaDon;
    }

    public HoaDon(Long id, PhieuGiamGia IdPGG, NhanVien IdNV, KhachHang IdKH, Integer trangThai) {
        this.id = id;
        this.IdPGG = IdPGG;
        this.IdNV = IdNV;
        this.IdKH = IdKH;
        this.trangThai = trangThai;
    }

    public HoaDon(Long id, NhanVien IdNV, KhachHang IdKH, Integer trangThai) {
        this.id = id;
        this.IdNV = IdNV;
        this.IdKH = IdKH;
        this.trangThai = trangThai;
    }

    public HoaDon(Long id, PhieuGiamGia IdPGG, NhanVien IdNV, KhachHang IdKH, String maHoaDon, Date ngayTao, Integer trangThai) {
        this.id = id;
        this.IdPGG = IdPGG;
        this.IdNV = IdNV;
        this.IdKH = IdKH;
        this.maHoaDon = maHoaDon;
        this.ngayTao = ngayTao;
        this.trangThai = trangThai;
    }

    public HoaDon(PhieuGiamGia IdPGG, NhanVien IdNV, KhachHang IdKH, String maHoaDon, BigDecimal tienPhieuGiam, Integer phuongThucTT, BigDecimal tienKhDua, BigDecimal tienKhChuyenKhoan, BigDecimal tienThua, BigDecimal thanhTien, boolean hinhThucMua, Integer trangThai) {
        this.IdPGG = IdPGG;
        this.IdNV = IdNV;
        this.IdKH = IdKH;
        this.maHoaDon = maHoaDon;
        this.tienPhieuGiam = tienPhieuGiam;
        this.phuongThucTT = phuongThucTT;
        this.tienKhDua = tienKhDua;
        this.tienKhChuyenKhoan = tienKhChuyenKhoan;
        this.tienThua = tienThua;
        this.thanhTien = thanhTien;
        this.hinhThucMua = hinhThucMua;
        this.trangThai = trangThai;
    }

    public HoaDon(PhieuGiamGia IdPGG, NhanVien IdNV, KhachHang IdKH, String maHoaDon, BigDecimal tienPhieuGiam, Integer phuongThucTT, BigDecimal tienKhDua, BigDecimal tienKhChuyenKhoan, BigDecimal tienThua, BigDecimal thanhTien, Date ngayThanhToan, boolean hinhThucMua, Integer trangThai) {
        this.IdPGG = IdPGG;
        this.IdNV = IdNV;
        this.IdKH = IdKH;
        this.maHoaDon = maHoaDon;
        this.tienPhieuGiam = tienPhieuGiam;
        this.phuongThucTT = phuongThucTT;
        this.tienKhDua = tienKhDua;
        this.tienKhChuyenKhoan = tienKhChuyenKhoan;
        this.tienThua = tienThua;
        this.thanhTien = thanhTien;
        this.ngayThanhToan = ngayThanhToan;
        this.hinhThucMua = hinhThucMua;
        this.trangThai = trangThai;
    }

    public HoaDon(Long id, PhieuGiamGia IdPGG, NhanVien IdNV, KhachHang IdKH, String maHoaDon, BigDecimal tienPhieuGiam, Integer phuongThucTT, BigDecimal tienKhDua, BigDecimal tienKhChuyenKhoan, BigDecimal tienThua, BigDecimal thanhTien, boolean hinhThucMua, Integer trangThai) {
        this.id = id;
        this.IdPGG = IdPGG;
        this.IdNV = IdNV;
        this.IdKH = IdKH;
        this.maHoaDon = maHoaDon;
        this.tienPhieuGiam = tienPhieuGiam;
        this.phuongThucTT = phuongThucTT;
        this.tienKhDua = tienKhDua;
        this.tienKhChuyenKhoan = tienKhChuyenKhoan;
        this.tienThua = tienThua;
        this.thanhTien = thanhTien;
        this.hinhThucMua = hinhThucMua;
        this.trangThai = trangThai;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PhieuGiamGia getIdPGG() {
        return IdPGG;
    }

    public void setIdPGG(PhieuGiamGia IdPGG) {
        this.IdPGG = IdPGG;
    }

    public NhanVien getIdNV() {
        return IdNV;
    }

    public void setIdNV(NhanVien IdNV) {
        this.IdNV = IdNV;
    }

    public KhachHang getIdKH() {
        return IdKH;
    }

    public void setIdKH(KhachHang IdKH) {
        this.IdKH = IdKH;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public BigDecimal getTienPhieuGiam() {
        return tienPhieuGiam;
    }

    public void setTienPhieuGiam(BigDecimal tienPhieuGiam) {
        this.tienPhieuGiam = tienPhieuGiam;
    }

    public Integer getPhuongThucTT() {
        return phuongThucTT;
    }

    public void setPhuongThucTT(Integer phuongThucTT) {
        this.phuongThucTT = phuongThucTT;
    }

    public BigDecimal getTongTienSP() {
        return tongTienSP;
    }

    public void setTongTienSP(BigDecimal tongTienSP) {
        this.tongTienSP = tongTienSP;
    }

    public BigDecimal getTienKhDua() {
        return tienKhDua;
    }

    public void setTienKhDua(BigDecimal tienKhDua) {
        this.tienKhDua = tienKhDua;
    }

    public BigDecimal getTienKhChuyenKhoan() {
        return tienKhChuyenKhoan;
    }

    public void setTienKhChuyenKhoan(BigDecimal tienKhChuyenKhoan) {
        this.tienKhChuyenKhoan = tienKhChuyenKhoan;
    }

    public BigDecimal getTienThua() {
        return tienThua;
    }

    public void setTienThua(BigDecimal tienThua) {
        this.tienThua = tienThua;
    }

    public BigDecimal getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(BigDecimal thanhTien) {
        this.thanhTien = thanhTien;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public boolean isHinhThucMua() {
        return hinhThucMua;
    }

    public void setHinhThucMua(boolean hinhThucMua) {
        this.hinhThucMua = hinhThucMua;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }


    public String setTrangThaiHD(int trangThaiIP) {
        switch (trangThaiIP) {
            case 0:
                return "Chờ thanh toán";
            case 1:
                return "Đã thanh toán";
            case 2:
                return "Đã hủy";
            default:
                return "Đang nghĩ";
        }
    }

    public Object[] rowDataHDBH(int i) {
        return new Object[]{
            i, maHoaDon, ngayTao, IdNV.getMaNV(), IdKH.getMaKH(), this.setTrangThaiHD(trangThai)
        };
    }

    public Object[] rowDataPGH(int i) {
        return new Object[]{
            i, maHoaDon, ngayTao, IdKH.getTenKH()
        };
    }

    public Object[] rowDataHD(int i) {

        return new Object[]{
            i, maHoaDon, IdNV.getMaNV(), IdKH.getMaKH(), 
            Format.format(thanhTien), 
            ngayTao, ngayThanhToan, setTrangThaiHD(trangThai)
        };
    }

   @Override
    public String toString() {
        return "HoaDon{" + "id=" + id + ", IdPGG=" + IdPGG + ", IdNV=" + IdNV + ", IdKH=" + IdKH + ", maHoaDon=" + maHoaDon + ", tienPhieuGiam=" + tienPhieuGiam + ", phuongThucTT=" + phuongThucTT + ", TienKhDua=" + tienKhDua + ", TienKhChuyenKhoan=" + tienKhChuyenKhoan + ", TienThua=" + tienThua + ", ThanhTien=" + thanhTien + ", NgayTao=" + ngayTao + ", NgayThanhToan=" + ngayThanhToan + ", hinhThucMua=" + hinhThucMua + ", trangThai=" + trangThai + '}';
    }
}
