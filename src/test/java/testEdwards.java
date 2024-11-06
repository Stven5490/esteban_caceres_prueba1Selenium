import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Random;

import static controller.btn.*;
import static controller.calendar.*;
import static controller.check.clickTerminos;
import static controller.comboBox.*;
import static controller.condiciones.*;
import static controller.constantes.*;
import static controller.fix.*;
import static controller.iFrame.*;
import static controller.mensajes.*;
import static controller.textBox.*;

public class testEdwards {
    private static WebDriver driver;
    private WebDriverWait wait;
    @BeforeEach
    public void preCondiciones(){
        System.getProperty(obtenerChromeDriver(), obtenerRutaChrome());
        driver = new ChromeDriver();
    }
    @Test
    public void CP001_llegarSitioEdwards(){
        driver.get(irBcoEdwards());
        maximizarVentana(driver);
        obtenerTitulo(driver);
    }
    @Test
    public void CP002_hazteCliente() throws InterruptedException {
        //Pagina principal
        CP001_llegarSitioEdwards();
        clickHazteCliente(driver);
    }
    @Test
    public void CP003_hazteClienteok() throws InterruptedException {
        CP002_hazteCliente();
        //Formulario iFrame
        iriFrame(driver);
        //Nombres
        ingresarNombre(driver);
        //Apellidos
        ingresarApellido(driver);
        //Rut
        ingresarRutok(driver);
        //Actividad
        seleccionarActividad(driver);
        //Telefono
        ingresarTelefono(driver);
        //Email
        ingresarEmail(driver);
        //Siguiente
        clickSiguiente(driver);
        //Comuna
        seleccionarComunaOK(driver);
        //Tramo renta liquida
        seleccionarRenta(driver);
        //Fecha de nacimiento
        System.out.println("Ingresando fecha de nacimiento");
        //Abrir calendario
        seleccionarDOB(driver);
        //Seleccion de productos
        seleccionarProducto(driver);
        //Terminos y condiciones
        clickTerminos(driver);
        //Enviando solicitud
        clickEnviar(driver);
        //Status ok Ingresado Correctamente
        hazteClienteOK(driver);
    }
    @Test
    public void CP004_hazteClienteRutinValido() throws InterruptedException {
        CP002_hazteCliente();
        //Formulario iFrame
        iriFrame(driver);
        //Nombres
        ingresarNombre(driver);
        //Apellidos
        ingresarApellido(driver);
        //Rut
        ingresarRutNok(driver);
        //Actividad
        seleccionarActividad(driver);
        //Telefono
        ingresarTelefono(driver);
        //Email
        ingresarEmail(driver);
        //Siguiente
        clickSiguiente(driver);
        //Status Rut invalido
        String resultadoEsperado = corregirEncoding("Por favor, ingrese un rut válido.");
        String stringResultado = driver.findElement(By.xpath("/html/body/form/div[4]/div[1]/div[1]/div[3]/div/div/div/div[2]/label[1]")).getText();
        Assertions.assertEquals(resultadoEsperado, stringResultado);
        if (resultadoEsperado == stringResultado){
            System.err.println("Rut ingresado es invalido.");
        } else {
            System.out.println(resultadoEsperado);
        }
    }
    @Test
    public void CP005_ingresarComunaInexistente() throws InterruptedException {
        CP002_hazteCliente();
        //Formulario iFrame
        WebElement iFrame;
        By byiFrame = By.id("form_hazte_cliente");
        iFrame = driver.findElement(byiFrame);
        driver.switchTo().frame(iFrame);
        //Nombres
        System.out.println("Ingresando Nombres");
        WebElement Nombres;
        By byNombres = By.xpath("//*[@id=\"txt_nombre\"]");
        Nombres = driver.findElement(byNombres);
        Nombres.sendKeys("Esteban Orlando");
        //Apellidos
        System.out.println("Ingresando Apellidos");
        WebElement Apellidos;
        By byApellidos = By.xpath("//*[@id=\"txt_apellido\"]");
        Apellidos = driver.findElement(byApellidos);
        Apellidos.sendKeys("Caceres Creuz");
        //Rut
        System.out.println("Ingresando RUT");
        WebElement Rut;
        By byRut = By.xpath("//*[@id=\"txt_rut\"]");
        Rut = driver.findElement(byRut);
        Rut.sendKeys(generarRUT());
        //Actividad
        System.out.println("Seleccionando actividad");
        By bycampoActividad = By.xpath("//*[@id='ddlActividad-selectized']");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(bycampoActividad)).click();
        By opcionTrabajando = By.xpath("//*[contains(text(), 'Trabajando')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(opcionTrabajando)).click();
        //Telefono
        System.out.println("Indicando Nro. telefonico");
        WebElement Telefono;
        By byTelefono = By.xpath("//*[@id=\"txt_telefono\"]");
        Telefono = driver.findElement(byTelefono);
        Telefono.sendKeys("12345678");
        //Email
        System.out.println("Ingresando eMail");
        WebElement Email;
        By byEmail = By.xpath("//*[@id=\"txtEmail\"]");
        Email = driver.findElement(byEmail);
        Email.sendKeys("x@x.com");
        //Siguiente
        System.out.println("Data ingresada & validada");
        System.out.println("Clickeando siguiente");
        WebElement Siguiente;
        By bySiguiente = By.xpath("//*[@id=\"bt_step\"]");
        Siguiente = driver.findElement(bySiguiente);
        Siguiente.click();
        //Comuna
        System.out.println("Seleccionando Comuna");
        By byComuna = By.xpath("//*[@id=\"ddl_comunas-selectized\"]");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(byComuna)).click();
            By byComunaOpcion = By.xpath("//[contains(text(), 'Tangamandapio')]");
            if (!driver.findElements(byComunaOpcion).isEmpty()){
                driver.findElement(byComunaOpcion).click();
                System.out.println("Comuna indicada existe");
            } else {
                System.err.println("Comuna indicada no esta disponible");
            }
        } catch (Exception e){
            System.out.println("Comuna Tangamandapio no esta disponible.");
        }
    }
   public static String generarRUT() {
        Random random = new Random();
        int numeroBase = 1000000 + random.nextInt(9000000);
        int digitoVerificador = calcularDigitoVerificador(numeroBase);
        return String.format("%,d-%d", numeroBase, digitoVerificador).replace(",", ".");
    }
    private static int calcularDigitoVerificador(int numero) {
        int suma = 0;
        int multiplicador = 2;
        while (numero > 0) {
            int digito = numero % 10;
            suma += digito * multiplicador;
            multiplicador = (multiplicador == 7) ? 2 : multiplicador + 1;
            numero /= 10;
        }
        int resto = 11 - (suma % 11);
        if (resto == 11) {
            return 0;
        } else if (resto == 10) {
            return 'K';
        } else {
            return resto;
        }
    }
    public static String corregirEncoding(String textoIncorrecto){
        byte[] bytes = textoIncorrecto.getBytes(StandardCharsets.ISO_8859_1);
        String textoCorregido = new String(bytes, StandardCharsets.UTF_8);
        return textoCorregido;
    }
    @AfterEach
    public void cerrar() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("Cerrando vista");
        driver.close();
    }
}