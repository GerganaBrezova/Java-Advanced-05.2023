package StackAndQueueEx;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stackNumbers = new ArrayDeque<>();

        int commandsCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < commandsCount; i++) {
            int[] commandsArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            switch (commandsArr[0]) {
                case 1:
                    int elementToPush = commandsArr[1];
                    stackNumbers.push(elementToPush);

                    break;
                case 2:
                    if (!stackNumbers.isEmpty()) {
                        stackNumbers.pop();
                    }
                    break;
                case 3:
                    if (stackNumbers.size() > 0) {
                        System.out.println(Collections.max(stackNumbers));
                    }
                    break;
            }
        }
    }
}
