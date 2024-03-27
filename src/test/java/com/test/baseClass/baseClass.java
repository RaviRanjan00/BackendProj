package com.test.baseClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class baseClass {
    static ChromeOptions options = new ChromeOptions();
    static WebDriver driver;

    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ranjara2\\Downloads\\chromedriver-win64 (1)\\chromedriver-win64\\chromedriver.exe");
        options = new ChromeOptions();
        options.setBinary("C:\\Users\\ranjara2\\Downloads\\chrome-win64\\chrome-win64\\chrome.exe");
        driver = new ChromeDriver(options);
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    public void tear(){
        driver.quit();
    }
}
