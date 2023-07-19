/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TesRula;

import Koneksi.koneksi;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author asutr
 */
public class Form2_ProsesRulaTes extends javax.swing.JFrame {

    /**
     * Creates new form MainRula
     */
    
    //Setting Database
    Connection con = null;
    Statement st = null;
    
    //Masukan Data LenganAtas
    public void InsertLenganAtas() {
        try {
            // Kondisi untuk menentukan posisi upper arm
            int upperarm = 0;
            int adjust = 0;
            int adjustUpper = 0;
            int adjustAUpper = 0;
            if (LenganAtas1.isSelected()) {
                upperarm = 1;
                adjustUpper = 1;
            } 
            else if (LenganAtas2.isSelected()) {
                upperarm = 2;
                adjustUpper = 2;
            }
            else if (LenganAtas3.isSelected()) {
                upperarm = 2;
                adjustUpper = 3;
            }
            else if (LenganAtas4.isSelected()) {
                upperarm = 3;
                adjustUpper = 4;
            }
            else if (LenganAtas5.isSelected()) {
                upperarm = 4;
                adjustUpper = 5;
            }
            if (TambahanUA1.isSelected() && TambahanUA2.isSelected() && TambahanUA3.isSelected()) {
                adjust = 1;
                adjustAUpper = 5;
            }
            else if (TambahanUA1.isSelected() && TambahanUA2.isSelected()) {
                adjust = 2;
                adjustAUpper = 3;
            } 
            else if (TambahanUA1.isSelected()) {
                adjust++;
                adjustAUpper = 1;
            } 
            else if (TambahanUA2.isSelected()) {
                adjust++;
                adjustAUpper = 2;
            } 
            else if (TambahanUA3.isSelected()) {
                adjust--;
                adjustAUpper = 4;
            }
            
            int SUpperArm = upperarm + adjust;
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/rula_project", "root" ,"");
            st=con.createStatement();
                
            // Untuk menyimpan ke database
            String simpan = "UPDATE t_rula SET upperarm ='" + SUpperArm + "' WHERE nim='" + Form1_InputDataTes.NimTxt.getText()+"'";
            
            // Untuk menyimpan ke database adjust
            String simpanAdjust = "UPDATE t_adjustdata SET upperarm ='" + adjustUpper + "',a_upperarm='" + adjustAUpper
                        + "' WHERE nim='" + Form1_InputDataTes.NimTxt.getText()+"'";
            int SA2 = st.executeUpdate(simpanAdjust);
            
            int SA = st.executeUpdate(simpan);
            JOptionPane.showMessageDialog(null, "Data Berhasil Tersimpan");
            
            
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            // Jika ada primary key yang sama
            JOptionPane.showMessageDialog(this, "Data gagal disimpan", "Pesan",
            JOptionPane.WARNING_MESSAGE);
        }
    }
    
    //Tampilkan Data LenganAtas
    public void DataUA(){ 
        
        try{
            String sql="SELECT * FROM t_adjustdata WHERE nim ='" + Form1_InputDataTes.NimTxt.getText() + "'";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                int UpperArm = res.getInt("upperarm");
                int AUpperArm = res.getInt("a_upperarm");
                if (UpperArm == 1) {
                    LenganAtas1.setSelected(true);
                }
                else if (UpperArm == 2) {
                    LenganAtas2.setSelected(true);
                }
                else if (UpperArm == 3) {
                    LenganAtas3.setSelected(true);
                }
                else if (UpperArm == 4) {
                    LenganAtas4.setSelected(true);
                }
                else if (UpperArm == 5) {
                    LenganAtas5.setSelected(true);
                }
                if (AUpperArm == 1) {
                    TambahanUA1.setSelected(true);
                }
                else if (AUpperArm == 2) {
                    TambahanUA2.setSelected(true);
                }
                else if (AUpperArm == 3) {
                    TambahanUA1.setSelected(true);
                    TambahanUA2.setSelected(true);
                }
                else if (AUpperArm == 4) {
                    TambahanUA3.setSelected(true);
                }
                else if (AUpperArm == 5) {
                    TambahanUA1.setSelected(true);
                    TambahanUA2.setSelected(true);
                    TambahanUA3.setSelected(true);
                }
                }
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    //Masukan Data LenganBawah
    public void InsertLenganBawah() {
        try {
            // Kondisi untuk menentukan posisi Lengan Bawah
            int lowerarm = 0;
            int adjust = 0;
            int adjustLower = 0;
            int adjustALower = 0;
            if (LenganBawah1.isSelected()) {
                lowerarm = 1;
                adjustLower = 1;
            } 
            else if (LenganBawah2.isSelected()) {
                lowerarm = 2;
                adjustLower = 2;
            }
            else if (LenganBawah3.isSelected()) {
                lowerarm = 2;
                adjustLower = 3;
            }
            if (TambahanLA.isSelected()) {
                adjust = 1;
                adjustALower = 1;
            }
            
            int SUpperArm = lowerarm + adjust;
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/rula_project", "root" ,"");
            st=con.createStatement();
                
            // Untuk menyimpan ke database
            String simpan = "UPDATE t_rula SET lowerarm ='" + SUpperArm + "' WHERE nim='" + Form1_InputDataTes.NimTxt.getText()+"'";
            
            // Untuk menyimpan ke database adjust
            String simpanAdjust = "UPDATE t_adjustdata SET lowerarm ='" + adjustLower + "',a_lowerarm='" + adjustALower
                        + "' WHERE nim='" + Form1_InputDataTes.NimTxt.getText()+"'";
            int SA2 = st.executeUpdate(simpanAdjust);
            
            int SA = st.executeUpdate(simpan);
            JOptionPane.showMessageDialog(null, "Data Berhasil Tersimpan");
            
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            // Jika ada primary key yang sama
            JOptionPane.showMessageDialog(this, "Data gagal disimpan", "Pesan",
            JOptionPane.WARNING_MESSAGE);
        }
    }
    
    //Tampilkan Data Lengan bawah
    public void DataLA(){ 
        
        try{
            String sql="SELECT * FROM t_adjustdata WHERE nim ='" + Form1_InputDataTes.NimTxt.getText() + "'";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                int LowerArm = res.getInt("lowerarm");
                int ALowerArm = res.getInt("a_lowerarm");
                if (LowerArm == 1) {
                    LenganBawah1.setSelected(true);
                }
                else if (LowerArm == 2) {
                    LenganBawah2.setSelected(true);
                }
                else if (LowerArm == 3) {
                    LenganBawah3.setSelected(true);
                }
                if (ALowerArm == 1) {
                    TambahanLA.setSelected(true);
                }
                }
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    //Masukan Data PergelanganTangan
    public void InsertPergelanganTangan() {
        try {
            // Kondisi untuk menentukan posisi dari pergelangan tangan
            int wrist = 0;
            int adjust = 0;
            int adjustWrist = 0;
            int adjustAWrist = 0;
            if (Pergelangan1.isSelected()) {
                wrist = 1;
                adjustWrist = 1;
            } 
            else if (Pergelangan2.isSelected()) {
                wrist = 2;
                adjustWrist = 2;
            }
            else if (Pergelangan3.isSelected()) {
                wrist = 3;
                adjustWrist = 3;
            }
            else if (Pergelangan4.isSelected()) {
                wrist = 3;
                adjustWrist = 4;
            }
            if (TambahanWrist.isSelected()) {
                adjust = 1;
                adjustAWrist = 1;
            }
            
            int SWrist = wrist + adjust;
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/rula_project", "root" ,"");
            st=con.createStatement();
                
            // Untuk menyimpan ke database t_rula
            String simpan = "UPDATE t_rula SET wrist ='" + SWrist + "' WHERE nim='" + Form1_InputDataTes.NimTxt.getText()+"'";
            
            // Untuk menyimpan ke database adjust_data
            String simpanAdjust = "UPDATE t_adjustdata SET wrist ='" + adjustWrist + "',a_wrist='" + adjustAWrist
                        + "' WHERE nim='" + Form1_InputDataTes.NimTxt.getText()+"'";
            int SA2 = st.executeUpdate(simpanAdjust);
            
            int SA = st.executeUpdate(simpan);
            JOptionPane.showMessageDialog(null, "Data Berhasil Tersimpan");
            
            
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            
            JOptionPane.showMessageDialog(this, "Data gagal disimpan", "Pesan",
            JOptionPane.WARNING_MESSAGE);
        }
    }
    
    //Tampilkan Data PergelanganTangan
    public void DataWrist(){ 
        
        try{
            String sql="SELECT * FROM t_adjustdata WHERE nim ='" + Form1_InputDataTes.NimTxt.getText() + "'";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                int Wrist = res.getInt("wrist");
                int AWrist = res.getInt("a_wrist");
                if (Wrist == 1) {
                    Pergelangan1.setSelected(true);
                }
                else if (Wrist == 2) {
                    Pergelangan2.setSelected(true);
                }
                else if (Wrist == 3) {
                    Pergelangan3.setSelected(true);
                }
                else if (Wrist == 4) {
                    Pergelangan4.setSelected(true);
                }
                if (AWrist == 1) {
                    TambahanWrist.setSelected(true);
                }
                }
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    //Masukan Data Putaran Pergelangan Tangan
    public void InsertPutaranPergelangan() {
        try {
            // Kondisi untuk menentukan posisi Putaran Pergelangan Tangan
            int wristTwist = 0;
            int adjust = 0;
            int adjustWristTwist = 0;
            if (PutaranLengan1.isSelected()) {
                wristTwist = 1;
                adjustWristTwist = 1;
            } 
            else if (PutaranLengan2.isSelected()) {
                wristTwist = 2;
                adjustWristTwist = 2;
            }
            
            int SUpperArm = wristTwist + adjust;
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/rula_project", "root" ,"");
            st=con.createStatement();
                
            // Untuk menyimpan ke database t_rula
            String simpan = "UPDATE t_rula SET wristtwist ='" + SUpperArm + "' WHERE nim='" + Form1_InputDataTes.NimTxt.getText()+"'";
            
            // Untuk menyimpan ke database adjust_data
            String simpanAdjust = "UPDATE t_adjustdata SET wristtwist ='" + adjustWristTwist + "' WHERE nim='" + Form1_InputDataTes.NimTxt.getText()+"'";
            int SA2 = st.executeUpdate(simpanAdjust);
            
            int SA = st.executeUpdate(simpan);
            JOptionPane.showMessageDialog(null, "Data Berhasil Tersimpan");
            
            
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            // Jika ada primary key yang sama
            JOptionPane.showMessageDialog(this, "Data gagal disimpan", "Pesan",
            JOptionPane.WARNING_MESSAGE);
        }
    }
    
    //Tampilkan Data Putaran Pergelangan Tangan
    public void DataWristTwist(){ 
        
        try{
            String sql="SELECT * FROM t_adjustdata WHERE nim ='" + Form1_InputDataTes.NimTxt.getText() + "'";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                int LowerArm = res.getInt("wristtwist");
                if (LowerArm == 1) {
                    PutaranLengan1.setSelected(true);
                }
                else if (LowerArm == 2) {
                    PutaranLengan2.setSelected(true);
                }
                }
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    //Masukan Data Leher
    public void InsertLeher() {
        try {
            // Kondisi untuk menentukan posisi Leher
            int location_neck = 0;
            int adjust = 0;
            int adjustlocation_neck = 0;
            int adjustAlocation_neck = 0;
            if (Leher.isSelected()) {
                location_neck = 1;
                adjustlocation_neck = 1;
            } 
            else if (Leher1.isSelected()) {
                location_neck = 2;
                adjustlocation_neck = 2;
            }
            else if (Leher2.isSelected()) {
                location_neck = 3;
                adjustlocation_neck = 3;
            }
            else if (Leher3.isSelected()) {
                location_neck = 4;
                adjustlocation_neck = 4;
            }
            if (cmbLeher1.isSelected() && cmbLeher2.isSelected()) {
                adjust = 2;
                adjustAlocation_neck = 3;
            }
            else if (cmbLeher1.isSelected()) {
                adjust = 1;
                adjustAlocation_neck = 1;
            }
            else if (cmbLeher2.isSelected()) {
                adjust = 1;
                adjustAlocation_neck = 2;
            }
            
            int Slocation_neck = location_neck + adjust;
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/rula_project", "root" ,"");
            st=con.createStatement();
                
            // Untuk menyimpan ke database t_rula
            String simpan = "UPDATE t_rula SET neck ='" + Slocation_neck + "' WHERE nim='" + Form1_InputDataTes.NimTxt.getText()+"'";
            
            // Untuk menyimpan ke database adjust_data
            String simpanAdjust = "UPDATE t_adjustdata SET location_neck ='" + adjustlocation_neck + "',a_location_neck='" + adjustAlocation_neck
                        + "' WHERE nim='" + Form1_InputDataTes.NimTxt.getText()+"'";
            int SA2 = st.executeUpdate(simpanAdjust);
            
            int SA = st.executeUpdate(simpan);
            JOptionPane.showMessageDialog(null, "Data Berhasil Tersimpan");
            
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            // Jika ada primary key yang sama
            JOptionPane.showMessageDialog(this, "Data gagal disimpan", "Pesan",
            JOptionPane.WARNING_MESSAGE);
        }
    }
    
    //Tampilkan Data Leher
    public void DataNeck(){ 
        
        try{
            String sql="SELECT * FROM t_adjustdata WHERE nim ='" + Form1_InputDataTes.NimTxt.getText() + "'";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                int armwrist_muscle = res.getInt("location_neck");
                int Aarmwrist_muscle = res.getInt("a_location_neck");
                if (armwrist_muscle == 1) {
                    Leher.setSelected(true);
                }
                else if (armwrist_muscle == 2) {
                    Leher1.setSelected(true);
                }
                else if (armwrist_muscle == 3) {
                    Leher2.setSelected(true);
                }
                else if (armwrist_muscle == 4) {
                    Leher3.setSelected(true);
                }
                if (Aarmwrist_muscle == 1) {
                    cmbLeher1.setSelected(true);
                }
                else if (Aarmwrist_muscle == 2) {
                    cmbLeher2.setSelected(true);
                }
                else if (Aarmwrist_muscle == 3) {
                    cmbLeher1.setSelected(true);
                    cmbLeher2.setSelected(true);
                }
                }
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    //Masukan Data Punggung
    public void InsertPunggung() {
        try {
            // Kondisi untuk menentukan posisi Punggung
            int locate_trunk = 0;
            int adjust = 0;
            int adjustlocate_trunk = 0;
            int adjustAlocate_trunk = 0;
            if (Punggung1.isSelected()) {
                locate_trunk = 1;
                adjustlocate_trunk = 1;
            } 
            else if (Punggung2.isSelected()) {
                locate_trunk = 2;
                adjustlocate_trunk = 2;
            }
            else if (Punggung3.isSelected()) {
                locate_trunk = 3;
                adjustlocate_trunk = 3;
            }
            else if (Punggung4.isSelected()) {
                locate_trunk = 4;
                adjustlocate_trunk = 4;
            }
            if (cmbPunggung1.isSelected() && cmbPunggung2.isSelected()) {
                adjust = 2;
                adjustAlocate_trunk = 3;
            }
            else if (cmbPunggung1.isSelected()) {
                adjust = 1;
                adjustAlocate_trunk = 1;
            }
            else if (cmbPunggung2.isSelected()) {
                adjust = 1;
                adjustAlocate_trunk = 2;
            }
            
            int Slocate_trunk = locate_trunk + adjust;
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/rula_project", "root" ,"");
            st=con.createStatement();
                
            // Untuk menyimpan ke t_rula
            String simpan = "UPDATE t_rula SET trunk ='" + Slocate_trunk + "' WHERE nim='" + Form1_InputDataTes.NimTxt.getText()+"'";
            
            // Untuk menyimpan ke database adjustdata
            String simpanAdjust = "UPDATE t_adjustdata SET locate_trunk ='" + adjustlocate_trunk + "',a_locate_trunk='" + adjustAlocate_trunk
                        + "' WHERE nim='" + Form1_InputDataTes.NimTxt.getText()+"'";
            int SA2 = st.executeUpdate(simpanAdjust);
            
            int SA = st.executeUpdate(simpan);
            JOptionPane.showMessageDialog(null, "Data Berhasil Tersimpan");
            
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            // Jika ada primary key yang sama
            JOptionPane.showMessageDialog(this, "Data gagal disimpan", "Pesan",
            JOptionPane.WARNING_MESSAGE);
        }
    }
    
    //Tampilkan Data Punggung
    public void DataTrunk(){ 
        
        try{
            String sql="SELECT * FROM t_adjustdata WHERE nim ='" + Form1_InputDataTes.NimTxt.getText() + "'";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                int armwrist_muscle = res.getInt("locate_trunk");
                int Aarmwrist_muscle = res.getInt("a_locate_trunk");
                if (armwrist_muscle == 1) {
                    Punggung1.setSelected(true);
                }
                else if (armwrist_muscle == 2) {
                    Punggung2.setSelected(true);
                }
                else if (armwrist_muscle == 3) {
                    Punggung3.setSelected(true);
                }
                else if (armwrist_muscle == 4) {
                    Punggung4.setSelected(true);
                }
                if (Aarmwrist_muscle == 1) {
                    cmbPunggung1.setSelected(true);
                }
                else if (Aarmwrist_muscle == 2) {
                    cmbPunggung2.setSelected(true);
                }
                else if (Aarmwrist_muscle == 3) {
                    cmbPunggung1.setSelected(true);
                    cmbPunggung2.setSelected(true);
                }
                }
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    //Masukan Data Kaki
    public void InsertKaki() {
        try {
            // Kondisi untuk menentukan posisi Kaki
            int legs = 0;
            int adjust = 0;
            int adjustlegs = 0;
            if (Kaki1.isSelected()) {
                legs = 1;
                adjustlegs = 1;
            } 
            else if (Kaki2.isSelected()) {
                legs = 2;
                adjustlegs = 2;
            }
            
            int Slegs = legs + adjust;
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/rula_project", "root" ,"");
            st=con.createStatement();
                
            // Untuk menyimpan ke database t_rula
            String simpan = "UPDATE t_rula SET leg ='" + Slegs + "' WHERE nim='" + Form1_InputDataTes.NimTxt.getText()+"'";
            
            // Untuk menyimpan ke database adjustdata
            String simpanAdjust = "UPDATE t_adjustdata SET legs ='" + adjustlegs + "' WHERE nim='" + Form1_InputDataTes.NimTxt.getText()+"'";
            int SA2 = st.executeUpdate(simpanAdjust);
            
            int SA = st.executeUpdate(simpan);
            JOptionPane.showMessageDialog(null, "Data Berhasil Tersimpan");
            
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            // Jika ada primary key yang sama
            JOptionPane.showMessageDialog(this, "Data gagal disimpan", "Pesan",
            JOptionPane.WARNING_MESSAGE);
        }
    }
    
    //Tampilkan Data Kaki
    public void DataLegs(){ 
        
        try{
            String sql="SELECT * FROM t_adjustdata WHERE nim ='" + Form1_InputDataTes.NimTxt.getText() + "'";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                int LowerArm = res.getInt("legs");
                if (LowerArm == 1) {
                    Kaki1.setSelected(true);
                }
                else if (LowerArm == 2) {
                    Kaki2.setSelected(true);
                }
                }
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    //Masukan Data Penggunaan Otot dan Beban Dari Grup A
    public void InsertOtotDanBebanA() {
        try {
            // Kondisi untuk menentukan penggunaan otot dan beban grup A
            int armwrist_muscle = 0;
            int adjust = 0;
            int adjustarmwrist_muscle = 0;
            int adjustAarmwrist_muscle = 0;
            if (RadioBebanA1.isSelected()) {
                armwrist_muscle = 0;
                adjustarmwrist_muscle = 1;
            } 
            else if (RadioBebanA2.isSelected()) {
                armwrist_muscle = 1;
                adjustarmwrist_muscle = 2;
            }
            else if (RadioBebanA3.isSelected()) {
                armwrist_muscle = 2;
                adjustarmwrist_muscle = 3;
            }
            else if (RadioBebanA4.isSelected()) {
                armwrist_muscle = 3;
                adjustarmwrist_muscle = 4;
            }
            if (CheckOtotA.isSelected()) {
                adjust = 1;
                adjustAarmwrist_muscle = 1;
            }
            
            int Sarmwrist_muscle = armwrist_muscle + adjust;
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/rula_project", "root" ,"");
            st=con.createStatement();
                
            // Untuk menyimpan ke database t_rula
            String simpan = "UPDATE t_rula SET armmuscle ='" + Sarmwrist_muscle + "' WHERE nim='" + Form1_InputDataTes.NimTxt.getText()+"'";
            
            // Untuk menyimpan ke database adjust_data
            String simpanAdjust = "UPDATE t_adjustdata SET armwrist_muscle ='" + adjustarmwrist_muscle + "',a_armwrist_muscle='" + adjustAarmwrist_muscle
                        + "' WHERE nim='" + Form1_InputDataTes.NimTxt.getText()+"'";
            int SA2 = st.executeUpdate(simpanAdjust);
            
            int SA = st.executeUpdate(simpan);
            //JOptionPane.showMessageDialog(null, "Data Berhasil Tersimpan");
            
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            // Jika ada primary key yang sama
            //JOptionPane.showMessageDialog(this, "Data gagal disimpan", "Pesan",
            //JOptionPane.WARNING_MESSAGE);
        }
    }
    
    //Tampilkan Data Penggunaan Otot dan Beban Dari Grup A
    public void DataMuscleA(){ 
        
        try{
            String sql="SELECT * FROM t_adjustdata WHERE nim ='" + Form1_InputDataTes.NimTxt.getText() + "'";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                int armwrist_muscle = res.getInt("armwrist_muscle");
                int Aarmwrist_muscle = res.getInt("a_armwrist_muscle");
                if (armwrist_muscle == 1) {
                    RadioBebanA1.setSelected(true);
                }
                else if (armwrist_muscle == 2) {
                    RadioBebanA2.setSelected(true);
                }
                else if (armwrist_muscle == 3) {
                    RadioBebanA3.setSelected(true);
                }
                else if (armwrist_muscle == 4) {
                    RadioBebanA4.setSelected(true);
                }
                if (Aarmwrist_muscle == 1) {
                    CheckOtotA.setSelected(true);
                }
                }
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    //Masukan Data Penggunaan Otot dan Beban Dari Grup B
    public void InsertOtotDanBebanB() {
        try {
            // Kondisi untuk menentukan penggunaan otot dan beban grup B
            int necktrunklegs_muscle = 0;
            int adjust = 0;
            int adjustnecktrunklegs_muscle = 0;
            int adjustAnecktrunklegs_muscle = 0;
            if (RadioBebanB1.isSelected()) {
                necktrunklegs_muscle = 0;
                adjustnecktrunklegs_muscle = 1;
            } 
            else if (RadioBebanB2.isSelected()) {
                necktrunklegs_muscle = 1;
                adjustnecktrunklegs_muscle = 2;
            }
            else if (RadioBebanB3.isSelected()) {
                necktrunklegs_muscle = 2;
                adjustnecktrunklegs_muscle = 3;
            }
            else if (RadioBebanB4.isSelected()) {
                necktrunklegs_muscle = 3;
                adjustnecktrunklegs_muscle = 4;
            }
            if (CheckOtotB.isSelected()) {
                adjust = 1;
                adjustAnecktrunklegs_muscle = 1;
            }
            
            int Snecktrunklegs_muscle = necktrunklegs_muscle + adjust;
            
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/rula_project", "root" ,"");
            st=con.createStatement();
                
            // Untuk menyimpan ke database t_rula
            String simpan = "UPDATE t_rula SET legmuscle ='" + Snecktrunklegs_muscle + "' WHERE nim='" + Form1_InputDataTes.NimTxt.getText()+"'";
            
            // Untuk menyimpan ke database adjustdata
            String simpanAdjust = "UPDATE t_adjustdata SET necktrunklegs_muscle ='" + adjustnecktrunklegs_muscle + "',a_necktrunklegs_muscle='" + adjustAnecktrunklegs_muscle
                        + "' WHERE nim='" + Form1_InputDataTes.NimTxt.getText()+"'";
            int SA2 = st.executeUpdate(simpanAdjust);
            
            int SA = st.executeUpdate(simpan);
            JOptionPane.showMessageDialog(null, "Data Berhasil Tersimpan");
            
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            // Jika ada primary key yang sama
            JOptionPane.showMessageDialog(this, "Data gagal disimpan", "Pesan",
            JOptionPane.WARNING_MESSAGE);
        }
    }
    
    //Tampilkan Data Penggunaan Otot dan Beban Dari Grup B
    public void DataMuscleB(){ 
        
        try{
            String sql="SELECT * FROM t_adjustdata WHERE nim ='" + Form1_InputDataTes.NimTxt.getText() + "'";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                int armwrist_muscle = res.getInt("necktrunklegs_muscle");
                int Aarmwrist_muscle = res.getInt("a_necktrunklegs_muscle");
                if (armwrist_muscle == 1) {
                    RadioBebanB1.setSelected(true);
                }
                else if (armwrist_muscle == 2) {
                    RadioBebanB2.setSelected(true);
                }
                else if (armwrist_muscle == 3) {
                    RadioBebanB3.setSelected(true);
                }
                else if (armwrist_muscle == 4) {
                    RadioBebanB4.setSelected(true);
                }
                if (Aarmwrist_muscle == 1) {
                    CheckOtotB.setSelected(true);
                }
                }
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    //Tampil Data Di database
    private void tampilkan_data(){
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nim");
        model.addColumn("Nama");
        model.addColumn("Pekerjaan");
        model.addColumn("Jenis Kelamin");
        model.addColumn("No Telepon");
        model.addColumn("Final Score");
        
        try {
            String sql = "SELECT * FROM t_rula";
            java.sql.Connection conn = (Connection)koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while(res.next()){
                model.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5),res.getString(15)});
            }
            TabelData.setModel(model);
            
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    //Tampilkan Identitas Dari Pengguna
    private void tampilkan_identitas(){
        LabelIdentitas.setText("NIM: " + Form1_InputDataTes.NimTxt.getText());
        
    }
    
    
    
    public Form2_ProsesRulaTes() {
        initComponents();
        tampilkan_data();
        tampilkan_identitas();
        
        setExtendedState(JFrame.MAXIMIZED_HORIZ);
        setVisible(true);
        setResizable(false);
        
        //Tampilkan Data Yang di input
        DataUA();
        DataLA();
        DataWrist();
        DataWristTwist();
        DataNeck();
        DataTrunk();
        DataLegs();
        DataMuscleA();
        DataMuscleB();
        
 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        RULA_btnGroup = new javax.swing.ButtonGroup();
        LenganAtasGroup = new javax.swing.ButtonGroup();
        LenganBawahGroup = new javax.swing.ButtonGroup();
        PergelanganGroup = new javax.swing.ButtonGroup();
        PutaranLenganGroup = new javax.swing.ButtonGroup();
        LeherGroup = new javax.swing.ButtonGroup();
        PunggungGroup = new javax.swing.ButtonGroup();
        KakiGroup = new javax.swing.ButtonGroup();
        BebanAGroup = new javax.swing.ButtonGroup();
        BebanBGroup = new javax.swing.ButtonGroup();
        BodyPanel = new javax.swing.JPanel();
        TitelPanel = new javax.swing.JPanel();
        txtTitle = new javax.swing.JLabel();
        LabelIdentitas = new javax.swing.JLabel();
        PilihanPanel = new javax.swing.JPanel();
        Radiobtn_Lenganatas = new javax.swing.JRadioButton();
        Radiobtn_Lenganbawah = new javax.swing.JRadioButton();
        Radiobtn_Pergelangan = new javax.swing.JRadioButton();
        Radiobtn_Putaranlengan = new javax.swing.JRadioButton();
        Radiobtn_Leher = new javax.swing.JRadioButton();
        Radiobtn_Punggung = new javax.swing.JRadioButton();
        Radiobtn_Kaki = new javax.swing.JRadioButton();
        Radiobtn_Otot = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        MainPanel = new javax.swing.JPanel();
        WelcomePanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        LenganAtasPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        LenganAtasLbl = new javax.swing.JLabel();
        LenganAtasLbl1 = new javax.swing.JLabel();
        LenganAtasLbl2 = new javax.swing.JLabel();
        LenganAtasLbl3 = new javax.swing.JLabel();
        LenganAtasLbl4 = new javax.swing.JLabel();
        LenganAtas1 = new javax.swing.JRadioButton();
        LenganAtas2 = new javax.swing.JRadioButton();
        LenganAtas3 = new javax.swing.JRadioButton();
        LenganAtas4 = new javax.swing.JRadioButton();
        LenganAtas5 = new javax.swing.JRadioButton();
        TambahanPanel = new javax.swing.JPanel();
        Tambahantxt = new javax.swing.JLabel();
        TambahanUA1 = new javax.swing.JCheckBox();
        TambahanUA2 = new javax.swing.JCheckBox();
        TambahanUA3 = new javax.swing.JCheckBox();
        PanelSimpan = new GUI_Custom.PanelRound();
        BtnSimpan = new javax.swing.JButton();
        LenganBawahPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        LenganBawahLbl1 = new javax.swing.JLabel();
        LenganBawahLbl2 = new javax.swing.JLabel();
        LenganBawahLbl3 = new javax.swing.JLabel();
        LenganBawah1 = new javax.swing.JRadioButton();
        LenganBawah2 = new javax.swing.JRadioButton();
        LenganBawah3 = new javax.swing.JRadioButton();
        TambahanPanel1 = new javax.swing.JPanel();
        Tambahantxt1 = new javax.swing.JLabel();
        LenganBawahLbl4 = new javax.swing.JLabel();
        TambahanLA = new javax.swing.JCheckBox();
        PanelSimpan1 = new GUI_Custom.PanelRound();
        BtnSimpan1 = new javax.swing.JButton();
        PergelanganPanel = new javax.swing.JPanel();
        PergelanganTxt = new javax.swing.JLabel();
        PergelanganLbl1 = new javax.swing.JLabel();
        PergelanganLbl2 = new javax.swing.JLabel();
        PergelanganLbl3 = new javax.swing.JLabel();
        PergelanganLbl4 = new javax.swing.JLabel();
        Pergelangan1 = new javax.swing.JRadioButton();
        Pergelangan2 = new javax.swing.JRadioButton();
        Pergelangan3 = new javax.swing.JRadioButton();
        Pergelangan4 = new javax.swing.JRadioButton();
        TambahanPanel2 = new javax.swing.JPanel();
        Tambahantxt2 = new javax.swing.JLabel();
        PergelanganLbl5 = new javax.swing.JLabel();
        TambahanWrist = new javax.swing.JCheckBox();
        PanelSimpan2 = new GUI_Custom.PanelRound();
        BtnSimpan2 = new javax.swing.JButton();
        PutaranTanganPanel = new javax.swing.JPanel();
        PutaranTangantxt = new javax.swing.JLabel();
        PutaranLenganLbl1 = new javax.swing.JLabel();
        PutaranLenganLbl2 = new javax.swing.JLabel();
        PutaranLengan1 = new javax.swing.JRadioButton();
        PutaranLengan2 = new javax.swing.JRadioButton();
        PanelSimpan3 = new GUI_Custom.PanelRound();
        BtnSimpan3 = new javax.swing.JButton();
        LeherPanel = new javax.swing.JPanel();
        LeherTxt = new javax.swing.JLabel();
        LeherLbl1 = new javax.swing.JLabel();
        LeherLbl2 = new javax.swing.JLabel();
        LeherLbl3 = new javax.swing.JLabel();
        LeherLbl4 = new javax.swing.JLabel();
        Leher = new javax.swing.JRadioButton();
        Leher1 = new javax.swing.JRadioButton();
        Leher2 = new javax.swing.JRadioButton();
        Leher3 = new javax.swing.JRadioButton();
        TambahanPanel3 = new javax.swing.JPanel();
        Tambahantxt3 = new javax.swing.JLabel();
        LeherLbl5 = new javax.swing.JLabel();
        LeherLbl6 = new javax.swing.JLabel();
        cmbLeher1 = new javax.swing.JCheckBox();
        cmbLeher2 = new javax.swing.JCheckBox();
        PanelSimpan4 = new GUI_Custom.PanelRound();
        BtnSimpan4 = new javax.swing.JButton();
        PunggungPanel = new javax.swing.JPanel();
        PunggungTxt = new javax.swing.JLabel();
        PunggungLbl1 = new javax.swing.JLabel();
        PunggungLbl2 = new javax.swing.JLabel();
        PunggungLbl3 = new javax.swing.JLabel();
        PunggungLbl4 = new javax.swing.JLabel();
        Punggung1 = new javax.swing.JRadioButton();
        Punggung2 = new javax.swing.JRadioButton();
        Punggung3 = new javax.swing.JRadioButton();
        Punggung4 = new javax.swing.JRadioButton();
        TambahanPanel4 = new javax.swing.JPanel();
        Tambahantxt4 = new javax.swing.JLabel();
        Punggung5 = new javax.swing.JLabel();
        Punggung6 = new javax.swing.JLabel();
        cmbPunggung1 = new javax.swing.JCheckBox();
        cmbPunggung2 = new javax.swing.JCheckBox();
        PanelSimpan5 = new GUI_Custom.PanelRound();
        BtnSimpan5 = new javax.swing.JButton();
        KakiPanel = new javax.swing.JPanel();
        KakiTxt = new javax.swing.JLabel();
        KakiLbl1 = new javax.swing.JLabel();
        KakiLbl2 = new javax.swing.JLabel();
        KakiTxt1 = new javax.swing.JLabel();
        KakiTxt2 = new javax.swing.JLabel();
        KakiTxt3 = new javax.swing.JLabel();
        KakiTxt4 = new javax.swing.JLabel();
        Kaki1 = new javax.swing.JRadioButton();
        Kaki2 = new javax.swing.JRadioButton();
        PanelSimpan7 = new GUI_Custom.PanelRound();
        BtnSimpan6 = new javax.swing.JButton();
        OtotPanel = new javax.swing.JPanel();
        OtotDanBebanTxt = new javax.swing.JLabel();
        OtotDanBebanTxt1 = new javax.swing.JLabel();
        OtotDanBebanTxt2 = new javax.swing.JLabel();
        PanelOtotBagianA = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        CheckOtotA = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        PanelBebanBagianA = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        RadioBebanA1 = new javax.swing.JRadioButton();
        RadioBebanA2 = new javax.swing.JRadioButton();
        RadioBebanA3 = new javax.swing.JRadioButton();
        RadioBebanA4 = new javax.swing.JRadioButton();
        PanelOtotBagianB = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        CheckOtotB = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        PanelBebanBagianB = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        RadioBebanB1 = new javax.swing.JRadioButton();
        RadioBebanB2 = new javax.swing.JRadioButton();
        RadioBebanB3 = new javax.swing.JRadioButton();
        RadioBebanB4 = new javax.swing.JRadioButton();
        PanelSimpan6 = new GUI_Custom.PanelRound();
        BtnSimpan7 = new javax.swing.JButton();
        DatabasesPanel = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        OtotDanBebanTxt3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelData = new GUI_Custom.TableDark();
        InformasiPanel = new javax.swing.JPanel();
        TxtInfo1 = new javax.swing.JLabel();
        InfoDeveloper1 = new javax.swing.JPanel();
        LblDev2 = new javax.swing.JLabel();
        ImgDev2 = new javax.swing.JLabel();
        LblNama2 = new javax.swing.JLabel();
        Lblnim2 = new javax.swing.JLabel();
        LblProdi2 = new javax.swing.JLabel();
        LblSemester2 = new javax.swing.JLabel();
        LblKampus1 = new javax.swing.JLabel();
        Nama2 = new javax.swing.JLabel();
        NIM2 = new javax.swing.JLabel();
        Prodi2 = new javax.swing.JLabel();
        Semester2 = new javax.swing.JLabel();
        Kampus1 = new javax.swing.JLabel();
        btnHasil = new javax.swing.JButton();
        btnDatabases = new javax.swing.JButton();
        btnInformasi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BodyPanel.setBackground(new java.awt.Color(124, 150, 171));

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LabelIdentitas, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66))
        );
        TitelPanelLayout.setVerticalGroup(
            TitelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TitelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(LabelIdentitas))
        );

        PilihanPanel.setBackground(new java.awt.Color(191, 204, 181));
        PilihanPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        RULA_btnGroup.add(Radiobtn_Lenganatas);
        Radiobtn_Lenganatas.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        Radiobtn_Lenganatas.setText("Lengan Atas");
        Radiobtn_Lenganatas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Radiobtn_LenganatasActionPerformed(evt);
            }
        });

        RULA_btnGroup.add(Radiobtn_Lenganbawah);
        Radiobtn_Lenganbawah.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        Radiobtn_Lenganbawah.setText("Lengan Bawah");
        Radiobtn_Lenganbawah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Radiobtn_LenganbawahActionPerformed(evt);
            }
        });

        RULA_btnGroup.add(Radiobtn_Pergelangan);
        Radiobtn_Pergelangan.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        Radiobtn_Pergelangan.setText("Pergelangan tangan");
        Radiobtn_Pergelangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Radiobtn_PergelanganActionPerformed(evt);
            }
        });

        RULA_btnGroup.add(Radiobtn_Putaranlengan);
        Radiobtn_Putaranlengan.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        Radiobtn_Putaranlengan.setText("Putaran Pergelangan tangan");
        Radiobtn_Putaranlengan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Radiobtn_PutaranlenganActionPerformed(evt);
            }
        });

        RULA_btnGroup.add(Radiobtn_Leher);
        Radiobtn_Leher.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        Radiobtn_Leher.setText("Leher");
        Radiobtn_Leher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Radiobtn_LeherActionPerformed(evt);
            }
        });

        RULA_btnGroup.add(Radiobtn_Punggung);
        Radiobtn_Punggung.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        Radiobtn_Punggung.setText("Punggung");
        Radiobtn_Punggung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Radiobtn_PunggungActionPerformed(evt);
            }
        });

        RULA_btnGroup.add(Radiobtn_Kaki);
        Radiobtn_Kaki.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        Radiobtn_Kaki.setText("Kaki");
        Radiobtn_Kaki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Radiobtn_KakiActionPerformed(evt);
            }
        });

        RULA_btnGroup.add(Radiobtn_Otot);
        Radiobtn_Otot.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        Radiobtn_Otot.setText("Penggunaan Otot dan Beban");
        Radiobtn_Otot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Radiobtn_OtotActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(0, 255, 255));
        jLabel11.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Pilih Bagian Tubuh");

        javax.swing.GroupLayout PilihanPanelLayout = new javax.swing.GroupLayout(PilihanPanel);
        PilihanPanel.setLayout(PilihanPanelLayout);
        PilihanPanelLayout.setHorizontalGroup(
            PilihanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PilihanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PilihanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Radiobtn_Lenganatas)
                    .addComponent(Radiobtn_Lenganbawah))
                .addGap(18, 18, 18)
                .addGroup(PilihanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Radiobtn_Putaranlengan)
                    .addComponent(Radiobtn_Pergelangan))
                .addGap(27, 27, 27)
                .addGroup(PilihanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Radiobtn_Punggung)
                    .addComponent(Radiobtn_Leher))
                .addGap(18, 18, 18)
                .addGroup(PilihanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Radiobtn_Kaki)
                    .addComponent(Radiobtn_Otot))
                .addContainerGap(28, Short.MAX_VALUE))
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PilihanPanelLayout.setVerticalGroup(
            PilihanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PilihanPanelLayout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PilihanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Radiobtn_Lenganatas)
                    .addComponent(Radiobtn_Pergelangan)
                    .addComponent(Radiobtn_Leher)
                    .addComponent(Radiobtn_Kaki))
                .addGap(11, 11, 11)
                .addGroup(PilihanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Radiobtn_Lenganbawah)
                    .addComponent(Radiobtn_Putaranlengan)
                    .addComponent(Radiobtn_Punggung)
                    .addComponent(Radiobtn_Otot))
                .addContainerGap())
        );

        MainPanel.setBackground(new java.awt.Color(102, 102, 102));
        MainPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        MainPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                MainPanelMouseMoved(evt);
            }
        });
        MainPanel.setLayout(new java.awt.CardLayout());

        WelcomePanel.setBackground(new java.awt.Color(191, 204, 181));

        jLabel4.setFont(new java.awt.Font("Bookman Old Style", 1, 36)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("SELAMAT DATANG DI RULA APPLICATION");

        jLabel10.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("RULA - Rapid Upper Limb Assessment");

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/manikin_logo.png"))); // NOI18N

        jLabel13.setFont(new java.awt.Font("Poppins", 1, 24)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Penilaian Penggunaan Postur Tubuh Bagian Atas Dengan Cepat");

        jLabel14.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Aplikasi penilaian untuk menilai risiko gangguan anggota tubuh bagian atas seperti lengan Atas, lengan bawah, pergelangan tangan, putaran pergelangan tangan");

        jLabel15.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Leher, punggung, kaki serta penggunaan otot dan beban");

        jLabel16.setFont(new java.awt.Font("Poppins", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Pilih salah satu penilaian, pilih postur tubuh yang paling akurat mencerminkan posisi kerja Anda untuk mengetahui dan meminimalisir resiko cedera");

        javax.swing.GroupLayout WelcomePanelLayout = new javax.swing.GroupLayout(WelcomePanel);
        WelcomePanel.setLayout(WelcomePanelLayout);
        WelcomePanelLayout.setHorizontalGroup(
            WelcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 1103, Short.MAX_VALUE)
            .addGroup(WelcomePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(WelcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(WelcomePanelLayout.createSequentialGroup()
                        .addGroup(WelcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 1073, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        WelcomePanelLayout.setVerticalGroup(
            WelcomePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(WelcomePanelLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addGap(58, 58, 58)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addGap(0, 27, Short.MAX_VALUE))
        );

        MainPanel.add(WelcomePanel, "card5");

        LenganAtasPanel.setBackground(new java.awt.Color(191, 204, 181));

        jLabel1.setBackground(new java.awt.Color(0, 255, 255));
        jLabel1.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tentukan Posisi Dari Lengan Atas");

        LenganAtasLbl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/upperarm1.jpg"))); // NOI18N
        LenganAtasLbl.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        LenganAtasLbl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/upperarm2.jpg"))); // NOI18N
        LenganAtasLbl1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        LenganAtasLbl2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/upperarm3.jpg"))); // NOI18N
        LenganAtasLbl2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        LenganAtasLbl3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/upperarm4.jpg"))); // NOI18N
        LenganAtasLbl3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        LenganAtasLbl4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/upperarm5.jpg"))); // NOI18N
        LenganAtasLbl4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        LenganAtasGroup.add(LenganAtas1);
        LenganAtas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LenganAtas1ActionPerformed(evt);
            }
        });

        LenganAtasGroup.add(LenganAtas2);

        LenganAtasGroup.add(LenganAtas3);

        LenganAtasGroup.add(LenganAtas4);

        LenganAtasGroup.add(LenganAtas5);
        LenganAtas5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LenganAtas5ActionPerformed(evt);
            }
        });

        TambahanPanel.setBackground(new java.awt.Color(255, 255, 255));
        TambahanPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        Tambahantxt.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Tambahantxt.setText("Opsi Tambahan Jika Sesuai Keadaan");

        TambahanUA1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TambahanUA1.setText("Jika Bahu Diangkat");

        TambahanUA2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TambahanUA2.setText("jika lengan atas diabduksi (menjauh dari sisi tubuh)");

        TambahanUA3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TambahanUA3.setText("jika Bersandar atau menopang berat lengan");
        TambahanUA3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahanUA3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TambahanPanelLayout = new javax.swing.GroupLayout(TambahanPanel);
        TambahanPanel.setLayout(TambahanPanelLayout);
        TambahanPanelLayout.setHorizontalGroup(
            TambahanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TambahanPanelLayout.createSequentialGroup()
                .addGroup(TambahanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TambahanPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Tambahantxt))
                    .addGroup(TambahanPanelLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(TambahanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TambahanUA2)
                            .addComponent(TambahanUA1)
                            .addComponent(TambahanUA3))))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        TambahanPanelLayout.setVerticalGroup(
            TambahanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TambahanPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Tambahantxt)
                .addGap(18, 18, 18)
                .addComponent(TambahanUA1)
                .addGap(18, 18, 18)
                .addComponent(TambahanUA2)
                .addGap(18, 18, 18)
                .addComponent(TambahanUA3)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        PanelSimpan.setBackground(new java.awt.Color(124, 150, 171));
        PanelSimpan.setRoundBottomLeft(25);
        PanelSimpan.setRoundBottomRight(25);
        PanelSimpan.setRoundTopLeft(25);
        PanelSimpan.setRoundTopRight(25);

        BtnSimpan.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        BtnSimpan.setForeground(new java.awt.Color(255, 255, 255));
        BtnSimpan.setText("Simpan");
        BtnSimpan.setContentAreaFilled(false);
        BtnSimpan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnSimpan.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                BtnSimpanMouseMoved(evt);
            }
        });
        BtnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelSimpanLayout = new javax.swing.GroupLayout(PanelSimpan);
        PanelSimpan.setLayout(PanelSimpanLayout);
        PanelSimpanLayout.setHorizontalGroup(
            PanelSimpanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSimpanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnSimpan)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelSimpanLayout.setVerticalGroup(
            PanelSimpanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BtnSimpan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout LenganAtasPanelLayout = new javax.swing.GroupLayout(LenganAtasPanel);
        LenganAtasPanel.setLayout(LenganAtasPanelLayout);
        LenganAtasPanelLayout.setHorizontalGroup(
            LenganAtasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LenganAtasPanelLayout.createSequentialGroup()
                .addGroup(LenganAtasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LenganAtasPanelLayout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(LenganAtas1)
                        .addGap(177, 177, 177)
                        .addComponent(LenganAtas2)
                        .addGap(195, 195, 195)
                        .addComponent(LenganAtas3)
                        .addGap(194, 194, 194)
                        .addComponent(LenganAtas4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LenganAtasPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(TambahanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LenganAtasPanelLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(LenganAtasLbl)
                        .addGap(66, 66, 66)
                        .addComponent(LenganAtasLbl1)
                        .addGap(68, 68, 68)
                        .addComponent(LenganAtasLbl2)
                        .addGap(65, 65, 65)
                        .addComponent(LenganAtasLbl3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(LenganAtasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LenganAtasPanelLayout.createSequentialGroup()
                        .addComponent(LenganAtas5)
                        .addGap(126, 126, 126))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LenganAtasPanelLayout.createSequentialGroup()
                        .addComponent(PanelSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LenganAtasPanelLayout.createSequentialGroup()
                        .addComponent(LenganAtasLbl4)
                        .addGap(59, 59, 59))))
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        LenganAtasPanelLayout.setVerticalGroup(
            LenganAtasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LenganAtasPanelLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(LenganAtasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LenganAtasLbl)
                    .addComponent(LenganAtasLbl1)
                    .addComponent(LenganAtasLbl2)
                    .addGroup(LenganAtasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(LenganAtasLbl4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LenganAtasLbl3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LenganAtasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LenganAtas1)
                    .addComponent(LenganAtas2)
                    .addComponent(LenganAtas3)
                    .addComponent(LenganAtas4)
                    .addComponent(LenganAtas5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(LenganAtasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TambahanPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelSimpan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        MainPanel.add(LenganAtasPanel, "card2");

        LenganBawahPanel.setBackground(new java.awt.Color(191, 204, 181));

        jLabel2.setBackground(new java.awt.Color(0, 255, 255));
        jLabel2.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tentukan Posisi Dari Lengan Bawah");

        LenganBawahLbl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/lowerarm1.jpg"))); // NOI18N
        LenganBawahLbl1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        LenganBawahLbl2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/lowerarm2.jpg"))); // NOI18N
        LenganBawahLbl2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        LenganBawahLbl3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/lowerarm3.jpg"))); // NOI18N
        LenganBawahLbl3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        LenganBawahGroup.add(LenganBawah1);

        LenganBawahGroup.add(LenganBawah2);

        LenganBawahGroup.add(LenganBawah3);

        TambahanPanel1.setBackground(new java.awt.Color(255, 255, 255));
        TambahanPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        Tambahantxt1.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Tambahantxt1.setText("Opsi Tambahan Jika Sesuai Keadaan");

        LenganBawahLbl4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/lowerarm4.jpg"))); // NOI18N
        LenganBawahLbl4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        TambahanLA.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TambahanLA.setText("Jika salah satu lengan bekerja melintasi garis tengah \natau keluar ke samping tubuh");
        TambahanLA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahanLAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TambahanPanel1Layout = new javax.swing.GroupLayout(TambahanPanel1);
        TambahanPanel1.setLayout(TambahanPanel1Layout);
        TambahanPanel1Layout.setHorizontalGroup(
            TambahanPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TambahanPanel1Layout.createSequentialGroup()
                .addGroup(TambahanPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TambahanPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Tambahantxt1))
                    .addGroup(TambahanPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(LenganBawahLbl4)
                        .addGap(18, 18, 18)
                        .addComponent(TambahanLA)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TambahanPanel1Layout.setVerticalGroup(
            TambahanPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TambahanPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Tambahantxt1)
                .addGroup(TambahanPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TambahanPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(LenganBawahLbl4)
                        .addContainerGap(45, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TambahanPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TambahanLA)
                        .addGap(104, 104, 104))))
        );

        PanelSimpan1.setBackground(new java.awt.Color(124, 150, 171));
        PanelSimpan1.setRoundBottomLeft(25);
        PanelSimpan1.setRoundBottomRight(25);
        PanelSimpan1.setRoundTopLeft(25);
        PanelSimpan1.setRoundTopRight(25);

        BtnSimpan1.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        BtnSimpan1.setForeground(new java.awt.Color(255, 255, 255));
        BtnSimpan1.setText("Simpan");
        BtnSimpan1.setContentAreaFilled(false);
        BtnSimpan1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnSimpan1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                BtnSimpan1MouseMoved(evt);
            }
        });
        BtnSimpan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSimpan1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelSimpan1Layout = new javax.swing.GroupLayout(PanelSimpan1);
        PanelSimpan1.setLayout(PanelSimpan1Layout);
        PanelSimpan1Layout.setHorizontalGroup(
            PanelSimpan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSimpan1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnSimpan1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelSimpan1Layout.setVerticalGroup(
            PanelSimpan1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BtnSimpan1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout LenganBawahPanelLayout = new javax.swing.GroupLayout(LenganBawahPanel);
        LenganBawahPanel.setLayout(LenganBawahPanelLayout);
        LenganBawahPanelLayout.setHorizontalGroup(
            LenganBawahPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LenganBawahPanelLayout.createSequentialGroup()
                .addContainerGap(138, Short.MAX_VALUE)
                .addComponent(TambahanPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(PanelSimpan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(LenganBawahPanelLayout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(LenganBawahLbl1)
                .addGap(176, 176, 176)
                .addComponent(LenganBawahLbl2)
                .addGap(188, 188, 188)
                .addComponent(LenganBawahLbl3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(LenganBawahPanelLayout.createSequentialGroup()
                .addGap(247, 247, 247)
                .addComponent(LenganBawah1)
                .addGap(260, 260, 260)
                .addComponent(LenganBawah2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LenganBawah3)
                .addGap(260, 260, 260))
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        LenganBawahPanelLayout.setVerticalGroup(
            LenganBawahPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LenganBawahPanelLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(LenganBawahPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LenganBawahPanelLayout.createSequentialGroup()
                        .addGroup(LenganBawahPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LenganBawahLbl1)
                            .addComponent(LenganBawahLbl2)
                            .addComponent(LenganBawahLbl3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(LenganBawahPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LenganBawah1)
                            .addComponent(LenganBawah2)
                            .addComponent(LenganBawah3))
                        .addGap(18, 18, 18)
                        .addComponent(TambahanPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(LenganBawahPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(PanelSimpan1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
        );

        MainPanel.add(LenganBawahPanel, "card3");

        PergelanganPanel.setBackground(new java.awt.Color(191, 204, 181));

        PergelanganTxt.setBackground(new java.awt.Color(0, 255, 255));
        PergelanganTxt.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        PergelanganTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PergelanganTxt.setText("Tentukan Posisi Dari Pergelangan Tangan");

        PergelanganLbl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/wrist1.jpg"))); // NOI18N
        PergelanganLbl1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        PergelanganLbl2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/wrist2.jpg"))); // NOI18N
        PergelanganLbl2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        PergelanganLbl3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/wrist3.jpg"))); // NOI18N
        PergelanganLbl3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        PergelanganLbl4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/wrist4.jpg"))); // NOI18N
        PergelanganLbl4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        PergelanganGroup.add(Pergelangan1);

        PergelanganGroup.add(Pergelangan2);

        PergelanganGroup.add(Pergelangan3);

        PergelanganGroup.add(Pergelangan4);

        TambahanPanel2.setBackground(new java.awt.Color(255, 255, 255));
        TambahanPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        Tambahantxt2.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Tambahantxt2.setText("Opsi Tambahan Jika Sesuai Keadaan");

        PergelanganLbl5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/wrist5.jpg"))); // NOI18N
        PergelanganLbl5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        TambahanWrist.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TambahanWrist.setText("jika pergelangan tangan ditekuk jauh dari garis tengah");
        TambahanWrist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahanWristActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TambahanPanel2Layout = new javax.swing.GroupLayout(TambahanPanel2);
        TambahanPanel2.setLayout(TambahanPanel2Layout);
        TambahanPanel2Layout.setHorizontalGroup(
            TambahanPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TambahanPanel2Layout.createSequentialGroup()
                .addGroup(TambahanPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TambahanPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Tambahantxt2))
                    .addGroup(TambahanPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(PergelanganLbl5)
                        .addGap(18, 18, 18)
                        .addComponent(TambahanWrist)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        TambahanPanel2Layout.setVerticalGroup(
            TambahanPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TambahanPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Tambahantxt2)
                .addGroup(TambahanPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TambahanPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(PergelanganLbl5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TambahanPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TambahanWrist)
                        .addGap(110, 110, 110))))
        );

        PanelSimpan2.setBackground(new java.awt.Color(124, 150, 171));
        PanelSimpan2.setRoundBottomLeft(25);
        PanelSimpan2.setRoundBottomRight(25);
        PanelSimpan2.setRoundTopLeft(25);
        PanelSimpan2.setRoundTopRight(25);

        BtnSimpan2.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        BtnSimpan2.setForeground(new java.awt.Color(255, 255, 255));
        BtnSimpan2.setText("Simpan");
        BtnSimpan2.setContentAreaFilled(false);
        BtnSimpan2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnSimpan2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                BtnSimpan2MouseMoved(evt);
            }
        });
        BtnSimpan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSimpan2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelSimpan2Layout = new javax.swing.GroupLayout(PanelSimpan2);
        PanelSimpan2.setLayout(PanelSimpan2Layout);
        PanelSimpan2Layout.setHorizontalGroup(
            PanelSimpan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSimpan2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnSimpan2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelSimpan2Layout.setVerticalGroup(
            PanelSimpan2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BtnSimpan2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PergelanganPanelLayout = new javax.swing.GroupLayout(PergelanganPanel);
        PergelanganPanel.setLayout(PergelanganPanelLayout);
        PergelanganPanelLayout.setHorizontalGroup(
            PergelanganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PergelanganPanelLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(PergelanganLbl1)
                .addGap(41, 41, 41)
                .addComponent(PergelanganLbl2)
                .addGap(39, 39, 39)
                .addComponent(PergelanganLbl3)
                .addGap(40, 40, 40)
                .addComponent(PergelanganLbl4)
                .addContainerGap(51, Short.MAX_VALUE))
            .addComponent(PergelanganTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PergelanganPanelLayout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addGroup(PergelanganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PergelanganPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(TambahanPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74)
                        .addComponent(PanelSimpan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(PergelanganPanelLayout.createSequentialGroup()
                        .addComponent(Pergelangan1)
                        .addGap(237, 237, 237)
                        .addComponent(Pergelangan2)
                        .addGap(241, 241, 241)
                        .addComponent(Pergelangan3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Pergelangan4)
                        .addGap(128, 128, 128))))
        );
        PergelanganPanelLayout.setVerticalGroup(
            PergelanganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PergelanganPanelLayout.createSequentialGroup()
                .addComponent(PergelanganTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(PergelanganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PergelanganLbl1)
                    .addComponent(PergelanganLbl2)
                    .addComponent(PergelanganLbl3)
                    .addComponent(PergelanganLbl4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PergelanganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PergelanganPanelLayout.createSequentialGroup()
                        .addGroup(PergelanganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Pergelangan1)
                            .addComponent(Pergelangan3)
                            .addComponent(Pergelangan4)
                            .addComponent(Pergelangan2))
                        .addGap(54, 54, 54)
                        .addComponent(TambahanPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PergelanganPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(PanelSimpan2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );

        MainPanel.add(PergelanganPanel, "card4");

        PutaranTanganPanel.setBackground(new java.awt.Color(191, 204, 181));

        PutaranTangantxt.setBackground(new java.awt.Color(0, 255, 255));
        PutaranTangantxt.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        PutaranTangantxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PutaranTangantxt.setText("Tentukan Posisi Apakah Ada Putaran Pergelangan Tangan");

        PutaranLenganLbl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/wrist_twist1.jpg"))); // NOI18N
        PutaranLenganLbl1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        PutaranLenganLbl2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/wrist_twist2.jpg"))); // NOI18N
        PutaranLenganLbl2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        PutaranLenganGroup.add(PutaranLengan1);
        PutaranLengan1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        PutaranLengan1.setText("Jika Dalam Posisi Jabat Tangan");
        PutaranLengan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PutaranLengan1ActionPerformed(evt);
            }
        });

        PutaranLenganGroup.add(PutaranLengan2);
        PutaranLengan2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        PutaranLengan2.setText("Jika Memutar Jauh Dari Posisi Jabat Tangan");
        PutaranLengan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PutaranLengan2ActionPerformed(evt);
            }
        });

        PanelSimpan3.setBackground(new java.awt.Color(124, 150, 171));
        PanelSimpan3.setRoundBottomLeft(25);
        PanelSimpan3.setRoundBottomRight(25);
        PanelSimpan3.setRoundTopLeft(25);
        PanelSimpan3.setRoundTopRight(25);

        BtnSimpan3.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        BtnSimpan3.setForeground(new java.awt.Color(255, 255, 255));
        BtnSimpan3.setText("Simpan");
        BtnSimpan3.setContentAreaFilled(false);
        BtnSimpan3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnSimpan3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                BtnSimpan3MouseMoved(evt);
            }
        });
        BtnSimpan3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSimpan3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelSimpan3Layout = new javax.swing.GroupLayout(PanelSimpan3);
        PanelSimpan3.setLayout(PanelSimpan3Layout);
        PanelSimpan3Layout.setHorizontalGroup(
            PanelSimpan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSimpan3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnSimpan3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelSimpan3Layout.setVerticalGroup(
            PanelSimpan3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BtnSimpan3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PutaranTanganPanelLayout = new javax.swing.GroupLayout(PutaranTanganPanel);
        PutaranTanganPanel.setLayout(PutaranTanganPanelLayout);
        PutaranTanganPanelLayout.setHorizontalGroup(
            PutaranTanganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PutaranTanganPanelLayout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(PutaranLengan1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PutaranLengan2)
                .addGap(128, 128, 128))
            .addGroup(PutaranTanganPanelLayout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(PutaranLenganLbl1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 301, Short.MAX_VALUE)
                .addComponent(PutaranLenganLbl2)
                .addGap(171, 171, 171))
            .addComponent(PutaranTangantxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PutaranTanganPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelSimpan3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(499, 499, 499))
        );
        PutaranTanganPanelLayout.setVerticalGroup(
            PutaranTanganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PutaranTanganPanelLayout.createSequentialGroup()
                .addComponent(PutaranTangantxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addGroup(PutaranTanganPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PutaranTanganPanelLayout.createSequentialGroup()
                        .addComponent(PutaranLenganLbl1)
                        .addGap(18, 18, 18)
                        .addComponent(PutaranLengan1))
                    .addGroup(PutaranTanganPanelLayout.createSequentialGroup()
                        .addComponent(PutaranLenganLbl2)
                        .addGap(18, 18, 18)
                        .addComponent(PutaranLengan2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(PanelSimpan3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(146, 146, 146))
        );

        MainPanel.add(PutaranTanganPanel, "card6");

        LeherPanel.setBackground(new java.awt.Color(191, 204, 181));

        LeherTxt.setBackground(new java.awt.Color(0, 255, 255));
        LeherTxt.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        LeherTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LeherTxt.setText("Tentukan Posisi Dari Leher");

        LeherLbl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/neck1.jpg"))); // NOI18N
        LeherLbl1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        LeherLbl2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/neck2.jpg"))); // NOI18N
        LeherLbl2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        LeherLbl3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/neck3.jpg"))); // NOI18N
        LeherLbl3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        LeherLbl4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/neck4.jpg"))); // NOI18N
        LeherLbl4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        LeherGroup.add(Leher);

        LeherGroup.add(Leher1);

        LeherGroup.add(Leher2);

        LeherGroup.add(Leher3);

        TambahanPanel3.setBackground(new java.awt.Color(255, 255, 255));
        TambahanPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        Tambahantxt3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Tambahantxt3.setText("Opsi Tambahan Jika Sesuai Keadaan");

        LeherLbl5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/neck5.jpg"))); // NOI18N
        LeherLbl5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        LeherLbl6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/neck6.jpg"))); // NOI18N
        LeherLbl6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        cmbLeher1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cmbLeher1.setText("memutar");
        cmbLeher1.setActionCommand("");
        cmbLeher1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLeher1ActionPerformed(evt);
            }
        });

        cmbLeher2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cmbLeher2.setText("Kesamping");
        cmbLeher2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbLeher2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TambahanPanel3Layout = new javax.swing.GroupLayout(TambahanPanel3);
        TambahanPanel3.setLayout(TambahanPanel3Layout);
        TambahanPanel3Layout.setHorizontalGroup(
            TambahanPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TambahanPanel3Layout.createSequentialGroup()
                .addGroup(TambahanPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TambahanPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Tambahantxt3))
                    .addGroup(TambahanPanel3Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(LeherLbl5)
                        .addGap(18, 18, 18)
                        .addComponent(cmbLeher1)
                        .addGap(52, 52, 52)
                        .addComponent(LeherLbl6)
                        .addGap(18, 18, 18)
                        .addComponent(cmbLeher2)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        TambahanPanel3Layout.setVerticalGroup(
            TambahanPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TambahanPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Tambahantxt3)
                .addGroup(TambahanPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TambahanPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(TambahanPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TambahanPanel3Layout.createSequentialGroup()
                                .addGroup(TambahanPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LeherLbl6)
                                    .addComponent(LeherLbl5))
                                .addContainerGap(17, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TambahanPanel3Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cmbLeher1)
                                .addGap(116, 116, 116))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TambahanPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbLeher2)
                        .addGap(119, 119, 119))))
        );

        PanelSimpan4.setBackground(new java.awt.Color(124, 150, 171));
        PanelSimpan4.setRoundBottomLeft(25);
        PanelSimpan4.setRoundBottomRight(25);
        PanelSimpan4.setRoundTopLeft(25);
        PanelSimpan4.setRoundTopRight(25);

        BtnSimpan4.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        BtnSimpan4.setForeground(new java.awt.Color(255, 255, 255));
        BtnSimpan4.setText("Simpan");
        BtnSimpan4.setContentAreaFilled(false);
        BtnSimpan4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnSimpan4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                BtnSimpan4MouseMoved(evt);
            }
        });
        BtnSimpan4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSimpan4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelSimpan4Layout = new javax.swing.GroupLayout(PanelSimpan4);
        PanelSimpan4.setLayout(PanelSimpan4Layout);
        PanelSimpan4Layout.setHorizontalGroup(
            PanelSimpan4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSimpan4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnSimpan4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelSimpan4Layout.setVerticalGroup(
            PanelSimpan4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BtnSimpan4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout LeherPanelLayout = new javax.swing.GroupLayout(LeherPanel);
        LeherPanel.setLayout(LeherPanelLayout);
        LeherPanelLayout.setHorizontalGroup(
            LeherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeherPanelLayout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(Leher)
                .addGap(231, 231, 231)
                .addComponent(Leher1)
                .addGap(222, 222, 222)
                .addComponent(Leher2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Leher3)
                .addGap(177, 177, 177))
            .addGroup(LeherPanelLayout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addComponent(LeherLbl4)
                .addGap(106, 106, 106)
                .addComponent(LeherLbl1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addComponent(LeherLbl2)
                .addGap(115, 115, 115)
                .addComponent(LeherLbl3)
                .addGap(108, 108, 108))
            .addComponent(LeherTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(LeherPanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(TambahanPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PanelSimpan4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        LeherPanelLayout.setVerticalGroup(
            LeherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeherPanelLayout.createSequentialGroup()
                .addComponent(LeherTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(LeherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(LeherLbl3)
                    .addComponent(LeherLbl2)
                    .addComponent(LeherLbl4)
                    .addComponent(LeherLbl1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(LeherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LeherPanelLayout.createSequentialGroup()
                        .addGroup(LeherPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Leher)
                            .addComponent(Leher1)
                            .addComponent(Leher2)
                            .addComponent(Leher3))
                        .addGap(18, 18, 18)
                        .addComponent(TambahanPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(LeherPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(PanelSimpan4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31))
        );

        MainPanel.add(LeherPanel, "card7");

        PunggungPanel.setBackground(new java.awt.Color(191, 204, 181));

        PunggungTxt.setBackground(new java.awt.Color(0, 255, 255));
        PunggungTxt.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        PunggungTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PunggungTxt.setText("Tentukan Posisi Dari Punggung");

        PunggungLbl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/trunk1.jpg"))); // NOI18N
        PunggungLbl1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        PunggungLbl2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/trunk2.jpg"))); // NOI18N
        PunggungLbl2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        PunggungLbl3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/trunk3.jpg"))); // NOI18N
        PunggungLbl3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        PunggungLbl4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/trunk4.jpg"))); // NOI18N
        PunggungLbl4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        PunggungGroup.add(Punggung1);

        PunggungGroup.add(Punggung2);
        Punggung2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Punggung2ActionPerformed(evt);
            }
        });

        PunggungGroup.add(Punggung3);

        PunggungGroup.add(Punggung4);

        TambahanPanel4.setBackground(new java.awt.Color(255, 255, 255));
        TambahanPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        Tambahantxt4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        Tambahantxt4.setText("Opsi Tambahan Jika Sesuai Keadaan");

        Punggung5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/trunk5.jpg"))); // NOI18N
        Punggung5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        Punggung6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/trunk6.jpg"))); // NOI18N
        Punggung6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        cmbPunggung1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cmbPunggung1.setText("memutar");
        cmbPunggung1.setActionCommand("");
        cmbPunggung1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPunggung1ActionPerformed(evt);
            }
        });

        cmbPunggung2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        cmbPunggung2.setText("Kesamping");
        cmbPunggung2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbPunggung2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TambahanPanel4Layout = new javax.swing.GroupLayout(TambahanPanel4);
        TambahanPanel4.setLayout(TambahanPanel4Layout);
        TambahanPanel4Layout.setHorizontalGroup(
            TambahanPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TambahanPanel4Layout.createSequentialGroup()
                .addGroup(TambahanPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TambahanPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Tambahantxt4))
                    .addGroup(TambahanPanel4Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(Punggung5)
                        .addGap(18, 18, 18)
                        .addComponent(cmbPunggung1)
                        .addGap(52, 52, 52)
                        .addComponent(Punggung6)
                        .addGap(18, 18, 18)
                        .addComponent(cmbPunggung2)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        TambahanPanel4Layout.setVerticalGroup(
            TambahanPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TambahanPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Tambahantxt4)
                .addGroup(TambahanPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TambahanPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(TambahanPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(TambahanPanel4Layout.createSequentialGroup()
                                .addGroup(TambahanPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Punggung6)
                                    .addComponent(Punggung5))
                                .addContainerGap(17, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TambahanPanel4Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(cmbPunggung1)
                                .addGap(116, 116, 116))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TambahanPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbPunggung2)
                        .addGap(119, 119, 119))))
        );

        PanelSimpan5.setBackground(new java.awt.Color(124, 150, 171));
        PanelSimpan5.setRoundBottomLeft(25);
        PanelSimpan5.setRoundBottomRight(25);
        PanelSimpan5.setRoundTopLeft(25);
        PanelSimpan5.setRoundTopRight(25);

        BtnSimpan5.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        BtnSimpan5.setForeground(new java.awt.Color(255, 255, 255));
        BtnSimpan5.setText("Simpan");
        BtnSimpan5.setContentAreaFilled(false);
        BtnSimpan5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnSimpan5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                BtnSimpan5MouseMoved(evt);
            }
        });
        BtnSimpan5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSimpan5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelSimpan5Layout = new javax.swing.GroupLayout(PanelSimpan5);
        PanelSimpan5.setLayout(PanelSimpan5Layout);
        PanelSimpan5Layout.setHorizontalGroup(
            PanelSimpan5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSimpan5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnSimpan5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelSimpan5Layout.setVerticalGroup(
            PanelSimpan5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BtnSimpan5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PunggungPanelLayout = new javax.swing.GroupLayout(PunggungPanel);
        PunggungPanel.setLayout(PunggungPanelLayout);
        PunggungPanelLayout.setHorizontalGroup(
            PunggungPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PunggungPanelLayout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addGroup(PunggungPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PunggungPanelLayout.createSequentialGroup()
                        .addComponent(PunggungLbl1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                        .addComponent(PunggungLbl2)
                        .addGap(129, 129, 129)
                        .addComponent(PunggungLbl3)
                        .addGap(108, 108, 108)
                        .addComponent(PunggungLbl4)
                        .addGap(99, 99, 99))
                    .addGroup(PunggungPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(Punggung1)
                        .addGap(207, 207, 207)
                        .addComponent(Punggung2)
                        .addGap(224, 224, 224)
                        .addComponent(Punggung3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Punggung4)
                        .addGap(184, 184, 184))
                    .addGroup(PunggungPanelLayout.createSequentialGroup()
                        .addComponent(TambahanPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(PanelSimpan5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addComponent(PunggungTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PunggungPanelLayout.setVerticalGroup(
            PunggungPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PunggungPanelLayout.createSequentialGroup()
                .addComponent(PunggungTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PunggungPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PunggungLbl1)
                    .addComponent(PunggungLbl2)
                    .addComponent(PunggungLbl3)
                    .addComponent(PunggungLbl4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PunggungPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PunggungPanelLayout.createSequentialGroup()
                        .addGroup(PunggungPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Punggung1)
                            .addComponent(Punggung2)
                            .addComponent(Punggung3)
                            .addComponent(Punggung4))
                        .addGap(28, 28, 28)
                        .addComponent(TambahanPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PunggungPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(PanelSimpan5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );

        MainPanel.add(PunggungPanel, "card8");

        KakiPanel.setBackground(new java.awt.Color(191, 204, 181));

        KakiTxt.setBackground(new java.awt.Color(0, 255, 255));
        KakiTxt.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        KakiTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        KakiTxt.setText("Tentukan Posisi Dari Kaki");

        KakiLbl1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/legs1.jpg"))); // NOI18N
        KakiLbl1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        KakiLbl2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/legs2.jpg"))); // NOI18N
        KakiLbl2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        KakiTxt1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        KakiTxt1.setText("dengan baik dan dalam");

        KakiTxt2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        KakiTxt2.setText("postur yang seimbang");

        KakiTxt3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        KakiTxt3.setText("seimbang dan tertopang ");

        KakiTxt4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        KakiTxt4.setText("secara merata");

        KakiGroup.add(Kaki1);
        Kaki1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        Kaki1.setText("tungkai dan kaki ditopang ");

        KakiGroup.add(Kaki2);
        Kaki2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        Kaki2.setText("tungkai dan kaki tidak");

        PanelSimpan7.setBackground(new java.awt.Color(124, 150, 171));
        PanelSimpan7.setRoundBottomLeft(25);
        PanelSimpan7.setRoundBottomRight(25);
        PanelSimpan7.setRoundTopLeft(25);
        PanelSimpan7.setRoundTopRight(25);

        BtnSimpan6.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        BtnSimpan6.setForeground(new java.awt.Color(255, 255, 255));
        BtnSimpan6.setText("Simpan");
        BtnSimpan6.setContentAreaFilled(false);
        BtnSimpan6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnSimpan6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                BtnSimpan6MouseMoved(evt);
            }
        });
        BtnSimpan6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSimpan6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelSimpan7Layout = new javax.swing.GroupLayout(PanelSimpan7);
        PanelSimpan7.setLayout(PanelSimpan7Layout);
        PanelSimpan7Layout.setHorizontalGroup(
            PanelSimpan7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSimpan7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnSimpan6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelSimpan7Layout.setVerticalGroup(
            PanelSimpan7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BtnSimpan6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout KakiPanelLayout = new javax.swing.GroupLayout(KakiPanel);
        KakiPanel.setLayout(KakiPanelLayout);
        KakiPanelLayout.setHorizontalGroup(
            KakiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KakiPanelLayout.createSequentialGroup()
                .addGroup(KakiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(KakiPanelLayout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addGroup(KakiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(KakiLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(KakiPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(Kaki1))))
                    .addGroup(KakiPanelLayout.createSequentialGroup()
                        .addGap(282, 282, 282)
                        .addGroup(KakiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(KakiTxt1, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                            .addComponent(KakiTxt2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 244, Short.MAX_VALUE)
                .addGroup(KakiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(KakiLbl2)
                    .addGroup(KakiPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(KakiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Kaki2)
                            .addGroup(KakiPanelLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(KakiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(KakiTxt3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(KakiTxt4, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(202, 202, 202))
            .addComponent(KakiTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KakiPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(PanelSimpan7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(481, 481, 481))
        );
        KakiPanelLayout.setVerticalGroup(
            KakiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KakiPanelLayout.createSequentialGroup()
                .addComponent(KakiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(KakiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(KakiLbl1)
                    .addComponent(KakiLbl2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(KakiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(KakiPanelLayout.createSequentialGroup()
                        .addComponent(Kaki1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(KakiTxt1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(KakiTxt2))
                    .addGroup(KakiPanelLayout.createSequentialGroup()
                        .addComponent(Kaki2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(KakiTxt3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(KakiTxt4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addComponent(PanelSimpan7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155))
        );

        MainPanel.add(KakiPanel, "card9");

        OtotPanel.setBackground(new java.awt.Color(191, 204, 181));

        OtotDanBebanTxt.setBackground(new java.awt.Color(0, 255, 255));
        OtotDanBebanTxt.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        OtotDanBebanTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OtotDanBebanTxt.setText("Tentukan Apakah Ada Penggunaan Otot Dan Beban");

        OtotDanBebanTxt1.setBackground(new java.awt.Color(0, 255, 255));
        OtotDanBebanTxt1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        OtotDanBebanTxt1.setText("Group A - Lengan Atas, Lengan Bawah, dan Pergelangan Tangan");

        OtotDanBebanTxt2.setBackground(new java.awt.Color(0, 255, 255));
        OtotDanBebanTxt2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        OtotDanBebanTxt2.setText("Grup B - Leher, Punggung Dan Kaki");

        PanelOtotBagianA.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel3.setText("Pilih Jika Ada Penggunaan Otot");

        CheckOtotA.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        CheckOtotA.setText("Postur terutama statis, ditahan lebih lama dari 10 menit ");
        CheckOtotA.setToolTipText("");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel6.setText("atau diulang lebih dari 4 kali per menit");

        javax.swing.GroupLayout PanelOtotBagianALayout = new javax.swing.GroupLayout(PanelOtotBagianA);
        PanelOtotBagianA.setLayout(PanelOtotBagianALayout);
        PanelOtotBagianALayout.setHorizontalGroup(
            PanelOtotBagianALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelOtotBagianALayout.createSequentialGroup()
                .addGroup(PanelOtotBagianALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelOtotBagianALayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(PanelOtotBagianALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelOtotBagianALayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel6))
                            .addComponent(CheckOtotA)))
                    .addGroup(PanelOtotBagianALayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelOtotBagianALayout.setVerticalGroup(
            PanelOtotBagianALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelOtotBagianALayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(CheckOtotA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        PanelBebanBagianA.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel5.setText("Pilih Jika Ada Beban");

        BebanAGroup.add(RadioBebanA1);
        RadioBebanA1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        RadioBebanA1.setText("Jika beban  kurang dari 2kg (intermittent)");
        RadioBebanA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioBebanA1ActionPerformed(evt);
            }
        });

        BebanAGroup.add(RadioBebanA2);
        RadioBebanA2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        RadioBebanA2.setText("Jika beban 2 hingga 10 kg (intermittent Load)");

        BebanAGroup.add(RadioBebanA3);
        RadioBebanA3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        RadioBebanA3.setText("Jika beban 2 hingga 10 kg (beban statis atau berulang)");

        BebanAGroup.add(RadioBebanA4);
        RadioBebanA4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        RadioBebanA4.setText("Jika beban lebih dari 10 kg, berulang atau guncangan");
        RadioBebanA4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RadioBebanA4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelBebanBagianALayout = new javax.swing.GroupLayout(PanelBebanBagianA);
        PanelBebanBagianA.setLayout(PanelBebanBagianALayout);
        PanelBebanBagianALayout.setHorizontalGroup(
            PanelBebanBagianALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBebanBagianALayout.createSequentialGroup()
                .addGroup(PanelBebanBagianALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelBebanBagianALayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(PanelBebanBagianALayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(PanelBebanBagianALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RadioBebanA2)
                            .addComponent(RadioBebanA1)
                            .addComponent(RadioBebanA3)
                            .addComponent(RadioBebanA4))))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        PanelBebanBagianALayout.setVerticalGroup(
            PanelBebanBagianALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBebanBagianALayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(RadioBebanA1)
                .addGap(18, 18, 18)
                .addComponent(RadioBebanA2)
                .addGap(18, 18, 18)
                .addComponent(RadioBebanA3)
                .addGap(18, 18, 18)
                .addComponent(RadioBebanA4)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        PanelOtotBagianB.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel7.setText("Pilih Jika Ada Penggunaan Otot");

        CheckOtotB.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        CheckOtotB.setText("Postur terutama statis, ditahan lebih lama dari 10 menit ");
        CheckOtotB.setToolTipText("");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel8.setText("atau diulang lebih dari 4 kali per menit");

        javax.swing.GroupLayout PanelOtotBagianBLayout = new javax.swing.GroupLayout(PanelOtotBagianB);
        PanelOtotBagianB.setLayout(PanelOtotBagianBLayout);
        PanelOtotBagianBLayout.setHorizontalGroup(
            PanelOtotBagianBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelOtotBagianBLayout.createSequentialGroup()
                .addGroup(PanelOtotBagianBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelOtotBagianBLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(PanelOtotBagianBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelOtotBagianBLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel8))
                            .addComponent(CheckOtotB)))
                    .addGroup(PanelOtotBagianBLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelOtotBagianBLayout.setVerticalGroup(
            PanelOtotBagianBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelOtotBagianBLayout.createSequentialGroup()
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(CheckOtotB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(0, 29, Short.MAX_VALUE))
        );

        PanelBebanBagianB.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel9.setText("Pilih JIka Ada Beban");

        BebanBGroup.add(RadioBebanB1);
        RadioBebanB1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        RadioBebanB1.setText("Jika beban  kurang dari 2kg (intermittent)");

        BebanBGroup.add(RadioBebanB2);
        RadioBebanB2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        RadioBebanB2.setText("Jika beban 2 hingga 10 kg (intermittent Load)");

        BebanBGroup.add(RadioBebanB3);
        RadioBebanB3.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        RadioBebanB3.setText("Jika beban 2 hingga 10 kg (beban statis atau berulang)");

        BebanBGroup.add(RadioBebanB4);
        RadioBebanB4.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        RadioBebanB4.setText("Jika beban lebih dari 10 kg, berulang atau guncangan");

        javax.swing.GroupLayout PanelBebanBagianBLayout = new javax.swing.GroupLayout(PanelBebanBagianB);
        PanelBebanBagianB.setLayout(PanelBebanBagianBLayout);
        PanelBebanBagianBLayout.setHorizontalGroup(
            PanelBebanBagianBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBebanBagianBLayout.createSequentialGroup()
                .addGroup(PanelBebanBagianBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelBebanBagianBLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9))
                    .addGroup(PanelBebanBagianBLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(PanelBebanBagianBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RadioBebanB2)
                            .addComponent(RadioBebanB1)
                            .addComponent(RadioBebanB3)
                            .addComponent(RadioBebanB4))))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        PanelBebanBagianBLayout.setVerticalGroup(
            PanelBebanBagianBLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBebanBagianBLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addComponent(RadioBebanB1)
                .addGap(18, 18, 18)
                .addComponent(RadioBebanB2)
                .addGap(18, 18, 18)
                .addComponent(RadioBebanB3)
                .addGap(18, 18, 18)
                .addComponent(RadioBebanB4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelSimpan6.setBackground(new java.awt.Color(124, 150, 171));
        PanelSimpan6.setRoundBottomLeft(25);
        PanelSimpan6.setRoundBottomRight(25);
        PanelSimpan6.setRoundTopLeft(25);
        PanelSimpan6.setRoundTopRight(25);

        BtnSimpan7.setFont(new java.awt.Font("Poppins", 1, 14)); // NOI18N
        BtnSimpan7.setForeground(new java.awt.Color(255, 255, 255));
        BtnSimpan7.setText("Simpan");
        BtnSimpan7.setContentAreaFilled(false);
        BtnSimpan7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnSimpan7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                BtnSimpan7MouseMoved(evt);
            }
        });
        BtnSimpan7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSimpan7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelSimpan6Layout = new javax.swing.GroupLayout(PanelSimpan6);
        PanelSimpan6.setLayout(PanelSimpan6Layout);
        PanelSimpan6Layout.setHorizontalGroup(
            PanelSimpan6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSimpan6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnSimpan7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelSimpan6Layout.setVerticalGroup(
            PanelSimpan6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BtnSimpan7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout OtotPanelLayout = new javax.swing.GroupLayout(OtotPanel);
        OtotPanel.setLayout(OtotPanelLayout);
        OtotPanelLayout.setHorizontalGroup(
            OtotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OtotPanelLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(OtotDanBebanTxt1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(OtotDanBebanTxt2)
                .addGap(177, 177, 177))
            .addComponent(OtotDanBebanTxt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OtotPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(OtotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelOtotBagianA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelBebanBagianA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addGroup(OtotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelOtotBagianB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelBebanBagianB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
            .addGroup(OtotPanelLayout.createSequentialGroup()
                .addGap(498, 498, 498)
                .addComponent(PanelSimpan6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        OtotPanelLayout.setVerticalGroup(
            OtotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OtotPanelLayout.createSequentialGroup()
                .addComponent(OtotDanBebanTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(OtotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OtotDanBebanTxt1)
                    .addComponent(OtotDanBebanTxt2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(OtotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelOtotBagianB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelOtotBagianA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(OtotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelBebanBagianA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelBebanBagianB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(PanelSimpan6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        MainPanel.add(OtotPanel, "card10");

        DatabasesPanel.setBackground(new java.awt.Color(191, 204, 181));

        jButton3.setText("Hapus");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        OtotDanBebanTxt3.setBackground(new java.awt.Color(0, 255, 255));
        OtotDanBebanTxt3.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        OtotDanBebanTxt3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        OtotDanBebanTxt3.setText("Database Riwayat Penggunaan RULA Application");

        TabelData.setModel(new javax.swing.table.DefaultTableModel(
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
        TabelData.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        TabelData.setMaximumSize(new java.awt.Dimension(525, 150));
        TabelData.setMinimumSize(new java.awt.Dimension(525, 150));
        TabelData.setPreferredScrollableViewportSize(new java.awt.Dimension(525, 150));
        TabelData.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                TabelDataMouseMoved(evt);
            }
        });
        TabelData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelDataMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelData);

        javax.swing.GroupLayout DatabasesPanelLayout = new javax.swing.GroupLayout(DatabasesPanel);
        DatabasesPanel.setLayout(DatabasesPanelLayout);
        DatabasesPanelLayout.setHorizontalGroup(
            DatabasesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(OtotDanBebanTxt3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DatabasesPanelLayout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(DatabasesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 980, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60))
        );
        DatabasesPanelLayout.setVerticalGroup(
            DatabasesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DatabasesPanelLayout.createSequentialGroup()
                .addComponent(OtotDanBebanTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton3)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        MainPanel.add(DatabasesPanel, "card11");

        InformasiPanel.setBackground(new java.awt.Color(191, 204, 181));

        TxtInfo1.setBackground(new java.awt.Color(0, 51, 255));
        TxtInfo1.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        TxtInfo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TxtInfo1.setText("INFORMASI RULA APPLICATION");

        InfoDeveloper1.setBackground(new java.awt.Color(124, 150, 171));
        InfoDeveloper1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        LblDev2.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        LblDev2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        LblDev2.setText("Developer Aplikasi ");

        ImgDev2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/DeveloperProfile.png"))); // NOI18N

        LblNama2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        LblNama2.setText("Nama            : ");

        Lblnim2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Lblnim2.setText("NIM              :");

        LblProdi2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        LblProdi2.setText("Prodi             :");

        LblSemester2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        LblSemester2.setText("Semester        :");

        LblKampus1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        LblKampus1.setText("Kampus         :");

        Nama2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Nama2.setText("Asep Sutrisna Suhada Putra");

        NIM2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        NIM2.setText("21552011123");

        Prodi2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Prodi2.setText("Teknik Informatika");

        Semester2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Semester2.setText("4 (Empat)");

        Kampus1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Kampus1.setText("Sekolah Tinggi Teknologi Bandung");

        javax.swing.GroupLayout InfoDeveloper1Layout = new javax.swing.GroupLayout(InfoDeveloper1);
        InfoDeveloper1.setLayout(InfoDeveloper1Layout);
        InfoDeveloper1Layout.setHorizontalGroup(
            InfoDeveloper1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoDeveloper1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InfoDeveloper1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LblDev2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(InfoDeveloper1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(ImgDev2)
                        .addGap(44, 44, 44)
                        .addGroup(InfoDeveloper1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(InfoDeveloper1Layout.createSequentialGroup()
                                .addComponent(LblSemester2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Semester2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(InfoDeveloper1Layout.createSequentialGroup()
                                .addComponent(LblNama2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Nama2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(InfoDeveloper1Layout.createSequentialGroup()
                                .addComponent(Lblnim2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(NIM2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(InfoDeveloper1Layout.createSequentialGroup()
                                .addComponent(LblProdi2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Prodi2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(InfoDeveloper1Layout.createSequentialGroup()
                                .addComponent(LblKampus1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Kampus1, javax.swing.GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        InfoDeveloper1Layout.setVerticalGroup(
            InfoDeveloper1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InfoDeveloper1Layout.createSequentialGroup()
                .addComponent(LblDev2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(InfoDeveloper1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ImgDev2)
                    .addGroup(InfoDeveloper1Layout.createSequentialGroup()
                        .addGroup(InfoDeveloper1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblKampus1)
                            .addComponent(Kampus1))
                        .addGap(18, 18, 18)
                        .addGroup(InfoDeveloper1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblNama2)
                            .addComponent(Nama2))
                        .addGap(18, 18, 18)
                        .addGroup(InfoDeveloper1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Lblnim2)
                            .addComponent(NIM2))
                        .addGap(18, 18, 18)
                        .addGroup(InfoDeveloper1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblProdi2)
                            .addComponent(Prodi2))
                        .addGap(18, 18, 18)
                        .addGroup(InfoDeveloper1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LblSemester2)
                            .addComponent(Semester2))))
                .addGap(0, 102, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout InformasiPanelLayout = new javax.swing.GroupLayout(InformasiPanel);
        InformasiPanel.setLayout(InformasiPanelLayout);
        InformasiPanelLayout.setHorizontalGroup(
            InformasiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InformasiPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TxtInfo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InformasiPanelLayout.createSequentialGroup()
                .addContainerGap(210, Short.MAX_VALUE)
                .addComponent(InfoDeveloper1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(193, 193, 193))
        );
        InformasiPanelLayout.setVerticalGroup(
            InformasiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InformasiPanelLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(TxtInfo1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(InfoDeveloper1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172))
        );

        MainPanel.add(InformasiPanel, "card13");

        btnHasil.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnHasil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Ceklis.png"))); // NOI18N
        btnHasil.setText("Cek Hasil");
        btnHasil.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHasil.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHasil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHasilActionPerformed(evt);
            }
        });

        btnDatabases.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnDatabases.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/database-storage .png"))); // NOI18N
        btnDatabases.setText("Database");
        btnDatabases.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDatabases.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDatabases.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatabasesActionPerformed(evt);
            }
        });

        btnInformasi.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        btnInformasi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/info.png"))); // NOI18N
        btnInformasi.setText("Informasi");
        btnInformasi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInformasi.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInformasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformasiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BodyPanelLayout = new javax.swing.GroupLayout(BodyPanel);
        BodyPanel.setLayout(BodyPanelLayout);
        BodyPanelLayout.setHorizontalGroup(
            BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TitelPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(BodyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(BodyPanelLayout.createSequentialGroup()
                        .addComponent(PilihanPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnHasil, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(btnDatabases, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnInformasi, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        BodyPanelLayout.setVerticalGroup(
            BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BodyPanelLayout.createSequentialGroup()
                .addComponent(TitelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(BodyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnDatabases, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHasil, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PilihanPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInformasi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addComponent(MainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 592, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BodyPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Radiobtn_OtotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Radiobtn_OtotActionPerformed
        // TODO add your handling code here:
        MainPanel.removeAll();
        MainPanel.repaint();
        MainPanel.revalidate();
        
        MainPanel.add(OtotPanel);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_Radiobtn_OtotActionPerformed

    private void Radiobtn_KakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Radiobtn_KakiActionPerformed
        // TODO add your handling code here:
        MainPanel.removeAll();
        MainPanel.repaint();
        MainPanel.revalidate();
        
        MainPanel.add(KakiPanel);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_Radiobtn_KakiActionPerformed

    private void Radiobtn_PunggungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Radiobtn_PunggungActionPerformed
        // TODO add your handling code here:
        MainPanel.removeAll();
        MainPanel.repaint();
        MainPanel.revalidate();
        
        MainPanel.add(PunggungPanel);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_Radiobtn_PunggungActionPerformed

    private void Radiobtn_LeherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Radiobtn_LeherActionPerformed
        // TODO add your handling code here:
        MainPanel.removeAll();
        MainPanel.repaint();
        MainPanel.revalidate();
        
        MainPanel.add(LeherPanel);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_Radiobtn_LeherActionPerformed

    private void Radiobtn_PutaranlenganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Radiobtn_PutaranlenganActionPerformed
        // TODO add your handling code here:
        MainPanel.removeAll();
        MainPanel.repaint();
        MainPanel.revalidate();
        
        MainPanel.add(PutaranTanganPanel);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_Radiobtn_PutaranlenganActionPerformed

    private void Radiobtn_PergelanganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Radiobtn_PergelanganActionPerformed
        // TODO add your handling code here:
        MainPanel.removeAll();
        MainPanel.repaint();
        MainPanel.revalidate();
        
        MainPanel.add(PergelanganPanel);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_Radiobtn_PergelanganActionPerformed

    private void Radiobtn_LenganbawahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Radiobtn_LenganbawahActionPerformed
        // TODO add your handling code here:
        MainPanel.removeAll();
        MainPanel.repaint();
        MainPanel.revalidate();
        
        MainPanel.add(LenganBawahPanel);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_Radiobtn_LenganbawahActionPerformed

    private void Radiobtn_LenganatasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Radiobtn_LenganatasActionPerformed
        // TODO add your handling code here:
        MainPanel.removeAll();
        MainPanel.repaint();
        MainPanel.revalidate();
        
        MainPanel.add(LenganAtasPanel);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_Radiobtn_LenganatasActionPerformed

    private void TambahanUA3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahanUA3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TambahanUA3ActionPerformed

    private void LenganAtas5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LenganAtas5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_LenganAtas5ActionPerformed

    private void TambahanLAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahanLAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TambahanLAActionPerformed

    private void TambahanWristActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahanWristActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TambahanWristActionPerformed

    private void PutaranLengan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PutaranLengan1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PutaranLengan1ActionPerformed

    private void PutaranLengan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PutaranLengan2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PutaranLengan2ActionPerformed

    private void cmbLeher1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLeher1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbLeher1ActionPerformed

    private void cmbLeher2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbLeher2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbLeher2ActionPerformed

    private void Punggung2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Punggung2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Punggung2ActionPerformed

    private void cmbPunggung2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPunggung2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPunggung2ActionPerformed

    private void cmbPunggung1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbPunggung1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbPunggung1ActionPerformed

    private void btnDatabasesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatabasesActionPerformed
        // TODO add your handling code here:
        MainPanel.removeAll();
        MainPanel.repaint();
        MainPanel.revalidate();
        
        MainPanel.add(DatabasesPanel);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_btnDatabasesActionPerformed

    private void btnInformasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformasiActionPerformed
        // TODO add your handling code here:
        MainPanel.removeAll();
        MainPanel.repaint();
        MainPanel.revalidate();
        
        MainPanel.add(InformasiPanel);
        MainPanel.repaint();
        MainPanel.revalidate();
    }//GEN-LAST:event_btnInformasiActionPerformed

    private void TabelDataMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelDataMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_TabelDataMouseMoved

    private void TabelDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelDataMouseClicked
        // TODO add your handling code here:
        // Ketika tabel ke tekan
    }//GEN-LAST:event_TabelDataMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void RadioBebanA4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioBebanA4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioBebanA4ActionPerformed

    private void RadioBebanA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RadioBebanA1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RadioBebanA1ActionPerformed

    private void btnHasilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHasilActionPerformed
        // TODO add your handling code here:
        this.dispose();
            new Form3_ResultTes().setVisible(true);
    }//GEN-LAST:event_btnHasilActionPerformed

    private void BtnSimpanMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnSimpanMouseMoved
        // TODO add your handling code here:
        PanelSimpan.setBackground(Color.BLUE);
    }//GEN-LAST:event_BtnSimpanMouseMoved

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        // TODO add your handling code here:
       InsertLenganAtas();
    }//GEN-LAST:event_BtnSimpanActionPerformed

    private void BtnSimpan1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnSimpan1MouseMoved
        // TODO add your handling code here:
        PanelSimpan1.setBackground(Color.BLUE);
    }//GEN-LAST:event_BtnSimpan1MouseMoved

    private void BtnSimpan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpan1ActionPerformed
        // TODO add your handling code here:
        InsertLenganBawah();
    }//GEN-LAST:event_BtnSimpan1ActionPerformed

    private void BtnSimpan2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnSimpan2MouseMoved
        // TODO add your handling code here:
        PanelSimpan2.setBackground(Color.BLUE);
    }//GEN-LAST:event_BtnSimpan2MouseMoved

    private void BtnSimpan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpan2ActionPerformed
        // TODO add your handling code here:
        InsertPergelanganTangan();
    }//GEN-LAST:event_BtnSimpan2ActionPerformed

    private void BtnSimpan3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnSimpan3MouseMoved
        // TODO add your handling code here:
        PanelSimpan3.setBackground(Color.BLUE);
    }//GEN-LAST:event_BtnSimpan3MouseMoved

    private void BtnSimpan3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpan3ActionPerformed
        // TODO add your handling code here:
        InsertPutaranPergelangan();
    }//GEN-LAST:event_BtnSimpan3ActionPerformed

    private void BtnSimpan4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnSimpan4MouseMoved
        // TODO add your handling code here:
        PanelSimpan4.setBackground(Color.BLUE);
    }//GEN-LAST:event_BtnSimpan4MouseMoved

    private void BtnSimpan4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpan4ActionPerformed
        // TODO add your handling code here:
        InsertLeher();
    }//GEN-LAST:event_BtnSimpan4ActionPerformed

    private void BtnSimpan5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnSimpan5MouseMoved
        // TODO add your handling code here:
        PanelSimpan5.setBackground(Color.BLUE);
    }//GEN-LAST:event_BtnSimpan5MouseMoved

    private void BtnSimpan5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpan5ActionPerformed
        // TODO add your handling code here:
        InsertPunggung();
    }//GEN-LAST:event_BtnSimpan5ActionPerformed

    private void BtnSimpan7MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnSimpan7MouseMoved
        // TODO add your handling code here:
        PanelSimpan6.setBackground(Color.BLUE);
    }//GEN-LAST:event_BtnSimpan7MouseMoved

    private void BtnSimpan7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpan7ActionPerformed
        // TODO add your handling code here:
        InsertOtotDanBebanA();
        InsertOtotDanBebanB();
    }//GEN-LAST:event_BtnSimpan7ActionPerformed

    private void BtnSimpan6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BtnSimpan6MouseMoved
        // TODO add your handling code here:
        PanelSimpan7.setBackground(Color.BLUE);
    }//GEN-LAST:event_BtnSimpan6MouseMoved

    private void BtnSimpan6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpan6ActionPerformed
        // TODO add your handling code here:
        InsertKaki();
    }//GEN-LAST:event_BtnSimpan6ActionPerformed

    private void MainPanelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MainPanelMouseMoved
        // TODO add your handling code here:
        PanelSimpan.setBackground(new java.awt.Color(124,150,171));
        PanelSimpan1.setBackground(new java.awt.Color(124,150,171));
        PanelSimpan2.setBackground(new java.awt.Color(124,150,171));
        PanelSimpan3.setBackground(new java.awt.Color(124,150,171));
        PanelSimpan4.setBackground(new java.awt.Color(124,150,171));
        PanelSimpan5.setBackground(new java.awt.Color(124,150,171));
        PanelSimpan6.setBackground(new java.awt.Color(124,150,171));
        PanelSimpan7.setBackground(new java.awt.Color(124,150,171));
    }//GEN-LAST:event_MainPanelMouseMoved

    private void LenganAtas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LenganAtas1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_LenganAtas1ActionPerformed

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
            java.util.logging.Logger.getLogger(Form2_ProsesRulaTes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form2_ProsesRulaTes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form2_ProsesRulaTes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form2_ProsesRulaTes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form2_ProsesRulaTes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BebanAGroup;
    private javax.swing.ButtonGroup BebanBGroup;
    private javax.swing.JPanel BodyPanel;
    private javax.swing.JButton BtnSimpan;
    private javax.swing.JButton BtnSimpan1;
    private javax.swing.JButton BtnSimpan2;
    private javax.swing.JButton BtnSimpan3;
    private javax.swing.JButton BtnSimpan4;
    private javax.swing.JButton BtnSimpan5;
    private javax.swing.JButton BtnSimpan6;
    private javax.swing.JButton BtnSimpan7;
    private javax.swing.JCheckBox CheckOtotA;
    private javax.swing.JCheckBox CheckOtotB;
    private javax.swing.JPanel DatabasesPanel;
    private javax.swing.JLabel ImgDev2;
    private javax.swing.JPanel InfoDeveloper1;
    private javax.swing.JPanel InformasiPanel;
    private javax.swing.JRadioButton Kaki1;
    private javax.swing.JRadioButton Kaki2;
    private javax.swing.ButtonGroup KakiGroup;
    private javax.swing.JLabel KakiLbl1;
    private javax.swing.JLabel KakiLbl2;
    private javax.swing.JPanel KakiPanel;
    private javax.swing.JLabel KakiTxt;
    private javax.swing.JLabel KakiTxt1;
    private javax.swing.JLabel KakiTxt2;
    private javax.swing.JLabel KakiTxt3;
    private javax.swing.JLabel KakiTxt4;
    private javax.swing.JLabel Kampus1;
    private javax.swing.JLabel LabelIdentitas;
    private javax.swing.JLabel LblDev2;
    private javax.swing.JLabel LblKampus1;
    private javax.swing.JLabel LblNama2;
    private javax.swing.JLabel LblProdi2;
    private javax.swing.JLabel LblSemester2;
    private javax.swing.JLabel Lblnim2;
    private javax.swing.JRadioButton Leher;
    private javax.swing.JRadioButton Leher1;
    private javax.swing.JRadioButton Leher2;
    private javax.swing.JRadioButton Leher3;
    private javax.swing.ButtonGroup LeherGroup;
    private javax.swing.JLabel LeherLbl1;
    private javax.swing.JLabel LeherLbl2;
    private javax.swing.JLabel LeherLbl3;
    private javax.swing.JLabel LeherLbl4;
    private javax.swing.JLabel LeherLbl5;
    private javax.swing.JLabel LeherLbl6;
    private javax.swing.JPanel LeherPanel;
    private javax.swing.JLabel LeherTxt;
    private javax.swing.JRadioButton LenganAtas1;
    private javax.swing.JRadioButton LenganAtas2;
    private javax.swing.JRadioButton LenganAtas3;
    private javax.swing.JRadioButton LenganAtas4;
    private javax.swing.JRadioButton LenganAtas5;
    private javax.swing.ButtonGroup LenganAtasGroup;
    private javax.swing.JLabel LenganAtasLbl;
    private javax.swing.JLabel LenganAtasLbl1;
    private javax.swing.JLabel LenganAtasLbl2;
    private javax.swing.JLabel LenganAtasLbl3;
    private javax.swing.JLabel LenganAtasLbl4;
    private javax.swing.JPanel LenganAtasPanel;
    private javax.swing.JRadioButton LenganBawah1;
    private javax.swing.JRadioButton LenganBawah2;
    private javax.swing.JRadioButton LenganBawah3;
    private javax.swing.ButtonGroup LenganBawahGroup;
    private javax.swing.JLabel LenganBawahLbl1;
    private javax.swing.JLabel LenganBawahLbl2;
    private javax.swing.JLabel LenganBawahLbl3;
    private javax.swing.JLabel LenganBawahLbl4;
    private javax.swing.JPanel LenganBawahPanel;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JLabel NIM2;
    private javax.swing.JLabel Nama2;
    private javax.swing.JLabel OtotDanBebanTxt;
    private javax.swing.JLabel OtotDanBebanTxt1;
    private javax.swing.JLabel OtotDanBebanTxt2;
    private javax.swing.JLabel OtotDanBebanTxt3;
    private javax.swing.JPanel OtotPanel;
    private javax.swing.JPanel PanelBebanBagianA;
    private javax.swing.JPanel PanelBebanBagianB;
    private javax.swing.JPanel PanelOtotBagianA;
    private javax.swing.JPanel PanelOtotBagianB;
    private GUI_Custom.PanelRound PanelSimpan;
    private GUI_Custom.PanelRound PanelSimpan1;
    private GUI_Custom.PanelRound PanelSimpan2;
    private GUI_Custom.PanelRound PanelSimpan3;
    private GUI_Custom.PanelRound PanelSimpan4;
    private GUI_Custom.PanelRound PanelSimpan5;
    private GUI_Custom.PanelRound PanelSimpan6;
    private GUI_Custom.PanelRound PanelSimpan7;
    private javax.swing.JRadioButton Pergelangan1;
    private javax.swing.JRadioButton Pergelangan2;
    private javax.swing.JRadioButton Pergelangan3;
    private javax.swing.JRadioButton Pergelangan4;
    private javax.swing.ButtonGroup PergelanganGroup;
    private javax.swing.JLabel PergelanganLbl1;
    private javax.swing.JLabel PergelanganLbl2;
    private javax.swing.JLabel PergelanganLbl3;
    private javax.swing.JLabel PergelanganLbl4;
    private javax.swing.JLabel PergelanganLbl5;
    private javax.swing.JPanel PergelanganPanel;
    private javax.swing.JLabel PergelanganTxt;
    private javax.swing.JPanel PilihanPanel;
    private javax.swing.JLabel Prodi2;
    private javax.swing.JRadioButton Punggung1;
    private javax.swing.JRadioButton Punggung2;
    private javax.swing.JRadioButton Punggung3;
    private javax.swing.JRadioButton Punggung4;
    private javax.swing.JLabel Punggung5;
    private javax.swing.JLabel Punggung6;
    private javax.swing.ButtonGroup PunggungGroup;
    private javax.swing.JLabel PunggungLbl1;
    private javax.swing.JLabel PunggungLbl2;
    private javax.swing.JLabel PunggungLbl3;
    private javax.swing.JLabel PunggungLbl4;
    private javax.swing.JPanel PunggungPanel;
    private javax.swing.JLabel PunggungTxt;
    private javax.swing.JRadioButton PutaranLengan1;
    private javax.swing.JRadioButton PutaranLengan2;
    private javax.swing.ButtonGroup PutaranLenganGroup;
    private javax.swing.JLabel PutaranLenganLbl1;
    private javax.swing.JLabel PutaranLenganLbl2;
    private javax.swing.JPanel PutaranTanganPanel;
    private javax.swing.JLabel PutaranTangantxt;
    private javax.swing.ButtonGroup RULA_btnGroup;
    private javax.swing.JRadioButton RadioBebanA1;
    private javax.swing.JRadioButton RadioBebanA2;
    private javax.swing.JRadioButton RadioBebanA3;
    private javax.swing.JRadioButton RadioBebanA4;
    private javax.swing.JRadioButton RadioBebanB1;
    private javax.swing.JRadioButton RadioBebanB2;
    private javax.swing.JRadioButton RadioBebanB3;
    private javax.swing.JRadioButton RadioBebanB4;
    private javax.swing.JRadioButton Radiobtn_Kaki;
    private javax.swing.JRadioButton Radiobtn_Leher;
    private javax.swing.JRadioButton Radiobtn_Lenganatas;
    private javax.swing.JRadioButton Radiobtn_Lenganbawah;
    private javax.swing.JRadioButton Radiobtn_Otot;
    private javax.swing.JRadioButton Radiobtn_Pergelangan;
    private javax.swing.JRadioButton Radiobtn_Punggung;
    private javax.swing.JRadioButton Radiobtn_Putaranlengan;
    private javax.swing.JLabel Semester2;
    private GUI_Custom.TableDark TabelData;
    private javax.swing.JCheckBox TambahanLA;
    private javax.swing.JPanel TambahanPanel;
    private javax.swing.JPanel TambahanPanel1;
    private javax.swing.JPanel TambahanPanel2;
    private javax.swing.JPanel TambahanPanel3;
    private javax.swing.JPanel TambahanPanel4;
    private javax.swing.JCheckBox TambahanUA1;
    private javax.swing.JCheckBox TambahanUA2;
    private javax.swing.JCheckBox TambahanUA3;
    private javax.swing.JCheckBox TambahanWrist;
    private javax.swing.JLabel Tambahantxt;
    private javax.swing.JLabel Tambahantxt1;
    private javax.swing.JLabel Tambahantxt2;
    private javax.swing.JLabel Tambahantxt3;
    private javax.swing.JLabel Tambahantxt4;
    private javax.swing.JPanel TitelPanel;
    private javax.swing.JLabel TxtInfo1;
    private javax.swing.JPanel WelcomePanel;
    private javax.swing.JButton btnDatabases;
    private javax.swing.JButton btnHasil;
    private javax.swing.JButton btnInformasi;
    private javax.swing.JCheckBox cmbLeher1;
    private javax.swing.JCheckBox cmbLeher2;
    private javax.swing.JCheckBox cmbPunggung1;
    private javax.swing.JCheckBox cmbPunggung2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel txtTitle;
    // End of variables declaration//GEN-END:variables
}
