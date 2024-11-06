package controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class iFrame {
    private static String formHazteCliente = "form_hazte_cliente";
    public static void iriFrame(WebDriver driver){
        WebElement iFrame;
        By byiFrame = By.id(formHazteCliente);
        iFrame = driver.findElement(byiFrame);
        System.out.println("Validando si existe el formulario");
        if (iFrame.isDisplayed()){
            System.out.println("Ingresando data a formulario");
            driver.switchTo().frame(iFrame);
        } else {
            System.err.println("iFrame no existe, validar");
        }
    }
}
