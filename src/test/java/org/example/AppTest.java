package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

class AppTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setupAll() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }

    @AfterAll
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void oneTest() throws InterruptedException {
        driver.get("https://leetcode.com/accounts/login/");
        Thread.sleep(7000);
        WebElement nickname = driver.findElement(By.xpath("//*[@id=\"id_login\"]"));
        nickname.click();
        nickname.sendKeys("andersentest@mail.ru");

        WebElement password = driver.findElement(By.xpath("//*[@id=\"id_password\"]"));
        password.click();
        password.sendKeys("Chess_1995@");

        driver.findElement(By.xpath("//*[@id=\"signin_btn\"]/div")).click();
        Thread.sleep(7000);
    }

    @Test
    public void twoTest() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"navbar-root\"]/div/div/div[1]/div[3]/a")).click();
        Thread.sleep(7000);

        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div[1]/div[1]/div[6]/div[2]/div/div/div[2]/div[1]/div[1]/a")).click();
        Thread.sleep(7000);

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to("https://www.google.com/");
        Thread.sleep(3000);
        WebElement elem = driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[1]/div/div[2]/input"));
        elem.click();
        elem.sendKeys("Let's Write The code ! :)");
        Thread.sleep(7000);
    }
}