package javaswingdev.form;

import Utils.Auth;
import Utils.MsgBox;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javaswingdev.entity.ChatLieu;
import javaswingdev.entity.KichThuoc;
import javaswingdev.entity.MauSac;
import javaswingdev.entity.NhanVien;
import javaswingdev.entity.SanPham;
import javaswingdev.entity.SanPhamChiTiet;
import javaswingdev.entity.ThuongHieu;
import javaswingdev.impl.DisplayValueProvider;
import javaswingdev.main.Main;
import javaswingdev.service.ChatLieuService;
import javaswingdev.service.MauService;
import javaswingdev.service.NhanVienService;
import javaswingdev.service.SanPhamCT_Service;
import javaswingdev.service.SanPhamService;
import javaswingdev.service.SizeService;
import javaswingdev.service.ThuongHieuService;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class Form_SanPham extends javax.swing.JPanel {

    private DefaultTableModel dtm = new DefaultTableModel();

    private final MauService mauService = new MauService();
    private final SizeService sizeService = new SizeService();
    private final ChatLieuService chatLieuService = new ChatLieuService();
    private final ThuongHieuService thuongHieuService = new ThuongHieuService();
    private final SanPhamService sanPhamService = new SanPhamService();
    private final SanPhamCT_Service spctService = new SanPhamCT_Service();
    private final NhanVienService nvService = new NhanVienService();

    private List<MauSac> listMauSac = new ArrayList<>();
    private List<KichThuoc> listSize = new ArrayList<>();
    private List<ChatLieu> listChatLieu = new ArrayList<>();
    private List<ThuongHieu> listThuongHieu = new ArrayList<>();
    private List<SanPham> listSP = new ArrayList<>();
    private List<SanPhamChiTiet> listSPCT = new ArrayList<>();
    private List<NhanVien> listNguoiTao = new ArrayList<>();
    private final List<String> listTrangThai = new ArrayList<>();

    private int indexSP = -1;
    private int indexSPCT = -1;

    public Form_SanPham(String name) {
        initComponents();
        this.init();
    }

    private void init() {
        this.pushDataToList();
        this.loadFullData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        txt_keyword = new javax.swing.JTextField();
        btn_Loc = new javax.swing.JButton();
        cbx_THTK = new javax.swing.JComboBox<>();
        cbx_MauTK = new javax.swing.JComboBox<>();
        cbx_SizeKT = new javax.swing.JComboBox<>();
        cbx_CLTK = new javax.swing.JComboBox<>();
        cbx_NgTaoTK = new javax.swing.JComboBox<>();
        cbx_TrTTK = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_SP = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_MaGiay = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_TenGiay = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btn_ThemSP = new javax.swing.JButton();
        btn_SuaSP = new javax.swing.JButton();
        btn_LamMoiSP = new javax.swing.JButton();
        cbx_TrTSP = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txt_SoLuongSP = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_SPCT = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txt_MaSPCT = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbx_MauSPCT = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbx_CLSPCT = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cbx_SizeSCPT = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cbx_THSPCT = new javax.swing.JComboBox<>();
        txt_SoLuongSPCT = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txA_MoTa = new javax.swing.JTextArea();
        jButton16 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        txt_GiaBan = new javax.swing.JTextField();
        txt_TenGiaySPCT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        cbx_TrTSPCT = new javax.swing.JComboBox<>();
        btn_ThemSPCT = new javax.swing.JButton();
        btn_SuaSPCT = new javax.swing.JButton();
        btn_LamMoiSPCT = new javax.swing.JButton();

        setOpaque(false);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Danh Sách Giày ");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm Kiếm Giày"));

        txt_keyword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_keywordKeyReleased(evt);
            }
        });

        btn_Loc.setText("Lọc");
        btn_Loc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LocActionPerformed(evt);
            }
        });

        cbx_THTK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbx_THTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbx_THTKMouseClicked(evt);
            }
        });

        cbx_MauTK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbx_MauTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_MauTKActionPerformed(evt);
            }
        });

        cbx_SizeKT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbx_SizeKT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_SizeKTActionPerformed(evt);
            }
        });

        cbx_CLTK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbx_CLTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbx_CLTKMouseClicked(evt);
            }
        });
        cbx_CLTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_CLTKActionPerformed(evt);
            }
        });

        cbx_NgTaoTK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbx_NgTaoTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbx_NgTaoTKMouseClicked(evt);
            }
        });
        cbx_NgTaoTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_NgTaoTKActionPerformed(evt);
            }
        });

        cbx_TrTTK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbx_TrTTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbx_TrTTKMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txt_keyword, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbx_THTK, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbx_MauTK, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbx_SizeKT, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbx_CLTK, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbx_NgTaoTK, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbx_TrTTK, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_Loc)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_keyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_Loc)
                    .addComponent(cbx_THTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_MauTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_SizeKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_CLTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_NgTaoTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbx_TrTTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh Sách Giày"));

        tbl_SP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "MASP", "TenSP", "SoLuong", "NgayTao", "NguoiTao", "TrangThai"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_SP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_SPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_SP);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Mã Giày :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Tên Giày :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Trạng Thái :");

        btn_ThemSP.setText("Thêm");
        btn_ThemSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemSPActionPerformed(evt);
            }
        });

        btn_SuaSP.setText("Sửa");
        btn_SuaSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaSPActionPerformed(evt);
            }
        });

        btn_LamMoiSP.setText("Làm Mới");
        btn_LamMoiSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LamMoiSPActionPerformed(evt);
            }
        });

        cbx_TrTSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setText("Số Lượng :");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbx_TrTSP, 0, 410, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txt_TenGiay, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(txt_SoLuongSP))
                    .addComponent(txt_MaGiay))
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(148, Short.MAX_VALUE)
                .addComponent(btn_ThemSP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_SuaSP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_LamMoiSP)
                .addGap(147, 147, 147))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addComponent(txt_MaGiay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_TenGiay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(txt_SoLuongSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbx_TrTSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_ThemSP)
                    .addComponent(btn_SuaSP)
                    .addComponent(btn_LamMoiSP))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_LamMoiSP, btn_SuaSP, btn_ThemSP, cbx_TrTSP, jLabel11, jLabel2, jLabel3, jLabel4, txt_MaGiay, txt_SoLuongSP, txt_TenGiay});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Sản Phẩm Chi Tiết"));

        tbl_SPCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "MaSPCT", "ThuongHieu", "Mau", "Size", "ChatLieu", "SoLuongTon", "GiaBan", "NgayTao", "NguoiTao", "TrangThai"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_SPCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_SPCTMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_SPCT);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("Mã SPCT :");

        jLabel7.setText("Màu :");

        cbx_MauSPCT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("Chất Liệu :");

        cbx_CLSPCT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel9.setText("Size :");

        cbx_SizeSCPT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setText("Thương Hiệu :");

        cbx_THSPCT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel12.setText("Số Lượng :");

        jLabel13.setText("Mô tả :");

        txA_MoTa.setColumns(20);
        txA_MoTa.setRows(5);
        jScrollPane3.setViewportView(txA_MoTa);

        jButton16.setText("+");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jLabel14.setText("Giá Bán :");

        txt_TenGiaySPCT.setEditable(false);

        jLabel6.setText("Tên Giầy :");

        jButton17.setText("+");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setText("+");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setText("+");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jLabel15.setText("Trạng Thái :");

        cbx_TrTSPCT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel6)
                            .addComponent(jLabel14))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_TenGiaySPCT, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(cbx_SizeSCPT, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton19))
                            .addComponent(txt_GiaBan)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel12)
                            .addComponent(jLabel15))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_SoLuongSPCT, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbx_MauSPCT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbx_THSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbx_CLSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton16)
                                    .addComponent(jButton17)
                                    .addComponent(jButton18)))
                            .addComponent(cbx_TrTSPCT, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_MaSPCT))))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbx_CLSPCT, cbx_MauSPCT, cbx_SizeSCPT, cbx_THSPCT});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_MaSPCT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx_MauSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jButton16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbx_THSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbx_CLSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbx_SizeSCPT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jButton19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_TenGiaySPCT)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txt_GiaBan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txt_SoLuongSPCT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(cbx_TrTSPCT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbx_CLSPCT, cbx_MauSPCT, cbx_SizeSCPT, cbx_THSPCT});

        btn_ThemSPCT.setText("Thêm");
        btn_ThemSPCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ThemSPCTActionPerformed(evt);
            }
        });

        btn_SuaSPCT.setText("Sửa ");
        btn_SuaSPCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SuaSPCTActionPerformed(evt);
            }
        });

        btn_LamMoiSPCT.setText("Làm Mới");
        btn_LamMoiSPCT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LamMoiSPCTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btn_ThemSPCT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_SuaSPCT, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(btn_LamMoiSPCT))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_LamMoiSPCT, btn_SuaSPCT, btn_ThemSPCT});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(btn_ThemSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_SuaSPCT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_LamMoiSPCT)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_LamMoiSPCT, btn_SuaSPCT, btn_ThemSPCT});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_SPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SPMouseClicked
        // TODO add your handling code here:
        indexSP = tbl_SP.getSelectedRow();
        this.setFormSP(indexSP);
    }//GEN-LAST:event_tbl_SPMouseClicked

    private void tbl_SPCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_SPCTMouseClicked
        // TODO add your handling code here:
        indexSPCT = tbl_SPCT.getSelectedRow();
        this.setFormSPCT(indexSPCT);
    }//GEN-LAST:event_tbl_SPCTMouseClicked

    private void btn_ThemSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemSPActionPerformed
        // TODO add your handling code here:
        if (this.validateSP() == false) {
            SanPham sanPham = this.getInputSanPham();
            sanPham.setNgayTao(new Date());

            if (checkDuplicateSP()) {
                return;
            }

            try {
                if (sanPhamService.addSanPham(sanPham) != null) {
                    MsgBox.alert(this, "Them Moi San Pham Thanh Cong");
                    this.resetFormSanPham();
                } else {
                    MsgBox.alert(this, "Them Moi San Pham Khong Thanh Cong");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return;
        }
    }//GEN-LAST:event_btn_ThemSPActionPerformed

    private void btn_SuaSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaSPActionPerformed
        // TODO add your handling code here:
        if (indexSP == -1) {
            MsgBox.alert(this, "Chua Chon SP");
            return;
        }

        if (this.validateSP() == false) {
            SanPham sanPham = this.getInputSanPham();
            sanPham.setIdSanPham(listSP.get(indexSP).getIdSanPham());
            try {
                if (sanPhamService.updateSanPham(sanPham) != null) {
                    MsgBox.alert(this, "Sua San Pham Thanh Cong");
                    this.resetFormSanPham();
                } else {
                    MsgBox.alert(this, "Sua San Pham Khong Thanh Cong");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return;
        }
    }//GEN-LAST:event_btn_SuaSPActionPerformed

    private void btn_ThemSPCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ThemSPCTActionPerformed
        // TODO add your handling code here:
        if (indexSP == -1) {
            MsgBox.alert(this, "Chưa chọn sản phẩm");
            return;
        }

        if (!validateSPCT()) {
            SanPham sanPham = listSP.get(indexSP);
            SanPhamChiTiet sanPhamChiTiet = this.getInputSanPhamChiTiet(sanPham);
            sanPhamChiTiet.setNgayTao(new Date());

            if (checkDuplicateSPCT()) {
                return;
            }

            if (checkTongSLSPCT_T(sanPhamChiTiet.getSoLuong())) {
                return;
            }

            try {
                if (spctService.addSanPhamChiTiet(sanPhamChiTiet) != null) {
                    MsgBox.alert(this, "Thêm thành công");
                    this.resetFormSanPhamChiTiet();
                } else {
                    MsgBox.alert(this, "Them Khong Thanh Cong");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return;
        }
    }//GEN-LAST:event_btn_ThemSPCTActionPerformed

    private void btn_SuaSPCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SuaSPCTActionPerformed
        // TODO add your handling code here:
        if (indexSP == -1) {
            MsgBox.alert(this, "Chua Chon SP");
            return;
        }

        if (!validateSPCT()) {
            SanPham sanPham = listSP.get(indexSP);
            SanPhamChiTiet sanPhamChiTiet = this.getInputSanPhamChiTiet(sanPham);
            sanPhamChiTiet.setIdSPCT(listSPCT.get(indexSPCT).getIdSPCT());

            if (checkTongSLSPCT_U(sanPhamChiTiet.getSoLuong())) {
                return;
            }

            try {
                if (spctService.updateSPCT(sanPhamChiTiet) != null) {
                    MsgBox.alert(this, "Sua Thanh Cong");
                    this.resetFormSanPhamChiTiet();
                } else {
                    MsgBox.alert(this, "Sua Khong Thanh Cong");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            return;
        }
    }//GEN-LAST:event_btn_SuaSPCTActionPerformed

    private void btn_LamMoiSPCTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LamMoiSPCTActionPerformed
        // TODO add your handling code here:
        this.resetFormSanPhamChiTiet();
    }//GEN-LAST:event_btn_LamMoiSPCTActionPerformed

    private void btn_LamMoiSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LamMoiSPActionPerformed
        // TODO add your handling code here:
        this.resetFormSanPham();
    }//GEN-LAST:event_btn_LamMoiSPActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        MauSacJDialog form_MauSac = new MauSacJDialog(new Main(), true);
        form_MauSac.setVisible(true);
        MauSac mausac = form_MauSac.returnSelectedMauSac();
        if (mausac != null) {
            listMauSac = mauService.getToAll();
            loadDataComoBox(cbx_MauSPCT, "MauSac", listMauSac, MauSac::getTenMau);
            cbx_MauSPCT.setSelectedItem(mausac.getTenMau());
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        ThuongHieuJDialog form_MauSac = new ThuongHieuJDialog(new Main(), true);
        form_MauSac.setVisible(true);
        ThuongHieu mausac = form_MauSac.returnSelectedThuongHieu();
        if (mausac != null) {
            listThuongHieu = thuongHieuService.getToAll();
            loadDataComoBox(cbx_THSPCT, "ThuongHieu", listThuongHieu, ThuongHieu::getTenThuongHieu);
            cbx_THSPCT.setSelectedItem(mausac.getTenThuongHieu());
        }
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        ChatLieuJDialog form_MauSac = new ChatLieuJDialog(new Main(), true);
        form_MauSac.setVisible(true);
        ChatLieu mausac = form_MauSac.returnSelectedChatLieu();
        if (mausac != null) {
            listChatLieu = chatLieuService.getToAllChatLieu();
            loadDataComoBox(cbx_CLSPCT, "ThuongHieu", listChatLieu, ChatLieu::getTenCL);
            cbx_CLSPCT.setSelectedItem(mausac.getTenCL());
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        SizeJDialog form_MauSac = new SizeJDialog(new Main(), true);
        form_MauSac.setVisible(true);
        KichThuoc mausac = form_MauSac.returnSelectedKichThuoc();
        if (mausac != null) {
            listSize = sizeService.getToAllKichThuoc();
            loadDataComoBox(cbx_SizeSCPT, "ThuongHieu", listSize, (kichthuoc) -> String.valueOf(kichthuoc.getTenSize()));
            String tenSize = "" + mausac.getTenSize();
            cbx_SizeSCPT.setSelectedItem(tenSize.trim());
        }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void txt_keywordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_keywordKeyReleased
        // TODO add your handling code here:
        String keyword = txt_keyword.getText().trim();
        if (!keyword.equals("")) {
            listSP = sanPhamService.findAllSP(keyword);
            loadDataTableSP(listSP);
        }
    }//GEN-LAST:event_txt_keywordKeyReleased

    private void btn_LocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LocActionPerformed
        // TODO add your handling code here:
        if (indexSP == -1) {
            MsgBox.alert(this, "Vui Long Chon SP");
            return;
        }
        String thuonghieu = null;
        String mau = null;
        String kichthuoc = null;
        String chatlieu = null;
        String nguoitao = null;
        Integer trangthai = null;
        if (cbx_THTK.getSelectedIndex() == 0) {
            thuonghieu = null;
        } else {
            thuonghieu = (String) cbx_THTK.getSelectedItem();
        }
        if (cbx_MauTK.getSelectedIndex() == 0) {
            mau = null;
        } else {
            mau = (String) cbx_MauTK.getSelectedItem();
        }
        if (cbx_SizeKT.getSelectedIndex() == 0) {
            kichthuoc = null;
        } else {
            kichthuoc = (String) cbx_SizeKT.getSelectedItem();
        }
        if (cbx_CLTK.getSelectedIndex() == 0) {
            chatlieu = null;
        } else {
            chatlieu = (String) cbx_CLTK.getSelectedItem();
        }
        if (cbx_NgTaoTK.getSelectedIndex() == 0) {
            nguoitao = null;
        } else {
            nguoitao = (String) cbx_NgTaoTK.getSelectedItem();
        }
        if (cbx_TrTTK.getSelectedIndex() == 0) {
            trangthai = null;
        } else {
            if (cbx_TrTTK.getSelectedItem().equals("Con Hang")) {
                trangthai = 0;
            } else if (cbx_TrTTK.getSelectedItem().equals("Het Hang")) {
                trangthai = 1;
            }
        }
        listSPCT = spctService.findByIdSP(listSP.get(indexSP).getIdSanPham(), thuonghieu, mau, kichthuoc, chatlieu, nguoitao, trangthai);
        loadDataTableSPCT(listSPCT);
    }//GEN-LAST:event_btn_LocActionPerformed

    private void cbx_THTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbx_THTKMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_THTKMouseClicked

    private void cbx_MauTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_MauTKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_MauTKActionPerformed

    private void cbx_SizeKTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_SizeKTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_SizeKTActionPerformed

    private void cbx_CLTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_CLTKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_CLTKActionPerformed

    private void cbx_CLTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbx_CLTKMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_CLTKMouseClicked

    private void cbx_NgTaoTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_NgTaoTKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_NgTaoTKActionPerformed

    private void cbx_NgTaoTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbx_NgTaoTKMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_NgTaoTKMouseClicked

    private void cbx_TrTTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbx_TrTTKMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbx_TrTTKMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_LamMoiSP;
    private javax.swing.JButton btn_LamMoiSPCT;
    private javax.swing.JButton btn_Loc;
    private javax.swing.JButton btn_SuaSP;
    private javax.swing.JButton btn_SuaSPCT;
    private javax.swing.JButton btn_ThemSP;
    private javax.swing.JButton btn_ThemSPCT;
    private javax.swing.JComboBox<String> cbx_CLSPCT;
    private javax.swing.JComboBox<String> cbx_CLTK;
    private javax.swing.JComboBox<String> cbx_MauSPCT;
    private javax.swing.JComboBox<String> cbx_MauTK;
    private javax.swing.JComboBox<String> cbx_NgTaoTK;
    private javax.swing.JComboBox<String> cbx_SizeKT;
    private javax.swing.JComboBox<String> cbx_SizeSCPT;
    private javax.swing.JComboBox<String> cbx_THSPCT;
    private javax.swing.JComboBox<String> cbx_THTK;
    private javax.swing.JComboBox<String> cbx_TrTSP;
    private javax.swing.JComboBox<String> cbx_TrTSPCT;
    private javax.swing.JComboBox<String> cbx_TrTTK;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
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
    private javax.swing.JTable tbl_SP;
    private javax.swing.JTable tbl_SPCT;
    private javax.swing.JTextArea txA_MoTa;
    private javax.swing.JTextField txt_GiaBan;
    private javax.swing.JTextField txt_MaGiay;
    private javax.swing.JTextField txt_MaSPCT;
    private javax.swing.JTextField txt_SoLuongSP;
    private javax.swing.JTextField txt_SoLuongSPCT;
    private javax.swing.JTextField txt_TenGiay;
    private javax.swing.JTextField txt_TenGiaySPCT;
    private javax.swing.JTextField txt_keyword;
    // End of variables declaration//GEN-END:variables
    private static <T> void loadDataComoBox(JComboBox<String> cbx, String tenCB, List<T> list, DisplayValueProvider<T> provider) {
        cbx.removeAllItems();
        cbx.addItem("--" + tenCB + "--");
        for (T item : list) {
            cbx.addItem(provider.getDisplayValue(item));
        }
    }

    private void loadDataComoBox(JComboBox<String> cbx, String tenCB, List<String> list) {
        cbx.removeAllItems();
        cbx.addItem("--" + tenCB + "--");
        for (String string : list) {
            cbx.addItem(string);
        }
    }

    private void loadDataTableSP(List<SanPham> listSP) {
        dtm = (DefaultTableModel) tbl_SP.getModel();
        dtm.setRowCount(0);
        for (SanPham sanPham : listSP) {
            dtm.addRow(sanPham.toDataRow());
        }
    }

    private void loadDataTableSPCT(List<SanPhamChiTiet> listSPCT) {
        dtm = (DefaultTableModel) tbl_SPCT.getModel();
        dtm.setRowCount(0);
        for (SanPhamChiTiet spct : listSPCT) {
            dtm.addRow(spct.rowDataSPCT());
        }
    }

    private void pushDataToList() {
        listChatLieu = chatLieuService.getToAllChatLieu();
        listMauSac = mauService.getToAll();
        listSize = sizeService.getToAllKichThuoc();
        listThuongHieu = thuongHieuService.getToAll();
        listSP = sanPhamService.findAllSP();
        listNguoiTao = nvService.findAll();
        listTrangThai.add("Con Hang");
        listTrangThai.add("Het Hang");
    }

    private void loadFullData() {
//        LoadData ComoboxTK
        loadDataComoBox(cbx_MauTK, "MauSac", listMauSac, MauSac::getTenMau);
        loadDataComoBox(cbx_SizeKT, "Size", listSize, (kichthuoc) -> String.valueOf(kichthuoc.getTenSize()));
        loadDataComoBox(cbx_CLTK, "ChatLieu", listChatLieu, ChatLieu::getTenCL);
        loadDataComoBox(cbx_THTK, "ThuongHieu", listThuongHieu, ThuongHieu::getTenThuongHieu);
        loadDataComoBox(cbx_NgTaoTK, "NguoiTao", listNguoiTao, NhanVien::getHoTenNV);
        loadDataComoBox(cbx_TrTTK, "TrangThai", listTrangThai);

//        LoadData ComoboxSP
        loadDataComoBox(cbx_TrTSP, "TrangThai", listTrangThai);

//        LoadData ComoboxSPCT
        loadDataComoBox(cbx_MauSPCT, "MauSac", listMauSac, MauSac::getTenMau);
        loadDataComoBox(cbx_SizeSCPT, "KichThuoc", listSize, (kichthuoc) -> String.valueOf(kichthuoc.getTenSize()));
        loadDataComoBox(cbx_CLSPCT, "ChatLieu", listChatLieu, ChatLieu::getTenCL);
        loadDataComoBox(cbx_THSPCT, "ThuongHieu", listThuongHieu, ThuongHieu::getTenThuongHieu);
        loadDataComoBox(cbx_TrTSPCT, "TrangThai", listTrangThai);

//        LoadDataTableSP
        this.loadDataTableSP(listSP);
    }

    private void setFormSP(int index) {
        txt_MaGiay.setText(listSP.get(index).getMaSanPham());
        txt_TenGiay.setText(listSP.get(index).getTenSanpham());
        txt_TenGiaySPCT.setText(listSP.get(index).getTenSanpham());
        txt_SoLuongSP.setText("" + listSP.get(index).getSoLuong());
        if (listSP.get(index).getTrangThai() == 0) {
            cbx_TrTSP.setSelectedIndex(1);
        } else {
            cbx_TrTSP.setSelectedIndex(2);
        }

        listSPCT = spctService.findByIdSP(listSP.get(index).getIdSanPham());
        this.loadDataTableSPCT(listSPCT);
    }

    private void setFormSPCT(int index) {
        txt_MaSPCT.setText(listSPCT.get(index).getMaSPCT());
        txt_GiaBan.setText("" + listSPCT.get(index).getGiaBan());
        txt_SoLuongSPCT.setText("" + listSPCT.get(index).getSoLuong());
        txA_MoTa.setText("" + listSPCT.get(index).getMoTa());

        if (listSPCT.get(index).getTrangThai() == 0) {
            cbx_TrTSPCT.setSelectedIndex(1);
        } else {
            cbx_TrTSPCT.setSelectedIndex(2);
        }

        cbx_MauSPCT.setSelectedItem(listSPCT.get(index).getIdMau().getTenMau());
        String size = String.valueOf(listSPCT.get(index).getIdKichThuoc().getTenSize());
        cbx_SizeSCPT.setSelectedItem(size);
        cbx_CLSPCT.setSelectedItem(listSPCT.get(index).getIdChatLieu().getTenCL());
        cbx_THSPCT.setSelectedItem(listSPCT.get(index).getIdThuongHieu().getTenThuongHieu());
    }

    private SanPham getInputSanPham() {
        SanPham sanpham = new SanPham();
        sanpham.setMaSanPham(txt_MaGiay.getText());
        sanpham.setTenSanpham(txt_TenGiay.getText());
        sanpham.setNguoiTao(Auth.user.getHoTenNV());
        sanpham.setSoLuong(Integer.valueOf(txt_SoLuongSP.getText()));
        if (cbx_TrTSP.getSelectedItem().equals("Con Hang")) {
            sanpham.setTrangThai(0);
        } else {
            sanpham.setTrangThai(1);
        }
        return sanpham;
    }

    private void resetFormSanPham() {
        indexSP = -1;
        pushDataToList();
        loadFullData();

        cbx_CLSPCT.setSelectedIndex(0);
        cbx_CLTK.setSelectedIndex(0);
        cbx_MauSPCT.setSelectedIndex(0);
        cbx_MauTK.setSelectedIndex(0);
        cbx_NgTaoTK.setSelectedIndex(0);
        cbx_SizeKT.setSelectedIndex(0);
        cbx_SizeSCPT.setSelectedIndex(0);
        cbx_THSPCT.setSelectedIndex(0);
        cbx_THTK.setSelectedIndex(0);
        cbx_TrTSP.setSelectedIndex(0);
        cbx_TrTSPCT.setSelectedIndex(0);
        cbx_TrTTK.setSelectedIndex(0);

        String t = "";
        txA_MoTa.setText(t);
        txt_GiaBan.setText(t);
        txt_MaGiay.setText(t);
        txt_MaSPCT.setText(t);
        txt_SoLuongSP.setText(t);
        txt_SoLuongSPCT.setText(t);
        txt_TenGiay.setText(t);
        txt_TenGiaySPCT.setText(t);

        dtm = (DefaultTableModel) tbl_SPCT.getModel();
        dtm.setRowCount(0);
    }

    private void resetFormSanPhamChiTiet() {
        if (indexSP != -1) {
            indexSPCT = -1;
            pushDataToList();
            loadFullData();
            listSPCT = spctService.findByIdSP(listSP.get(indexSP).getIdSanPham());
            this.loadDataTableSPCT(listSPCT);

            cbx_CLSPCT.setSelectedIndex(0);
            cbx_CLTK.setSelectedIndex(0);
            cbx_MauSPCT.setSelectedIndex(0);
            cbx_MauTK.setSelectedIndex(0);
            cbx_NgTaoTK.setSelectedIndex(0);
            cbx_SizeKT.setSelectedIndex(0);
            cbx_SizeSCPT.setSelectedIndex(0);
            cbx_THSPCT.setSelectedIndex(0);
            cbx_THTK.setSelectedIndex(0);
            cbx_TrTSP.setSelectedIndex(0);
            cbx_TrTSPCT.setSelectedIndex(0);
            cbx_TrTTK.setSelectedIndex(0);

            String t = "";
            txA_MoTa.setText(t);
            txt_GiaBan.setText(t);
            txt_MaSPCT.setText(t);
            txt_SoLuongSPCT.setText(t);
        } else {
            indexSPCT = -1;
            dtm = (DefaultTableModel) tbl_SPCT.getModel();
            dtm.setRowCount(0);
        }
    }

    private SanPhamChiTiet getInputSanPhamChiTiet(SanPham sanPham) {
        SanPhamChiTiet sanPhamChiTiet = new SanPhamChiTiet();

        MauSac mauSac = listMauSac.get(cbx_MauSPCT.getSelectedIndex() - 1);
        KichThuoc kichThuoc = listSize.get(cbx_SizeSCPT.getSelectedIndex() - 1);
        ChatLieu chatLieu = listChatLieu.get(cbx_CLSPCT.getSelectedIndex() - 1);
        ThuongHieu thuongHieu = listThuongHieu.get(cbx_THSPCT.getSelectedIndex() - 1);

        sanPhamChiTiet.setIdChatLieu(chatLieu);
        sanPhamChiTiet.setIdKichThuoc(kichThuoc);
        sanPhamChiTiet.setIdThuongHieu(thuongHieu);
        sanPhamChiTiet.setIdMau(mauSac);
        sanPhamChiTiet.setIdSanPham(sanPham);

        sanPhamChiTiet.setMaSPCT(txt_MaSPCT.getText());
        sanPhamChiTiet.setSoLuong(Integer.parseInt(txt_SoLuongSPCT.getText()));
        sanPhamChiTiet.setMoTa(txA_MoTa.getText());

        Double gia = Double.valueOf(txt_GiaBan.getText());
        sanPhamChiTiet.setGiaBan(BigDecimal.valueOf(gia));
        sanPhamChiTiet.setGiaNiemYet(BigDecimal.valueOf(gia));

        if (cbx_TrTSPCT.getSelectedItem().equals("Con Hang")) {
            sanPhamChiTiet.setTrangThai(0);
        } else {
            sanPhamChiTiet.setTrangThai(1);
        }

        sanPhamChiTiet.setNguoiTao(Auth.user.getHoTenNV());
        return sanPhamChiTiet;
    }

    private boolean validateSP() {
        if (txt_MaGiay.getText().isEmpty() || txt_MaGiay.getText().trim().length() == 0) {
            MsgBox.alert(this, "Vui Long Khong De Trong");
            return true;
        }

        if (txt_TenGiay.getText().isEmpty() || txt_TenGiay.getText().trim().length() == 0) {
            MsgBox.alert(this, "Vui Long Khong De Trong");
            return true;
        }

        if (txt_SoLuongSP.getText().isEmpty() || txt_SoLuongSP.getText().trim().length() == 0) {
            MsgBox.alert(this, "Vui Long Khong De Trong");
            return true;
        }

        if (!isNumeric(txt_SoLuongSP.getText())) {
            MsgBox.alert(this, "Vui Long Nhap So");
            return true;
        }

        if (!checkPositive(txt_SoLuongSP.getText())) {
            MsgBox.alert(this, "Vui Long Nhap Lon Hon 0");
            return true;
        }

        if (cbx_TrTSP.getSelectedIndex() == 0) {
            MsgBox.alert(this, "Vui long nhap du truong du lieu");
            return true;
        }
        return false;
    }

    private boolean validateSPCT() {
        if (txt_MaSPCT.getText().isEmpty() || txt_MaSPCT.getText().trim().length() == 0) {
            MsgBox.alert(this, "Vui Long Khong De Trong");
            return true;
        }

        if (txt_GiaBan.getText().isEmpty() || txt_GiaBan.getText().trim().length() == 0) {
            MsgBox.alert(this, "Vui Long Khong De Trong");
            return true;
        }

        if (txt_SoLuongSPCT.getText().isEmpty() || txt_SoLuongSPCT.getText().trim().length() == 0) {
            MsgBox.alert(this, "Vui Long Khong De Trong");
            return true;
        }

        if (txA_MoTa.getText().isEmpty() || txA_MoTa.getText().trim().length() == 0) {
            MsgBox.alert(this, "Vui Long Khong De Trong");
            return true;
        }

        if (!isNumeric(txt_GiaBan.getText())) {
            MsgBox.alert(this, "Vui Long Nhap So");
            return true;
        }

        if (!isNumeric(txt_SoLuongSPCT.getText())) {
            MsgBox.alert(this, "Vui Long Nhap So");
            return true;
        }

        if (!checkPositive(txt_GiaBan.getText())) {
            MsgBox.alert(this, "Vui Long Nhap Lon Hon 0");
            return true;
        }

        if (!checkPositive(txt_SoLuongSPCT.getText())) {
            MsgBox.alert(this, "Vui Long Nhap Lon Hon 0");
            return true;
        }

        if (cbx_MauSPCT.getSelectedIndex() == 0) {
            MsgBox.alert(this, "Vui long nhap du truong du lieu");
            return true;
        }

        if (cbx_THSPCT.getSelectedIndex() == 0) {
            MsgBox.alert(this, "Vui long nhap du truong du lieu");
            return true;
        }

        if (cbx_CLSPCT.getSelectedIndex() == 0) {
            MsgBox.alert(this, "Vui long nhap du truong du lieu");
            return true;
        }

        if (cbx_SizeSCPT.getSelectedIndex() == 0) {
            MsgBox.alert(this, "Vui long nhap du truong du lieu");
            return true;
        }

        if (cbx_TrTSPCT.getSelectedIndex() == 0) {
            MsgBox.alert(this, "Vui long nhap du truong du lieu");
            return true;
        }

        return false;
    }

    private boolean isNumeric(String s) {
        try {
            Integer.valueOf(s);
            return true;
        } catch (NumberFormatException e1) {
            try {
                Double.valueOf(s);
                return true;
            } catch (NumberFormatException e2) {
                return false;
            }
        }
    }

    private boolean checkPositive(String s) {
        try {
            double number = Double.parseDouble(s);
            return number > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean checkTongSLSPCT_T(int sl) {
        int totalSP = 0;
        int totalSPCT = 0;

        for (SanPham sp : sanPhamService.findAllSPByID(listSP.get(indexSP).getIdSanPham())) {
            totalSP += sp.getSoLuong();
        }

        for (SanPhamChiTiet spct : listSPCT) {
            if (spct != null) {
                totalSPCT += spct.getSoLuong();
            }
        }

        if (totalSP < totalSPCT + sl) {
            MsgBox.alert(this, "Ban Da Nhap Qua Trong So Luong Sp");
            return true;
        } else if (totalSP == totalSPCT + sl) {
            return false;
        }
        return false;
    }

    private boolean checkTongSLSPCT_U(int sl) {
        int totalSP = 0;
        int totalSPCT = 0;

        for (SanPham sp : sanPhamService.findAllSPByID(listSP.get(indexSP).getIdSanPham())) {
            totalSP += sp.getSoLuong();
        }

        for (SanPhamChiTiet spct : listSPCT) {
            if (spct != null) {
                totalSPCT += spct.getSoLuong();
            }
        }

        if (sl <= listSPCT.get(indexSPCT).getSoLuong()) {
            System.out.println(sl < listSPCT.get(indexSPCT).getSoLuong());
            return false;
        }

        if (sl > listSPCT.get(indexSPCT).getSoLuong()) {
            if (totalSP < totalSPCT + (sl - listSPCT.get(indexSPCT).getSoLuong())) {
                MsgBox.alert(this, "Ban Da Nhap Qua Trong So Luong Sp");
                return true;

            } else if (totalSP == totalSPCT + (sl - listSPCT.get(indexSPCT).getSoLuong())) {
                return false;
            }

        }
        return false;
    }

    private boolean checkDuplicateSP() {
        if (checkDuplicate(txt_MaGiay.getText(), listSP, (sanpham) -> sanpham.getMaSanPham())) {
            MsgBox.alert(this, "Trùng mã sản phẩm");
            return true;
        }

        if (checkDuplicate(txt_TenGiay.getText(), listSP, (sanpham) -> sanpham.getTenSanpham())) {
            MsgBox.alert(this, "Trùng tên sản phẩm");
            return true;
        }

        return false;
    }

    private boolean checkDuplicateSPCT() {
        if (checkDuplicate(txt_MaSPCT.getText(), listSPCT, (spct) -> spct.getMaSPCT())) {
            MsgBox.alert(this, "Trùng Mã CTSP");
            return true;
        }

//        String mau = (String) cbx_MauSPCT.getSelectedItem();
//        String thuonghieu = (String) cbx_THSPCT.getSelectedItem();
//        String chatlieu = (String) cbx_CLSPCT.getSelectedItem();
//        String size = (String) cbx_SizeSCPT.getSelectedItem();
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
