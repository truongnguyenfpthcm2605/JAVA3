/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package bai2;

import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.Hashtable;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author truong
 */
public class bai2 extends javax.swing.JFrame {

    DefaultTableModel model;
    DefaultComboBoxModel standard, fees;
    ConnectToSQL sql = new ConnectToSQL();
    int location = -1;

    /**
     * Creates new form bai2
     */
    public bai2() {
        initComponents();
        initColumnTable();
        this.setLocationRelativeTo(null);
        initCombobox();
        initTable();
    }
    

    private void initColumnTable() {
        model = (DefaultTableModel) tblList.getModel();
        String[] column = {"Name", "Standard"};
        model.setColumnIdentifiers(column);
        

    }

    public void initCombobox() {
        try {
            String query = "select stand,fees from standards";
            try (Connection com = sql.Connect(); PreparedStatement pmst = com.prepareStatement(query); 
                    ResultSet rs = pmst.executeQuery()) {
                cboStandard.removeAll();
                cboFees.removeAll();
                while (rs.next()) {
                    cboStandard.addItem(rs.getString(1));
                    cboFees.addItem(String.valueOf(rs.getFloat(2)));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initTable() {
        try {
            DefaultTableModel model = (DefaultTableModel) tblList.getModel();
            String query = "select name,standards.stand from students join standards on students.stand = standards.stand";
            Connection com = sql.Connect();
            PreparedStatement pmst = com.prepareStatement(query);
            ResultSet rs = pmst.executeQuery();
            model.setRowCount(0);
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString(1), rs.getString(2)});

            }
            model.fireTableDataChanged();
        } catch (Exception e) {
        }
    }

    private void showForm(int a) {
        try {
            Student sv = sql.getStudent(tblList.getValueAt(a, 0).toString());

            if (sv != null) {
                txtName.setText(sv.getName());
                txtArea.setText(sv.getAddress());
                txtParent.setText(sv.getParenName());
                txtContact.setText(sv.getPhone());
                cboStandard.setSelectedItem(sv.getStand());
                cboFees.setSelectedItem(String.valueOf(sv.getFees()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void resetForm() {
        txtName.setText("");
        txtContact.setText("");
        txtArea.setText("");
        txtParent.setText("");
        cboFees.setSelectedIndex(0);
        cboStandard.setSelectedIndex(0);
    }

    public boolean LocationHere() {
        location = tblList.getSelectedRow();
        if (location == -1) {
            return false;
        }
        return true;

    }

    public boolean checkValidate(JTextField text) {
        if (text.getText().isEmpty()) {
            text.setBackground(Color.yellow);
            return false;
        } else {
            text.setBackground(Color.white);
        }
        return true;
    }

    public boolean checkForm() {
        if (!checkValidate(txtName)) {
            JOptionPane.showMessageDialog(this, "Please input name, Name is not empty");
            return false;
        }
        if (txtArea.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please input address, Address is not empty");
            txtArea.setBackground(Color.yellow);
            return false;
        } else {
            txtArea.setBackground(Color.white);
        }

        if (!checkValidate(txtParent)) {
            JOptionPane.showMessageDialog(this, "Please input parent Name, Parent Name is not empty");
            return false;
        } else if (!checkValidate(txtContact)) {
            JOptionPane.showMessageDialog(this, "Please input contact ,Contact is not empty");
            return false;
        } else if (!sql.checkNumberPhone(txtContact.getText())) {
            JOptionPane.showMessageDialog(this, "Contact Number ==10 and is Number");
            return false;
        }
        return true;
    }

    public int MessageComfirm(String ax) {
        int a = JOptionPane.showConfirmDialog(this, ax, "Notify", JOptionPane.YES_NO_OPTION);
        return a;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblList = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        txtParent = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtContact = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cboStandard = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cboFees = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnNew = new javax.swing.JButton();
        btnInsert = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnPre = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblList);

        jLabel1.setText("Name : ");

        txtName.setEnabled(false);

        jLabel2.setText("Address :");

        txtArea.setColumns(20);
        txtArea.setRows(5);
        txtArea.setEnabled(false);
        jScrollPane2.setViewportView(txtArea);

        jLabel3.setText("Parent Name :");

        txtParent.setEnabled(false);

        jLabel4.setText("ContactNo:");

        txtContact.setEnabled(false);

        jLabel5.setText("Standard :");

        jLabel6.setText("Fees :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtName)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(txtParent)
                    .addComponent(txtContact)
                    .addComponent(cboStandard, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cboFees, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtParent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboStandard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboFees, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jPanel2.setLayout(new java.awt.GridLayout(2, 4, 10, 5));

        btnNew.setText("Print");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jPanel2.add(btnNew);

        btnInsert.setText("Insert");
        btnInsert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertActionPerformed(evt);
            }
        });
        jPanel2.add(btnInsert);

        btnedit.setText("Edit");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });
        jPanel2.add(btnedit);

        btnUpdate.setText("Update");
        btnUpdate.setEnabled(false);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel2.add(btnUpdate);

        btnNext.setText("Next");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        jPanel2.add(btnNext);

        btnPre.setText("Pre");
        btnPre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreActionPerformed(evt);
            }
        });
        jPanel2.add(btnPre);

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel2.add(btnDelete);

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel2.add(btnExit);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 373, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
      //  resetForm();
        try {
            Hashtable map = new Hashtable();
            map.put("names",txtName.getText() );
            map.put("ok", "Nguyen");
            JasperReport jsp =  JasperCompileManager.compileReport("src\\bai2\\printStudnet.jrxml");
            Connection com = sql.Connect();
            JasperPrint print  = JasperFillManager.fillReport(jsp, map, com);
            JasperViewer.viewReport(print, false);
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnNewActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        location = tblList.getSelectedRow();
        if (location < 0) {
            return;
        } else {
            location++;
            if (location > tblList.getRowCount() - 1) {
                location = 0;
            }
            tblList.setRowSelectionInterval(location, location);
            showForm(location);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnPreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreActionPerformed
        location = tblList.getSelectedRow();
        if (location < 0) {
            return;
        } else {
            location--;
            if (location < 0) {
                location = tblList.getRowCount() - 1;
            }
            tblList.setRowSelectionInterval(location, location);
            showForm(location);
            
        }
    }//GEN-LAST:event_btnPreActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        txtName.setEnabled(true);
        txtContact.setEnabled(true);
        txtArea.setEnabled(true);
        txtParent.setEnabled(true);
        cboFees.setEditable(true);
        cboStandard.setEnabled(true);
        btnUpdate.setEnabled(true);
    }//GEN-LAST:event_btneditActionPerformed

    private void tblListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListMouseClicked
        location = tblList.getSelectedRow();
        if (location == -1) {
            return;
        } else {
            showForm(location);
        }
    }//GEN-LAST:event_tblListMouseClicked

    private void btnInsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertActionPerformed
        try {
            if (checkForm()) {         
                if (MessageComfirm("Do you wamt to insert") == JOptionPane.YES_OPTION) {
                    Student sv = new Student();
                    sv.setName(txtName.getText());
                    sv.setAddress(txtArea.getText());
                    sv.setParenName(txtParent.getText());
                    sv.setPhone(txtContact.getText());
                    String stand = cboStandard.getSelectedItem().toString();
                    if (sql.addStudent(sv, stand)) {
                        JOptionPane.showMessageDialog(this, "Insert Student SuccessFull");
                        initTable();
                        resetForm();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnInsertActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            if (LocationHere()) {
                if (checkForm()) {
                    if (MessageComfirm("Do you wamt to Update this object") == JOptionPane.YES_OPTION) {
                        Student sv = new Student();
                        sv.setName(txtName.getText());
                        sv.setAddress(txtArea.getText());
                        sv.setParenName(txtParent.getText());
                        sv.setPhone(txtContact.getText());
                        String stand = cboStandard.getSelectedItem().toString();
                        String name = tblList.getValueAt(location, 0).toString();
                        if (sql.Update(sv, stand, name)) {
                            JOptionPane.showMessageDialog(this, "Update successFull");
                            resetForm();
                            initTable();
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select object to Update");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (LocationHere()) {
            try {
                if (MessageComfirm("Do you want to delete ?") == JOptionPane.YES_OPTION) {
                    if (sql.Delete(String.valueOf(tblList.getValueAt(location, 0)))) {
                        JOptionPane.showMessageDialog(this, "Delete succesfull");
                        initTable();
                        resetForm();
                    }
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "DeleteFail");
                ex.printStackTrace();
            }

        } else {
            JOptionPane.showMessageDialog(this, "Please select row you want to delete");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

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
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnInsert;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnPre;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnedit;
    private javax.swing.JComboBox<String> cboFees;
    private javax.swing.JComboBox<String> cboStandard;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblList;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtParent;
    // End of variables declaration//GEN-END:variables
}
