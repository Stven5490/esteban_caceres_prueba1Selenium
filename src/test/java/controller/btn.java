package controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class btn {
    private static String btnHazteCliente = "//*[@id=\"pbec_header-link-hazte_cliente\"]";
    private static String btnSiguiente = "//*[@id=\"bt_step\"]";
    private static String btnEnviar = "//*[@id=\"bt_guarda\"]";
    public static void clickHazteCliente(WebDriver driver) throws InterruptedException {
        WebElement BtnHazteCliente;
        By byBtnHazteCliente = By.xpath(btnHazteCliente);
        BtnHazteCliente = driver.findElement(byBtnHazteCliente);
        System.out.println("Validando si existe boton 'Hazte Cliente'.");
        if (BtnHazteCliente.isDisplayed()){
            System.out.println("El boton si esta");
            BtnHazteCliente.click();
            System.out.println("Clickeando en boton: " + driver.getTitle());
            Thread.sleep(10000);
        } else {
            System.err.println("No se encuentra el boton.");
        }
    }
    public static void clickSiguiente(WebDriver driver){
        WebElement Siguiente;
        By bySiguiente = By.xpath(btnSiguiente);
        Siguiente = driver.findElement(bySiguiente);
        if (Siguiente.isDisplayed()){
            System.out.println("Boton Siguiente encontrado" +
                    "Clickenado Siguiente");
            Siguiente.click();
        } else {
            System.err.println("Boton Siguiente no encontrado");
        }
    }
    public static void clickEnviar(WebDriver driver){
        WebElement botonEnviar;
        By byBotonEnviar = By.xpath(btnEnviar);
        botonEnviar = driver.findElement(byBotonEnviar);
        if (botonEnviar.isDisplayed()){
            botonEnviar.click();
        } else {
            System.err.println("Boton no existe");
        }
    }
}
