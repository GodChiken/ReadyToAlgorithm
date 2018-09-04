package kbh.com.practice.level2;

public class JadenCaseStringConverter {
    public static void main(String[] args) {
        System.out.println(solution("3people unFollowed me"));
        System.out.println(solution("for the last week"));
    }

    public static String solution(String originalString) {
        boolean isNextUpper = true;
        StringBuffer stringBuffer = new StringBuffer();

        for (int index = 0; index < originalString.length(); index++) {
            char checkCharacter = originalString.charAt(index);
            if (index == 0 || isNextUpper) {
                stringBuffer.append(Character.toUpperCase(checkCharacter));
                isNextUpper = false;
            } else {
                stringBuffer.append(Character.toLowerCase(checkCharacter));
            }
            if (checkCharacter == ' ') {
                isNextUpper = true;
            }
        }
        return stringBuffer.toString();
    }
}
