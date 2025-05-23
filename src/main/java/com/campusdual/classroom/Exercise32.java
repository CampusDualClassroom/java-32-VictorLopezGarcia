package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.io.*;
import java.util.Objects;

public class Exercise32 {

    public static void main(String[] args) {
        String s = "This is a\nmulti-line string.";
        System.out.println("String to save: " + s);
        printToFile(s);
        System.out.println("String saved in file.");
        s=generateStringToSave(null);
        System.out.println("String to save: " + s);
    }

    public static String generateStringToSave(String string) {
        return Objects.requireNonNullElseGet(string, Exercise32::generateUserInputToSave);
    }

    private static String generateUserInputToSave(){
        StringBuilder sb = new StringBuilder();
        System.out.println("Escribe debajo el texto que quieras. Pulsa \"ENTER\" 2 veces seguidas para finalizar:");
        String string;
        while(!(string = Utils.string()).isEmpty()){
            sb.append(string).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public static void printToFile(String string) {
        if (string == null)
            return;
        try {
            File file = new File("src/main/resources/data.txt");
            if(file.getParentFile().mkdirs()){
                System.out.println("Directorio creado: " + file.getParentFile());
            }
            PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            writer.println(string);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + e.getMessage());
        }
    }


}
