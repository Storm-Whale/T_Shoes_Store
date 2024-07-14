package javaswingdev.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javaswingdev.entity.ChatLieu;

public class ChatLieuService {

    Connection connect = DBConnect.getConnect();

    public List<ChatLieu> getToAllChatLieu() {
        ArrayList<ChatLieu> listKichThuoc = new ArrayList<>();
        String query = "SELECT * FROM [dbo].[CHATLIEU]";
        try {
            PreparedStatement ps = connect.prepareCall(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ChatLieu chatlieu = new ChatLieu();
                chatlieu.setId(rs.getLong(1));
                chatlieu.setMaCL(rs.getString(2));
                chatlieu.setTenCL(rs.getString(3));
                chatlieu.setNguoiTao(rs.getString(4));
                chatlieu.setTrangThai(rs.getInt(5));
                listKichThuoc.add(chatlieu);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listKichThuoc;
    }

    public List<ChatLieu> getToAllChatLieu(String keyword, Integer trangthai) {
        List<ChatLieu> listChatLieu = new ArrayList<>();
        StringBuilder query = new StringBuilder("SELECT * FROM [dbo].[CHATLIEU] WHERE 1=1");

        List<Object> params = new ArrayList<>();

        if (keyword != null && !keyword.trim().isEmpty()) {
            query.append(" AND (MaChatLieu LIKE ? OR TenChatLieu LIKE ? OR NguoiTao LIKE ?)");
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
                    ChatLieu chatLieu = new ChatLieu();
                    chatLieu.setId(rs.getLong("Id"));
                    chatLieu.setMaCL(rs.getString("MaChatLieu"));
                    chatLieu.setTenCL(rs.getString("TenChatLieu"));
                    chatLieu.setNguoiTao(rs.getString("NguoiTao"));
                    chatLieu.setTrangThai(rs.getInt("TrangThai"));
                    listChatLieu.add(chatLieu);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listChatLieu;
    }

    public List<ChatLieu> findChatLieuByTrangThai() {
        ArrayList<ChatLieu> listKichThuoc = new ArrayList<>();
        String query = "SELECT * FROM [dbo].[CHATLIEU] Where TrangThai = 0";
        try {
            PreparedStatement ps = connect.prepareCall(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ChatLieu chatlieu = new ChatLieu();
                chatlieu.setId(rs.getLong(1));
                chatlieu.setMaCL(rs.getString(2));
                chatlieu.setTenCL(rs.getString(3));
                chatlieu.setNguoiTao(rs.getString(4));
                chatlieu.setTrangThai(rs.getInt(5));
                listKichThuoc.add(chatlieu);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listKichThuoc;
    }

    public Integer addChatLieu(ChatLieu mauSac) {
        Integer row = null;
        String sql = "INSERT INTO ChatLieu (MaChatLieu, TenChatLieu, NguoiTao, TrangThai)\n"
                + "VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ppstm = connect.prepareStatement(sql);
            ppstm.setString(1, mauSac.getMaCL());
            ppstm.setString(2, mauSac.getTenCL());
            ppstm.setString(3, mauSac.getNguoiTao());
            ppstm.setInt(4, mauSac.getTrangThai());
            row = ppstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public Integer updateChatLieu(ChatLieu mauSac) {
        Integer row = null;
        String sql = "UPDATE ChatLieu\n"
                + "SET MaChatLieu = ?, TenChatLieu = ?, NguoiTao = ?, TrangThai = ?\n"
                + "WHERE ID = ?";
        try {
            PreparedStatement ppstm = connect.prepareStatement(sql);
            ppstm.setString(1, mauSac.getMaCL());
            ppstm.setString(2, mauSac.getTenCL());
            ppstm.setString(3, mauSac.getNguoiTao());
            ppstm.setInt(4, mauSac.getTrangThai());
            ppstm.setLong(5, mauSac.getTrangThai());
            row = ppstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }
}
