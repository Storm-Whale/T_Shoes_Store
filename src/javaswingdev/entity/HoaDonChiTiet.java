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
 * @author DEll
 */
public class HoaDonChiTiet {

    private Long id;
    private HoaDon IdHoaDon;
    private SanPhamChiTiet IdCTSP;
    private Integer soLuong;
    private String maPGG;
    private Integer loaiPGG;
    private BigDecimal giaTriPGG;
    private BigDecimal quyDoiPGGTT;
    private BigDecimal GiaBan;
    private BigDecimal DonGia;
    private BigDecimal thanhTien;
    private Date ngayTao;
    private Integer trangThai;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(HoaDon IdHoaDon, SanPhamChiTiet IdCTSP, Integer soLuong) {
        this.IdHoaDon = IdHoaDon;
        this.IdCTSP = IdCTSP;
        this.soLuong = soLuong;
    }

    public HoaDonChiTiet(HoaDon IdHoaDon, SanPhamChiTiet IdCTSP, Integer soLuong, String maPGG, Integer loaiPGG, BigDecimal giaTriPGG, BigDecimal quyDoiPGGTT, BigDecimal GiaBan, BigDecimal DonGia, Integer trangThai) {
        this.IdHoaDon = IdHoaDon;
        this.IdCTSP = IdCTSP;
        this.soLuong = soLuong;
        this.maPGG = maPGG;
        this.loaiPGG = loaiPGG;
        this.giaTriPGG = giaTriPGG;
        this.quyDoiPGGTT = quyDoiPGGTT;
        this.GiaBan = GiaBan;
        this.DonGia = DonGia;
        this.trangThai = trangThai;
    }

    public HoaDonChiTiet(HoaDon IdHoaDon, SanPhamChiTiet IdCTSP, Integer soLuong, String maPGG, Integer loaiPGG, BigDecimal giaTriPGG, BigDecimal quyDoiPGGTT, BigDecimal GiaBan, BigDecimal DonGia, BigDecimal thanhTien) {
        this.IdHoaDon = IdHoaDon;
        this.IdCTSP = IdCTSP;
        this.soLuong = soLuong;
        this.maPGG = maPGG;
        this.loaiPGG = loaiPGG;
        this.giaTriPGG = giaTriPGG;
        this.quyDoiPGGTT = quyDoiPGGTT;
        this.GiaBan = GiaBan;
        this.DonGia = DonGia;
        this.thanhTien = thanhTien;

    }

    public HoaDonChiTiet(Long id, HoaDon IdHoaDon, SanPhamChiTiet IdCTSP, Integer soLuong, String maPGG, Integer loaiPGG, BigDecimal giaTriPGG, BigDecimal quyDoiPGGTT, BigDecimal GiaBan, BigDecimal DonGia, BigDecimal thanhTien) {
        this.id = id;
        this.IdHoaDon = IdHoaDon;
        this.IdCTSP = IdCTSP;
        this.soLuong = soLuong;
        this.maPGG = maPGG;
        this.loaiPGG = loaiPGG;
        this.giaTriPGG = giaTriPGG;
        this.quyDoiPGGTT = quyDoiPGGTT;
        this.GiaBan = GiaBan;
        this.DonGia = DonGia;
        this.thanhTien = thanhTien;
    }

    public BigDecimal getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(BigDecimal thanhTien) {
        this.thanhTien = thanhTien;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public HoaDon getIdHoaDon() {
        return IdHoaDon;
    }

    public void setIdHoaDon(HoaDon IdHoaDon) {
        this.IdHoaDon = IdHoaDon;
    }

    public SanPhamChiTiet getIdCTSP() {
        return IdCTSP;
    }

    public void setIdCTSP(SanPhamChiTiet IdCTSP) {
        this.IdCTSP = IdCTSP;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getMaPGG() {
        return maPGG;
    }

    public void setMaPGG(String maPGG) {
        this.maPGG = maPGG;
    }

    public Integer getLoaiPGG() {
        return loaiPGG;
    }

    public void setLoaiPGG(Integer loaiPGG) {
        this.loaiPGG = loaiPGG;
    }

    public BigDecimal getGiaTriPGG() {
        return giaTriPGG;
    }

    public void setGiaTriPGG(BigDecimal giaTriPGG) {
        this.giaTriPGG = giaTriPGG;
    }

    public BigDecimal getQuyDoiPGGTT() {
        return quyDoiPGGTT;
    }

    public void setQuyDoiPGGTT(BigDecimal quyDoiPGGTT) {
        this.quyDoiPGGTT = quyDoiPGGTT;
    }

    public BigDecimal getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(BigDecimal GiaBan) {
        this.GiaBan = GiaBan;
    }

    public BigDecimal getDonGia() {
        return DonGia;
    }

    public void setDonGia(BigDecimal DonGia) {
        this.DonGia = DonGia;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public Object[] rowDataGioHang(int i) {
        String str = "";
        if (loaiPGG != null) {
            if (loaiPGG == 0) {
                str = " ( " + (giaTriPGG == null ? 0 : giaTriPGG) + " %)  ";
            } else if (loaiPGG == 1) {
                str = " VND ";
            }
        } else {
            str = "Không có";
        }
//        float tenSize = (IdCTSP.getIdKichThuoc().getIdSize() != null) ? IdCTSP.getIdKichThuoc().getTenSize() : 0.0f;
        return new Object[]{
            i,
            IdCTSP.getMaSPCT(),
            IdCTSP.getIdSanPham().getTenSanpham(),
            DonGia,
            soLuong,
            this.getIdCTSP().getIdKichThuoc().getTenSize(),
            Format.format1((DonGia.subtract(GiaBan))) + str,
            Format.format(GiaBan),
            Format.format(thanhTien)

        };
    }

    public Object[] rowDataHD(int index) {
        return new Object[]{
            index, IdCTSP.getMaSPCT(), IdCTSP.getIdSanPham().getTenSanpham(), soLuong, Format.format(GiaBan), Format.format(thanhTien)
        };
    }

    @Override
    public String toString() {
        return "ChiTietHoaDon{" + "id=" + id + ", IdHoaDon=" + IdHoaDon + ", IdCTSP=" + IdCTSP + ", soLuong=" + soLuong + ", maPGG=" + maPGG + ", loaiPGG=" + loaiPGG + ", giaTriPGG=" + giaTriPGG + ", quyDoiPGGTT=" + quyDoiPGGTT + ", GiaBan=" + GiaBan + ", DonGia=" + DonGia + ", thanhTien=" + thanhTien + ", ngayTao=" + ngayTao + ", trangThai=" + trangThai + '}';
    }

    public Object[] rowDataTraHang(int i) {
        return new Object[]{
            i,
            IdCTSP.getMaSPCT(),
            IdCTSP.getIdSanPham().getTenSanpham(),
            soLuong,
            Format.format(GiaBan),
            Format.format(thanhTien)
        };
    }
}
