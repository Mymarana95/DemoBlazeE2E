package com.demoblaze.test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DemoblazePurchaseTest {

    @Test
    public void completePurchaseFlow() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\webdriver\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.demoblaze.com");
        Thread.sleep(3000); // Esperar que cargue la página

        // Agregar primer producto
        driver.findElement(By.linkText("Samsung galaxy s6")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Add to cart")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        // Volver al inicio
        driver.findElement(By.id("nava")).click();
        Thread.sleep(3000); // Esperar que cargue la página


        // Agregar segundo producto
        driver.findElement(By.linkText("Nokia lumia 1520")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Add to cart")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        // Ir al carrito
        driver.findElement(By.id("cartur")).click();
        Thread.sleep(2000);

        // Finalizar compra
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("name")).sendKeys("Maria");
        driver.findElement(By.id("country")).sendKeys("Ecuador");
        driver.findElement(By.id("city")).sendKeys("Quito");
        driver.findElement(By.id("card")).sendKeys("123456789");
        driver.findElement(By.id("month")).sendKeys("12");
        driver.findElement(By.id("year")).sendKeys("2025");
        driver.findElement(By.xpath("//button[text()='Purchase']")).click();
        Thread.sleep(3000);

        driver.quit();
    }
}
