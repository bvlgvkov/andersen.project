package org.example;

import lombok.Data;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;


@Data
public class WebDriverComponents {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement element;

    public WebDriverComponents() {
        SetupWebDriver setup = new SetupWebDriver();
        this.driver = setup.getDriver();
        this.wait = setup.getWait();
    }

    public void exit() {
        driver.close();
        driver.quit();
    }

    public void openWebsite(String site) {
        driver.get(site);
    }

    public WebDriverComponents visibilityOfElementLocated(String type, String name) {
        if (Objects.equals(type, "name"))
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
        else if (Objects.equals(type, "className"))
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(name)));
        else if (Objects.equals(type, "id"))
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(name)));
        else if (Objects.equals(type, "partialLinkText"))
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(name)));
        else
            element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(name)));

        return this;
    }

    public WebDriverComponents presenceOfElementLocated(String type, String name) {
        if (Objects.equals(type, "name"))
            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.name(name)));
        else if (Objects.equals(type, "className"))
            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.className(name)));
        else if (Objects.equals(type, "id"))
            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(name)));
        else
            element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(name)));

        return this;
    }

    public WebDriverComponents findElement(String type, String name) {
        if (Objects.equals(type, "name"))
            element = driver.findElement(By.name(name));
        else if (Objects.equals(type, "className"))
            element = driver.findElement(By.className(name));
        else if (Objects.equals(type, "id"))
            element = driver.findElement(By.id(name));
        else
            element = driver.findElement(By.xpath(name));

        return this;
    }

    public WebDriverComponents attributeContain(String type, String name, String property, String value) {
        if (Objects.equals(type, "name"))
            wait.until(ExpectedConditions.attributeContains(By.name(name), property, value));
        else if (Objects.equals(type, "className"))
            wait.until(ExpectedConditions.attributeContains(By.className(name), property, value));
        else if (Objects.equals(type, "id"))
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
        findElement(type, name).clickElement();

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

    public void sendKeys(Keys key) {
        element.sendKeys(key);
    }

    public WebDriverComponents clear() {
        element.clear();

        return this;
    }

    public String findAndGetText(String type, String name) {
        return findElement(type, name).getText();
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

    public String getCssValue(String value) {
        return element.getCssValue(value);
    }

    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    public boolean isDisplayed(String type, String name) {
        return findElement(type, name).isDisplayed();
    }
}