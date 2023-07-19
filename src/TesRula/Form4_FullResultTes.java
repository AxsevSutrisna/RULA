/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesRula;

import Koneksi.koneksi;
import static TesRula.Form3_ResultTes.ScoreFinal;
import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author asutr
 */
public class Form4_FullResultTes extends javax.swing.JFrame {

    /**
     * Creates new form Form4_FullResultTes
     */
    
    Connection con =null;
    Statement st = null;
    
    private void tampilkan_dataA(){
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("UpperArm");
        model.addColumn("LowerArm");
        model.addColumn("Wrist");
        model.addColumn("WristTwist");
        model.addColumn("Muscle And Load");
        
        try {
            String sql="SELECT * FROM t_rula WHERE nim ='" + Form1_InputDataTes.NimTxt.getText() + "'";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while(res.next()){
                model.addRow(new Object[]{res.getString(6),res.getString(7),res.getString(8),res.getString(9),res.getString(13)});
            }
            TabelGrupA.setModel(model);
            
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    private void tampilkan_dataB(){
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Neck");
        model.addColumn("Trunk");
        model.addColumn("Leg");
        model.addColumn("Muscle And Load");
       
        
        try {
            String sql="SELECT * FROM t_rula WHERE nim ='" + Form1_InputDataTes.NimTxt.getText() + "'";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while(res.next()){
                model.addRow(new Object[]{res.getString(10),res.getString(11),res.getString(12),res.getString(14)});
            }
            TabelGrupB.setModel(model);
            
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public void tampilkan_personal() {
        try{
            String sql="SELECT * FROM t_rula WHERE nim ='" + Form1_InputDataTes.NimTxt.getText() + "'";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                String Nim = res.getString("nim");
                String Nama = res.getString("nama");
                String Pekerjaan = res.getString("pekerjaan");
                String JenisKelamin = res.getString("jeniskelamin");
                String NoTelepon = res.getString("no_telepon");
                LabelNim.setText(Nim);
                LabelNama.setText(Nama);
                LabelPekerjaan.setText(Pekerjaan);
                LabelKelamin.setText(JenisKelamin);
                LabelTelepon.setText(NoTelepon);
            }
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    public void WarnaPanel(){
                if (ScoreFinal.getText().equals("1") || ScoreFinal.getText().equals("2")) {
                    PanelScoreRula.setBackground(new java.awt.Color(40,167,69));
                }
                else if (ScoreFinal.getText().equals("3") || ScoreFinal.getText().equals("4")) {
                    PanelScoreRula.setBackground(new java.awt.Color(0,123,255));
                }
                else if (ScoreFinal.getText().equals("5") || ScoreFinal.getText().equals("6")) {
                    PanelScoreRula.setBackground(new java.awt.Color(255,193,7));
                }
                else if (ScoreFinal.getText().equals("7")) {
                    PanelScoreRula.setBackground(new java.awt.Color(220,53,69));
                }
        
    }
    
    public void tampilkan_identitas() {
        LabelIdentitas.setText("NIM: " + Form1_InputDataTes.NimTxt.getText());
    }
    
    public void FinalScore(){
        LabelFinalScoreRula.setText(Form3_ResultTes.ScoreFinal.getText());
    }
    
    public Form4_FullResultTes() {
        initComponents();
        
        //Tampilkan NIM primary key user
        tampilkan_identitas();
        
        setExtendedState(JFrame.MAXIMIZED_HORIZ);
        setVisible(true);
        setResizable(false);
        
        //Menampilkan Data Dari Grup A dan B
        tampilkan_dataA();
        tampilkan_dataB();
        tampilkan_personal();
        
        WarnaPanel();
        FinalScore();
        
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
        PanelBack = new GUI_Custom.PanelRound();
        ButtonBack = new javax.swing.JButton();
        TitelPanel = new javax.swing.JPanel();
        txtTitle = new javax.swing.JLabel();
        LabelIdentitas = new javax.swing.JLabel();
        LabelFullResult = new javax.swing.JLabel();
        LabelScoreA = new javax.swing.JLabel();
        JTabelGrupA = new javax.swing.JScrollPane();
        TabelGrupA = new GUI_Custom.TableDark();
        LabelScoreB = new javax.swing.JLabel();
        JTabelGrupB = new javax.swing.JScrollPane();
        TabelGrupB = new GUI_Custom.TableDark();
        PanelIdentitas = new GUI_Custom.PanelRound();
        NoTelepon = new javax.swing.JLabel();
        LabelNim = new javax.swing.JLabel();
        LabelTelepon = new javax.swing.JLabel();
        LabelTanda = new javax.swing.JLabel();
        Nama = new javax.swing.JLabel();
        Pekerjaan = new javax.swing.JLabel();
        JenisKelamin = new javax.swing.JLabel();
        LabelNama = new javax.swing.JLabel();
        LabelPekerjaan = new javax.swing.JLabel();
        LabelKelamin = new javax.swing.JLabel();
        Nim = new javax.swing.JLabel();
        LabelTanda3 = new javax.swing.JLabel();
        LabelTanda4 = new javax.swing.JLabel();
        LabelTanda2 = new javax.swing.JLabel();
        LabelTanda1 = new javax.swing.JLabel();
        LabelScoreB1 = new javax.swing.JLabel();
        PanelScoreRula = new GUI_Custom.PanelRound();
        LabelFinalScoreRula = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(124, 150, 171));
        jPanel1.setMaximumSize(new java.awt.Dimension(1042, 575));
        jPanel1.setMinimumSize(new java.awt.Dimension(1042, 575));
        jPanel1.setPreferredSize(new java.awt.Dimension(1040, 480));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel1MouseMoved(evt);
            }
        });

        PanelBack.setBackground(new java.awt.Color(191, 204, 181));
        PanelBack.setRoundBottomLeft(25);
        PanelBack.setRoundBottomRight(25);
        PanelBack.setRoundTopLeft(25);
        PanelBack.setRoundTopRight(25);

        ButtonBack.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        ButtonBack.setForeground(new java.awt.Color(255, 255, 255));
        ButtonBack.setText("<<< BACK");
        ButtonBack.setContentAreaFilled(false);
        ButtonBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonBack.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                ButtonBackMouseMoved(evt);
            }
        });
        ButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelBackLayout = new javax.swing.GroupLayout(PanelBack);
        PanelBack.setLayout(PanelBackLayout);
        PanelBackLayout.setHorizontalGroup(
            PanelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBackLayout.createSequentialGroup()
                .addComponent(ButtonBack)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        PanelBackLayout.setVerticalGroup(
            PanelBackLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ButtonBack, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        TitelPanel.setBackground(new java.awt.Color(191, 204, 181));
        TitelPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        txtTitle.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        txtTitle.setText("RULA Appliication");

        LabelIdentitas.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        LabelIdentitas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelIdentitas.setText("jLabel2");

        javax.swing.GroupLayout TitelPanelLayout = new javax.swing.GroupLayout(TitelPanel);
        TitelPanel.setLayout(TitelPanelLayout);
        TitelPanelLayout.setHorizontalGroup(
            TitelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitelPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 542, Short.MAX_VALUE)
                .addComponent(LabelIdentitas, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
        TitelPanelLayout.setVerticalGroup(
            TitelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(LabelIdentitas))
        );

        LabelFullResult.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        LabelFullResult.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelFullResult.setText("FULL RESULT RULA");

        LabelScoreA.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        LabelScoreA.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelScoreA.setText("Skor Grup A (Lengan Atas, Lengan Bawah, Pergelangan dan Penggunaan Otot)");

        TabelGrupA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", "", "", null, null, null},
                {"", "", "", "", null, null, null},
                {"", "", "", "", null, null, null},
                {"", "", "", "", null, null, null},
                {"", "", "", "", null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "NIM", "Nama", "Alamat", "Umur", "Pekerjaan", "Jenis Kelamin", "No Telepon"
            }
        ));
        TabelGrupA.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        TabelGrupA.setMaximumSize(new java.awt.Dimension(525, 150));
        TabelGrupA.setMinimumSize(new java.awt.Dimension(525, 150));
        TabelGrupA.setPreferredScrollableViewportSize(new java.awt.Dimension(525, 150));
        TabelGrupA.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                TabelGrupAMouseMoved(evt);
            }
        });
        TabelGrupA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelGrupAMouseClicked(evt);
            }
        });
        JTabelGrupA.setViewportView(TabelGrupA);

        LabelScoreB.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        LabelScoreB.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelScoreB.setText("Skor Akhir");

        TabelGrupB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"", "", "", "", null, null, null},
                {"", "", "", "", null, null, null},
                {"", "", "", "", null, null, null},
                {"", "", "", "", null, null, null},
                {"", "", "", "", null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "NIM", "Nama", "Alamat", "Umur", "Pekerjaan", "Jenis Kelamin", "No Telepon"
            }
        ));
        TabelGrupB.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        TabelGrupB.setMaximumSize(new java.awt.Dimension(525, 150));
        TabelGrupB.setMinimumSize(new java.awt.Dimension(525, 150));
        TabelGrupB.setPreferredScrollableViewportSize(new java.awt.Dimension(525, 150));
        TabelGrupB.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                TabelGrupBMouseMoved(evt);
            }
        });
        TabelGrupB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelGrupBMouseClicked(evt);
            }
        });
        JTabelGrupB.setViewportView(TabelGrupB);

        PanelIdentitas.setBackground(new java.awt.Color(191, 204, 181));
        PanelIdentitas.setRoundBottomLeft(50);
        PanelIdentitas.setRoundBottomRight(50);
        PanelIdentitas.setRoundTopLeft(50);
        PanelIdentitas.setRoundTopRight(50);
        PanelIdentitas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        NoTelepon.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        NoTelepon.setForeground(new java.awt.Color(255, 255, 255));
        NoTelepon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        NoTelepon.setText("No Telepon");
        PanelIdentitas.add(NoTelepon, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 130, -1));

        LabelNim.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        LabelNim.setForeground(new java.awt.Color(255, 255, 255));
        LabelNim.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabelNim.setText("0");
        PanelIdentitas.add(LabelNim, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 310, -1));

        LabelTelepon.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        LabelTelepon.setForeground(new java.awt.Color(255, 255, 255));
        LabelTelepon.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabelTelepon.setText("0");
        PanelIdentitas.add(LabelTelepon, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 140, 310, -1));

        LabelTanda.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        LabelTanda.setForeground(new java.awt.Color(255, 255, 255));
        LabelTanda.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LabelTanda.setText(":");
        PanelIdentitas.add(LabelTanda, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 20, -1));

        Nama.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        Nama.setForeground(new java.awt.Color(255, 255, 255));
        Nama.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Nama.setText("Nama");
        PanelIdentitas.add(Nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 80, -1));

        Pekerjaan.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        Pekerjaan.setForeground(new java.awt.Color(255, 255, 255));
        Pekerjaan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Pekerjaan.setText("Pekerjaan");
        PanelIdentitas.add(Pekerjaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 90, -1));

        JenisKelamin.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        JenisKelamin.setForeground(new java.awt.Color(255, 255, 255));
        JenisKelamin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        JenisKelamin.setText("Jenis Kelamin");
        PanelIdentitas.add(JenisKelamin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 130, -1));

        LabelNama.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        LabelNama.setForeground(new java.awt.Color(255, 255, 255));
        LabelNama.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabelNama.setText("0");
        PanelIdentitas.add(LabelNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 310, -1));

        LabelPekerjaan.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        LabelPekerjaan.setForeground(new java.awt.Color(255, 255, 255));
        LabelPekerjaan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabelPekerjaan.setText("0");
        PanelIdentitas.add(LabelPekerjaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, 310, -1));

        LabelKelamin.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        LabelKelamin.setForeground(new java.awt.Color(255, 255, 255));
        LabelKelamin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LabelKelamin.setText("0");
        PanelIdentitas.add(LabelKelamin, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 310, -1));

        Nim.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        Nim.setForeground(new java.awt.Color(255, 255, 255));
        Nim.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Nim.setText("Nim");
        PanelIdentitas.add(Nim, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 40, -1));

        LabelTanda3.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        LabelTanda3.setForeground(new java.awt.Color(255, 255, 255));
        LabelTanda3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LabelTanda3.setText(":");
        PanelIdentitas.add(LabelTanda3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 20, -1));

        LabelTanda4.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        LabelTanda4.setForeground(new java.awt.Color(255, 255, 255));
        LabelTanda4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LabelTanda4.setText(":");
        PanelIdentitas.add(LabelTanda4, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 20, -1));

        LabelTanda2.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        LabelTanda2.setForeground(new java.awt.Color(255, 255, 255));
        LabelTanda2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LabelTanda2.setText(":");
        PanelIdentitas.add(LabelTanda2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 20, -1));

        LabelTanda1.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        LabelTanda1.setForeground(new java.awt.Color(255, 255, 255));
        LabelTanda1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        LabelTanda1.setText(":");
        PanelIdentitas.add(LabelTanda1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 50, 20, -1));

        LabelScoreB1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        LabelScoreB1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelScoreB1.setText("Skor Grup B (Leher, Punggung, Kaki Dan Penggunaan Otot)");

        PanelScoreRula.setBackground(new java.awt.Color(40, 167, 69));
        PanelScoreRula.setRoundBottomLeft(50);
        PanelScoreRula.setRoundBottomRight(50);
        PanelScoreRula.setRoundTopLeft(50);
        PanelScoreRula.setRoundTopRight(50);
        PanelScoreRula.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LabelFinalScoreRula.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        LabelFinalScoreRula.setForeground(new java.awt.Color(255, 255, 255));
        LabelFinalScoreRula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelFinalScoreRula.setText("0");
        PanelScoreRula.add(LabelFinalScoreRula, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TitelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(LabelFullResult, javax.swing.GroupLayout.PREFERRED_SIZE, 1040, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(PanelIdentitas, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(LabelScoreA, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(JTabelGrupA, javax.swing.GroupLayout.PREFERRED_SIZE, 970, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(LabelScoreB1, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(JTabelGrupB, javax.swing.GroupLayout.PREFERRED_SIZE, 970, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(750, 750, 750)
                .addComponent(LabelScoreB, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(PanelBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(610, 610, 610)
                .addComponent(PanelScoreRula, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TitelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(LabelFullResult)))
                .addGap(28, 28, 28)
                .addComponent(PanelIdentitas, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(LabelScoreA)
                .addGap(11, 11, 11)
                .addComponent(JTabelGrupA, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(LabelScoreB1)
                .addGap(11, 11, 11)
                .addComponent(JTabelGrupB, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(LabelScoreB)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(PanelBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(PanelScoreRula, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1042, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonBackMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButtonBackMouseMoved
        // TODO add your handling code here:
        PanelBack.setBackground(Color.BLUE);
    }//GEN-LAST:event_ButtonBackMouseMoved

    private void ButtonBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBackActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Form2_ProsesRulaTes().setVisible(true);
    }//GEN-LAST:event_ButtonBackActionPerformed

    private void jPanel1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseMoved
        // TODO add your handling code here:
        PanelBack.setBackground(new java.awt.Color(191,204,181));
    }//GEN-LAST:event_jPanel1MouseMoved

    private void TabelGrupAMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelGrupAMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_TabelGrupAMouseMoved

    private void TabelGrupAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelGrupAMouseClicked
        // TODO add your handling code here:
        // Ketika tabel ke tekan
    }//GEN-LAST:event_TabelGrupAMouseClicked

    private void TabelGrupBMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelGrupBMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_TabelGrupBMouseMoved

    private void TabelGrupBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelGrupBMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_TabelGrupBMouseClicked

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
            java.util.logging.Logger.getLogger(Form4_FullResultTes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form4_FullResultTes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form4_FullResultTes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form4_FullResultTes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form4_FullResultTes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBack;
    private javax.swing.JScrollPane JTabelGrupA;
    private javax.swing.JScrollPane JTabelGrupB;
    private javax.swing.JLabel JenisKelamin;
    private javax.swing.JLabel LabelFinalScoreRula;
    private javax.swing.JLabel LabelFullResult;
    private javax.swing.JLabel LabelIdentitas;
    private javax.swing.JLabel LabelKelamin;
    private javax.swing.JLabel LabelNama;
    private javax.swing.JLabel LabelNim;
    private javax.swing.JLabel LabelPekerjaan;
    private javax.swing.JLabel LabelScoreA;
    private javax.swing.JLabel LabelScoreB;
    private javax.swing.JLabel LabelScoreB1;
    private javax.swing.JLabel LabelTanda;
    private javax.swing.JLabel LabelTanda1;
    private javax.swing.JLabel LabelTanda2;
    private javax.swing.JLabel LabelTanda3;
    private javax.swing.JLabel LabelTanda4;
    private javax.swing.JLabel LabelTelepon;
    private javax.swing.JLabel Nama;
    private javax.swing.JLabel Nim;
    private javax.swing.JLabel NoTelepon;
    private GUI_Custom.PanelRound PanelBack;
    private GUI_Custom.PanelRound PanelIdentitas;
    private GUI_Custom.PanelRound PanelScoreRula;
    private javax.swing.JLabel Pekerjaan;
    private GUI_Custom.TableDark TabelGrupA;
    private GUI_Custom.TableDark TabelGrupB;
    private javax.swing.JPanel TitelPanel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables
}
