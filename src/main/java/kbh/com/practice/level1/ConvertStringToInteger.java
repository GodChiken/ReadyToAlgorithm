package kbh.com.practice.level1;

public class ConvertStringToInteger {
    public static void main(String[] args) {
        solution("1234");
        solution("-1234");
    }
    public static int solution(String s) {
        return Integer.valueOf(s);
    }
}
