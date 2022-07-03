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
class MySiteTests {

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
        driver.get("https://leetcode.com/accounts/login/");
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("/html/body/div[4]/iframe")));
        WebElement nickname = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"id_login\"]")));
        nickname.click();
        nickname.sendKeys("andersentest@mail.ru");

        WebElement password = driver.findElement(By.xpath("//*[@id=\"id_password\"]"));
        password.click();
        password.sendKeys("Chess_1995@");
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[@id=\"signin_btn\"]/div")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[@id=\"signin_btn\"]/div")));

        driver.findElement(By.xpath("//*[@id=\"signin_btn\"]/div")).click();
    }

    @Test
    @Order(2)
    public void twoTest() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Problems"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Two Sum"))).click();

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to("https://www.google.com/");
        WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        elem.click();
        elem.sendKeys("Let's Write The code ! :)");
    }
}