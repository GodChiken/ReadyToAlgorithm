package kbh.com.practice.level2;

import java.util.Arrays;

import static java.util.stream.Collectors.toList;

public class CorrectBracket {
    public static void main(String[] args) {
        System.out.println(solution("()()"));
        System.out.println(solution("(())()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));
        System.out.println(solution("()))((()"));
    }

    private static boolean solution(String bracket) {
        boolean result = false;
        if (bracket.charAt(0) == ')') {
            return result;
        } else {
            String[] bracketStringArray = bracket.split("");
            int leftBracket = Arrays.stream(bracketStringArray)
                    .filter(string -> string.equals("(")).collect(toList()).size();
            int rightBracket = Arrays.stream(bracketStringArray)
                    .filter(string -> string.equals(")")).collect(toList()).size();
            if (leftBracket == rightBracket) {
                int calculate = 0;
                for (int i = 0; i < bracketStringArray.length; i++) {
                    String searchBracket = bracketStringArray[i];

                    if (searchBracket.equals("(")) {
                        calculate++;
                    } else {
                        calculate--;
                    }

                    if (calculate < 0) {
                        result = false;
                        break;
                    } else {
                        result = true;
                    }
                }
            }
            return result;
        }
    }
}
