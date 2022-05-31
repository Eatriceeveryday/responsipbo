package controller;

import model.MenuModel;
import view.MenuView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuController {
    MenuModel menuModel;
    MenuView menuView;

    public MenuController(MenuModel menuModel,MenuView menuView){
        this.menuModel = menuModel;
        this.menuView = menuView;

        if (menuModel.getbannyakdata() != 0){
            String[][] data = menuModel.readdata();
            menuView.table.setModel((new JTable(data,menuView.namakolom).getModel()));
        }

        menuView.btn_tambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] cek = cekinput();

                if (cek[0] == 0){
                    String nama = menuView.getnama();
                    double np = Double.parseDouble(menuView.getnp());
                    double nm = Double.parseDouble(menuView.getnm());
                    double nw = Double.parseDouble(menuView.getnw());
                    double nilai = nm + np + nw;
                    nilai = nilai/3;

                    menuModel.insertdata(nama,np,nm,nw,nilai);
                    String[][] data = menuModel.readdata();
                    menuView.table.setModel((new JTable(data,menuView.namakolom).getModel()));
                }else {
                    if (cek[1] == 1){
                        JOptionPane.showMessageDialog(null,"Nilai Maksimum 100");
                    }else {
                        JOptionPane.showMessageDialog(null,"Nilai Minimum 0");
                    }
                }

            }
        });

        menuView.btn_update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int[] cek = cekinput();

                if (cek[0] == 0){
                    String nama = menuView.getnama();
                    double np = Double.parseDouble(menuView.getnp());
                    double nm = Double.parseDouble(menuView.getnm());
                    double nw = Double.parseDouble(menuView.getnw());
                    double nilai = nm + np + nw;
                    nilai = nilai/3;

                    menuModel.updatedata(nama,np,nm,nw,nilai);
                    String[][] data = menuModel.readdata();
                    menuView.table.setModel((new JTable(data,menuView.namakolom).getModel()));
                }else {
                    if (cek[1] == 1){
                        JOptionPane.showMessageDialog(null,"Nilai Maksimum 100");
                    }else {
                        JOptionPane.showMessageDialog(null,"Nilai Minimum 0");
                    }
                }

            }
        });

        menuView.btn_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuView.tfnama.setText("");
                menuView.tfnm.setText("");
                menuView.tfnp.setText("");
                menuView.tfnw.setText("");
            }
        });

        menuView.table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                int baris = menuView.table.getSelectedRow();
                String[] nilai = new String[4];
                for (int i = 0 ; i <= 3 ; i++){
                    nilai[i] = menuView.table.getModel().getValueAt(baris,i).toString();
                }
                menuView.tfnama.setText(nilai[0]);
                menuView.tfnp.setText(nilai[1]);
                menuView.tfnm.setText(nilai[2]);
                menuView.tfnw.setText(nilai[3]);
            }
        });

        menuView.btn_delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = menuView.getnama();
                menuModel.deletedata(nama);
                String[][] data = menuModel.readdata();
                menuView.table.setModel((new JTable(data,menuView.namakolom).getModel()));

            }
        });

    }

    public int[] cekinput(){
        int[] cek = new int[2];
        cek[0] = 0;
        double np = Double.parseDouble(menuView.getnp());
        double nm = Double.parseDouble(menuView.getnm());
        double nw = Double.parseDouble(menuView.getnw());

        double[] data = {np,nm,nw};
        for (int i=0; i < data.length ; i++ ){
            if (data[i] > 100 ){
                cek[0] = 1;
                cek[1] = 1;
            } else if(data[i] < 0){
                cek[0] = 1;
                cek[1] = 2;
            }
        }
        return cek;
    }


}
