/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edusys;

import DAO.ChuyenDeDAO;
import DAO.HocVienDAO;
import DAO.KhoaHocDAO;
import DAO.NguoiHocDAO;
import Entity.ChuyenDe;
import Entity.HocVien;
import Entity.KhoaHoc;
import Entity.NguoiHoc;
import Helper.Auth;
import Helper.MsgBox;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class QuanLyHocVien extends javax.swing.JDialog {

    ChuyenDeDAO cddao = new ChuyenDeDAO();
    KhoaHocDAO khdao = new KhoaHocDAO();
    HocVienDAO hvdao = new HocVienDAO();
    NguoiHocDAO nhdao = new NguoiHocDAO();
    int row = -1;

    /**
     * Creates new form QuanLyHocVien
     */
    public QuanLyHocVien(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbbChuyenDe = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        cbbKhoaHoc = new javax.swing.JComboBox<>();
        Tabs = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHocVien = new javax.swing.JTable();
        btnXoaHV = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        tabs = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblNguoiHoc = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        btnThemHV = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("CHUYÊN ĐỀ"));

        cbbChuyenDe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbChuyenDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbChuyenDeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbbChuyenDe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbbChuyenDe, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("KHÓA HỌC"));

        cbbKhoaHoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbKhoaHoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbKhoaHocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbbKhoaHoc, 0, 340, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbbKhoaHoc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        tblHocVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TT", "Mã HV", "Mã NH", "Họ tên", "Điểm"
            }
        ));
        tblHocVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHocVienMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblHocVienMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblHocVien);

        btnXoaHV.setText("Xóa khỏi khóa học");
        btnXoaHV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaHVActionPerformed(evt);
            }
        });

        btnCapNhat.setText("Cập nhật điêm");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 723, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnXoaHV)
                        .addGap(49, 49, 49)
                        .addComponent(btnCapNhat)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCapNhat)
                    .addComponent(btnXoaHV))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        Tabs.addTab("Học viên", jPanel4);

        tblNguoiHoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NH", "Họ tên", "Giới tính", "Ngày sinh", "Điện thoại", "Email"
            }
        ));
        jScrollPane2.setViewportView(tblNguoiHoc);

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Tìm kiếm"));

        btnTimKiem.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2))
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        btnThemHV.setText("Thêm vào khóa học");
        btnThemHV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemHVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout tabsLayout = new javax.swing.GroupLayout(tabs);
        tabs.setLayout(tabsLayout);
        tabsLayout.setHorizontalGroup(
            tabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabsLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnThemHV)))
                .addContainerGap())
        );
        tabsLayout.setVerticalGroup(
            tabsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnThemHV)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        Tabs.addTab("Người học", tabs);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tabs)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Tabs)
                .addContainerGap())
        );

        jPanel1.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbbChuyenDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbChuyenDeActionPerformed
        fillCboKhocHoc();
    }//GEN-LAST:event_cbbChuyenDeActionPerformed

    private void cbbKhoaHocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbKhoaHocActionPerformed
        fillTableHocVien();
    }//GEN-LAST:event_cbbKhoaHocActionPerformed

    private void btnXoaHVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaHVActionPerformed
        deleteHocVien();
    }//GEN-LAST:event_btnXoaHVActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        updateDiem();
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnThemHVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemHVActionPerformed
        addHocVien();
    }//GEN-LAST:event_btnThemHVActionPerformed

    private void tblHocVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHocVienMouseClicked
        
    }//GEN-LAST:event_tblHocVienMouseClicked

    private void tblHocVienMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHocVienMousePressed
        if (evt.getClickCount()==2) {
            double s = Double.parseDouble(MsgBox.prompt(this, "Mời nhập điểm"));
            tblHocVien.setValueAt(s, tblHocVien.getSelectedRow(), 4);
            
        }

    }//GEN-LAST:event_tblHocVienMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLyHocVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyHocVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyHocVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyHocVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QuanLyHocVien dialog = new QuanLyHocVien(new javax.swing.JFrame(), true);
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
    private javax.swing.JTabbedPane Tabs;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnThemHV;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoaHV;
    private javax.swing.JComboBox<String> cbbChuyenDe;
    private javax.swing.JComboBox<String> cbbKhoaHoc;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel tabs;
    private javax.swing.JTable tblHocVien;
    private javax.swing.JTable tblNguoiHoc;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables

    private void init() {
        setLocationRelativeTo(null);
        this.fillCboChuyenDe();
        fillTableHocVien();
        

    }

   

    void fillTableHocVien() {
        DefaultTableModel model = (DefaultTableModel) tblHocVien.getModel();
        model.setRowCount(0);
        try {

            KhoaHoc khoaHoc = (KhoaHoc) cbbKhoaHoc.getSelectedItem();
            if (khoaHoc != null) {
                List<HocVien> list = hvdao.selectByKhoaHoc(khoaHoc.getMaKH());
                for (int i = 0; i < list.size(); i++) {
                    HocVien hv = list.get(i);
                    String hoten = nhdao.selectById(hv.getMaNH()).getHoTen();
                    
                    model.addRow(new Object[]{i + 1, hv.getMaHV(), hv.getMaNH(), hoten, hv.getDiem()});
                }
                this.fillTableNguoiHoc();
            }
        } catch (Exception e) {
            MsgBox.alert(this, "lỗi truy vấn dữ liệu!!!");
            e.printStackTrace();
        }

    }

    void fillTableNguoiHoc() {
        DefaultTableModel model = (DefaultTableModel) tblNguoiHoc.getModel();
        model.setRowCount(0);
        try {
            KhoaHoc khoaHoc = (KhoaHoc) cbbKhoaHoc.getSelectedItem();
            String keyword = txtTimKiem.getText();
            List<NguoiHoc> list = nhdao.selectNotlnCourse(khoaHoc.getMaKH(), keyword);
            for (NguoiHoc nguoiHoc : list) {
                model.addRow(new Object[]{
                    nguoiHoc.getMaNH(),
                    nguoiHoc.getHoTen(),
                    nguoiHoc.getGioiTinh() ? "Nam" : "Nữ",
                    nguoiHoc.getNgaySinh(),
                    nguoiHoc.getDienThoai(),
                    nguoiHoc.getEmail()
                });
            }
        } catch (Exception e) {
            MsgBox.alert(this, "lỗi truy vấn dữ liệu!!!");
            e.printStackTrace();
        }

    }

    void fillCboChuyenDe() {

        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbChuyenDe.getModel();
        model.removeAllElements();
        try {
            List<ChuyenDe> list = cddao.selectAll();
            for (ChuyenDe cd : list) {
                model.addElement(cd);
            }
            fillCboKhocHoc();
        } catch (Exception e) {
            MsgBox.alert(this, "lỗi truy vấn dữ liệu!!!");
            e.printStackTrace();
        }

    }

    void fillCboKhocHoc() {
        DefaultComboBoxModel model = (DefaultComboBoxModel) cbbKhoaHoc.getModel();
        model.removeAllElements();
        try {
            ChuyenDe chuyenDe = (ChuyenDe) cbbChuyenDe.getSelectedItem();
            if (chuyenDe != null) {
                List<KhoaHoc> list = khdao.selectByChuyenDe(chuyenDe.getMaCD());
                for (KhoaHoc kh : list) {
                    model.addElement(kh);
                }

            }
        } catch (Exception e) {
            MsgBox.alert(this, "lỗi truy vấn dữ liệu!!!");
            e.printStackTrace();
        }

    }

    void addHocVien() {
        KhoaHoc khoaHoc = (KhoaHoc) cbbKhoaHoc.getSelectedItem();
        for (int row : tblNguoiHoc.getSelectedRows()) {
            HocVien hv = new HocVien();
            hv.setMaKH(khoaHoc.getMaKH());
            hv.setDiem(0);
            hv.setMaNH((String) tblNguoiHoc.getValueAt(row, 0));
            hvdao.insert(hv);
        }
        this.fillTableHocVien();
        Tabs.setSelectedIndex(0);

    }

    void deleteHocVien() {
        if (!Auth.isManager()) {
            MsgBox.alert(this, "Bạn không có quyền xóa");
        } else {
            if (MsgBox.confirm(this, " Bạn muốn xóa học viên được chọn ?")) {
                for (int row :tblHocVien.getSelectedRows()) {
                    int mahv=(Integer)tblHocVien.getValueAt(row, 1);
                    hvdao.delete(mahv);
                    
                }
                this.fillTableHocVien();
                 
            }
        
        }
    }
   
    void updateDiem(){
       
        for (int i = 0; i < tblHocVien.getRowCount(); i++) {
            int mahv=(Integer)tblHocVien.getValueAt(i, 1);
            HocVien hv = hvdao.selectById(mahv);
            hv.setDiem((Double)tblHocVien.getValueAt(i, 4));
            hvdao.update(hv);
        }
        MsgBox.alert(this, "cập nhập điểm thành công !!");
        
    }



}