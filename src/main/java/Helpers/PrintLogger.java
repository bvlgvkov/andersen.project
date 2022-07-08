package Helpers;

import WebDriver.WebDriverComponents;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

public class PrintLogger {
    public static void printWebLogger() {
        for (LogEntry entry : WebDriverComponents.getDriver().manage().logs().get(LogType.BROWSER).getAll()) {
            String msg = entry.getMessage();
            System.err.println("Message: " + msg);
        }
    }
}
