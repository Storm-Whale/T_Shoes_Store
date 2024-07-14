package javaswingdev.form;

import Utils.Auth;
import Utils.MsgBox;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javaswingdev.entity.MauSac;
import javaswingdev.impl.DisplayValueProvider;
import javaswingdev.service.MauService;
import javax.swing.table.DefaultTableModel;

public class MauSacJDialog extends javax.swing.JDialog {

//    private DefaultTableModel dtm = new DefaultTableModel();
    private final MauService mauService = new MauService();
    private List<MauSac> listMauSac = new ArrayList<>();
    private int index = -1;
    private MauSac returnMauSac;

    public MauSacJDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    private void init() {
        this.setLocationRelativeTo(null);
        this.loadDataTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        btn_Them = new javax.swing.JButton();
        btn_Sua = new javax.swing.JButton();
        btn_LamMoi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_MaMau = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_TenMau = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        rdo_CSD = new javax.swing.JRadioButton();
        rdo_NSD = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_MauSac = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        txt_TimKiem = new javax.swing.JTextField();
        rdo_TKCSD = new javax.swing.JRadioButton();
        rdo_TKNSD = new javax.swing.JRadioButton();
        btn_TimKiem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        btn_LamMoi.setText("Làm Mới");
        btn_LamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LamMoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_Them, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_LamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_Sua, btn_Them});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Them)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_Sua, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_LamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_Sua, btn_Them});

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Danh Sách Màu Sắc");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Mã Màu :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Tên Màu :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Trạng Thái :");

        buttonGroup1.add(rdo_CSD);
        rdo_CSD.setText("Còn Sử Dụng");

        buttonGroup1.add(rdo_NSD);
        rdo_NSD.setText("Ngưng Sử Dụng");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rdo_CSD)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdo_NSD))
                    .addComponent(txt_MaMau)
                    .addComponent(txt_TenMau, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_MaMau, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txt_TenMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rdo_CSD)
                    .addComponent(rdo_NSD))
                .addContainerGap())
        );

        tbl_MauSac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Mã Màu", "Tên Màu", "Người Tạo", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_MauSac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_MauSacMouseClicked(evt);
            }
        });
        tbl_MauSac.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbl_MauSacKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_MauSac);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        buttonGroup2.add(rdo_TKCSD);
        rdo_TKCSD.setText("Còn Sử Dụng");

        buttonGroup2.add(rdo_TKNSD);
        rdo_TKNSD.setText("Ngưng Sử Dụng");

        btn_TimKiem.setText("Tìm kiếm");
        btn_TimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_TimKiemMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(rdo_TKCSD)
                .addGap(18, 18, 18)
                .addComponent(rdo_TKNSD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_TimKiem)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rdo_TKCSD)
                    .addComponent(rdo_TKNSD)
                    .addComponent(btn_TimKiem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemActionPerformed
        // TODO add your handling code here:
        if (checkValidate()) {
            return;
        }
        
        if(checkDuplicateAll()) {
            return;
        }

        MauSac mausac = this.getInputMauSac();
        try {
            if (mauService.addMauSac(mausac) != null) {
                MsgBox.alert(this, "Them Thanh Cong");
                this.refresh();
            } else {
                MsgBox.alert(this, "Them Khong Thanh Cong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_ThemActionPerformed

    private void btn_SuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaActionPerformed
        // TODO add your handling code here:
        if (index == -1) {
            MsgBox.alert(this, "Vui Long Chon Mau Sac");
            return;
        }

        if (checkValidate()) {
            return;
        }

        MauSac mausac = this.getInputMauSac();
        mausac.setIdMau(listMauSac.get(index).getIdMau());
        try {
            if (mauService.updateMauSac(mausac) != null) {
                MsgBox.alert(this, "Sua Thanh Cong");
                this.refresh();
            } else {
                MsgBox.alert(this, "Sua Khong Thanh Cong");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_SuaActionPerformed

    private void tbl_MauSacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_MauSacMouseClicked
        // TODO add your handling code here:
        index = tbl_MauSac.getSelectedRow();
        this.setForm(index);
    }//GEN-LAST:event_tbl_MauSacMouseClicked

    private void tbl_MauSacKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbl_MauSacKeyReleased
        // TODO add your handling code here:
        if (index == -1) {
            MsgBox.alert(this, "Vui Long Chon Mau Sac");
            return;
        }

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            returnMauSac = listMauSac.get(index);
            this.dispose();
        }
    }//GEN-LAST:event_tbl_MauSacKeyReleased

    private void btn_TimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_TimKiemMouseClicked
        // TODO add your handling code here:
        String keyword = txt_TimKiem.getText();
        Integer trangthai = null;
        if (rdo_CSD.isSelected()) {
            trangthai = 0;
        }
        if (rdo_TKNSD.isSelected()) {
            trangthai = 1;
        }
        
        listMauSac = mauService.getToAll(keyword, trangthai);
        DefaultTableModel dtm = (DefaultTableModel) tbl_MauSac.getModel();
        dtm.setRowCount(0);
        for (MauSac mauSac : listMauSac) {
            dtm.addRow(new Object[]{
                mauSac.getIdMau(),
                mauSac.getMaMau(),
                mauSac.getTenMau(),
                mauSac.getNguoiTao(),
                mauSac.getTrangThai() == 0 ? "Con Su Dung" : "Ngung Su Dung"
            });
        }
    }//GEN-LAST:event_btn_TimKiemMouseClicked

    private void btn_LamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LamMoiActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_btn_LamMoiActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MauSacJDialog dialog = new MauSacJDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_LamMoi;
    private javax.swing.JButton btn_Sua;
    private javax.swing.JButton btn_Them;
    private javax.swing.JButton btn_TimKiem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdo_CSD;
    private javax.swing.JRadioButton rdo_NSD;
    private javax.swing.JRadioButton rdo_TKCSD;
    private javax.swing.JRadioButton rdo_TKNSD;
    private javax.swing.JTable tbl_MauSac;
    private javax.swing.JTextField txt_MaMau;
    private javax.swing.JTextField txt_TenMau;
    private javax.swing.JTextField txt_TimKiem;
    // End of variables declaration//GEN-END:variables
    private void loadDataTable() {
        DefaultTableModel dtm = (DefaultTableModel) tbl_MauSac.getModel();
        dtm.setRowCount(0);
        listMauSac = mauService.getToAll();
        for (MauSac mauSac : listMauSac) {
            dtm.addRow(new Object[]{
                mauSac.getIdMau(),
                mauSac.getMaMau(),
                mauSac.getTenMau(),
                mauSac.getNguoiTao(),
                mauSac.getTrangThai() == 0 ? "Con Su Dung" : "Ngung Su Dung"
            });
        }
    }

    private void setForm(int index) {
        txt_MaMau.setText(listMauSac.get(index).getMaMau());
        txt_TenMau.setText(listMauSac.get(index).getTenMau());
        if (listMauSac.get(index).getTrangThai() == 0) {
            rdo_CSD.setSelected(true);
        } else {
            rdo_NSD.setSelected(true);
        }
    }

    private MauSac getInputMauSac() {
        MauSac mauSac = new MauSac();
        mauSac.setMaMau(txt_MaMau.getText());
        mauSac.setTenMau(txt_TenMau.getText());
        mauSac.setNguoiTao(Auth.user.getHoTenNV());
        if (rdo_CSD.isSelected()) {
            mauSac.setTrangThai(0);
        } else {
            mauSac.setTrangThai(1);
        }
        return mauSac;
    }

    private void refresh() {
        String text = "";
        txt_MaMau.setText(text);
        txt_TenMau.setText(text);
        txt_TimKiem.setText(text);
        rdo_CSD.setSelected(true);
        this.loadDataTable();
    }

    public MauSac returnSelectedMauSac() {
        return returnMauSac;
    }

    private boolean checkValidate() {
        if (txt_MaMau.getText().isEmpty() || txt_MaMau.getText().trim().length() == 0) {
            MsgBox.alert(this, "Vui Long Khong De Trong");
            return true;
        }

        if (txt_TenMau.getText().isEmpty() || txt_TenMau.getText().trim().length() == 0) {
            MsgBox.alert(this, "Vui Long Khong De Trong");
            return true;
        }
        return false;
    }
    
    private boolean checkDuplicateAll () {
        if (checkDuplicate(txt_MaMau.getText(), listMauSac, MauSac::getMaMau)) {
            MsgBox.alert(this, "Trung Ma");
            return true;
        }
        if (checkDuplicate(txt_TenMau.getText(), listMauSac, MauSac::getTenMau)) {
            MsgBox.alert(this, "Trung Ten");
            return true;
        }
        return false;
    }
    
    private static <T> boolean checkDuplicate(String data, List<T> list, DisplayValueProvider<T> provider) {
        for (T item : list) {
            if (data.equals(provider.getDisplayValue(item))) {
                return true;
            }
        }
        return false;
    }
}
