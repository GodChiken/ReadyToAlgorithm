package kbh.com.practice.level2;

public class SameBitAndNextNumberConverter {
    public static void main(String[] args) {
        solution(78);
        solution(15);
    }
    public static int solution(int number) {
        int bitCount = Integer.bitCount(number);
        while (true) {
            if (bitCount == Integer.bitCount(++number)) {
                break;
            }
        }
        return number;
    }
}
