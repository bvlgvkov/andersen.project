package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
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

        String ActualTitle = driver.getTitle();
        String ExpectedTitle = "Account Login - LeetCode";
        Assertions.assertEquals(ExpectedTitle, ActualTitle);

        WebElement element = driver.findElement(By.className("tips__3UvI"));
        String expectedText = "or you can sign in with";
        String actualText = element.getText();
        Assertions.assertEquals(expectedText, actualText);

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
        boolean logoPresent = driver.findElement(By.className("logo__3xn0")).isDisplayed();
        Assertions.assertTrue(logoPresent);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Problems"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Two Sum"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div[4]/iframe")));

        String actualText = driver.findElement(By.className("css-14oi08n")).getText();
        String expectedText = "Easy";
        Assertions.assertEquals(expectedText, actualText);

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to("https://www.google.com/");
        WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        elem.click();
        elem.sendKeys("Let's Write The code ! :)");

        logoPresent = driver.findElement(By.className("lnXdpd")).isDisplayed();
        Assertions.assertTrue(logoPresent);
    }

    @Test
    @Order(3)
    public void threeTest() {
        WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        elem.sendKeys(Keys.RETURN);

        boolean logoPresent = driver.findElement(By.xpath("//*[@id=\"logo\"]/img")).isDisplayed();
        Assertions.assertTrue(logoPresent);

        String actualText = driver.findElement(By.className("GmE3X")).getText();
        String expectedText = "Картинки по запросу Let's Write The code ! :)";
        Assertions.assertEquals(expectedText, actualText);
    }

    @Test
    @Order(4)
    public void fourTest() {
        WebElement elem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
        elem.clear();
        elem.sendKeys("Webdriver tests example");
        elem.sendKeys(Keys.RETURN);

        elem = driver.findElement(By.className("r21Kzd"));

        String actualText = elem.getCssValue("visibility");
        String expectedText = "visible";
        Assertions.assertEquals(expectedText, actualText);

        elem.click();
        wait.until(ExpectedConditions.attributeContains(By.className("r21Kzd"), "visibility", "hidden"));
        actualText = elem.getCssValue("visibility");
        expectedText = "hidden";
        Assertions.assertEquals(expectedText, actualText);

        elem = driver.findElement(By.xpath("//img[@src='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTE5q1QSDORlXiZIyVaeNB4JqMv1kQs2G9B2rPuAcptcw&s']"));
        boolean logoPresent = elem.isDisplayed();
        Assertions.assertTrue(logoPresent);
    }
}