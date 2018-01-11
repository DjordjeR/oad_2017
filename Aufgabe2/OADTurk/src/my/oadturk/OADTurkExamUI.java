package my.oadturk;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class OADTurkExamUI extends javax.swing.JFrame {


    public static SessionInfo session;
    public static int laid;
    public static int exid;
    public static ArrayList<Integer> questions = new ArrayList<>();
    
    public static int currentIndex = 0;
    public static float points = 0;
    
    public OADTurkExamUI(SessionInfo ses, int l, int e) {
        session = ses;
        laid = l;
        exid = e;
        initComponents();
        
        jButton5.setFocusPainted(false);
        jButton5.setContentAreaFilled(false);
        
        Exam exam = session.manager.la.get(laid).exam.get(exid);
        
        if(exam.type == 1)
        {
            loadDefinedExam();
        }
        else if(exam.type == 0)
        {
            loadRandomExam();
        }
    }
    
    public void loadDefinedExam()
    {
        LearningApp lapp = session.manager.la.get(laid);
        Exam exam = lapp.exam.get(exid);
        
        questions = exam.lus;
        loadQuestion(questions.get(0));
        
        
    }
    
     public void loadRandomExam()
    {
        LearningApp lapp = session.manager.la.get(laid);
        Exam exam = lapp.exam.get(exid);
        
        while(true)
        {
            
            ArrayList<Integer> cats = exam.categories;
            int cat_index = new Random().nextInt(cats.size());
            int cat_id = exam.categories.get(cat_index);
            
            
            ArrayList<Integer> lus = new ArrayList<Integer>(lapp.lu.keySet());
            
            LearningUnit lunit;
            int lu_index;
            
            while(true)
            {
                lu_index = new Random().nextInt(lus.size());
                lunit = lapp.lu.get(lus.get(lu_index));
                
                if(lunit.cat_id == cat_id)
                    break;
            }
           
            if(lunit.approved == 1)
            {
                 if(!questions.contains(lus.get(lu_index)))
                    questions.add(lus.get(lu_index));
            }
            
            if(questions.size() == exam.num_of_questions)
                break;
        }
        
        loadQuestion(questions.get(0));
        
    }
    
    public void loadQuestion(int luid)
    {
        LearningApp lapp = session.manager.la.get(laid);
        LearningUnit lunit = lapp.lu.get(luid);
             
        jLabel4.setText("");
        jLabel9.setText("");
        jLabel6.setText("");
        jLabel10.setText("");
        jLabel11.setText("");
        jLabel23.setText("");

        jLabel4.setIcon(null);
        jLabel9.setIcon(null);
        jLabel6.setIcon(null);
        jLabel10.setIcon(null);
        jLabel11.setIcon(null);
        jLabel23.setIcon(null);

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


        
    }
    
    public Dimension getScaledDimension(Dimension imageSize, Dimension boundary) 
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
        jPanel8 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel11.setBackground(java.awt.Color.white);

        jCheckBox1.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jCheckBox1.setForeground(java.awt.Color.gray);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jCheckBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );

        jPanel12.setBackground(java.awt.Color.white);
        jPanel12.setPreferredSize(new java.awt.Dimension(603, 151));

        jCheckBox3.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jCheckBox3.setForeground(java.awt.Color.gray);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jCheckBox3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jCheckBox3, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel13.setBackground(java.awt.Color.white);

        jCheckBox2.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jCheckBox2.setForeground(java.awt.Color.gray);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jCheckBox2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jCheckBox2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel14.setBackground(java.awt.Color.white);

        jCheckBox4.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jCheckBox4.setForeground(java.awt.Color.gray);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jCheckBox4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jCheckBox4, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel8.setBackground(java.awt.Color.white);

        jButton5.setForeground(java.awt.Color.gray);
        jButton5.setText("Submit");
        jButton5.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.gray));
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton5MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jLabel4.setBackground(java.awt.Color.white);
        jLabel4.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel4.setForeground(java.awt.Color.gray);
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel4.setOpaque(true);

        jLabel9.setBackground(java.awt.Color.white);
        jLabel9.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel9.setForeground(java.awt.Color.gray);
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel9.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1133, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1133, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton5MousePressed
        
        LearningApp lapp = session.manager.la.get(laid);
        Exam exam = lapp.exam.get(exid);
        LearningUnit lunit = lapp.lu.get(questions.get(currentIndex));
        
        boolean a1 = jCheckBox1.isSelected();
        boolean a2 = jCheckBox2.isSelected();
        boolean a3 = jCheckBox3.isSelected();
        boolean a4 = jCheckBox4.isSelected();
        
        int maxCorrect = 0;
        int numCorrect = 0;
        
        if(lunit.a1_type != 0)
            maxCorrect++;
        if(lunit.a2_type != 0)
            maxCorrect++;
        if(lunit.a3_type != 0)
            maxCorrect++;
        if(lunit.a4_type != 0)
            maxCorrect++;
        
        if(lunit.a1_type != 0 && lunit.a1_correct == a1)
            numCorrect++;
        if(lunit.a2_type != 0 && lunit.a2_correct == a2)
            numCorrect++;
        if(lunit.a3_type != 0 && lunit.a3_correct == a3)
            numCorrect++;
        if(lunit.a4_type != 0 && lunit.a4_correct == a4)
            numCorrect++;
        
        float pt = numCorrect/maxCorrect * exam.points_per_question;
        
        points += pt;
        
        currentIndex++;
        if(currentIndex + 1 == exam.num_of_questions)
        {
            jButton5.setText("Finish exam");
            loadQuestion(questions.get(currentIndex));
        }
        else if(currentIndex + 1 > exam.num_of_questions )
        {
            session.manager.addFinishedExam(session.id, laid, exid, points);
            session.manager.deleteRegisteredExam(session.id, laid, exid);
            JOptionPane.showMessageDialog(rootPane, "You successfully finished the exam!\n\nYou points: " + points + "/" + exam.num_of_questions * exam.points_per_question);
            close();
        }
        else
            loadQuestion(questions.get(currentIndex));
    }//GEN-LAST:event_jButton5MousePressed

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
            java.util.logging.Logger.getLogger(OADTurkExamUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OADTurkExamUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OADTurkExamUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OADTurkExamUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OADTurkExamUI(session, laid, exid).setVisible(true);
            }
        });
    }
    
    private void close()
    {
        WindowEvent winClosing = new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosing);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel8;
    // End of variables declaration//GEN-END:variables
}
