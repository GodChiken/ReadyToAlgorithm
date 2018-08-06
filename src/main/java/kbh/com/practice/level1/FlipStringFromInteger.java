package kbh.com.practice.level1;

public class FlipStringFromInteger {
    public static void main(String[] args) {
        solution(12345);
    }
    public static int[] solution(long n) {
        int[] answer = {};
        String numString = String.valueOf(n);
        numString = (new StringBuilder(numString)).reverse().toString();
        answer = new int[numString.length()];
        for(int i = 0 ; i < numString.length() ; i++){
            answer[i] = Integer.valueOf(String.valueOf(numString.charAt(i)));
        }
        return answer;
    }
}
