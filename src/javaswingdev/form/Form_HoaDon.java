package javaswingdev.form;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javaswingdev.entity.HoaDon;
import javaswingdev.entity.HoaDonChiTiet;
import javaswingdev.impl.ExcelHoaDon;
import javaswingdev.jnafilechooser.api.JnaFileChooser;
import javaswingdev.main.DangNhap1;
import javaswingdev.service.HoaDonChiTietService;
import javaswingdev.service.HoaDonService;
import Utils.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class Form_HoaDon extends javax.swing.JPanel {

    private static HoaDonService hoaDonService = new HoaDonService();
    private static HoaDonChiTietService hoaDonChiTietService = new HoaDonChiTietService();
    private static List<HoaDon> listHD = new ArrayList<>();
    private static List<HoaDon> listEx = new ArrayList<>();
    private static List<HoaDonChiTiet> listHDCT = new ArrayList<>();
    private ExcelHoaDon excelHoaDon = new ExcelHoaDon();
    static int page = 1;
    static int lmit = 9;
    private int index = 1;
    private int gioiHanPage = (int) ((Math.ceil(hoaDonService.getRowCountHD() / lmit))) + 1;

    public Form_HoaDon(String name) {
        initComponents();
//        lb.setText("Form " + name);
        listHD = hoaDonService.getAll_HD("", page, lmit);
        fillToTableHD(listHD);
    }

    private void fillToTableHD(List<HoaDon> list) {
        DefaultTableModel dtm = (DefaultTableModel) this.tblHoaDon.getModel();
        int i = 1;
        dtm.setRowCount(0);
        for (HoaDon hd : list) {
            dtm.addRow(hd.rowDataHD(i));
            i++;
        }
        lblSoHD.setText(hoaDonService.getRowCountHD() + "");
    }

    private void fillToTableHDCT(List<HoaDonChiTiet> list) {
        DefaultTableModel dtm = (DefaultTableModel) this.tblHoaDonChiTiet.getModel();
        int i = 1;
        dtm.setRowCount(0);
        for (HoaDonChiTiet hdct : list) {
            dtm.addRow(hdct.rowDataHD(i));
            i++;
        }
    }

    private void first() {
        if (index == 2) {
            listHD = hoaDonService.getAll_Loc(txtTuNgay.getDate(), txtDenNgay.getDate(), cboTrangThai.getSelectedIndex() - 1, 1, lmit);
            lblPageTTKH.setText(1 + " / " + gioiHanPage);
            fillToTableHD(listHD);
            index = 1;
        } else {
            listHD = hoaDonService.getAll_HD(txtTimKiem.getText().trim(), page, lmit);
            lblPageTTKH.setText(1 + " / " + gioiHanPage);
            fillToTableHD(listHD);
        }

        //  fillTable(listHD);
    }

    private void prev() {
        page--;

        if (page >= 1) {
            if (index == 2) {
                lblPageTTKH.setText(page + " / " + gioiHanPage);
                listHD = hoaDonService.getAll_Loc(txtTuNgay.getDate(), txtDenNgay.getDate(), cboTrangThai.getSelectedIndex() - 1, page, lmit);
                fillToTableHD(listHD);
                return;
            } else {

                lblPageTTKH.setText(page + " / " + gioiHanPage);
                listHD = hoaDonService.getAll_HD(txtTimKiem.getText().trim(), page, lmit);
                fillToTableHD(listHD);
                return;

            }
        }
        page = 1;

    }

    private void next() {
        page++;

        if (page <= gioiHanPage) {
            if (index == 2) {
                listHD = hoaDonService.getAll_Loc(txtTuNgay.getDate(), txtDenNgay.getDate(), cboTrangThai.getSelectedIndex() - 1, page, lmit);
                fillToTableHD(listHD);
                lblPageTTKH.setText(page + " / " + gioiHanPage);
                return;
            } else {
                listHD = hoaDonService.getAll_HD(txtTimKiem.getText().trim(), page, lmit);
                fillToTableHD(listHD);
                lblPageTTKH.setText(page + " / " + gioiHanPage);
                return;
            }
        }
        page = gioiHanPage;
    }

    private void last() {
        if (index == 2) {
            listHD = hoaDonService.getAll_Loc(txtTuNgay.getDate(), txtDenNgay.getDate(), cboTrangThai.getSelectedIndex() - 1, page, lmit);
            lblPageTTKH.setText(gioiHanPage + " / " + gioiHanPage);
            fillToTableHD(listHD);
            index = 1;
        } else {
            listHD = hoaDonService.getAll_HD(txtTimKiem.getText().trim(), page, lmit);
            lblPageTTKH.setText(gioiHanPage + " / " + gioiHanPage);
            fillToTableHD(listHD);
        }

    }

    public boolean compareDates(String dateStr1, String dateStr2) {
        // Định dạng để chuyển đổi từ chuỗi sang LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Chuyển đổi chuỗi thành LocalDate
        LocalDate date1 = LocalDate.parse(dateStr1, formatter);
        LocalDate date2 = LocalDate.parse(dateStr2, formatter);

        // So sánh ngày
        return date2.isAfter(date1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cboTrangThai = new javax.swing.JComboBox<>();
        btnLoc = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        lblSoHD = new javax.swing.JLabel();
        btnDau = new javax.swing.JButton();
        btnLui = new javax.swing.JButton();
        lblPageTTKH = new javax.swing.JLabel();
        btnTien = new javax.swing.JButton();
        btnCuoi = new javax.swing.JButton();
        btnXuatDSHD = new javax.swing.JButton();
        btnInHoaDon = new javax.swing.JButton();
        btnXemChiTiet = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtTuNgay = new com.toedter.calendar.JDateChooser();
        txtDenNgay = new com.toedter.calendar.JDateChooser();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblHoaDonChiTiet = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setText("Hóa đơn chi tiết");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã HĐ", "Mã NV", "Mã KH", "Tổng tiền", "Ngày tạo", "Ngày thanh toán", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        jLabel1.setText("Tìm kiếm:");

        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        jLabel2.setText("Từ ngày:");

        jLabel3.setText("Đến ngày:");

        jLabel4.setText("Trạng thái hóa đơn");

        cboTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---- Tất cả ----", "Chưa thanh toán", "Đã thanh toán", "Đang giao", "Thanh toán trước", "Hủy" }));

        btnLoc.setText("Lọc");
        btnLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocActionPerformed(evt);
            }
        });

        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        jLabel6.setText("Số hóa đơn:");

        lblSoHD.setText("0");

        btnDau.setText("<<");
        btnDau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDauActionPerformed(evt);
            }
        });

        btnLui.setText("<");
        btnLui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuiActionPerformed(evt);
            }
        });

        lblPageTTKH.setText("1/2");

        btnTien.setText(">");
        btnTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTienActionPerformed(evt);
            }
        });

        btnCuoi.setText(">>");
        btnCuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCuoiActionPerformed(evt);
            }
        });

        btnXuatDSHD.setText("Xuất danh sách hóa đơn");
        btnXuatDSHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatDSHDActionPerformed(evt);
            }
        });

        btnInHoaDon.setText("In hóa đơn");

        btnXemChiTiet.setText("Xem chi tiết");
        btnXemChiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXemChiTietActionPerformed(evt);
            }
        });

        btnHuy.setText("Hủy");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        jLabel9.setText("Danh sách hóa đơn:");

        txtTuNgay.setDateFormatString("dd-MM-yyyy");

        txtDenNgay.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(lblSoHD)
                                .addGap(98, 98, 98)
                                .addComponent(btnDau)
                                .addGap(18, 18, 18)
                                .addComponent(btnLui, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblPageTTKH)
                                .addGap(18, 18, 18)
                                .addComponent(btnTien, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCuoi)
                                .addGap(37, 37, 37)
                                .addComponent(btnInHoaDon)
                                .addGap(18, 18, 18)
                                .addComponent(btnXuatDSHD)
                                .addGap(18, 18, 18)
                                .addComponent(btnXemChiTiet)
                                .addGap(18, 18, 18)
                                .addComponent(btnHuy))
                            .addComponent(jLabel9))
                        .addGap(0, 309, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                            .addComponent(txtTuNgay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLamMoi))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLamMoi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnLoc))
                            .addComponent(txtTuNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtDenNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblSoHD)
                    .addComponent(btnDau)
                    .addComponent(lblPageTTKH)
                    .addComponent(btnTien)
                    .addComponent(btnInHoaDon)
                    .addComponent(btnXuatDSHD)
                    .addComponent(btnXemChiTiet)
                    .addComponent(btnLui)
                    .addComponent(btnCuoi)
                    .addComponent(btnHuy))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblHoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Số lượng", "Giá bán", "Thành tiền"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblHoaDonChiTiet);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(88, 88, 88))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 1309, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Quản lý hóa đơn", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 862, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDauActionPerformed
        // TODO add your handling code here:
        first();
    }//GEN-LAST:event_btnDauActionPerformed

    private void btnLuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuiActionPerformed
        // TODO add your handling code here:
        prev();
    }//GEN-LAST:event_btnLuiActionPerformed

    private void btnTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTienActionPerformed
        // TODO add your handling code here:
        next();
    }//GEN-LAST:event_btnTienActionPerformed

    private void btnCuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCuoiActionPerformed
        // TODO add your handling code here:
        last();
    }//GEN-LAST:event_btnCuoiActionPerformed

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        // TODO add your handling code here:
        index = 1;
        String tt = txtTimKiem.getText().trim();
        if (tt.isEmpty()) {

            return;
        }
        listHD = hoaDonService.getAll_HD(tt, page, lmit);
        fillToTableHD(listHD);
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        txtTimKiem.setText("");
        txtTuNgay.setDate(null);
        txtDenNgay.setDate(null);
        cboTrangThai.setSelectedIndex(0);
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        // TODO add your handling code here:
//        String maHD = tblHoaDon.getValueAt(tblHoaDon.getSelectedRow(), 1).toString();
//
//        if (MsgBox.confirm(this, "Bạn muốn hủy hóa đơn: " + maHD)) {
//            hoaDonService.updateTTHD(maHD, 4);
//            listHD = hoaDonService.getAll_HD("", page, lmit);
//            fillToTableHD(listHD);
//        }
    }//GEN-LAST:event_btnHuyActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        // TODO add your handling code here:
        int index = tblHoaDon.getSelectedRow();
        String maHD = tblHoaDon.getValueAt(index, 1).toString();
        String tt = tblHoaDon.getValueAt(index, 7).toString();
        if (tt.endsWith("Chờ thanh toán")) {
            btnHuy.setVisible(true);
        } else {
            btnHuy.setVisible(false);
        }
        listHDCT = hoaDonChiTietService.getListCTHDByMaHD(maHD);
        fillToTableHDCT(listHDCT);
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocActionPerformed
        // TODO add your handling code here:
        try {
            index = 2;
            Date date1 = null;
            Date date2 = null;
            int tt = cboTrangThai.getSelectedIndex() - 1;
            try {
                date1 = txtTuNgay.getDate();
                date2 = txtDenNgay.getDate();
            } catch (Exception e) {
                MsgBox.aleart(this, "Ngày tháng năm không hợp lệ");
                return;
            }
            if (date1 != null || date2 != null) {
                if (date1 == null || date2 == null) {
                    MsgBox.aleart(this, "Bạn hãy điền đúng 2 ngày");
                    return;
                }

            }
            if (date1 != null && date2 != null) {

                System.out.println("Vaof ");
                if (!Utils.Validate.isDate(XDate.toString(date1, "dd-MM-yyyy"))) {
                    MsgBox.aleart(this, "Ngày sinh sai định dạng dd-MM-yyyy");
                    txtTuNgay.requestFocus();
                    return;
                }
                if (!Utils.Validate.isDate(XDate.toString(date2, "dd-MM-yyyy"))) {
                    MsgBox.aleart(this, "Ngày sinh sai định dạng dd-MM-yyyy");
                    txtDenNgay.requestFocus();
                    return;
                }
                try {
                    XDate.toDate(XDate.toString(date1, "dd-MM-yyyy"), "dd-MM-yyyy");
                    XDate.toDate(XDate.toString(date2, "dd-MM-yyyy"), "dd-MM-yyyy");
                } catch (Exception e) {
                    MsgBox.aleart(this, "Ngày hoặc Tháng hoặc Năm sai ");

                    return;
                }

                if (!compareDates(XDate.toString(date1, "dd-MM-yyyy"), XDate.toString(date2, "dd-MM-yyyy"))) {
                    MsgBox.aleart(this, "Ngày bắt đầu phải nhỏ hơn ngày kết thúc");
                    return;
                }
            }

            System.out.println(" tt " + tt);
            listHD = hoaDonService.getAll_Loc(date1, date2, tt, 1, lmit);
            listEx = hoaDonService.getAll_Loc_ALL(date2, date2, tt);
            fillToTableHD(listHD);
            lblPageTTKH.setText(page + " / " + gioiHanPage);
        } catch (Exception e) {
            MsgBox.aleart(this, "Bạn hay kiểm tra lại thông tin");
        }
    }//GEN-LAST:event_btnLocActionPerformed

    private void btnXemChiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXemChiTietActionPerformed
        // TODO add your handling code here:
        int index = tblHoaDon.getSelectedRow();
        if (index < 0) {
            MsgBox.alert(this, "Bạn hãy chọn một hóa đơn");
            return;
        }
        String maHD = tblHoaDon.getValueAt(index, 1).toString();
        System.out.println("ravormed()" + " " + hoaDonChiTietService.viewCTHDByMaHD(maHD));

        View_CTHD view_CTHD = new View_CTHD(new DangNhap1(), true, maHD);
        view_CTHD.setVisible(true);

    }//GEN-LAST:event_btnXemChiTietActionPerformed

    private void btnXuatDSHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatDSHDActionPerformed
        // TODO add your handling code here:
        JnaFileChooser jfc = new JnaFileChooser();
        jfc.setMode(JnaFileChooser.Mode.Directories);
        if (!jfc.showOpenDialog((JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, this))) {
            return;
        }
        String path = jfc.getSelectedFile().getAbsolutePath();
        LocalDateTime local = LocalDateTime.now();
        File file = new File(path + "\\Danh_Sach_HD_" + local.getDayOfMonth() + "_" + local.getMonthValue() + "_" + local.getYear() + ".xlsx");

        if (excelHoaDon.export(file, listEx)) {
            JOptionPane.showMessageDialog(this, "Export thành công", "Export", JOptionPane.INFORMATION_MESSAGE);
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (file.exists()) {
                    try {
                        desktop.open(file);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Mở thất bại", "Export", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Thất bại", "Export", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnXuatDSHDActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCuoi;
    private javax.swing.JButton btnDau;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnInHoaDon;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLoc;
    private javax.swing.JButton btnLui;
    private javax.swing.JButton btnTien;
    private javax.swing.JButton btnXemChiTiet;
    private javax.swing.JButton btnXuatDSHD;
    private javax.swing.JComboBox<String> cboTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblPageTTKH;
    private javax.swing.JLabel lblSoHD;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblHoaDonChiTiet;
    private com.toedter.calendar.JDateChooser txtDenNgay;
    private javax.swing.JTextField txtTimKiem;
    private com.toedter.calendar.JDateChooser txtTuNgay;
    // End of variables declaration//GEN-END:variables
}
