/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.oadturk;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static my.oadturk.OADTurkUserUI.session;

/**
 *
 * @author gaja
 */
public class OADTurkNewLU extends javax.swing.JFrame {

    /**
     * Creates new form OADTurkNewLU
     */
    public static SessionInfo session;
    public static int la_id;
    public OADTurkNewLU(SessionInfo ses, int laid) {
        session = ses;
        la_id = laid;
        LearningApp lapp = session.manager.la.get(laid);
        initComponents();
        getContentPane().requestFocusInWindow();
        getContentPane().setBackground(Color.white);
        
        jTextField1.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        jTextField2.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        jTextField3.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        jTextField4.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        jTextField5.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        jTextField6.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.GRAY));
        
        jButton1.setFocusPainted(false);
        jButton1.setContentAreaFilled(false);
        
        jCheckBox1.setBackground(Color.white);
        
        for(HashMap.Entry<Integer, String> entry : lapp.categories.entrySet())
        {
            jComboBox6.addItem(entry.getValue());
        }
        
        // NOTE: Creator is not required to apply if this is creators LA
        if(ses.getLevelText().equals("Creator"))
        {
            jButton1.setText("CONFIRM");
        }
        else
        {
            jButton1.setText("APPLY");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField3 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jTextField4 = new javax.swing.JTextField();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jTextField5 = new javax.swing.JTextField();
        jCheckBox3 = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jTextField6 = new javax.swing.JTextField();
        jCheckBox4 = new javax.swing.JCheckBox();
        jComboBox5 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        jLabel1.setForeground(java.awt.Color.gray);
        jLabel1.setText("Question:");

        jTextField1.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        jTextField1.setForeground(java.awt.Color.lightGray);
        jTextField1.setText("question ");

        jLabel2.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        jLabel2.setForeground(java.awt.Color.gray);
        jLabel2.setText("Description:");

        jTextField2.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        jTextField2.setForeground(java.awt.Color.lightGray);
        jTextField2.setText("descritption");

        jLabel3.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        jLabel3.setForeground(java.awt.Color.gray);
        jLabel3.setText("Q1:");

        jComboBox1.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        jComboBox1.setForeground(java.awt.Color.gray);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disabled", "Text", "Image" }));
        jComboBox1.setBorder(null);
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jTextField3.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        jTextField3.setForeground(java.awt.Color.lightGray);
        jTextField3.setText("answer 1");

        jCheckBox1.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        jCheckBox1.setForeground(java.awt.Color.gray);
        jCheckBox1.setText("True");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        jLabel4.setForeground(java.awt.Color.gray);
        jLabel4.setText("Q2:");

        jComboBox2.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        jComboBox2.setForeground(java.awt.Color.gray);
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disabled", "Text", "Image" }));
        jComboBox2.setBorder(null);
        jComboBox2.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox2ItemStateChanged(evt);
            }
        });

        jTextField4.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        jTextField4.setForeground(java.awt.Color.lightGray);
        jTextField4.setText("answer 2");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jCheckBox2.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        jCheckBox2.setForeground(java.awt.Color.gray);
        jCheckBox2.setText("True");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        jLabel5.setForeground(java.awt.Color.gray);
        jLabel5.setText("Q3:");

        jComboBox3.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        jComboBox3.setForeground(java.awt.Color.gray);
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disabled", "Text", "Image" }));
        jComboBox3.setBorder(null);
        jComboBox3.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox3ItemStateChanged(evt);
            }
        });

        jTextField5.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        jTextField5.setForeground(java.awt.Color.lightGray);
        jTextField5.setText("answer 3");

        jCheckBox3.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        jCheckBox3.setForeground(java.awt.Color.gray);
        jCheckBox3.setText("True");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        jLabel6.setForeground(java.awt.Color.gray);
        jLabel6.setText("Q4:");

        jComboBox4.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        jComboBox4.setForeground(java.awt.Color.gray);
        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disabled", "Text", "Image" }));
        jComboBox4.setBorder(null);
        jComboBox4.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox4ItemStateChanged(evt);
            }
        });

        jTextField6.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        jTextField6.setForeground(java.awt.Color.lightGray);
        jTextField6.setText("answer 4");

        jCheckBox4.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        jCheckBox4.setForeground(java.awt.Color.gray);
        jCheckBox4.setText("True");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });

        jComboBox5.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        jComboBox5.setForeground(java.awt.Color.gray);
        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Disabled", "Text", "Image" }));
        jComboBox5.setBorder(null);
        jComboBox5.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox5ItemStateChanged(evt);
            }
        });
        jComboBox5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox5MouseClicked(evt);
            }
        });

        jButton1.setText("APPLY");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.gray));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        jLabel7.setForeground(java.awt.Color.gray);
        jLabel7.setText("Category:");

        jLabel8.setFont(new java.awt.Font("Ubuntu Light", 0, 15)); // NOI18N
        jLabel8.setForeground(java.awt.Color.gray);
        jLabel8.setText("INFO: Please fill in the following fields in order to apply for new Learning Unit!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField6))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField3)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCheckBox3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCheckBox4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jCheckBox1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextField2))
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                            .addComponent(jComboBox6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextField2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox4))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jComboBox5ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox5ItemStateChanged
        // TODO add your handling code here:
        
        if(jComboBox5.getSelectedIndex() == 1 && evt.getStateChange() == ItemEvent.SELECTED)
        {
            JFileChooser fc = new JFileChooser();
            
            int returnVal = fc.showOpenDialog(this);
            
            if(returnVal == JFileChooser.APPROVE_OPTION)
            {
                File file = fc.getSelectedFile();
                
                jTextField2.setText(file.getAbsolutePath());
                jTextField2.setForeground(Color.gray);
            }
        }
        
    }//GEN-LAST:event_jComboBox5ItemStateChanged

    private void jComboBox5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox5MouseClicked
        // TODO add your handling code here:\
        
        
    }//GEN-LAST:event_jComboBox5MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        
        String q = jTextField1.getText();
        String desc = jTextField2.getText();
        int dt = jComboBox5.getSelectedIndex();
        int cat = session.manager.getCatId(la_id, jComboBox6.getItemAt(jComboBox6.getSelectedIndex()));
        
        String as1 = jTextField3.getText();
        String as2 = jTextField4.getText();
        String as3 = jTextField5.getText();
        String as4 = jTextField6.getText();
        
        int as1t = jComboBox1.getSelectedIndex();
        int as2t = jComboBox2.getSelectedIndex();
        int as3t = jComboBox3.getSelectedIndex();
        int as4t = jComboBox4.getSelectedIndex();
        
        boolean a1c = jCheckBox1.isSelected();
        boolean a2c = jCheckBox2.isSelected();
        boolean a3c = jCheckBox3.isSelected();
        boolean a4c = jCheckBox4.isSelected();
               
        
        if(q.length() < 3)
        {
            jLabel8.setText("ERROR: You must enter the question!");
            jLabel8.setForeground(Color.red);
            return;
        }
        
        if(dt != 0 && desc.length() < 3)
        {
            jLabel8.setText("ERROR: You must enter the description!");
            jLabel8.setForeground(Color.red);
            return;
        }
        
        if(as1t != 0 && as1.length() < 3)
        {
            jLabel8.setText("ERROR: You must enter the first answer!");
            jLabel8.setForeground(Color.red);
            return;
        }
        
        if(as2t != 0 && as2.length() < 3)
        {
            jLabel8.setText("ERROR: You must enter the second answer!");
            jLabel8.setForeground(Color.red);
            return;
        }
        
        if(as3t != 0 && as3.length() < 3)
        {
            jLabel8.setText("ERROR: You must enter the third answer!");
            jLabel8.setForeground(Color.red);
            return;
        }
        
        if(as4t != 0 && as4.length() < 3)
        {
            jLabel8.setText("ERROR: You must enter the fourth answer!");
            jLabel8.setForeground(Color.red);
            return;
        }
        
        if(as1t == 0 && as2t == 0)
        {
            jLabel8.setText("ERROR: You must enter at least first two answers!");
            jLabel8.setForeground(Color.red);
            return;
        }
        
        if(as3t == 0 && as4t != 0)
        {
            jLabel8.setText("ERROR: You cannot leave empty the third and not fourth answer!");
            jLabel8.setForeground(Color.red);
            return;
        }
        
        int approved = 1;
        
        if(session.manager.users.get(session.id).level == 1)
            approved = 0;
        
        session.manager.insertLU(la_id, q, desc, dt, as1, as1t, as2, as2t, as3, as3t, as4, as4t, session.id, approved, cat, a1c, a2c, a3c, a4c);
               
        JOptionPane.showMessageDialog(rootPane,"INFO: You successfully submited new LU!");
        
        close();
        
    }//GEN-LAST:event_jButton1MouseClicked

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        
        if(jComboBox1.getSelectedIndex() == 2 && evt.getStateChange() == ItemEvent.SELECTED)
        {
            JFileChooser fc = new JFileChooser();
            
            int returnVal = fc.showOpenDialog(this);
            
            if(returnVal == JFileChooser.APPROVE_OPTION)
            {
                File file = fc.getSelectedFile();
                
                jTextField3.setText(file.getAbsolutePath());
                jTextField3.setForeground(Color.gray);
            }
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jComboBox2ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox2ItemStateChanged
        // TODO add your handling code here:
        
        if(jComboBox2.getSelectedIndex() == 2 && evt.getStateChange() == ItemEvent.SELECTED)
        {
            JFileChooser fc = new JFileChooser();
            
            int returnVal = fc.showOpenDialog(this);
            
            if(returnVal == JFileChooser.APPROVE_OPTION)
            {
                File file = fc.getSelectedFile();
                
                jTextField4.setText(file.getAbsolutePath());
                jTextField4.setForeground(Color.gray);
            }
        }
    }//GEN-LAST:event_jComboBox2ItemStateChanged

    private void jComboBox3ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox3ItemStateChanged
        // TODO add your handling code here:
        
        if(jComboBox3.getSelectedIndex() == 2 && evt.getStateChange() == ItemEvent.SELECTED)
        {
            JFileChooser fc = new JFileChooser();
            
            int returnVal = fc.showOpenDialog(this);
            
            if(returnVal == JFileChooser.APPROVE_OPTION)
            {
                File file = fc.getSelectedFile();
                
                jTextField5.setText(file.getAbsolutePath());
                jTextField5.setForeground(Color.gray);
            }
        }
    }//GEN-LAST:event_jComboBox3ItemStateChanged

    private void jComboBox4ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox4ItemStateChanged
        // TODO add your handling code here:
        
        if(jComboBox4.getSelectedIndex() == 2 && evt.getStateChange() == ItemEvent.SELECTED)
        {
            JFileChooser fc = new JFileChooser();
            
            int returnVal = fc.showOpenDialog(this);
            
            if(returnVal == JFileChooser.APPROVE_OPTION)
            {
                File file = fc.getSelectedFile();
                
                jTextField6.setText(file.getAbsolutePath());
                jTextField6.setForeground(Color.gray);
            }
        }
    }//GEN-LAST:event_jComboBox4ItemStateChanged

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
            java.util.logging.Logger.getLogger(OADTurkNewLU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OADTurkNewLU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OADTurkNewLU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OADTurkNewLU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OADTurkNewLU(session, la_id).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables

    private void close()
    {
        WindowEvent winClosing = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosing);
    }
}
