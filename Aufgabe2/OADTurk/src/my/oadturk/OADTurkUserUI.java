/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.oadturk;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

/**
 *
 * @author gaja
 */
public class OADTurkUserUI extends javax.swing.JFrame {

    /**
     * Creates new form OADTurkUserUI
     */
    public static SessionInfo session;
    public static DataManager manager;
    public int loaded_lu = 0;
    public OADTurkUserUI(SessionInfo ses) {
        session = ses;
        manager = session.manager;
        initComponents();
        
        jLabel1.setText(session.name + " (" + session.getLevelText() + ")");
        
        JLabel lab1 = new JLabel("Creator Panel");
        lab1.setPreferredSize(new Dimension(240, 30));
        jTabbedPane1.setTabComponentAt(0, lab1); 
        
        JLabel lab2 = new JLabel("Consume Learning Units");
        lab2.setPreferredSize(new Dimension(235, 30));
        jTabbedPane1.setTabComponentAt(1, lab2); 
        
        JLabel lab3 = new JLabel("Exams");
        lab3.setPreferredSize(new Dimension(235, 30));
        jTabbedPane1.setTabComponentAt(2, lab3);
        
        JLabel lab4 = new JLabel("Your Results");
        lab4.setPreferredSize(new Dimension(235, 30));
        jTabbedPane1.setTabComponentAt(3, lab4); 
        
        JLabel lab5 = new JLabel("Settings");
        lab5.setPreferredSize(new Dimension(235, 30));
        jTabbedPane1.setTabComponentAt(4, lab5);
        
        
        
        for(HashMap.Entry<Integer, LearningApp> entry : manager.la.entrySet())
        {
            JLabel lab6 = new JLabel(entry.getValue().name);
            lab6.setPreferredSize(new Dimension(150, 30));
            jTabbedPane2.setTabComponentAt(entry.getKey(), lab6);
        }
        
        jTabbedPane2.setTabPlacement(JTabbedPane.LEFT);
        
        for(HashMap.Entry<Integer, LearningApp> entry : manager.la.entrySet())
        {
            JLabel lab6 = new JLabel(entry.getValue().name);
            lab6.setPreferredSize(new Dimension(150, 30));
            jTabbedPane3.setTabComponentAt(entry.getKey(), lab6);
        }
        
        jTabbedPane3.setTabPlacement(JTabbedPane.LEFT);

        
        jButton4.setFocusPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton2.setFocusPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton3.setFocusPainted(false);
        jButton3.setContentAreaFilled(false);
        jButton5.setFocusPainted(false);
        jButton5.setContentAreaFilled(false);
        
        jButton1.setFocusPainted(false);
        jButton1.setContentAreaFilled(false);
        
        jButton8.setFocusPainted(false);
        jButton8.setContentAreaFilled(false);
        
        //jToggleButton1.setFocusPainted(false);
        //jToggleButton1.setContentAreaFilled(false);
        
        jTextField5.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        jTextField6.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        jTextField7.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        jTextField8.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        
        jPasswordField3.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        jPasswordField4.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        
        /*jCheckBox1.setBackground(Color.white);
        jCheckBox1.setOpaque(true);
        jCheckBox2.setBackground(Color.white);
        jCheckBox2.setOpaque(true);
        jCheckBox3.setBackground(Color.white);
        jCheckBox3.setOpaque(true);
        jCheckBox4.setBackground(Color.white);
        jCheckBox4.setOpaque(true);*/
        
        jButton6.setFocusPainted(false);
        jButton6.setContentAreaFilled(false);
        
        jButton7.setFocusPainted(false);
        jButton7.setContentAreaFilled(false);
        
        jLabel11.setVerticalAlignment(jLabel11.CENTER);
        jLabel10.setVerticalAlignment(jLabel10.CENTER);
        jLabel10.setVerticalAlignment(jLabel6.CENTER);
        jLabel10.setVerticalAlignment(jLabel23.CENTER);
        
        loadRandomQuestion();
        
    }
    
    public void loadRandomQuestion()
    {
        LearningApp lapp = manager.la.get(jTabbedPane2.getSelectedIndex());
        
        if(lapp.lu.size() > 0)
        {
            LearningUnit lunit;
            while(true)
            {
                ArrayList<Integer> keys = new ArrayList<Integer>(lapp.lu.keySet());
                int randomIndex = new Random().nextInt(keys.size());
                lunit = lapp.lu.get(randomIndex);
                
                if(randomIndex == loaded_lu)
                    continue;
                
                loaded_lu = randomIndex;
                
                if(lunit.approved == 1)
                    break;
                
                if(lunit.approved == 0 && lunit.created_by == session.id)
                    break;
            }
            

            jLabel4.setText("");
            jLabel6.setText("");
            jLabel9.setText("");
            jLabel10.setText("");
            jLabel11.setText("");

            jLabel4.setIcon(null);
            jLabel6.setIcon(null);
            jLabel9.setIcon(null);
            jLabel10.setIcon(null);
            jLabel11.setIcon(null);

            jCheckBox1.setSelected(false);
            jCheckBox2.setSelected(false);
            jCheckBox3.setSelected(false);
            jCheckBox4.setSelected(false);
            
            jPanel11.setBackground(Color.white);
            jPanel12.setBackground(Color.white);
            jPanel13.setBackground(Color.white);
            jPanel14.setBackground(Color.white);
            

            /*6  10
              11 23 image dim: 360 * 120
            */

            jLabel4.setText(lunit.question);

            if(lunit.desc_type != 0)
            {
                if(lunit.desc_type == 1)
                    jLabel9.setText(lunit.desc);
                else if(lunit.desc_type == 2)
                {
                    ImageIcon icon = new ImageIcon(lunit.desc);
                    Image image = icon.getImage(); 
                    Dimension img = new Dimension(image.getWidth(rootPane), image.getHeight(rootPane));
                    Dimension bound = new Dimension(600, 130);
                    Dimension scaled = getScaledDimension(img, bound);
                    Image newimg = image.getScaledInstance(scaled.width, scaled.height, java.awt.Image.SCALE_SMOOTH); 
                    icon = new ImageIcon(newimg);
                    jLabel9.setIcon(icon);
                }

                jLabel9.setVisible(true);
            }
            else
            {
                jLabel9.setVisible(false);
            }

            if(lunit.a1_type != 0)
            {
                if(lunit.a1_type == 1)
                    jLabel6.setText(lunit.a1);
                else if(lunit.a1_type == 2)
                {
                    ImageIcon icon = new ImageIcon(lunit.a1);
                    Image image = icon.getImage(); 
                    Dimension img = new Dimension(image.getWidth(rootPane), image.getHeight(rootPane));
                    Dimension bound = new Dimension(360, 120);
                    Dimension scaled = getScaledDimension(img, bound);
                    Image newimg = image.getScaledInstance(scaled.width, scaled.height, java.awt.Image.SCALE_SMOOTH); 
                    icon = new ImageIcon(newimg);
                    jLabel6.setIcon(icon);
                }

                jPanel11.setVisible(true);
                jLabel6.setVisible(true);
            }
            else
            {
                jPanel11.setVisible(false);
                jLabel6.setVisible(false);
            }

            if(lunit.a2_type != 0)
            {
                if(lunit.a2_type == 1)
                    jLabel10.setText(lunit.a2);
                else if(lunit.a2_type == 2)
                {
                    ImageIcon icon = new ImageIcon(lunit.a2);
                    Image image = icon.getImage(); 
                    Dimension img = new Dimension(image.getWidth(rootPane), image.getHeight(rootPane));
                    Dimension bound = new Dimension(360, 120);
                    Dimension scaled = getScaledDimension(img, bound);
                    Image newimg = image.getScaledInstance(scaled.width, scaled.height, java.awt.Image.SCALE_SMOOTH); 
                    icon = new ImageIcon(newimg);
                    jLabel10.setIcon(icon);
                }

                jPanel13.setVisible(true);
                jLabel10.setVisible(true);
            }
            else
            {
                jPanel13.setVisible(false);
                jLabel10.setVisible(false);
            }

            if(lunit.a3_type != 0)
            {
                if(lunit.a3_type == 1)
                    jLabel23.setText(lunit.a3);
                else if(lunit.a3_type == 2)
                {
                    ImageIcon icon = new ImageIcon(lunit.a3);
                    Image image = icon.getImage(); 
                    Dimension img = new Dimension(image.getWidth(rootPane), image.getHeight(rootPane));
                    Dimension bound = new Dimension(360, 120);
                    Dimension scaled = getScaledDimension(img, bound);
                    Image newimg = image.getScaledInstance(scaled.width, scaled.height, java.awt.Image.SCALE_SMOOTH); 
                    icon = new ImageIcon(newimg);
                    jLabel23.setIcon(icon);
                }

                jPanel12.setVisible(true);
                jLabel23.setVisible(true);
            }
            else
            {
                jPanel12.setVisible(false);
                jLabel23.setVisible(false);
            }

            if(lunit.a4_type != 0)
            {
                if(lunit.a4_type == 1)
                    jLabel11.setText(lunit.a4);
                else if(lunit.a4_type == 2)
                {
                    ImageIcon icon = new ImageIcon(lunit.a4);
                    Image image = icon.getImage(); 
                    Dimension img = new Dimension(image.getWidth(rootPane), image.getHeight(rootPane));
                    Dimension bound = new Dimension(360, 120);
                    Dimension scaled = getScaledDimension(img, bound);
                    Image newimg = image.getScaledInstance(scaled.width, scaled.height, java.awt.Image.SCALE_SMOOTH); 
                    icon = new ImageIcon(newimg);
                    jLabel11.setIcon(icon);
                }

                jPanel14.setVisible(true);
                jLabel11.setVisible(true);
            }
            else
            {
                jPanel14.setVisible(false);
                jLabel11.setVisible(false);
            }
            
            jPanel6.setVisible(true);
            jPanel7.setVisible(false);
        }
        else
        {
            jPanel6.setVisible(true);
            jPanel7.setVisible(false);
        }
        

        
    }
    
    Dimension getScaledDimension(Dimension imageSize, Dimension boundary) 
    {
        double widthRatio = boundary.getWidth() / imageSize.getWidth();
        double heightRatio = boundary.getHeight() / imageSize.getHeight();
        double ratio = Math.min(widthRatio, heightRatio);

        return new Dimension((int) (imageSize.width * ratio), (int) (imageSize.height * ratio));
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jCheckBox3 = new javax.swing.JCheckBox();
        jLabel23 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jCheckBox4 = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel15 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPasswordField3 = new javax.swing.JPasswordField();
        jPasswordField4 = new javax.swing.JPasswordField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setOpaque(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Ubuntu Light", 0, 24)); // NOI18N
        jLabel12.setForeground(java.awt.Color.gray);
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Unfortunately you are not a CREATOR.");

        jLabel13.setFont(new java.awt.Font("Ubuntu Light", 0, 20)); // NOI18N
        jLabel13.setForeground(java.awt.Color.gray);
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("To become one,  plase apply and wait for our Admins to evaluate your request.");

        jLabel14.setFont(new java.awt.Font("Ubuntu Light", 0, 20)); // NOI18N
        jLabel14.setForeground(java.awt.Color.gray);
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("You  might be asked to provide some additional informations.");

        jButton2.setFont(new java.awt.Font("Ubuntu Light", 0, 14)); // NOI18N
        jButton2.setForeground(java.awt.Color.gray);
        jButton2.setText("APPLY");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.gray));
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 1286, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(595, 595, 595)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jLabel12)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addGap(32, 32, 32)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(348, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab1", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane2StateChanged(evt);
            }
        });

        jPanel8.setBackground(java.awt.Color.white);

        jButton5.setText("Next");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(85, 85, 85)));
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton5MouseClicked(evt);
            }
        });

        jButton1.setText("Add LU");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.gray));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jButton8.setForeground(java.awt.Color.black);
        jButton8.setText("Verify");
        jButton8.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.black));
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14))
        );

        jLabel4.setBackground(java.awt.Color.white);
        jLabel4.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel4.setForeground(java.awt.Color.gray);
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel4.setOpaque(true);

        jPanel11.setBackground(java.awt.Color.white);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jCheckBox1)
                .addGap(29, 29, 29)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
        );

        jPanel12.setBackground(java.awt.Color.white);
        jPanel12.setPreferredSize(new java.awt.Dimension(603, 151));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jCheckBox3)
                .addGap(26, 26, 26)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jCheckBox3, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel13.setBackground(java.awt.Color.white);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jCheckBox2)
                .addGap(29, 29, 29)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jCheckBox2, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel14.setBackground(java.awt.Color.white);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jCheckBox4)
                .addGap(33, 33, 33)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jCheckBox4, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel9.setBackground(java.awt.Color.white);
        jLabel9.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel9.setForeground(java.awt.Color.gray);
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel9.setOpaque(true);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1278, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 490, Short.MAX_VALUE))
                        .addGap(0, 205, Short.MAX_VALUE))
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("tab1", jPanel6);

        jLabel5.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel5.setForeground(java.awt.Color.gray);
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("<html>Unfortunately there are no Learning Units for this Application.<br>Check back again later</html>");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 1302, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("tab2", jPanel7);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        jTabbedPane1.addTab("tab2", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel15.setBackground(java.awt.Color.white);

        jLabel8.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel8.setForeground(java.awt.Color.gray);
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("<html>Note: Exam will open in new window. DONOT close it until you are finished.<br>If you are not registered please do.</html>");

        jButton6.setFont(new java.awt.Font("Ubuntu Light", 0, 14)); // NOI18N
        jButton6.setForeground(java.awt.Color.gray);
        jButton6.setText("REGISTER");
        jButton6.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.gray));
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setOpaque(true);

        jButton7.setFont(new java.awt.Font("Ubuntu Light", 0, 14)); // NOI18N
        jButton7.setForeground(java.awt.Color.gray);
        jButton7.setText("START");
        jButton7.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.gray));
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setOpaque(true);
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 1302, Short.MAX_VALUE)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(278, 278, 278)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(495, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("tab1", jPanel15);

        jLabel7.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel7.setForeground(java.awt.Color.gray);
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("<html>Unfortunately there is no Exam for this Application.<br>Check back again later</html>");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 1302, Short.MAX_VALUE)
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("tab2", jPanel21);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane3)
        );

        jTabbedPane1.addTab("tab3", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1310, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 673, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab4", jPanel5);

        jPanel9.setBackground(java.awt.Color.white);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jButton4.setText("Save");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(85, 85, 85)));

        jTextField5.setBackground(java.awt.Color.white);
        jTextField5.setFont(new java.awt.Font("Ubuntu Light", 0, 24)); // NOI18N
        jTextField5.setForeground(java.awt.Color.gray);
        jTextField5.setText("Max");

        jTextField6.setBackground(java.awt.Color.white);
        jTextField6.setFont(new java.awt.Font("Ubuntu Light", 0, 24)); // NOI18N
        jTextField6.setForeground(java.awt.Color.gray);
        jTextField6.setText("Mustermann");

        jTextField7.setBackground(java.awt.Color.white);
        jTextField7.setFont(new java.awt.Font("Ubuntu Light", 0, 24)); // NOI18N
        jTextField7.setForeground(java.awt.Color.gray);
        jTextField7.setText("MaxM");

        jTextField8.setBackground(java.awt.Color.white);
        jTextField8.setFont(new java.awt.Font("Ubuntu Light", 0, 24)); // NOI18N
        jTextField8.setForeground(java.awt.Color.gray);
        jTextField8.setText("mustermann@me.com");

        jLabel15.setFont(new java.awt.Font("Ubuntu Light", 1, 24)); // NOI18N
        jLabel15.setForeground(java.awt.Color.gray);
        jLabel15.setText("Settings");

        jLabel16.setText("Here you can change you personal info.");

        jPasswordField3.setFont(new java.awt.Font("Ubuntu Light", 0, 24)); // NOI18N
        jPasswordField3.setForeground(java.awt.Color.gray);
        jPasswordField3.setText("jPasswordField1");

        jPasswordField4.setFont(new java.awt.Font("Ubuntu Light", 0, 24)); // NOI18N
        jPasswordField4.setForeground(java.awt.Color.gray);

        jLabel17.setFont(new java.awt.Font("Ubuntu Light", 0, 24)); // NOI18N
        jLabel17.setForeground(java.awt.Color.gray);
        jLabel17.setText("First Name:");

        jLabel18.setFont(new java.awt.Font("Ubuntu Light", 0, 24)); // NOI18N
        jLabel18.setForeground(java.awt.Color.gray);
        jLabel18.setText("Last Name:");

        jLabel19.setFont(new java.awt.Font("Ubuntu Light", 0, 24)); // NOI18N
        jLabel19.setForeground(java.awt.Color.gray);
        jLabel19.setText("Username:");

        jLabel20.setFont(new java.awt.Font("Ubuntu Light", 0, 24)); // NOI18N
        jLabel20.setForeground(java.awt.Color.gray);
        jLabel20.setText("E-Mail:");

        jLabel21.setFont(new java.awt.Font("Ubuntu Light", 0, 24)); // NOI18N
        jLabel21.setForeground(java.awt.Color.gray);
        jLabel21.setText("Old Password:");

        jLabel22.setFont(new java.awt.Font("Ubuntu Light", 0, 24)); // NOI18N
        jLabel22.setForeground(java.awt.Color.gray);
        jLabel22.setText("New Password:");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18)
                            .addComponent(jLabel19)
                            .addComponent(jLabel20)
                            .addComponent(jLabel21)
                            .addComponent(jLabel22))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField6)
                            .addComponent(jTextField5)
                            .addComponent(jTextField7)
                            .addComponent(jTextField8)
                            .addComponent(jPasswordField4)
                            .addComponent(jPasswordField3, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(682, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPasswordField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 174, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("tab5", jPanel9);

        jLabel1.setFont(new java.awt.Font("Ubuntu Light", 0, 24)); // NOI18N
        jLabel1.setForeground(java.awt.Color.gray);
        jLabel1.setText("Max  Mustermann (User)");

        jLabel2.setFont(new java.awt.Font("Ubuntu Light", 1, 30)); // NOI18N
        jLabel2.setForeground(java.awt.Color.gray);
        jLabel2.setText("Your OADTurk");

        jLabel3.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        jLabel3.setForeground(java.awt.Color.gray);
        jLabel3.setText("Open system for Learning Aplications.");

        jButton3.setFont(new java.awt.Font("Ubuntu Light", 1, 20)); // NOI18N
        jButton3.setForeground(java.awt.Color.gray);
        jButton3.setText("Sign Out");
        jButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)))
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        // TODO add your handling code here:
        OADTurkExamUI user = new OADTurkExamUI();
        //close();
        user.setVisible(true);
    }//GEN-LAST:event_jButton7MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        OADTurkUI login = new OADTurkUI();
        close();
        login.setVisible(true);
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MouseClicked
        // TODO add your handling code here:
            
        loadRandomQuestion();
        
    }//GEN-LAST:event_jButton5MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        OADTurkNewLU login = new OADTurkNewLU(session, jTabbedPane2.getSelectedIndex());
        login.setVisible(true);
    }//GEN-LAST:event_jButton1MouseClicked

    private void jTabbedPane2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane2StateChanged
        // TODO add your handling code here:
        if(jTabbedPane2.getSelectedIndex() > 0)
        {
            loadRandomQuestion();
        }
            
    }//GEN-LAST:event_jTabbedPane2StateChanged

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        LearningApp lapp = manager.la.get(jTabbedPane2.getSelectedIndex());
        LearningUnit lunit = lapp.lu.get(loaded_lu);
        
        if(lunit.a1_correct == jCheckBox1.isSelected())
        {
            jPanel11.setBackground(new Color(0, 153, 51));
        }
        else
        {
            jPanel11.setBackground(new Color(153, 0, 0));
        }
        
        if(lunit.a2_correct == jCheckBox2.isSelected())
        {
            jPanel13.setBackground(new Color(0, 153, 51));
        }
        else
        {
            jPanel13.setBackground(new Color(153, 0, 0));
        }
        
        if(lunit.a3_correct == jCheckBox3.isSelected())
        {
            jPanel12.setBackground(new Color(0, 153, 51));
        }
        else
        {
            jPanel12.setBackground(new Color(153, 0, 0));
        }
        
        if(lunit.a4_correct == jCheckBox4.isSelected())
        {
            jPanel14.setBackground(new Color(0, 153, 51));
        }
        else
        {
            jPanel14.setBackground(new Color(153, 0, 0));
        }
        
        
        
    }//GEN-LAST:event_jButton8ActionPerformed

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
            java.util.logging.Logger.getLogger(OADTurkUserUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OADTurkUserUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OADTurkUserUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OADTurkUserUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OADTurkUserUI(session).setVisible(true);
            }
        });
        

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPasswordField jPasswordField3;
    private javax.swing.JPasswordField jPasswordField4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables

    
        private void close()
    {
        WindowEvent winClosing = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosing);
    }
    
}
