package WebDriver;

import lombok.Data;
import lombok.Getter;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

@Data
@Getter
public class WebDriverComponents {
    private static WebDriver driver;
    private WebDriverWait wait;
    private WebElement element;
    private static final String X_PATH = "xPath";
    private static final String CLASS_NAME = "className";
    private static final String PARTIAL_LINK_TEXT = "partialLinkText";
    private static final String NAME = "name";
    private static final String VISIBILITY = "visibility";
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


    public WebDriverComponents findElementByClassName(String elem) {
        return findElement(CLASS_NAME, elem);
    }

    public WebDriverComponents presenceOfElementLocatedByXPath(String name) {
        return presenceOfElementLocated(X_PATH, name);
    }

    public WebDriverComponents visibilityOfElementLocatedByXPath(String name) {
        return visibilityOfElementLocated(X_PATH, name);
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

    public WebDriverComponents attributeContainByClassName(String name, String property, String value) {
        return attributeContain(CLASS_NAME, name, property, value);
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

    public WebDriverComponents findAndClick(String type, String name) {
        return findElement(type, name).clickElement();
    }

    public WebDriverComponents findElementByName(String name) {
        return findElement(NAME, name);
    }

    public WebDriverComponents findAndClickByXpath(String name) {
        return findElement(X_PATH, name).clickElement();
    }

    public WebDriverComponents findElementByXpath(String name) {
        return findElement(X_PATH, name);
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

    public void sendKeys(Keys key) {
        element.sendKeys(key);
    }

    public WebDriverComponents clear() {
        element.clear();

        return this;
    }

    public String findAndGetTextByClassName(String name) {
        return findElement(CLASS_NAME, name).getText();
    }

    public WebDriverComponents changeSite(String site) {
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to(site);

        return this;
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

    public boolean isDisplayedByClassName(String name) {
        return findElement(CLASS_NAME, name).isDisplayed();
    }

    public WebDriverComponents visibilityOfElementLocatedByName(String s) {
        return visibilityOfElementLocated(NAME, s);
    }

    public WebDriverComponents visibilityOfElementLocatedByLink(String problems) {
        return visibilityOfElementLocated(PARTIAL_LINK_TEXT, problems);
    }

    public WebDriverComponents presenceOfElementLocatedByLink(String name) {
        return presenceOfElementLocated(PARTIAL_LINK_TEXT, name);
    }

    public String getVisibility() {
        return VISIBILITY;
    }

    public WebDriverComponents findAndSendKeysByXPath(String s, String name) {
        return findAndSendKeys(X_PATH, s, name);
    }

    public String findAndGetTextById(String name) {
        return findElement(ID, name).getText();
    }

    public WebDriverComponents findElementById(String name) {
        return findElement(ID, name);
    }

    public WebDriverComponents presenceOfElementLocatedById(String name) {
        return presenceOfElementLocated(ID, name);
    }

    public WebDriverComponents visibilityOfElementLocatedById(String name) {
        return visibilityOfElementLocated(ID, name);
    }

    public WebDriverComponents presenceOfElementLocatedByName(String name) {
        return visibilityOfElementLocated(NAME, name);
    }

    public WebDriverComponents findAndClickById(String name) {
        return findAndClick(ID, name);
    }
}