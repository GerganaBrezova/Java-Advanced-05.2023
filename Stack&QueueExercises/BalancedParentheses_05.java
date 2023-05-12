package StackAndQueueEx;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Scanner;

public class BalancedParentheses_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Character> stackOpenBrackets = new ArrayDeque<>();

        boolean areBalanced = false;

        String brackets = scanner.nextLine();
        for (char bracket : brackets.toCharArray()) {
            if (bracket == '{' || bracket == '[' || bracket == '(') {
                stackOpenBrackets.push(bracket);
            } else if (bracket == '}' || bracket == ']' || bracket == ')') {
                if (stackOpenBrackets.isEmpty()) {
                    areBalanced = false;
                    break;
                }
                char lastOpenBracket = stackOpenBrackets.pop();
                if (lastOpenBracket == '(' && bracket == ')') {
                    areBalanced = true;
                } else if (lastOpenBracket == '[' && bracket == ']') {
                    areBalanced = true;
                } else if (lastOpenBracket == '{' && bracket == '}') {
                    areBalanced = true;
                } else {
                    areBalanced = false;
                    break;
                }
            }
        }
        if (areBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}

