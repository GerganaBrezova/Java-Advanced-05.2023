package StackAndQueueEx;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseNumbersWithAStack_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stackNumbers = new ArrayDeque<>();
        int[] numbersArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < numbersArr.length; i++) {
            stackNumbers.push(numbersArr[i]);
        }
        for (Integer stackNumber : stackNumbers) {
            System.out.printf("%d ", stackNumber);
        }
//      while (!stack.isEmpty()) {
//          System.out.print(stack.pop() + " ");
//      }
    }
}
