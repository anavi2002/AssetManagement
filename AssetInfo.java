
package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class AssetInfo extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l10, l11;
    // JTextArea c1, c2, c3, c4, c5;
    JTextField c1, c2, c3, c5, l9;
    JButton b1, b2;
    Choice c4;
    String name, amount;

    AssetInfo(String asset, String name, String amount) {
        setLocation(600, 200);
        setSize(700, 500);
        this.name = name;
        this.amount = amount;
        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(new Color(173, 216, 230));

        JLabel title = new JLabel("Asset Information");
        title.setBounds(180, 10, 200, 26);
        title.setFont(new Font("Tahoma", Font.PLAIN, 24));
        p.add(title);

        l1 = new JLabel("Asset Number");
        l1.setBounds(100, 80, 100, 20);

        l11 = new JLabel(asset);
        l11.setBounds(240, 80, 200, 20);
        p.add(l1);
        p.add(l11);

        l2 = new JLabel("Asset Location");
        l2.setBounds(100, 120, 100, 20);
        c1 = new JTextField();
        c1.setBounds(240, 120, 200, 20);
        p.add(l2);
        p.add(c1);

        l3 = new JLabel("Asset Department");
        l3.setBounds(100, 160, 100, 20);
        c2 = new JTextField();

        c2.setBounds(240, 160, 200, 20);
        p.add(l3);
        p.add(c2);

        l5 = new JLabel("Asset Month");
        l5.setBounds(100, 200, 100, 20);
        c3 = new JTextField();

        c3.setBounds(240, 200, 200, 20);
        p.add(l5);
        p.add(c3);

        l4 = new JLabel("Asset Status");
        l4.setBounds(100, 240, 100, 20);
        c4 = new Choice();
        c4.add("Active");
        c4.add("Inactive");
        c4.setBounds(240, 240, 200, 20);
        p.add(l4);
        p.add(c4);

        l6 = new JLabel("Vendor");
        l6.setBounds(100, 280, 100, 20);

        l9 = new JTextField();
        l9.setBounds(240, 280, 200, 20);
        p.add(l6);
        p.add(l9);

        b1 = new JButton("Submit");
        b1.setBounds(120, 390, 100, 25);
        b2 = new JButton("Cancel");
        b2.setBounds(250, 390, 100, 25);

        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);

        p.add(b1);
        p.add(b2);
        setLayout(new BorderLayout());

        add(p, "Center");

        getContentPane().setBackground(Color.WHITE);

        b1.addActionListener(this);
        b2.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String asset_number = l11.getText();
            String asset_location = c1.getText();
            String asset_type = c2.getText();
            String phase_code = c3.getText();
            String bill_type = c4.getSelectedItem();
            String days = l9.getText();

            String q1 = "insert into assetdetails values('" + asset_number + "','" + name + "','" + asset_location
                    + "','"
                    + phase_code
                    + "','" + amount + "','" + days + "','" + bill_type + "', '" + asset_type + "')";
            try {
                Conn c1 = new Conn();
                c1.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "asset Info Added Successfully");
                this.setVisible(false);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (ae.getSource() == b2) {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AssetInfo("", "", "").setVisible(true);
    }
}
