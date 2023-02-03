package dev.legaspicary.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;

public class EduChallenge {
    public static void main(String[] args) {
        // sortLinesOfIntsVertically();
        // absDifferenceOfEvenOddCounts();
        // sortByCountOfWord();
        cyclicDependencyCheck();
    }

    // this one only passed 9/10 cases
    public static void cyclicDependencyCheck() {
        // cyclic
        // 1 2 3 4 5
        // 1 5 1 4 7
        // (1,1) (2,5) (3,1) (4,4) (5,7)

        // not cylic
        // 1 2 3 4 5 6
        // 2 3 4 5 6 7
        // (1,2) (2,3) (3,4) (4,5) (5,6) (6,7)

        // cyclic
        // 1 2 3 4 5 6
        // 2 1 5 3 4 9
        // (1,2) (2,1) (3,5) (4,3) (5,4) (6,9)
        // [1] -> 2
        // [2] -> 1
        // [3] -> 5
        // [4] -> 3
        // [5] -> 4
        // [6] -> 9
        // store hash map of dependency
        // store visited tracker for 1 to N+1
        // int nextPoint = 1;
        // for 1 of n
        // if (visitedTracker[nextPoint]) -> return false
        // visitedTracker[nextPoint] = true;
        // nextPoint = dependency.get(nextPoint);
        // return true;

        Scanner in = new Scanner(System.in);
        HashMap<Integer, Integer> entries = new HashMap<>();
        HashMap<Integer, Boolean> tracker = new HashMap<>();

        // get size
        int size = in.nextInt();

        // scan and store
        for (int i = 1; i <= size; i++) {
            int input = in.nextInt();
            entries.put(i, input);
            tracker.put(i, false);
        }

        // run checker algo each only visited once
        int currentNode = 1;

        // probably should have iterated it, but well it's a meager attempt for DFS algo
        while (true) {
            if (tracker.get(currentNode) != null && tracker.get(currentNode)) {
                System.out.println(0);
                return;
            }
            tracker.put(currentNode, true);

            if (entries.get(currentNode) == null) {
                break;
            }
            currentNode = entries.get(currentNode);
        }
        System.out.println(1);
    }

    public static void sortLinesOfIntsVertically() {
        Scanner in = new Scanner(System.in);
        // discard this
        String rowColStr = in.nextLine();

        // for readability
        String firstLineOfIntegers = in.nextLine();
        String secondLineOfIntegers = in.nextLine();

        String allIntegers = firstLineOfIntegers + " " + secondLineOfIntegers;

        // map, sort then print
        Arrays.asList(allIntegers.split(" "))
                .stream()
                .map(Integer::parseInt)
                .sorted((intA, intB) -> {
                    return intB - intA;
                })
                .forEach(System.out::println);
    }

    public static void sortByCountOfWord() {
        Scanner in = new Scanner(System.in);
        // create list
        List<String> strList = new ArrayList<>();

        // get inputs
        int lineCount = in.nextInt();
        // capture newline character after int
        in.nextLine();
        String targetWord = in.nextLine();

        // get words to sort
        for (int i = 0; i < lineCount; i++) {
            String str = in.nextLine();
            strList.add(str);
        }

        strList.sort((strA, strB) -> {
            return countWordInString(targetWord, strA) - countWordInString(targetWord, strB);
        });

        strList.forEach((str) -> {
            System.out.println(str);
        });
    }

    public static int countWordInString(String findWord, String targetString) {
        List<String> wordsList = Arrays.asList(targetString.split(" "));
        return wordsList.stream()
                .filter((word) -> {
                    return word.equals(findWord);
                })
                .toArray().length;
    }

    public static void absDifferenceOfEvenOddCounts() {
        Scanner in = new Scanner(System.in);
        // create list
        List<Integer> numList = new ArrayList<>();

        // scan inputs
        for (int i = 0; i < 10; i++) {
            int num = in.nextInt();
            numList.add(num);
        }

        // count
        int evenCount = 0;
        int oddCount = 0;
        for (int num : numList) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        // output
        System.out.println(Math.abs(evenCount - oddCount));
    }

    public static void sumOfTwo() {
        Scanner in = new Scanner(System.in);

        int firstNum = in.nextInt();
        int secondNum = in.nextInt();

        System.out.println(firstNum + secondNum);
    }
}