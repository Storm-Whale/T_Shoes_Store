package javaswingdev.form;

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import Utils.*;
import javaswingdev.entity.NhanVien;
import javaswingdev.service.NhanVienService;
import javax.swing.table.DefaultTableModel;

public class Form_NhanVien extends javax.swing.JPanel {

    private final NhanVienService nhanVienService = new NhanVienService();
    private DefaultTableModel dtm = new DefaultTableModel();
    private List<NhanVien> listNhanVien;
    private Integer index = -1;

    public Form_NhanVien(String name) {
        initComponents();
        this.loadData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txt_CCCD = new javax.swing.JTextField();
        dc_NgayTao = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        txt_HoTenNV = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        dc_NgaySinh = new com.toedter.calendar.JDateChooser();
        txt_Pw = new javax.swing.JPasswordField();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_MaNV = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        chb_TrangThai = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        txt_Email = new javax.swing.JTextField();
        txt_DiaChi = new javax.swing.JTextField();
        chb_PassWord = new javax.swing.JCheckBox();
        cbx_VaiTro = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_SDT = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btn_Them = new javax.swing.JButton();
        btn_Sua = new javax.swing.JButton();
        btn_LamMoi = new javax.swing.JButton();
        btn_Xoa = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_NhanVien = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbl_TongSoNhanVien = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txt_Keyword = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        rdo_HoatDong = new javax.swing.JRadioButton();
        rdo_KhongHoatDong = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1180, 640));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Quản Lý Nhân Viên");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txt_CCCD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Email :");

        txt_HoTenNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("SĐT :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Họ Tên :");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Ngày Tạo :");

        dc_NgaySinh.setDateFormatString("dd-MM-yyyy");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Ngày Sinh :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Mã Nhân Viên :");

        txt_MaNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Địa Chỉ :");

        chb_TrangThai.setText("Hoạt động ");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("CCCD :");

        txt_Email.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txt_DiaChi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        chb_PassWord.setText("Hiện Mật Khẩu");
        chb_PassWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chb_PassWordActionPerformed(evt);
            }
        });

        cbx_VaiTro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Vai trò :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Mật Khẩu :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Trạng Thái :");

        txt_SDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btn_Them.setText("Thêm");
        btn_Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemActionPerformed(evt);
            }
        });

        btn_Sua.setText("Sửa");
        btn_Sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaActionPerformed(evt);
            }
        });

        btn_LamMoi.setText("Làm mới");
        btn_LamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LamMoiActionPerformed(evt);
            }
        });

        btn_Xoa.setText("Xóa");
        btn_Xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_XoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Sua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Them, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_LamMoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Xoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Them, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Sua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_LamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Xoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(53, 53, 53)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(35, 35, 35)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbx_VaiTro, 0, 240, Short.MAX_VALUE)
                            .addComponent(txt_MaNV)
                            .addComponent(txt_Pw))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chb_TrangThai))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(chb_PassWord)))
                        .addGap(30, 30, 30)))
                .addGap(75, 75, 75)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dc_NgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_HoTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(71, 71, 71)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dc_NgayTao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel12))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_CCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(38, 38, 38))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(25, 25, 25)
                        .addComponent(txt_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(357, 357, 357)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_HoTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(23, 23, 23)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel11)
                                    .addComponent(dc_NgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txt_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(txt_CCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel14)
                                    .addComponent(dc_NgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txt_DiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txt_MaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(cbx_VaiTro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txt_Pw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(chb_PassWord)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(chb_TrangThai)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbx_VaiTro, dc_NgaySinh, dc_NgayTao, txt_CCCD, txt_DiaChi, txt_Email, txt_HoTenNV, txt_MaNV, txt_Pw, txt_SDT});

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        tbl_NhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "MaNV", "HoTenNV", "MatKhau", "NgaySinh", "CCCD", "Email", "DiaChi", "SDT", "VaiTro", "NgayTao", "TrangThai"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_NhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_NhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_NhanVien);

        jButton1.setText("<<");

        jButton2.setText("<");

        jButton3.setText(">");

        jButton4.setText(">>");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel2.setText("Tổng số nhân viên :");

        lbl_TongSoNhanVien.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1168, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_TongSoNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbl_TongSoNhanVien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        jButton5.setText("Tìm kiếm");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdo_HoatDong);
        rdo_HoatDong.setText("Hoạt động");

        buttonGroup1.add(rdo_KhongHoatDong);
        rdo_KhongHoatDong.setText("Không hoạt động");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(txt_Keyword, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdo_HoatDong)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rdo_KhongHoatDong)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_Keyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(rdo_HoatDong)
                    .addComponent(rdo_KhongHoatDong))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_NhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_NhanVienMouseClicked
        // TODO add your handling code here:
        index = tbl_NhanVien.getSelectedRow();
        txt_MaNV.setText(tbl_NhanVien.getValueAt(index, 1).toString().trim());
        txt_HoTenNV.setText(tbl_NhanVien.getValueAt(index, 2).toString().trim());
        txt_SDT.setText(tbl_NhanVien.getValueAt(index, 8).toString().trim());
        txt_Email.setText(tbl_NhanVien.getValueAt(index, 6).toString().trim());
        txt_DiaChi.setText(tbl_NhanVien.getValueAt(index, 7).toString().trim());
        txt_CCCD.setText(tbl_NhanVien.getValueAt(index, 5).toString().trim());

        txt_Pw.setText(String.valueOf(tbl_NhanVien.getValueAt(index, 3).toString().trim()));

        cbx_VaiTro.setSelectedItem(tbl_NhanVien.getValueAt(index, 9).toString().trim());

        String trangThai = tbl_NhanVien.getValueAt(index, 11).toString().trim();
        if (trangThai.equals("Hoat Dong")) {
            chb_TrangThai.setSelected(true);
        } else {
            chb_TrangThai.setSelected(false);
        }

        String ngaySinh = tbl_NhanVien.getValueAt(index, 4).toString().trim();
        dc_NgaySinh.setDate(XDate.toDate(ngaySinh, "yyyy-MM-dd"));
        String ngayTao = tbl_NhanVien.getValueAt(index, 10).toString().trim();
        dc_NgayTao.setDate(XDate.toDate(ngayTao, "yyyy-MM-dd"));
    }//GEN-LAST:event_tbl_NhanVienMouseClicked

    private void btn_LamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LamMoiActionPerformed
        // TODO add your handling code here:
        this.resetData();
        loadData();
    }//GEN-LAST:event_btn_LamMoiActionPerformed

    private void chb_PassWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chb_PassWordActionPerformed
        // TODO add your handling code here:
        if (chb_PassWord.isSelected()) {
            txt_Pw.setEchoChar((char) 0);
        } else {
            txt_Pw.setEchoChar('*');
        }
    }//GEN-LAST:event_chb_PassWordActionPerformed

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        if (Auth.isManager()) {
            if (checkEmpty()) {
                return;
            } else {
                NhanVien nv = this.getNhanVien();
                if (!checkEmail(nv.getEmail())) {
                    MsgBox.alert(this, "Email khong hop le");
                    return;
                }
                if (!checkPhoneNumber(nv.getSdt())) {
                    MsgBox.alert(this, "Sdt khong hop le");
                    return;
                }
                try {
                    if (nhanVienService.addNhanVien(nv) != null) {
                        MsgBox.alert(this, "Them Nhan Vien Thanh Cong");
                        this.loadData();
                        this.resetData();
                    } else {
                        MsgBox.alert(this, "Them Nhan Vien Khong Thanh Cong");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }else{
            MsgBox.alert(this, "Ban khong the xoa");
        }
    }//GEN-LAST:event_btn_ThemActionPerformed

    private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaActionPerformed
        // TODO add your handling code here:
        if (Auth.isManager()) {
            if (checkEmpty()) {
                return;
            } else {
                NhanVien nv = this.getNhanVien();
                if (!checkEmail(nv.getEmail())) {
                    MsgBox.alert(this, "Email khong hop le");
                    return;
                }
                if (!checkPhoneNumber(nv.getSdt())) {
                    MsgBox.alert(this, "Sdt khong hop le");
                    return;
                }
                nv.setId(Long.valueOf(tbl_NhanVien.getValueAt(index, 0).toString().trim()));
                System.out.println(nv.toString());
                try {
                    if (nhanVienService.updateNhanVien(nv) != null) {
                        MsgBox.alert(this, "Sua Nhan Vien Thanh Cong");
                        this.loadData();
                        this.resetData();
                    } else {
                        MsgBox.alert(this, "Sua Nhan Vien Khong Thanh Cong");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            MsgBox.alert(this, "Ban khong the xoa");
        }
    }//GEN-LAST:event_btn_SuaActionPerformed

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
         if (Auth.isManager()) {
        boolean check = MsgBox.confirm(this, "Ban Co Muon Xoa Hay Khong");
        if (check) {
            try {
                NhanVien nv = listNhanVien.get(index);
                if (nhanVienService.sortDeleteNhanVien(nv) != null) {
                    MsgBox.alert(this, "Xoa Nhan Vien Thanh Cong");
                    this.loadData();
                    this.resetData();
                } else {
                    MsgBox.alert(this, "Xoa Nhan Vien Khong Thanh Cong");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return;
        }
         }else{
             MsgBox.alert(this, "Ban khong the xoa");
         }
    }//GEN-LAST:event_btn_XoaActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        String keyword = txt_Keyword.getText().trim();
        Integer trangThai = null;
        if (rdo_HoatDong.isSelected()) {
            trangThai = 1;
        } else if (rdo_KhongHoatDong.isSelected()) {
            trangThai = 0;
        }

        dtm = (DefaultTableModel) tbl_NhanVien.getModel();
        dtm.setRowCount(0);
        for (NhanVien nhanVien : nhanVienService.findAll(keyword, trangThai)) {
            dtm.addRow(new Object[]{
                nhanVien.getId(),
                nhanVien.getMaNV(),
                nhanVien.getHoTenNV(),
                nhanVien.getMatKhau(),
                nhanVien.getNgaySinh(),
                nhanVien.getCccd(),
                nhanVien.getEmail(),
                nhanVien.getDiaChi(),
                nhanVien.getSdt(),
                nhanVien.getVaiTro() == 1 ? "Admin" : "Nhan Vien",
                nhanVien.getNgayTao(),
                nhanVien.getTrangThai() == 1 ? "Hoat Dong" : "Ngung Hoat Dong"
            });
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_LamMoi;
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbx_VaiTro;
    private javax.swing.JCheckBox chb_PassWord;
    private javax.swing.JCheckBox chb_TrangThai;
    private com.toedter.calendar.JDateChooser dc_NgaySinh;
    private com.toedter.calendar.JDateChooser dc_NgayTao;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_TongSoNhanVien;
    private javax.swing.JRadioButton rdo_HoatDong;
    private javax.swing.JRadioButton rdo_KhongHoatDong;
    private javax.swing.JTable tbl_NhanVien;
    private javax.swing.JTextField txt_CCCD;
    private javax.swing.JTextField txt_DiaChi;
    private javax.swing.JTextField txt_Email;
    private javax.swing.JTextField txt_HoTenNV;
    private javax.swing.JTextField txt_Keyword;
    private javax.swing.JTextField txt_MaNV;
    private javax.swing.JPasswordField txt_Pw;
    private javax.swing.JTextField txt_SDT;
    // End of variables declaration//GEN-END:variables
    private void loadData() {
        lbl_TongSoNhanVien.setText(String.valueOf(nhanVienService.soLuongNV()));
        listNhanVien = nhanVienService.findAll();

        cbx_VaiTro.removeAllItems();
        cbx_VaiTro.addItem("Admin");
        cbx_VaiTro.addItem("Nhan Vien");

        dtm = (DefaultTableModel) tbl_NhanVien.getModel();
        dtm.setRowCount(0);
        for (NhanVien nhanVien : listNhanVien) {
            dtm.addRow(new Object[]{
                nhanVien.getId(),
                nhanVien.getMaNV(),
                nhanVien.getHoTenNV(),
                nhanVien.getMatKhau(),
                nhanVien.getNgaySinh(),
                nhanVien.getCccd(),
                nhanVien.getEmail(),
                nhanVien.getDiaChi(),
                nhanVien.getSdt(),
                nhanVien.getVaiTro() == 1 ? "Admin" : "Nhan Vien",
                nhanVien.getNgayTao(),
                nhanVien.getTrangThai() == 1 ? "Hoat Dong" : "Ngung Hoat Dong"
            });
        }
    }

    private NhanVien getNhanVien() {
        NhanVien nv = new NhanVien();
        nv.setCccd(txt_CCCD.getText());
        nv.setDiaChi(txt_DiaChi.getText());
        nv.setHoTenNV(txt_HoTenNV.getText());
        nv.setMatKhau(String.valueOf(txt_Pw.getText()));
        nv.setEmail(txt_Email.getText());
        nv.setMaNV(txt_MaNV.getText());
        nv.setSdt(txt_SDT.getText());

        if (0 == cbx_VaiTro.getSelectedIndex()) {
            nv.setVaiTro(1);
        } else {
            nv.setVaiTro(0);
        }

        nv.setNgaySinh(XDate.toString(dc_NgaySinh.getDate(), "yyyy-MM-dd"));

        nv.setNgayTao(XDate.toString(dc_NgayTao.getDate() != null ? dc_NgayTao.getDate() : new Date(), "yyyy-MM-dd"));
        if (chb_TrangThai.isSelected()) {
            nv.setTrangThai(1);
        } else {
            nv.setTrangThai(0);
        }
        return nv;
    }

    private void resetData() {
        String text = "";
        txt_CCCD.setText(text);
        txt_DiaChi.setText(text);
        txt_Email.setText(text);
        txt_HoTenNV.setText(text);
        txt_MaNV.setText(text);
        txt_Pw.setText(text);
        txt_CCCD.setText(text);
        cbx_VaiTro.setSelectedIndex(0);
        chb_TrangThai.setSelected(false);
        chb_PassWord.setSelected(false);
        dc_NgaySinh.setDate(null);
        dc_NgayTao.setDate(null);
    }

    private boolean checkEmpty() {
        if (txt_CCCD.getText().trim().isBlank()) {
            MsgBox.alert(this, "Vui Long Nhap Du Du Lieu");
            return true;
        }
        if (txt_DiaChi.getText().trim().isBlank()) {
            MsgBox.alert(this, "Vui Long Nhap Du Du Lieu");
            return true;
        }
        if (txt_Email.getText().trim().isBlank()) {
            MsgBox.alert(this, "Vui Long Nhap Du Du Lieu");
            return true;
        }
        if (txt_HoTenNV.getText().trim().isBlank()) {
            MsgBox.alert(this, "Vui Long Nhap Du Du Lieu");
            return true;
        }
        if (txt_MaNV.getText().trim().isBlank()) {
            MsgBox.alert(this, "Vui Long Nhap Du Du Lieu");
            return true;
        }
        if (txt_Pw.getText().trim().isBlank()) {
            MsgBox.alert(this, "Vui Long Nhap Du Du Lieu");
            return true;
        }
        if (txt_SDT.getText().trim().isBlank()) {
            MsgBox.alert(this, "Vui Long Nhap Du Du Lieu");
            return true;
        }

        Date checkDate = dc_NgaySinh.getDate();

        if (checkDate == null) {
            MsgBox.alert(this, "Vui Long Nhap Du Du Lieu");
            return true;
        }

        checkDate = dc_NgayTao.getDate();

        if (checkDate == null) {
            MsgBox.alert(this, "Vui Long Nhap Du Du Lieu");
            return true;
        }
        return false;
    }

    private boolean checkEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."
                + "[a-zA-Z0-9_+&*-]+)*@"
                + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                + "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null) {
            return false;
        }
        return pat.matcher(email).matches();
    }

    private boolean checkPhoneNumber(String phoneNumber) {
        String phoneRegex = "^0\\d{9}$";
        Pattern pat = Pattern.compile(phoneRegex);
        if (phoneNumber == null) {
            return false;
        }
        return pat.matcher(phoneNumber).matches();
    }
}
