package controller;

public class condiciones {
    private static String userID = System.getProperty("user.id");
    private static String rutaConfig = "\\src\\test\\resources\\drivers\\";
    private static String chromeEXE = "chromedriver.exe";
    private static String rutaChrome = userID + rutaConfig + chromeEXE;
    private static String chromeDriver = "webdriver.chrome.driver";
    public static String obtenerRutaChrome(){
        return rutaChrome;
    }
    public static String obtenerChromeDriver(){
        return chromeDriver;
    }
}
