package javaswingdev.form;

import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;
import javaswingdev.entity.HoaDon;
import Utils.*;
import javaswingdev.entity.KhachHang;
import javaswingdev.entity.NhanVien;
import javaswingdev.service.HoaDonService;
import javaswingdev.service.KhachHangService;
import javaswingdev.service.NhanVienService;
import javax.swing.table.DefaultTableModel;

public class Form_KhachHang extends javax.swing.JPanel {

    private DefaultTableModel dtm = new DefaultTableModel();
    private final KhachHangService khs = new KhachHangService();
    private final HoaDonService hds = new HoaDonService();
    private final NhanVienService nvs = new NhanVienService();
    private List<KhachHang> listKhachHang;
    private int index = -1;

    public Form_KhachHang(String name) {
        initComponents();
        this.loadData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_KhachHang = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        txt_TimKiem2 = new javax.swing.JTextField();
        cbx_TrangThai2 = new javax.swing.JComboBox<>();
        btn_TimKiem2 = new javax.swing.JButton();
        cbx_LocGioiTinh2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_HDKH = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_TenNV = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_SDT = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_Email = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_TenKH = new javax.swing.JTextField();
        txt_MaKH = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_DiaChi = new javax.swing.JTextField();
        dc_NgayTao = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        dc_NgaySinh = new com.toedter.calendar.JDateChooser();
        chb_TrangThai = new javax.swing.JCheckBox();
        cbx_GioiTinh = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        btn_Them = new javax.swing.JButton();
        btn_Sua = new javax.swing.JButton();
        btn_LamMoi = new javax.swing.JButton();
        btn_Xoa = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1180, 640));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Thông tin khách hàng");
        jLabel1.setPreferredSize(new java.awt.Dimension(219, 32));

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jButton3.setText(">");

        jButton4.setText(">>");

        tbl_KhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Id NV", "Ma KH", "Ten KH", "SDT", "NgaySinh", "GioiTinh", "Email", "Dia Chi", "Ngay Tao", "Trang Thai"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_KhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_KhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_KhachHang);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm Kiếm"));

        cbx_TrangThai2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_TimKiem2.setText("Tìm kiếm");
        btn_TimKiem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TimKiem2ActionPerformed(evt);
            }
        });

        cbx_LocGioiTinh2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_TimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(cbx_LocGioiTinh2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbx_TrangThai2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_TimKiem2)
                .addContainerGap(655, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_TimKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_TrangThai2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_TimKiem2)
                    .addComponent(cbx_LocGioiTinh2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jButton1.setText("<<");

        jButton2.setText("<");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(1014, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addContainerGap()))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(556, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(15, 15, 15))
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel7Layout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(50, Short.MAX_VALUE)))
        );

        jTabbedPane2.addTab("Danh Sách Khách Hàng", jPanel7);

        tbl_HDKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "IDHD", "IDNV", "MAHD", "PTTT", "ThanhTien", "TrangThai"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_HDKH);

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Lịch Sử Mua Hàng Của :");

        jLabel14.setText("jLabel14");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1178, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Lịch Sử Mua", jPanel8);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Thiết lập thông tin khách hàng ");
        jLabel2.setPreferredSize(new java.awt.Dimension(219, 32));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1180, -1));

        jLabel3.setText("Tên NV :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        txt_TenNV.setEditable(false);
        jPanel1.add(txt_TenNV, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 240, -1));

        jLabel4.setText("Mã KH :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));
        jPanel1.add(txt_SDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 260, -1));

        jLabel5.setText("SĐT :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, -1, -1));

        jTextField3.setText("jTextField1");
        jPanel1.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(-460, 210, -1, -1));

        jLabel6.setText("Ngày Sinh :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 50, -1, -1));
        jPanel1.add(txt_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 260, -1));

        jLabel7.setText("Tên KH :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, -1, -1));
        jPanel1.add(txt_TenKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 260, -1));
        jPanel1.add(txt_MaKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 240, -1));

        jLabel8.setText("Email :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, -1, -1));

        jLabel9.setText("Địa Chỉ :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 130, -1, -1));
        jPanel1.add(txt_DiaChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 130, 200, -1));

        dc_NgayTao.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(dc_NgayTao, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 240, -1));

        jLabel10.setText("Giới tính :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 90, -1, -1));

        jLabel11.setText("Ngày tạo :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel12.setText("Trạng Thái :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        dc_NgaySinh.setDateFormatString("yyyy-MM-dd");
        jPanel1.add(dc_NgaySinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 50, 200, -1));

        chb_TrangThai.setText("Hoạt động");
        jPanel1.add(chb_TrangThai, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        cbx_GioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbx_GioiTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 90, 200, -1));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Sua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Them, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_LamMoi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_Xoa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
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

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 40, -1, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        // TODO add your handling code here:
        if (checkEmpty()) {
            return;
        }
        KhachHang nv = this.getKhachHang();
        if (!checkEmail(nv.getEmail())) {
            MsgBox.alert(this, "Email khong hop le");
            return;
        }
        if (!checkPhoneNumber(nv.getSdt())) {
            MsgBox.alert(this, "Sdt khong hop le");
            return;
        }

        try {
            if (khs.addKhachHang(nv) != null) {
                MsgBox.alert(this, "Them Khach Hang Thanh Cong");
                this.loadData();
                this.resetData();
            } else {
                MsgBox.alert(this, "Them Khach Hang Khong Thanh Cong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_ThemActionPerformed

    private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaActionPerformed
        // TODO add your handling code here:
        if (checkEmpty()) {
            return;
        }
        KhachHang nv = this.getKhachHang();

        if (!checkEmail(nv.getEmail())) {
            MsgBox.alert(this, "Email khong hop le");
            return;
        }
        if (!checkPhoneNumber(nv.getSdt())) {
            MsgBox.alert(this, "Sdt khong hop le");
            return;
        }
        nv.setId(listKhachHang.get(index).getId());
        try {
            if (khs.updateKhachHang(nv) != null) {
                MsgBox.alert(this, "Sua Khach Hang Thanh Cong");
                this.loadData();
                this.resetData();
            } else {
                MsgBox.alert(this, "Sua Khach Hang Khong Thanh Cong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_SuaActionPerformed

    private void btn_LamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LamMoiActionPerformed
        // TODO add your handling code here:
        this.resetData();
        this.loadData();
    }//GEN-LAST:event_btn_LamMoiActionPerformed

    private void btn_XoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_XoaActionPerformed
        // TODO add your handling code here:
        boolean check = MsgBox.confirm(this, "Ban Co Muon Xoa Hay Khong");

        if (check) {
            KhachHang nv = this.getKhachHang();
            nv.setId(listKhachHang.get(index).getId());
            try {
                if (khs.sortDeleteKhachHang(nv) != null) {
                    MsgBox.alert(this, "Xoa Khach Hang Thanh Cong");
                    this.loadData();
                    this.resetData();
                } else {
                    MsgBox.alert(this, "Xoa Khach Hang Khong Thanh Cong");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return;
        }
    }//GEN-LAST:event_btn_XoaActionPerformed

    private void tbl_KhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_KhachHangMouseClicked
        // TODO add your handling code here:
        index = tbl_KhachHang.getSelectedRow();
        txt_Email.setText(listKhachHang.get(index).getEmail());
        txt_MaKH.setText(listKhachHang.get(index).getMaKH());
        txt_SDT.setText(listKhachHang.get(index).getSdt());
        txt_TenKH.setText(listKhachHang.get(index).getTenKH());
        txt_TenNV.setText(nvs.findByID(listKhachHang.get(index).getIdNV().getId()).getHoTenNV());
        txt_DiaChi.setText(listKhachHang.get(index).getDiaChi());
        cbx_GioiTinh.setSelectedItem(tbl_KhachHang.getValueAt(index, 6).toString().trim());
        dc_NgaySinh.setDate(listKhachHang.get(index).getNgaySinh());
        dc_NgayTao.setDate(listKhachHang.get(index).getNgayTao());
        if (listKhachHang.get(index).getTrangThai() == true) {
            chb_TrangThai.setSelected(true);
        } else {
            chb_TrangThai.setSelected(false);
        }
        this.loadDataHD(listKhachHang.get(index).getId());
    }//GEN-LAST:event_tbl_KhachHangMouseClicked

    private void btn_TimKiem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TimKiem2ActionPerformed
        // TODO add your handling code here:
        String keyword = txt_TimKiem2.getText().trim();
        Integer gioiTinh = cbx_LocGioiTinh2.getSelectedIndex();
        Integer trangThai = cbx_TrangThai2.getSelectedIndex();
        dtm = (DefaultTableModel) tbl_KhachHang.getModel();
        dtm.setRowCount(0);
        for (KhachHang khachHang : khs.findAll(keyword, gioiTinh, trangThai)) {
            dtm.addRow(new Object[]{
                khachHang.getId(),
                khachHang.getId(),
                khachHang.getMaKH(),
                khachHang.getTenKH(),
                khachHang.getSdt(),
                khachHang.getNgaySinh(),
                khachHang.isGioiTinh()== true ? "Nu" : "Nam",
                khachHang.getEmail(),
                khachHang.getDiaChi(),
                khachHang.getNgayTao(),
                khachHang.getTrangThai() == true ? "Hoạt động" : "Ngưng hoạt động"
            });
        }
    }//GEN-LAST:event_btn_TimKiem2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_LamMoi;
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_TimKiem2;
    private javax.swing.JButton btn_Xoa;
    private javax.swing.JComboBox<String> cbx_GioiTinh;
    private javax.swing.JComboBox<String> cbx_LocGioiTinh2;
    private javax.swing.JComboBox<String> cbx_TrangThai2;
    private javax.swing.JCheckBox chb_TrangThai;
    private com.toedter.calendar.JDateChooser dc_NgaySinh;
    private com.toedter.calendar.JDateChooser dc_NgayTao;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTable tbl_HDKH;
    private javax.swing.JTable tbl_KhachHang;
    private javax.swing.JTextField txt_DiaChi;
    private javax.swing.JTextField txt_Email;
    private javax.swing.JTextField txt_MaKH;
    private javax.swing.JTextField txt_SDT;
    private javax.swing.JTextField txt_TenKH;
    private javax.swing.JTextField txt_TenNV;
    private javax.swing.JTextField txt_TimKiem2;
    // End of variables declaration//GEN-END:variables
    private void loadData() {
        listKhachHang = khs.findAll();

        cbx_GioiTinh.removeAllItems();
        cbx_GioiTinh.addItem("Nam");
        cbx_GioiTinh.addItem("Nu");
        cbx_LocGioiTinh2.removeAllItems();
        cbx_LocGioiTinh2.addItem("Nam");
        cbx_LocGioiTinh2.addItem("Nu");
        
        cbx_TrangThai2.removeAllItems();
        cbx_TrangThai2.addItem("Ngung Hoat Dong");
        cbx_TrangThai2.addItem("Hoat dong");
        
        dtm = (DefaultTableModel) tbl_KhachHang.getModel();
        dtm.setRowCount(0);
        for (KhachHang khachHang : listKhachHang) {
            dtm.addRow(new Object[]{
                khachHang.getId(),
                khachHang.getId(),
                khachHang.getMaKH(),
                khachHang.getTenKH(),
                khachHang.getSdt(),
                khachHang.getNgaySinh(),
                khachHang.isGioiTinh()== true ? "Nu" : "Nam",
                khachHang.getEmail(),
                khachHang.getDiaChi(),
                khachHang.getNgayTao(),
                khachHang.getTrangThai() == true ? "Hoạt động" : "Ngưng hoạt động"
            });
        }
    }

    private void loadDataHD(Long idKH) {
        dtm = (DefaultTableModel) tbl_HDKH.getModel();
        dtm.setRowCount(0);
        for (HoaDon hd : hds.findHDbyIDKH(idKH)) {
            dtm.addRow(new Object[]{
                hd.getId(),
                hd.getIdNV().getId(),
                hd.getMaHoaDon(),
                hd.getPhuongThucTT(),
                Format.format(hd.getThanhTien()),
                hd.getTrangThai()
            });
        }
    }

    private KhachHang getKhachHang() {
        KhachHang khachHang = new KhachHang();
        NhanVien nv = Auth.user;
        khachHang.setIdNV(nv);
        khachHang.setEmail(txt_Email.getText());
        khachHang.setMaKH(txt_MaKH.getText());
        khachHang.setSdt(txt_SDT.getText());
        khachHang.setTenKH(txt_TenKH.getText());
        khachHang.setDiaChi(txt_DiaChi.getText());

        if (0 == cbx_GioiTinh.getSelectedIndex()) {
            khachHang.setGioiTinh(false);
        } else {
            khachHang.setGioiTinh(true);
        }
        khachHang.setNgaySinh(dc_NgaySinh.getDate());
        khachHang.setNgayTao(dc_NgayTao.getDate());

        if (chb_TrangThai.isSelected()) {
            khachHang.setTrangThai(true);
        } else {
            khachHang.setTrangThai(false);
        }

        return khachHang;
    }

    private void resetData() {
        String text = "";
        txt_SDT.setText(text);
        txt_DiaChi.setText(text);
        txt_Email.setText(text);
        txt_TenNV.setText(text);
        txt_TenKH.setText(text);
        cbx_GioiTinh.setSelectedIndex(0);
        chb_TrangThai.setSelected(false);
        dc_NgaySinh.setDate(null);
        dc_NgayTao.setDate(null);
    }

    private boolean checkEmpty() {
        if (txt_DiaChi.getText().trim().isBlank()) {
            MsgBox.alert(this, "Vui Long Nhap Du Du Lieu");
            return true;
        }
        if (txt_Email.getText().trim().isBlank()) {
            MsgBox.alert(this, "Vui Long Nhap Du Du Lieu");
            return true;
        }
        if (txt_MaKH.getText().trim().isBlank()) {
            MsgBox.alert(this, "Vui Long Nhap Du Du Lieu");
            return true;
        }
        if (txt_SDT.getText().trim().isBlank()) {
            MsgBox.alert(this, "Vui Long Nhap Du Du Lieu");
            return true;
        }
        if (txt_TenKH.getText().trim().isBlank()) {
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
