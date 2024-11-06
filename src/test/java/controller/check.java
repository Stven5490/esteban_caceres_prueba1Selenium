package controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class check {
    private static String checkTerminos = "//*[@id=\"df_check\"]";
    private static WebDriverWait wait;
    private static int ten = 10;
    private static String okTerminos = "/html/body/form/div[4]";
    public static void clickTerminos(WebDriver driver){
        driver.findElements(By.xpath(okTerminos));
        wait = new WebDriverWait(driver, Duration.ofSeconds(ten));
        WebElement checkTyC;
        By bycheckTyC = By.xpath(checkTerminos);
        checkTyC = driver.findElement(bycheckTyC);
        if (checkTyC.isDisplayed()){
            checkTyC.click();
        } else {
            System.err.println("Check no existe");
        }
    }
}
