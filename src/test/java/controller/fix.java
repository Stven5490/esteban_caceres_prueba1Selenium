package controller;

import java.nio.charset.StandardCharsets;

public class fix {
    public static String fixEncoding(String textoIncorrecto){
        byte[] bytes = textoIncorrecto.getBytes(StandardCharsets.ISO_8859_1);
        String textoCorregido = new String(bytes, StandardCharsets.UTF_8);
        return textoCorregido;
    }
}