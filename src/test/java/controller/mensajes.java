package controller;

import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static controller.fix.fixEncoding;

public class mensajes {
    private static String tituloSitio = "Se ingresa al sitio: ";
    private static String maximizar = "Maximizando vista";
    private static String siguiente = "Data ingresada & validada" +
            "Clickeando siguiente";
    private static String ingresadoOk = "¡Ingresado correctamente!";
    private static String ingresadoResultado = "/html/body/div[1]/div/div[1]/h2";
    public static void obtenerTitulo(WebDriver driver){
        System.out.println(tituloSitio + driver.getTitle());
    }
    public static void maximizarVentana(WebDriver driver){
        driver.manage().window().maximize();
        System.out.println(maximizar);
    }
    public static String validarSiguiente(){
        return siguiente;
    }
    public static String hazteClienteOK(WebDriver driver){
        String resultadoEsperado = fixEncoding(ingresadoOk);
        String resultadoObtenido = driver.findElement(By.xpath(ingresadoResultado)).getText();
        Assertions.assertEquals(resultadoEsperado, resultadoObtenido);
        return resultadoEsperado;
    }
}
