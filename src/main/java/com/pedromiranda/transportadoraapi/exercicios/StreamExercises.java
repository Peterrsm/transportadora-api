package com.pedromiranda.transportadoraapi.exercicios;

import java.util.*;
import java.util.stream.Collectors;

public class StreamExercises {
    public static void runExercise() {
        List<Integer> inteiros = new ArrayList<>();
        inteiros.add(2);
        inteiros.add(5);
        inteiros.add(3);
        inteiros.add(10);

        List<String> strings = new ArrayList<>();
        strings.add("turn");
        strings.add("the");
        strings.add("page");
        strings.add("unforgiven");
        strings.add("fade");

        printLongestString(strings);
    }


    /*
     * Exercise 1
     * Write a program that takes a list of integers as input and prints the sum of all the even numbers in the list using Java Streams.
     */
    public static void sumList(List<Integer> inteiros) {
        int sum = inteiros.stream()
                .mapToInt(num -> num)
                .sum();
        System.out.println(sum);
    }

    /*
     * Exercise 2
     * Write a program that takes a list of strings as input and prints the count of strings whose length is greater than 5 using Java Streams.
     */
    public static void printFive(List<String> textos) {
        textos.stream()
                .filter(item -> item.length() > 5)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    /*
     * Exercise 3
     * Write a program that takes a list of strings as input and prints all the strings in uppercase using Java Streams
     */
    public static void printUpperCase(List<String> textos) {
        textos.stream()
                .map(item -> item.toUpperCase())
                .forEach(System.out::println);
    }

    /*
     * Exercise 4
     * Write a program that takes a list of integers as input and prints the square of each number using Java Streams
     */
    public static void printSquared(List<Integer> inteiros) {
        inteiros.stream()
                .map(num -> Math.sqrt(num))
                .forEach(System.out::println);
    }

    /*
     * Exercise 5
     * Write a program that takes a list of strings as input and prints the concatenation of all the strings using Java Streams.
     */
    public static void printConcat(List<String> inteiros) {
        String s = inteiros.stream()
                .collect(Collectors.joining());

        System.out.println(s);
    }

    /*
     * Exercise 6
     * Write a program that takes a list of integers as input and prints the maximum and minimum values using Java Streams.
     */
    public static void printMaxMin(List<Integer> inteiros) {
        OptionalInt max = inteiros.stream()
                .mapToInt(v -> v)
                .max();

        OptionalInt min = inteiros.stream()
                .mapToInt(v -> v)
                .min();

        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
    }

    /*
     * Exercise 7
     * Write a program that takes a list of strings as input and prints the distinct strings in alphabetical order using Java Streams.
     */
    public static void printAlfaOrder(List<String> strings) {
        strings.stream()
                .sorted()
                .forEach(System.out::println)
        ;
    }

    /*
     * Exercise 8
     * Write a program that takes a list of strings as input and prints the average length of the strings using Java Streams.
     */
    public static void printAverageLength(List<String> strings) {
        OptionalDouble average = strings.stream()
                .mapToInt(item -> item.length())
                .average();

        System.out.println(average);
    }

    /*
     * Exercise 9
     * Write a program that takes a list of integers as input and prints the product of all the numbers using Java Streams.
     */
    public static void printProduct(List<Integer> inteiros) {
        int reduce = inteiros.stream()
                .mapToInt(num -> num)
                .reduce(1, Math::multiplyExact);

        System.out.println(reduce);
    }

    /*
     * Exercise 10
     * Write a program that takes a list of strings as input and prints the longest string using Java Streams.
     */
    public static void printLongestString(List<String> strings) {
        String s = strings.stream()
                .max(Comparator.comparingInt(String::length))
                .get();

        System.out.println(s);
    }
}
