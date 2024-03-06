package com.selenium.test.insure_me_testing;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        System.out.println( "This application is to test Insure me application login!" );
        
        // System.setProperty("webdriver.chrome.driver", "C:\\Bharathi\\software\\Chrome-driver\\chromedriver-win64\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        
        WebDriver driver = new ChromeDriver(chromeOptions);
        
        System.out.println("Let's begin the testing");
        
        // 1. Open the browser and get to the URL
        driver.get("http://54.86.51.106:8085/contact.html");
        
        // Enable wait for 2 seconds
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        
        // Enter name
        driver.findElement(By.id("inputName")).sendKeys("Jack Sparrow");
        Thread.sleep(1000);

        // Enter phone number
        driver.findElement(By.id("inputNumber")).sendKeys("9999999999");
        Thread.sleep(1000);
        
        // Enter email id
        driver.findElement(By.id("inputMail")).sendKeys("admin@xyz.com");
        Thread.sleep(1000);
        
        // Enter message
        driver.findElement(By.id("inputMessage")).sendKeys("Please consider this request");
        Thread.sleep(1000);
        
        driver.findElement(By.id("my-button")).click();
        Thread.sleep(10000);
        
     // Wait for the message to appear
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement messageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("response")));

        // Verify the message content
        String messageText = messageElement.getText();
        if (messageText.contains("Message Sent")) {
            System.out.println("Message Sent successfully!");
            System.out.println("Testing has been completed successfully.");
        } else {
            System.out.println("Message Sent not successful!");
            System.out.println("Testing failed.");
        }
        
        driver.quit();
    }
}
