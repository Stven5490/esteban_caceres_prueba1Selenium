package controller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static controller.aleatorio.*;
import static controller.constantes.*;

public class textBox {
    private static String txtNombre = "//*[@id=\"txt_nombre\"]";
    private static String txtApellido = "//*[@id=\"txt_apellido\"]";
    private static String txtRut = "//*[@id=\"txt_rut\"]";
    private static String txtPhone = "//*[@id=\"txt_telefono\"]";
    private static String txtEmail = "//*[@id=\"txtEmail\"]";
    public static void ingresarNombre(WebDriver driver){
        WebElement Nombres;
        By byNombres = By.xpath(txtNombre);
        Nombres = driver.findElement(byNombres);
        System.out.println("Validando si existe el TextBox para Nombres");
        if (Nombres.isDisplayed()){
            System.out.println("Textbox encontrado");
            Nombres.sendKeys(ambosNombres());
        } else {
            System.err.println("TextBox Nombres, no existe");
        }
    }
    public static void ingresarApellido(WebDriver driver){
        WebElement Apellidos;
        By byApellidos = By.xpath(txtApellido);
        Apellidos = driver.findElement(byApellidos);
        System.out.println("Validando si existe el TextBox para Apellidos");
        if (Apellidos.isDisplayed()){
            System.out.println("Textbox encontrado");
            Apellidos.sendKeys(ambosApellidos());
        } else {
            System.err.println("TextBox Apellidos, no existe");
        }
    }
    public static void ingresarRutok(WebDriver driver){
        WebElement Rut;
        By byRut = By.xpath(txtRut);
        Rut = driver.findElement(byRut);
        System.out.println("Validando si existe el TextBox para Rut");
        if (Rut.isDisplayed()){
            System.out.println("TextBox encontrado");
            Rut.sendKeys(generarRutOk());
        } else {
            System.err.println("TextBox RUT, no existe");
        }
    }
    public static void ingresarTelefono(WebDriver driver){
        WebElement Telefono;
        By byTelefono = By.xpath(txtPhone);
        Telefono = driver.findElement(byTelefono);
        System.out.println("Validar si existe TextBox Telefono");
        if (Telefono.isDisplayed()){
            System.out.println("Textbox existe");
            Telefono.sendKeys(telefonoAleatorio());
        } else {
            System.err.println("Textbox no se encuentra");
        }
    }
    public static void ingresarEmail(WebDriver driver){
        WebElement Email;
        By byEmail = By.xpath(txtEmail);
        Email = driver.findElement(byEmail);
        System.out.println("Validando que exista textbox Email");
        if (Email.isDisplayed()){
            System.out.println("TextBox encontrado");
            Email.sendKeys(obtenerCorreo());
        } else {
            System.err.println("TextBox no existe");
        }
    }
    public static void ingresarRutNok(WebDriver driver){
        WebElement Rut;
        By byRut = By.xpath(txtRut);
        Rut = driver.findElement(byRut);
        Rut.sendKeys(generarRutNok());
    }
}
