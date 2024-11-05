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

public class testEdwards {
    private static WebDriver driver;
    private String rutaDriver = System.getProperty("user.id") + "\\src\\test\\resources\\drivers\\chromedriver.exe";
    private WebDriverWait wait;
    @BeforeEach
    public void preCondiciones(){
        System.getProperty("webdriver.chrome.driver", rutaDriver);
        driver = new ChromeDriver();
    }
    @Test
    public void CP001_llegarSitioEdwards(){
        String urlBcoEdwards = "https://portales.bancoedwards.cl/personas";
        driver.get(urlBcoEdwards);
        System.out.println("Se ingresar al sitio: " + driver.getTitle());
        System.out.println("Maximizando vista");
        driver.manage().window().maximize();
    }
    @Test
    public void CP002_hazteCliente() throws InterruptedException {
        //Pagina principal
        CP001_llegarSitioEdwards();
        WebElement btnHazteCliente;
        By bybtnHazteCliente = By.xpath("//*[@id=\"pbec_header-link-hazte_cliente\"]");
        btnHazteCliente = driver.findElement(bybtnHazteCliente);
        System.out.println("Validando si existe boton 'Hazte Cliente'.");
        if (btnHazteCliente.isDisplayed()){
            System.out.println("El boton si esta");
            btnHazteCliente.click();
            System.out.println("Clickeando en boton: " + driver.getTitle());
            Thread.sleep(10000);
        } else {
            System.err.println("No se encuentra el boton.");
        }
    }
    @Test
    public void CP003_hazteClienteok() throws InterruptedException {
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
        System.out.println("Seleccionando comuna");
        By byComuna = By.xpath("//*[@id=\"ddl_comunas-selectized\"]");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(byComuna)).click();
        By byComunaOpcion = By.xpath("//*[contains(text(), 'Coquimbo')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(byComunaOpcion)).click();
        //Tramo renta liquida
        System.out.println("Seleccionando tramo de renta");
        By byTramoRenta = By.xpath("//*[@id=\"dv_tramo\"]/div[1]/div/div[1]");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(byTramoRenta)).click();
        By byTramo = By.xpath("//*[contains(text(), '700.000 - 1.800.000')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(byTramo)).click();
        //Fecha de nacimiento
        System.out.println("Ingresando fecha de nacimiento");
        //Abrir calendario
        By byCalendar = By.xpath("//*[@id=\"datepicker\"]");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(byCalendar)).click();
        //Mes
        System.out.println("Mes");
        By byMonthDOB = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[1]");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(byMonthDOB)).click();
        Select ddLMonth = new Select(driver.findElement(byMonthDOB));
        ddLMonth.selectByVisibleText("Abr");
        //Año
        System.out.println("Year");
        By byYearDOB = By.xpath("//*[@id=\"ui-datepicker-div\"]/div/div/select[2]");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(byYearDOB)).click();
        By byYear = By.xpath("//*[contains(text(), '1990')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(byYear)).click();
        //Dia
        System.out.println("Dia");
        By byDiaBOD = By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[2]/td[4]/a");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(byDiaBOD)).click();
        //Seleccion de productos
        System.out.println("Seleccionando productos");
        By byProducto = By.xpath("//*[@id=\"dll_productos-selectized\"]");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(byProducto)).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By byProductoOpcion = By.xpath("/html/body/form/div[4]/div[1]/div[3]/div[4]/div[1]/div/div[2]/div/div[5]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(byProductoOpcion)).click();
        //Terminos y condiciones
        driver.findElement(By.xpath("/html/body/form/div[4]")).click();
        System.out.println("Clickeando Terminos & Condiciones");
        WebElement checkTyC;
        By byCheckTyC = By.xpath("//*[@id=\"df_check\"]");
        checkTyC = driver.findElement(byCheckTyC);
        checkTyC.click();
        //Enviando solicitud
        WebElement btnEnviar;
        By bybtnEnviar = By.xpath("//*[@id=\"bt_guarda\"]");
        btnEnviar = driver.findElement(bybtnEnviar);
        btnEnviar.click();
        //Status ok Ingresado Correctamente
        String resultadoEsperado = corregirEncoding("¡Ingresado correctamente!");
        String stringResultado = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/h2")).getText();
        Assertions.assertEquals(resultadoEsperado, stringResultado);
    }
    @Test
    public void CP004_hazteClienteRutinValido() throws InterruptedException {
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
        Rut.sendKeys("11");
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
        driver.close();
    }
}