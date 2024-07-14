package javaswingdev.service;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.entity.SanPham;

public class SanPhamService {

    Connection connect = DBConnect.getConnect();

    public ArrayList<SanPham> getToAllSanPham() {
        ArrayList<SanPham> listSanPham = new ArrayList<>();
        String query = "Select ID,MaSP, TenSP, TrangThai from SANPHAM";
        try {
            PreparedStatement ps = connect.prepareCall(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listSanPham.add(new SanPham(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }
        } catch (Exception e) {
            System.out.println("Error at get to all sanPham");
        }
        return listSanPham;
    }

    public Integer getSoLuongSp(String maSpct) {
        Integer soLuong = null;
        String sql = "SELECT sp.SoLuong FROM SANPHAM sp \n"
                + "JOIN SANPHAMCHITIET spct ON spct.IdSP = sp.ID\n"
                + "WHERE spct.MaSPCT = ?";
        try {
            PreparedStatement ppstm = connect.prepareStatement(sql);
            ppstm.setString(1, maSpct);
            ResultSet rs = ppstm.executeQuery();
            while (rs.next()) {
                soLuong = rs.getInt("SoLuong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return soLuong;
    }

    public void updateSoLuongSP(int soLuong, Long idSp) {
        String sql = "UPDATE SANPHAM SET SoLuong = ? WHERE ID = ?";
        try {
            PreparedStatement ppstm = connect.prepareStatement(sql);
            ppstm.setInt(1, soLuong);
            ppstm.setLong(2, idSp);
            ppstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<SanPham> findAllSP() {
        List<SanPham> listSP = new ArrayList<>();
        String sql = "SELECT * FROM [dbo].[SANPHAM]";
        try {
            PreparedStatement ppstm = connect.prepareStatement(sql);
            ResultSet rs = ppstm.executeQuery();
            while (rs.next()) {
                listSP.add(new SanPham(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getInt(7)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSP;
    }

    public List<SanPham> findAllSP(String keyword) {
        List<SanPham> listSP = new ArrayList<>();
        String sql = "SELECT * FROM SANPHAM WHERE MaSP LIKE ? OR TenSP LIKE ? OR NguoiTao LIKE ?";
        try {
            PreparedStatement ppstm = connect.prepareStatement(sql);
            int i = 1;
            ppstm.setString(i++, "%" + keyword + "%");
            ppstm.setString(i++, "%" + keyword + "%");
            ppstm.setString(i++, "%" + keyword + "%");
            ResultSet rs = ppstm.executeQuery();
            while (rs.next()) {
                listSP.add(new SanPham(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getInt(7)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSP;
    }

    public List<SanPham> findAllSPByID(Long id) {
        List<SanPham> listSP = new ArrayList<>();
        String sql = "SELECT * FROM SANPHAM WHERE ID = ?";
        try {
            PreparedStatement ppstm = connect.prepareStatement(sql);
            ppstm.setLong(1, id);
            ResultSet rs = ppstm.executeQuery();
            while (rs.next()) {
                listSP.add(new SanPham(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getInt(7)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSP;
    }

    public Integer addSanPham(SanPham sanPham) {
        Integer row = null;
        String sql = "INSERT INTO dbo.SANPHAM (MaSP, TenSP, SoLuong, NgayTao, NguoiTao, TrangThai)\n"
                + "VALUES (?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement ppstm = connect.prepareStatement(sql);
            ppstm.setString(1, sanPham.getMaSanPham());
            ppstm.setString(2, sanPham.getTenSanpham());
            ppstm.setInt(3, sanPham.getSoLuong());
            ppstm.setString(5, sanPham.getNguoiTao());
            ppstm.setInt(6, sanPham.getTrangThai());

            java.util.Date utilDate = sanPham.getNgayTao();
            if (utilDate != null) {
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                ppstm.setDate(4, sqlDate);
            } else {
                ppstm.setNull(4, java.sql.Types.DATE);
            }

            row = ppstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public Integer updateSanPham(SanPham sanPham) {
        Integer row = null;
        String sql = "UPDATE dbo.SANPHAM\n"
                + "SET MaSP = ?, TenSP = ?, SoLuong = ?, "
                + "TrangThai = ?\n"
                + "WHERE ID = ?;";
        try {
            PreparedStatement ppstm = connect.prepareStatement(sql);
            ppstm.setString(1, sanPham.getMaSanPham());
            ppstm.setString(2, sanPham.getTenSanpham());
            ppstm.setInt(3, sanPham.getSoLuong());
            ppstm.setInt(4, sanPham.getTrangThai());
            ppstm.setLong(5, sanPham.getIdSanPham());
            row = ppstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }
    
        public void updateSL(Long id, int soLuong) {
        try {
            String query;
            query = "update SanPham\n"
                    + "set SoLuong = ? \n"
                    + "where ID = ? ";
            PreparedStatement pstm;
            pstm = connect.prepareStatement(query);
            pstm.setInt(1, soLuong);
            pstm.setLong(2, id);
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
