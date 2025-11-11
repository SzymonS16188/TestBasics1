package pl.kurs.task3.app;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {

        /// Poproś użytkownika o podanie dwóch macierzy (tablic dwuwymiarowych)
        /// wypisz tablice ktora będzie efektem pomnozenia tych dwoch tablic przez siebie.
        /// (klasyczne mnozenia macierzy)
        /// Uwaga: jesli uzytkownik poda macierze których nie da się pomnożyć należy wypisać komunikat:
        /// "Tych macierzy nie da sie pomnożyć"

        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj liczbe wierszy macierzy A: ");
        int rowA = scanner.nextInt();

        System.out.println("Podaj liczbe kolumn macierzy A: ");
        int columnA = scanner.nextInt();

        System.out.println("Podaj liczbe wierszy macierzy B: ");
        int rowB = scanner.nextInt();

        System.out.println("Podaj liczbe kolumn macierzy B: ");
        int columnB = scanner.nextInt();


        if (columnA != rowB) {
            System.out.println("Tych macierzy nie da sie pomnożyć.");
            return;
        } else if (rowA <= 0 || columnA <= 0 || rowB <= 0 || columnB <= 0) {
            System.out.println("Podano niewłaściwe dane.");
            return;
        }

        int[][] matrixA = new int[rowA][columnA];
        int[][] matrixB = new int[rowB][columnB];
        int[][] resultMatrix = new int[rowA][columnB];

        //Wpisanie danych do Macierzy A
        System.out.println("Podaj dane do uzupełnienia macierzy A: ");
        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < columnA; j++) {
                matrixA[i][j] = scanner.nextInt();
            }
        }

        //Wpisanie danych do Macierzy B
        System.out.println("Podaj dane do uzupełnienia macierzy B: ");
        for (int i = 0; i < rowB; i++) {
            for (int j = 0; j < columnB; j++) {
                matrixB[i][j] = scanner.nextInt();
            }
        }

        //mnozenie macierzy
        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < columnB; j++) {
                int sum = 0;
                for (int k = 0; k < columnA; k++) {
                    sum += matrixA[i][k] * matrixB[k][j];
                }
                resultMatrix[i][j] = sum;
            }
        }

        System.out.println(Arrays.deepToString(resultMatrix));

        for (int i = 0; i < resultMatrix.length; i++) {
            System.out.println(Arrays.toString(resultMatrix[i]));
        }


        scanner.close();
    }


}
