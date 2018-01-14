/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.oadturk;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;


/**
 *
 * @author am1704
 */
public class OADTurkExamAdminUI extends javax.swing.JFrame {

    /**
     * Creates new form OADTurkExamAdminUI
     */
    
    public static SessionInfo session;
    public static int la_id;
    public static int ex_id;
    public static DefaultListModel<String> model = new DefaultListModel<>();
    
    public OADTurkExamAdminUI(SessionInfo ses, int laid, int exid) {
        session = ses;
        la_id = laid;
        ex_id = exid;
        
        initComponents();
        
        
        
        jLabel6.setVisible(false);
        LearningApp lapp = session.manager.la.get(laid);
        
        if(ex_id != -1)
        {
            Exam ex = lapp.exam.get(exid);
            
            jTextField1.setText(ex.name);
            jTextField2.setText(String.valueOf(ex.code));
            jSpinner1.setValue(ex.date.getTime());
            jSpinner2.setValue(ex.until.getTime());
            jSpinner4.setValue(ex.num_of_questions);
            jSpinner5.setValue(ex.points_per_question);
            jComboBox1.setSelectedIndex(ex.type);
        }
        
         
         jList1.setModel(model);
         model.clear();
        if(jComboBox1.getSelectedIndex() == 0)
        {
            for(HashMap.Entry<Integer, String> entry : lapp.categories.entrySet())
            {
                 model.addElement(entry.getKey() + " - " + entry.getValue());
            }
        }
        else
        {
            for(HashMap.Entry<Integer, LearningUnit> entry : lapp.lu.entrySet())
            {
                model.addElement(entry.getKey() + " - " + entry.getValue().question + " - " + lapp.categories.get(entry.getValue().cat_id));
            }
        }
        
        
        if(ex_id != -1)
        {
            Exam ex = lapp.exam.get(exid);
            
            if(ex.type == 0)
            {
                int ids[] = new int[ex.categories.size()];
                int counter = 0;
                 for(int i = 0; i < model.size(); i++)
                {
                    String[] split = model.get(i).split(" - ");
                    int id = Integer.parseInt(split[0]);
                    
                    for(int j = 0; j < ex.categories.size(); j++)
                    {
                        if(ex.categories.get(j) == id)
                        {
                            ids[counter++] = i;
                        }
                    }
                }
                 
                 jList1.setSelectedIndices(ids);
            }
            else
            {
                int ids[] = new int[ex.lus.size()];
                int counter = 0;
                 for(int i = 0; i < model.size(); i++)
                {
                    String[] split = model.get(i).split(" - ");
                    int id = Integer.parseInt(split[0]);
                    
                    for(int j = 0; j < ex.lus.size(); j++)
                    {
                        if(ex.lus.get(j) == id)
                        {
                            ids[counter++] = i;
                        }
                    }
                }
                 
                 jList1.setSelectedIndices(ids);
            }
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
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel4 = new javax.swing.JLabel();
        jSpinner2 = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSpinner4 = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jSpinner5 = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setText("Exam Administration:");

        jLabel2.setText("Start Time:");

        jLabel3.setText("Exam name:");

        jSpinner1.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.MINUTE));

        jLabel4.setText("End Time:");

        jSpinner2.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.MINUTE));

        jLabel5.setText("Code:");

        jLabel7.setText("Points per question:");

        jSpinner4.setModel(new javax.swing.SpinnerNumberModel(10, 1, 50, 1));

        jLabel8.setText("Exam type:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Automatic Exam - Select Categories", "Manual Exam - Select Questions" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jList1.setToolTipText("");
        jScrollPane1.setViewportView(jList1);

        jButton1.setText("Save Exam");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setText("Number of questions:");

        jSpinner5.setModel(new javax.swing.SpinnerNumberModel(1.0d, 0.5d, 25.0d, 0.5d));

        jLabel6.setText("Error: Something went wrong!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel7))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel9))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(55, 55, 55)
                                        .addComponent(jLabel5)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jSpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 136, Short.MAX_VALUE))))))
                    .addComponent(jLabel6))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jSpinner4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jSpinner2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jSpinner5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox1)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        LearningApp lapp = session.manager.la.get(la_id);
         model.clear();
        if(jComboBox1.getSelectedIndex() == 0)
        {
            for(HashMap.Entry<Integer, String> entry : lapp.categories.entrySet())
            {
                 model.addElement(entry.getKey() + " - " + entry.getValue());
            }
        }
        else
        {
            for(HashMap.Entry<Integer, LearningUnit> entry : lapp.lu.entrySet())
            {
                model.addElement(entry.getKey() + " - " + entry.getValue().question + " - " + lapp.categories.get(entry.getValue().cat_id));
            }
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        LearningApp lapp = session.manager.la.get(la_id);
        
        String name = jTextField1.getText();
        int code;
        
         try {  
            code = Integer.parseInt(jTextField2.getText());
        } catch (NumberFormatException e) {  
            jLabel6.setText("ERROR: Code must be number!!");
            jLabel6.setForeground(Color.red);
            jLabel6.setVisible(true);
            
            return;
        }  
        
        Calendar date = Calendar.getInstance();
        Date d = (Date) jSpinner1.getValue();
        date.setTime(d);
        
        
        Calendar until = Calendar.getInstance();
        Date u = (Date) jSpinner2.getValue();
        until.setTime(u);
        
        int num_of_questions = (int) jSpinner4.getValue();
        float pts_per_question =  Float.parseFloat(jSpinner5.getValue().toString());
        
        int type = jComboBox1.getSelectedIndex();
        
        List<String> values = jList1.getSelectedValuesList();
        
        ArrayList<Integer> ids = new ArrayList();
        
        if(name.length() < 2)
        {
            jLabel6.setText("ERROR: Name must be at least 2 characters long!");
            jLabel6.setForeground(Color.red);
            jLabel6.setVisible(true);
            
            return;
        }
        
        if(jTextField2.getText().length() < 0)
        {
            jLabel6.setText("ERROR: You must enter code!");
            jLabel6.setForeground(Color.red);
            jLabel6.setVisible(true);
            
            return;
        }
        
        if(d.before(new Date()))
        {
            jLabel6.setText("ERROR: You must enter start date after current time!");
            jLabel6.setForeground(Color.red);
            jLabel6.setVisible(true);
            
            return;
        }
        
         if(u.before(new Date()))
        {
            jLabel6.setText("ERROR: You must enter end date after current time!");
            jLabel6.setForeground(Color.red);
            jLabel6.setVisible(true);
            
            return;
        }
         
          if(u.before(d))
        {
            jLabel6.setText("ERROR: You must enter start date before end date!");
            jLabel6.setForeground(Color.red);
            jLabel6.setVisible(true);
            
            return;
        }
        
        for(int i = 0; i < values.size(); i++)
        {
            String[] split = values.get(i).split(" - ");
            
            int id = Integer.parseInt(split[0]);
            ids.add(id);
        }
        
        if(values.size() == 0)
        {
            jLabel6.setText("ERROR: You must select questions or categories!");
            jLabel6.setForeground(Color.red);
            jLabel6.setVisible(true);
            
            return;
        }
        
        if(values.size() != num_of_questions && type == 1)
        {
            jLabel6.setText("ERROR: You must select exact number of questions you entered!");
            jLabel6.setForeground(Color.red);
            jLabel6.setVisible(true);
            
            return;
        }
        
        if(type == 0)
        {
            int count_q = 0;
            
            for(int i = 0; i < ids.size(); i++)
            {
                for(HashMap.Entry<Integer, LearningUnit> entry : lapp.lu.entrySet())
                {
                    if(entry.getValue().cat_id == ids.get(i))
                    {
                        count_q++;
                    }
                }
            }
            
            if(count_q < num_of_questions)
            {
                jLabel6.setText("ERROR: There are not enough questions in selected categories!");
                jLabel6.setForeground(Color.red);
                jLabel6.setVisible(true);
            
                return;
            }
        }
        
               
        
        if(ex_id == -1)
        {
            ex_id = session.manager.insertExam(la_id, name, date, until, type, num_of_questions, pts_per_question, code, ids);
        }
        else
        {
            session.manager.editExam(la_id, ex_id, name, date, until, type, num_of_questions, pts_per_question, code, ids);
        }
        
         JOptionPane.showMessageDialog(rootPane, "You have edited this exam!");
         close();
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(OADTurkExamAdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OADTurkExamAdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OADTurkExamAdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OADTurkExamAdminUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OADTurkExamAdminUI(session, la_id, ex_id).setVisible(true);
            }
        });
    }
    
    private void close()
    {
        WindowEvent winClosing = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosing);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JSpinner jSpinner5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
