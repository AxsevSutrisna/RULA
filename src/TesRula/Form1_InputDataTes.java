/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesRula;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author asutr
 */
public class Form1_InputDataTes extends javax.swing.JFrame {
    
    int xx , xy;
    
    //Set Databases
    Connection con = null;
    Statement st = null;
    
    public void inputdata(){
        
        try {
            if (NimTxt.getText().equals("") || Namatxt.getText().equals("") || PekerjaanTxt.getText().equals("") || ComboBoxKelamin.getSelectedItem().equals("")
                ||NoTelpTxt.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Data Tidak Boleh Kosong", "Pesan", JOptionPane.ERROR_MESSAGE);
                hapuslayar();
            } else {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/rula_project","root","");
                st = con.createStatement();
                
                String simpan = "INSERT INTO t_rula VALUES ('"+ NimTxt.getText() + "','" + Namatxt.getText() +  "','" 
                                + PekerjaanTxt.getText() + "','" 
                                + ComboBoxKelamin.getSelectedItem() + "','" + NoTelpTxt.getText() + "','" + "" + 
                        "','" + "" + "','" + "" + "','" +
                        "" + "','" + "" + "','" +
                        "" + "','" + "" + "','" +
                        "" + "','" + "" + "','" + "" + "')";
                
                String simpanAjust = "INSERT INTO t_adjustdata VALUES ('"+ NimTxt.getText() + "','" + "" +  "','" 
                                + "" + "','" + "" + "','" + "" + "','" + "" + "','" + "" + "','" + "" + "','" + "" + "','" + ""
                        + "','" + "" + "','" + "" + "','" + "" + "','" + "" + "','" + "" + "','" + "" + "','" + "" + "')";
                
                st = con.createStatement();
                
                int SA = st.executeUpdate(simpan);
                int SA2 = st.executeUpdate(simpanAjust);
                JOptionPane.showMessageDialog(this, "Registrasi Berhasil");
                this.setVisible(false);
                new Form2_ProsesRulaTes().setVisible(true);
            }
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "NIM Sudah ada / Duplikat", "Pesan",JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public Form1_InputDataTes() {
        initComponents();
        
        setExtendedState(JFrame.MAXIMIZED_HORIZ);
        setVisible(true);
        setResizable(false);
        
    }
    
    private void hapuslayar(){
        NimTxt.setText("");
        Namatxt.setText("");
        PekerjaanTxt.setText("");
        ComboBoxKelamin.getSelectedItem();
        NoTelpTxt.setText("");
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        TitlePanel = new javax.swing.JPanel();
        LabelJudul = new javax.swing.JLabel();
        NoLBL = new javax.swing.JLabel();
        PanelNo = new javax.swing.JPanel();
        NamaIcon = new javax.swing.JLabel();
        NimTxt = new javax.swing.JTextField();
        NamaLBL1 = new javax.swing.JLabel();
        PanelNama1 = new javax.swing.JPanel();
        Namatxt = new javax.swing.JTextField();
        NamaIcon1 = new javax.swing.JLabel();
        PekerjaanLBL = new javax.swing.JLabel();
        PanelPekerjaan = new javax.swing.JPanel();
        PekerjaanTxt = new javax.swing.JTextField();
        PekerjaanIcon = new javax.swing.JLabel();
        DepartementLBL = new javax.swing.JLabel();
        PanelDepartement = new javax.swing.JPanel();
        DepartementIcon = new javax.swing.JLabel();
        ComboBoxKelamin = new javax.swing.JComboBox<>();
        CompanyLBL = new javax.swing.JLabel();
        PanelCompany = new javax.swing.JPanel();
        NoTelpTxt = new javax.swing.JTextField();
        CompanyIcon = new javax.swing.JLabel();
        PanelEnter = new GUI_Custom.PanelRound();
        BtnMasuk = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(0, 255, 0));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        getContentPane().setLayout(new java.awt.CardLayout());

        MainPanel.setBackground(new java.awt.Color(124, 150, 171));
        MainPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.darkGray, java.awt.Color.darkGray, java.awt.Color.darkGray, java.awt.Color.darkGray));
        MainPanel.setForeground(new java.awt.Color(204, 204, 204));
        MainPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                MainPanelMouseMoved(evt);
            }
        });
        MainPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MainPanelMousePressed(evt);
            }
        });

        TitlePanel.setBackground(new java.awt.Color(191, 204, 181));
        TitlePanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        LabelJudul.setBackground(new java.awt.Color(191, 204, 181));
        LabelJudul.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        LabelJudul.setForeground(new java.awt.Color(255, 255, 255));
        LabelJudul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LabelJudul.setText("Rapid Upper Limb Assesment (RULA)");
        LabelJudul.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));
        LabelJudul.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout TitlePanelLayout = new javax.swing.GroupLayout(TitlePanel);
        TitlePanel.setLayout(TitlePanelLayout);
        TitlePanelLayout.setHorizontalGroup(
            TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LabelJudul, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        TitlePanelLayout.setVerticalGroup(
            TitlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TitlePanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(LabelJudul, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        NoLBL.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        NoLBL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NoLBL.setText("NIM");

        PanelNo.setBackground(new java.awt.Color(191, 204, 181));
        PanelNo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        NamaIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NamaIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/id.png"))); // NOI18N

        NimTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        NimTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NimTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelNoLayout = new javax.swing.GroupLayout(PanelNo);
        PanelNo.setLayout(PanelNoLayout);
        PanelNoLayout.setHorizontalGroup(
            PanelNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelNoLayout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(NamaIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NimTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelNoLayout.setVerticalGroup(
            PanelNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNoLayout.createSequentialGroup()
                .addGroup(PanelNoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(NamaIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(NimTxt))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        NamaLBL1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        NamaLBL1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NamaLBL1.setText("Nama");

        PanelNama1.setBackground(new java.awt.Color(191, 204, 181));
        PanelNama1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        Namatxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        NamaIcon1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NamaIcon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/name_user_3716.png"))); // NOI18N

        javax.swing.GroupLayout PanelNama1Layout = new javax.swing.GroupLayout(PanelNama1);
        PanelNama1.setLayout(PanelNama1Layout);
        PanelNama1Layout.setHorizontalGroup(
            PanelNama1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelNama1Layout.createSequentialGroup()
                .addGap(0, 10, Short.MAX_VALUE)
                .addComponent(NamaIcon1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Namatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelNama1Layout.setVerticalGroup(
            PanelNama1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelNama1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(Namatxt, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(NamaIcon1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        PekerjaanLBL.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        PekerjaanLBL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PekerjaanLBL.setText("Pekerjaan");

        PanelPekerjaan.setBackground(new java.awt.Color(191, 204, 181));
        PanelPekerjaan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        PekerjaanTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        PekerjaanIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PekerjaanIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Pekerjaan.png"))); // NOI18N

        javax.swing.GroupLayout PanelPekerjaanLayout = new javax.swing.GroupLayout(PanelPekerjaan);
        PanelPekerjaan.setLayout(PanelPekerjaanLayout);
        PanelPekerjaanLayout.setHorizontalGroup(
            PanelPekerjaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPekerjaanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PekerjaanIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PekerjaanTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelPekerjaanLayout.setVerticalGroup(
            PanelPekerjaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PekerjaanTxt)
            .addGroup(PanelPekerjaanLayout.createSequentialGroup()
                .addComponent(PekerjaanIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        DepartementLBL.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        DepartementLBL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DepartementLBL.setText("Jenis Kelamin");

        PanelDepartement.setBackground(new java.awt.Color(191, 204, 181));
        PanelDepartement.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        DepartementIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DepartementIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/kelamin.png"))); // NOI18N

        ComboBoxKelamin.setEditable(true);
        ComboBoxKelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "                 ", "Laki-Laki", "Perempuan", " " }));
        ComboBoxKelamin.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ComboBoxKelamin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxKelaminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelDepartementLayout = new javax.swing.GroupLayout(PanelDepartement);
        PanelDepartement.setLayout(PanelDepartementLayout);
        PanelDepartementLayout.setHorizontalGroup(
            PanelDepartementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDepartementLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DepartementIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ComboBoxKelamin, 0, 197, Short.MAX_VALUE))
        );
        PanelDepartementLayout.setVerticalGroup(
            PanelDepartementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDepartementLayout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addComponent(DepartementIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(ComboBoxKelamin)
        );

        CompanyLBL.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        CompanyLBL.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CompanyLBL.setText("No Telepon");

        PanelCompany.setBackground(new java.awt.Color(191, 204, 181));
        PanelCompany.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        NoTelpTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        CompanyIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        CompanyIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Telepon.png"))); // NOI18N

        javax.swing.GroupLayout PanelCompanyLayout = new javax.swing.GroupLayout(PanelCompany);
        PanelCompany.setLayout(PanelCompanyLayout);
        PanelCompanyLayout.setHorizontalGroup(
            PanelCompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelCompanyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CompanyIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(NoTelpTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        PanelCompanyLayout.setVerticalGroup(
            PanelCompanyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(NoTelpTxt)
            .addComponent(CompanyIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        PanelEnter.setBackground(new java.awt.Color(124, 150, 171));
        PanelEnter.setRoundBottomLeft(25);
        PanelEnter.setRoundBottomRight(25);
        PanelEnter.setRoundTopLeft(25);
        PanelEnter.setRoundTopRight(25);

        BtnMasuk.setBackground(new java.awt.Color(191, 204, 181));
        BtnMasuk.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        BtnMasuk.setText("Simpan");
        BtnMasuk.setContentAreaFilled(false);
        BtnMasuk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnMasuk.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                BtnMasukMouseMoved(evt);
            }
        });
        BtnMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnMasukActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelEnterLayout = new javax.swing.GroupLayout(PanelEnter);
        PanelEnter.setLayout(PanelEnterLayout);
        PanelEnterLayout.setHorizontalGroup(
            PanelEnterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelEnterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnMasuk)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelEnterLayout.setVerticalGroup(
            PanelEnterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BtnMasuk, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout MainPanelLayout = new javax.swing.GroupLayout(MainPanel);
        MainPanel.setLayout(MainPanelLayout);
        MainPanelLayout.setHorizontalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TitlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PekerjaanLBL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DepartementLBL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CompanyLBL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NamaLBL1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(NoLBL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelEnter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(181, 181, 181))
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelNo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelPekerjaan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelDepartement, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelCompany, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelNama1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        MainPanelLayout.setVerticalGroup(
            MainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MainPanelLayout.createSequentialGroup()
                .addComponent(TitlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(NoLBL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(NamaLBL1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelNama1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(PekerjaanLBL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelPekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(DepartementLBL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelDepartement, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(CompanyLBL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelCompany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(PanelEnter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(69, 69, 69))
        );

        getContentPane().add(MainPanel, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        
    }//GEN-LAST:event_formMousePressed

    private void MainPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MainPanelMousePressed
        // TODO add your handling code here:
        xx = evt.getX();
        xy = evt.getY();
    }//GEN-LAST:event_MainPanelMousePressed

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x = xx, y = xy);
    }//GEN-LAST:event_formMouseDragged

    private void NimTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NimTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NimTxtActionPerformed

    private void BtnMasukMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnMasukMouseMoved
        // TODO add your handling code here:
        PanelEnter.setBackground(Color.BLUE);
        BtnMasuk.setForeground(Color.WHITE);
    }//GEN-LAST:event_BtnMasukMouseMoved

    private void BtnMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnMasukActionPerformed
        // TODO add your handling code here:
        inputdata();
    }//GEN-LAST:event_BtnMasukActionPerformed

    private void MainPanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MainPanelMouseMoved
        // TODO add your handling code here:
        PanelEnter.setBackground(new java.awt.Color(191,204,181));
        BtnMasuk.setForeground(Color.BLACK);
    }//GEN-LAST:event_MainPanelMouseMoved

    private void ComboBoxKelaminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxKelaminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxKelaminActionPerformed

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
            java.util.logging.Logger.getLogger(Form1_InputDataTes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form1_InputDataTes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form1_InputDataTes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form1_InputDataTes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form1_InputDataTes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnMasuk;
    private javax.swing.JComboBox<String> ComboBoxKelamin;
    private javax.swing.JLabel CompanyIcon;
    private javax.swing.JLabel CompanyLBL;
    private javax.swing.JLabel DepartementIcon;
    private javax.swing.JLabel DepartementLBL;
    private javax.swing.JLabel LabelJudul;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JLabel NamaIcon;
    private javax.swing.JLabel NamaIcon1;
    private javax.swing.JLabel NamaLBL1;
    private javax.swing.JTextField Namatxt;
    public static javax.swing.JTextField NimTxt;
    private javax.swing.JLabel NoLBL;
    private javax.swing.JTextField NoTelpTxt;
    private javax.swing.JPanel PanelCompany;
    private javax.swing.JPanel PanelDepartement;
    private GUI_Custom.PanelRound PanelEnter;
    private javax.swing.JPanel PanelNama1;
    private javax.swing.JPanel PanelNo;
    private javax.swing.JPanel PanelPekerjaan;
    private javax.swing.JLabel PekerjaanIcon;
    private javax.swing.JLabel PekerjaanLBL;
    private javax.swing.JTextField PekerjaanTxt;
    private javax.swing.JPanel TitlePanel;
    // End of variables declaration//GEN-END:variables
}
