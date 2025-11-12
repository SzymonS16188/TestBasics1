package pl.kurs.task1.app;

import java.util.Locale;
import java.util.Scanner;

public class ArithmeticCalculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj wyrażenie arytmetyczne, liczby i operatory muszą być rozdzeilone spacją: ");
        String input = scanner.nextLine();
        scanner.close();

        if (input.isBlank()) {
            System.out.println("Podano niewłaściwe dane.");
            return;
        }


        String[] elements = input.trim().split(" ");

        if (elements.length < 3 || elements.length % 2 == 0) {
            System.out.println("Podano niewłaściwe dane.");
            return;
        }


        String[] temporary = new String[elements.length];
        int index = 0;
        temporary[index++] = elements[0];

        for (int i = 1; i < elements.length; i += 2) {
            String currentElement = elements[i];
            int a = Integer.parseInt(temporary[index - 1]);
            int b = Integer.parseInt(elements[i + 1]);
            int operationResult;

            if (currentElement.equals("*")) {
                operationResult = a * b;
                temporary[index - 1] = Integer.toString(operationResult);
            } else if (currentElement.equals("/")) {
                if (b == 0) {
                    System.out.println("Podano niewłaściwe dane.");
                    return;
                }
                operationResult = a / b;
                temporary[index - 1] = Integer.toString(operationResult);
            } else {
                temporary[index++] = currentElement;
                temporary[index++] = Integer.toString(b);

            }
        }


        int result = Integer.parseInt(temporary[0]);
        for (int j = 1; j < index; j += 2) {
            String operator = temporary[j];
            int number = Integer.parseInt(temporary[j + 1]);

            if (operator.equals("+")) {
                result += number;
            } else if (operator.equals("-")) {
                result -= number;
            } else {
                System.out.println("Podano niewłaściwe dane.");
                return;
            }
        }

        System.out.println("Result = " + result);


    }

}
