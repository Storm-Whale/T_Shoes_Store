package javaswingdev.main;

import Utils.Auth;
import Utils.MsgBox;
import java.util.List;


import javaswingdev.entity.NhanVien;
import javaswingdev.service.NhanVienService;

public class DangNhap1 extends javax.swing.JFrame {
    
    NhanVienService nvr = new NhanVienService();
    List<NhanVien> listNV = nvr.findAll();
    
    public DangNhap1() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        txt_Password = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        txt_TenDangNhap = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btn_DangNhap = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        chb_Password = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Đăng Nhập");

        jLabel1.setText("Tên Đăng Nhập");

        jLabel2.setText("Mật Khẩu");

        jButton1.setText("Exit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn_DangNhap.setText("Đăng Nhập");
        btn_DangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DangNhapActionPerformed(evt);
            }
        });

        jLabel3.setText("Quên Mật Khẩu ?");

        chb_Password.setText("Hiển thị mật khẩu");
        chb_Password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chb_PasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(txt_TenDangNhap)
                    .addComponent(jLabel2)
                    .addComponent(txt_Password)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_DangNhap)
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jButton1))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(chb_Password)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_TenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_Password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chb_Password)
                .addGap(4, 4, 4)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_DangNhap)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_DangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DangNhapActionPerformed
        // TODO add your handling code here:
        String username = txt_TenDangNhap.getText().trim();
        String password = txt_Password.getText().trim();
        if (this.validate(username, password)) {
            return;
        } else {
            NhanVien nv = nvr.findByEmailAndPassword(username, password);
            Auth.user = nv;
            MsgBox.alert(this, "Dang Nhap Thanh Cong");
            new Main().setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btn_DangNhapActionPerformed

    private void chb_PasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chb_PasswordActionPerformed
        // TODO add your handling code here:
        if (chb_Password.isSelected()) {
            txt_Password.setEchoChar((char) 0);
        } else {
            txt_Password.setEchoChar('*');
        }
    }//GEN-LAST:event_chb_PasswordActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DangNhap1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_DangNhap;
    private javax.swing.JCheckBox chb_Password;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField txt_Password;
    private javax.swing.JTextField txt_TenDangNhap;
    // End of variables declaration//GEN-END:variables
    private boolean validate(String username, String password) {
        if (username.length() == 0 || password.length() == 0) {
            MsgBox.alert(this, "Ban Vui Long Nhap Du Du Lieu");
            return true;
        }
        
        if (username.length() == 0 && password.length() == 0) {
            MsgBox.alert(this, "Ban Vui Long Nhap Du Du Lieu");
            return true;
        }
        
        boolean flag = true;
        
        for (NhanVien nhanVien : listNV) {
            if (nhanVien.getEmail().equals(username)) {
                flag = false;
                break;
            }
        }
        
        if (flag) {
            MsgBox.alert(this, "Tai Khoan Khong Ton Tai");
            return true;
        }
        
        flag = true;
        for (NhanVien nhanVien : listNV) {
            if (nhanVien.getMatKhau().equals(password)) {
                flag = false;
                break;
            }
        }
        
        if (flag) {
            MsgBox.alert(this, "Sai Mat Khau");
            return true;
        }
        
        return false;
    }
}
