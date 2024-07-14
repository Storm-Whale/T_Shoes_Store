/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaswingdev.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javaswingdev.entity.NhanVien;

/**
 *
 * @author DEll
 */
public class NhanVienService {

    private Connection conn = DBConnect.getConnect();

    public List<NhanVien> findAll() {
        String sql = "SELECT * FROM dbo.NHANVIEN";
        List<NhanVien> listNV = new ArrayList<>();
        try {
            PreparedStatement ppstm = conn.prepareStatement(sql);
            ResultSet rs = ppstm.executeQuery();
            while (rs.next()) {
                listNV.add(new NhanVien(rs.getLong("ID"),
                        rs.getString("MaNV"),
                        rs.getString("HoTenNV"),
                        rs.getString("MatKhau"),
                        rs.getString("NgaySinh"),
                        rs.getString("CCCD"),
                        rs.getString("Email"),
                        rs.getString("DiaChi"),
                        rs.getString("SDT"),
                        rs.getInt("VaiTro"),
                        rs.getString("NgayTao"),
                        rs.getInt("TrangThai")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNV;
    }

    public NhanVien findByID(Long id) {
        String sql = "SELECT * FROM dbo.NHANVIEN Where Id = ?";
        List<NhanVien> listNV = new ArrayList<>();
        try {
            PreparedStatement ppstm = conn.prepareStatement(sql);
            ppstm.setLong(1, id);
            ResultSet rs = ppstm.executeQuery();
            while (rs.next()) {
                listNV.add(new NhanVien(rs.getLong("ID"),
                        rs.getString("MaNV"),
                        rs.getString("HoTenNV"),
                        rs.getString("MatKhau"),
                        rs.getString("NgaySinh"),
                        rs.getString("CCCD"),
                        rs.getString("Email"),
                        rs.getString("DiaChi"),
                        rs.getString("SDT"),
                        rs.getInt("VaiTro"),
                        rs.getString("NgayTao"),
                        rs.getInt("TrangThai")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNV.get(0);
    }

    public List<NhanVien> findAll(String keyword, Integer trangThai) {
        List<NhanVien> listNV = new ArrayList<>();
        String sql = "SELECT * FROM dbo.NHANVIEN ";
        int i = 1;
        if (keyword.trim().length() != 0 || trangThai != null) {
            sql += "WHERE ";
        }

        if (keyword.trim().length() != 0) {
            sql += "((MaNV LIKE ?) OR (HoTenNV LIKE ?) OR (CCCD LIKE ?) OR (Email LIKE ?) OR (DiaChi LIKE ?) OR (SDT LIKE ?)) ";
        }

        if (trangThai != null) {
            sql += keyword.trim().length() != 0 ? "AND " : " ";
            sql += "TrangThai = ?";
        }

        try {
            PreparedStatement ppstm = conn.prepareStatement(sql);
            if (keyword.trim().length() != 0) {
                ppstm.setString(i++, "%" + keyword + "%");
                ppstm.setString(i++, "%" + keyword + "%");
                ppstm.setString(i++, "%" + keyword + "%");
                ppstm.setString(i++, "%" + keyword + "%");
                ppstm.setString(i++, "%" + keyword + "%");
                ppstm.setString(i++, "%" + keyword + "%");
            }

            if (trangThai != null) {
                ppstm.setInt(i++, trangThai);
            }

            ResultSet rs = ppstm.executeQuery();
            while (rs.next()) {
                listNV.add(new NhanVien(rs.getLong("ID"),
                        rs.getString("MaNV"),
                        rs.getString("HoTenNV"),
                        rs.getString("MatKhau"),
                        rs.getString("NgaySinh"),
                        rs.getString("CCCD"),
                        rs.getString("Email"),
                        rs.getString("DiaChi"),
                        rs.getString("SDT"),
                        rs.getInt("VaiTro"),
                        rs.getString("NgayTao"),
                        rs.getInt("TrangThai")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNV;
    }

    public NhanVien findByEmailAndPassword(String email, String password) {
        String sql = "SELECT * FROM dbo.NHANVIEN WHERE Email = ? AND MatKhau = ?;";
        List<NhanVien> listNV = new ArrayList<>();
        try {
            PreparedStatement ppstm = conn.prepareStatement(sql);
            ppstm.setString(1, email);
            ppstm.setString(2, password);
            ResultSet rs = ppstm.executeQuery();
            while (rs.next()) {
                listNV.add(new NhanVien(rs.getLong("ID"),
                        rs.getString("MaNV"),
                        rs.getString("HoTenNV"),
                        rs.getString("MatKhau"),
                        rs.getString("NgaySinh"),
                        rs.getString("CCCD"),
                        rs.getString("Email"),
                        rs.getString("DiaChi"),
                        rs.getString("SDT"),
                        rs.getInt("VaiTro"),
                        rs.getString("NgayTao"),
                        rs.getInt("TrangThai")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNV.get(0);
    }

    public Integer addNhanVien(NhanVien nnv) {
        Integer row = null;
        String sql = "INSERT INTO dbo.NHANVIEN (MaNV, HoTenNV, MatKhau, NgaySinh, CCCD, Email, DiaChi, SDT, VaiTro, NgayTao, TrangThai) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ppstm = conn.prepareStatement(sql);
            ppstm.setString(1, nnv.getMaNV());
            ppstm.setString(2, nnv.getHoTenNV());
            ppstm.setString(3, nnv.getMatKhau());
            ppstm.setString(4, nnv.getNgaySinh());
            ppstm.setString(5, nnv.getCccd());
            ppstm.setString(6, nnv.getEmail());
            ppstm.setString(7, nnv.getDiaChi());
            ppstm.setString(8, nnv.getSdt());
            ppstm.setInt(9, nnv.getVaiTro());
            ppstm.setString(10, nnv.getNgayTao());
            ppstm.setInt(11, nnv.getTrangThai());
            row = ppstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public Integer updateNhanVien(NhanVien nnv) {
        Integer row = null;
        String sql = "UPDATE dbo.NHANVIEN SET MaNV = ?, HoTenNV = ?, MatKhau = ?, NgaySinh = ?, CCCD = ?, Email = ?,\n"
                + "DiaChi = ?, SDT = ?, VaiTro = ?, NgayTao = ?, TrangThai = ? WHERE ID = ?";
        try {
            PreparedStatement ppstm = conn.prepareStatement(sql);
            ppstm.setString(1, nnv.getMaNV());
            ppstm.setString(2, nnv.getHoTenNV());
            ppstm.setString(3, nnv.getMatKhau());
            ppstm.setString(4, nnv.getNgaySinh());
            ppstm.setString(5, nnv.getCccd());
            ppstm.setString(6, nnv.getEmail());
            ppstm.setString(7, nnv.getDiaChi());
            ppstm.setString(8, nnv.getSdt());
            ppstm.setInt(9, nnv.getVaiTro());
            ppstm.setString(10, nnv.getNgayTao());
            ppstm.setInt(11, nnv.getTrangThai());
            ppstm.setLong(12, nnv.getId());
            row = ppstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public Integer sortDeleteNhanVien(NhanVien nnv) {
        Integer row = null;
        String sql = "UPDATE dbo.NHANVIEN SET TrangThai = ? WHERE ID = ?";
        try {
            PreparedStatement ppstm = conn.prepareStatement(sql);
            ppstm.setInt(1, 0); // Setting TrangThai to 0
            ppstm.setLong(2, nnv.getId()); // Setting ID of the NhanVien to be updated
            row = ppstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public Integer hardDeleteNhanVien(Integer id) {
        Integer row = null;
        String sql = "DELETE FROM dbo.NHANVIEN WHERE ID = ?";
        try {
            PreparedStatement ppstm = conn.prepareStatement(sql);
            ppstm.setInt(1, id); // Setting ID of the NhanVien to be deleted
            row = ppstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public Integer soLuongNV() {
        Integer total = 0;
        String sql = "SELECT COUNT(ID) AS SoLuongNhanVien FROM dbo.NHANVIEN";
        try {
            PreparedStatement ppstm = conn.prepareStatement(sql);
            ResultSet rs = ppstm.executeQuery();
            while (rs.next()) {
                total = rs.getInt("SoLuongNhanVien");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return total;
    }
}
