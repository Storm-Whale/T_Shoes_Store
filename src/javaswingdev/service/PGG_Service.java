package javaswingdev.service;

import Utils.XDate;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javaswingdev.entity.HoaDon;
import javaswingdev.entity.NhanVien;
import javaswingdev.entity.PhieuGiamGia;

public class PGG_Service {

    private String query = null;
    private Statement stm = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;
    private Connection con = null;

    public List<PhieuGiamGia> getALL(BigDecimal donToiThieu) {
        List<PhieuGiamGia> list = new ArrayList<>();
        try {
            query = " SELECT ID, MaPGG, TenPGG, LoaiPGG, GiaTri, SoLuongPhieu, DonToiThieu, TrangThai FROM PHIEUGIAMGIA\n"
                    + " WHERE TrangThai = 1 AND SoLuongPhieu >0 AND DonToiThieu <= ?";
            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);
            pstm.setBigDecimal(1, donToiThieu);
            rs = pstm.executeQuery();
            while (rs.next()) {
                PhieuGiamGia giamGia = new PhieuGiamGia();
                giamGia.setId(rs.getLong("ID"));
                giamGia.setMaPGG(rs.getString("MaPGG"));
                giamGia.setTenPGG(rs.getString("TenPGG"));
                giamGia.setLoaiPGG(rs.getInt("LoaiPGG"));
                giamGia.setGiaTri(rs.getBigDecimal("GiaTri"));
                giamGia.setSoLuongPhieu(rs.getInt("SoLuongPhieu"));
                giamGia.setDonToiThieu(rs.getBigDecimal("DonToiThieu"));
                giamGia.setTrangThai(rs.getInt("TrangThai"));
                list.add(giamGia);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PGG_Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public ArrayList<PhieuGiamGia> getAllPGG(int page, int limt) {
        ArrayList<PhieuGiamGia> listPGG = new ArrayList<>();
        Connection conn = DBConnect.getConnect();
        String sql = "SELECT PGG.ID, NV.HoTenNV, nv.ID as IDNV, MaPGG, TenPGG, LoaiPGG, GiaTri, SoLuongPhieu, DonToiThieu, "
                + "NgayBatDau, NgayKetThuc, PGG.NgayTao, MoTa, PGG.TrangThai FROM PHIEUGIAMGIA AS PGG "
                + "JOIN NHANVIEN AS NV ON NV.ID = PGG.IdNV "
                + "ORDER BY PGG.ID DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";

        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, (page - 1) * limt);
            pstm.setInt(2, limt);
            rs = pstm.executeQuery();
            while (rs.next()) {
                PhieuGiamGia pgg = new PhieuGiamGia();
                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(rs.getLong("IDNV"));
                nhanVien.setHoTenNV(rs.getString("HoTenNV"));
                pgg.setIdNV(nhanVien);
                pgg.setMaPGG(rs.getString("MaPGG"));
                pgg.setTenPGG(rs.getString("TenPGG"));
                pgg.setLoaiPGG(rs.getInt("LoaiPGG"));
                pgg.setGiaTri(rs.getBigDecimal("GiaTri"));
                pgg.setSoLuongPhieu(rs.getInt("SoLuongPhieu"));
                pgg.setDonToiThieu(rs.getBigDecimal("DonToiThieu"));
                pgg.setNgayBatDau(rs.getDate("NgayBatDau"));
                pgg.setNgayKetThuc(rs.getDate("NgayKetThuc"));
                pgg.setNgayTao(rs.getDate("NgayTao"));
                pgg.setMoTa(rs.getString("MoTa"));
                pgg.setTrangThai(rs.getInt("TrangThai"));
                listPGG.add(pgg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPGG;
    }

    public PhieuGiamGia getPGG_BH(String maCTSP) {
        PhieuGiamGia pgg = new PhieuGiamGia();
        try {
            query = "SELECT MaPGG , LoaiPGG , GiaTri  FROM PHIEUGIAMGIA\n"
                    + "                    JOIN SANPHAMCHITIET  AS CTSP ON CTSP.IdPGG = PHIEUGIAMGIA.ID\n"
                    + "                    WHERE MaSPCT LIKE '\" + maCTSP + \"'";
            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            if (rs.next()) {
                pgg.setMaPGG(rs.getString("MaPGG"));
                pgg.setLoaiPGG(rs.getInt("LoaiPGG"));
                pgg.setGiaTri(rs.getBigDecimal("GiaTri"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(PGG_Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pgg;
    }

    public void updateKetThuc(String date) {
        try {
            query = "UPDATE PHIEUGIAMGIA\n"
                    + "SET TrangThai = 2\n"
                    + "WHERE NgayKetThuc <'" + date + "' or SoLuongPhieu =0 ";
            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PGG_Service.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
       public Integer ThemPGG(PhieuGiamGia pgg) {
        Integer row = null;
        Connection conn = DBConnect.getConnect();
        String sql = "INSERT INTO PHIEUGIAMGIA (IdNV , MaPGG , TenPGG , LoaiPGG , GiaTri , SoLuongPhieu , DonToiThieu , NgayBatDau , NgayKetThuc , MoTa)\n"
                + "VALUES (? , ? , ? , ? , ? , ? , ? , ? , ? , ?, ?)";
        try {
            PreparedStatement pr = conn.prepareCall(sql);
            pr.setObject(1, pgg.getIdNV().getId());
            pr.setObject(2, pgg.getMaPGG());
            pr.setObject(3, pgg.getTenPGG());
            pr.setObject(4, pgg.getLoaiPGG());
            pr.setObject(5, pgg.getGiaTri());
            pr.setObject(6, pgg.getSoLuongPhieu());
            pr.setObject(7, pgg.getDonToiThieu());
            pr.setObject(8, pgg.getNgayBatDau());
            pr.setObject(9, pgg.getNgayKetThuc());
            pr.setObject(10, pgg.getMoTa());
//            pr.setObject(11, pgg.setTrangThai(0));
            row = pr.executeUpdate();
        } catch (Exception e) {
        }
        return row;
    }

    public Integer SuaPGG(PhieuGiamGia pgg) {
        Integer row = null;
        Connection conn = DBConnect.getConnect();
        String sql = "UPDATE PHIEUGIAMGIA\n"
                + "SET TenPGG = ? , LoaiPGG = ? , GiaTri =? , SoLuongPhieu = ? , DonToiThieu = ? , NgayBatDau = ? , NgayKetThuc = ? , MoTa =? , TrangThai = ? \n"
                + "WHERE MaPGG LIKE ?";
        try {
            PreparedStatement pr = conn.prepareCall(sql);
            pr.setObject(1, pgg.getTenPGG());
            pr.setObject(2, pgg.getLoaiPGG());
            pr.setObject(3, pgg.getGiaTri());
            pr.setObject(4, pgg.getSoLuongPhieu());
            pr.setObject(5, pgg.getDonToiThieu());
            pr.setObject(6, pgg.getNgayBatDau());
            pr.setObject(7, pgg.getNgayKetThuc());
            pr.setObject(8, pgg.getMoTa());
            pr.setObject(9, pgg.getTrangThai());
            pr.setObject(10, pgg.getMaPGG());

            row = pr.executeUpdate();
        } catch (Exception e) {
        }
        return row;
    }

    public Integer XoaPGG(String ma) {
        Integer row = null;
        Connection conn = DBConnect.getConnect();
        String sql = "DELETE PHIEUGIAMGIA WHERE MaPGG=?";
        try {
            PreparedStatement pr = conn.prepareCall(sql);
            pr.setObject(1, ma);

            row = pr.executeUpdate();
        } catch (Exception e) {
        }
        return row;
    }

    public ArrayList<PhieuGiamGia> getLoc(Date NgayBatDau, Date NgayKetThuc, int LoaiPhieu, int TrangThai) {
        ArrayList<PhieuGiamGia> listPGG = new ArrayList<>();
        Connection conn = DBConnect.getConnect();
        System.out.println(TrangThai);

        try {
            String sql = "Select IdNV, MaPGG, TenPGG, LoaiPGG, GiaTri, SoLuongPhieu, DonToiThieu, NgayBatDau, NgayKetThuc, NgayTao, MoTa, TrangThai from PHIEUGIAMGIA ";
            ArrayList<String> whereQueries = new ArrayList<>();
            String NgayBatDauStr = null, NgayKetThucStr = null;

            if (NgayBatDau != null && NgayKetThuc != null) {
                SimpleDateFormat spd = new SimpleDateFormat("yyyy-MM-dd");
                NgayBatDauStr = spd.format(NgayBatDau);
                NgayKetThucStr = spd.format(NgayKetThuc);

                whereQueries.add("NgayBatDau >= ? AND NgayKetThuc <= ?");
            }
            whereQueries.add("LoaiPGG = ?");
            if (TrangThai != -1) {
                whereQueries.add("TrangThai = ?");
            }
            String whereQuery = "";
            for (int i = 0; i < whereQueries.size(); i++) {
                String dieukien = whereQueries.get(i);
                whereQuery += dieukien;
                if (i != whereQueries.size() - 1) {
                    whereQuery += " AND ";
                }
            }
            System.out.println(whereQuery);

            sql += "WHERE " + whereQuery;

            PreparedStatement pr = conn.prepareStatement(sql);
            if (NgayBatDau != null && NgayKetThuc != null) {
                pr.setObject(1, NgayBatDauStr);
                pr.setObject(2, NgayKetThucStr);
                pr.setObject(3, LoaiPhieu);
                if (TrangThai != -1) {
                    pr.setObject(4, TrangThai);
                }
            } else if (TrangThai != -1) {
                pr.setObject(1, LoaiPhieu);
                pr.setObject(2, TrangThai);
            } else {
                pr.setObject(1, LoaiPhieu);
            }

            //PreparedStatement pr= conn.prepareStatement(sql);
//            pr.setObject(1, dateStart);
//            pr.setObject(2, dateEnd);
//            pr.setObject(3, loai);
//            pr.setObject(4, trangThai);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                PhieuGiamGia pgg = new PhieuGiamGia();
//                NhanVien nv= new NhanVien();
//                nv.setIdNV(rs.getLong(1));
//                  pgg.setIdNV(rs.getLong(1));
                pgg.setMaPGG(rs.getString(2));
                pgg.setTenPGG(rs.getString(3));
                pgg.setLoaiPGG(rs.getInt(4));
                pgg.setGiaTri(rs.getBigDecimal(5));
                pgg.setSoLuongPhieu(rs.getInt(6));
                pgg.setDonToiThieu(rs.getBigDecimal(7));
                pgg.setNgayBatDau(rs.getDate(8));
                pgg.setNgayKetThuc(rs.getDate(9));
                pgg.setNgayTao(rs.getDate(10));
                pgg.setMoTa(rs.getString(11));
                pgg.setTrangThai(rs.getInt(12));

                listPGG.add(pgg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPGG;
    }

    public List<PhieuGiamGia> getListLoc(PhieuGiamGia giamGia, int page, int limt) {
        List<PhieuGiamGia> list = new ArrayList<>();
        query = "SELECT PGG.ID , nv.ID AS IDNV , NV.HoTenNV , MaPGG , TenPGG , LoaiPGG , GiaTri , \n"
                + "SoLuongPhieu , DonToiThieu , NgayBatDau , NgayKetThuc , PGG.NgayTao , MoTa , PGG.TrangThai FROM PHIEUGIAMGIA  AS PGG\n"
                + "JOIN NHANVIEN AS NV ON NV.ID = PGG.IdNV\n";
        ArrayList<String> where = new ArrayList<>();
        String wheres = "";
        con = DBConnect.getConnect();
        try {

            if (giamGia.getNgayBatDau() == null && giamGia.getNgayKetThuc() == null && giamGia.getLoaiPGG() == -1 && giamGia.getTrangThai() == -1) {
                query += "order by ID DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
                System.out.println(query);
                pstm = con.prepareStatement(query);
                pstm.setInt(1, (page - 1) * limt);
                pstm.setInt(2, limt);
                rs = pstm.executeQuery();
                while (rs.next()) {
                    PhieuGiamGia pgg = new PhieuGiamGia();
                    NhanVien nhanVien = new NhanVien();
                    nhanVien.setId(rs.getLong("IDNV"));
                    nhanVien.setHoTenNV(rs.getString("HoVaTen"));
                    pgg.setIdNV(nhanVien);
                    pgg.setMaPGG(rs.getString("MaPGG"));
                    pgg.setTenPGG(rs.getString("TenPGG"));
                    pgg.setLoaiPGG(rs.getInt(("LoaiPGG")));
                    pgg.setGiaTri(rs.getBigDecimal("GiaTri"));
                    pgg.setSoLuongPhieu(rs.getInt("SoLuongPhieu"));
                    pgg.setDonToiThieu(rs.getBigDecimal("DonToiThieu"));
                    pgg.setNgayBatDau(rs.getDate("NgayBatDau"));
                    pgg.setNgayKetThuc(rs.getDate("NgayKetThuc"));
                    pgg.setNgayTao(rs.getDate("NgayTao"));
                    pgg.setMoTa(rs.getString("MoTa"));
                    pgg.setTrangThai(rs.getInt("TrangThai"));
                    list.add(pgg);
                }
                return list;
            }
            if (giamGia.getNgayBatDau() != null && giamGia.getNgayKetThuc() != null) {
                where.add("(NgayBatDau >= ? AND NgayKetThuc <= ? ) ");
            }
            if (giamGia.getLoaiPGG() != -1) {
                where.add("LoaiPGG = ?");
            }
            if (giamGia.getTrangThai() != -1) {
                where.add("PGG.TrangThai = ? ");
            }
            int count = 0;
            for (int i = 0; i < where.size(); i++) {
                int checkLast = (where.size() - 1);
                wheres += where.get(i);
                if (i != checkLast && where.size() != 1) {
                    wheres += " AND ";
                }
                count++;
            }

            query += "WHERE " + wheres + " order by ID OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
            System.out.println(query);
            pstm = con.prepareStatement(query);
            if (giamGia.getNgayBatDau() == null && giamGia.getNgayKetThuc() == null && giamGia.getLoaiPGG() == -1 && (giamGia.getTrangThai() != -1)) {
                System.out.println("javaswingdev.service.PhieuGiamGiaService.getListLoc()" + 6);
                pstm.setInt(1, giamGia.getTrangThai());
                pstm.setInt(2, (page - 1) * limt);
                pstm.setInt(3, limt);
            }

            if (giamGia.getNgayBatDau() == null && giamGia.getNgayKetThuc() == null && giamGia.getLoaiPGG() != -1 && giamGia.getTrangThai() == -1) {
                System.out.println("javaswingdev.service.PhieuGiamGiaService.getListLoc()" + 7);
                pstm.setInt(1, giamGia.getLoaiPGG());
                pstm.setInt(2, (page - 1) * limt);
                pstm.setInt(3, limt);
            }

            if (giamGia.getNgayBatDau() == null && giamGia.getNgayKetThuc() == null && giamGia.getLoaiPGG() != -1 && giamGia.getTrangThai() != -1) {
                System.out.println("javaswingdev.service.PhieuGiamGiaService.getListLoc()" + 8);
                pstm.setInt(1, giamGia.getLoaiPGG());
                // sua
                pstm.setInt(2, giamGia.getTrangThai());
                pstm.setInt(3, (page - 1) * limt);
                pstm.setInt(4, limt);
            }

            if (giamGia.getNgayBatDau() != null && giamGia.getNgayKetThuc() != null && giamGia.getLoaiPGG() != -1 && (giamGia.getTrangThai() != -1)) {
                System.out.println("javaswingdev.service.PhieuGiamGiaService.getListLoc()" + 1);
                pstm.setString(1, XDate.toString(giamGia.getNgayBatDau(), "MM-dd-yyyy"));
                pstm.setString(2, XDate.toString(giamGia.getNgayKetThuc(), "MM-dd-yyyy"));
                pstm.setInt(3, giamGia.getLoaiPGG());
                pstm.setInt(4, giamGia.getTrangThai());
                pstm.setInt(5, (page - 1) * limt);
                pstm.setInt(6, limt);

            }
            if (giamGia.getNgayBatDau() != null && giamGia.getNgayKetThuc() != null && giamGia.getLoaiPGG() != -1 && giamGia.getTrangThai() == -1) {
                System.out.println("javaswingdev.service.PhieuGiamGiaService.getListLoc()" + 2);
                pstm.setString(1, XDate.toString(giamGia.getNgayBatDau(), "MM-dd-yyyy"));
                pstm.setString(2, XDate.toString(giamGia.getNgayKetThuc(), "MM-dd-yyyy"));
                pstm.setInt(3, giamGia.getLoaiPGG());
                pstm.setInt(4, (page - 1) * limt);
                pstm.setInt(5, limt);
                System.out.println("javaswingdev.service.PhieuGiamGiaService.getListLoc()" + 2);
            }
            if (giamGia.getNgayBatDau() != null && giamGia.getNgayKetThuc() != null && giamGia.getTrangThai() != -1 && giamGia.getLoaiPGG() == -1) {
                System.out.println("javaswingdev.service.PhieuGiamGiaService.getListLoc()" + 3);
                pstm.setString(1, XDate.toString(giamGia.getNgayBatDau(), "MM-dd-yyyy"));
                pstm.setString(2, XDate.toString(giamGia.getNgayKetThuc(), "MM-dd-yyyy"));
                pstm.setInt(3, giamGia.getTrangThai());
                pstm.setInt(4, (page - 1) * limt);
                pstm.setInt(5, limt);

            }
            if (giamGia.getNgayBatDau() != null && giamGia.getNgayKetThuc() != null && giamGia.getLoaiPGG() == -1 && (giamGia.getTrangThai() == -1)) {
                System.out.println("javaswingdev.service.PhieuGiamGiaService.getListLoc()" + 4);

                pstm.setString(1, XDate.toString(giamGia.getNgayBatDau(), "MM-dd-yyyy"));
                pstm.setString(2, XDate.toString(giamGia.getNgayKetThuc(), "MM-dd-yyyy"));
                pstm.setInt(3, (page - 1) * limt);
                pstm.setInt(4, limt);

            }

            rs = pstm.executeQuery();
            while (rs.next()) {
                PhieuGiamGia pgg = new PhieuGiamGia();
                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(rs.getLong("IDNV"));
                nhanVien.setHoTenNV(rs.getString("HoVaTen"));
                pgg.setIdNV(nhanVien);
                pgg.setMaPGG(rs.getString("MaPGG"));
                pgg.setTenPGG(rs.getString("TenPGG"));
                pgg.setLoaiPGG(rs.getInt(("LoaiPGG")));
                pgg.setGiaTri(rs.getBigDecimal("GiaTri"));
                pgg.setSoLuongPhieu(rs.getInt("SoLuongPhieu"));
                pgg.setDonToiThieu(rs.getBigDecimal("DonToiThieu"));
                pgg.setNgayBatDau(rs.getDate("NgayBatDau"));
                pgg.setNgayKetThuc(rs.getDate("NgayKetThuc"));
                pgg.setNgayTao(rs.getDate("NgayTao"));
                pgg.setMoTa(rs.getString("MoTa"));
                pgg.setTrangThai(rs.getInt("TrangThai"));
                list.add(pgg);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(PGG_Service.class.getName()).log(Level.SEVERE, null, ex);
            return list;
        }

    }
    public List<PhieuGiamGia> getListLoc1(PhieuGiamGia giamGia, int page, int limit) {
    List<PhieuGiamGia> list = new ArrayList<>();

    String query = "SELECT PGG.ID, NV.ID AS IDNV, NV.HoTenNV, MaPGG, TenPGG, LoaiPGG, GiaTri, " +
            "SoLuongPhieu, DonToiThieu, NgayBatDau, NgayKetThuc, PGG.NgayTao, MoTa, PGG.TrangThai " +
            "FROM PHIEUGIAMGIA AS PGG " +
            "JOIN NHANVIEN AS NV ON NV.ID = PGG.IdNV ";
    
    List<String> conditions = new ArrayList<>();
    
    if (giamGia.getNgayBatDau() != null && giamGia.getNgayKetThuc() != null) {
        conditions.add("(NgayBatDau >= ? AND NgayKetThuc <= ?)");
    }
    if (giamGia.getLoaiPGG() != -1) {
        conditions.add("LoaiPGG = ?");
    }
    if (giamGia.getTrangThai() != -1) {
        conditions.add("PGG.TrangThai = ?");
    }
    
    String whereClause = String.join(" AND ", conditions);
    if (!whereClause.isEmpty()) {
        query += "WHERE " + whereClause + " ";
    }
    
    query += "ORDER BY PGG.ID DESC OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
    
    try (Connection con = DBConnect.getConnect();
         PreparedStatement pstm = con.prepareStatement(query)) {
        
        int paramIndex = 1;
        if (giamGia.getNgayBatDau() != null && giamGia.getNgayKetThuc() != null) {
            pstm.setDate(paramIndex++, new java.sql.Date(giamGia.getNgayBatDau().getTime()));
            pstm.setDate(paramIndex++, new java.sql.Date(giamGia.getNgayKetThuc().getTime()));
        }
        if (giamGia.getLoaiPGG() != -1) {
            pstm.setInt(paramIndex++, giamGia.getLoaiPGG());
        }
        if (giamGia.getTrangThai() != -1) {
            pstm.setInt(paramIndex++, giamGia.getTrangThai());
        }
        
        pstm.setInt(paramIndex++, (page - 1) * limit);
        pstm.setInt(paramIndex++, limit);
        
        try (ResultSet rs = pstm.executeQuery()) {
            while (rs.next()) {
                PhieuGiamGia pgg = new PhieuGiamGia();
                NhanVien nhanVien = new NhanVien();
                nhanVien.setId(rs.getLong("IDNV"));
                nhanVien.setHoTenNV(rs.getString("HoTenNV")); // Fixed the column name
                pgg.setIdNV(nhanVien);
                pgg.setMaPGG(rs.getString("MaPGG"));
                pgg.setTenPGG(rs.getString("TenPGG"));
                pgg.setLoaiPGG(rs.getInt("LoaiPGG"));
                pgg.setGiaTri(rs.getBigDecimal("GiaTri"));
                pgg.setSoLuongPhieu(rs.getInt("SoLuongPhieu"));
                pgg.setDonToiThieu(rs.getBigDecimal("DonToiThieu"));
                pgg.setNgayBatDau(rs.getDate("NgayBatDau"));
                pgg.setNgayKetThuc(rs.getDate("NgayKetThuc"));
                 pgg.setNgayTao(rs.getDate("NgayTao"));
                pgg.setMoTa(rs.getString("MoTa"));
                pgg.setTrangThai(rs.getInt("TrangThai"));
                list.add(pgg);
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(PGG_Service.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return list;
}


    public static NhanVien getNhanVien(long idPGG) {
        //ArrayList<PhieuGiamGia> listPGG= new ArrayList<>();
        NhanVien nv = null;
        Connection conn = DBConnect.getConnect();
        String sql = "select NHANVIEN.ID, HoTenNV from PHIEUGIAMGIA join NHANVIEN on PHIEUGIAMGIA.ID = NHANVIEN.ID where PHIEUGIAMGIA.ID = ?";

        try {
            PreparedStatement pr = conn.prepareStatement(sql);
            pr.setObject(1, idPGG);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                nv = new NhanVien();
                nv.setId(rs.getLong("ID"));
                nv.setHoTenNV(rs.getString("HoTenNV"));
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nv;
    }

    public List<Object> getAllHDByMaPhieu(String ma) {
        List<Object> list = new ArrayList<>();
        try {
            query = "SELECT HOADON.MaHoaDon , PHIEUGIAMGIA.MaPGG , HOADON.NgayTao , PHIEUGIAMGIA.LoaiPGG , PHIEUGIAMGIA.GiaTri FROM PHIEUGIAMGIA\n"
                    + "JOIN HOADON ON HOADON.IdPGG = PHIEUGIAMGIA.ID\n"
                    + "WHERE MaPGG LIKE ?";
            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);
            pstm.setString(1, ma);
            rs = pstm.executeQuery();
            int i = 1;
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setNgayTao(rs.getDate("NgayTao"));
                hd.setMaHoaDon(rs.getString("MaHoaDon"));
                PhieuGiamGia pgg = new PhieuGiamGia();
                pgg.setMaPGG(rs.getString("MaPGG"));
                pgg.setLoaiPGG(0);
                Object[] ob = new Object[]{
                    i, rs.getString("MaHoaDon"), rs.getString("MaPGG"), rs.getDate("NgayTao"), rs.getInt("LoaiPGG") == 0 ? rs.getFloat("GiaTri") + " % "
                    : rs.getFloat("GiaTri") + " VND "
                };
                i++;
                list.add(ob);
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(PGG_Service.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public int getRowCountPGG() {
        String countSql = "SELECT COUNT(*) AS totalRows FROM PHIEUGIAMGIA";
        Connection con = DBConnect.getConnect();
        Statement stm;
        ResultSet rs;
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
        }
    }

    public Integer updateSoLuongPhieu(Long idPGG, Integer soLuong) {
        try {
            con = DBConnect.getConnect();
            query = "UPDATE PHIEUGIAMGIA\n"
                    + "SET SoLuongPhieu = ?\n"
                    + "WHERE ID = ?";
            pstm = con.prepareStatement(query);
            pstm.setInt(1, soLuong);
            pstm.setLong(2, idPGG);
            return pstm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PGG_Service.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public void updateKT(String date) {
        try {
            query = "UPDATE PHIEUGIAMGIA\n"
                    + "SET TrangThai = 2\n"
                    + "WHERE NgayKetThuc < '" + date + "' or SoLuongPhieu = 0 ";
            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PGG_Service.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void updateBD(String date) {
        try {
            query = "UPDATE PHIEUGIAMGIA\n"
                    + "SET TrangThai = 1\n"
                    + "WHERE NgayBatDau = '" + date + "' and SoLuongPhieu > 0";
            con = DBConnect.getConnect();
            pstm = con.prepareStatement(query);
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PGG_Service.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
