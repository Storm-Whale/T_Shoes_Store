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
import javaswingdev.entity.ChatLieu;
import javaswingdev.entity.KichThuoc;
import javaswingdev.entity.MauSac;
import javaswingdev.entity.SanPham;
import javaswingdev.entity.SanPhamChiTiet;
import javaswingdev.entity.ThuongHieu;

/**
 *
 * @author DEll
 */
public class SanPhamCT_Service {

    private String query = null;
    private Statement stm = null;
    private PreparedStatement pstm = null;
    private ResultSet rs = null;
    private Connection con = null;

    Connection connect = DBConnect.getConnect();

    public List<SanPhamChiTiet> getToAll() {
        List<SanPhamChiTiet> list = new ArrayList<>();
        String sql = "SELECT spct.id, spct.maSpct, dbo.SANPHAM.TenSP, dbo.MAU.TenMau, dbo.SIZE.TenSize, dbo.THUONGHIEU.TenThuongHieu, spct.GiaBan, spct.GiaNiemYet, spct.SoLuongTon, spct.Mota, spct.trangThai, spct.NguoiTao, spct.NgayTao, CHATLIEU.TenChatLieu FROM dbo.SANPHAMCHITIET spct\n"
                + "JOIN dbo.SANPHAM ON dbo.SANPHAM.ID = spct.IDSP\n"
                + "JOIN  dbo.THUONGHIEU ON THUONGHIEU.ID = spct.idThuongHieu\n"
                + "JOIN dbo.SIZE ON SIZE.ID = spct.idSize\n"
                + "JOIN dbo.MAU ON MAU.ID = spct.idMau\n"
                + "JOIN dbo.CHATLIEU ON CHATLIEU.ID = spct.IdChatLieu;";

        try {
            pstm = connect.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                SanPham sanPham = new SanPham(rs.getString("TenSP"));
                MauSac mauSac = new MauSac(rs.getString("TenMau"));
                ThuongHieu thuongHieu = new ThuongHieu(rs.getString("TenThuongHieu"));
                KichThuoc kichThuoc = new KichThuoc(rs.getFloat("TenSize"));
                ChatLieu chatLieu = new ChatLieu();
                chatLieu.setTenCL(rs.getString("TenChatLieu"));
                SanPhamChiTiet sanPhamChiTiet = new SanPhamChiTiet(rs.getLong("ID"), rs.getString("maSpct"), rs.getInt("SoLuongTon"), rs.getBigDecimal("GiaBan"), rs.getBigDecimal("GiaNiemYet"), rs.getInt("TrangThai"), rs.getString("MoTa"), mauSac, kichThuoc, thuongHieu, sanPham);
                sanPhamChiTiet.setNguoiTao(rs.getString("NguoiTao"));
                sanPhamChiTiet.setIdChatLieu(chatLieu);
                sanPhamChiTiet.setNgayTao(rs.getDate("NgayTao"));
                list.add(sanPhamChiTiet);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<SanPhamChiTiet> findByIdSP(Long idSP) {
        List<SanPhamChiTiet> list = new ArrayList<>();
        String sql = "SELECT spct.id, spct.maSpct, dbo.SANPHAM.TenSP, dbo.MAU.TenMau, dbo.SIZE.TenSize, dbo.THUONGHIEU.TenThuongHieu, spct.GiaBan, spct.GiaNiemYet, spct.SoLuongTon, spct.Mota, spct.trangThai, spct.NguoiTao, spct.NgayTao, CHATLIEU.TenChatLieu FROM dbo.SANPHAMCHITIET spct\n"
                + "JOIN dbo.SANPHAM ON dbo.SANPHAM.ID = spct.IDSP\n"
                + "JOIN  dbo.THUONGHIEU ON THUONGHIEU.ID = spct.idThuongHieu\n"
                + "JOIN dbo.SIZE ON SIZE.ID = spct.idSize\n"
                + "JOIN dbo.MAU ON MAU.ID = spct.idMau\n"
                + "JOIN dbo.CHATLIEU ON CHATLIEU.ID = spct.IdChatLieu\n"
                + "WHERE SANPHAM.ID = ?";

        try {
            pstm = connect.prepareStatement(sql);
            pstm.setLong(1, idSP);
            rs = pstm.executeQuery();
            while (rs.next()) {
                SanPham sanPham = new SanPham(rs.getString("TenSP"));
                MauSac mauSac = new MauSac(rs.getString("TenMau"));
                ThuongHieu thuongHieu = new ThuongHieu(rs.getString("TenThuongHieu"));
                KichThuoc kichThuoc = new KichThuoc(rs.getFloat("TenSize"));
                ChatLieu chatLieu = new ChatLieu();
                chatLieu.setTenCL(rs.getString("TenChatLieu"));
                SanPhamChiTiet sanPhamChiTiet = new SanPhamChiTiet(rs.getLong("ID"), rs.getString("maSpct"), rs.getInt("SoLuongTon"), rs.getBigDecimal("GiaBan"), rs.getBigDecimal("GiaNiemYet"), rs.getInt("TrangThai"), rs.getString("MoTa"), mauSac, kichThuoc, thuongHieu, sanPham);
                sanPhamChiTiet.setNguoiTao(rs.getString("NguoiTao"));
                sanPhamChiTiet.setIdChatLieu(chatLieu);
                sanPhamChiTiet.setNgayTao(rs.getDate("NgayTao"));
                list.add(sanPhamChiTiet);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<SanPhamChiTiet> findByIdSP(Long idSP, String thuongHieu, String mau, String kichThuoc, String chatLieu, String nguoiTao, Integer trangThai) {
        List<SanPhamChiTiet> list = new ArrayList<>();
        StringBuilder sql = new StringBuilder("SELECT spct.id, spct.maSpct, dbo.SANPHAM.TenSP, dbo.MAU.TenMau, dbo.SIZE.TenSize, dbo.THUONGHIEU.TenThuongHieu, spct.GiaBan, spct.GiaNiemYet, spct.SoLuongTon, spct.Mota, spct.trangThai, spct.NguoiTao, spct.NgayTao, CHATLIEU.TenChatLieu FROM dbo.SANPHAMCHITIET spct ")
                .append("JOIN dbo.SANPHAM ON dbo.SANPHAM.ID = spct.IDSP ")
                .append("JOIN dbo.THUONGHIEU ON THUONGHIEU.ID = spct.idThuongHieu ")
                .append("JOIN dbo.SIZE ON SIZE.ID = spct.idSize ")
                .append("JOIN dbo.MAU ON MAU.ID = spct.idMau ")
                .append("JOIN dbo.CHATLIEU ON CHATLIEU.ID = spct.IdChatLieu ")
                .append("WHERE SANPHAM.ID = ?");

        List<Object> params = new ArrayList<>();
        params.add(idSP);

        boolean hasThuongHieu = thuongHieu != null && !thuongHieu.trim().isEmpty();
        boolean hasMau = mau != null && !mau.trim().isEmpty();
        boolean hasKichThuoc = kichThuoc != null && !kichThuoc.trim().isEmpty();
        boolean hasChatLieu = chatLieu != null && !chatLieu.trim().isEmpty();
        boolean hasNguoiTao = nguoiTao != null && !nguoiTao.trim().isEmpty();
        boolean hasTrangThai = trangThai != null;

        if (hasThuongHieu) {
            sql.append(" AND THUONGHIEU.TenThuongHieu LIKE ?");
            params.add("%" + thuongHieu.trim() + "%");
        }

        if (hasMau) {
            sql.append(" AND MAU.TenMau LIKE ?");
            params.add("%" + mau.trim() + "%");
        }

        if (hasKichThuoc) {
            sql.append(" AND SIZE.TenSize LIKE ?");
            params.add("%" + kichThuoc.trim() + "%");
        }

        if (hasChatLieu) {
            sql.append(" AND CHATLIEU.TenChatLieu LIKE ?");
            params.add("%" + chatLieu.trim() + "%");
        }

        if (hasNguoiTao) {
            sql.append(" AND spct.NguoiTao LIKE ?");
            params.add("%" + nguoiTao.trim() + "%");
        }

        if (hasTrangThai) {
            sql.append(" AND spct.trangThai = ?");
            params.add(trangThai);
        }

        System.out.println("sql : " + sql);

        try (PreparedStatement pstm = connect.prepareStatement(sql.toString())) {
            for (int i = 0; i < params.size(); i++) {
                pstm.setObject(i + 1, params.get(i));
            }

            try (ResultSet rs = pstm.executeQuery()) {
                while (rs.next()) {
                    SanPham sanPham = new SanPham(rs.getString("TenSP"));
                    MauSac mauSac = new MauSac(rs.getString("TenMau"));
                    ThuongHieu thuongHieuEntity = new ThuongHieu(rs.getString("TenThuongHieu"));
                    KichThuoc kichThuocEntity = new KichThuoc(rs.getFloat("TenSize"));
                    ChatLieu chatLieuEntity = new ChatLieu();
                    chatLieuEntity.setTenCL(rs.getString("TenChatLieu"));
                    SanPhamChiTiet sanPhamChiTiet = new SanPhamChiTiet(
                            rs.getLong("id"),
                            rs.getString("maSpct"),
                            rs.getInt("SoLuongTon"),
                            rs.getBigDecimal("GiaBan"),
                            rs.getBigDecimal("GiaNiemYet"),
                            rs.getInt("trangThai"),
                            rs.getString("Mota"),
                            mauSac,
                            kichThuocEntity,
                            thuongHieuEntity,
                            sanPham
                    );
                    sanPhamChiTiet.setNguoiTao(rs.getString("NguoiTao"));
                    sanPhamChiTiet.setIdChatLieu(chatLieuEntity);
                    sanPhamChiTiet.setNgayTao(rs.getDate("NgayTao"));
                    list.add(sanPhamChiTiet);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<SanPhamChiTiet> getByTrangThai() {
        List<SanPhamChiTiet> list = new ArrayList<>();
        String sql = "SELECT spct.id ,spct.maSpct, dbo.SANPHAM.TenSP, dbo.MAU.TenMau, dbo.SIZE.TenSize, dbo.THUONGHIEU.TenThuongHieu, spct.GiaBan, spct.GiaNiemYet, spct.SoLuongTon, spct.Mota, spct.trangThai, SANPHAM.id as IDSP FROM dbo.SANPHAMCHITIET spct\n"
                + "	JOIN dbo.SANPHAM ON dbo.SANPHAM.ID = spct.IDSP\n"
                + "	JOIN dbo.THUONGHIEU ON THUONGHIEU.ID = spct.idThuongHieu\n"
                + "	JOIN dbo.SIZE ON SIZE.ID = spct.idSize\n"
                + "	JOIN dbo.MAU ON MAU.ID = spct.idMau"
                + "      WHERE spct.TrangThai =  0";

        try {
            PreparedStatement pstm = connect.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                SanPham sanPham = new SanPham(rs.getString("TenSP"));
                sanPham.setIdSanPham(rs.getLong("IDSP"));
                MauSac mauSac = new MauSac(rs.getString("TenMau"));
                ThuongHieu thuongHieu = new ThuongHieu(rs.getString("TenThuongHieu"));
                KichThuoc kichThuoc = new KichThuoc(rs.getFloat("TenSize"));

                SanPhamChiTiet sanPhamChiTiet = new SanPhamChiTiet(rs.getLong("ID"), rs.getString("maSpct"), rs.getInt("SoLuongTon"), rs.getBigDecimal("GiaBan"), rs.getBigDecimal("GiaNiemYet"), rs.getInt("TrangThai"), rs.getString("MoTa"), mauSac, kichThuoc, thuongHieu, sanPham);
                list.add(sanPhamChiTiet);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<SanPhamChiTiet> getListGH() {
        List<SanPhamChiTiet> list = new ArrayList<>();
        String sql = "SELECT CTSP.ID, CTSP.MaSPCT, SP.TenSP, TH.TenThuongHieu, S.TenSize, M.TenMau, CTSP.SoLuongTon, CTSP.GiaBan, CTSP.GiaNiemYet, CTSP.MoTa, CTSP.TrangThai\n"
                + "                FROM SANPHAMCHITIET as CTSP\n"
                + "                JOIN MAU as M on M.ID = CTSP.IdMau\n"
                + "                JOIN SIZE as S on S.ID = CTSP.IdSize\n"
                + "                JOIN THUONGHIEU as TH on TH.ID = CTSP.IdThuongHieu\n"
                + "                JOIN SANPHAM as SP on SP.ID = CTSP.IdSP\n"
                + "                 where CTSP.SoLuongTon > 0 ";

        try {
            PreparedStatement pstm = connect.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                SanPham sanPham = new SanPham(rs.getString("TenSP"));
                MauSac mauSac = new MauSac(rs.getString("TenMau"));
                ThuongHieu thuongHieu = new ThuongHieu(rs.getString("TenThuongHieu"));
                KichThuoc kichThuoc = new KichThuoc(rs.getFloat("TenSize"));
                SanPhamChiTiet sanPhamChiTiet = new SanPhamChiTiet(rs.getLong("ID"), rs.getString("MaCTSP"), rs.getInt("SoLuongTon"), rs.getBigDecimal("GiaBan"), rs.getBigDecimal("GiaNiemYet"), rs.getInt("TrangThai"), rs.getString("MoTa"), mauSac, kichThuoc, thuongHieu, sanPham);
                list.add(sanPhamChiTiet);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public List<SanPhamChiTiet> search_SanPhamChiTiet(String text) {
        List<SanPhamChiTiet> listSearch = new ArrayList<>();
        String query = "SELECT CTSP.ID, CTSP.MaSPCT, SP.TenSP, TH.TenThuongHieu, S.TenSize, M.TenMau, \n"
                + "       CTSP.SoLuongTon, CTSP.GiaBan, CTSP.GiaNiemYet, CTSP.MoTa, CTSP.TrangThai\n"
                + "FROM SANPHAMCHITIET AS CTSP\n"
                + "JOIN MAU AS M ON M.ID = CTSP.IdMau\n"
                + "JOIN SIZE AS S ON S.ID = CTSP.IdSize\n"
                + "JOIN THUONGHIEU AS TH ON TH.ID = CTSP.IdThuongHieu\n"
                + "JOIN SANPHAM AS SP ON SP.ID = CTSP.IdSP\n"
                + "WHERE (CTSP.MaSPCT LIKE ?\n"
                + "       OR SP.TenSP LIKE ?\n"
                + "       OR TH.TenThuongHieu LIKE ?)\n"
                + "  AND CTSP.TrangThai = 0";

        try {
            PreparedStatement ps = connect.prepareCall(query);
            ps.setString(1, "%" + text + "%");
            ps.setString(2, "%" + text + "%");
            ps.setString(3, "%" + text + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPham sanPham = new SanPham(rs.getString("TenSP"));
                MauSac mauSac = new MauSac(rs.getString("TenMau"));
                ThuongHieu thuongHieu = new ThuongHieu(rs.getString("TenThuongHieu"));
                KichThuoc kichThuoc = new KichThuoc(rs.getFloat("TenSize"));

                SanPhamChiTiet sanPhamChiTiet = new SanPhamChiTiet(rs.getLong("ID"), rs.getString("MaSPCT"), rs.getInt("SoLuongTon"), rs.getBigDecimal("GiaBan"), rs.getBigDecimal("GiaNiemYet"), rs.getInt("TrangThai"), rs.getString("MoTa"), mauSac, kichThuoc, thuongHieu, sanPham);
                listSearch.add(sanPhamChiTiet);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listSearch;
    }

    public int getRowCount() {
        String countSql = "SELECT COUNT(*) AS totalRows FROM SANPHAMCHITIET "
                + " WHERE SoLuongTon > 0 ";
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

    public List<SanPhamChiTiet> searchItem(Long idMau, Long idSize, Long idThuongHieu, Long idSanPham) {
        List<SanPhamChiTiet> list = new ArrayList<>();
        if (connect != null) {
            try {
                StringBuilder query = new StringBuilder("SELECT CTSP.ID, CTSP.MaSPCT, SP.TenSP, TH.TenThuongHieu, S.TenSize, M.TenMau, CTSP.SoLuongTon, CTSP.GiaBan, CTSP.GiaNiemYet, CTSP.MoTa, CTSP.TrangThai, CTSP.ID as ID FROM SANPHAMCHITIET as CTSP\n"
                        + "JOIN MAU as M ON M.ID = CTSP.IdMau\n"
                        + "JOIN SIZE as S ON S.ID = CTSP.IdSize\n"
                        + "JOIN THUONGHIEU as TH ON TH.ID = CTSP.IdThuongHieu\n"
                        + "JOIN SANPHAM as SP ON SP.ID = CTSP.IdSP\n"
                        + " WHERE CTSP.TrangThai = 0"
                );

                // Màu Sắc
                if (idMau != null) {
                    query.append(" AND M.ID = " + idMau);
                }
                // Kích Thước
                if (idSize != null) {
                    query.append(" AND S.ID = " + idSize);
                }
                // Thương Hiệu
                if (idThuongHieu != null) {
                    query.append(" AND TH.ID = " + idThuongHieu);
                }
                // Sản Phẩm
                if (idSanPham != null) {
                    query.append(" AND SP.ID = " + idSanPham);
                }

                String queryFinal = query.toString();

                System.out.println(queryFinal);

                PreparedStatement ps = connect.prepareStatement(queryFinal);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    SanPham sanPham = new SanPham(rs.getString("TenSP"));
                    MauSac mauSac = new MauSac(rs.getString("TenMau"));
                    ThuongHieu thuongHieu = new ThuongHieu(rs.getString("TenThuongHieu"));
                    KichThuoc kichThuoc = new KichThuoc(rs.getFloat("TenSize"));
                    SanPhamChiTiet sanPhamChiTiet = new SanPhamChiTiet(rs.getLong("ID"), rs.getString("MaSPCT"), rs.getInt("SoLuongTon"), rs.getBigDecimal("GiaBan"), rs.getBigDecimal("GiaNiemYet"), rs.getInt("TrangThai"), rs.getString("MoTa"), mauSac, kichThuoc, thuongHieu, sanPham);
                    list.add(sanPhamChiTiet);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return list;
    }

    public int getSoLuongTonByMaCTSP(String maCTSP) {
        int soLuongTon = 0;
        query = "SELECT SoLuongTon FROM SANPHAMCHITIET WHERE MaSPCT LIKE '" + maCTSP + "' ;";
        con = DBConnect.getConnect();
        try {
            pstm = con.prepareStatement(query);
            rs = pstm.executeQuery();
            if (rs.next()) {
                soLuongTon = rs.getInt("SoLuongTon");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return soLuongTon;
    }

    public void updateSLSP(int sl, String maCTSP) {
        try {
            con = DBConnect.getConnect();
            query = "update SANPHAMCHITIET\n"
                    + "set SoLuongTon = ?\n"
                    + "where MaSPCT like ?";
            pstm = con.prepareStatement(query);
            pstm.setInt(1, sl);
            pstm.setString(2, maCTSP);
            pstm.execute();
        } catch (SQLException ex) {
            Logger.getLogger(SanPhamCT_Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateSoLuongSP(int soLuong, String maSPCT) {
        String sql = "UPDATE SANPHAMCHITIET SET SoLuongTon = ? WHERE maSPCT = ?";
        try {
            PreparedStatement ppstm = connect.prepareStatement(sql);
            ppstm.setInt(1, soLuong);
            ppstm.setString(2, maSPCT);
            ppstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Long getIdSPCTByMaSPCT(String maCTSP) {
        Long idSPCT = null;
        query = "SELECT Id FROM SANPHAMCHITIET WHERE MaSPCT = ?";
        con = DBConnect.getConnect();
        try {
            pstm = con.prepareStatement(query);
            pstm.setString(1, maCTSP);
            rs = pstm.executeQuery();
            if (rs.next()) {
                idSPCT = rs.getLong("ID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ChiTietHoaDonService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return idSPCT;
    }

    public Integer addSanPhamChiTiet(SanPhamChiTiet sanPhamChiTiet) {
        Integer row = null;
        String sql = "INSERT INTO "
                + "SANPHAMCHITIET (IdSP, IdThuongHieu, IdMau, IdSize, IdChatLieu, "
                + "MaSPCT, SoLuongTon, GiaNiemYet, GiaBan, MoTa, NgayTao, NguoiTao, TrangThai) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ppstm = connect.prepareStatement(sql);
            ppstm.setLong(1, sanPhamChiTiet.getIdSanPham().getIdSanPham());
            ppstm.setLong(2, sanPhamChiTiet.getIdThuongHieu().getIdThuongHieu());
            ppstm.setLong(3, sanPhamChiTiet.getIdMau().getIdMau());
            ppstm.setLong(4, sanPhamChiTiet.getIdKichThuoc().getIdSize());
            ppstm.setLong(5, sanPhamChiTiet.getIdChatLieu().getId());
            ppstm.setString(6, sanPhamChiTiet.getMaSPCT());
            ppstm.setObject(7, sanPhamChiTiet.getSoLuong());
            ppstm.setBigDecimal(8, sanPhamChiTiet.getGiaBan());
            ppstm.setBigDecimal(9, sanPhamChiTiet.getGiaNiemYet());
            ppstm.setString(10, sanPhamChiTiet.getMoTa());

            java.util.Date utilDate = sanPhamChiTiet.getNgayTao();
            if (utilDate != null) {
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                ppstm.setDate(11, sqlDate);
            } else {
                ppstm.setNull(11, java.sql.Types.DATE);
            }

            ppstm.setString(12, sanPhamChiTiet.getNguoiTao());
            ppstm.setInt(13, sanPhamChiTiet.getTrangThai());

            row = ppstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public Integer updateSPCT(SanPhamChiTiet sanPhamChiTiet) {
        Integer row = null;
        String sql = "UPDATE SANPHAMCHITIET SET "
                + "IdThuongHieu = ?, IdMau = ?, IdSize = ?, IdChatLieu = ?, MaSPCT = ?, SoLuongTon = ?, "
                + "GiaNiemYet = ?, GiaBan = ?, MoTa = ?, TrangThai = ? "
                + "WHERE ID = ?";

        try {
            PreparedStatement ppstm = connect.prepareStatement(sql);
            ppstm.setLong(1, sanPhamChiTiet.getIdThuongHieu().getIdThuongHieu());
            ppstm.setLong(2, sanPhamChiTiet.getIdMau().getIdMau());
            ppstm.setLong(3, sanPhamChiTiet.getIdKichThuoc().getIdSize());
            ppstm.setLong(4, sanPhamChiTiet.getIdChatLieu().getId());
            ppstm.setString(5, sanPhamChiTiet.getMaSPCT());
            ppstm.setObject(6, sanPhamChiTiet.getSoLuong());
            ppstm.setBigDecimal(7, sanPhamChiTiet.getGiaBan());
            ppstm.setBigDecimal(8, sanPhamChiTiet.getGiaNiemYet());
            ppstm.setString(9, sanPhamChiTiet.getMoTa());
            ppstm.setInt(10, sanPhamChiTiet.getTrangThai());
            ppstm.setLong(11, sanPhamChiTiet.getIdSPCT());
            row = ppstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }
}
