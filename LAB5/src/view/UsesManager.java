/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.awt.Color;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.CheckData;
import model.Student;
import model.StudentDataAccessObject;

/**
 *
 * @author truong
 */
public class UsesManager extends javax.swing.JFrame {

    StudentDataAccessObject DAO = new StudentDataAccessObject();
    Student sv;
    List<Student> list = new ArrayList<>();
    CheckData data = new CheckData();
    int current = 0;

    /**
     * Creates new form UsesManager
     */
    public UsesManager() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        ConnectToDatabase();
        showDisplay(current);

    }

    private void showDisplay(int i) {
        sv = list.get(i);
        txtCodeStudent.setText(sv.getCodeStudent());
        txtName.setText(sv.getFullName());
        txtEmail.setText(sv.getEmail());
        txtPhone.setText(sv.getPhone());
        txtAddress.setText(sv.getAddress());
        if (sv.isGender()) {
            rdoMale.setSelected(true);
        } else {
            rdoFemale.setSelected(true);
        }
    }

    private void ConnectToDatabase() {
        list.clear();
        String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=QLSINHVIEN;encrypt=true;trustServerCertificate=true";
        String user = "sa";
        String pass = "12345";
        String query = "select * from students";
        try ( Connection conn = DriverManager.getConnection(dbURL, user, pass)) {
            if (conn != null) {
                Statement st = conn.createStatement();
                ResultSet re = st.executeQuery(query);

                while (re.next()) {
                    String code = re.getString(1);
                    String name = re.getString(2);
                    String email = re.getString(3);
                    String phone = re.getString(4);
                    boolean gender = re.getBoolean(5);
                    String address = re.getString(6);
                    sv = new Student(code, name, email, phone, gender, address);
                    list.add(sv);
                }
                conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public boolean Gender() {
        if (rdoMale.isSelected()) {
            return true;
        }
        return false;
    }

    private boolean checkValiDate(JTextField a) {
        if (a.getText().isEmpty()) {
            a.setBackground(Color.YELLOW);
            return false;
        } else {
            a.setBackground(Color.white);
        }
        return true;

    }

    public boolean checkForm() {

        // check code
        if (!checkValiDate(txtCodeStudent)) {
            JOptionPane.showMessageDialog(this, "Code Students not is empty");
            return false;
        } else if (!data.checkMaSv(txtCodeStudent.getText())) {
            JOptionPane.showMessageDialog(this, "Code Student wrong format!");
            txtCodeStudent.setBackground(Color.yellow);
            return false;
        } else {
            txtCodeStudent.setBackground(Color.white);
        }
        // check name
        if (!checkValiDate(txtName)) {
            JOptionPane.showMessageDialog(this, "Name not is empty");
            return false;
        } else if (!data.checkName(txtName.getText())) {
            JOptionPane.showMessageDialog(this, "Name Length longer than 20 charactor!");
            txtName.setBackground(Color.yellow);
            return false;
        } else {
            txtName.setBackground(Color.white);
        }
        // check email
        if (!checkValiDate(txtEmail)) {
            JOptionPane.showMessageDialog(this, "Email not is empty");
            return false;
        } else if (!data.checkEmail(txtEmail.getText())) {
            JOptionPane.showMessageDialog(this, "Email wrong format!");
            txtEmail.setBackground(Color.yellow);
            return false;
        } else {
            txtEmail.setBackground(Color.white);
        }
        //check phone
        if (!checkValiDate(txtPhone)) {
            JOptionPane.showMessageDialog(this, "Number phone not is empty");
            return false;
        } else if (!data.checkNumberPhone(txtPhone.getText())) {
            JOptionPane.showMessageDialog(this, "Number phone wrong format!");
            txtPhone.setBackground(Color.yellow);
            return false;
        } else {
            txtPhone.setBackground(Color.white);
        }
        //check addres
        if (txtAddress.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Address not is empty");
            txtAddress.setBackground(Color.yellow);
            return false;
        } else if (txtAddress.getText().length() < 10) {
            JOptionPane.showMessageDialog(this, "Address Length longer than 10 charactor");
            txtAddress.setBackground(Color.yellow);
            return false;
        } else {
            txtAddress.setBackground(Color.white);
        }

        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblCode = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblemail = new javax.swing.JLabel();
        labPhone = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        txtCodeStudent = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btnSearch = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        rdoMale = new javax.swing.JRadioButton();
        rdoFemale = new javax.swing.JRadioButton();
        lblAddress = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        jPanel2 = new javax.swing.JPanel();
        btnLast = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        btnFirst = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 255));
        jLabel1.setText("Users Manager");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/fpoly2.png"))); // NOI18N

        lblCode.setText("Code Student :");

        lblName.setText("Full Name :");

        lblemail.setText("Email :");

        labPhone.setText("Number Phone :");

        lblGender.setText("Gender :");

        txtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPhoneActionPerformed(evt);
            }
        });

        jPanel1.setLayout(new java.awt.GridLayout(5, 1, 5, 15));

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search-icon.png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel1.add(btnSearch);

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/newicon.png"))); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanel1.add(btnAdd);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/exit-Close-icon.png"))); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete);

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Text-Edit-icon.png"))); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        jPanel1.add(btnUpdate);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Save-icon.png"))); // NOI18N
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel1.add(btnSave);

        buttonGroup1.add(rdoMale);
        rdoMale.setSelected(true);
        rdoMale.setText("Male");

        buttonGroup1.add(rdoFemale);
        rdoFemale.setText("Female");

        lblAddress.setText("Address : ");

        txtAddress.setColumns(20);
        txtAddress.setRows(5);
        jScrollPane1.setViewportView(txtAddress);

        btnLast.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Back-icon.png"))); // NOI18N
        btnLast.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLastActionPerformed(evt);
            }
        });
        jPanel2.add(btnLast);

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/back-icon (1).png"))); // NOI18N
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        jPanel2.add(btnBack);

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/forward-icon (1).png"))); // NOI18N
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        btnNext.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnNextKeyPressed(evt);
            }
        });
        jPanel2.add(btnNext);

        btnFirst.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Next-icon.png"))); // NOI18N
        btnFirst.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFirstActionPerformed(evt);
            }
        });
        jPanel2.add(btnFirst);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(215, 215, 215)
                            .addComponent(jLabel1))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(52, 52, 52)
                                    .addComponent(labPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblemail, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblName, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtName)
                                .addComponent(txtEmail)
                                .addComponent(txtPhone))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblCode, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(lblGender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdoMale, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdoFemale, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(47, 47, 47))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txtCodeStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblCode)
                            .addComponent(txtCodeStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblName)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblemail)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labPhone)
                            .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblGender)
                            .addComponent(rdoMale)
                            .addComponent(rdoFemale)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAddress))
                .addGap(54, 54, 54)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPhoneActionPerformed

    private void btnNextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnNextKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNextKeyPressed

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFirstActionPerformed

        showDisplay(0);
    }//GEN-LAST:event_btnFirstActionPerformed

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        current++;
        if (current > list.size() - 1) {
            current = 0;
        }
        showDisplay(current);
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        current--;
        if (current < 0) {
            current = list.size() - 1;
        }
        showDisplay(current);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLastActionPerformed
        showDisplay(list.size() - 1);
    }//GEN-LAST:event_btnLastActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        txtCodeStudent.setText("");
        txtName.setText("");
        txtPhone.setText("");
        txtEmail.setText("");
        txtAddress.setText("");
        rdoMale.setSelected(true);
        txtCodeStudent.setBackground(Color.white);
        txtName.setBackground(Color.white);
        txtPhone.setBackground(Color.white);
        txtEmail.setBackground(Color.white);
        txtAddress.setBackground(Color.white);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed

        if (!checkValiDate(txtCodeStudent)) {
            JOptionPane.showMessageDialog(this, "Please Enter CodeStudent is not empty");
            return;
        } else if (!data.checkMaSv(txtCodeStudent.getText())) {
            JOptionPane.showMessageDialog(this, "Code Student wrong format!");
            txtCodeStudent.setBackground(Color.yellow);
            return;
        }
        try {
            sv = DAO.FindStudent(txtCodeStudent.getText());
            if (sv != null) {
                txtCodeStudent.setText(sv.getCodeStudent());
                txtName.setText(sv.getFullName());
                txtEmail.setText(sv.getEmail());
                txtPhone.setText(sv.getPhone());
                txtAddress.setText(sv.getAddress());
                if (sv.isGender()) {
                    rdoMale.setSelected(true);
                } else {
                    rdoFemale.setSelected(true);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Student not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        try {
            if (checkForm()) {
                int choose = JOptionPane.showConfirmDialog(this, "Do you want to save student", "Notify", JOptionPane.YES_NO_OPTION);
                if (choose == JOptionPane.YES_OPTION) {
                    sv = new Student();
                    sv.setCodeStudent(txtCodeStudent.getText());
                    sv.setFullName(txtName.getText());
                    sv.setEmail(txtEmail.getText());
                    sv.setPhone(txtPhone.getText());
                    sv.setGender(Gender());
                    sv.setAddress(txtAddress.getText());
                    DAO.InsertStudent(sv);
                    JOptionPane.showMessageDialog(this, "Save student to SQL Server successfull");
                    btnAddActionPerformed(evt);
                    ConnectToDatabase();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Student ID can't be duplicated");
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        try {
            if (checkForm()) {
                if (DAO.FindStudent(txtAddress.getText()) != null) {
                    int choose = JOptionPane.showConfirmDialog(this, "Do you want to Delete student", "Notify", JOptionPane.YES_NO_OPTION);
                    if (choose == JOptionPane.YES_OPTION) {
                        sv = new Student();
                        sv.setCodeStudent(txtCodeStudent.getText());
                        sv.setFullName(txtName.getText());
                        sv.setEmail(txtEmail.getText());
                        sv.setPhone(txtPhone.getText());
                        sv.setGender(Gender());
                        sv.setAddress(txtAddress.getText());
                        if (DAO.UpdateStudent(sv)) {
                            JOptionPane.showMessageDialog(this, "Update student to SQL Server successfull");
                        } else {
                            JOptionPane.showMessageDialog(this, "Update fail");
                        }
                        btnAddActionPerformed(evt);
                          ConnectToDatabase();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Update fail Id is not exists");
                }
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (!checkValiDate(txtCodeStudent)) {
            JOptionPane.showMessageDialog(this, "Please Enter CodeStudent is not empty");
            return;
        } else if (!data.checkMaSv(txtCodeStudent.getText())) {
            JOptionPane.showMessageDialog(this, "Code Student wrong format!");
            txtCodeStudent.setBackground(Color.yellow);
            return;
        }
        try {
            int choose = JOptionPane.showConfirmDialog(this, "Do you want to Delete student", "Notify", JOptionPane.YES_NO_OPTION);
            if (choose == JOptionPane.YES_OPTION) {
                if (DAO.DeleteStudent(txtCodeStudent.getText())) {
                    JOptionPane.showMessageDialog(this, "Delete  student have Code " + txtCodeStudent.getText() + " to SQL Server successfull");
                    btnAddActionPerformed(evt);
                      ConnectToDatabase();
                } else {
                    JOptionPane.showMessageDialog(this, "ID Student is not Exists");
                }
            }
        } catch (Exception e) {

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
            java.util.logging.Logger.getLogger(UsesManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsesManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsesManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsesManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsesManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnFirst;
    private javax.swing.JButton btnLast;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labPhone;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblCode;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblemail;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtCodeStudent;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}
