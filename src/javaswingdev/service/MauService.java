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
import javaswingdev.entity.MauSac;

/**
 *
 * @author DEll
 */
public class MauService {

    Connection connect = DBConnect.getConnect();

    public List<MauSac> getToAll() {
        ArrayList<MauSac> listMauSac = new ArrayList<>();
        String query = "SELECT * FROM [dbo].[Mau]";
        try {
            PreparedStatement ps = connect.prepareCall(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listMauSac.add(new MauSac(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getInt(5), rs.getString(4)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listMauSac;
    }

    public List<MauSac> getToAll(String keyword, Integer trangthai) {
        List<MauSac> listMauSac = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT * FROM [dbo].[Mau] WHERE 1=1");

        List<Object> params = new ArrayList<>();

        if (keyword != null && !keyword.trim().isEmpty()) {
            query.append(" AND (MaMau LIKE ? OR TenMau LIKE ? OR NguoiTao LIKE ?)");
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
                    listMauSac.add(new MauSac(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getInt(5), rs.getString(4)));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listMauSac;
    }

    public List<MauSac> findMauByTrangThai() {
        ArrayList<MauSac> listMauSac = new ArrayList<>();
        String query = "SELECT * FROM [dbo].[Mau] Where TrangThai = 0";
        try {
            PreparedStatement ps = connect.prepareCall(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listMauSac.add(new MauSac(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getInt(5), rs.getString(4)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listMauSac;
    }

    public Integer addMauSac(MauSac mauSac) {
        Integer row = null;
        String sql = "INSERT INTO MAU (MaMau, TenMau, NguoiTao, TrangThai)\n"
                + "VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ppstm = connect.prepareStatement(sql);
            ppstm.setString(1, mauSac.getMaMau());
            ppstm.setString(2, mauSac.getTenMau());
            ppstm.setString(3, mauSac.getNguoiTao());
            ppstm.setInt(4, mauSac.getTrangThai());
            row = ppstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public Integer updateMauSac(MauSac mauSac) {
        Integer row = null;
        String sql = "UPDATE MAU\n"
                + "SET MaMau = ?, TenMau = ?, NguoiTao = ?, TrangThai = ?\n"
                + "WHERE ID = ?";
        try {
            PreparedStatement ppstm = connect.prepareStatement(sql);
            ppstm.setString(1, mauSac.getMaMau());
            ppstm.setString(2, mauSac.getTenMau());
            ppstm.setString(3, mauSac.getNguoiTao());
            ppstm.setInt(4, mauSac.getTrangThai());
            ppstm.setLong(5, mauSac.getIdMau());
            row = ppstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }
}
