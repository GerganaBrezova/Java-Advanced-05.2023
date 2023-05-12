package StackAndQueueEx;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicQueueOperations_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> queueNumbers = new ArrayDeque<>();

        int nElementsToOffer = scanner.nextInt();
        int nElementsToPoll = scanner.nextInt();
        int numberToCheck = scanner.nextInt();

        for (int i = 0; i < nElementsToOffer; i++) {
            queueNumbers.offer(scanner.nextInt());
        }
        for (int i = 0; i < nElementsToPoll; i++) {
            if (!queueNumbers.isEmpty()) {
                queueNumbers.poll();
            }
            if (queueNumbers.isEmpty()) {
                System.out.println(0);
                return;
            }
        }
        if (queueNumbers.contains(numberToCheck)) {
            System.out.println("true");
        } else {
            //System.out.println(Collections.min(queueNumbers));
            int smallestNum = Integer.MAX_VALUE;
            for (Integer stackNumber : queueNumbers) {
                if (stackNumber < smallestNum) {
                    smallestNum = stackNumber;
                }
            }
            System.out.println(smallestNum);
        }
    }
}
