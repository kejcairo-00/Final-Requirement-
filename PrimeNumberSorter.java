/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.primenumbersorter;

/**
 *
 * @author Jericho Seriosa
 */
import java.util.*;



public class PrimeNumberSorter {
    public static void main(String[] args) {
        do {
            List<Integer> userInputList = getUserInputs();  // getting some cool user inputs
            List<Integer> primeNumbers = findPrimeNumbers(userInputList);
            sortPrimeNumbersDescending(primeNumbers);  // sorting prime numbers like a boss
            System.out.println("Sorted prime numbers: " + primeNumbers);
            System.out.println("Wanna run it again? (yes/no): ");
        } while (new Scanner(System.in).nextLine().equalsIgnoreCase("yes"));
        System.out.println("Peace out! 🤘");  // exiting the loop, peace out!
    }

    private static List<Integer> getUserInputs() {
        List<Integer> inputList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (inputList.size() < 15) {
            System.out.println("Drop a positive integer: ");
            try {
                int userInput = scanner.nextInt();
                if (userInput < 0) {
                    System.out.println("Bruh, unsigned integers only! Try again.");
                } else {
                    inputList.add(userInput);
                }
            } catch (InputMismatchException e) {
                System.out.println("Bro, that's not a number. Enter a numerical value!");
                scanner.next();
            }
        }
        return inputList;
    }

    private static List<Integer> findPrimeNumbers(List<Integer> inputList) {
        List<Integer> primes = new ArrayList<>();
        for (int inputNumber : inputList) {
            if (isPrime(inputNumber)) {
                primes.add(inputNumber);
            }
        }
        return primes;
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i < Math.sqrt(number) + 1; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void sortPrimeNumbersDescending(List<Integer> primeNumbers) {
        Collections.sort(primeNumbers, Collections.reverseOrder());
    }
}