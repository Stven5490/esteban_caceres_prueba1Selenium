package controller;

import java.util.Random;

public class aleatorio {
    private static int iniRandom = 1000000;
    private static int maxRandom = 9000000;
    private static int zero = 0;
    private static int one = 1;
    private static int multiplo = 2;
    private static int seven = 7;
    private static int ten = 10;
    private static int eleven = 11;
    private static char K = 'K';
    private static int iniPhone = 10000000;
    private static int maxPhone = 99999999;
    public static String generarRutOk(){
        Random random = new Random();
        int numeroBase = iniRandom + random.nextInt(maxRandom);
        int digitoVerificador = calcularDigitoVerificador(numeroBase);
        return String.format("%,d-%d", numeroBase, digitoVerificador).replace(",", ".");

    }
    public static int calcularDigitoVerificador(int numero){
        int suma = zero;
        int multiplicador = multiplo;
        while (numero > zero){
            int digito = numero % ten;
            suma += digito * multiplicador;
            multiplicador = (multiplicador == seven) ? multiplo : multiplicador + one;
            numero /= ten;
        }
        int resto = eleven - (suma % eleven);
        if (resto == eleven){
            return zero;
        } else if (resto == ten) {
            return K;
        } else {
            return resto;
        }
    }
    public static String telefonoAleatorio(){
        Random random = new Random();
        int min = iniPhone;
        int max = maxPhone;
        int randomNumber = random.nextInt(max - min + 1) + min;
        System.out.println("Ingresando numero de telefono");
        return String.valueOf(randomNumber);
    }
    public static String generarRutNok(){
        Random random = new Random();
        int min = iniPhone;
        int max = maxPhone;
        int randomNumer = random.nextInt(max - min + 1) + min;
        return String.valueOf(randomNumer);
    }
}
