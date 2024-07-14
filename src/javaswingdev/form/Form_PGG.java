package javaswingdev.form;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javaswingdev.entity.KhachHang;
import javaswingdev.entity.NhanVien;
import javaswingdev.entity.PhieuGiamGia;
import javaswingdev.service.KhachHangService;
import javaswingdev.service.PhieuGiamGiaService;
import Utils.Auth;
import Utils.FormatMoney;
import Utils.MsgBox;
import Utils.Validate;
import Utils.XDate;
import javax.swing.table.DefaultTableModel;


public class Form_PGG extends javax.swing.JPanel {

    private static KhachHangService khachHangService = new KhachHangService();
    ArrayList<PhieuGiamGia> listPGG = new ArrayList<>();
    private static PhieuGiamGiaService servicePGG = new PhieuGiamGiaService();
    public List<Object> listHF = new ArrayList<>();

    private static int page = 1;
    private static int page2 = 1;
    private static int lmit = 4;
    private static int gioiHanPage = (int) ((Math.ceil(servicePGG.getRowCountPGG() / lmit))) + 1;

    public Form_PGG(String name) {
        initComponents();
//        lb.setText("Form " + name);
        listPGG = servicePGG.getAllPGG(page, lmit);
        loadToTable(listPGG);
        // Đang
        if (Auth.isManager()) {
            btnSua.setVisible(true);
            btnThem.setVisible(true);
        } else {
            btnSua.setVisible(false);
            btnThem.setVisible(false);
        }
        txtNguoiTao.setText(Auth.user.getMaNV());
    }

    public void loadToTable(ArrayList<PhieuGiamGia> listPgg) {
        DefaultTableModel model = (DefaultTableModel) this.tblDSPGG.getModel();
        model.setRowCount(0);
        int i = 1;
        for (PhieuGiamGia pgg : listPgg) {
            model.addRow(pgg.rowDate(i));
            i++;
        }
    }

    public void loadToTableHD(ArrayList<Object> listPgg) {
        DefaultTableModel model = (DefaultTableModel) this.tblDSHDADPGG.getModel();

        model.setRowCount(0);
        int i = 1;
        for (Object ob : listPgg) {
            model.addRow((Object[]) ob);
            i++;
        }
    }

    private void showData(int index) {
        PhieuGiamGia pgg = servicePGG.getAllPGG(page, lmit).get(index);
        txtDonToiThieu.setText(pgg.getDonToiThieu() + "");
        txtGiaTri.setText(pgg.getGiaTri() + "");
        txtMaPhieu.setText(pgg.getMaPGG() + "");
        txtMoTa.setText(pgg.getMoTa() + "");
        txtNgayBatDau.setDate(pgg.getNgayBatDau());
        txtNgayKetThuc.setDate(pgg.getNgayKetThuc());
        txtNguoiTao.setText(pgg.getIdNV().getHoTenNV() + "");
        txtSoLuongPhieu.setText(pgg.getSoLuongPhieu() + "");
        txtTenPhieu.setText(pgg.getTenPGG() + "");
        cboLoaiPhieu.setSelectedIndex(pgg.getLoaiPGG());
        cboTrangThai.setSelectedIndex(pgg.getTrangThai());
    }

    public void show2() {
        int row = tblDSPGG.getSelectedRow();
        PhieuGiamGia pgg = this.listPGG.get(row);
        txtNguoiTao.setText(String.valueOf(pgg.getIdNV()));
        String giaTriStr = tblDSPGG.getValueAt(row, 4).toString();
        giaTriStr = giaTriStr.replace("%", "");
        giaTriStr = giaTriStr.replace("VNĐ", "");
        giaTriStr = FormatMoney.formatTienToNumBer(giaTriStr);

        String donToiThieu = tblDSPGG.getValueAt(row, 6).toString();
        donToiThieu = FormatMoney.formatTienToNumBer(donToiThieu);
        txtMaPhieu.setText(tblDSPGG.getValueAt(row, 1).toString());
        txtTenPhieu.setText(tblDSPGG.getValueAt(row, 2).toString());
        cboLoaiPhieu.setSelectedItem(tblDSPGG.getValueAt(row, 3).toString());
        txtGiaTri.setText(giaTriStr);
        txtSoLuongPhieu.setText(tblDSPGG.getValueAt(row, 5).toString());
        txtDonToiThieu.setText(donToiThieu);
        try {
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            Date dateBD = date.parse(tblDSPGG.getValueAt(row, 7).toString());
            Date dateKT = date.parse(tblDSPGG.getValueAt(row, 8).toString());
//            tdateNgayBatDau.setDate(dateBD);
//            tdateNgayKetThuc.setDate(dateKT); SUA
        } catch (Exception e) {
            e.printStackTrace();
        }

        txtMoTa.setText(tblDSPGG.getValueAt(row, 10).toString());
        if (tblDSPGG.getValueAt(row, 11).toString().equalsIgnoreCase("Sắp diễn ra")) {
            cboTrangThai.setSelectedIndex(0);
        } else if (tblDSPGG.getValueAt(row, 11).toString().equalsIgnoreCase("Đang diễn ra")) {
            cboTrangThai.setSelectedIndex(1);
        } else {
            cboTrangThai.setSelectedIndex(3);
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

    private PhieuGiamGia getForm() {
        NhanVien nhanVien = Auth.user;
        String maPhieu = txtMaPhieu.getText().trim();
        int max = servicePGG.getRowCountPGG();
        if (maPhieu.isEmpty()) {
            if (max < 10) {
                maPhieu = "PGG" + "00" + maPhieu;
            } else if (max < 100) {
                maPhieu = "PGG" + "0" + max;
            } else {
                maPhieu = "PGG" + max;
            }
        }

        String tenPhieu = txtTenPhieu.getText().trim();
        int loaiPhieu = cboLoaiPhieu.getSelectedIndex();
        String giaTri = txtGiaTri.getText().trim();
        String soLuong = txtSoLuongPhieu.getText().trim();
        String donToiThieu = txtDonToiThieu.getText().trim();
//        String ngayBD = XDate.toString(txtNgayBatDAu.getDate(), "dd-MM-yyyy");
//        String ngayKetThuc = XDate.toString(txtNgayKetThuc.getDate(), "dd-MM-yyyy");

        String moTa = txtMoTa.getText().trim();
        BigDecimal giaTriB = BigDecimal.ZERO;
        BigDecimal donDt = BigDecimal.ZERO;
        int soLuongI = 0;
        Integer trangThai = cboTrangThai.getSelectedIndex();

        // Tên
        if (tenPhieu.isEmpty()) {
            MsgBox.aleart(this, "Tên phiếu chưa có !");
            txtTenPhieu.requestFocus();
            return null;
        } else {
            if (Validate.checkLength(tenPhieu, 99)) {
                MsgBox.aleart(this, "Tên phiếu tối đa 99 ký tự !");
                txtTenPhieu.requestFocus();
                return null;
            }
        }
        // Giá trị
        if (giaTri.isEmpty()) {
            MsgBox.aleart(this, "Giá trị phiếu chưa có !");
            txtGiaTri.requestFocus();
            return null;
        } else {
            try {
                giaTriB = new BigDecimal(giaTri);
                if (cboLoaiPhieu.getSelectedIndex() == 0) {
                    if (giaTriB.compareTo(new BigDecimal("70.0")) >= 0) {
                        MsgBox.aleart(this, "Giá trị % nhở hơn 70 !");
                        txtGiaTri.requestFocus();
                        return null;
                    }
                }
                if (Float.parseFloat(giaTri) <= 0) {
                    MsgBox.aleart(this, "Giá trị > 0");
                    txtGiaTri.requestFocus();
                    return null;
                }
            } catch (Exception e) {
                MsgBox.aleart(this, "Giá trị phiếu phải là số !");
                txtGiaTri.requestFocus();
                return null;
            }
        }
        // Số lượng
        if (soLuong.isEmpty()) {
            MsgBox.aleart(this, "Số lượng phiếu chưa có !");
            txtSoLuongPhieu.requestFocus();
            return null;
        } else {
            try {
                soLuongI = Integer.parseInt(soLuong);
                if (soLuongI <= 0) {
                    MsgBox.aleart(this, "Số lượng phải > 0");
                    return null;
                }

                if (soLuongI >= 1000000) {
                    MsgBox.aleart(this, "Số lượng phải < 1000000");
                    return null;
                }
            } catch (Exception e) {
                MsgBox.aleart(this, "Số lượng phiếu phải là số !");
                txtSoLuongPhieu.requestFocus();
                return null;
            }
        }
        // Đơn tối thiểu
        if (donToiThieu.isEmpty()) {
            MsgBox.aleart(this, "Đơn tối thiểu phiếu chưa có !");
            txtDonToiThieu.requestFocus();
            return null;
        } else {
            try {
                float dtt = Float.parseFloat(donToiThieu);
                donDt = new BigDecimal(donToiThieu);
                if (dtt < 0) {
                    MsgBox.aleart(this, "Đơn tối thiểu phiếu phải > 0!");
                    txtDonToiThieu.requestFocus();
                    return null;
                }
            } catch (Exception e) {
                MsgBox.aleart(this, "Đơn tối thiểu phiếu phải là số !");
                txtDonToiThieu.requestFocus();
                return null;
            }
        }
        // Date 
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = txtNgayBatDau.getDate();
            date2 = txtNgayKetThuc.getDate();

        } catch (Exception e) {
            MsgBox.aleart(this, "Ngày tháng năm ko hợp lệ !");
            return null;
        }
        if (date1 != null || date2 != null) {
            if (date1 == null || date2 == null) {
                MsgBox.aleart(this, "Bạn hãy điền đủ 2 ngày !");
                return null;
            }

        }

        if (date1 == null || date2 == null) {
            MsgBox.aleart(this, "Bạn hãy điền đủ 2 ngày !");
            return null;
        }

        if (date1 != null && date2 != null) {

            System.out.println("Vaof ");
            if (!Utils.Validate.isDate(XDate.toString(date1, "dd-MM-yyyy"))) {
                MsgBox.aleart(this, "Ngày sinh sai định dạng dd-MM-yyyy");
                txtNgayBatDau.requestFocus();
                return null;
            }
            if (!Utils.Validate.isDate(XDate.toString(date2, "dd-MM-yyyy"))) {
                MsgBox.aleart(this, "Ngày sinh sai định dạng dd-MM-yyyy");
                txtNgayKetThuc.requestFocus();
                return null;
            }
            try {
                XDate.toDate(XDate.toString(date1, "dd-MM-yyyy"), "dd-MM-yyyy");
                XDate.toDate(XDate.toString(date2, "dd-MM-yyyy"), "dd-MM-yyyy");
            } catch (Exception e) {
                MsgBox.aleart(this, "Ngày hoặc Tháng hoặc Năm sai ");

                return null;
            }

            if (!compareDates(XDate.toString(date1, "dd-MM-yyyy"), XDate.toString(date2, "dd-MM-yyyy"))) {
                MsgBox.aleart(this, "Ngày bắt đầu phải nhỏ hơn ngày kết thúc");
                return null;
            }
        }

        if (Utils.Validate.isEmpty(XDate.toString(date1, "dd-MM-yyyy"))) {
            MsgBox.aleart(this, "Ngày bắt đầu không được để trống");
            txtNgayBatDau.requestFocus();
            return null;
        } else {
            if (!Utils.Validate.isDate(XDate.toString(date1, "dd-MM-yyyy"))) {
                MsgBox.aleart(this, "Ngày bắt đầu sai định dạng dd-MM-yyyy");
                txtNgayBatDau.requestFocus();
                return null;
            }
            try {
                XDate.toDate(XDate.toString(date1, "dd-MM-yyyy"), "dd-MM-yyyy");
            } catch (Exception e) {
                MsgBox.aleart(this, "Ngày hoặc Tháng hoặc Năm sai ");
                txtNgayBatDau.requestFocus();
                return null;
            }
        }

        if (Utils.Validate.isEmpty(XDate.toString(date2, "dd-MM-yyyy"))) {
            MsgBox.aleart(this, "Ngày kết thúc không được để trống");
            txtNgayKetThuc.requestFocus();
            return null;
        } else {
            if (!Utils.Validate.isDate(XDate.toString(date2, "dd-MM-yyyy"))) {
                MsgBox.aleart(this, "Ngày kết thúc sai định dạng dd-MM-yyyy");
                txtNgayKetThuc.requestFocus();
                return null;
            }
            try {
                XDate.toDate(XDate.toString(date1, "dd-MM-yyyy"), "dd-MM-yyyy");
            } catch (Exception e) {
                MsgBox.aleart(this, "Ngày hoặc Tháng hoặc Năm sai ");
                txtNgayKetThuc.requestFocus();
                return null;
            }
        }
        System.out.println("javaswingdev.form.Form_PGG.getForm()" + " don toi thiu " + donDt);
        java.util.Date utilDate1 = txtNgayBatDau.getDate(); // Giả sử dateNgaybd.getDate() trả về java.util.Date
        java.sql.Date sqlDate1 = new java.sql.Date(utilDate1.getTime());
        java.util.Date utilDate2 = txtNgayKetThuc.getDate(); // Giả sử dateNgaybd.getDate() trả về java.util.Date
        java.sql.Date sqlDate2 = new java.sql.Date(utilDate2.getTime());
        PhieuGiamGia phieuGiamGia = new PhieuGiamGia();
        phieuGiamGia.setIdNV(nhanVien);
        phieuGiamGia.setMaPGG(maPhieu);
        phieuGiamGia.setTenPGG(tenPhieu);
        phieuGiamGia.setLoaiPGG(loaiPhieu);
        phieuGiamGia.setGiaTri(giaTriB);
        phieuGiamGia.setSoLuongPhieu(soLuongI);
        phieuGiamGia.setDonToiThieu(donDt);
        phieuGiamGia.setNgayBatDau(sqlDate1);
        phieuGiamGia.setNgayKetThuc(sqlDate2);
        phieuGiamGia.setMoTa(moTa);
        phieuGiamGia.setTrangThai(trangThai);
        return phieuGiamGia;
    }

    private void first() {
        lblPage.setText(1 + " / " + gioiHanPage);
        listPGG = servicePGG.getAllPGG(1, lmit);
        loadToTable(listPGG);
    }

    private void prev() {
        page--;

        if (page >= 1) {
            lblPage.setText(page + " / " + gioiHanPage);
            listPGG = servicePGG.getAllPGG(page, lmit);
            loadToTable(listPGG);
            return;
        }
        page = 1;

    }

    private void next() {
        page++;

        if (page <= gioiHanPage) {
            listPGG = servicePGG.getAllPGG(page, lmit);
            loadToTable(listPGG);
            lblPage.setText(page + " / " + gioiHanPage);
            return;
        }
        page = gioiHanPage;
    }

    private void last() {

        lblPage.setText(gioiHanPage + " / " + gioiHanPage);
        listPGG = servicePGG.getAllPGG(gioiHanPage, lmit);
        loadToTable(listPGG);
    }

    private void clear() {
        txtMaPhieu.setText("");
        txtNguoiTao.setText("");
        txtTenPhieu.setText("");
        txtGiaTri.setText("");
        txtSoLuongPhieu.setText("");
        txtDonToiThieu.setText("");
        txtNgayBatDau.setDate(null);
        txtNgayKetThuc.setDate(null);
        txtMoTa.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNguoiTao = new javax.swing.JTextField();
        txtMaPhieu = new javax.swing.JTextField();
        txtTenPhieu = new javax.swing.JTextField();
        cboLoaiPhieu = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtNgayBatDau = new com.toedter.calendar.JDateChooser();
        txtNgayKetThuc = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtGiaTri = new javax.swing.JTextField();
        txtSoLuongPhieu = new javax.swing.JTextField();
        txtDonToiThieu = new javax.swing.JTextField();
        cboTrangThai = new javax.swing.JComboBox<>();
        btnLamMoi = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtNgayBatDauLoc = new com.toedter.calendar.JDateChooser();
        txtNgayKetThucLoc = new com.toedter.calendar.JDateChooser();
        cboLoaiPhieuLoc = new javax.swing.JComboBox<>();
        cboTrangThaiLoc = new javax.swing.JComboBox<>();
        btnLoc = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDSPGG = new javax.swing.JTable();
        btnDau = new javax.swing.JButton();
        btnLui = new javax.swing.JButton();
        btnTien = new javax.swing.JButton();
        btnCuoi = new javax.swing.JButton();
        lblPage = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblDSHDADPGG = new javax.swing.JTable();

        setOpaque(false);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setToolTipText("");
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setText("Người tạo:");

        jLabel2.setText("Mã phiếu");

        jLabel3.setText("Tên phiếu:");

        jLabel4.setText("Loại phiếu:");

        txtNguoiTao.setEditable(false);

        txtMaPhieu.setEditable(false);

        cboLoaiPhieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Giảm theo %", "Giảm theo VND" }));

        jLabel5.setText("Giá trị:");

        txtNgayBatDau.setDateFormatString("dd-MM-yyyy");

        txtNgayKetThuc.setDateFormatString("dd-MM-yyyy");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane1.setViewportView(txtMoTa);

        jLabel6.setText("Số lượng phiếu:");

        jLabel7.setText("Đơn tối thiểu:");

        jLabel8.setText("Trạng thái:");

        jLabel9.setText("Ngày bắt đầu:");

        jLabel10.setText("Ngày kết thúc:");

        jLabel11.setText("Mô tả:");

        cboTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sắp đến", "Đang diễn ra", "Đã hết hạn" }));

        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNguoiTao)
                    .addComponent(txtMaPhieu)
                    .addComponent(txtTenPhieu)
                    .addComponent(cboLoaiPhieu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(63, 63, 63)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cboTrangThai, 0, 390, Short.MAX_VALUE)
                    .addComponent(txtGiaTri, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSoLuongPhieu, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDonToiThieu, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel11))
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(btnLamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNgayBatDau, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(txtNguoiTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel9)
                                .addComponent(txtGiaTri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10)
                            .addComponent(txtSoLuongPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTenPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11)
                            .addComponent(txtDonToiThieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8)
                            .addComponent(cboTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboLoaiPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua)
                    .addComponent(btnLamMoi)
                    .addComponent(btnThem))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel12.setText("Ngày bắt đầu:");

        jLabel13.setText("Ngày kết thúc:");

        jLabel14.setText("Loại phiếu:");

        jLabel15.setText("Trạng thái:");

        txtNgayBatDauLoc.setDateFormatString("dd-MM-yyyy");

        txtNgayKetThucLoc.setDateFormatString("dd-MM-yyyy");

        cboLoaiPhieuLoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Tất cả--", "Giảm theo %", "Giảm theo VND" }));

        cboTrangThaiLoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Sắp đến", "Đang diễn ra", "Đã hết hạn", " " }));

        btnLoc.setText("Lọc");
        btnLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(txtNgayBatDauLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(txtNgayKetThucLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(cboLoaiPhieuLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(cboTrangThaiLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNgayBatDauLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel12))
                    .addComponent(txtNgayKetThucLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jLabel15)
                        .addComponent(cboLoaiPhieuLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cboTrangThaiLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnLoc)))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tblDSPGG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Người tạo", "Mã PGG", "Tên PGG", "Loại PGG", "Giá trị", "Số lượng phiếu", "Đơn tối thiểu", "Ngày bắt đầu ", "Ngày kết thúc", "Ngày tạo", "Mô tả", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSPGG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDSPGGMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDSPGG);
        if (tblDSPGG.getColumnModel().getColumnCount() > 0) {
            tblDSPGG.getColumnModel().getColumn(0).setResizable(false);
            tblDSPGG.getColumnModel().getColumn(1).setResizable(false);
            tblDSPGG.getColumnModel().getColumn(2).setResizable(false);
            tblDSPGG.getColumnModel().getColumn(3).setResizable(false);
            tblDSPGG.getColumnModel().getColumn(4).setResizable(false);
            tblDSPGG.getColumnModel().getColumn(5).setResizable(false);
            tblDSPGG.getColumnModel().getColumn(6).setResizable(false);
            tblDSPGG.getColumnModel().getColumn(7).setResizable(false);
            tblDSPGG.getColumnModel().getColumn(8).setResizable(false);
            tblDSPGG.getColumnModel().getColumn(9).setResizable(false);
            tblDSPGG.getColumnModel().getColumn(10).setResizable(false);
            tblDSPGG.getColumnModel().getColumn(11).setResizable(false);
            tblDSPGG.getColumnModel().getColumn(12).setResizable(false);
        }

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

        lblPage.setText("1/2");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(527, 527, 527)
                .addComponent(btnDau, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLui, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblPage)
                .addGap(18, 18, 18)
                .addComponent(btnTien, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(634, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDau)
                    .addComponent(btnLui)
                    .addComponent(btnTien)
                    .addComponent(btnCuoi)
                    .addComponent(lblPage))
                .addContainerGap())
        );

        jTabbedPane2.addTab("Danh sách PGG", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        tblDSHDADPGG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã hóa đơn", "Mã PGG", "Ngày áp dụng", "Giá trị giảm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblDSHDADPGG);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1558, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Danh sách HĐ áp dụng PGG", jPanel5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane2))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane2)
                .addContainerGap())
        );

        jPanel2.getAccessibleContext().setAccessibleName("");

        jTabbedPane1.addTab("Phiếu giảm giá", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        /*
   
         */
        PhieuGiamGia phieuGiamGia = getForm();
        if (phieuGiamGia == null) {
            return;
        }
//        Tao
//        Impl.ExportQr.exportQrHD("src\\qrpgg", phieuGiamGia.getMaPhieu());

        int kq = servicePGG.ThemPGG(phieuGiamGia);
        String date = XDate.toString(new Date(), "yyyy-MM-dd");
//        servicePGG.updateKT(date);
//        servicePGG.updateBD(date);
        if (kq != -1) {
            MsgBox.aleart(this, "Thêm thành công");
            listPGG = servicePGG.getAllPGG(page, lmit);
            loadToTable(listPGG);
//            email
//            for (KhachHang kh : khachHangService.getAll2()) {
//                try {
//                    if (kh.getMaKH() == null) {
//                        continue;
//                    }
//                    String thongTin = "Shop TSHOES  \n Gửi tặng khách hàng " + kh.getTenKH() + " Phiếu giảm giá \n"
//                            + "Mã PGG : " + phieuGiamGia.getMaPGG() + " .\n"
//                            + "Giá trị PGG : " + phieuGiamGia.getTenPGG() + " .\n"
//                            + (phieuGiamGia.getLoaiPGG() == 0 ? phieuGiamGia.getGiaTri() + " % " : phieuGiamGia.getGiaTri() + " VNĐ ") + " \n "
//                            + "Ngày bắt đầu : " + XDate.toString(phieuGiamGia.getNgayBatDau(), "dd-MM-yyyy") + " \n "
//                            + "Ngày kết thúc : " + XDate.toString(phieuGiamGia.getNgayKetThuc(), "dd-MM-yyyy");
////                    Gửi EMail
////                    Email.sendMailwithFile(kh.getEmail(), thongTin, "Phiếu giảm giá danh tặng cho bạn", "src\\qrpgg\\" + phieuGiamGia.getMaPGG() + ".png");
//                } catch (Exception e) {
//                    continue;
//                }
//            }

            clear();
        } else {
            MsgBox.aleart(this, "Thêm không thành công");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        PhieuGiamGia phieuGiamGia = getForm();
        System.out.println(phieuGiamGia);
        if (phieuGiamGia == null) {
            return;
        }
        int kq = servicePGG.SuaPGG(phieuGiamGia);
        if (kq == 1) {
            MsgBox.aleart(this, "Sửa thành công");
            String date = XDate.toString(new Date(), "yyyy-MM-dd");
            servicePGG.updateKT(date);
            servicePGG.updateBD(date);
            listPGG = servicePGG.getAllPGG(page, lmit);
            loadToTable(listPGG);
            clear();
        } else {
            MsgBox.aleart(this, "Sửa không thành công");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocActionPerformed
        // TODO add your handling code here:
        Date date1 = null;
        Date date2 = null;
        try {
            try {
                date1 = txtNgayBatDauLoc.getDate();
                date2 = txtNgayKetThucLoc.getDate();
            } catch (Exception e) {
                MsgBox.aleart(this, "Ngày tháng năm ko hợp lệ");
                return;
            }
            if (date1 != null || date2 != null) {
                if (date1 == null || date2 == null) {
                    MsgBox.aleart(this, "Bạn hãy điền đúng 2 ngày"); 
                    return;
                }

            }
            if (date1 != null && date2 != null) {

                System.out.println("Phiếu giảm giá");
                if (!Utils.Validate.isDate(XDate.toString(date1, "dd-MM-yyyy"))) {
                    MsgBox.aleart(this, "Ngày sinh sai định dạng dd-MM-yyyy");
                    txtNgayBatDauLoc.requestFocus();
                    return;
                }
                if (!Utils.Validate.isDate(XDate.toString(date2, "dd-MM-yyyy"))) {
                    MsgBox.aleart(this, "Ngày sinh sai định dạng dd-MM-yyyy");
                    txtNgayKetThucLoc.requestFocus();
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
        } catch (Exception e) {
            MsgBox.aleart(this, "Kiểm tra lại ngày của bạn nhập vào");
            return;
        }
        int loaiPhieu = cboLoaiPhieuLoc.getSelectedIndex() - 1;
        int trangThai = cboTrangThaiLoc.getSelectedIndex() - 1;
        System.out.println("Trạng thái" + trangThai);
        PhieuGiamGia gia = new PhieuGiamGia();
        gia.setNgayBatDau(txtNgayBatDauLoc.getDate());
        gia.setNgayKetThuc(txtNgayKetThucLoc.getDate());
        gia.setLoaiPGG(loaiPhieu);
        gia.setTrangThai(trangThai);
        listPGG = (ArrayList<PhieuGiamGia>) servicePGG.getListLoc1(gia, page, lmit);
        loadToTable(listPGG);
    }//GEN-LAST:event_btnLocActionPerformed

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

    private void tblDSPGGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDSPGGMouseClicked
        // TODO add your handling code here:
        int index = tblDSPGG.getSelectedRow();
        showData(index);
        String maPhieu = tblDSPGG.getValueAt(index, 2).toString();

        listHF = servicePGG.getAllHDByMaPhieu(maPhieu);
        loadToTableHD((ArrayList<Object>) listHF);
    }//GEN-LAST:event_tblDSPGGMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCuoi;
    private javax.swing.JButton btnDau;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLoc;
    private javax.swing.JButton btnLui;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTien;
    private javax.swing.JComboBox<String> cboLoaiPhieu;
    private javax.swing.JComboBox<String> cboLoaiPhieuLoc;
    private javax.swing.JComboBox<String> cboTrangThai;
    private javax.swing.JComboBox<String> cboTrangThaiLoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lblPage;
    private javax.swing.JTable tblDSHDADPGG;
    private javax.swing.JTable tblDSPGG;
    private javax.swing.JTextField txtDonToiThieu;
    private javax.swing.JTextField txtGiaTri;
    private javax.swing.JTextField txtMaPhieu;
    private javax.swing.JTextArea txtMoTa;
    private com.toedter.calendar.JDateChooser txtNgayBatDau;
    private com.toedter.calendar.JDateChooser txtNgayBatDauLoc;
    private com.toedter.calendar.JDateChooser txtNgayKetThuc;
    private com.toedter.calendar.JDateChooser txtNgayKetThucLoc;
    private javax.swing.JTextField txtNguoiTao;
    private javax.swing.JTextField txtSoLuongPhieu;
    private javax.swing.JTextField txtTenPhieu;
    // End of variables declaration//GEN-END:variables
}
