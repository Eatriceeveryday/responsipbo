package model;

import javax.swing.*;
import java.sql.*;

public class MenuModel extends JFrame {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/aslab_db";
    static final String USER = "root";
    static final String PASS = "";

    Connection koneksi;
    Statement statement;

    public MenuModel(){
        try {
            Class.forName(JDBC_DRIVER);
            koneksi = DriverManager.getConnection(DB_URL,USER,PASS);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Gagal Koneksi ke Server");
        }
    }

    public int getbannyakdata(){
        int Jmldata = 0;
        try {
            statement = koneksi.createStatement();
            String query = "Select * from aslab";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Jmldata++;
            }
            return Jmldata;
        }catch (SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }

    public String[][] readdata(){
        int jmlh = 0;
        try {
            String[][] data = new String[getbannyakdata()][5];
            String query = "Select * from aslab";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                data[jmlh][0] = resultSet.getString("judul");
                data[jmlh][1] = resultSet.getString("portofolio");
                data[jmlh][2] = resultSet.getString("microteaching");
                data[jmlh][3] = resultSet.getString("wawancara");
                data[jmlh][4] = resultSet.getString("nilai");
                jmlh++;
            }
            return data;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
            return null;
        }
    }

    public void insertdata(String nama , double np , double nm , double nw , double nilai){
        int jmlh = 0;
        try {
            String query = "Select * from aslab where judul ='" + nama + "'";
            statement = (Statement) koneksi.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlh++;
            }
            if (jmlh < 1){
                query = "Insert into aslab values ('"+ nama + "','" + np + "','" + nm + "','" + nw + "','" + nilai + "')";
                statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Data berhasil ditambahkan");
            }else {
                JOptionPane.showMessageDialog(null,"Data sudah ada");
            }
        } catch ( SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void updatedata(String nama , double np , double nm , double nw , double nilai){
        int jmlh = 0;
        try {
            String query = "Select * from aslab where judul ='" + nama + "'";
            statement = (Statement) koneksi.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlh++;
            }
            if (jmlh != 0){
                query = "Update aslab set judul ='" + nama + "',portofolio ='"+ np +"', microteaching ='"+ nm + "', wawancara = '" + nw + "', nilai = '" + nilai + "' where judul ='" + nama + "';" ;
                statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Data berhasil update");
            }else {
                JOptionPane.showMessageDialog(null,"Data tidak ada");
            }
        } catch ( SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public  void deletedata(String nama){
        try {
            String query = "Delete from aslab where judul ='" + nama + "'";
            statement = (Statement) koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null,"Data berhasil dihapus");

        }catch ( SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
