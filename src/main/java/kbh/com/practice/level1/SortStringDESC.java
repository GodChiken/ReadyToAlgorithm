package kbh.com.practice.level1;

import java.util.Arrays;
import java.util.Collections;

public class SortStringDESC {
    public static void main(String[] args) {
        solution("Zbcdefg");
    }

    public static String solution(String s) {
        String[] splitToArray = s.split("");
        Arrays.sort(splitToArray);
        Collections.reverse(Arrays.asList(splitToArray));
        return String.join("",splitToArray);
    }
}
