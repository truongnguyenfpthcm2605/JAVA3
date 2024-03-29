/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package lab4;

import java.awt.Color;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author truong
 */
public class bai2 extends javax.swing.JFrame {

    DefaultTableModel modelProducts;
    DefaultComboBoxModel<String> modelCombo;

    /**
     *
     */
    public bai2() {
        initComponents();
        setLocationRelativeTo(null);

        initDataTable();
        initComboBox();
    }

    private boolean checkEmpty(JTextField a) {
        if (a.getText().isEmpty()) {
            a.setBackground(Color.yellow);
            a.requestFocus();
            return false;
        } else {
            a.setBackground(Color.white);
            
        }
        return true;
    }

    private boolean checkPrice() {
        try {
            double a = Double.parseDouble(txtDonGia.getText());
            if (a < 0) {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Don gia is Number");
            return false;
        }
        return true;
    }

    private String checkForm() {
        StringBuilder str = new StringBuilder();
        str.append("");
        if (!checkEmpty(txtmaSp)) {
            str.append(lblmasp.getText()).append(" not Empty \n");
        } else if (!checkEmpty(txtNameSp)) {
            str.append(lbltensp.getText()).append(" not Empty \n");
        } else if (!checkEmpty(txtDonGia)) {
            str.append(lblDonGia.getText()).append(" not Empty \n");
        } else if (!checkPrice()) {
            str.append("Don gia lon hon 0 \n");
        } else if (!checkEmpty(txtNCC)) {
            str.append(lblNCC.getText()).append(" not Empty \n");
        }
        if (str.length() > 0) {
            JOptionPane.showMessageDialog(this, str);
        }
        return str.toString();
    }

    private void initDataTable() {
        String[] header = {"Ma Sp", "Ten Sp", "DVT", "Don gia ban", "Nha cung cap"};
        String[][] data = {
            {"SP01", "Dau goi Head & Shoulder", "Chai", "34000", "Unilevers"},
            {"SP02",
                "Xa bong Omo", "Thung", "124000", "Unilevers"},
            {"SP03",
                "Dau an Truong An 5 li", "Chai", "100000", "Truong An"},
            {"SP04",
                "Mi an lien Hao Hao", "Thung", "75000", "Acebook"},
            {"SP05",
                "Duong tinh luyen", "kg", "14000", "Duong Bien Hoa"},
            {"SP06",
                "Sua Ong Tho", "Lon", "13000", "VinaMilk"},};
        modelProducts = new DefaultTableModel(data, header);
        tblProDuct.setModel(modelProducts);
    }

    public void initComboBox() {
        modelCombo = new DefaultComboBoxModel<>();
        String[] data = {"Thung", "Chai", "kg", "Lon"};
        for (String string : data) {
            modelCombo.addElement(string);
        }
        cboDVT.setModel(modelCombo);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProDuct = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        lblmasp = new javax.swing.JLabel();
        lbltensp = new javax.swing.JLabel();
        lblDVT = new javax.swing.JLabel();
        txtmaSp = new javax.swing.JTextField();
        txtNameSp = new javax.swing.JTextField();
        cboDVT = new javax.swing.JComboBox<>();
        lblDonGia = new javax.swing.JLabel();
        lblNCC = new javax.swing.JLabel();
        txtDonGia = new javax.swing.JTextField();
        txtNCC = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnAddSp = new javax.swing.JButton();
        btnDeleteSp = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "List ProDucts", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        tblProDuct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "null", "null", "null", "null"
            }
        ));
        tblProDuct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProDuctMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProDuct);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 51));

        lblmasp.setText("Ma San Pham :");

        lbltensp.setText("Ten San Pham :");

        lblDVT.setText("Don Vi Tinh :");

        lblDonGia.setText("Don Gia :");

        lblNCC.setText("Nha Cung Cap :");

        txtNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNCCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(lbltensp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                    .addComponent(lblmasp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblDVT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNameSp, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtmaSp, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(lblNCC)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNCC))))
                    .addComponent(cboDVT, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblmasp)
                    .addComponent(txtmaSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDonGia)
                    .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbltensp)
                    .addComponent(txtNameSp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNCC)
                    .addComponent(txtNCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDVT)
                    .addComponent(cboDVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(51, 255, 51));

        btnAddSp.setText("Them San Pham");
        btnAddSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddSpActionPerformed(evt);
            }
        });
        jPanel3.add(btnAddSp);

        btnDeleteSp.setText("Xoa San Pham");
        btnDeleteSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteSpActionPerformed(evt);
            }
        });
        jPanel3.add(btnDeleteSp);

        btnEdit.setText("Dieu Chinh ThongTin");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel3.add(btnEdit);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNCCActionPerformed

    private void tblProDuctMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProDuctMouseClicked
        int row = tblProDuct.getSelectedRow();
        if (row < 0) {
            return;
        }
        txtmaSp.setText(tblProDuct.getValueAt(row, 0).toString());
        txtNameSp.setText(tblProDuct.getValueAt(row, 1).toString());
        cboDVT.setSelectedItem(tblProDuct.getValueAt(row, 2));
        txtDonGia.setText(tblProDuct.getValueAt(row, 3).toString());
        txtNCC.setText(tblProDuct.getValueAt(row, 4).toString());
    }//GEN-LAST:event_tblProDuctMouseClicked

    private void btnAddSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddSpActionPerformed
        if (checkForm().length() > 0) {
            JOptionPane.showMessageDialog(this, "Fail");
            return;

        } else {
            Vector dataRow = new Vector();
            dataRow.add(txtmaSp.getText().trim());
            dataRow.add(txtNameSp.getText().trim());
            dataRow.add(cboDVT.getSelectedItem());
            dataRow.add(txtDonGia.getText().trim());
            dataRow.add(txtNCC.getText().trim());
            modelProducts.addRow(dataRow);
            JOptionPane.showMessageDialog(this, "Successfull");
        }

    }//GEN-LAST:event_btnAddSpActionPerformed

    private void btnDeleteSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteSpActionPerformed
        int row = tblProDuct.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Please Choose Delete!");
        } else {
            int a = JOptionPane.showConfirmDialog(this, "Bạn có chắt muốn xóa không!", "Xóa Nhân viên", JOptionPane.YES_NO_OPTION);
            if (a == JOptionPane.YES_OPTION) {
                int[] index = tblProDuct.getSelectedRows(); // vi tri nhan la 1 mang gia tri
                for (int i = 0; i <= index.length - 1; i++) {
                    modelProducts.removeRow(index[0]);
                }
            }
            JOptionPane.showMessageDialog(this, "Delete Successfull");
        }
    }//GEN-LAST:event_btnDeleteSpActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int row = tblProDuct.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Chua chon doi tuong de sua");
            return;
        }
   
        modelProducts.setValueAt(txtNameSp.getText().trim(), row, 1);
        modelProducts.setValueAt(cboDVT.getSelectedItem(), row, 2);
        modelProducts.setValueAt(txtDonGia.getText().trim(), row, 3);
        modelProducts.setValueAt(txtNCC.getText().trim(), row, 4);
    }//GEN-LAST:event_btnEditActionPerformed

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
            java.util.logging.Logger.getLogger(bai2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bai2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bai2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bai2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bai2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddSp;
    private javax.swing.JButton btnDeleteSp;
    private javax.swing.JButton btnEdit;
    private javax.swing.JComboBox<String> cboDVT;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDVT;
    private javax.swing.JLabel lblDonGia;
    private javax.swing.JLabel lblNCC;
    private javax.swing.JLabel lblmasp;
    private javax.swing.JLabel lbltensp;
    private javax.swing.JTable tblProDuct;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtNCC;
    private javax.swing.JTextField txtNameSp;
    private javax.swing.JTextField txtmaSp;
    // End of variables declaration//GEN-END:variables
}
