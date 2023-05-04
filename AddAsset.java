
package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class AddAsset extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l11;
    JTextField t1, t2, t3, t4, t5, t6, t7;
    JButton b1, b2;

    AddAsset() {
        setLocation(600, 200);
        setSize(700, 500);

        JPanel p = new JPanel();
        p.setLayout(null);
        p.setBackground(Color.WHITE);
        p.setBackground(new Color(173, 216, 230));

        JLabel title = new JLabel("New Asset");
        title.setBounds(180, 10, 200, 26);
        title.setFont(new Font("Tahoma", Font.PLAIN, 24));
        p.add(title);

        l1 = new JLabel("Asset Name");
        l1.setBounds(100, 80, 100, 20);

        t1 = new JTextField();
        t1.setBounds(240, 80, 200, 20);
        p.add(l1);
        p.add(t1);
        l2 = new JLabel("Asset ID");
        l2.setBounds(100, 120, 100, 20);
        l11 = new JLabel();
        l11.setBounds(240, 120, 200, 20);
        p.add(l2);
        p.add(l11);
        l3 = new JLabel("Owner Name");
        l3.setBounds(100, 160, 100, 20);
        t3 = new JTextField();
        t3.setBounds(240, 160, 200, 20);
        p.add(l3);
        p.add(t3);
        l5 = new JLabel("Owner ID");
        l5.setBounds(100, 200, 100, 20);
        t4 = new JTextField();
        t4.setBounds(240, 200, 200, 20);
        p.add(l5);
        p.add(t4);
        l4 = new JLabel("Asset Amount");
        l4.setBounds(100, 240, 100, 20);
        t5 = new JTextField();
        t5.setBounds(240, 240, 200, 20);
        p.add(l4);
        p.add(t5);
        /*
         * /
         * l6 = new JLabel("Email");
         * l6.setBounds(100, 280, 100, 20);
         * t6 = new JTextField();
         * t6.setBounds(240, 280, 200, 20);
         * p.add(l6);
         * p.add(t6);
         * l7 = new JLabel("Phone Number");
         * l7.setBounds(100, 320, 100, 20);
         * t7 = new JTextField();
         * t7.setBounds(240, 320, 200, 20);
         * p.add(l7);
         * p.add(t7);
         */

        b1 = new JButton("Next");
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

        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icon/hicon1.jpg"));
        Image i3 = ic1.getImage().getScaledInstance(150, 300, Image.SCALE_DEFAULT);
        ImageIcon ic2 = new ImageIcon(i3);
        l8 = new JLabel(ic2);

        add(l8, "West");
        // for changing the color of the whole Frame
        getContentPane().setBackground(Color.WHITE);

        b1.addActionListener(this);
        b2.addActionListener(this);

        Random ran = new Random();
        long first = (ran.nextLong() % 1000000);
        l11.setText("" + Math.abs(first));

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            String name = t1.getText();
            String id = l11.getText();
            String owner_name = t3.getText();
            String owner_id = t4.getText();
            String amount = t5.getText();
            int amt = Integer.parseInt(amount);
            String q1 = "insert into asset values('" + name + "','" + id + "','" + owner_name + "','" + owner_id + "','"
                    + amt + "')";
            // String q2 = "insert into login values('"+meter+"', '', '', '', '')";
            try {
                Conn c1 = new Conn();
                c1.s.executeUpdate(q1);
                // c1.s.executeUpdate(q2);
                JOptionPane.showMessageDialog(null, "Asset Details Added Successfully");
                this.setVisible(false);
                new AssetInfo(id, name, amount).setVisible(true);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else if (ae.getSource() == b2) {
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddAsset().setVisible(true);
    }
}
