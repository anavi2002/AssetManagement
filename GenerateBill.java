package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class GenerateBill extends JFrame implements ActionListener {
    JLabel l1, l2;
    JTextArea t1;
    JButton b1;
    Choice c2;
    JPanel p1;
    String meter;
    Conn c;

    GenerateBill() {

        c = new Conn();
        setSize(500, 500);
        setLayout(new BorderLayout());

        p1 = new JPanel();

        l1 = new JLabel("Generate Report");

        l2 = new JLabel("Attributes:");
        c2 = new Choice();
        // ResultSet rs = c.s.executeQuery("select * from assetdetails");
        // while (rs.next()) {
        // (rs.getString(1));
        // l12.setText(rs.getString(2));
        // t1.setText(rs.getString(3));
        // t2.setText(rs.getString(4));
        // t3.setText(rs.getString(5));
        // t4.setText(rs.getString(6));
        // t5.setText(rs.getString(7));

        // }
        c2.add("Location");
        c2.add("Amount");
        c2.add("Department");
        c2.add("Vendor");
        c2.add("Status");
        c2.add("Month");

        t1 = new JTextArea(50, 15);
        t1.setText(
                "\n\n\t------- Click on the -------\n\t Generate Report Button to get\n\tthe bill of the Selected Month\n\n");
        JScrollPane jsp = new JScrollPane(t1);
        t1.setFont(new Font("Senserif", Font.ITALIC, 18));

        b1 = new JButton("Generate Report");

        p1.add(l1);
        p1.add(l2);
        p1.add(c2);
        add(p1, "North");

        add(jsp, "Center");
        add(b1, "South");

        b1.addActionListener(this);

        setLocation(750, 100);
    }

    public void actionPerformed(ActionEvent ae) {
        try {

            String column = c2.getSelectedItem().toLowerCase();
            t1.setText("\tAsset Management\n Report for  " + column + " of the assets\n\n\n");

            ResultSet rs = c.s
                    .executeQuery("SELECT " + column + ", COUNT(*) AS count FROM assetdetails GROUP BY " + column);

            /*
             * 
             * // Print the results
             * while (rs.next()) {
             * 
             * System.out.println(value + ": " + count);
             * }
             */
            while (rs.next()) {
                String value = rs.getString(column);
                int count = rs.getInt("count");
                t1.append("\n " + value + "  :  " + count);
                t1.append("\n");
            }
            /*
             * rs = c.s.executeQuery("select * from meter_info where meter_number = " +
             * meter);
             * 
             * if (rs.next()) {
             * t1.append("\n    Meter Location:" + rs.getString("meter_location"));
             * t1.append("\n    Meter Type:      " + rs.getString("meter_type"));
             * t1.append("\n    Phase Code:    " + rs.getString("phase_code"));
             * t1.append("\n    Bill Type:         " + rs.getString("bill_type"));
             * t1.append("\n    Days:               " + rs.getString("days"));
             * t1.append("\n");
             * }
             * rs = c.s.executeQuery("select * from tax");
             * if (rs.next()) {
             * t1.append("---------------------------------------------------------------");
             * t1.append("\n\n");
             * t1.append("\n Cost per Unit:             Rs " +
             * rs.getString("cost_per_unit"));
             * t1.append("\n Meter Rent:                Rs " + rs.getString("meter_rent"));
             * t1.append("\n Service Charge:            Rs " +
             * rs.getString("service_charge"));
             * t1.append("\n Service Tax:               Rs " + rs.getString("service_tax"));
             * t1.append("\n Swacch Bharat Cess:        Rs " +
             * rs.getString("swacch_bharat_cess"));
             * t1.append("\n Fixed Tax:                 Rs " + rs.getString("fixed_tax"));
             * t1.append("\n");
             * 
             * }
             * 
             * rs = c.s.executeQuery(
             * "select * from bill where meter=" + meter + " AND month = '" +
             * c2.getSelectedItem() + "'");
             * 
             * if (rs.next()) {
             * t1.append("\n    Current Month :\t" + rs.getString("month"));
             * t1.append("\n    Units Consumed:\t" + rs.getString("units"));
             * t1.append("\n    Total Charges :\t" + rs.getString("total_bill"));
             * t1.append("\n---------------------------------------------------------------"
             * );
             * t1.append("\n    TOTAL PAYABLE :\t" + rs.getString("total_bill"));
             * }
             */

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new GenerateBill().setVisible(true);
    }
}
