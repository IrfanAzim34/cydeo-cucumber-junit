package com.cydeo.apache_POI_Test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelRead {

    @Test
    public void readFromExcelFile() throws IOException {
        String path = "SampleData.xlsx";

        // to read from excel we need to load it to FileInputStream
        FileInputStream fileInputStream = new FileInputStream(path);

        // workbook>sheet>row>cell
        // <1> Create a workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        // <2> We need to get specific sheet from currently opened workbook
        XSSFSheet sheet = workbook.getSheet("Employees");

        // <3> Select row and cell
        //Print out mary's cell
        // Indexes start from 0
        System.out.println(sheet.getRow(1).getCell(0));

        // print out Developer
        System.out.println(sheet.getRow(3).getCell(2));

        // Return the count of used cells only
        // Starts counting from 1
        int usedRows = sheet.getPhysicalNumberOfRows();
        System.out.println("usedRows = " + usedRows);

        // Return the numbers from top cell to bottom cell
        // It doesn't care if the cell is empty or not
        // Starts counting from 0
        int lastUsedRow = sheet.getLastRowNum();
        System.out.println("lastUsedRow = " + lastUsedRow);

        // Create a logic to print Linda's name

        for (int i = 0; i < usedRows; i++) {
            if (sheet.getRow(i).getCell(0).toString().equals("Linda")) {
                System.out.println(sheet.getRow(i).getCell(0));
            }
        }

        // Create a logic to print out Linda's JobID
        // Check if name is Linda --> print out JobID of Linda
        for (int i = 0; i < usedRows; i++) {
            if (sheet.getRow(i).getCell(0).toString().equals("Linda")){
                System.out.println(sheet.getRow(i).getCell(2));
            }
        }

    }


}
