package com.example.demo.utils;


public class Utils {

    


    public static String validaLetra(String cad){
        String regex = "[0-9]{8}";
        if(!cad.matches(regex))
            return "Error";
        String result="";
        String juegoCaracteres="TRWAGMYFPDXBNJZSQVHLCKE";

        int modulo= Integer.parseInt(cad) % 23;
        
        result += juegoCaracteres.charAt(modulo);

        return result;
    }

    public static int calculaCoincidencias(String cad1, String cad2){
        int result = 0;
        char[] aux1 = cad1.toLowerCase().toCharArray();
        char[] aux2 = cad2.toLowerCase().toCharArray();
        String letrasaux="";
        for(int i=0; i<aux1.length; i++){
            if(letrasaux.contains(Character.toString(aux1[i]))){
                continue;
            }
            for(int j=0; j<aux2.length; j++){
                if(aux1[i]==aux2[j]){
                    result++;
                    break;
                }       
            }
            letrasaux += aux1[i];
        }

        return result;
    }

}
