package com.cydeo.apache_POI_Test;

import com.cydeo.pages.vyTrack.VyTrackDashboardPage;
import com.cydeo.pages.vyTrack.VyTrackLoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class VyTrackLoginDDTTest {

    VyTrackLoginPage loginPage = new VyTrackLoginPage();
    VyTrackDashboardPage dashboardPage = new VyTrackDashboardPage();

    @Before
    public void setUp() {
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));
    }

    @After
    public void tearDown() {
        Driver.closeDriver();
    }

    @Test
    public void loginDDTTest() throws IOException {
        String filePath = "VyTrackQa2Users.xlsx";
        FileInputStream fis = new FileInputStream(filePath);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("data");

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            loginPage.login(
                    sheet.getRow(i).getCell(0).toString(),
                    sheet.getRow(i).getCell(1).toString());

            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
            WebElement loaderMask = Driver.getDriver().findElement(By.cssSelector("div[class='loader-mask shown']"));
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));

            String expectedFullName =
                    sheet.getRow(i).getCell(2).toString() + " " +
                            sheet.getRow(i).getCell(3).toString();

            String actualFullName = dashboardPage.fullName.getText().trim();

            if (actualFullName.equals(expectedFullName)){
                sheet.getRow(i).getCell(4).setCellValue("PASS");
            }else {
                sheet.getRow(i).getCell(4).setCellValue("FALSE");
            }

            dashboardPage.logout();
        }

        FileOutputStream fos = new FileOutputStream(filePath);
        workbook.write(fos);

        fis.close();
        workbook.close();
        fos.close();
    }

}
