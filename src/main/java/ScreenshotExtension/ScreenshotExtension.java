package ScreenshotExtension;

import WebDriver.WebDriverComponents;
import io.qameta.allure.Allure;
import lombok.SneakyThrows;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotExtension extends TestWatcher {
    @SneakyThrows
    @Override
    public void failed(Throwable e, Description description) {
        WebDriver driver = WebDriverComponents.getDriver();
        System.out.println("check" + " " + driver.getTitle());
        Allure.getLifecycle().addAttachment(
                "Screenshot",
                "image/png", "png",
                ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)
        );
    }
}