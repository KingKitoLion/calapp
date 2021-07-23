package com.company;

import java.util.Scanner;

public class Main {
    private static boolean arabic_numbers = true;

    private static String[] pars(String input) {
        String[] parsed_input = input.split(" ");
        if (parsed_input.length != 3) {
            Scanner input_value = new Scanner(System.in);
            System.out.println("Neverny format vvoda dannyh. vvidite vyrazhenie, razdelyy kazhdy simvol probelom");
            input = input_value.nextLine();
            return pars(input);
        } else {
            return parsed_input;
        }
    }



    public static void main(String[] args) {

        Scanner input_a_value = new Scanner(System.in);
        System.out.print("VVedite vyrazhenie: ");
        String input = input_a_value.nextLine();
        while (!input.isEmpty()) {
            String[] parsed_input = Main.pars(input);
            String operation = parsed_input[1];
            Number values;
            int value1 = 0;
            int value2 = 0;
            // Perevodim v int. Esli vvedeny rimskie, vvedet iskluchenie
            try {
                value1 = Integer.parseInt(parsed_input[0]);
                value2 = Integer.parseInt(parsed_input[2]);

            } catch (NumberFormatException e) {
                arabic_numbers = false;
                System.out.println("vvedenie rimskie cifry");
            }

            if (arabic_numbers) {
                values = new Arabic(value1, value2);
            } else {
                values = new Romes(parsed_input[0], parsed_input[2]);
            }

            if (operation.equals("+")) {
                values.sum();
            } else if (operation.equals("-")) {
                values.sub();
            } else if (operation.equals("/") || operation.equals(":")) {
                values.div();
            } else if (operation.equals("*") || operation.equals("x")) {
                values.mul();
            }

            if (arabic_numbers) {
                System.out.println("Otvet: " + values.getResult());
            } else {
                System.out.println("Otvet: " + values.getStringResult());
            }
            System.out.println();
            System.out.print("VVedyte sledushee vyrozhenie: ");
            input = input_a_value.nextLine();
        }
        System.out.println("Rabota zavershina!");

    }
}
