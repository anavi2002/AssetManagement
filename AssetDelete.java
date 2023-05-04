package Electricity;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class AssetDelete extends JFrame implements ActionListener {
    JTextField t1, l11;
    JLabel l12;
    JButton b1, b2, b3;
    String id;
    Conn c;

    AssetDelete() {
        c = new Conn();
        setBounds(500, 220, 1050, 450);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel title = new JLabel("DELETE ASSET INFORMATION");
        title.setBounds(110, 0, 400, 30);
        title.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(title);
        JLabel l2 = new JLabel("ASSET ID");
        l2.setBounds(30, 70, 100, 20);
        add(l2);
        l11 = new JTextField();
        l11.setBounds(230, 70, 200, 20);
        add(l11);

        b3 = new JButton("Done");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(470, 70, 100, 20);
        b3.addActionListener(this);
        add(b3);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b3) {
            id = l11.getText();
            try {
                System.out.println(id);
                c.s.executeUpdate("delete from asset where id = '" + id + "'");
                c.s.executeUpdate("update assetdetails set status = 'Inactive' where id = '" + id + "'");
                JOptionPane.showMessageDialog(null, "Details Deleted Successfully");
                this.setVisible(false);
            } catch (Exception e) {
            }
        }
    }
}