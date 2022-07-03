package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CRMTests {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeAll
    public static void setupAll() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @AfterAll
    public static void tearDown() {
        driver.close();
        driver.quit();
    }
    @Test
    @Order(1)
    public void oneTest() {
        driver.get("https://www.saucedemo.com/checkout-complete.html");
        WebElement nickname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user-name")));
        nickname.click();
        nickname.sendKeys("standard_user");

        WebElement password = driver.findElement(By.name("password"));
        password.click();
        password.sendKeys("secret_sauce");

        driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"shopping_cart_container\"]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"first-name\"]")).sendKeys("Anatoliy");
        driver.findElement(By.xpath("//*[@id=\"last-name\"]")).sendKeys("Bulgakov");
        driver.findElement(By.xpath("//*[@id=\"postal-code\"]")).sendKeys("050051");
        driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"finish\"]")).click();
    }

    @Test
    @Order(2)
    public void twoTest() {
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to("http://justnotepad.com/ru/");
        WebElement nickname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("editable_text")));
        nickname.click();
        nickname.sendKeys("Bulgakov Anatoliy");

        driver.findElement(By.id("temp_url_nav")).click();

        WebElement elem = driver.findElement(By.name("password"));
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.name("password")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.name("password")));
        elem.click();
        elem.sendKeys("12345678");
        driver.findElement(By.id("create_url")).click();
    }
}