/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaswingdev.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.entity.HoaDon;
import javaswingdev.entity.HoaDonChiTiet;
import javaswingdev.entity.KhachHang;
import javaswingdev.entity.NhanVien;
import javaswingdev.entity.PhieuGiamGia;
import javaswingdev.entity.SanPham;
import javaswingdev.entity.SanPhamChiTiet;

/**
 *
 * @author ADMIN
 */
public class HoaDonChiTietService {

   
    private String query = null;
    private Statement stm = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;
    private Connection con = null;

    public List<HoaDonChiTiet> getListCTHDByMaHD(String ma) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        try {
            query = "SELECT HDCT.ID AS IDHDCT , SPCT.ID AS IDSPCT , MaSPCT , TenSP , HDCT.SoLuong , HDCT.GiaBan , HD.ThanhTien FROM HOADONCHITIET AS HDCT \n"
                    + "JOIN SANPHAMCHITIET AS SPCT ON SPCT.ID = HDCT.IdSPCT \n"
                    + "JOIN HOADON AS HD ON HD.ID = HDCT.IdHD \n"
                    + "JOIN SANPHAM AS SP ON SP.ID = SPCT.IdSP \n"
                    + "WHERE HD.MaHoaDon LIKE '%" + ma + "%'";
            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet hdct = new HoaDonChiTiet();
                SanPham sanPham = new SanPham(rs.getString("TenSP"));
                SanPhamChiTiet sanPhamChiTiet = new SanPhamChiTiet();
                sanPhamChiTiet.setIdSanPham(sanPham);
                sanPhamChiTiet.setIdSPCT(rs.getLong("IDSPCT"));
                sanPhamChiTiet.setMaSPCT(rs.getString("MaSPCT"));
                hdct.setId(rs.getLong("IDHDCT"));
                hdct.setIdCTSP(sanPhamChiTiet);
                hdct.setSoLuong(rs.getInt("SoLuong"));
                hdct.setGiaBan(rs.getBigDecimal("GiaBan"));
                hdct.setThanhTien(rs.getBigDecimal("ThanhTien"));
                list.add(hdct);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonChiTietService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    
    public HoaDon viewCTHDByMaHD(String maHD) {
        HoaDon hoaDon = new HoaDon();
        try {
            query = "SELECT MaHoaDon , MaKH , TenKH,\n"
                    + "MaNV , NV.HoTenNV , HD.NgayTao , HD.NgayThanhToan,\n"
                    + "HD.ThanhTien , HD.PhuongThucTT , HD.TrangThai, "
                    + "HD.TienKhChuyenKhoan , HD.TienKhDua , HD.TienThua , \n"
                    + "PGG.MaPGG , PGG.LoaiPGG , PGG.GiaTri , HD.TienPhieuGiam\n"
                    + "FROM HOADON AS HD\n"
                    + "LEFT JOIN NHANVIEN  AS NV ON NV.ID = HD.IdNV\n"
                    + "LEFT JOIN KHACHHANG AS KH  ON KH.ID = HD.IdKH\n"
                    + "LEFT JOIN PHIEUGIAMGIA AS PGG ON PGG.ID = HD.IdPGG\n"
                    + "WHERE  HD.MaHoaDon LIKE '%" + maHD + "' ";
            
            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            if (rs.next()) {
                KhachHang khachHang = new KhachHang();
                NhanVien nhanVien = new NhanVien();
                PhieuGiamGia phieuGiamGia = new PhieuGiamGia();
                
                khachHang.setMaKH(rs.getString("MaKH"));
                khachHang.setTenKH(rs.getString("TenKH"));
                
                nhanVien.setMaNV(rs.getString("MaNV"));
                nhanVien.setHoTenNV(rs.getString("HoTenNV"));
                
                phieuGiamGia.setMaPGG(rs.getString("MaPGG"));
                phieuGiamGia.setLoaiPGG(rs.getInt("LoaiPGG"));
                phieuGiamGia.setGiaTri(rs.getBigDecimal("GiaTri"));
                hoaDon.setIdNV(nhanVien);
                hoaDon.setIdKH(khachHang);
                hoaDon.setIdPGG(phieuGiamGia);
                hoaDon.setMaHoaDon(rs.getString("MaHoaDon"));
                hoaDon.setThanhTien(rs.getBigDecimal("ThanhTien"));
                hoaDon.setPhuongThucTT(rs.getInt("PhuongThucTT"));
                hoaDon.setTrangThai(rs.getInt("TrangThai"));
                hoaDon.setTienKhChuyenKhoan(rs.getBigDecimal("TienKhChuyenKhoan"));
                hoaDon.setTienKhDua(rs.getBigDecimal("TienKhDua"));
                hoaDon.setTienThua(rs.getBigDecimal("TienThua"));
                hoaDon.setNgayTao(rs.getDate("NgayTao"));
                hoaDon.setNgayThanhToan(rs.getDate("NgayThanhToan"));
//                hoaDon.setTienPhieuGiam(rs.getBigDecimal("TienPhieuGiam"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonChiTietService.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return hoaDon;
    }
}
