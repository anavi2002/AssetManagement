package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class AssetDetails extends JFrame implements ActionListener {

    JTable t1;
    JButton b1;
    String x[] = { "Asset Name", "Asset ID", "Owner Name", "Owner ID", "Amount" };
    String y[][] = new String[40][5];
    int i = 0, j = 0;

    AssetDetails(String id, int i) {
        super("Asset Details");
        setSize(1200, 650);
        setLocation(400, 150);

        try {
            Conn c1 = new Conn();
            String s1 = "";
            if (i == 0) {
                s1 = "select * from asset where oid = " + id;
            } else {
                s1 = "select * from asset";
            }

            ResultSet rs = c1.s.executeQuery(s1);
            while (rs.next()) {
                y[i][j++] = rs.getString("name");
                y[i][j++] = rs.getString("id");
                y[i][j++] = rs.getString("oname");
                y[i][j++] = rs.getString("oid");
                y[i][j++] = rs.getString("amount");
                i++;
                j = 0;
            }
            t1 = new JTable(y, x);

        } catch (Exception e) {
            e.printStackTrace();
        }

        b1 = new JButton("Print");
        add(b1, "South");
        JScrollPane sp = new JScrollPane(t1);
        add(sp);
        b1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            t1.print();
        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        new AssetDetails("", 1).setVisible(true);
    }

}
