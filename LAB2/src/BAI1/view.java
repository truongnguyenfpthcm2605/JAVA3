/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BAI1;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author truong
 */
public class view extends JFrame implements ActionListener {

    public JLabel label_name, label_Address, label_sex, label_Qualiflcation, label_Hobby;
    public JTextField txtName;
    public JTextArea txtArea;
    public JRadioButton rdoMale, rdoFemale;
    public ButtonGroup butGender;
    public JComboBox<String> cboList;
    public JPanel panelCheckBox;
    public JButton Validate, Reset;
    public JCheckBox checkRead, checkSing, checkDan;

    public view(String title) throws HeadlessException {
        super(title);
        init();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void init() {
        int width = 700;
        int height = 400;
        int label_width = 80;
        int label_height = 20;
        this.setSize(width, height);
        this.setLayout(null);
        Font font = new Font("Arial", Font.BOLD, 15);

        // Name 
        label_name = new JLabel("Name : ");
        label_name.setFont(font);
        label_name.setBounds(10, 10, label_width, label_height);
        this.add(label_name);
        // Iuput Name
        txtName = new JTextField();
        txtName.setFont(font);
        txtName.setBounds(label_name.getX() + label_width + 20, 10, 250, 30);
        this.add(txtName);

        // Address
        label_Address = new JLabel("Address :");
        label_Address.setFont(font);
        label_Address.setBounds(10, label_height + 40, label_width, label_height);
        this.add(label_Address);
        // Area
        txtArea = new JTextArea(100, 100);
        txtArea.setFont(font);
        txtArea.setBounds(label_Address.getX() + label_width + 20, txtName.getHeight() + 35, 250, 100);
        this.add(txtArea);

        // sex 
        label_sex = new JLabel("Sex :");
        label_sex.setFont(font);
        label_sex.setBounds(10, txtArea.getHeight() + txtArea.getY() + 20, label_width, label_height);
        this.add(label_sex);
        // Gender
        butGender = new ButtonGroup();
        rdoMale = new JRadioButton("Male");
        rdoMale.setSelected(true);
        rdoMale.setBounds(label_sex.getWidth() + label_sex.getX() + 20, txtArea.getHeight() + txtArea.getY() + 20, label_width, 20);
        rdoFemale = new JRadioButton("FeMale");
        rdoFemale.setBounds(label_sex.getWidth() + label_sex.getX() + 20, rdoMale.getHeight() + rdoMale.getY() + 10, label_width, 20);
        butGender.add(rdoMale);
        rdoMale.setFont(font);
        butGender.add(rdoFemale);
        rdoFemale.setFont(font);
        this.add(rdoMale);
        this.add(rdoFemale);

        //Qualification 
        label_Qualiflcation = new JLabel("Qualification :");
        label_Qualiflcation.setFont(font);
        label_Qualiflcation.setBounds(txtName.getWidth() + 150, 10, label_width + 40, label_height);
        this.add(label_Qualiflcation);
        // Combobox

        String[] option = new String[]{"Qualification", " Gaduate"};
        cboList = new JComboBox<>(option);

//        cboList.addItem("Qualification");
//        cboList.addItem("Gaduate");
        cboList.setBounds(label_Qualiflcation.getX() + label_Qualiflcation.getWidth() + 20, 10, label_Qualiflcation.getWidth(), label_height);
        this.add(cboList);

        // hobby
        label_Hobby = new JLabel("Hobby :");
        label_Hobby.setFont(font);
        label_Hobby.setBounds(label_Qualiflcation.getX(), label_Qualiflcation.getHeight() + 40, label_width, label_height);
        this.add(label_Hobby);
        // checkbox
        panelCheckBox = new JPanel();
        panelCheckBox.setLayout(new GridLayout(3, 1));
        checkRead = new JCheckBox("Reading");
        checkSing = new JCheckBox("Singing");
        checkDan = new JCheckBox("Dancing");
        panelCheckBox.add(checkRead);
        panelCheckBox.add(checkSing);
        panelCheckBox.add(checkDan);
        panelCheckBox.setBounds(label_Hobby.getX() + label_Hobby.getWidth() + 40, label_Qualiflcation.getHeight() + 40, label_Qualiflcation.getWidth(), 100);
        this.add(panelCheckBox);

        //validate
        Validate = new JButton("Validate");
        Validate.setFont(font);
        Validate.setBounds(220, 300, label_width + 20, label_height + 10);
        Validate.setBackground(Color.green);
        Validate.addActionListener(this);
        this.add(Validate);

        // reset 
        Reset = new JButton("Reset");
        Reset.setFont(font);
        Reset.setBounds(350, 300, label_width + 20, label_height + 10);
        Reset.setBackground(Color.red);
        Reset.addActionListener(this);
        this.add(Reset);
       
    }

    public boolean checkEmpty() {
        if (txtName.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Name can't be Blank ,Please Enter Name! \n");
            txtName.setBackground(Color.yellow);
            return false;
        } else {
            txtName.setBackground(Color.white);
        }
        if (txtArea.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Address can't be Blank ,Please Enter Name!");
            txtArea.setBackground(Color.yellow);
            return false;
        } else {
            txtArea.setBackground(Color.white);

        }
        return true;
    }

    public void checkValiDate() {
        StringBuilder str = new StringBuilder();
        str.append("");

        if (checkEmpty()) {
            str.append("Name :  ").append(txtName.getText()).append("\n");
            str.append("Address :  ").append(txtArea.getText()).append("\n");
            if (rdoMale.isSelected()) {
                str.append("Gender:  Male  \n");
            } else if (rdoFemale.isSelected()) {
                str.append("Gender:  FeMale  \n");
            }

            str.append("Qualification :  ").append(cboList.getSelectedItem()).append("\n");
            if (checkRead.isSelected() == false && checkSing.isSelected() == false && checkDan.isSelected() == false) {
                JOptionPane.showMessageDialog(this, "Please chose a hobbie!");
                return;
            } else if (checkRead.isSelected()) {
                str.append("Hobby : Reading \n");
            } else if (checkSing.isSelected()) {
                str.append("Hobby : Singing \n");
            } else if (checkDan.isSelected()) {
                str.append("Hobby : Dancing \n");
            }
        }

        if (str.length() > 0) {
            JOptionPane.showMessageDialog(this, str);
            JOptionPane.showMessageDialog(this, "Successfully");
        }
    }

    public void ResetForm() {
        txtName.setText("");
        txtArea.setText("");
        txtName.setBackground(Color.white);
        txtArea.setBackground(Color.white);
        checkRead.setSelected(false);
        checkSing.setSelected(false);
        checkDan.setSelected(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(Validate.getText())) {
            checkValiDate();
        } else {
            ResetForm();
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            new view("Bai1").setVisible(true);
        } catch (Exception e) {
        }
    }

}
