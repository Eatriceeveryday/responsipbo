package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MenuView extends JFrame {
    JLabel lnama = new JLabel("Nama");
    JLabel lnp = new JLabel("Nilai Portofolio");
    JLabel lnm = new JLabel("Nilai Microteaching");
    JLabel lnw = new JLabel("Nilai Wawancara");

    public JTextField tfnama = new JTextField();
    public JTextField tfnp = new JTextField();
    public JTextField tfnm = new JTextField();
    public JTextField tfnw = new JTextField();

    public JButton btn_tambah = new JButton("Tambah");
    public JButton btn_update = new JButton("Update");
    public JButton btn_delete = new JButton("Delete");
    public JButton btn_clear = new JButton("Clear");

    public JTable table;
    DefaultTableModel dtm;
    JScrollPane jScrollPane;
    public Object namakolom[] = {"Nama" , "Portofolio" , "Microteaching" , "Wawancara" , "Nilai"};

    public MenuView(){
        dtm = new DefaultTableModel(namakolom,0);
        table = new JTable(dtm);
        jScrollPane = new JScrollPane(table);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,800);
        setLayout(null);
        setVisible(true);

        add(jScrollPane);
        add(lnama); add(tfnama);
        add(lnm); add(tfnm);
        add(lnp); add(tfnp);
        add(lnw); add(tfnw);
        add(btn_tambah);
        add(btn_update);
        add(btn_delete);
        add(btn_clear);

        jScrollPane.setBounds(20,20,450,600);
        lnama.setBounds(500,30,100,30);
        tfnama.setBounds(500,60,180,30);
        lnp.setBounds(500,100,100,30);
        tfnp.setBounds(500,130,180,30);
        lnm.setBounds(500,170,150,30);
        tfnm.setBounds(500,200,180,30);
        lnw.setBounds(500,240,100,30);
        tfnw.setBounds(500,270,180,30);

        btn_tambah.setBounds(500,400,100,30);
        btn_update.setBounds(500,450,100,30);
        btn_delete.setBounds(500,500,100,30);
        btn_clear.setBounds(500,550,100,30);
    }

    public String getnama(){
        return tfnama.getText();
    }

    public String getnp(){
        return tfnp.getText();
    }

    public String getnw(){
        return tfnw.getText();
    }

    public String getnm(){
        return tfnm.getText();
    }
}
