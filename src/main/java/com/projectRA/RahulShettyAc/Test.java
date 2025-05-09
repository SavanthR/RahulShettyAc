package com.projectRA.RahulShettyAc;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

    public static void main(String[] args) throws InterruptedException {
    	
    	System.setProperty("webdriver.chrome.driver", "C:\\WORK\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.xpath("//input[@name=\"enter-name\"]")).sendKeys("Savanth");
		driver.findElement(By.xpath("//input[@value=\"Alert\"]")).click();
			Thread.sleep(4000);
		driver.switchTo().alert().accept();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value=\"Confirm\"]"))).click();
		Thread.sleep(4000);
		driver.switchTo().alert().dismiss();
		Thread.sleep(4000);	
		 // Find the dropdown input and type "Ind"
	      WebElement countryInput = driver.findElement(By.xpath("//input[@placeholder='Type to Select Countries']"));
	      countryInput.sendKeys("Ind");

	      // Wait for suggestions to appear
	      Thread.sleep(2000);

	      // Now find all suggestion options
	      List<WebElement> options = driver.findElements(By.xpath("//li[contains(@class, 'ui-menu-item')]"));

	      System.out.println("Total countries shown: " + options.size());

	      // Loop through options and select "India"
	      for (WebElement option : options) {
	          String text = option.getText();
	          System.out.println(text);
	          if (text.equalsIgnoreCase("Indonesia")) {
	              option.click();
	              break;
	          }
	      }
//    	 System.out.println("Code execution started");
//        WebDriverManager.chromedriver().setup(); // Setup first
//        WebDriver driver = new ChromeDriver();   // Then create driver

        driver.manage().window().maximize();
      //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement table = driver.findElement(By.xpath("//*[@id='product' and @class='table-display']"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));

        for (int i = 1; i < rows.size(); i++) {  
            WebElement row = rows.get(i);
            List<WebElement> columns = row.findElements(By.tagName("th"));

            for (int j = 0; j < columns.size(); j++) {
                String cellText = columns.get(j).getText();
                
                
                if(cellText.equals("WebSecurity Testing for Beginners-QA knowledge to next level")) {
                    System.out.println("cell data: " + cellText );
                }
                System.out.println(cellText + " | ");
            }
            System.out.println();
        }
        System.out.println("Code executed");
        driver.quit();
    }
    }
   