package controller;

public class constantes {
    private static String urlBcoEdwards = "https://portales.bancoedwards.cl/personas";
    private static String Nombre1 = "Esteban";
    private static String Nombre2 = "Orlando";
    private static String Apellido1 = "Caceres";
    private static String Apellido2 = "Creuz";
    private static String correo = "x@x.cl";
    public static String irBcoEdwards(){
        System.out.println("Dirigiendo al sitio web de Banco Edwards");
        return urlBcoEdwards;
    }
    public static String ambosNombres(){
        System.out.println("Ingresando nombres" +
                "Nombre: " + Nombre1 +
                "2do Nombre: " + Nombre2);
        return Nombre1 + " " + Nombre2;
    }
    public static String ambosApellidos(){
        System.out.println("Ingresando apellidos" +
                "Apellido Paterno: " + Apellido1 +
                "Apellido Materno: " + Apellido2);
        return Apellido1 + " " + Apellido2;
    }
    public static String obtenerCorreo(){
        System.out.println("Ingresando correo)");
        return correo;
    }
}
