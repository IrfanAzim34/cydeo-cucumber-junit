package com.cydeo.apache_POI_Test;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcel {

    String filePath = "SampleData.xlsx";

    XSSFWorkbook workbook;
    XSSFSheet sheet;

    @Test
    public void excelWrite() throws IOException {

        FileInputStream fileInputStream = new FileInputStream(filePath);

        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet("Employees");

        XSSFCell salaryCell = sheet.getRow(0).createCell(3);
        salaryCell.setCellValue("Salary");

        XSSFCell salary1 = sheet.getRow(1).createCell(3);
        salary1.setCellValue(200000);

        XSSFCell salary2 = sheet.getRow(2).createCell(3);
        salary2.setCellValue(110000);

        XSSFCell salary3 = sheet.getRow(3).createCell(3);
        salary3.setCellValue(135000);

        XSSFCell salary4 = sheet.getRow(4).createCell(3);
        salary4.setCellValue(125000);

        // Changes Mary's lastname to Jones
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            if (sheet.getRow(i).getCell(0).toString().equals("Mary")){
                sheet.getRow(i).getCell(1).setCellValue("Jones");
            }
        }

        // Open to write to the file : FileInputStream --> reading
        // save changes              : FileOutputStream --> writing
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);

        // save/write changes to the workbook
        workbook.write(fileOutputStream);

        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();

    }
}
