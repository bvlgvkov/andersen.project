package ScreenshotExtension;

import io.qameta.allure.Allure;
import lombok.SneakyThrows;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import WebDriver.WebDriverComponents;

public class ScreenshotExtension implements TestWatcher {
    @SneakyThrows
    @Override
    public void testFailed(ExtensionContext context, Throwable throwable) {
        WebDriver driver = WebDriverComponents.getDriver();
        System.out.println("check" + " " + driver.getTitle());
        Allure.getLifecycle().addAttachment(
                "Screenshot",
                "image/png", "png",
                ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)
        );
    }
}