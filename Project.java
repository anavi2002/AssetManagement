package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Project extends JFrame implements ActionListener {
    String meter;
    int x;

    Project(String meter, String person) {
        super("ASSET MANAGEMENT SYSTEM");
        this.meter = meter;

        setSize(1920, 1030);

        /* Adding background image */
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icon/back.png"));
        Image i3 = ic.getImage().getScaledInstance(1550, 800, Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        JLabel l1 = new JLabel(icc3);
        add(l1);

        /* First Column */
        JMenuBar mb = new JMenuBar();
        JMenu master = new JMenu("VENDOR");
        JMenuItem m1 = new JMenuItem("New vendor");
        JMenuItem m2 = new JMenuItem("Vendor Details");
        master.setForeground(Color.BLACK);

        /* ---- Customer Details ---- */
        m1.setFont(new Font("monospaced", Font.PLAIN, 12));
        // ImageIcon icon1 = new
        // ImageIcon(ClassLoader.getSystemResource("icon/icon1.png"));
        // Image image1 = icon1.getImage().getScaledInstance(20, 20,
        // Image.SCALE_DEFAULT);
        // m1.setIcon(new ImageIcon(image1));
        // m1.setMnemonic('D');
        // m1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,
        // ActionEvent.CTRL_MASK));
        m1.setBackground(Color.WHITE);

        /* ---- Meter Details ---- */
        m2.setFont(new Font("monospaced", Font.PLAIN, 12));
        // ImageIcon icon2 = new
        // ImageIcon(ClassLoader.getSystemResource("icon/icon2.png"));
        // Image image2 = icon2.getImage().getScaledInstance(20, 20,
        // Image.SCALE_DEFAULT);
        // m2.setIcon(new ImageIcon(image2));
        // m2.setMnemonic('M');
        // m2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,
        // ActionEvent.CTRL_MASK));
        m2.setBackground(Color.WHITE);

        /* ---- Deposit Details ----- */

        m1.addActionListener(this);
        m2.addActionListener(this);

        // -----------------------------

        /* Second Column */
        JMenu info = new JMenu("ASSET");
        JMenuItem info1 = new JMenuItem("View Asset");
        JMenuItem info2 = new JMenuItem("Add Asset");
        JMenuItem info3 = new JMenuItem("Delete Asset");
        JMenuItem info4 = new JMenuItem("Edit Asset");
        JMenuItem info5 = new JMenuItem("View All Assets");
        info.setForeground(Color.BLACK);

        /* ---- Pay Bill ---- */
        info1.setFont(new Font("monospaced", Font.PLAIN, 12));
        // ImageIcon icon41 = new
        // ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        // Image image41 = icon41.getImage().getScaledInstance(20, 20,
        // Image.SCALE_DEFAULT);
        // info1.setIcon(new ImageIcon(image41));
        // info1.setMnemonic('P');
        // info1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
        // ActionEvent.CTRL_MASK));
        info1.setBackground(Color.WHITE);

        /* ---- Last Bill ---- */
        info2.setFont(new Font("monospaced", Font.PLAIN, 12));
        // ImageIcon icon42 = new
        // ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        // Image image42 = icon42.getImage().getScaledInstance(20, 20,
        // Image.SCALE_DEFAULT);
        // info2.setIcon(new ImageIcon(image42));
        // info2.setMnemonic('L');
        // info2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
        // ActionEvent.CTRL_MASK));
        info2.setBackground(Color.WHITE);
        info3.setFont(new Font("monospaced", Font.PLAIN, 12));
        info3.setBackground(Color.WHITE);
        info4.setFont(new Font("monospaced", Font.PLAIN, 12));
        info4.setBackground(Color.WHITE);
        info5.setFont(new Font("monospaced", Font.PLAIN, 12));
        info5.setBackground(Color.WHITE);
        info1.addActionListener(this);
        info2.addActionListener(this);
        info3.addActionListener(this);
        info4.addActionListener(this);
        info5.addActionListener(this);
        // --------------------------------------------------------------------------------------------

        /* Second Column */
        JMenu user = new JMenu("UPDATE");
        JMenuItem u1 = new JMenuItem("Edit Vendor");
        JMenuItem u2 = new JMenuItem("Delete Vendor");
        JMenuItem u3 = new JMenuItem("Assign Asset");
        user.setForeground(Color.RED);

        /* ---- Pay Bill ---- */
        u1.setFont(new Font("monospaced", Font.PLAIN, 12));
        // ImageIcon icon4 = new
        // ImageIcon(ClassLoader.getSystemResource("icon/icon4.png"));
        // Image image4 = icon4.getImage().getScaledInstance(20, 20,
        // Image.SCALE_DEFAULT);
        // u1.setIcon(new ImageIcon(image4));
        // u1.setMnemonic('P');
        // u1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
        // ActionEvent.CTRL_MASK));
        u1.setBackground(Color.WHITE);

        /* ---- Last Bill ---- */
        u3.setFont(new Font("monospaced", Font.PLAIN, 12));
        // ImageIcon icon6 = new
        // ImageIcon(ClassLoader.getSystemResource("icon/icon6.png"));
        // Image image6 = icon6.getImage().getScaledInstance(20, 20,
        // Image.SCALE_DEFAULT);
        // u3.setIcon(new ImageIcon(image6));
        // u3.setMnemonic('L');
        // u3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L,
        // ActionEvent.CTRL_MASK));
        u3.setBackground(Color.WHITE);
        u2.setFont(new Font("monospaced", Font.PLAIN, 12));
        u2.setBackground(Color.WHITE);
        u1.addActionListener(this);
        u2.addActionListener(this);
        u3.addActionListener(this);

        // ---------------------------------------------------------------------------------------------

        /* Third Column */
        JMenu report = new JMenu("REPORT");
        JMenuItem r1 = new JMenuItem("Generate Report");
        JMenuItem r2 = new JMenuItem("Export Data");
        report.setForeground(Color.BLACK);

        /* ---- Report ---- */
        r1.setFont(new Font("monospaced", Font.PLAIN, 12));
        // ImageIcon icon7 = new
        // ImageIcon(ClassLoader.getSystemResource("icon/icon7.png"));
        // Image image7 = icon7.getImage().getScaledInstance(20, 20,
        // Image.SCALE_DEFAULT);
        // r1.setIcon(new ImageIcon(image7));
        // r1.setMnemonic('R');
        // r1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
        // ActionEvent.CTRL_MASK));
        r1.setBackground(Color.WHITE);
        r2.setFont(new Font("monospaced", Font.PLAIN, 12));
        r2.setBackground(Color.WHITE);
        r1.addActionListener(this);
        r2.addActionListener(this);
        // -----------------------------------------------------------------------------------------------

        // ---------------------------------------------------------------------------------------

        /* Fifth Column */
        JMenu exit = new JMenu("LOGOUT");
        JMenuItem ex = new JMenuItem("Logout");
        exit.setForeground(Color.BLACK);

        /* ---- Exit ---- */
        ex.setFont(new Font("monospaced", Font.PLAIN, 12));
        // ImageIcon icon11 = new
        // ImageIcon(ClassLoader.getSystemResource("icon/icon11.png"));
        // Image image11 = icon11.getImage().getScaledInstance(20, 20,
        // Image.SCALE_DEFAULT);
        // ex.setIcon(new ImageIcon(image11));
        // ex.setMnemonic('Z');
        // ex.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,
        // ActionEvent.CTRL_MASK));
        ex.setBackground(Color.WHITE);

        ex.addActionListener(this);

        // ---------------------------------------------------------------------------------------------

        master.add(m1);
        master.add(m2);
        // master.add(m3);

        user.add(u1);
        user.add(u2);
        user.add(u3);

        report.add(r1);
        report.add(r2);
        exit.add(ex);

        if (person.equals("Admin")) {
            mb.add(user);
            info.add(info5);
            info.add(info2);
            info.add(info3);
            info.add(info4);
            x = 1;
        } else {
            info.add(info1);
            info.add(info2);
            info.add(info3);
            info.add(info4);
            x = 0;
        }
        mb.add(info);
        mb.add(master);
        mb.add(report);

        mb.add(exit);

        setJMenuBar(mb);

        setFont(new Font("Senserif", Font.BOLD, 25));
        setLayout(new FlowLayout());
        setVisible(false);
    }

    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        if (msg.equals("Vendor Details")) {
            new CustomerDetails().setVisible(true);

        } else if (msg.equals("New vendor")) {
            new NewCustomer().setVisible(true);

        } else if (msg.equals("Add Asset")) {
            new AddAsset().setVisible(true);

        } else if (msg.equals("Delete Asset")) {
            new AssetDelete().setVisible(true);

        } else if (msg.equals("Edit Vendor")) {
            new UpdateInformation().setVisible(true);

        } else if (msg.equals("Export Data")) {//
            ExcelExporter obj = new ExcelExporter();
            ResultSet r = obj.getResultSet();
            int c = obj.getRows(r);
            obj.export(r, c);

        } else if (msg.equals("Logout")) {
            this.setVisible(false);
            new Login().setVisible(true);
        } else if (msg.equals("Generate Report")) {
            new GenerateBill().setVisible(true);

        } else if (msg.equals("Delete Vendor")) {
            new VendorDelete().setVisible(true);
        } else if (msg.equals("View Asset")) {
            new AssetDetails(meter, x).setVisible(true);
        } else if (msg.equals("Edit Asset")) { //
            new EditAsset(meter, x).setVisible(true);
        } else if (msg.equals("Assign Asset")) {
            new UpdateAsset(meter, x).setVisible(true);
        } else if (msg.equals("View All Assets")) {
            new AssetDetails("", x).setVisible(true);
        }

    }// Export Data

    public static void main(String[] args) {
        new Project("", "").setVisible(true);
    }

}
