package javaswingdev.form;

import Utils.Auth;
import Utils.Format;
import Utils.MsgBox;
import Utils.Validate;
import Utils.XDate;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javaswingdev.entity.HoaDonChiTiet;
import javaswingdev.entity.HoaDon;
import javaswingdev.entity.KhachHang;
import javaswingdev.entity.KichThuoc;
import javaswingdev.entity.MauSac;
import javaswingdev.entity.NhanVien;
import javaswingdev.entity.PhieuGiamGia;
import javaswingdev.entity.SanPham;
import javaswingdev.entity.SanPhamChiTiet;
import javaswingdev.entity.ThuongHieu;
import javaswingdev.main.Main;
import javaswingdev.service.HoaDonService;
import javaswingdev.service.SanPhamCT_Service;
import javaswingdev.service.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Form_BanHang extends javax.swing.JPanel {

    private static Long IdNV = 0L;
    private static SanPhamService sanPhamService = new SanPhamService();
    private static List<SanPhamChiTiet> list = new ArrayList<>();
    private static List<HoaDon> listHD = new ArrayList<>();
    private static List<HoaDonChiTiet> listGH = new ArrayList<>();
    private static HoaDonService hoaDonService = new HoaDonService();
    private static SanPhamCT_Service sanPhamCT_Service = new SanPhamCT_Service();
    private static ChiTietHoaDonService chiTietHoaDonService = new ChiTietHoaDonService();
    private static KhachHangService khachHangService = new KhachHangService();
    private static SizeService sService = new SizeService();
    private static KhachHang defaultKhachHang = new KhachHang(1L, "KH00", "Khách bán lẻ");
    private static KhachHang defaultKhachHang1 = new KhachHang(1L, "KH00", "Khách bán lẻ");
    private static int indexHD = -1;
    private static int demClick = 0;

    DefaultComboBoxModel cboModelTenGiay1 = new DefaultComboBoxModel();
    DefaultComboBoxModel cboModelThuongHieu1 = new DefaultComboBoxModel();
    DefaultComboBoxModel cboModelKichThuoc1 = new DefaultComboBoxModel();
    DefaultComboBoxModel cboModelMauSac1 = new DefaultComboBoxModel();

    DefaultComboBoxModel cboModelThuongHieu = new DefaultComboBoxModel();
    DefaultComboBoxModel cboModelKichThuoc = new DefaultComboBoxModel();
    DefaultComboBoxModel cboModelMauSac = new DefaultComboBoxModel();
    DefaultComboBoxModel cboModelTenGiay = new DefaultComboBoxModel();

    private static SanPhamCT_Service sanPhamCT_Repository = new SanPhamCT_Service();
    public static SanPhamChiTiet spct = new SanPhamChiTiet();

    MauService mauService = new MauService();
    SizeService sizeService = new SizeService();
    ThuongHieuService thuongHieuService = new ThuongHieuService();

    private DefaultTableModel dtm = new DefaultTableModel();

//     pgg
    private static PGG_Service phieuGiamGiaService = new PGG_Service();
    private static List<PhieuGiamGia> listPGG = new ArrayList<>();
    private PhieuGiamGia phieuGiamGia = new PhieuGiamGia();

    private String date = XDate.toString(new Date(), "yyyy-MM-dd");

    public Form_BanHang(String name) {
        initComponents();
        init();
    }

    void init() {
        txtTenNV.setText(Auth.user.getHoTenNV());
        lblDonTreo.setText("" + hoaDonService.getHoaDonTreo());
        setKH(defaultKhachHang);
        listHD = hoaDonService.findHoaDonByTranThai();
        fillToTableHD(listHD);
        list = sanPhamCT_Service.getByTrangThai();

        fillToTableSP(list);
        fillToCboTenSP();
        fillToCboMauSac1();
        fillToCboKichThuoc1();
        fillToCboThuongHieu1();
        System.out.println("NV " + Auth.user);
    }

    private void fillToTableHD(List<HoaDon> list) {
        DefaultTableModel dtm = (DefaultTableModel) this.tblHoaDon.getModel();
        dtm.setRowCount(0);
        int i = 1;
        for (HoaDon don : list) {
            dtm.addRow(don.rowDataHDBH(i));
            i++;
        }
    }

    private void fillToTableSP(List<SanPhamChiTiet> list) {
        DefaultTableModel dtm = (DefaultTableModel) this.tblSP.getModel();
        dtm.setRowCount(0);

        for (SanPhamChiTiet ctspm : list) {
            dtm.addRow(ctspm.rowDataSPBH());

        }
    }

    private void fillToCboTenSP() {
        cboModelTenGiay1 = (DefaultComboBoxModel) this.cboTen.getModel();
        List<SanPham> list = sanPhamService.getToAllSanPham();
        for (SanPham sanPham : list) {
            cboModelTenGiay1.addElement(sanPham);
        }
    }

    private void fillToCboMauSac1() {
        cboModelMauSac1 = (DefaultComboBoxModel) this.cboMau.getModel();
        List<MauSac> list = mauService.getToAll();
        for (MauSac ms : list) {
            cboModelMauSac1.addElement(ms);
        }
    }

    private void fillToCboKichThuoc1() {
        cboModelKichThuoc1 = (DefaultComboBoxModel) this.cboSize.getModel();
        List<KichThuoc> list = sizeService.getToAllKichThuoc();
        for (KichThuoc kt : list) {
            cboModelKichThuoc1.addElement(kt);
        }
    }

    public void fillToCboThuongHieu1() {
        cboModelThuongHieu1 = (DefaultComboBoxModel) this.cboThuongHieu.getModel();
        List<ThuongHieu> list = thuongHieuService.getToAll();
        for (ThuongHieu th : list) {
            cboModelThuongHieu1.addElement(th);
        }
    }

    private void fillToTableGH(List<HoaDonChiTiet> list) {
        dtm = (DefaultTableModel) this.tblGH.getModel();
        dtm.setRowCount(0);
        int i = 1;
        for (HoaDonChiTiet chiTietHoaDon : list) {
            System.out.println(chiTietHoaDon);
            dtm.addRow(chiTietHoaDon.rowDataGioHang(i));
            //setFormTT();
            i++;
        }
    }

    private void setKH(KhachHang khachHang) {
        txtMaKH.setText(khachHang.getMaKH());
        txtTenKH.setText(khachHang.getTenKH());
        txtSDT.setText(khachHang.getSdt());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgpHinhThucTT = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblDonTreo = new javax.swing.JLabel();
        btnTaoHoaDon = new javax.swing.JButton();
        btnXoaHD = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGH = new javax.swing.JTable();
        ckbAll = new javax.swing.JCheckBox();
        btnXoaGH = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        txtSreach = new javax.swing.JTextField();
        cboTen = new javax.swing.JComboBox<>();
        cboMau = new javax.swing.JComboBox<>();
        cboThuongHieu = new javax.swing.JComboBox<>();
        cboSize = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSP = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        btnThemNhanhKH = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtTienKhachCK = new javax.swing.JTextField();
        txtTienKhachDua = new javax.swing.JTextField();
        txtThanhTien = new javax.swing.JTextField();
        txtPhieuGiamGia = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        txtMaHD = new javax.swing.JTextField();
        txtTienThua = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        cboHTTT = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setOpaque(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "BÁN HÀNG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel4.setText("Số đơn treo:");

        lblDonTreo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDonTreo.setForeground(new java.awt.Color(255, 51, 51));
        lblDonTreo.setText("0");

        btnTaoHoaDon.setText("Tạo hóa đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        btnXoaHD.setText("Xóa");
        btnXoaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaHDActionPerformed(evt);
            }
        });

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã hóa đơn", "Ngày tạo", "Nhân viên", "Khách hàng", "Trạng thái"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        jButton1.setText("Làm mới");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDonTreo)
                        .addGap(114, 114, 114)
                        .addComponent(btnTaoHoaDon)
                        .addGap(89, 89, 89)
                        .addComponent(btnXoaHD)
                        .addGap(93, 93, 93)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblDonTreo)
                    .addComponent(btnTaoHoaDon)
                    .addComponent(btnXoaHD)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CHI TIẾT HÓA ĐƠN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        tblGH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Đơn giá", "Số lượng", "Size", "Giảm giá", "Giá bán", "Thành tiền", "Chọn"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblGH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGHMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblGH);

        ckbAll.setText("Tất cả");
        ckbAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbAllActionPerformed(evt);
            }
        });

        btnXoaGH.setText("Xóa");
        btnXoaGH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaGHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ckbAll)
                    .addComponent(btnXoaGH))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(ckbAll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoaGH)))
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DANH SÁCH SẢN PHẨM", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        txtSreach.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSreachKeyReleased(evt);
            }
        });

        cboTen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Tên sản phẩm--" }));
        cboTen.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboTenItemStateChanged(evt);
            }
        });

        cboMau.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Màu sắc--" }));
        cboMau.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboMauItemStateChanged(evt);
            }
        });

        cboThuongHieu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Thương hiệu--" }));
        cboThuongHieu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboThuongHieuItemStateChanged(evt);
            }
        });

        cboSize.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Size--" }));
        cboSize.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboSizeItemStateChanged(evt);
            }
        });

        tblSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã CTSP", "Tên SP", "Màu sắc", "Size", "Thương hiệu", "Số Lượng", "Giá", "Trạng thái"
            }
        ));
        tblSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSPMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblSP);

        jLabel1.setText("Tìm kiếm:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSreach, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(cboTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cboMau, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cboThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cboSize, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSreach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboThuongHieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(247, 247, 247))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ĐƠN HÀNG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÔNG TIN KHÁCH HÀNG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel8.setText("Mã KH:");

        jLabel9.setText("Tên KH:");

        jLabel10.setText("SĐT:");

        txtMaKH.setEditable(false);

        txtTenKH.setEditable(false);

        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });

        btnThemNhanhKH.setText("+");
        btnThemNhanhKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemNhanhKHActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenKH)
                            .addComponent(txtSDT))
                        .addGap(40, 40, 40)
                        .addComponent(btnThemNhanhKH, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThemNhanhKH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÔNG TIN ĐƠN HÀNG", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        jLabel13.setText("Mã hóa đơn:");

        jLabel14.setText("Tên nhân viên:");

        jLabel15.setText("Tổng tiền:");

        jLabel16.setText("Phiếu giảm giá:");

        jLabel18.setText("Thành tiền:");

        jLabel19.setText("Hình thức thanh toán:");

        jLabel20.setText("Tiền khách đưa:");

        jLabel21.setText("Tiền khách chuyển khoản:");

        jLabel22.setText("Tiền thừa:");

        txtTienKhachCK.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTienKhachCKKeyPressed(evt);
            }
        });

        txtTienKhachDua.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienKhachDuaKeyReleased(evt);
            }
        });

        txtThanhTien.setEditable(false);

        txtPhieuGiamGia.setEditable(false);
        txtPhieuGiamGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtPhieuGiamGiaMouseClicked(evt);
            }
        });

        txtTongTien.setEditable(false);

        txtTenNV.setEditable(false);

        txtMaHD.setEditable(false);

        txtTienThua.setEditable(false);

        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        cboHTTT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền mặt", "Chuyển khoản", "Tiền mặt và chuyển khoản", " " }));
        cboHTTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboHTTTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTienKhachCK, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(txtTienKhachDua)
                    .addComponent(txtThanhTien)
                    .addComponent(txtPhieuGiamGia)
                    .addComponent(txtTongTien)
                    .addComponent(txtTenNV)
                    .addComponent(txtMaHD)
                    .addComponent(txtTienThua)
                    .addComponent(cboHTTT, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThanhToan)
                .addGap(118, 118, 118))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtPhieuGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cboHTTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(txtTienKhachCK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(btnThanhToan)
                .addGap(71, 71, 71))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed

        Long maxHD = (long) hoaDonService.getRowCountHD();
        String maHD = "HD";
        Date date = new Date();
        String dateStr = XDate.toString(date, "yy-MM-ddHHmm");
        maHD += dateStr + maxHD;

        HoaDon hd = new HoaDon();
        hd.setId(maxHD);
        hd.setIdKH(defaultKhachHang1);
        hd.setIdNV(Auth.user);
        hd.setMaHoaDon(maHD);
        hd.setThanhTien(BigDecimal.ZERO);

        int kq = hoaDonService.create(hd);
        if (kq != -1) {
            MsgBox.alert(this, "Tạo thành công hóa đơn : " + maHD);
            listHD = hoaDonService.findHoaDonByTranThai();
            fillToTableHD(listHD);
            lblDonTreo.setText("" + hoaDonService.getHoaDonTreo());
        } else {
            MsgBox.alert(this, "Tạo không thành công hóa đơn : " + maHD);
        }
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void initSearch() {
        KichThuoc kt = new KichThuoc();
        if (cboSize.getSelectedItem() instanceof KichThuoc) {
            kt = (KichThuoc) cboSize.getSelectedItem();
        }
        Long idKichThuoc = null;
        idKichThuoc = kt.getIdSize();

        MauSac ms = new MauSac();
        if (cboMau.getSelectedItem() instanceof MauSac) {
            ms = (MauSac) cboMau.getSelectedItem();
        }
        Long idMau = null;
        idMau = ms.getIdMau();

        SanPham sp = new SanPham();
        if (cboTen.getSelectedItem() instanceof SanPham) {
            sp = (SanPham) cboTen.getSelectedItem();
        }
        Long idSanPham = null;
        idSanPham = sp.getIdSanPham();

        ThuongHieu th = new ThuongHieu();
        if (cboThuongHieu.getSelectedItem() instanceof ThuongHieu) {
            th = (ThuongHieu) cboThuongHieu.getSelectedItem();
        }
        Long idThuongHieu = null;
        idThuongHieu = th.getIdThuongHieu();

        List<SanPhamChiTiet> list = sanPhamCT_Service.searchItem(idMau, idKichThuoc, idThuongHieu, idSanPham);
        fillToTableSP(list);
    }

    private void tblSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSPMouseClicked
        indexHD = tblHoaDon.getSelectedRow();
        if (indexHD == -1) {
            MsgBox.alert(this, "Hãy chọn 1 hóa đơn");
            return;
        }
        int index = tblSP.getSelectedRow();
        int soLuongTbl = Integer.parseInt(tblSP.getValueAt(index, 5).toString());
        Long maSp = list.get(index).getIdSPCT();

        SanPhamChiTiet sanPhamChiTiet = list.get(index);
        // System.out.println(" " + sanPhamChiTiet.getMaSPCT());
        Long maHD = listHD.get(indexHD).getId();

        Integer soLuong = 0;
        String soLuongStr = JOptionPane.showInputDialog("Nhập số lượng !!!");
        Integer soSum = hoaDonService.getSoLuongGH(maHD, maSp);
        try {
            soLuong = Integer.valueOf(soLuongStr.trim());
            System.out.println();
            if (soLuong > soLuongTbl) {
                MsgBox.alert(this, "Số lượng sản phẩm không đủ !!!");
                return;
            }

            if (soLuong <= 0) {
                MsgBox.alert(this, "Số lượng sản phẩm lớn hơn 0 !!!");
                return;
            }
        } catch (Exception e) {
            MsgBox.alert(this, "Số lượng sản phải là số !!!");
            return;
        }
        String maHD2 = tblHoaDon.getValueAt(indexHD, 1).toString().trim();
        long idHD = hoaDonService.getIDHDByMaHD(maHD2);
        HoaDon hd = new HoaDon();
        hd.setId(idHD);

        PhieuGiamGia pgg = phieuGiamGiaService.getPGG_BH(maHD2);
        BigDecimal quyDoi = BigDecimal.ZERO, giaBanB = BigDecimal.ZERO, donGiaB = BigDecimal.ZERO;
        giaBanB = sanPhamChiTiet.getGiaBan();
        donGiaB = sanPhamChiTiet.getGiaNiemYet();
        quyDoi = donGiaB.subtract(giaBanB);
        HoaDonChiTiet chiTietHoaDon = new HoaDonChiTiet();
        chiTietHoaDon.setIdHoaDon(hd);
        chiTietHoaDon.setIdCTSP(sanPhamChiTiet);
        chiTietHoaDon.setSoLuong(soLuong);
        chiTietHoaDon.setMaPGG(pgg.getMaPGG());
        chiTietHoaDon.setLoaiPGG(pgg.getLoaiPGG());
        chiTietHoaDon.setQuyDoiPGGTT(quyDoi);
        chiTietHoaDon.setGiaTriPGG(pgg.getGiaTri());
        chiTietHoaDon.setDonGia(donGiaB);
        chiTietHoaDon.setGiaBan(giaBanB);

        BigDecimal tt = BigDecimal.ZERO;
        if (soSum == null) {
            tt = sanPhamChiTiet.getGiaBan().multiply(new BigDecimal(soLuong));
        } else {
            tt = sanPhamChiTiet.getGiaBan().multiply(new BigDecimal(soLuong + soSum));
        }
        chiTietHoaDon.setThanhTien(tt);

        if (!listHD.isEmpty()) {
            System.out.println();
            hoaDonService.updateSLGH(list.get(index).getIdSPCT(), soLuong + soSum, tt);
        }
        if (soSum == 0) {
            chiTietHoaDonService.insertCTHD(chiTietHoaDon);
        }

        listGH = chiTietHoaDonService.findByIDHD(hd.getId());
        fillToTableGH(listGH);
        int slTru = soLuongTbl - soLuong;
        sanPhamService.updateSoLuongSP(sanPhamService.getSoLuongSp(list.get(index).getMaSPCT()) - soLuong,
                list.get(index).getIdSanPham().getIdSanPham());
        sanPhamCT_Service.updateSoLuongSP(sanPhamCT_Service.getSoLuongTonByMaCTSP(list.get(index).getMaSPCT()) - soLuong,
                list.get(index).getMaSPCT());
        list = sanPhamCT_Service.getByTrangThai();
        fillToTableSP(list);
        setFormTT(indexHD);
    }//GEN-LAST:event_tblSPMouseClicked

    private void cboTenItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboTenItemStateChanged
        initSearch();
    }//GEN-LAST:event_cboTenItemStateChanged

    private void cboMauItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboMauItemStateChanged
        initSearch();
    }//GEN-LAST:event_cboMauItemStateChanged

    private void cboThuongHieuItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboThuongHieuItemStateChanged
        initSearch();
    }//GEN-LAST:event_cboThuongHieuItemStateChanged

    private void cboSizeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboSizeItemStateChanged
        initSearch();
    }//GEN-LAST:event_cboSizeItemStateChanged

    private void txtSreachKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSreachKeyReleased
        if (txtSreach.getText().trim().equals("")) {
            fillToTableSP(list);
        } else {
            List<SanPhamChiTiet> listSearch = sanPhamCT_Repository.search_SanPhamChiTiet(txtSreach.getText().trim());
            fillToTableSP(listSearch);
        }
    }//GEN-LAST:event_txtSreachKeyReleased

    private void tblGHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGHMouseClicked
        demClick++;
        if (demClick > 2) {
            demClick = 0;
        }

        if (demClick == 2) {
            int indexGH = tblGH.getSelectedRow();
            String maHD = tblHoaDon.getValueAt(indexHD, 1).toString();
            System.out.println("index GH " + indexGH);
            long IDHDCT = listGH.get(indexGH).getId();
            String maSP = tblGH.getValueAt(indexGH, 1).toString();
            int soLuongTon = chiTietHoaDonService.getSLSPByMa(maSP).getSoLuong();

            Integer slSPGh = Integer.valueOf(tblGH.getValueAt(indexGH, 4).toString());

            System.out.println(maHD + " " + maSP + " " + IDHDCT + " ssl " + soLuongTon + "slspgh");
            Integer slInp = 0;
            Integer slInsert = 0;

// Lay tien trong gh
            BigDecimal ghtt = listGH.get(indexGH).getThanhTien();
            BigDecimal lastTT = BigDecimal.ZERO;

            String sl = JOptionPane.showInputDialog("Xin mời bạn nhập lại số lượng !!!");

            try {
                slInp = Integer.valueOf(sl.trim());
                System.out.println("slInp " + slInp);
                if (slInp <= 0) {
                    MsgBox.alert(this, "Số lưởng phải lớn hơn 0 nếu muốn xóa hãy chọn và xóa !!");
                    return;
                }

                if (slSPGh > soLuongTon || slInp > soLuongTon) {
                    System.out.println("slt" + soLuongTon);
                    MsgBox.alert(this, "Số lượng sản phẩm ko đủ bán !!");
                    return;
                }

                if (slInp == slSPGh) {
                    return;
                }

                if (slInp < slSPGh) {
//                    Su loai tien va sl
                    double slTT = slSPGh - slInp;
                    slInsert = soLuongTon + (slSPGh - slInp);
                    lastTT = ghtt.subtract(listGH.get(indexGH).getGiaBan().multiply(BigDecimal.valueOf(slTT)));
                    System.out.println("last TT" + lastTT);
                    sanPhamCT_Service.updateSLSP(slInsert, listGH.get(indexGH).getIdCTSP().getMaSPCT());
                    chiTietHoaDonService.updateSL_Ban(IDHDCT, slInp, lastTT);

                } else if (slInp > slSPGh) {
//                    Su loai tien va sl
                    double slTT = slInp - slSPGh;
                    slInsert = soLuongTon - (slInp - slSPGh);
                    lastTT = ghtt.add(listGH.get(indexGH).getGiaBan().multiply(BigDecimal.valueOf(slTT)));
                    System.out.println("last TT" + lastTT);
                    sanPhamCT_Service.updateSLSP(slInsert, listGH.get(indexGH).getIdCTSP().getMaSPCT());
                    chiTietHoaDonService.updateSL_Ban(IDHDCT, slInp, lastTT);

                } else {
                    demClick = 0;
                    return;
                }

                demClick = 0;
                list = sanPhamCT_Service.getByTrangThai();
                fillToTableSP(list);
                listGH = chiTietHoaDonService.findByIDHD(listHD.get(indexHD).getId());
                fillToTableGH(listGH);
            } catch (Exception e) {
                MsgBox.alert(this, "Số lượng phải là số !!");
                demClick = 0;
                return;
            }
        }
    }//GEN-LAST:event_tblGHMouseClicked

    private void insertKH() {
        /////////////////////////
        NhanVien nhanVien = new NhanVien(2L);
        //////////////
        String sdt = txtSDT.getText().trim();
        if (sdt.isEmpty()) {
            MsgBox.alert(this, "Số điện thoại khách hàng chưa có  !");
            txtSDT.requestFocus();
            return;
        } else {
            if (Validate.checkLength(sdt, 15)) {
                MsgBox.alert(this, "Số điện thoại tối da 15 ký tự !");
                txtSDT.requestFocus();
                return;
            }
            if (!Validate.isPhoneNumber(sdt)) {
                MsgBox.alert(this, "Số điện thoại đinh dạng !");
                txtSDT.requestFocus();
                return;
            }
        }
        KhachHang khachHang = khachHangService.findKhBySDT(sdt);
        String tenKH = "";

        if (khachHang.getId() == null) {

            boolean kqHoi = MsgBox.confirm(this, "Khách hàng ko tồn tại . \n Bạn có muốn tạo mới khách hàng ");
            if (kqHoi) {
                tenKH = JOptionPane.showInputDialog("Xin mời bạn nhập tên khách hàng !!!");
                if (tenKH.isEmpty()) {
                    MsgBox.alert(this, "Tên khách hàng chưa có !");
                    return;
                } else {
                    if (Validate.checkLength(tenKH, 50)) {
                        MsgBox.alert(this, "Tên khách hàng tối da 50 ký tự !");
                        return;
                    }
                    if (!Validate.isName(tenKH)) {
                        MsgBox.alert(this, "Tên khách hàng sai đinh dạng !");
                        return;
                    }
                }

                int maxIDKH = khachHangService.getRowCountKH() + 1;
                String maKH = "";
                if (maKH.isEmpty()) {
                    if (maxIDKH < 10) {
                        maKH = "KH" + "00" + maKH;
                    } else if (maxIDKH < 100) {
                        maKH = "KH" + "0" + maxIDKH;
                    } else {
                        maKH = "KH" + maxIDKH;
                    }
                }
                khachHang.setIdNV(nhanVien);
                khachHang.setTenKH(tenKH);
                khachHang.setSdt(sdt);
                khachHang.setMaKH(maKH);
                int kqInsert = khachHangService.insertKH_BH(khachHang);
                if (kqInsert != -1) {
                    MsgBox.alert(this, "tạo thành công 1 khách hàng");
                    khachHang = khachHangService.findKhBySDT(sdt);
                    defaultKhachHang = khachHang;
                    setKH(khachHang);
                }
            }

        } else {
            defaultKhachHang = khachHang;
            setKH(khachHang);

        }

        indexHD = tblHoaDon.getSelectedRow();
        if (indexHD != -1) {
            String maHD = tblHoaDon.getValueAt(indexHD, 1).toString();
            hoaDonService.updateHDBy(defaultKhachHang, maHD);
            listHD = hoaDonService.getAllHDByTrangThai2(0, Auth.user.getId());
            fillToTableHD(listHD);
        }
        if (defaultKhachHang != null) {
            setKH(defaultKhachHang);
        }
    }

    private boolean tinhTienThua() {
        String tienMatStr = "0";
        String tienCkStr = "0";
        int cbo = cboHTTT.getSelectedIndex();
        System.out.println("rave " + cbo + " dddd");
        tienMatStr = "0" + txtTienKhachDua.getText().trim();
        tienCkStr = "0" + txtTienKhachCK.getText().trim();
        String ttStr = txtThanhTien.getText().trim();
        BigDecimal tienKD = new BigDecimal(0);
        BigDecimal tienCK = new BigDecimal(0);
        BigDecimal tienTTKH = new BigDecimal(0);
        String maHD = txtMaHD.getText().trim();
        if (maHD.isEmpty()) {
            MsgBox.alert(this, "Chưa thấy mã hóa đơn");
            return true;
        }
        int trangThai = hoaDonService.getTrangThaiHD(maHD);
        if (trangThai == 2) {
            return false;
        }
        try {
            tienKD = new BigDecimal(tienMatStr);
            tienCK = new BigDecimal(tienCkStr);

        } catch (Exception e) {
            MsgBox.alert(this, "Số tiền bạn nhập phải là số !!!");
            return true;
        }
        ttStr = ttStr.replaceAll(",", "");
        BigDecimal tongTien = new BigDecimal(ttStr);
        BigDecimal tienThua = new BigDecimal(0);
        if (cbo == 0) {
            if (tienKD.compareTo(BigDecimal.ZERO) < 0) {
                MsgBox.alert(this, "Số tiền lớn hơn 0 !!!");
                return true;
            }
            if (tienKD.compareTo(tongTien) >= 0) {
                tienTTKH = tienKD.add(tienCK);
                tienThua = tienTTKH.subtract(tongTien);
            }

        } // CK
        else if (cbo == 1) {

            if (tienCK.compareTo(BigDecimal.ZERO) < 0) {
                MsgBox.alert(this, "Số tiền lớn hơn 0 !!!");
                return true;
            }
            if (tienCK.compareTo(tongTien) >= 0) {
                tienTTKH = tienCK.add(tienKD);
                tienThua = tienTTKH.subtract(tongTien);
            }

        } else {

            if (tienCK.compareTo(BigDecimal.ZERO) < 0 || tienKD.compareTo(BigDecimal.ZERO) < 0) {
                MsgBox.alert(this, "Số tiền lớn hơn 0 !!!");
                return true;
            }

            tienTTKH = tienKD.add(tienCK);
            tienThua = tienTTKH.subtract(tongTien);

        }
        if (tienThua.compareTo(BigDecimal.ZERO) >= 0) {
            System.out.println("rav orm_BanHang.tinhTienThua()" + tienTTKH);
            txtTienThua.setText(Format.format1(tienThua));
        }

        if (tienTTKH.compareTo(tongTien) >= 0) {
            return false;
        } else {
            return true;
        }

//        return false;
    }

    private void setFormTT(int index) {

        txtTienKhachDua.setText("0");
        txtTienKhachCK.setText("0");
        cboHTTT.setSelectedIndex(0);
        txtTienThua.setText("0");
        String maKH = tblHoaDon.getValueAt(index, 4).toString();
        defaultKhachHang = khachHangService.findKHByMaKH(maKH);
        setKH(defaultKhachHang);

        BigDecimal tongTien = BigDecimal.ZERO;
        for (HoaDonChiTiet chiTietHoaDon : listGH) {
            tongTien = tongTien.add(chiTietHoaDon.getThanhTien());
        }
        BigDecimal thanhTien = BigDecimal.ZERO;

        String maHD = tblHoaDon.getValueAt(indexHD, 1).toString();
        int trangThai = hoaDonService.getTrangThaiHD(maHD);
        if (trangThai == 2) {
            txtTienKhachDua.setEditable(false);
            txtTienKhachCK.setEditable(false);
        } else {
            txtTienKhachDua.setEditable(true);
            txtTienKhachCK.setEditable(true);
        }

        txtMaHD.setText(maHD);
        txtTenNV.setText(Auth.user.getHoTenNV());
        int i = 0;

        thanhTien = tongTien;
        txtTongTien.setText(Format.format1(tongTien) + "");
        if (thanhTien.compareTo(BigDecimal.ZERO) < 0) {
            txtThanhTien.setText(Format.format1(new BigDecimal(0)));
        } else {
            txtThanhTien.setText(Format.format1(thanhTien));
        }

        listPGG = phieuGiamGiaService.getALL(tongTien);
        int count0 = 0;
        for (PhieuGiamGia pgg : listPGG) {
            if (thanhTien.compareTo(pgg.getDonToiThieu()) >= 0) {
                count0++;
            }
        }
        //
        BigDecimal giamPGG = BigDecimal.ZERO;
        BigDecimal mucGiam = BigDecimal.ZERO;

        Long idDGG = hoaDonService.getPPGByMaHD(maHD);
        if (idDGG == 0) {
            if (count0 > 0) {
                txtPhieuGiamGia.setText("Bạn có  " + count0 + " phiếu giảm giá");
            } else {
                txtPhieuGiamGia.setText("");
            }
        } else {
            phieuGiamGia = hoaDonService.getPGGByID_BH(idDGG);
            txtPhieuGiamGia.setText(phieuGiamGia.getLoaiPGG() == 0 ? phieuGiamGia.getGiaTri() + " ( % )" : Format.format(phieuGiamGia.getGiaTri()) + "");
            if (phieuGiamGia.getLoaiPGG() == 0) {
                mucGiam = phieuGiamGia.getGiaTri();
                BigDecimal quyDoiPhanTram = mucGiam.divide(new BigDecimal(100));
                giamPGG = quyDoiPhanTram.multiply(tongTien);
                thanhTien = tongTien.subtract(giamPGG);
                System.out.println(" % " + giamPGG);
            } else {
                giamPGG = phieuGiamGia.getGiaTri();
                thanhTien = tongTien.subtract(giamPGG);
                System.out.println(" VND " + giamPGG);
            }
        }
        txtThanhTien.setText(Format.format(thanhTien));
        System.out.println("Thanh tien sau phieu : " + thanhTien);

        txtThanhTien.setText(Format.format1(thanhTien) + "");

        //  htt
        if (cboHTTT.getSelectedIndex() == 0) {
            txtTienKhachCK.setEditable(false);
        } else {
            txtTienKhachCK.setEditable(true);
        }

        BigDecimal tienKhachDua = BigDecimal.ZERO;

        if (Float.parseFloat(thanhTien + "") <= 0) {
            txtTongTien.setText("");
        }

    }

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        indexHD = tblHoaDon.getSelectedRow();
        if (indexHD == -1) {
            return;
        }
        long idHD = listHD.get(indexHD).getId();
        listGH = chiTietHoaDonService.findByIDHD(idHD);
        for (HoaDonChiTiet chiTietHoaDon : listGH) {
            chiTietHoaDon.getIdCTSP().getIdKichThuoc().setTenSize(
                    sService.getByID(chiTietHoaDon.getIdCTSP().getIdKichThuoc().getIdSize()).getTenSize()
            );
        }

        fillToTableGH(listGH);
        setFormTT(indexHD);
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnThemNhanhKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemNhanhKHActionPerformed
        Form_KhachHangJDialog2 form_KhachHangJDialog = new Form_KhachHangJDialog2(new Main(), true);
        form_KhachHangJDialog.setVisible(true);
        defaultKhachHang = form_KhachHangJDialog.getSelectedKhachHang();

        indexHD = tblHoaDon.getSelectedRow();
        if (indexHD != -1) {
            String maHD = tblHoaDon.getValueAt(indexHD, 1).toString();
            hoaDonService.updateHDBy(defaultKhachHang, maHD);
            listHD = hoaDonService.getAllHDByTrangThai2(0, Auth.user.getId());

            fillToTableHD(listHD);
        }

    }//GEN-LAST:event_btnThemNhanhKHActionPerformed

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        insertKH();
    }//GEN-LAST:event_txtSDTActionPerformed

    private void cboHTTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboHTTTActionPerformed
        switch (cboHTTT.getSelectedIndex()) {
            case 0:

                txtTienKhachCK.setText("");
                txtTienKhachDua.setEditable(true);
                txtTienKhachCK.setEditable(false);
                break;
            case 1:
                txtTienKhachCK.setEditable(true);
                txtTienKhachDua.setEditable(false);
                txtTienKhachDua.setText("");
                break;
            case 2:
                txtTienKhachCK.setEditable(true);
                txtTienKhachDua.setEditable(true);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_cboHTTTActionPerformed

    public void xoaSpTable() {
        String maHD = tblHoaDon.getValueAt(indexHD, 1).toString();

        for (int i = 0; i < tblGH.getRowCount(); i++) {
            Object ktr = tblGH.getValueAt(i, 9);

            System.out.println("ktr " + ktr);
            if (ktr instanceof Boolean && (Boolean) ktr) {

                String maSP = tblGH.getValueAt(i, 1).toString();

                int soLuongTbl = Integer.parseInt(tblGH.getValueAt(i, 4).toString());
                int slTon = sanPhamCT_Service.getSoLuongTonByMaCTSP(maSP);
                int soSL = soLuongTbl + slTon;

                System.out.println(soLuongTbl + " " + slTon + " " + soSL);

                long idHD = hoaDonService.findIDByMaHD(maHD);
                long idSP = chiTietHoaDonService.getIDSPCT(idHD);
                long idHDCT = listGH.get(i).getId();
// Tra ve khi xoa
                sanPhamCT_Service.updateSLSP(soSL, maSP);
                chiTietHoaDonService.deleteSPTrongGH(idHD, idHDCT, sanPhamCT_Service.getIdSPCTByMaSPCT(maSP));

            }
        }

        listGH = chiTietHoaDonService.findByIDHD(listHD.get(indexHD).getId());
        list = sanPhamCT_Service.getByTrangThai();
        fillToTableGH(listGH);
        fillToTableSP(list);
    }

    private HoaDon thanhToan() {
        HoaDon hoaDon = new HoaDon();

        try {
            String ttSP = "0" + txtTongTien.getText().trim().replaceAll(",", "");
            BigDecimal ttSPB = new BigDecimal(ttSP);
            String maHD = txtMaHD.getText().trim();
            int pttt = cboHTTT.getSelectedIndex();

            String tienKHDuaStr = "0" + txtTienKhachDua.getText().trim();
            tienKHDuaStr = tienKHDuaStr.replaceAll(",", "");
            String tienChuyenKhoanStr = "0" + txtTienKhachCK.getText().trim();
            tienChuyenKhoanStr = "0" + tienChuyenKhoanStr.replaceAll(",", "");
            String tienThuaStr = "0" + txtTienThua.getText().trim();
            String thanhTienStr = "0" + txtThanhTien.getText().trim().replaceAll(",", "");
            System.out.println(" TTT : " + thanhTienStr);
            tienThuaStr = tienThuaStr.replaceAll(",", "");
            BigDecimal tienKHDua = new BigDecimal(tienKHDuaStr);
            BigDecimal tienChuyenKhoan = new BigDecimal(tienChuyenKhoanStr);
            BigDecimal thanhTien = new BigDecimal(thanhTienStr);
            BigDecimal tongCK_TD = BigDecimal.ZERO;
            tongCK_TD = tienChuyenKhoan.add(tienKHDua);

            int trangThai = hoaDonService.getTrangThaiHD(maHD);
            if (trangThai == 0) {
                trangThai = 1;
            }

            if (cboHTTT.getSelectedIndex() == 0) {

                tongCK_TD = tienKHDua.add(tienChuyenKhoan);
            } else if (cboHTTT.getSelectedIndex() == 1 && new BigDecimal(tienChuyenKhoanStr).compareTo(new BigDecimal(thanhTienStr)) < 0) {
                tongCK_TD = tienKHDua.add(tienChuyenKhoan);
            } else if (cboHTTT.getSelectedIndex() == 2 && tongCK_TD.compareTo((thanhTien)) < 0) {
                tongCK_TD = tienKHDua.add(tienChuyenKhoan);
            }

            if (tongCK_TD.compareTo(thanhTien) < 0) {
                MsgBox.alert(this, "Số tiền khách trả chưa đủ !!!");
                return null;
            }

            Date date = new Date();

            hoaDon.setMaHoaDon(maHD);
            hoaDon.setPhuongThucTT(pttt);
            hoaDon.setTienKhDua(new BigDecimal(tienKHDuaStr));
            hoaDon.setTienKhChuyenKhoan(new BigDecimal(tienChuyenKhoanStr));
            hoaDon.setTienThua(new BigDecimal(tienThuaStr));
            hoaDon.setThanhTien(thanhTien);
            hoaDon.setNgayTao(new Date());
            hoaDon.setTrangThai(trangThai);
            hoaDon.setTongTienSP(ttSPB);
        } catch (Exception e) {
            e.printStackTrace();
            MsgBox.alert(this, "Lỗi thanh toán !!!");
            return null;
        }
        return hoaDon;
    }

    private void txtTienKhachDuaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachDuaKeyReleased
        tinhTienThua();
    }//GEN-LAST:event_txtTienKhachDuaKeyReleased

    private void txtTienKhachCKKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienKhachCKKeyPressed
        tinhTienThua();
    }//GEN-LAST:event_txtTienKhachCKKeyPressed

    private void ckbAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbAllActionPerformed
        for (int i = 0; i < tblGH.getRowCount(); i++) {
            tblGH.setValueAt(true, i, 8);
            String maHD = "";
        }
    }//GEN-LAST:event_ckbAllActionPerformed

    private void btnXoaGHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaGHActionPerformed
        xoaSpTable();
    }//GEN-LAST:event_btnXoaGHActionPerformed

    private void btnXoaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaHDActionPerformed
        boolean check = MsgBox.confirm(this, "Bạn có muốn xóa hóa đơn này không?");
        if (check) {
            System.out.println(listHD.get(indexHD).getId());
            chiTietHoaDonService.deleteHDCT(listHD.get(indexHD).getId());
            MsgBox.alert(this, "Xóa thành công!!!");
        } else {
            return;
        }
        hoaDonService.hartDeleteHoaDon(listHD.get(indexHD).getId());
        this.fillToTableHD(hoaDonService.findHoaDonByTranThai());
        dtm = (DefaultTableModel) tblGH.getModel();
        dtm.setRowCount(0);
        lblDonTreo.setText("" + hoaDonService.getHoaDonTreo());
        txtMaHD.setText("");
        setKH(defaultKhachHang1);
    }//GEN-LAST:event_btnXoaHDActionPerformed

    private void txtPhieuGiamGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtPhieuGiamGiaMouseClicked
        String ttStr = "0";
        ttStr = txtTongTien.getText().trim();
        ttStr = ttStr.replaceAll(",", "");
        System.out.println(ttStr);
        BigDecimal tt = new BigDecimal(ttStr);
        if (tt.compareTo(BigDecimal.ZERO) == 0) {
            MsgBox.alert(this, "Bạn không có khuyến mãi nào !!");
            return;

        }
        ViewPhieuGiamGia viewPhieuGiam = new ViewPhieuGiamGia(new Main(), true, tt, txtMaHD.getText());
        viewPhieuGiam.setVisible(true);
        phieuGiamGia = viewPhieuGiam.getPGGSelect();
        setFormTT(indexHD);
    }//GEN-LAST:event_txtPhieuGiamGiaMouseClicked

    private void clearFormTT() {
        txtTienKhachCK.setText("");
        txtMaHD.setText("");
        txtPhieuGiamGia.setText("");
        txtThanhTien.setText("");
        txtTienThua.setText("");
        txtTienKhachDua.setText("");
        txtTongTien.setText("");
        cboHTTT.setSelectedIndex(0);
        phieuGiamGia = new PhieuGiamGia();
    }

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        if (indexHD == -1) {
            MsgBox.alert(this, "Bạn hãy chọn 1 hóa đơn !!!");
            return;
        }

        if (listGH.isEmpty()) {
            MsgBox.alert(this, "Hóa đơn chưa có sản phẩm nào !!!");
            return;
        }
        HoaDon hoaDon = thanhToan();
        if (hoaDon == null) {
            return;
        }

        if (tinhTienThua()) {
            MsgBox.alert(this, "Chưa đủ tiền");
            return;
        }

        Integer soLuong = 0;
        try {
            Long idPGG = phieuGiamGia.getId();
            if (idPGG >= 0) {
                soLuong = phieuGiamGia.getSoLuongPhieu();
            }
            phieuGiamGiaService.updateSoLuongPhieu(idPGG, soLuong - 1);
            phieuGiamGiaService.updateKetThuc(date);
        } catch (Exception e) {
        }

        for (int i = 0; i < tblGH.getRowCount(); i++) {
            String maSP = tblGH.getValueAt(i, 1).toString();
            Integer slGH = Integer.parseInt(tblGH.getValueAt(i, 04).toString());
            Integer soLuongTon = hoaDonService.getSoLuongTon(maSP);
            sanPhamCT_Repository.updateSLSP(soLuongTon - slGH, maSP);
        }

        BigDecimal tienKhachDua = BigDecimal.valueOf(Double.parseDouble(txtTienKhachDua.getText()));
        hoaDon.setNgayThanhToan(new Date());
        hoaDon.setTienKhDua(tienKhachDua);
        int kq = hoaDonService.thanh_toanHD(hoaDon);
        if (kq == 1) {
            MsgBox.alert(this, "Thanh toán thành công");
            listHD = hoaDonService.findHoaDonByTranThai();
            fillToTableHD(listHD);

            list = sanPhamCT_Repository.getByTrangThai();
            fillToTableSP(list);

            dtm = (DefaultTableModel) tblGH.getModel();
            dtm.setRowCount(0);

            lblDonTreo.setText(hoaDonService.getHoaDonTrao(0, Auth.user.getId()) + "");
            clearFormTT();
        } else {
            MsgBox.alert(this, "Thanh toán không thành công");
        }

    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        listHD = hoaDonService.findHoaDonByTranThai();
        list = sanPhamCT_Service.getByTrangThai();
        fillToTableHD(listHD);
        fillToTableSP(list);
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgpHinhThucTT;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnThemNhanhKH;
    private javax.swing.JButton btnXoaGH;
    private javax.swing.JButton btnXoaHD;
    private javax.swing.JComboBox<String> cboHTTT;
    private javax.swing.JComboBox<String> cboMau;
    private javax.swing.JComboBox<String> cboSize;
    private javax.swing.JComboBox<String> cboTen;
    private javax.swing.JComboBox<String> cboThuongHieu;
    private javax.swing.JCheckBox ckbAll;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblDonTreo;
    private javax.swing.JTable tblGH;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblSP;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtPhieuGiamGia;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSreach;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtThanhTien;
    private javax.swing.JTextField txtTienKhachCK;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables

}
