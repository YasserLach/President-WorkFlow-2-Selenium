package com.ensa;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

// 12:
// ce code permet au président de signer l'autorisation finale du service technique afin d'autoriser l'utilisateur à commencer ces travaux

public class Main {

	public static void main(String[] args) throws InterruptedException{
	     System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver-win64\\chromedriver.exe");
	        WebDriver driver = new ChromeDriver();
	        driver.get("http://127.0.0.1:5173/login");
	        driver.manage().window().maximize();
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        
	        Thread.sleep(2000);
	        WebElement inputEmail = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]"));
	        inputEmail.sendKeys("president@gmail.com");
	        Thread.sleep(500);
	        
	        WebElement inputPasswd = driver.findElement(By.xpath("//input[@id='passwdInput']"));
	        inputPasswd.sendKeys("123456789");
	        Thread.sleep(1000);
	        
	        WebElement ButtonLogin = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/button[1]"));
	        ButtonLogin.click();
	        Thread.sleep(4000);

	        Actions actions = new Actions(driver);
	        driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]")).click();
	        Thread.sleep(4000);
	       
	       
	        actions.moveByOffset(1000, 0).perform();
	        Thread.sleep(3000);
	        String targetId = "autorisationSTechnique2.pdf";
	        By locator = By.id(targetId);
	        driver.findElement(locator).click();
	        
	        WebElement ButtonImporterFichier = driver.findElement(By.cssSelector("#file"));
	        String filePath = "C:\\Users\\ylach\\Desktop\\cours\\TP_Qazdar\\autorisationPresid2.pdf";
	        ButtonImporterFichier.sendKeys(filePath);
	        Thread.sleep(2000);
	        
	        driver.findElement(By.xpath("//button[contains(text(),'confirmer')]")).click();
	        Thread.sleep(4000);
	        
	        driver.get("http://127.0.0.1:5173/autorisation");
	        Thread.sleep(3000);
	        
	        driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]")).click();
	        Thread.sleep(2000);
	        actions.moveByOffset(700, 0).perform();
	        Thread.sleep(4000);
	        driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[2]/p[1]")).click();
	        Thread.sleep(3000);
	        driver.close();
	        
	}

}
