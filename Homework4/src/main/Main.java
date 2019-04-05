/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Scanner;

/**
 *
 * @author USER
 */
public class Main {

    static String H2D = "0123456789ABCDEF";

    /**
     * @param args the command line arguments
     */
    /**
     * Main method
     *
     * @param args
     */
    public static void main(String[] args) {
// Create a Scanner
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(Dec2Hex(n));
        for (int i = 0; i < 2; i++) {
            String s = sc.next();
            try {
                int num = hexToDecimal(s);
                System.out.println(num);
            } catch (MyNumberFormatException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }

    public static int hexToDecimal(String hex) throws MyNumberFormatException {
        int decimalValue = 0;
        for (int i = 0; i < hex.length(); i++) {
            char hexChar = hex.charAt(i);
            if ((hexChar < 'A' || hexChar > 'F') && (hexChar < '0' || hexChar > '9')) {
                throw new MyNumberFormatException("String is no HEX");
            }
            decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
        }
        return decimalValue;
    }

    public static int hexCharToDecimal(char ch) {
        if (ch >= 'A' && ch <= 'F') {
            return 10 + ch - 'A';
        } else // ch is '0', '1', ..., or '9'
        {
            return ch - '0';
        }
    }

    public static String Dec2Hex(int dec) {
        String s = "";
        while (dec > 0) {
            int tmp = dec % 16;
            dec /= 16;
            s = H2D.charAt(tmp) + s;
        }
        return s;
    }
}

class MyNumberFormatException extends Exception {
    MyNumberFormatException(){}
    MyNumberFormatException(String msg){
        super(msg);
    }
}