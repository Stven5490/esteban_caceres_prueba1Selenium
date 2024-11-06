package controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class comboBox {
    private static WebDriverWait wait;
    private static int ten = 10;
    private static String comboActividad = "//*[@id='ddlActividad-selectized']";
    private static String actividadTrabajando = "//*[contains(text(), 'Trabajando')]";
    private static String comboComuna = "//*[@id=\"ddl_comunas-selectized\"]";
    private static String comunaCoquimbo = "//*[contains(text(), 'Coquimbo')]";
    private static String comboTramo = "//*[@id=\"dv_tramo\"]/div[1]/div/div[1]";
    private static String tramo7k18M = "//*[contains(text(), '700.000 - 1.800.000')]";
    private static String comboProducto = "//*[@id=\"dll_productos-selectized\"]";
    private static String productoHipotecario = "/html/body/form/div[4]/div[1]/div[3]/div[4]/div[1]/div/div[2]/div/div[5]";
    public static void seleccionarActividad(WebDriver driver){
        By byComboActividad = By.xpath(comboActividad);
        wait = new WebDriverWait(driver, Duration.ofSeconds(ten));
        System.out.println("Validando si esta habilitado el combobox");
        wait.until(ExpectedConditions.elementToBeClickable(byComboActividad)).click();
        By byActividadTrabajando = By.xpath(actividadTrabajando);
        wait.until(ExpectedConditions.visibilityOfElementLocated(byActividadTrabajando)).click();
    }
    public static void seleccionarComunaOK(WebDriver driver){
        By byComuna = By.xpath(comboComuna);
        wait = new WebDriverWait(driver, Duration.ofSeconds(ten));
        System.out.println("Clickeando comuna");
        wait.until(ExpectedConditions.elementToBeClickable(byComuna)).click();
        By byComunaOpcion = By.xpath(comunaCoquimbo);
        System.out.println("Seleccionando Comuna: Coquimbo");
        wait.until(ExpectedConditions.visibilityOfElementLocated(byComunaOpcion)).click();
    }
    public static void seleccionarRenta(WebDriver driver){
        By byRenta = By.xpath(comboTramo);
        wait = new WebDriverWait(driver, Duration.ofSeconds(ten));
        System.out.println("Clieckenando Tramo de Renta");
        wait.until(ExpectedConditions.elementToBeClickable(byRenta)).click();
        By byRentaOpcion = By.xpath(tramo7k18M);
        System.out.println("Seleccionando tramo 700.000 - 1.800.000");
        wait.until(ExpectedConditions.visibilityOfElementLocated(byRentaOpcion)).click();
    }
    public static void seleccionarProducto(WebDriver driver){
        By byComboProducto = By.xpath(comboProducto);
        wait = new WebDriverWait(driver, Duration.ofSeconds(ten));
        wait.until(ExpectedConditions.elementToBeClickable(byComboProducto)).click();
        By byProductoHipotecario = By.xpath(productoHipotecario);
        wait.until(ExpectedConditions.visibilityOfElementLocated(byProductoHipotecario)).click();
    }
}
