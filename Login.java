package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1, b2, b3;
    JPanel p1, p2, p3, p4;
    Choice c1;

    Login() {
        super("LOGIN PAGE");
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        l1 = new JLabel("USERNAME");
        l1.setBounds(300, 200, 100, 30);
        add(l1);
        l2 = new JLabel("PASSWORD");
        l2.setBounds(300, 240, 100, 30);
        add(l2);

        tf1 = new JTextField(15);
        tf1.setBounds(400, 200, 150, 30);
        add(tf1);
        pf2 = new JPasswordField(15);
        pf2.setBounds(400, 240, 150, 30);
        add(pf2);

        l4 = new JLabel("Logging in as");
        l4.setBounds(300, 280, 100, 30);
        add(l4);

        c1 = new Choice();
        c1.add("Admin");
        c1.add("Employee");
        c1.setBounds(400, 280, 150, 30);
        add(c1);

        ImageIcon ic1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        Image i1 = ic1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        b1 = new JButton("Login", new ImageIcon(i1));
        b1.setBounds(430, 360, 100, 20);
        add(b1);

        ImageIcon ic2 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.jpg"));
        Image i2 = ic2.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        b2 = new JButton("Cancel", new ImageIcon(i2));
        b2.setBounds(430, 400, 100, 20);
        add(b2);

        ImageIcon ic4 = new ImageIcon(ClassLoader.getSystemResource("icon/signup.png"));
        Image i4 = ic4.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        b3 = new JButton("Signup", new ImageIcon(i4));
        b3.setBounds(430, 440, 100, 20);
        add(b3);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);

        // ImageIcon ic3 = new
        // ImageIcon(ClassLoader.getSystemResource("icon/second.jpg"));
        // Image i3 = ic3.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        // ImageIcon icc3 = new ImageIcon(i3);
        // l3 = new JLabel(icc3);
        // l3.setBounds(0, 0, 250, 250);
        // add(l3);

        setLayout(new BorderLayout());

        setSize(1000, 1000);
        setLocation(0, 0);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == b1) {
            try {
                Conn c = new Conn();
                String a = tf1.getText();
                String b = new String(pf2.getPassword());
                // String a = "admin";
                // String b = "admin";
                String user = c1.getSelectedItem();
                String q = "select * from login where username = '" + a + "' and password = '" + b + "' and user = '"
                        + user + "'";
                ResultSet rs = c.s.executeQuery(q);
                if (rs.next()) {
                    String meter = rs.getString("id");
                    new Project(meter, user).setVisible(true);
                    this.setVisible(false);

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid login");
                    tf1.setText("");
                    pf2.setText("");
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("error: " + e);
            }
        } else if (ae.getSource() == b2) {
            this.setVisible(false);
        } else if (ae.getSource() == b3) {
            this.setVisible(false);
            new Signup().setVisible(true);

        }
    }

    public void setDetails(int m, String name, String email) {
        Model model = new Model(m, name, email);
        model.setID(m);
        model.setEmail(email);
        model.setName(name);
    }

    public static void main(String[] args) {
        new Login().setVisible(true);
    }

}
