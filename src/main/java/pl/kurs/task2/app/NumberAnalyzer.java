package pl.kurs.task2.app;

import java.util.Arrays;
import java.util.Scanner;

public class NumberAnalyzer {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczby rozdzielone spacją: ");
        String input = scanner.nextLine();
        scanner.close();

        if (input.isBlank()) {
            System.out.println("Podano niewłaściwe dane.");
            return;
        }


        String[] elements = input.trim().split(" ");
        int[] numbers = new int[elements.length];

        for (int i = 0; i < elements.length; i++) { // uzupełnienie tablicy intami
            numbers[i] = Integer.parseInt(elements[i]);
        }

        // System.out.println(Arrays.toString(numbers));

        int primeCounter = 0;
        for (int n : numbers) {
            if (isPrime(n)) primeCounter++;
        }

        System.out.println("Ilość liczb pierwszych: " + primeCounter);

        int topNumberOfDividers = 0; // tu zapiszemy sobie największą liczbe dzielników
        int numberWithMostDividers = 0; // liczba z największa liczbą dzielników
        for (int n : numbers) {
            int d = numberOfDivisors(n);
            if (d > topNumberOfDividers) {
                topNumberOfDividers = d;
                numberWithMostDividers = n;
            }
        }

        System.out.println("Liczba z największą ilością dzielników: " + numberWithMostDividers);

        Arrays.sort(numbers);
        double median;
        if (numbers.length % 2 == 1) { // warunek dla  nieparzystych
            median = numbers[numbers.length / 2];
        } else {
            int middleNumber = numbers.length / 2; // rozwiązanie dla parzystej ilosci liczb
            median = (numbers[middleNumber - 1] + numbers[middleNumber]) / 2;
        }

        System.out.println("Mediana wprowadzonych liczb to: " + median);


    }

    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) { //sprawdzanie liczb pierwszych od 2 do pierwiastek z n wiec dajemy wykonywanie petli i^2<= n
            if (n % i == 0) return false;
        }
        return true;
    }

    public static int numberOfDivisors(int n) {
        int counter = 0;
        for (int i = 1; i < n; i++) { // sprawdzanie liczb od 1 do n
            if (n % i == 0) counter++;
        }
        return counter;
    }


}
