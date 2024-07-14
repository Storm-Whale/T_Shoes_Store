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
public class SanPhamChiTiet {

    private Long idSPCT;
    private PhieuGiamGia idPGG;
    private String maSPCT;
    private int soLuong;
    private BigDecimal giaBan;
    private BigDecimal giaNiemYet;
    private int TrangThai;
    private String moTa;
    private MauSac idMau;
    private KichThuoc idKichThuoc;
    private ThuongHieu idThuongHieu;
    private ChatLieu idChatLieu;
    private SanPham idSanPham;
    private Date ngayTao;
    private String nguoiTao;

    public SanPhamChiTiet() {
    }

    public SanPhamChiTiet(Long idSPCT, String maSPCT, int soLuong, BigDecimal giaBan, BigDecimal giaNiemYet, int TrangThai, String moTa, MauSac idMau, KichThuoc idKichThuoc, ThuongHieu idThuongHieu, SanPham idSanPham) {
        this.idSPCT = idSPCT;
        this.maSPCT = maSPCT;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.giaNiemYet = giaNiemYet;
        this.TrangThai = TrangThai;
        this.moTa = moTa;
        this.idMau = idMau;
        this.idKichThuoc = idKichThuoc;
        this.idThuongHieu = idThuongHieu;
        this.idSanPham = idSanPham;
    }

    public SanPhamChiTiet(String maSPCT, int soLuong, BigDecimal giaBan, BigDecimal giaNiemYet, int TrangThai, String moTa, MauSac idMau, KichThuoc idKichThuoc, ThuongHieu idThuongHieu, SanPham idSanPham) {
        this.maSPCT = maSPCT;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.giaNiemYet = giaNiemYet;
        this.TrangThai = TrangThai;
        this.moTa = moTa;
        this.idMau = idMau;
        this.idKichThuoc = idKichThuoc;
        this.idThuongHieu = idThuongHieu;
        this.idSanPham = idSanPham;
    }

    public SanPhamChiTiet(Long idSPCT, PhieuGiamGia idPGG, String maSPCT, int soLuong, BigDecimal giaBan, BigDecimal giaNiemYet, SanPham idSanPham) {
        this.idSPCT = idSPCT;
        this.idPGG = this.idPGG;
        this.maSPCT = maSPCT;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.giaNiemYet = giaNiemYet;
        this.idSanPham = idSanPham;
    }

    public SanPhamChiTiet(Long idSPCT, PhieuGiamGia idPGG, String maSPCT, BigDecimal giaBan, BigDecimal giaNiemYet, SanPham idSanPham) {
        this.idSPCT = idSPCT;
        this.idPGG = this.idPGG;
        this.maSPCT = maSPCT;
        this.giaBan = giaBan;
        this.giaNiemYet = giaNiemYet;
        this.idSanPham = idSanPham;
    }

    public SanPhamChiTiet(Long idSPCT, String maSPCT, int soLuong, BigDecimal giaBan, BigDecimal giaNiemYet, MauSac idMau, KichThuoc idKichThuoc, ThuongHieu idThuongHieu, SanPham idSanPham) {
        this.idSPCT = idSPCT;
        this.maSPCT = maSPCT;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.giaNiemYet = giaNiemYet;
        this.idMau = idMau;
        this.idKichThuoc = idKichThuoc;
        this.idThuongHieu = idThuongHieu;
        this.idSanPham = idSanPham;

    }

    public SanPhamChiTiet(Long idSPCT, PhieuGiamGia idPGG, String maSPCT, int soLuong, BigDecimal giaBan, BigDecimal giaNiemYet, MauSac idMau, KichThuoc idKichThuoc, ThuongHieu idThuongHieu, SanPham idSanPham) {
        this.idSPCT = idSPCT;
        this.idPGG = idPGG;
        this.maSPCT = maSPCT;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.giaNiemYet = giaNiemYet;

        this.idMau = idMau;
        this.idKichThuoc = idKichThuoc;
        this.idThuongHieu = idThuongHieu;
        this.idSanPham = idSanPham;
    }

    public SanPhamChiTiet(Long idSPCT, PhieuGiamGia idPGG, String maSPCT, int soLuong, BigDecimal giaBan, BigDecimal giaNiemYet, int TrangThai, String moTa, MauSac idMau, KichThuoc idKichThuoc, ThuongHieu idThuongHieu, ChatLieu idChatLieu, SanPham idSanPham, Date ngayTao, String nguoiTao) {
        this.idSPCT = idSPCT;
        this.idPGG = idPGG;
        this.maSPCT = maSPCT;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.giaNiemYet = giaNiemYet;
        this.TrangThai = TrangThai;
        this.moTa = moTa;
        this.idMau = idMau;
        this.idKichThuoc = idKichThuoc;
        this.idThuongHieu = idThuongHieu;
        this.idChatLieu = idChatLieu;
        this.idSanPham = idSanPham;
        this.ngayTao = ngayTao;
        this.nguoiTao = nguoiTao;
    }
    
    

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public ChatLieu getIdChatLieu() {
        return idChatLieu;
    }

    public void setIdChatLieu(ChatLieu idChatLieu) {
        this.idChatLieu = idChatLieu;
    }

    public PhieuGiamGia getIdPGG() {
        return idPGG;
    }

    public void setIdPGG(PhieuGiamGia idPGG) {
        this.idPGG = idPGG;
    }

    public String getNguoiTao() {
        return nguoiTao;
    }

    public void setNguoiTao(String nguoiTao) {
        this.nguoiTao = nguoiTao;
    }

    public Long getIdSPCT() {
        return idSPCT;
    }

    public void setIdSPCT(Long idSPCT) {
        this.idSPCT = idSPCT;
    }

    public PhieuGiamGia getIdDGG() {
        return idPGG;
    }

    public void setIdDGG(PhieuGiamGia idPGG) {
        this.idPGG = idPGG;
    }

    public String getMaSPCT() {
        return maSPCT;
    }

    public void setMaSPCT(String maSPCT) {
        this.maSPCT = maSPCT;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

    public BigDecimal getGiaNiemYet() {
        return giaNiemYet;
    }

    public void setGiaNiemYet(BigDecimal giaNiemYet) {
        this.giaNiemYet = giaNiemYet;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public MauSac getIdMau() {
        return idMau;
    }

    public void setIdMau(MauSac idMau) {
        this.idMau = idMau;
    }

    public KichThuoc getIdKichThuoc() {
        return idKichThuoc;
    }

    public void setIdKichThuoc(KichThuoc idKichThuoc) {
        this.idKichThuoc = idKichThuoc;
    }

    public ThuongHieu getIdThuongHieu() {
        return idThuongHieu;
    }

    public void setIdThuongHieu(ThuongHieu idThuongHieu) {
        this.idThuongHieu = idThuongHieu;
    }

    public SanPham getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(SanPham idSanPham) {
        this.idSanPham = idSanPham;
    }

    public Object[] rowDataSPBH() {

        return new Object[]{
            maSPCT, idSanPham.getTenSanpham(), idMau.getTenMau(), idKichThuoc.getTenSize(), idThuongHieu.getTenThuongHieu(), soLuong, Format.format(giaNiemYet), TrangThai == 0 ? "Còn hàng" : "Hết hàng"
        };
    }

    public Object[] rowDataSPCT() {

        return new Object[]{
            maSPCT,
            idThuongHieu.getTenThuongHieu(),
            idMau.getTenMau(),
            idKichThuoc.getTenSize(),
            idChatLieu.getTenCL(),
            this.getSoLuong(),
            Format.format(giaBan),
            this.getNgayTao(),
            this.getNguoiTao(),
            TrangThai == 0 ? "Còn hàng" : "Hết hàng"
        };
    }

    public Object[] rowDataViewPGG() {
        return new Object[]{
            maSPCT, idSanPham.getTenSanpham(), giaNiemYet, idThuongHieu.getTenThuongHieu(), idMau.getTenMau(), idKichThuoc.getTenSize(), false
        };
    }

    public Object[] rowDataPGG(int index) {
        return new Object[]{
            false, index, maSPCT, idSanPham.getTenSanpham(), giaBan, idThuongHieu.getTenThuongHieu(), idMau.getTenMau(), idKichThuoc.getTenSize()
        };
    }

    @Override
    public String toString() {
        return "ChiTietSanPham_M{" + "idSPCT=" + idSPCT + ", idPGG=" + idPGG + ", maSPCT=" + maSPCT + ", soLuong=" + soLuong + ", giaBan=" + giaBan + ", giaNiemYet=" + giaNiemYet + ", TrangThai=" + TrangThai + ", moTa=" + moTa + ", idMau="/* + idMau.getIdMau() + ", idKichThuoc=" + idKichThuoc.getIdSize() + ", idThuongHieu=" + idThuongHieu.getIdThuongHieu() + ", idSanPham=" + idSanPham.getIdSanPham() + */ + '}';
    }
}
