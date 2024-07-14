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
import javaswingdev.entity.KichThuoc;

/**
 *
 * @author DEll
 */
public class SizeService {

    Connection connect = DBConnect.getConnect();

    public List<KichThuoc> getToAllKichThuoc() {
        ArrayList<KichThuoc> listKichThuoc = new ArrayList<>();
        String query = "SELECT * FROM [dbo].[SIZE]";
        try {
            PreparedStatement ps = connect.prepareCall(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listKichThuoc.add(new KichThuoc(rs.getLong(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getInt(5)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listKichThuoc;
    }

    public List<KichThuoc> getToAllKichThuoc(String keyword, Integer trangthai) {
        ArrayList<KichThuoc> listKichThuoc = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT * FROM [dbo].[SIZE] WHERE 1=1");

        List<Object> params = new ArrayList<>();

        if (keyword != null && !keyword.trim().isEmpty()) {
            query.append(" AND (MaSize LIKE ? OR TenSize LIKE ? OR NguoiTao LIKE ?)");
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
                    listKichThuoc.add(new KichThuoc(rs.getLong(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getInt(5)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKichThuoc;
    }

    public List<KichThuoc> findKichThuocByTrangThai() {
        ArrayList<KichThuoc> listKichThuoc = new ArrayList<>();
        String query = "SELECT * FROM [dbo].[SIZE] Where TrangThai = 0";
        try {
            PreparedStatement ps = connect.prepareCall(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listKichThuoc.add(new KichThuoc(rs.getLong(1), rs.getString(2), rs.getFloat(3), rs.getString(4), rs.getInt(5)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listKichThuoc;
    }

    public KichThuoc getByID(Long id) {
        ArrayList<KichThuoc> listKichThuoc = new ArrayList<>();
        String query = "Select ID,MaSize, TenSize, TrangThai From SIZE Where id = ?";
        try {
            PreparedStatement ps = connect.prepareCall(query);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listKichThuoc.add(new KichThuoc(rs.getLong(1), rs.getString(2), rs.getFloat(3), rs.getInt(4)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listKichThuoc.get(0);
    }

    public Integer addSize(KichThuoc mauSac) {
        Integer row = null;
        String sql = "INSERT INTO Size (MaSize, TenSize, NguoiTao, TrangThai)\n"
                + "VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ppstm = connect.prepareStatement(sql);
            ppstm.setString(1, mauSac.getMaSize());
            ppstm.setFloat(2, mauSac.getTenSize());
            ppstm.setString(3, mauSac.getNguoiTao());
            ppstm.setInt(4, mauSac.getTrangThai());
            row = ppstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public Integer updateSize(KichThuoc mauSac) {
        Integer row = null;
        String sql = "UPDATE Size\n"
                + "SET MaSize = ?, TenSize = ?, NguoiTao = ?, TrangThai = ?\n"
                + "WHERE ID = ?";
        try {
            PreparedStatement ppstm = connect.prepareStatement(sql);
            ppstm.setString(1, mauSac.getMaSize());
            ppstm.setFloat(2, mauSac.getTenSize());
            ppstm.setString(3, mauSac.getNguoiTao());
            ppstm.setInt(4, mauSac.getTrangThai());
            ppstm.setLong(5, mauSac.getIdSize());
            row = ppstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }
}
