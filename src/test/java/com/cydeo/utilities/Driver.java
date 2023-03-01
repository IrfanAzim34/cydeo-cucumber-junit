package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    /*
    Creating a private constructor, so we are closing access to the object of this class from outside the class
     */
    private Driver() {
    }

    /*
    We make WebDriver private, because we want to close access from outside the class
    We make it static because we weill use it in static method
     */
//    private static WebDriver driver;

    /*
    Create a re-usable utility method which will return same driver instance when we call it
     */
//    public static WebDriver getDriver(){
//
//        if (driver == null){
//
//            /*
//            We read our browser type from Configuration.properties
//            This way, we can control which browser is opened from outside our code, from Configuration.properties
//             */
//            String  browserType = ConfigurationReader.getProperty("browser");
//            switch (browserType){
//                case "chrome":
//                    WebDriverManager.chromedriver().setup();
//                    driver = new ChromeDriver();
//                    driver.manage().window().maximize();
//                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//                    break;
//
//                case "firefox":
//                    WebDriverManager.firefoxdriver().setup();
//                    driver = new FirefoxDriver();
//                    driver.manage().window().maximize();
//                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//                    break;
//
//                case "edge":
//                    WebDriverManager.edgedriver().setup();
//                    driver = new EdgeDriver();
//                    driver.manage().window().maximize();
//                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//                    break;
//
//                case "opera":
//                    WebDriverManager.operadriver().setup();
//                    driver = new OperaDriver();
//                    driver.manage().window().maximize();
//                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//                    break;
//            }
//        }
//
//        return driver;
//
//    }
/*

    This method will make sure our driver value is always null after using quit() method
     */
//    public static void closeDriver() {
//
//        if (driver != null) {
//            driver.quit();// Terminate  the existing session, value will not even null
//            driver = null;
//        }
//
//    }


    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    public static WebDriver getDriver() {

        if (driverPool.get() == null) {
            String browserType = ConfigurationReader.getProperty("browser");
            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driverPool.set(new EdgeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;

                case "opera":
                    WebDriverManager.operadriver().setup();
                    driverPool.set(new OperaDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }
        }

        return driverPool.get();

    }

        public static void closeDriver() {

        if (driverPool.get() != null) {
            driverPool.get().quit ();
            driverPool.remove();
        }

    }

}
