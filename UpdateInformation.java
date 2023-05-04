/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Electricity;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateInformation extends JFrame implements ActionListener {
    JTextField t1, t2, t3, t4, t5, t6, t7, l11;
    JLabel l12;
    JButton b1, b2, b3;
    String id;
    Conn c;

    UpdateInformation() {
        c = new Conn();
        setBounds(500, 220, 1050, 450);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel title = new JLabel("UPDATE VENDOR INFORMATION");
        title.setBounds(110, 0, 400, 30);
        title.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(title);
        JLabel l2 = new JLabel("Vendor ID");
        l2.setBounds(30, 70, 100, 20);
        add(l2);
        l11 = new JTextField();
        l11.setBounds(230, 70, 200, 20);
        add(l11);

        b3 = new JButton("Next");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        b3.setBounds(470, 70, 100, 20);
        b3.addActionListener(this);
        add(b3);
        JLabel l1 = new JLabel("Name");
        l1.setBounds(30, 110, 100, 20);
        add(l1);
        JLabel l3 = new JLabel("Address");
        l3.setBounds(30, 150, 100, 20);
        add(l3);
        JLabel l4 = new JLabel("City");
        l4.setBounds(30, 190, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("State");
        l5.setBounds(30, 230, 100, 20);
        add(l5);
        JLabel l6 = new JLabel("Email");
        l6.setBounds(30, 270, 100, 20);
        add(l6);
        JLabel l7 = new JLabel("Phone");
        l7.setBounds(30, 310, 100, 20);
        add(l7);
        b1 = new JButton("Update");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(70, 360, 100, 25);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(230, 360, 100, 25);
        b2.addActionListener(this);
        add(b2);
    }

    public void details() {
        id = l11.getText();

        l12 = new JLabel();
        l12.setBounds(230, 110, 200, 20);
        add(l12);

        t1 = new JTextField();
        t1.setBounds(230, 150, 200, 20);
        add(t1);

        t2 = new JTextField();
        t2.setBounds(230, 190, 200, 20);
        add(t2);

        t3 = new JTextField();
        t3.setBounds(230, 230, 200, 20);
        add(t3);

        t4 = new JTextField();
        t4.setBounds(230, 270, 200, 20);
        add(t4);

        t5 = new JTextField();
        t5.setBounds(230, 310, 200, 20);
        add(t5);

        try {

            ResultSet rs = c.s.executeQuery("select * from vendor where id = '" + id + "'");
            while (rs.next()) {
                l11.setText(rs.getString(1));
                l12.setText(rs.getString(2));
                t1.setText(rs.getString(3));
                t2.setText(rs.getString(4));
                t3.setText(rs.getString(5));
                t4.setText(rs.getString(6));
                t5.setText(rs.getString(7));

            }
            // System.out.println("Done");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b3) {
            details();
            // ImageIcon i1 = new
            // ImageIcon(ClassLoader.getSystemResource("icon/update.jpg"));
            // Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
            // ImageIcon i3 = new ImageIcon(i2);
            // JLabel l8 = new JLabel(i3);
            // l8.setBounds(550, 50, 400, 300);
            // add(l8);
        }
        if (ae.getSource() == b1) {
            // System.out.println("done2");
            String s1 = l11.getText();
            String s2 = l12.getText();
            String s3 = t1.getText();
            String s4 = t2.getText();
            String s5 = t3.getText();
            String s6 = t4.getText();
            String s7 = t5.getText();

            try {

                c.s.executeUpdate("update vendor set address = '" + s3 + "', city = '" + s4 + "', state = '" + s5
                        + "', email = '" + s6 + "', phone = '" + s7 + "' where id = '" + id + "'");
                JOptionPane.showMessageDialog(null, "Details Updated Successfully");
                this.setVisible(false);

            } catch (Exception e) {
            }

        } else if (ae.getSource() == b2) {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new UpdateInformation().setVisible(true);

    }
}
