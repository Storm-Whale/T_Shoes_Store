package javaswingdev.service;

import Utils.XDate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.entity.KhachHang;
import javaswingdev.entity.NhanVien;

public class KhachHangService {

    private String query = null;
    private Statement stm = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;
    private Connection con = null;

    public List<KhachHang> getAll() {
        try {
            query = "select KH.ID as ID , NV.ID as IdNV , MaKH , TenKH , KH.GioiTinh as GioiTinh , KH.SDT as SDT  , KH.DiaChi as DiaChi, KH.Email as Email, KH.NgaySinh as NgaySinh from KHACHHANG as KH\n"
                    + "                    	join NHANVIEN as NV on NV.ID = KH.IdNV";
            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            List<KhachHang> list = new ArrayList<>();
            while (rs.next()) {
                KhachHang khachHang = new KhachHang(rs.getLong("ID"), new NhanVien(rs.getLong("IdNV")),
                        rs.getString("MaKH"), rs.getString("TenKH"),
                        rs.getString("SDT"),
                        rs.getDate("NgaySinh"),
                        rs.getBoolean("GioiTinh"),
                        rs.getString("Email"),
                        rs.getString("DiaChi"));
                list.add(khachHang);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
                if (stm != null && !stm.isClosed()) {
                    stm.close();
                }
                if (pstm != null && !pstm.isClosed()) {
                    pstm.close();
                }
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhachHangService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public int getRowCountKH() {
        String countSql = "SELECT COUNT(*) AS totalRows FROM KHACHHANG";
        con = DBConnect.getConnect();
        try {
            stm = con.createStatement();
            rs = stm.executeQuery(countSql);
            int totalRows = 0;
            if (rs.next()) {
                return totalRows = rs.getInt("totalRows");
            }
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangService.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
                if (stm != null && !stm.isClosed()) {
                    stm.close();
                }
                if (pstm != null && !pstm.isClosed()) {
                    pstm.close();
                }
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhachHangService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public int insertAll(KhachHang khachHang) {
        try {
            query = "INSERT INTO KHACHHANG ( IdNV ,  MaKH , TenKH, SDT, NgaySinh , GioiTinh, Email , DiaChi ) \n"
                    + "	VALUES (?,  ? , ? , ?, ? , ?, ? , ?) ";
            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);
            pstm.setLong(1, khachHang.getIdNV().getId());
            pstm.setString(2, khachHang.getMaKH());
            pstm.setString(3, khachHang.getTenKH());
            pstm.setString(4, khachHang.getSdt());
            pstm.setString(5, XDate.toString(khachHang.getNgaySinh(), "MM-dd-yyyy"));
            pstm.setInt(6, khachHang.isGioiTinh() ? 1 : 0);
            pstm.setString(7, khachHang.getEmail());
            pstm.setString(8, khachHang.getDiaChi());
            return pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangService.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
                if (stm != null && !stm.isClosed()) {
                    stm.close();
                }
                if (pstm != null && !pstm.isClosed()) {
                    pstm.close();
                }
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhachHangService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public List<KhachHang> listSearch(String thongTin) {
        try {
            query = "SELECT ID, IdNV , MaKH , TenKH  , SDT , GioiTinh , NgaySinh , Email , DiaChi FROM KHACHHANG \n"
                    + "                      WHERE MaKH LIKE ? OR TenKH LIKE ? OR SDT LIKE  ? ";
            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);
            pstm.setString(1, "%" + thongTin + "%");
            pstm.setString(2, "%" + thongTin + "%");
            pstm.setString(3, "%" + thongTin + "%");
            rs = pstm.executeQuery();
            List<KhachHang> list = new ArrayList<>();
            while (rs.next()) {
                KhachHang khachHang = new KhachHang(new NhanVien(rs.getLong("IdNV")),
                        rs.getString("MaKhachHang"), rs.getString("TenKhachHang"), rs.getString("SDT"),
                        rs.getDate("NgaySinh"),
                        rs.getString("Email"), rs.getBoolean("GioiTinh"),
                        rs.getString("DiaChi"));
                list.add(khachHang);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
                if (stm != null && !stm.isClosed()) {
                    stm.close();
                }
                if (pstm != null && !pstm.isClosed()) {
                    pstm.close();
                }
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhachHangService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public KhachHang findKhBySDT(String sdt) {
        KhachHang khachHang = new KhachHang();
        try {
            query = "SELECT ID , MaKH , TenKH , SDT , Email , DiaChi   FROM KHACHHANG\n"
                    + "WHERE SDT LIKE '" + sdt + "';";
            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            if (rs.next()) {
                khachHang.setId(rs.getLong("ID"));
                khachHang.setMaKH(rs.getString("MaKH"));
                khachHang.setTenKH(rs.getString("TenKH"));
                khachHang.setSdt(rs.getString("SDT"));
                khachHang.setEmail(rs.getString("Email"));
                khachHang.setDiaChi(rs.getString("DiaChi"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return khachHang;
    }

    public int insertKH_BH(KhachHang khachHang) {
        try {
            query = "INSERT INTO  KHACHHANG  ( IdNV ,MaKH , TenKH , SDT) VALUES \n"
                    + "(? , ? , ? ,?)";
            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);
            pstm.setLong(1, khachHang.getIdNV().getId());
            pstm.setString(2, khachHang.getMaKH());
            pstm.setString(3, khachHang.getTenKH());
            pstm.setString(4, khachHang.getSdt());
            return pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangService.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public KhachHang findKHByMaKH(String maKH) {
        KhachHang khachHang = new KhachHang();
        try {
            query = "SELECT ID , MaKH , TenKH , SDT , Email , DiaChi   FROM KHACHHANG\n"
                    + "WHERE MaKH LIKE '" + maKH + "';";
            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            if (rs.next()) {
                khachHang.setId(rs.getLong("ID"));
                khachHang.setMaKH(rs.getString("MaKH"));
                khachHang.setTenKH(rs.getString("TenKH"));
                khachHang.setSdt(rs.getString("SDT"));
                khachHang.setEmail(rs.getString("Email"));
                khachHang.setDiaChi(rs.getString("DiaChi"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return khachHang;
    }
    
    public List<KhachHang> getAll2() {
        try {
            query = "select KH.ID as ID , NV.ID as IdNV , MaKH , TenKH , KH.GioiTinh as GioiTinh , KH.SDT as SDT  , KH.DiaChi as DiaChi, KH.Email as Email, KH.NgaySinh as NgaySinh from KHACHHANG as KH\n"
                    + "	join NHANVIEN as NV on NV.ID = KH.IdNV\n";

            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            List<KhachHang> list = new ArrayList<>();
            while (rs.next()) {
                KhachHang khachHang = new KhachHang(rs.getLong("ID"), new NhanVien(rs.getLong("IdNV")),
                        rs.getString("MaKH"), rs.getString("TenKH"),
                        rs.getString("SDT"),
                        rs.getDate("NgaySinh"),
                        rs.getBoolean("GioiTinh"),
                        rs.getString("Email"),
                        rs.getString("DiaChi"));
                list.add(khachHang);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(KhachHangService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
                if (stm != null && !stm.isClosed()) {
                    stm.close();
                }
                if (pstm != null && !pstm.isClosed()) {
                    pstm.close();
                }
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(KhachHangService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    private Connection conn = DBConnect.getConnect();

    public List<KhachHang> findAll() {
        List<KhachHang> listKH = new ArrayList<>();
        String sql = "SELECT * FROM dbo.KHACHHANG";
        try {
            PreparedStatement ppstm = conn.prepareStatement(sql);
            ResultSet rs = ppstm.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setId(rs.getLong("IdNV"));
                listKH.add(new KhachHang(
                        rs.getLong("ID"),
                        nv,
                        rs.getString("MaKH"),
                        rs.getString("TenKH"),
                        rs.getString("SDT"),
                        rs.getDate("NgaySinh"),
                        rs.getBoolean("GioiTinh"),
                        rs.getString("Email"),
                        rs.getString("DiaChi"),
                        rs.getDate("NgayTao"),
                        rs.getBoolean("TrangThai")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKH;
    }

   public List<KhachHang> findAll(String keyword, Integer gioiTinh, Integer trangThai) {
        List<KhachHang> listKH = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT * FROM dbo.KHACHHANG");

        boolean hasKeyword = keyword != null && !keyword.trim().isEmpty();
        boolean hasGioiTinh = gioiTinh != null;
        boolean hasTrangThai = trangThai != null;

        if (hasKeyword || hasGioiTinh || hasTrangThai) {
            sql.append(" WHERE ");
        }

        List<Object> params = new ArrayList<>();

        if (hasKeyword) {
            sql.append("((MaKH LIKE ?) OR (TenKH LIKE ?) OR (SDT LIKE ?) OR (Email LIKE ?) OR (DiaChi LIKE ?))");
            String keywordPattern = "%" + keyword.trim() + "%";
            for (int i = 0; i < 5; i++) {
                params.add(keywordPattern);
            }
        }

        if (hasTrangThai) {
            if (hasKeyword) {
                sql.append(" AND ");
            }
            sql.append("TrangThai = ?");
            params.add(trangThai);
        }

        if (hasGioiTinh) {
            if (hasKeyword || hasTrangThai) {
                sql.append(" AND ");
            }
            sql.append("GioiTinh = ?");
            params.add(gioiTinh);
        }

        System.out.println("sql : " + sql);

        try (PreparedStatement ppstm = conn.prepareStatement(sql.toString())) {
            for (int i = 0; i < params.size(); i++) {
                ppstm.setObject(i + 1, params.get(i));
            }

            try (ResultSet rs = ppstm.executeQuery()) {
                while (rs.next()) {
                    NhanVien nv = new NhanVien();
                    nv.setId(rs.getLong("IdNV"));
                    listKH.add(new KhachHang(
                            rs.getLong("ID"),
                            nv,
                            rs.getString("MaKH"),
                            rs.getString("TenKH"),
                            rs.getString("SDT"),
                            rs.getDate("NgaySinh"),
                            rs.getBoolean("GioiTinh"),
                            rs.getString("Email"),
                            rs.getString("DiaChi"),
                            rs.getDate("NgayTao"),
                            rs.getBoolean("TrangThai")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKH;
    }

    public Integer addKhachHang(KhachHang kh) {
        Integer row = null;
        String sql = "INSERT INTO KHACHHANG (IdNV, MaKH, TenKH, SDT, NgaySinh, GioiTinh, Email, DiaChi, NgayTao, TrangThai)\n"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try {
            PreparedStatement ppstm = conn.prepareStatement(sql);
            ppstm.setLong(1, kh.getIdNV().getId());
            ppstm.setString(2, kh.getMaKH());
            ppstm.setString(3, kh.getTenKH());
            ppstm.setString(4, kh.getSdt());
            ppstm.setDate(5, new java.sql.Date(kh.getNgaySinh().getTime()));
            ppstm.setBoolean(6, kh.isGioiTinh());
            ppstm.setString(7, kh.getEmail());
            ppstm.setString(8, kh.getDiaChi());
            ppstm.setDate(9, new java.sql.Date(kh.getNgayTao().getTime()));
            ppstm.setBoolean(10, kh.getTrangThai());
            row = ppstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public Integer updateKhachHang(KhachHang kh) {
        Integer row = null;
        String sql = "UPDATE KHACHHANG SET IdNV = ?, MaKH = ?, TenKH = ?, SDT = ?, NgaySinh = ?, GioiTinh = ?, Email = ?, DiaChi = ?, NgayTao = ?, TrangThai = ?\n"
                + "	WHERE ID = ?;";
        try {
            PreparedStatement ppstm = conn.prepareStatement(sql);

            ppstm.setLong(1, kh.getIdNV().getId());
            ppstm.setString(2, kh.getMaKH());
            ppstm.setString(3, kh.getTenKH());
            ppstm.setString(4, kh.getSdt());
            ppstm.setDate(5, new java.sql.Date(kh.getNgaySinh().getTime()));
            ppstm.setBoolean(6, kh.isGioiTinh());
            ppstm.setString(7, kh.getEmail());
            ppstm.setString(8, kh.getDiaChi());
            ppstm.setDate(9, new java.sql.Date(kh.getNgayTao().getTime()));
            ppstm.setBoolean(10, kh.getTrangThai());

            ppstm.setLong(11, kh.getId());
            row = ppstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public Integer sortDeleteKhachHang(KhachHang kh) {
        Integer row = null;
        String sql = "UPDATE KHACHHANG SET TrangThai = 0\n"
                + "	WHERE ID = ?;";
        try {
            PreparedStatement ppstm = conn.prepareStatement(sql);
            ppstm.setLong(1, kh.getId());
            row = ppstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }
}
