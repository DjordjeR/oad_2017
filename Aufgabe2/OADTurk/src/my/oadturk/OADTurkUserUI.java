package my.oadturk;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;


public class OADTurkUserUI extends javax.swing.JFrame {

    public static SessionInfo session;
    public static DataManager manager;
    public int loaded_lu = 0;
    public static int selected_la = 0;
    
    private JTable table_exam;
    private DefaultTableModel dm_exam;
    
    private JTable table_results;
    private DefaultTableModel dm_results;
    
    public OADTurkUserUI(SessionInfo ses) {
        session = ses;
        manager = session.manager;
        initComponents();
        
        jLabel1.setText(session.manager.users.get(session.id).name + " (" + session.getLevelText() + ")");
        
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
        
        for(HashMap.Entry<Integer, LearningApp> entry : manager.la.entrySet())
        {
            JLabel lab6 = new JLabel(entry.getValue().name);
            lab6.setPreferredSize(new Dimension(150, 30));
            jTabbedPane4.setTabComponentAt(entry.getKey(), lab6);
        }
        
        jTabbedPane4.setTabPlacement(JTabbedPane.LEFT);
        
        JLabel lab6 = new JLabel("Settings");
        lab6.setPreferredSize(new Dimension(150, 30));
        jTabbedPane5.setTabComponentAt(0, lab6);
        
        JLabel lab7 = new JLabel("Administration");
        lab7.setPreferredSize(new Dimension(150, 30));
        jTabbedPane5.setTabComponentAt(1, lab7);
        
        if(session.manager.users.get(session.id).level >= 3)
            jLabel24.setVisible(false);
        
        if(session.manager.users.get(session.id).level >= 2)
        {
            jLabel12.setVisible(false);
            jLabel13.setVisible(false);
            jLabel14.setVisible(false);
            jButton2.setVisible(false);
        }
        
        
        jTabbedPane5.setTabPlacement(JTabbedPane.LEFT);
        
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
        
        jLabel11.setVerticalAlignment(jLabel11.CENTER);
        jLabel10.setVerticalAlignment(jLabel10.CENTER);
        jLabel10.setVerticalAlignment(jLabel6.CENTER);
        jLabel10.setVerticalAlignment(jLabel23.CENTER);
        
        jPanel15.setLayout(new BorderLayout());
        jPanel15.setBackground(Color.white);
        dm_exam = new DefaultTableModel();
        dm_exam.addColumn("ID");
        dm_exam.addColumn("Exam");
        dm_exam.addColumn("Date");
        dm_exam.addColumn("Until");
        dm_exam.addColumn("Questions");
        dm_exam.addColumn("Points");
        dm_exam.addColumn("Action");
        
        table_exam = new JTable(dm_exam);
        table_exam.getColumn("Action").setCellRenderer(new ButtonRenderer());
        table_exam.getColumn("Action").setCellEditor(new ButtonEditor(new JCheckBox()));
        
        table_exam.setDefaultEditor(Object.class, null);
        table_exam.setBackground(Color.white);
        table_exam.setRowHeight(50);
        table_exam.setRowSelectionAllowed(false);
        table_exam.setCellSelectionEnabled(false);
        table_exam.setColumnSelectionAllowed(false);
        table_exam.getColumn("ID").setPreferredWidth(5);
        table_exam.getColumn("ID").setWidth(5);
        table_exam.getColumn("ID").setResizable(false);
        table_exam.getColumn("Exam").setResizable(false);
        table_exam.getColumn("Action").setResizable(false);
        table_exam.getColumn("Points").setResizable(false);
        table_exam.getColumn("Questions").setResizable(false);
        table_exam.getColumn("Date").setResizable(false);
        table_exam.getColumn("Until").setResizable(false);
        table_exam.getTableHeader().setReorderingAllowed(false);
        
        jPanel16.setLayout(new BorderLayout());
        jPanel16.setBackground(Color.white);
        
        dm_results = new DefaultTableModel();
        dm_results.addColumn("ID");
        dm_results.addColumn("Exam");
        dm_results.addColumn("Date");
        dm_results.addColumn("Questions");
        dm_results.addColumn("Achieved Points");
        dm_results.addColumn("Max Points");
        dm_results.addColumn("Note");
        
        table_results = new JTable(dm_results);
                
        table_results.setDefaultEditor(Object.class, null);
        table_results.setBackground(Color.white);
        table_results.setRowHeight(50);
        table_results.setRowSelectionAllowed(false);
        table_results.setCellSelectionEnabled(false);
        table_results.setColumnSelectionAllowed(false);
        table_results.getColumn("ID").setPreferredWidth(5);
        table_results.getColumn("ID").setWidth(5);
        table_results.getColumn("ID").setResizable(false);
        table_results.getColumn("Exam").setResizable(false);
        table_results.getColumn("Achieved Points").setResizable(false);
        table_results.getColumn("Questions").setResizable(false);
        table_results.getColumn("Date").setResizable(false);
        table_results.getColumn("Note").setResizable(false);
        table_results.getColumn("Max Points").setResizable(false);
        table_results.getTableHeader().setReorderingAllowed(false);
                   
        JScrollPane scroll = new JScrollPane(table_results);
        jPanel16.add(scroll, BorderLayout.CENTER);
        jPanel16.setPreferredSize(new Dimension(1300, 220));
                   
        JScrollPane scroll2 = new JScrollPane(table_exam);
        jPanel15.add(scroll2, BorderLayout.CENTER);
        
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
        jPanel21 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel16 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jTabbedPane5 = new javax.swing.JTabbedPane();
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
        jPanel17 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setOpaque(true);
        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

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
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

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
        jButton8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1302, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 641, Short.MAX_VALUE)
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

        jPanel16.setBackground(java.awt.Color.white);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1302, Short.MAX_VALUE)
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 641, Short.MAX_VALUE)
        );

        jTabbedPane4.addTab("tab1", jPanel16);

        jLabel8.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel8.setForeground(java.awt.Color.gray);
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("<html>Unfortunately there is no Exam for this Application.<br>Check back again later</html>");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 1302, Short.MAX_VALUE)
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("tab2", jPanel22);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane4)
        );

        jTabbedPane1.addTab("tab4", jPanel5);

        jPanel9.setBackground(java.awt.Color.white);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jButton4.setText("Save");
        jButton4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(85, 85, 85)));
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton4MousePressed(evt);
            }
        });

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
                .addContainerGap(698, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        jTabbedPane5.addTab("tab1", jPanel10);

        jLabel24.setFont(new java.awt.Font("Ubuntu Light", 0, 18)); // NOI18N
        jLabel24.setForeground(java.awt.Color.gray);
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("<html>Unfortunately you have no rights to access this section.<br>Administrators only!</html>");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, 1302, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(268, 268, 268)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("tab2", jPanel17);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane5)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane5)
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

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        OADTurkUI login = new OADTurkUI(session);
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
    
    public void loadSettings()
    {
        jTextField5.setText(session.manager.users.get(session.id).first_name);
        jTextField6.setText(session.manager.users.get(session.id).surname);
        jTextField7.setText(session.manager.users.get(session.id).user);
        jTextField8.setText(session.manager.users.get(session.id).mail);
        jPasswordField3.setText("");
    }
    
    public void loadResults()
    {
        selected_la = jTabbedPane4.getSelectedIndex();
        LearningApp lapp = manager.la.get(jTabbedPane4.getSelectedIndex());
                
        if (dm_results.getRowCount() > 0) 
        {
            for (int i = dm_results.getRowCount() - 1; i > -1; i--) 
            {
                dm_results.removeRow(i);
            }
        }
       
        for(int i = 0; i < session.manager.users.get(session.id).finished_exams.size(); i++)
        {
            int id = session.manager.users.get(session.id).finished_exams.get(i).exam_id;
            int exlid = session.manager.users.get(session.id).finished_exams.get(i).laid;
            
            if(exlid == selected_la)
            {
                Exam ex = lapp.exam.get(id);
                ExamResults exre = session.manager.users.get(session.id).finished_exams.get(i);
                DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                Calendar cal = ex.date;

                float points = exre.points;
                float max_points = ex.points_per_question * ex.num_of_questions;

                float percentage = points/max_points * 100;

                String note = "";

                if(percentage < 50)
                    note = "Not Sufficient (5)";
                else if(percentage >= 50 && percentage < 62)
                    note = "Inufficient (4)";
                else if(percentage >= 62 && percentage < 75)
                    note = "Good (3)";
                else if(percentage >= 75 && percentage < 87)
                    note = "Very Good (2)";
                else if(percentage >= 87)
                    note = "Excellent (1)";                       


                Object[] row = {id, ex.name, dateFormat.format(cal.getTime()), ex.num_of_questions, exre.points, ex.points_per_question * ex.num_of_questions, note};
                dm_results.addRow(row);
            }
           
            
        }
        
        JButton butt = new JButton();
        butt.setFocusPainted(false);
        butt.setContentAreaFilled(false);
        butt.setFont(new java.awt.Font("Ubuntu Light", 0, 14)); // NOI18N
        butt.setForeground(java.awt.Color.black);
        butt.setText("EXPORT RESULTS");
        butt.setPreferredSize(new Dimension(300, 50));
        butt.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.black));
        butt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        
        jPanel16.add(butt, BorderLayout.AFTER_LAST_LINE);
    }
    
              
    public void loadExams()
    {
        selected_la = jTabbedPane3.getSelectedIndex();
        LearningApp lapp = manager.la.get(jTabbedPane3.getSelectedIndex());

        if (dm_exam.getRowCount() > 0) 
        {
            for (int i = dm_exam.getRowCount() - 1; i > -1; i--) 
            {
                dm_exam.removeRow(i);
            }
        }
       
        for(HashMap.Entry<Integer, Exam> entry : lapp.exam.entrySet())
        {
            Exam ex = entry.getValue();
            int id = entry.getKey();
            DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            Calendar cal = ex.date;
            Calendar until = ex.until;
            Calendar current = Calendar.getInstance();
            current.setTime(new Date());

            if(current.before(until) && !session.manager.examAlreadyFinished(session.id, selected_la, id))
            {
                String text = "Register";

                for(int i = 0; i < session.manager.users.get(session.id).registered_exams.size(); i++)
                {
                    RegisteredExam rex = session.manager.users.get(session.id).registered_exams.get(i);
                    if(rex.laid == selected_la && rex.exid == id && current.after(cal))
                    {
                        text = "Start";
                        break;
                    }
                    else if(rex.laid == selected_la && rex.exid == id)
                    {
                        text = "Unregister";
                        break;
                    }
                }
                    

                Object[] row = {id, ex.name, dateFormat.format(cal.getTime()), dateFormat.format(until.getTime()) , ex.num_of_questions, ex.points_per_question * ex.num_of_questions, text};
                dm_exam.addRow(row);
            }  
        }
       
        
    }
    
    
    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
       
        if(jTabbedPane1.getSelectedIndex() == 2)
        {
            loadExams();
        }
        else if(jTabbedPane1.getSelectedIndex() == 3)
        {
            loadResults();
        }
        else if(jTabbedPane1.getSelectedIndex() == 4)
        {
            loadSettings();
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

    private void jButton4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MousePressed
        // TODO add your handling code here:
        char[] text1 = jPasswordField3.getPassword();
        String text = new String(text1);
        
        if(text.equals(session.manager.users.get(session.id).password))
        {
            char[] text2 = jPasswordField4.getPassword();
            String text3 = new String(text2);
            
            if(text.equals(text3))
            {
                JOptionPane.showMessageDialog(rootPane, "Old and new password can not be the same!", "Wrong new password", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            if(text3.length() < 4 && text3.length() != 0) 
            {
                JOptionPane.showMessageDialog(rootPane, "Password must be at least 5 chracters long!", "Wrong new password", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            String fn = jTextField5.getText();
            String sn = jTextField6.getText();
            String u = jTextField7.getText();
            String m = jTextField8.getText();
            String p;
            
            if(text3.length() != 0)
                p = text3;
            else
                p = text;
            
            String n = fn + " " + sn;
            
            session.manager.updateUserSettings(session.id, u, n, fn, sn, m, p, session.id, session.manager.users.get(session.id).level);
            
            jLabel1.setText(session.manager.users.get(session.id).name + " (" + session.getLevelText() + ")");
            
            JOptionPane.showMessageDialog(rootPane, "You successfuly saved your data!");
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "You entered the wrong password!", "Wrong password", JOptionPane.ERROR_MESSAGE);
        }
        
        jPasswordField3.setText("");
        jPasswordField4.setText("");
    }//GEN-LAST:event_jButton4MousePressed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        
        if(manager.creator_applications.containsKey(session.id))
        {
            int answer = JOptionPane.showConfirmDialog(rootPane, "You already applied to be a creator\nDo you want to withdraw your application?\n\n", "Creator application", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                
            if(answer == 0)
            {
                manager.deleteCreatorApplication(session.id);
                JOptionPane.showMessageDialog(rootPane, "You successfuly withdrawed your Creator application!");
            }
        }
        else
        {
          String answer = JOptionPane.showInputDialog(rootPane, "Hi, \nwe are glad that you decided to apply to be a creator.\nWe want to know why you would like to become one.\n\nPlease describe your application reasons:", "Creator application", JOptionPane.QUESTION_MESSAGE);  
          
          
          if(answer != null)
          {
            manager.addCreatorApplication(session.id, answer);
            JOptionPane.showMessageDialog(rootPane, "You successfuly applied to be a creator!"); 
          }
          else
          {
            JOptionPane.showMessageDialog(rootPane, "You canceled your application!"); 
          }
        }
        
    }//GEN-LAST:event_jButton2MouseClicked

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
    private javax.swing.JLabel jLabel24;
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
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
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
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
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

class ButtonRenderer extends JButton implements TableCellRenderer {

  public ButtonRenderer() {
    setOpaque(true);
  }

  public Component getTableCellRendererComponent(JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column) {
    if (isSelected) {
      setForeground(table.getSelectionForeground());
      setBackground(table.getSelectionBackground());
    } else {
      setForeground(table.getForeground());
      setBackground(UIManager.getColor("Button.background"));
    }
    setText((value == null) ? "" : value.toString());
    return this;
  }
}

/**
 * @version 1.0 11/09/98
 */

class ButtonEditor extends DefaultCellEditor {
  protected JButton button;

  private String label;

  private boolean isPushed;
  
  private int exam_id;

  public ButtonEditor(JCheckBox checkBox) {
    super(checkBox);
    button = new JButton();
    button.setOpaque(true);
    
    
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        fireEditingStopped();
      }
    });
  }

  public Component getTableCellEditorComponent(JTable table, Object value,
      boolean isSelected, int row, int column) {
     
    label = (value == null) ? "" : value.toString();
    button.setText(label);
    isPushed = true;
    exam_id = Integer.parseInt(table.getModel().getValueAt(row, 0).toString());
    return button;
  }

  @Override
  public Object getCellEditorValue() {
    
    if (isPushed) 
    {
        LearningApp lapp = OADTurkUserUI.manager.la.get(OADTurkUserUI.selected_la);
        Exam exam = lapp.exam.get(exam_id);
        Calendar start = exam.date;
        Calendar end = exam.until;
        Calendar current = Calendar.getInstance();
        current.setTime(new Date());
        
        if(button.getText().equals("Register"))
        {
            if(current.before(start))
            {
                int answer = JOptionPane.showConfirmDialog(button, "Are you sure that you want to register for an exam?\n", "Exam registration", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                
                if(answer == 0)
                {
                    JOptionPane.showMessageDialog(button, "You successfuly registered for exam!\n\nIn order to attend the exam save your exam entry code: " + exam.code);
                    OADTurkUserUI.session.manager.registerForExam(OADTurkUserUI.session.id, OADTurkUserUI.selected_la, exam_id);
                    button.setText("Unregister");
                    label = "Unregister";
                    return new String(label);
                }
            
            }
            else
            {
                JOptionPane.showMessageDialog(button, "You are not able to register for this exam!\n\nThis Exam has already started!", "Exam registration", JOptionPane.ERROR_MESSAGE);
            }
        
        }
        
        if(button.getText().equals("Unregister"))
        {
            if(current.before(start))
            {
                int answer = JOptionPane.showConfirmDialog(button, "Are you sure that you want to unregister from an exam?\n", "Exam registration", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                
                if(answer == 0)
                {
                    JOptionPane.showMessageDialog(button, "You successfuly unregistered from exam!");
                    OADTurkUserUI.session.manager.deleteRegisteredExam(OADTurkUserUI.session.id, OADTurkUserUI.selected_la, exam_id);
                    button.setText("Register");
                    label = "Register";
                    return new String(label);
                }
            
            }
            else
            {
                JOptionPane.showMessageDialog(button, "You are not able to unregister from this exam!\n\nThis Exam has already started!", "Exam registration", JOptionPane.ERROR_MESSAGE);
            }
        
        }
        
        if(button.getText().equals("Start"))
        {
            if(current.before(start))
            {
                JOptionPane.showMessageDialog(button, "You can not attend the exam!\n\nThis Exam has not started!", "Exam start", JOptionPane.ERROR_MESSAGE);
            }
            else if(current.after(start) && current.before(end))
            {
      
                String code = JOptionPane.showInputDialog(button, "Pleas enter your exam code in order to attend the exam: ");
                
                try
                {
                    int num = Integer.parseInt(code);
                    
                    if(num == exam.code)
                    {
                        OADTurkExamUI user = new OADTurkExamUI(OADTurkUserUI.session, OADTurkUserUI.selected_la, exam_id);
                        user.setVisible(true);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(button, "You can not attend the exam!\n\nYou entered the wrong exam code!", "Exam start", JOptionPane.ERROR_MESSAGE);
                    }
                } 
                catch (NumberFormatException e) 
                {
                    JOptionPane.showMessageDialog(button, "You can not attend the exam!\n\nYou entered the wrong exam code!", "Exam start", JOptionPane.ERROR_MESSAGE);
                }
                
            }
            else if(current.after(end))
            {
                JOptionPane.showMessageDialog(button, "You are not able to attend this exam!\n\nThis Exam is already finished!", "Exam start", JOptionPane.ERROR_MESSAGE);
            }
        
        }
        
    }
    isPushed = false;
    
    return new String(label);
  }

  @Override
  public boolean stopCellEditing() {
    isPushed = false;
    return super.stopCellEditing();
  }

  @Override
  protected void fireEditingStopped() {
    super.fireEditingStopped();
  }
}