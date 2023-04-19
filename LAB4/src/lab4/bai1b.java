/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollBar;

import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import org.w3c.dom.events.MouseEvent;

/**
 *
 * @author truong
 */
public class bai1b extends JFrame implements  MouseListener{

    JMenuBar mMain;
    JMenu mfile, mColor, mSystem;
    JMenuItem open, save, New,About,Exit,item1,item2,item3;
    ImageIcon iconnew,iconopen,iconsave,iconUser,iconExit;
    JRadioButtonMenuItem Red,Green,Blue,TestColor;
    ButtonGroup buttongroup;
    JToolBar tool;
    JButton butNew,butExit ,butAbout;
    JScrollBar scroll;
    JEditorPane edge;
    JTextField label ;
    JPopupMenu popMenu;
    

    public bai1b(String title) throws HeadlessException {
        super(title);
        init();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
    }

    private void init() {
        this.setSize(500, 500);
        this.setLayout(new BorderLayout());
        mMain = new JMenuBar();
        
        // menu file
        mfile = new JMenu("File");
        iconnew = new ImageIcon("./src/Icon/new-file-icon.png");
        New = new JMenuItem("New", iconnew);
        New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F10,InputEvent.CTRL_DOWN_MASK));
        New.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                edge.setText("");
            }
        });
        mfile.add(New);
        // open file
        
        iconopen = new ImageIcon("./src/Icon/open-file-icon.png");
        open = new JMenuItem("Open",iconopen);
        open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser f = new JFileChooser();
               int a =  f.showOpenDialog(null);
               if(a == JFileChooser.APPROVE_OPTION){
                   try {
                       FileReader file = new FileReader(f.getSelectedFile());
                      StringBuilder str = new StringBuilder();
                      int r;
                       while ((r = file.read())!=-1) {                           
                           str.append((char) r);
                       }
                       edge.setText(str.toString());
                   } catch (Exception ez) {
                       ez.printStackTrace();
                   }
               }
                
            }
        });
        mfile.add(open);
        
        // file save\
        iconsave = new ImageIcon("./src/Icon/Save-icon.png");
        save = new JMenuItem("Save", iconsave);
        save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_DOWN_MASK));
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fchooser = new JFileChooser();
                int result = fchooser.showSaveDialog(null);
                if(result == JFileChooser.APPROVE_OPTION){
                    File fname = fchooser.getSelectedFile();
                    try {
                        PrintWriter print = new PrintWriter(fname);
                        print.println(edge.getText());
                        print.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        mfile.add(save);
        
        
        
        
        mColor = new JMenu("Color");
        buttongroup = new ButtonGroup();
        Red = new JRadioButtonMenuItem("Red");
        Red.addActionListener((e) -> {
            label.setBackground(Color.red);
        });
        Green = new JRadioButtonMenuItem("Green");
        Green.addActionListener((e) -> {
            label.setBackground(Color.GREEN);
        });
        Blue = new JRadioButtonMenuItem("Blue");
        Blue.addActionListener((e) -> {
          label.setBackground(Color.blue);
        });
        TestColor = new JRadioButtonMenuItem("Test Color");
        TestColor.addActionListener((e) -> {
         Color c = JColorChooser.showDialog(TestColor, "Choose Color", Color.yellow);
         label.setBackground(c);
        });
        buttongroup.add(Red);
        buttongroup.add(Green);
        buttongroup.add(Blue);
        buttongroup.add(TestColor);
        mColor.add(Red);
        mColor.add(Green);
        mColor.add(Blue);
        mColor.addSeparator();
        mColor.add(TestColor);
        
        mSystem = new JMenu("System");
        About = new JMenuItem("About Us");
        About.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(About, "Nguyen Van Truong \n PS24083 \n FpolyHCM");
            }
        });
        Exit = new JMenuItem("Exit");
        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        mSystem.add(About);
        mSystem.add(Exit);
        mMain.add(mfile);
        mMain.add(mColor);
        mMain.add(mSystem);
        this.setJMenuBar(mMain);
        
        tool = new JToolBar();
        butNew = new JButton( iconnew);
        butNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                     edge.setText("");
            }
        });
        
        iconUser = new ImageIcon("./src/Icon/Office.png");
        butAbout = new JButton(iconUser);
        butAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   JOptionPane.showMessageDialog(About, "Nguyen Van Truong \n PS24083 \n FpolyHCM");
            }
        });
        iconExit = new ImageIcon("./src/Icon/exit-Close-icon.png");
        butExit = new JButton(iconExit);
        butExit.addActionListener((e) -> {
            System.exit(0);
        });
        tool.add(butNew);
        tool.add(butAbout);
        tool.add( butExit);
        edge = new JEditorPane();
        edge.setText("Hello");
        
        popMenu = new JPopupMenu();
        item1 = new JMenuItem("Cut");
        item2 = new JMenuItem("Past");
        item3 = new JMenuItem("Coppy");
        popMenu.add(item1);
        popMenu.add(item2);
        popMenu.add(item3);
        this.add(popMenu);
        this.addMouseListener(this);
        
        

        
        Font f = new Font("Arial",Font.BOLD,20) ;
        
        label = new JTextField("Hello Would",JTextField.CENTER);
        label.setFont(f);
        label.setHorizontalAlignment(JTextField.CENTER);
        
        this.add(tool,BorderLayout.NORTH);
        this.add(edge,BorderLayout.CENTER);
        this.add(label,BorderLayout.SOUTH);
        
        
        
        

    }

    public static void main(String[] args) {
        new bai1b("fromFile").setVisible(true);
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        if(e.isPopupTrigger()){
            popMenu.show(this, e.getX(), e.getY());
        }
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
    }



}
