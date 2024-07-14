package javaswingdev.service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.entity.HoaDonChiTiet;
import javaswingdev.entity.KichThuoc;
import javaswingdev.entity.SanPham;
import javaswingdev.entity.SanPhamChiTiet;

public class ChiTietHoaDonService {

    private String query = null;
    private Statement stm = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;
    private Connection con = null;

    public List<HoaDonChiTiet> getAllHDCT(String maHD) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        try {
            query = "SELECT HDCT.ID , MaSPCT , TenSP , HDCT.DonGia , HDCT.GiaBan , HDCT.SoLuong , HDCT.LoaiPGG ,\n"
                    + "                    HDCT.GiaTriPGG , HDCT.ThanhTien FROM HOADONCHITIET AS HDCT \n"
                    + "                    JOIN HOADON AS HD ON HD.ID = HDCT.IdHD\n"
                    + "                    JOIN SANPHAMCHITIET AS SPCT ON SPCT.ID = HDCT.IdSPCT\n"
                    + "                   JOIN SANPHAM AS SP ON SP.ID = SPCT.IdSP \n"
                    + "                    WHERE HD.MaHoaDon LIKE '\" + maHD + \"'";
            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet chiTietHoaDon = new HoaDonChiTiet();
                SanPham sanPham = new SanPham(rs.getString("TenSP"));
                SanPhamChiTiet sanPhamChiTiet = new SanPhamChiTiet();
                sanPhamChiTiet.setIdSanPham(sanPham);
                sanPhamChiTiet.setMaSPCT(rs.getString("MaSPCT"));
                chiTietHoaDon.setIdCTSP(sanPhamChiTiet);
                chiTietHoaDon.setId(rs.getLong("ID"));
                chiTietHoaDon.setDonGia(rs.getBigDecimal("DonGia"));
                chiTietHoaDon.setGiaBan(rs.getBigDecimal("GiaBan"));
                chiTietHoaDon.setSoLuong(rs.getInt("SoLuong"));
                chiTietHoaDon.setLoaiPGG(rs.getInt("LoaiPGG"));
                chiTietHoaDon.setGiaTriPGG(rs.getBigDecimal("GiaTriPGG"));
                chiTietHoaDon.setThanhTien(rs.getBigDecimal("ThanhTien"));
                list.add(chiTietHoaDon);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public int insertCTHD(HoaDonChiTiet chiTietHoaDon) {

        try {
            query = "INSERT INTO HOADONCHITIET ( IdHD , IdSPCT , SoLuong , MaPGG , LoaiPGG , GiaTriPGG , QuyDoiPGGTT  , DonGia , GiaBan, ThanhTien) VALUES \n"
                    + "	(? , ? , ? , ? , ? , ? , ? , ? , ? , ?)";
            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);
            pstm.setLong(1, chiTietHoaDon.getIdHoaDon().getId());
            pstm.setLong(2, chiTietHoaDon.getIdCTSP().getIdSPCT());
            pstm.setInt(3, chiTietHoaDon.getSoLuong());
            pstm.setString(4, chiTietHoaDon.getMaPGG());
            pstm.setObject(5, chiTietHoaDon.getLoaiPGG());
            pstm.setBigDecimal(6, chiTietHoaDon.getGiaTriPGG());
            pstm.setBigDecimal(7, chiTietHoaDon.getQuyDoiPGGTT());
            pstm.setBigDecimal(8, chiTietHoaDon.getDonGia());
            pstm.setBigDecimal(9, chiTietHoaDon.getGiaBan());
            pstm.setBigDecimal(10, chiTietHoaDon.getThanhTien());
            return pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonService.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public SanPhamChiTiet getSLSPByMa(String ma) {
        SanPhamChiTiet sanPhamChiTiet = new SanPhamChiTiet();
        try {
            query = "SELECT ID , MaSPCT , SoLuongTon FROM SANPHAMCHITIET\n"
                    + "WHERE MaSPCT LIKE '" + ma + "';";
            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            if (rs.next()) {
                sanPhamChiTiet.setIdSPCT(rs.getLong("ID"));
                sanPhamChiTiet.setMaSPCT(rs.getString("MaSPCT"));
                sanPhamChiTiet.setSoLuong(rs.getInt("SoLuongTon"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sanPhamChiTiet;
    }

    public void updateSL_Ban(Long id, int soLuong, BigDecimal tt) {
        try {
            con = DBConnect.getConnect();
            query = "update HOADONCHITIET\n"
                    + "set SoLuong = ?, ThanhTien = ? \n"
                    + "where ID = ? ";
            pstm = con.prepareStatement(query);
            pstm.setInt(1, soLuong);
            pstm.setLong(3, id);
            pstm.setBigDecimal(2, tt);
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<HoaDonChiTiet> findByIDHD(Long idHD) {
        List<HoaDonChiTiet> listCTHD = new ArrayList<>();
        try {
            query = "SELECT HDCT.ID , MaSPCT ,SPCT.IdSize, SP.ID as idSP,TenSP , HDCT.DonGia , HDCT.GiaBan , HDCT.SoLuong , HDCT.LoaiPGG ,"
                    + " HDCT.GiaTriPGG, HDCT.ThanhTien FROM HOADONCHITIET AS HDCT \n"
                    + "JOIN HOADON AS HD ON HD.ID = HDCT.IdHD\n"
                    + "JOIN SANPHAMCHITIET AS SPCT ON SPCT.ID = HDCT.IdSPCT\n"
                    + "JOIN SANPHAM AS SP ON SP.ID = SPCT.IdSP \n"
                    + "WHERE hd.id = ?";
            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);
            pstm.setLong(1, idHD);
            rs = pstm.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet chiTietHoaDon = new HoaDonChiTiet();
                SanPham sanPham = new SanPham(rs.getString("TenSP"));
                sanPham.setIdSanPham(rs.getLong("idSP"));
                SanPhamChiTiet sanPhamChiTiet = new SanPhamChiTiet();
                sanPhamChiTiet.setIdSanPham(sanPham);
                sanPhamChiTiet.setMaSPCT(rs.getString("MaSPCT"));
                
                KichThuoc kt = new KichThuoc();
                kt.setIdSize(rs.getLong("IdSize"));
                sanPhamChiTiet.setIdKichThuoc(kt);
                
                chiTietHoaDon.setIdCTSP(sanPhamChiTiet);
                chiTietHoaDon.setId(rs.getLong("ID"));
                chiTietHoaDon.setDonGia(rs.getBigDecimal("DonGia"));
                chiTietHoaDon.setGiaBan(rs.getBigDecimal("GiaBan"));
                chiTietHoaDon.setSoLuong(rs.getInt("SoLuong"));
                chiTietHoaDon.setLoaiPGG(rs.getInt("LoaiPGG"));
                chiTietHoaDon.setGiaTriPGG(rs.getBigDecimal("GiaTriPGG"));
                chiTietHoaDon.setThanhTien(rs.getBigDecimal("ThanhTien"));
                listCTHD.add(chiTietHoaDon);
            }
            return listCTHD;
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public Long getIDSPCT(Long id) {
        try {
            query = "SELECT IdSPCT FROM HOADONCHITIET\n"
                    + " WHERE IdHD = ?";
            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);
            pstm.setLong(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                return rs.getLong("IdSPCT");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1L;
    }

    public int deleteHDCT(Long idHD) {
        try {
            query = "DELETE FROM HOADONCHITIET WHERE  IDHD = ? ";
            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);

            pstm.setLong(1, idHD);
            return pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonService.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public int deleteSPTrongGH(Long idHD, Long IdHDCT, Long idSPCT) {
        try {
            query = "DELETE FROM HOADONCHITIET WHERE IdHD = ? AND ID = ? AND IdSPCT = ?";
            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);

            pstm.setLong(1, idHD);
            pstm.setLong(2, IdHDCT);
            pstm.setLong(3, idSPCT);
            return pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonService.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
}
