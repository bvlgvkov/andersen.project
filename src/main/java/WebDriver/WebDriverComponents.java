package WebDriver;

import lombok.Data;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

@Data
public class WebDriverComponents {
    private static WebDriver driver;
    private WebDriverWait wait;
    private WebElement element;
    public static final String X_PATH = "xPath";
    public static final String CLASS_NAME = "className";
    public static final String PARTIAL_LINK_TEXT = "partialLinkText";
    public static final String NAME = "name";
    public static final String VISIBILITY = "visibility";
    public static final String ID = "id";

    public WebDriverComponents() {
        SetupWebDriver setup = new SetupWebDriver();
        driver = setup.getDriver();
        this.wait = setup.getWait();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public void exit() {
        driver.close();
        driver.quit();
    }

    public void openWebsite(String site) {
        driver.get(site);
    }

    public WebDriverComponents visibilityOfElementLocated(String type, String name) {
        if (Objects.equals(type, NAME))
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
        else if (Objects.equals(type, CLASS_NAME))
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(name)));
        else if (Objects.equals(type, ID))
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(name)));
        else if (Objects.equals(type, PARTIAL_LINK_TEXT))
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(name)));
        else
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(name)));

        return this;
    }

    public WebDriverComponents presenceOfElementLocated(String type, String name) {
        if (Objects.equals(type, NAME))
            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.name(name)));
        else if (Objects.equals(type, CLASS_NAME))
            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.className(name)));
        else if (Objects.equals(type, ID))
            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(name)));
        else if (Objects.equals(type, PARTIAL_LINK_TEXT))
            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(name)));

        else
            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(name)));

        return this;
    }

    public WebDriverComponents findElement(String type, String name) {
        if (Objects.equals(type, NAME))
            element = driver.findElement(By.name(name));
        else if (Objects.equals(type, CLASS_NAME))
            element = driver.findElement(By.className(name));
        else if (Objects.equals(type, ID))
            element = driver.findElement(By.id(name));
        else
            element = driver.findElement(By.xpath(name));

        return this;
    }

    public WebDriverComponents attributeContain(String type, String name, String property, String value) {
        if (Objects.equals(type, NAME))
            wait.until(ExpectedConditions.attributeContains(By.name(name), property, value));
        else if (Objects.equals(type, CLASS_NAME))
            wait.until(ExpectedConditions.attributeContains(By.className(name), property, value));
        else if (Objects.equals(type, ID))
            wait.until(ExpectedConditions.attributeContains(By.id(name), property, value));
        else
            wait.until(ExpectedConditions.attributeContains(By.xpath(name), property, value));

        return this;
    }

    public WebDriverComponents clickAndSendKeys(String keys) {
        element.click();
        element.sendKeys(keys);

        return this;
    }

    public WebDriverComponents findAndSendKeys(String type, String name, String keys) {
        findElement(type, name).sendKeys(keys);

        return this;
    }

    public WebDriverComponents clickElement() {
        element.click();

        return this;
    }

    public WebDriverComponents sendKeys(String keys) {
        element.sendKeys(keys);

        return this;
    }

    public WebDriverComponents clear() {
        element.clear();

        return this;
    }

    public WebDriverComponents changeSite(String site) {
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to(site);

        return this;
    }

    public void sendKeys(Keys key) {
        element.sendKeys(key);
    }

    public String getText() {
        return element.getText();
    }

    public String getAttribute(String name) {
        return element.getAttribute(name);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getCssValueByVisibility() {
        return element.getCssValue(VISIBILITY);
    }

    public boolean isDisplayed() {
        return element.isDisplayed();
    }
}