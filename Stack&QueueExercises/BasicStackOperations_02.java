package StackAndQueueEx;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stackNumbers = new ArrayDeque<>();

        int nElementsToPush = scanner.nextInt();
        int nElementsToPop = scanner.nextInt();
        int numberToCheck = scanner.nextInt();

        for (int i = 0; i < nElementsToPush; i++) {
            stackNumbers.push(scanner.nextInt());
        }
        for (int i = 0; i < nElementsToPop; i++) {
            if (!stackNumbers.isEmpty()) {
                stackNumbers.pop();
            }
            if (stackNumbers.isEmpty()) {
                System.out.println(0);
                return;
            }
        }
        if (stackNumbers.contains(numberToCheck)) {
            System.out.println("true");
        } else {
            //System.out.println(Collections.min(stackNumbers));
            int smallestNum = Integer.MAX_VALUE;
            for (Integer stackNumber : stackNumbers) {
                if (stackNumber < smallestNum) {
                    smallestNum = stackNumber;
                }
            }
            System.out.println(smallestNum);
        }
    }
}
