package Electricity;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.ResultSet;

import javax.swing.JFileChooser;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.mysql.cj.protocol.Resultset;

// import GUI.Error_Dialog;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class ExcelExporter {
    private String[] columnNames = { "Asset ID", "Asset Name", "Location", "Month", "Amount", "Vendor", "Status",
            "Department" };
    private String[][] data_rows;
    private XSSFSheet sheet;
    private XSSFWorkbook workbook;

    public void export(ResultSet rs, int rows) {
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Assets");
        this.data_rows = new String[rows][this.columnNames.length];
        storeData(rs);
        writeHeaderLine(sheet);
        writeDataLines();
        FileOutputStream outputStream;
        try {
            LookAndFeel Default_laf = UIManager.getLookAndFeel();
            String System_laf = UIManager.getSystemLookAndFeelClassName();
            UIManager.setLookAndFeel(System_laf);
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.addChoosableFileFilter(
                    new FileNameExtensionFilter("Microsoft Excel Spreadsheet (*.xlsx)", "xlsx"));
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            int option = fileChooser.showSaveDialog(null);
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                String fname = file.getAbsolutePath();
                if (!fname.endsWith(".xlsx")) {
                    fname += ".xlsx";
                }
                outputStream = new FileOutputStream(fname);
                workbook.write(outputStream);
                outputStream.close();
                JOptionPane.showMessageDialog(null, "Data Exported Successfully");
                // Error_Dialog.showInfo("Data successfully exported.");
            }
            workbook.close();
            UIManager.setLookAndFeel(Default_laf);
        } catch (Exception e) {
            // Error_Dialog.showError(e);
        }
    }

    private void storeData(ResultSet result) {
        int currentRowIndex = 0;
        try {
            while (result.next()) {
                this.data_rows[currentRowIndex][0] = result.getString("id");
                this.data_rows[currentRowIndex][1] = result.getString("name");
                this.data_rows[currentRowIndex][2] = result.getString("location");
                this.data_rows[currentRowIndex][3] = result.getString("month");
                this.data_rows[currentRowIndex][4] = result.getString("amount");
                this.data_rows[currentRowIndex][5] = result.getString("vendor");
                this.data_rows[currentRowIndex][6] = result.getString("status");
                this.data_rows[currentRowIndex][7] = result.getString("department");
                currentRowIndex++;
            }

        } catch (Exception e) {
            // Error_Dialog.showError(e);
        }
    }

    private void writeDataLines() {
        writeHeaderLine(sheet);
        int rowNum = 1;
        for (String[] current_row : data_rows) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (String field : current_row) {
                Cell cell = row.createCell(colNum++);
                cell.setCellValue(field);
            }
        }

    }

    private void writeHeaderLine(XSSFSheet sheet) {
        Row headerRow = sheet.createRow(0);
        Cell headerCell;
        for (int i = 0; i < this.columnNames.length; i++) {
            headerCell = headerRow.createCell(i);
            headerCell.setCellValue(this.columnNames[i]);
        }
    }

    public ResultSet getResultSet() {
        Conn c1 = new Conn();
        String s1 = "select * from assetdetails";
        ResultSet rs = null;
        try {
            rs = c1.s.executeQuery(s1);
        } catch (Exception e) {
            // Error_Dialog.showError(e);
        }
        return rs;
    }

    /* Get number of rows in a ResultSet */
    public int getRows(ResultSet rs) {
        int count = 0;
        try {
            rs.last();
            count = rs.getRow();
            rs.beforeFirst();
        } catch (SQLException e) {
            // Error_Dialog.showError(e);
        }
        return count;
    }

    // void init() {

    // ResultSet r = obj.getResultSet();
    // int c = obj.getRows(r);
    // obj.export(r, c);
    // }

}
