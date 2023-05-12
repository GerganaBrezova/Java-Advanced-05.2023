package StackAndQueueEx;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> textStack = new ArrayDeque<>();
        StringBuilder text = new StringBuilder();

        int commandsCount = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < commandsCount; i++) {
            String[] commandArr = scanner.nextLine().split("\\s+");

            switch (commandArr[0]) {
                case "1":
                    textStack.push(text.toString());
                    String textToAppend = commandArr[1];
                    text.append(textToAppend);

                    break;
                case "2":
                    textStack.push(text.toString());
                    int countTimes = Integer.parseInt(commandArr[1]);
                    text.delete(text.length() - countTimes, text.length());

                    break;
                case "3":
                    int index = Integer.parseInt(commandArr[1]);
                    System.out.printf("%s%n", text.charAt(index - 1));

                    break;
                case "4":
                    if (!textStack.isEmpty()) {
                        text = new StringBuilder(textStack.pop());
                    }
                    break;
            }
        }
    }
}
