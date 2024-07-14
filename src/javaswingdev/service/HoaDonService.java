package javaswingdev.service;

import Utils.XDate;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.entity.HoaDon;
import javaswingdev.entity.KhachHang;
import javaswingdev.entity.NhanVien;
import javaswingdev.entity.PhieuGiamGia;

public class HoaDonService {

    private String query = null;
    private Statement stm = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;
    private Connection con = null;

    public List<HoaDon> getAllHDByTrangThai2(int trangThai, Long idNv) {
        List<HoaDon> listHD = new ArrayList<>();
        try {
            query = "SELECT HD.ID AS IDHD , KH.ID AS IdKH , NV.ID AS IdNV ,\n"
                    + "HD.NgayTao , HD.TrangThai , HD.MaHoaDon ,  \n"
                    + "NV.HoTenNV , NV.MaNV , \n"
                    + "KH.TenKH , KH.MaKH\n"
                    + "FROM HOADON AS HD\n"
                    + "JOIN NHANVIEN AS NV ON NV.ID = HD.IdNV\n"
                    + "JOIN KHACHHANG AS KH ON KH.ID = HD.IdKH\n"
                    + "WHERE HD.TrangThai = " + trangThai + "  AND  NV.ID =  " + idNv + " "
                    + " ORDER BY HD.NgayTao DESC";
            con = DBConnect.getConnect();
            pstm = con.prepareCall(query);
            rs = pstm.executeQuery();
            while (rs.next()) {
                KhachHang khachHang = new KhachHang();
                khachHang.setId(rs.getLong("IdKH"));
                khachHang.setTenKH(rs.getString("TenKH"));
                khachHang.setMaKH(rs.getString("MaKH"));
                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(rs.getLong("IdNV"));
                nhanVien.setHoTenNV(rs.getString("HoTenNV"));
                nhanVien.setMaNV(rs.getString("MaNV"));

                HoaDon hoaDon = new HoaDon();
                hoaDon.setId(rs.getLong("IdHD"));
                hoaDon.setIdKH(khachHang);
                hoaDon.setIdNV(nhanVien);
                hoaDon.setMaHoaDon(rs.getString("MaHoaDon"));
                hoaDon.setNgayTao(rs.getDate("NgayTao"));
                hoaDon.setTrangThai(rs.getInt("TrangThai"));
                listHD.add(hoaDon);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonService.class.getName()).log(Level.SEVERE, null, ex);

        }
        return listHD;
    }

    public Integer getHoaDonTreo() {
        Integer slHD = 0;
        try {

            query = "SELECT COUNT (*) as SLHD\n"
                    + "FROM HOADON AS HD\n"
                    + "WHERE HD.TrangThai = 0";
            con = DBConnect.getConnect();
            pstm = con.prepareCall(query);
            rs = pstm.executeQuery();
            if (rs.next()) {
                slHD = rs.getInt("SLHD");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return slHD;
    }

    public Integer getHoaDonTrao(int trangThai, Long idNv) {
        Integer slHD = 0;
        try {

            query = "SELECT COUNT (*) as SLHD\n"
                    + "FROM HOADON AS HD\n"
                    + "JOIN NHANVIEN AS NV ON NV.ID = HD.IdNV\n"
                    + "JOIN KHACHHANG AS KH ON KH.ID = HD.IdKH\n"
                    + "WHERE HD.TrangThai = " + trangThai + " AND NV.ID = " + idNv + "";
            con = DBConnect.getConnect();
            pstm = con.prepareCall(query);
            rs = pstm.executeQuery();
            if (rs.next()) {
                slHD = rs.getInt("SLHD");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return slHD;
    }

    public List<HoaDon> findHoaDonByTranThai() {
        List<HoaDon> listHoaDon = new ArrayList<>();
        query = "SELECT HD.ID AS IDHD , KH.ID AS IdKH , NV.ID AS IdNV, HD.NgayTao , HD.TrangThai , HD.MaHoaDon, NV.HoTenNV , NV.MaNV,\n"
                + "KH.TenKH , KH.MaKH\n"
                + " FROM [dbo].[HOADON] hd\n"
                + "JOIN NHANVIEN nv on hd.IdNV = nv.ID\n"
                + "JOIN KHACHHANG kh on hd.IdKH = kh.id\n"
                + "WHERE hd.TrangThai = 0";
        try {
            PreparedStatement ppstm = DBConnect.getConnect().prepareStatement(query);
            ResultSet rs = ppstm.executeQuery();
            while (rs.next()) {
                KhachHang khachHang = new KhachHang();
                khachHang.setId(rs.getLong("IdKH"));
                khachHang.setTenKH(rs.getString("TenKH"));
                khachHang.setMaKH(rs.getString("MaKH"));
                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(rs.getLong("IdNV"));
                nhanVien.setHoTenNV(rs.getString("HoTenNV"));
                nhanVien.setMaNV(rs.getString("MaNV"));

                HoaDon hoaDon = new HoaDon();
                hoaDon.setIdNV(nhanVien);
                hoaDon.setIdKH(khachHang);
                hoaDon.setMaHoaDon(rs.getString("MaHoaDon"));
                hoaDon.setId(rs.getLong("IDHD"));
                hoaDon.setNgayTao(rs.getDate("NgayTao"));
                hoaDon.setTrangThai(rs.getInt("TrangThai"));

                listHoaDon.add(hoaDon);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listHoaDon;
    }

    public int getRowCountHD() {
        String countSql = "SELECT COUNT(*) AS totalRows FROM HOADON";
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

    public int create(HoaDon hoaDon) {
        try {
            query = " INSERT INTO HOADON( IdNV , IdKH, MaHoaDon, ThanhTien ) VALUES \n"
                    + "	(? , ? , ?, ? ) ";
            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);
            // pstm.setObject(1, hoaDon.getIdPGG().getIdPGG());
            pstm.setLong(1, hoaDon.getIdNV().getId());
            pstm.setLong(2, hoaDon.getIdKH().getId());
            pstm.setString(3, hoaDon.getMaHoaDon());
            pstm.setBigDecimal(4, hoaDon.getThanhTien());
            
            return pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonService.class.getName()).log(Level.SEVERE, null, ex);
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

    public Integer getSoLuongGH(Long maHD, Long maSP) {
        Integer sl = 0;
        try {

            query = "SELECT SoLuong AS SL FROM HOADONCHITIET \n"
                    + "WHERE IdHD = ? AND IdSPCT = ?;";
            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);
            pstm.setLong(1, maHD);
            pstm.setLong(2, maSP);
            rs = pstm.executeQuery();
            if (rs.next()) {
                sl = rs.getInt("SL");

            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sl;
    }

    public int getIDHDByMaHD(String maHD) {
        try {
            query = "SELECT ID FROM HoaDon \n"
                    + " where MaHoaDon Like  '" + maHD + "'";
            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            if (rs.next()) {
                return rs.getInt("ID");
            }
            return -1;
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonService.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public void updateSLGH(Long id, Integer soLuong, BigDecimal tt) {
        try {
            query = "UPDATE HOADONCHITIET\n"
                    + "SET  SoLuong = ?\n"
                    + ", ThanhTien = ?\n"
                    + "WHERE IdSPCT = '" + id + "'";
            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);
            pstm.setInt(1, soLuong);
            pstm.setBigDecimal(2, tt);
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateHDBy(KhachHang khachHang, String maHD) {
        try {
            query = "UPDATE HOADON\n"
                    + "SET IdKH = ? \n"
                    + "WHERE MaHoaDon LIKE ?";
            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);
            pstm.setLong(1, khachHang.getId());
            pstm.setString(2, maHD);
            pstm.execute();

        } catch (SQLException ex) {
            Logger.getLogger(HoaDonService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int getTrangThaiHD(String maHD) {
        try {
            con = DBConnect.getConnect();
            query = "SELECT TrangThai FROM HOADON\n"
                    + "WHERE MaHoaDon LIKE '" + maHD + "' ";
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            if (rs.next()) {
                return rs.getInt("TrangThai");
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public Long findIDByMaHD(String maHoaDon) {
        Long id = 0L;
        try {
            query = "SELECT ID FROM HOADON WHERE MaHoaDon LIKE '" + maHoaDon + "'";
            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            if (rs.next()) {
                id = rs.getLong("ID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public Integer hartDeleteHoaDon(Long idHD) {
        try {
            query = "DELETE FROM HOADON WHERE ID = ? ";
            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);

            pstm.setLong(1, idHD);
            return pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonService.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public void updateIdDGGInHDByMaHD(String maHd, PhieuGiamGia giamGia) {
        try {
            query = "UPDATE HOADON\n"
                    + "SET IdPGG = ? , TienPhieuGiam = ?\n"
                    + "WHERE MaHoaDon LIKE ? ";
            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);
            pstm.setLong(1, giamGia.getId());
            if (giamGia.getLoaiPGG() == 0) {

                pstm.setObject(2, 0);
            } else if (giamGia.getLoaiPGG() == 1) {

                pstm.setObject(2, giamGia.getGiaTri());

            }
            pstm.setObject(3, maHd);

            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Integer getSoLuongTon(String ma) {
        Integer sl = 0;
        try {
            query = "select SoLuongTon from SANPHAMCHITIET\n"
                    + "where MaSPCT like '" + ma + "' ;";
            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            if (rs.next()) {
                sl = rs.getInt("SoLuongTon");
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sl;
    }

    public int thanh_toanHD(HoaDon hoaDon) {
        try {
            query = "UPDATE HOADON\n"
                    + "SET  PhuongThucTT = ? , TienKhDua = ? , TienKhChuyenKhoan = ? ,TienThua = ?  , NgayThanhToan = ? , TrangThai = ? , ThanhTien = ? \n"
                    + "WHERE MaHoaDon LIKE ? ";
            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);
            pstm.setObject(1, hoaDon.getPhuongThucTT());
            pstm.setObject(2, hoaDon.getTienKhDua());
            pstm.setObject(3, hoaDon.getTienKhChuyenKhoan());
            pstm.setObject(4, hoaDon.getTienThua());
            pstm.setObject(5, hoaDon.getNgayThanhToan());
            pstm.setObject(6, hoaDon.getTrangThai());
            pstm.setObject(7, hoaDon.getThanhTien());
            pstm.setObject(8, hoaDon.getMaHoaDon());
            return pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public Long getPPGByMaHD(String ma) {
        Long tt = null;
        try {
            query = "SELECT IdPGG FROM HOADON\n"
                    + "	WHERE MaHoaDon LIKE '" + ma + "'";
            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            if (rs.next()) {
                tt = rs.getLong("IdPGG");
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tt;
    }

    public PhieuGiamGia getPGGByID_BH(Long id) {
        PhieuGiamGia phieuGiamGia = new PhieuGiamGia();
        try {
            con = DBConnect.getConnect();
            query = "SELECT ID , MaPGG , TenPGG , LoaiPGG , GiaTri , SoLuongPhieu , DonToiThieu  FROM PHIEUGIAMGIA\n"
                    + "WHERE ID = " + id + " ";
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            if (rs.next()) {
                phieuGiamGia.setId(rs.getLong("ID"));
                phieuGiamGia.setMaPGG(rs.getString("MaPGG"));
                phieuGiamGia.setTenPGG(rs.getString("TenPGG"));
                phieuGiamGia.setLoaiPGG(rs.getInt("LoaiPGG"));
                phieuGiamGia.setGiaTri(rs.getBigDecimal("GiaTri"));
                phieuGiamGia.setSoLuongPhieu(rs.getInt("SoLuongPhieu"));
                phieuGiamGia.setDonToiThieu(rs.getBigDecimal("DonToiThieu"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return phieuGiamGia;
    }

    public List<HoaDon> getAll_HD(String tt, int page, int limt) {
        List<HoaDon> list = new ArrayList<>();
        try {
            query = "SELECT HD.ID , MaHoaDon , MaNV , KH.MaKH ,  KH.SDT , HD.ThanhTien , HD.NgayTao , HD.NgayThanhToan , HD.TrangThai FROM HOADON AS HD \n"
                    + "JOIN NHANVIEN AS NV ON NV.ID = HD.IdNV \n"
                    + "JOIN KHACHHANG AS KH ON KH.ID = HD.IdKH \n"
                    + " WHERE MaKH like ? or MaNV like ? or KH.SDT like ? or  HD.MaHoaDon like  ? "
                    + " order by HD.ID DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY ";

            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);
            pstm.setString(1, "%" + tt + "%");
            pstm.setString(2, "%" + tt + "%");
            pstm.setString(3, "%" + tt + "%");
            pstm.setString(4, "%" + tt + "%");
            pstm.setInt(5, (page - 1) * limt);
            pstm.setInt(6, limt);
            rs = pstm.executeQuery();
            while (rs.next()) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setMaNV(rs.getString("MaNV"));
                KhachHang khachHang = new KhachHang();
                khachHang.setMaKH(rs.getString("MaKH"));
                HoaDon hoaDon = new HoaDon();
                hoaDon.setId(rs.getLong("ID"));
                hoaDon.setMaHoaDon(rs.getString("MaHoaDon"));
                hoaDon.setThanhTien(rs.getBigDecimal("ThanhTien"));
                hoaDon.setNgayTao(rs.getDate("NgayTao"));
                hoaDon.setNgayThanhToan(rs.getDate("NgayThanhToan"));
                hoaDon.setTrangThai(rs.getInt("TrangThai"));
                hoaDon.setIdKH(khachHang);
                hoaDon.setIdNV(nhanVien);
                list.add(hoaDon);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<HoaDon> getAll_Loc(Date ngayBD, Date ngayKT,int trangThai, int page, int lmit) {
        List<HoaDon> list = new ArrayList<>();

        List<String> wheres = new ArrayList<>();
        String where = "";
        try {
            query = "SELECT HD.id AS IdHD, NV.id AS IdNV, KH.ID AS IdKH, KH.MaKH,\n"
                    + "NV.MaNV , MaHoaDon , ThanhTien , HD.NgayTao , NgayThanhToan , HD.TrangThai\n"
                    + "FROM HOADON AS HD\n"
                    + "JOIN NHANVIEN AS NV ON NV.id = HD.IdNV\n"
                    + "JOIN KHACHHANG AS KH ON KH.ID = HD.IdKH ";
            con = DBConnect.getConnect();

            if (ngayBD == null && ngayKT == null  && trangThai == -1) {
                query += "order by IdHD DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
                pstm = con.prepareStatement(query);
                pstm.setInt(1, (page - 1) * lmit);
                pstm.setInt(2, lmit);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    NhanVien nhanVien = new NhanVien();
                    nhanVien.setId(rs.getLong("IdNV"));
                    nhanVien.setMaNV(rs.getString("MaNV"));

                    KhachHang khachHang = new KhachHang();
                    khachHang.setId(rs.getLong("IdKH"));

                    khachHang.setMaKH(rs.getString("MaKH"));
                    HoaDon hoaDon = new HoaDon();
                    hoaDon.setId(rs.getLong("IdHD"));
                    hoaDon.setIdKH(khachHang);
                    hoaDon.setIdNV(nhanVien);
                    hoaDon.setMaHoaDon(rs.getString("MaHoaDon"));
                    hoaDon.setThanhTien(rs.getBigDecimal("ThanhTien"));
                    hoaDon.setNgayTao(rs.getDate("NgayTao"));
                    hoaDon.setNgayThanhToan(rs.getDate("NgayThanhToan"));
                    hoaDon.setTrangThai(rs.getInt("TrangThai"));
                    list.add(hoaDon);
                }
                return list;

            }

            if (ngayBD != null && ngayKT != null) {
                wheres.add("( HD.NgayTao BETWEEN  ? AND ?  ) ");
            }

            if (trangThai != -1) {
                wheres.add("HD.TrangThai = ? ");
            }
            int count = 0;
            for (int i = 0; i < wheres.size(); i++) {
                int checkLast = (wheres.size() - 1);
                where += wheres.get(i);
                if (i != checkLast && wheres.size() != 1) {
                    where += " AND ";
                }
                count++;
            }

            query += "WHERE " + where + " order by IdHD DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";;
            System.out.println(query);
            pstm = con.prepareStatement(query);

            if (ngayBD == null && ngayKT == null && (trangThai != -1)) {
                System.out.println("javaswingdev.service.PhieuGiamGiaService.getListLoc()" + 6);
                pstm.setInt(1, trangThai);
                pstm.setInt(2, (page - 1) * lmit);
                pstm.setInt(3, lmit);

            }

            if (ngayBD == null && ngayKT == null && trangThai == -1) {
                System.out.println("javaswingdev.service.PhieuGiamGiaService.getListLoc()" + 7);
                pstm.setInt(1, (page - 1) * lmit);
                pstm.setInt(2, lmit);

            }

//            if (ngayBD == null && ngayKT == null && trangThai != -1) {
//                System.out.println("javaswingdev.service.PhieuGiamGiaService.getListLoc()" + 8);
//                pstm.setInt(1, trangThai);
//                pstm.setInt(2, (page - 1) * lmit);
//                pstm.setInt(3, lmit);
//
//            }
            if (ngayBD != null && ngayKT != null && (trangThai != -1)) {
                System.out.println("javaswingdev.service.PhieuGiamGiaService.getListLoc()" + 1);
                pstm.setString(1, XDate.toString(ngayBD, "MM-dd-yyyy"));
                pstm.setString(2, XDate.toString(ngayKT, "MM-dd-yyyy"));
                pstm.setInt(3, trangThai);
                pstm.setInt(4, (page - 1) * lmit);
                pstm.setInt(5, lmit);

            }
            if (ngayBD != null && ngayKT != null && trangThai == -1) {
                System.out.println("javaswingdev.service.PhieuGiamGiaService.getListLoc()" + 2);
                pstm.setString(1, XDate.toString(ngayBD, "MM-dd-yyyy"));
                pstm.setString(2, XDate.toString(ngayKT, "MM-dd-yyyy"));
                pstm.setInt(3, (page - 1) * lmit);
                pstm.setInt(4, lmit);

                System.out.println("javaswingdev.service.PhieuGiamGiaService.getListLoc()" + 2);
            }
            if (ngayBD != null && ngayKT != null && trangThai != -1) {
                System.out.println("javaswingdev.service.PhieuGiamGiaService.getListLoc()" + 3);
                pstm.setString(1, XDate.toString(ngayBD, "MM-dd-yyyy"));
                pstm.setString(2, XDate.toString(ngayKT, "MM-dd-yyyy"));
                pstm.setInt(3, trangThai);
                pstm.setInt(4, (page - 1) * lmit);
                pstm.setInt(5, lmit);

            }
            if (ngayBD != null && ngayKT != null && (trangThai == -1)) {
                System.out.println("javaswingdev.service.PhieuGiamGiaService.getListLoc()" + 4);

                pstm.setString(1, XDate.toString(ngayBD, "MM-dd-yyyy"));
                pstm.setString(2, XDate.toString(ngayKT, "MM-dd-yyyy"));
                pstm.setInt(3, (page - 1) * lmit);
                pstm.setInt(4, lmit);

            }

            rs = pstm.executeQuery();
            while (rs.next()) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(rs.getLong("IdNV"));
                nhanVien.setMaNV(rs.getString("MaNV"));

                KhachHang khachHang = new KhachHang();
                khachHang.setId(rs.getLong("IdKH"));

                khachHang.setMaKH(rs.getString("MaKH"));
                HoaDon hoaDon = new HoaDon();
                hoaDon.setId(rs.getLong("IdHD"));
                hoaDon.setIdKH(khachHang);
                hoaDon.setIdNV(nhanVien);
                hoaDon.setMaHoaDon(rs.getString("MaHoaDon"));
                hoaDon.setThanhTien(rs.getBigDecimal("ThanhTien"));
                hoaDon.setNgayThanhToan(rs.getDate("NgayThanhToan"));
                hoaDon.setNgayTao(rs.getDate("NgayTao"));
                hoaDon.setTrangThai(rs.getInt("TrangThai"));
                list.add(hoaDon);
            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(HoaDonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<HoaDon> getAll_Loc_ALL(Date ngayBD, Date ngayKT, int trangThai) {
        List<HoaDon> list = new ArrayList<>();

        List<String> wheres = new ArrayList<>();
        String where = "";
        try {
            query = "SELECT HD.id AS IdHD, NV.id AS IdNV, KH.ID AS IdKH, KH.MaKH,\n"
                    + "NV.MaNV , MaHoaDon , ThanhTien , HD.NgayTao , NgayThanhToan , HD.TrangThai\n"
                    + "FROM HOADON AS HD\n"
                    + "JOIN NHANVIEN AS NV ON NV.id = HD.IdNV\n"
                    + "JOIN KHACHHANG AS KH ON KH.ID = HD.IdKH ";
            con = DBConnect.getConnect();

            if (ngayBD == null && ngayKT == null && trangThai == -1) {
                //  query += "order by IdHD DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
                pstm = con.prepareStatement(query);
//                pstm.setInt(1, (page - 1) * lmit);
//                pstm.setInt(2, lmit);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    NhanVien nhanVien = new NhanVien();
                    nhanVien.setId(rs.getLong("IdNV"));
                    nhanVien.setMaNV(rs.getString("MaNV"));

                    KhachHang khachHang = new KhachHang();
                    khachHang.setId(rs.getLong("IdKH"));

                    khachHang.setMaKH(rs.getString("MaKH"));
                    HoaDon hoaDon = new HoaDon();
                    hoaDon.setId(rs.getLong("IdHD"));
                    hoaDon.setIdKH(khachHang);
                    hoaDon.setIdNV(nhanVien);
                    hoaDon.setMaHoaDon(rs.getString("MaHoaDon"));
                    hoaDon.setThanhTien(rs.getBigDecimal("ThanhTien"));
                    hoaDon.setNgayTao(rs.getDate("NgayTao"));
                    hoaDon.setNgayThanhToan(rs.getDate("NgayThanhToan"));
                    hoaDon.setTrangThai(rs.getInt("TrangThai"));
                    list.add(hoaDon);
                }
                return list;

            }

            if (ngayBD != null && ngayKT != null) {
                wheres.add("( HD.NgayTao BETWEEN  ? AND ?  ) ");
            }
            if (trangThai != -1) {
                wheres.add("HD.TrangThai = ? ");
            }
            int count = 0;
            for (int i = 0; i < wheres.size(); i++) {
                int checkLast = (wheres.size() - 1);
                where += wheres.get(i);
                if (i != checkLast && wheres.size() != 1) {
                    where += " AND ";
                }
                count++;
            }

            query += "WHERE " + where;
            System.out.println(query);
            pstm = con.prepareStatement(query);

            if (ngayBD == null && ngayKT == null && (trangThai != -1)) {
                System.out.println("javaswingdev.service.PhieuGiamGiaService.getListLoc()" + 6);
                pstm.setInt(1, trangThai);

            }

//            if (ngayBD == null && ngayKT == null && loaiHD != -1 && trangThai == -1) {
//                System.out.println("javaswingdev.service.PhieuGiamGiaService.getListLoc()" + 7);
//                pstm.setInt(1, loaiHD);
//
//            }
//
            if (ngayBD == null && ngayKT == null && trangThai != -1) {
                System.out.println("javaswingdev.service.PhieuGiamGiaService.getListLoc()" + 7);
                pstm.setInt(1, trangThai);
            }

            if (ngayBD != null && ngayKT != null && (trangThai != -1)) {
                System.out.println("javaswingdev.service.PhieuGiamGiaService.getListLoc()" + 1);
                pstm.setString(1, XDate.toString(ngayBD, "MM-dd-yyyy"));
                pstm.setString(2, XDate.toString(ngayKT, "MM-dd-yyyy"));
                pstm.setInt(3, trangThai);

            }
            if (ngayBD != null && ngayKT != null && trangThai == -1) {
                System.out.println("javaswingdev.service.PhieuGiamGiaService.getListLoc()" + 2);
                pstm.setString(1, XDate.toString(ngayBD, "MM-dd-yyyy"));
                pstm.setString(2, XDate.toString(ngayKT, "MM-dd-yyyy"));

                System.out.println("javaswingdev.service.PhieuGiamGiaService.getListLoc()" + 2);
            }
            if (ngayBD != null && ngayKT != null && trangThai != -1) {
                System.out.println("javaswingdev.service.PhieuGiamGiaService.getListLoc()" + 3);
                pstm.setString(1, XDate.toString(ngayBD, "MM-dd-yyyy"));
                pstm.setString(2, XDate.toString(ngayKT, "MM-dd-yyyy"));
                pstm.setInt(3, trangThai);

            }
            if (ngayBD != null && ngayKT != null && (trangThai == -1)) {
                System.out.println("javaswingdev.service.PhieuGiamGiaService.getListLoc()" + 4);

                pstm.setString(1, XDate.toString(ngayBD, "MM-dd-yyyy"));
                pstm.setString(2, XDate.toString(ngayKT, "MM-dd-yyyy"));

            }

            rs = pstm.executeQuery();
            while (rs.next()) {
                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(rs.getLong("IdNV"));
                nhanVien.setMaNV(rs.getString("MaNV"));

                KhachHang khachHang = new KhachHang();
                khachHang.setId(rs.getLong("IdKH"));

                khachHang.setMaKH(rs.getString("MaKH"));
                HoaDon hoaDon = new HoaDon();
                hoaDon.setId(rs.getLong("IdHD"));
                hoaDon.setIdKH(khachHang);
                hoaDon.setIdNV(nhanVien);
                hoaDon.setMaHoaDon(rs.getString("MaHoaDon"));
                hoaDon.setThanhTien(rs.getBigDecimal("ThanhTien"));

                hoaDon.setNgayTao(rs.getDate("NgayTao"));
                hoaDon.setTrangThai(rs.getInt("TrangThai"));
                list.add(hoaDon);
            }
            return list;

        } catch (SQLException ex) {
            Logger.getLogger(HoaDonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

//    public int updateHD(HoaDon hoaDon) {
//        try {
//            query = " UPDATE HOADON  SET IdNV = ? , IdKH = ? , CapBac = ? , TienPhieuGiam = ? , PhanTramGia = ? , DiemDoi = ? ,\n"
//                    + "		PhuongThucTT = ? , TienKhDua = ?  , TienKhChuyenKhoan = ? , TienThua = ? , ThanhTien = ? ,\n"
//                    + "		NgayThanhToan = ? , TrangThai = 1 \n"
//                    + "		WHERE MaHoaDon like ?";
//            con = DBConnection.getConnect();
//            pstm = con.prepareStatement(query);
//            pstm.setLong(1, hoaDon.getIdNV().getId());
//            pstm.setLong(2, hoaDon.getIdKH().getId());
//            pstm.setInt(3, hoaDon.getCapBac());
//            pstm.setBigDecimal(4, hoaDon.getTienPhieuGiam());
//            pstm.setFloat(5, hoaDon.getPhanTramGG());
//
//            pstm.setBigDecimal(6, hoaDon.getDiemDoi());
//            pstm.setInt(7, hoaDon.getPhuongThucTT());
//            pstm.setBigDecimal(8, hoaDon.getTienKhDua());
//            pstm.setBigDecimal(9, hoaDon.getTienKhChuyenKhoan());
//            pstm.setBigDecimal(10, hoaDon.getTienThua());
//            pstm.setBigDecimal(11, hoaDon.getThanhTien());
//            pstm.setString(12, XDate.toString(hoaDon.getNgayThanhToan(), "yyyy-MM-dd HH:mm:ss.SSS"));
//
//            pstm.setString(13, hoaDon.getMaHoaDon());
//            return pstm.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(HoaDon_MRepositoryM.class.getName()).log(Level.SEVERE, null, ex);
//            return -1;
//        }
//    }
    public void updateTTHD(String maHD, int trangThai) {
        try {
            query = "UPDATE HOADON \n"
                    + "SET TrangThai = ? \n"
                    + "WHERE MaHoaDon LIKE  ?";
            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);
            pstm.setInt(1, trangThai);
            pstm.setString(2, maHD);
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateTTHD2(String maHD, int trangThai) {
        try {
            query = "UPDATE HOADON\n"
                    + "SET TrangThai = ? , TienKhDua = ThanhTien ,  NgayThanhToan = getdate()\n"
                    + "WHERE MaHoaDon LIKE  ? ;";
            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);
            pstm.setInt(1, trangThai);
            pstm.setString(2, maHD);
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

//    public int create(HoaDon hoaDon) {
//        try {
//            query = " INSERT INTO HOADON( IdNV , IdKH, MaHoaDon , QR ) VALUES \n"
//                    + "	(? , ? , ? , ?) ";
//            con = DBConnection.getConnect();
//            pstm = con.prepareStatement(query);
//            // pstm.setObject(1, hoaDon.getIdPGG().getIdPGG());
//            pstm.setLong(1, hoaDon.getIdNV().getId());
//            pstm.setLong(2, hoaDon.getIdKH().getId());
//            pstm.setString(3, hoaDon.getMaHoaDon());
//            pstm.setString(4, hoaDon.getQr());
//            return pstm.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(HoaDon_MRepositoryM.class.getName()).log(Level.SEVERE, null, ex);
//            return -1;
//        } finally {
//            try {
//                if (rs != null && !rs.isClosed()) {
//                    rs.close();
//                }
//                if (stm != null && !stm.isClosed()) {
//                    stm.close();
//                }
//                if (pstm != null && !pstm.isClosed()) {
//                    pstm.close();
//                }
//                if (con != null && !con.isClosed()) {
//                    con.close();
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(KhachHangRepositoryM.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    
//   
    public List<HoaDon> findHDbyIDKH(Long idKH) {
        List<HoaDon> listHD = new ArrayList<>();
        try {
            query = "SELECT ID, IdNV, MaHoaDon, PhuongThucTT, ThanhTien, TrangThai FROM [dbo].[HOADON] WHERE IdKH = ?";
            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);
            pstm.setLong(1, idKH);
            rs = pstm.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setId(rs.getLong(1));
                hd.setMaHoaDon(rs.getString(3));
                hd.setPhuongThucTT(rs.getInt(4));
                hd.setThanhTien(rs.getBigDecimal(5));
                hd.setTrangThai(rs.getInt(6));
                NhanVien nv = new NhanVien();
                nv.setId(rs.getLong(2));
                hd.setIdNV(nv);
                listHD.add(hd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HoaDonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listHD;
    }
}
