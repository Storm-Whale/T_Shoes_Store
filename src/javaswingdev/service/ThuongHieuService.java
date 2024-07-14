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
import javaswingdev.entity.ThuongHieu;

/**
 *
 * @author DEll
 */
public class ThuongHieuService {

    Connection connect = DBConnect.getConnect();

    public ArrayList<ThuongHieu> getToAll() {
        ArrayList<ThuongHieu> list = new ArrayList<>();
        String query = "SELECT * FROM [dbo].[THUONGHIEU]";
        try {
            PreparedStatement ps = connect.prepareCall(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new ThuongHieu(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public ArrayList<ThuongHieu> getToAll(String keyword, Integer trangthai) {
        ArrayList<ThuongHieu> list = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT * FROM [dbo].[THUONGHIEU] WHERE 1=1");

        List<Object> params = new ArrayList<>();

        if (keyword != null && !keyword.trim().isEmpty()) {
            query.append(" AND (MaThuongHieu LIKE ? OR TenThuongHieu LIKE ? OR NguoiTao LIKE ?)");
            String keywordPattern = "%" + keyword.trim() + "%";
            for (int i = 0; i < 3; i++) {
                params.add(keywordPattern);
            }
        }

        if (trangthai != null) {
            query.append(" AND TrangThai = ?");
            params.add(trangthai);
        }

        System.out.println("query : " + query);

        try (PreparedStatement ps = connect.prepareStatement(query.toString())) {
            for (int i = 0; i < params.size(); i++) {
                ps.setObject(i + 1, params.get(i));
            }

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new ThuongHieu(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<ThuongHieu> findByTrangThai() {
        ArrayList<ThuongHieu> list = new ArrayList<>();
        String query = "SELECT * FROM [dbo].[THUONGHIEU] Where TrangThai = 0";
        try {
            PreparedStatement ps = connect.prepareCall(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new ThuongHieu(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public Integer addThuongHieu(ThuongHieu mauSac) {
        Integer row = null;
        String sql = "INSERT INTO ThuongHieu (MaThuongHieu, TenThuongHieu, NguoiTao, TrangThai)\n"
                + "VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ppstm = connect.prepareStatement(sql);
            ppstm.setString(1, mauSac.getMaThuongHieu());
            ppstm.setString(2, mauSac.getTenThuongHieu());
            ppstm.setString(3, mauSac.getNguoiTao());
            ppstm.setInt(4, mauSac.getTrangThai());
            row = ppstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public Integer updateThuongHieu(ThuongHieu mauSac) {
        Integer row = null;
        String sql = "UPDATE ThuongHieu\n"
                + "SET MaThuongHieu = ?, TenThuongHieu = ?, NguoiTao = ?, TrangThai = ?\n"
                + "WHERE ID = ?";
        try {
            PreparedStatement ppstm = connect.prepareStatement(sql);
            ppstm.setString(1, mauSac.getMaThuongHieu());
            ppstm.setString(2, mauSac.getTenThuongHieu());
            ppstm.setString(3, mauSac.getNguoiTao());
            ppstm.setInt(4, mauSac.getTrangThai());
            ppstm.setLong(5, mauSac.getIdThuongHieu());
            row = ppstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }
}
