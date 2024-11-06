package controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class calendar {
    private static String datePicker = "//*[@id=\"datepicker\"]";
    private static WebDriverWait wait;
    private static String Month = "//*[@id=\"ui-datepicker-div\"]/div/div/select[1]";
    private static int ten = 10;
    private static String Abril = "Abr";
    private static String Year = "//*[@id=\"ui-datepicker-div\"]/div/div/select[2]";
    private static String Day = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[4]/a";
    public static void seleccionarDOB(WebDriver driver){
        By byCalendar = By.xpath(datePicker);
        wait = new WebDriverWait(driver, Duration.ofSeconds(ten));
        wait.until(ExpectedConditions.elementToBeClickable(byCalendar)).click();
        By byMonthDOB = By.xpath(Month);
        wait = new WebDriverWait(driver, Duration.ofSeconds(ten));
        wait.until(ExpectedConditions.elementToBeClickable(byMonthDOB)).click();
        Select ddlMonth = new Select(driver.findElement(byMonthDOB));
        ddlMonth.selectByVisibleText(Abril);
        By byYearDOB = By.xpath(Year);
        wait.until(ExpectedConditions.visibilityOfElementLocated(byYearDOB)).click();
        By byDayDOB = By.xpath(Day);
        wait = new WebDriverWait(driver, Duration.ofSeconds(ten));
        wait.until(ExpectedConditions.elementToBeClickable(byDayDOB)).click();
    }
}
